package com.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class EDPToken {
	private static String TOKEN_FILE_NAME = "token.txt";
	private static HttpClient _hc;
	private static String _refresh_token;
	private static String _access_token;
	private static String _username;
	private static String _password;
	private static String _client_id;
	
	public static String getToken(HttpClient hc, String username, String clientId)  {
		
		_hc = hc;
		_username = username;
		 _client_id = clientId;
		 List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		try {
			File tokenFile = new File(TOKEN_FILE_NAME);
			if(!tokenFile.exists()) {
				if(_password==null)
					_password = new String(System.console().readPassword("Enter your password:"));
				params.add(new BasicNameValuePair("username", _username));
				params.add(new BasicNameValuePair("password", _password));
				params.add(new BasicNameValuePair("client_id", _client_id));
				params.add(new BasicNameValuePair("grant_type", "password"));
				params.add(new BasicNameValuePair("scope", "trapi"));
				params.add(new BasicNameValuePair("takeExclusiveSignOnControl", "true"));
				return requestToken(params, false);
			}
			else { //read info from file
				return readTokenFile();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return _access_token;
	}
	private static String requestToken(List<NameValuePair> params, boolean useRefreshToken) throws Exception {
		String EDP_VERSION_AUTH = "beta1";
		String url = "https://api.refinitiv.com/auth/oauth2/" +EDP_VERSION_AUTH+ "/token";
		HttpPost httplogin = new HttpPost(url);
		httplogin.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
	
		//Execute and get the response.
		HttpResponse loginResponse = _hc.execute(httplogin);
		if(!Utils.isSuccessRequestPrnError(loginResponse, "Login fails:")) {
			if(!useRefreshToken)
				System.exit(-1);
			else {//try again with password in case of refresh_token expires
				System.out.println("Request token using refresh_token failed. Try again using password");
				if(_password==null)
					_password = new String(System.console().readPassword("Enter your password:"));
				params.add(new BasicNameValuePair("username", _username));
				params.add(new BasicNameValuePair("password", _password));
				params.add(new BasicNameValuePair("client_id", _client_id));
				params.add(new BasicNameValuePair("grant_type", "password"));
				params.add(new BasicNameValuePair("scope", "trapi"));
				params.add(new BasicNameValuePair("takeExclusiveSignOnControl", "true"));
				return requestToken(params, false);
			}
		} 
		
		String loginResponseStr = EntityUtils.toString(loginResponse.getEntity());
		JSONObject loginJson = new JSONObject(loginResponseStr);
		int expires_in = Integer.parseInt(loginJson.getString("expires_in"));
		long expiry_tm = System.currentTimeMillis() + (expires_in*1000) - (60*1000);	
		loginJson.put("expiry_tm", expiry_tm);
		_access_token = loginJson.getString("access_token");
		_refresh_token = loginJson.getString("refresh_token");
		System.out.println("login is successful. Writing token info to a file named " + TOKEN_FILE_NAME);
		//write a token file
		boolean success = Utils.writeAFile(TOKEN_FILE_NAME,loginJson.toString(4));
		System.out.println(((success==true)?"Success":"Fail") + " writting " +  TOKEN_FILE_NAME);
		if(!success)
			System.exit(-1);
		return _access_token;
	}
	private static String readTokenFile() {
		try {            
            BufferedReader br =   new BufferedReader(new FileReader(TOKEN_FILE_NAME));
            String aline; 
            StringBuffer sb = new StringBuffer();
            while ((aline = br.readLine()) != null) {
              sb.append(aline); 
            } 
            br.close();
            JSONObject tokenJson = new JSONObject(sb.toString());
            _refresh_token = tokenJson.getString("refresh_token");
            
            if(tokenJson.getLong("expiry_tm") > System.currentTimeMillis()) {
    			System.out.println("The token has not expired, use the token in the file.");
    			 _access_token = tokenJson.getString("access_token");
    			
    		} else {
    			System.out.println("Token is expired, request a new token using refresh_token ...");
    			List<NameValuePair> params = new ArrayList<NameValuePair>(2);
    			params.add(new BasicNameValuePair("username", _username));
    			params.add(new BasicNameValuePair("refresh_token", _refresh_token));
    			params.add(new BasicNameValuePair("grant_type", "refresh_token"));
    			params.add(new BasicNameValuePair("client_id", _client_id));
    			params.add(new BasicNameValuePair("takeExclusiveSignOnControl", "true"));
    			_access_token = requestToken(params, true);
    		}
        }
        catch(Exception e) {
        	e.printStackTrace();
        	System.exit(-1);
        }
		return _access_token;
    }
	
}
