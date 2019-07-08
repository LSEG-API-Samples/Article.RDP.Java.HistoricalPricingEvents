package com.java;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.LinkedHashSet;
//Commons CLI 
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
//Apache Http Components
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
//JSON in java 
import org.json.JSONObject;
//Jackson
import com.fasterxml.jackson.databind.*;

public class HistoricalPricingEventsRequestor {
		
		//The info to request token
		private static String username;
		private static String clientId;
	    //for making request via REST API
		private static HttpClient httpclient;
		 private static SSLConnectionSocketFactory sslsf;
		//Parameters
		private static LinkedHashSet<String> ricsSet;
	    private static LinkedHashSet<String> eventsSet;
	    private static String startDateTime;
	    private static String endDateTime;
	    private static LinkedHashSet<String> adjustmentsSet;
	    private static String count;
	    private static boolean singleEvent;
	    //The version of Historical Pricing Events specified in the end point REST API
	    private static String HISTORICAL_PRICING_VERSION = "v1";
	    //The data file name of a RIC
	    private static String outputFileName;

	    public static void getProgramArguments(String[] args) {
	   	 	Options options	 = new Options();
			try {
				//add Options for each program argument
				Option userOption = Option.builder("user").hasArg(true).argName("USERNAME").required(true).desc("The resource owner username (typically email).").build();
				options.addOption(userOption);
				Option clientIdOption = Option.builder("clientId").hasArg(true).argName("CLIENT_ID").required(true).desc("A unique ID defined for an application making the request.").build();
				options.addOption(clientIdOption);
				Option ricsOption = Option.builder("rics").hasArg(true).argName("LIST_RICS").required(true).desc("The list of RICs separated by ','").build();
				options.addOption(ricsOption);
				Option eventTypesOption = Option.builder("events").hasArg(true).argName("EVENT_TYPES").required(false).desc("a selection of comma separated market event types: trade,quote,correction").build();
				options.addOption(eventTypesOption);
				Option startOption = Option.builder("start").hasArg(true).argName("START_DATE_TIME").required(false).desc("start date time for the range of desired data in ISO 8601 e.g. 2019-01-01T00:00:00.000000000Z").build();
				options.addOption(startOption);
				Option endOption = Option.builder("end").hasArg(true).argName("END_DATE_TIME").required(false).desc("end date time for the range of desired data in ISO 8601 e.g. 2019-01-31T23:59:59.999999999Z").build();
				options.addOption(endOption);
				Option adjustmentsOption = Option.builder("adjustments").hasArg(true).argName("ADJUSTMENT_TYPES").required(false).desc("a selection of comma separated adjustment types for corrections and corporate actions. The possible values are exchangeCorrection,manualCorrection,CCH,CRE,RTS,RPO,unadjusted,qualifiers").build();
				options.addOption(adjustmentsOption);
				Option countOption = Option.builder("count").hasArg(true).argName("COUNT").required(false).desc("limit the maximum number of data points that will be returned (this does not apply to the historical pricing single-event call).").build();
				options.addOption(countOption);
				Option singleOption = Option.builder("single").hasArg(false).required(false).desc("Request the historical pricing single-event.").build();
				options.addOption(singleOption);
				CommandLineParser parser = new DefaultParser();
				//Get program arguments according to the Options 
				CommandLine cmd = parser.parse( options, args);
				//Set each argument to each variable 
				username = cmd.getOptionValue("user");
				clientId = cmd.getOptionValue("clientId");
				ricsSet =  new LinkedHashSet<String>(Arrays.asList(cmd.getOptionValue("rics").split(","))); 
				if(cmd.hasOption("events")) {
					eventsSet =  new LinkedHashSet<String>(Arrays.asList(cmd.getOptionValue("events").split(","))); 
				}
				startDateTime = cmd.getOptionValue("start");
				endDateTime = cmd.getOptionValue("end");
				if(cmd.hasOption("adjustments")) {
					adjustmentsSet =  new LinkedHashSet<String>(Arrays.asList(cmd.getOptionValue("adjustments").split(","))); 
				}
				count = cmd.getOptionValue("count");
				singleEvent = cmd.hasOption("single");
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "HistoricalPricingEventsRequestor", options );
				System.exit(0);
			}
	    }

	    public static void requestHistoricalEvent(String aRIC, String url, String access_token) throws Exception{
	    	//Request data
	    	HttpGet httpreq = new HttpGet(url);
			httpreq.addHeader("Authorization","Bearer "+access_token);
			System.out.println("\nRequested URI is :\n"+httpreq.getURI());
			HttpResponse historicalPriceres = httpclient.execute(httpreq);
			//Check if getting data successfully or not. If fails, print error then exit from the method
			if(!Utils.isSuccessRequestPrnError(historicalPriceres, "Request data failed:")) 
				return;
			//Remove '[' and ']' from the message
			String rawJsonMsg = EntityUtils.toString(historicalPriceres.getEntity());
			String rawJsonTmp = rawJsonMsg.substring(1);
			String rawJson = rawJsonTmp.substring(0, rawJsonTmp.length() - 1);
			//The response contains data and status means request is successful but may have the warning
			//The response contains status only is request failed e.g. RIC is not found so exit from the method
			if(rawJson.contains("\"status\"") && !rawJson.contains("\"data\"") ) {
				JSONObject json = new JSONObject(rawJson);
				System.out.println("Request data failed:");
				System.out.println(json.toString(4));
				return;
			}
			
			System.out.println("Request is processed successfully.");
			//Deserialize JSON content into HistoricalPricingEventsData class using Jackson library
			HistoricalPricingEventsData eventsData = new ObjectMapper()
					      .readerFor(HistoricalPricingEventsData.class)
					      .readValue(rawJson);
			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			//Get data field
			data = eventsData.getData();
			//If there is no data, exit from the method.
			if(data.size()==0) {
				System.out.println("No data is found according to the request.");
				return;
			}
			LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
			//Get fields' definition 
			headers = eventsData.getHeaders();
			//To create all lines written in a csv file
			//The variable to keep all field names
			StringBuffer sbName = new StringBuffer();
			//The variable to keep all field types
			StringBuffer sbType = new StringBuffer();
			//Each fields' definition
			for (String fieldName: headers.keySet()){ 
				//Add each field name following by "," to a String 
				sbName.append(fieldName).append(",");
				//Add each field type following by "," to a String 
				sbType.append(headers.get(fieldName)).append(",");
			}
			//remove "," after the last field name
			String fieldNameRow = sbName.substring(0, sbName.length() - 1);
			//remove "," after the last field type
			String fieldTypeRow = sbType.substring(0, sbType.length() - 1);
			Vector<String> lines = new Vector<String>();
			//add the field name row and the field type row into the vector
			lines.add(fieldNameRow);
			lines.add(fieldTypeRow);
			Iterator<Vector<Object>>  eventsIterator = data.iterator();
			StringBuffer sbData = new StringBuffer();
			//For each event in the data field
			while (eventsIterator.hasNext()) { 
		    	Vector<Object> anEvent = eventsIterator.next();
		    	Iterator<Object> aValueIterator = anEvent.iterator(); 
		    	//Add each field value(data) in the event into a String 
		    	while (aValueIterator.hasNext()) { 
		    		sbData.append(aValueIterator.next()).append(",");
		        } 
		    	//remove "," after the last field value
				String aData = sbData.substring(0, sbData.length() - 1);
				//Add the String containing all field values of an event 
		    	lines.add(aData);
		    	//clear StringBuffer keeping data for the next event
		    	sbData.setLength(0);
			}
			//Create the name of the file which contains the RIC and current date time
			String currentDataTime = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
			outputFileName =  System.getProperty("user.dir") + File.separator + aRIC + "_" + currentDataTime;
			//Write all events of a RIC into a file. The first line is the list of field names.
			//The second line is the list of field types, the other lines are data
			boolean success = Utils.writeAFile(outputFileName + ".csv",lines);
			System.out.println(((success==true)?"Success":"Fail") + " writting data to the file - " +  outputFileName + ".csv");	 
	    }
	    
	    //Get a token using EDPToken class
	    public static String getAccessToken() throws Exception{
	    	sslsf = new SSLConnectionSocketFactory(new SSLContextBuilder().build());
	    	httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
	    	return EDPToken.getToken(httpclient, username, clientId);
	    }
	    
		public static void main(String[] args) {
			//Get program arguments
			getProgramArguments(args);
			try {
				//get an access token  
				String access_token = getAccessToken();
				
				StringBuffer url = new StringBuffer("https://api.refinitiv.com/data/historical-pricing/"+HISTORICAL_PRICING_VERSION+ "/views/");
				//set the end point 
				if(!singleEvent) 
					//for historical pricing events data
					url.append("events/");
				else
					//for a latest historical pricing event data
					url.append("single-event/");
				//Create the parameters url according to the input arguments
				String paramReq = createParam();
				StringBuffer urlReq = new StringBuffer("");
				Iterator<String> iteratorRics = ricsSet.iterator();
				String aRIC;
				//for each RIC
				while(iteratorRics.hasNext()){
					aRIC = iteratorRics.next();
					urlReq.setLength(0);
					urlReq.append(url.toString());
					//Add the RIC to url
					urlReq.append(aRIC);
					//If there are parameters, add them to url 
					if(paramReq.length()>0)
						urlReq.append(paramReq);
					//request data of the RIC based on URL and with access token
					requestHistoricalEvent(aRIC,urlReq.toString(), access_token);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//Create the parameters url 
		public static String createParam() {
			StringBuffer paramsReqSb = new StringBuffer("");
			if(eventsSet!=null) {
				paramsReqSb.append("?eventTypes=");
				Iterator<String> iteratorEvents =eventsSet.iterator();
				while(iteratorEvents.hasNext()) 
					paramsReqSb.append(iteratorEvents.next()).append(",");
				paramsReqSb.deleteCharAt(paramsReqSb.length()-1);
			}	
			if(startDateTime!=null) {
				if(paramsReqSb.toString().contains("?"))
					paramsReqSb.append("&");
				else
					paramsReqSb.append("?");
				paramsReqSb.append("start=" + startDateTime);
			}
			if(endDateTime!=null) {
				if(paramsReqSb.toString().contains("?"))
					paramsReqSb.append("&");
				else
					paramsReqSb.append("?");
				paramsReqSb.append("end=" + endDateTime);
			}
			if(adjustmentsSet!=null) {
				if(paramsReqSb.toString().contains("?"))
					paramsReqSb.append("&");
				else
					paramsReqSb.append("?");
				paramsReqSb.append("adjustments=");
				Iterator<String> iteratorAdjustments =adjustmentsSet.iterator();
				while(iteratorAdjustments.hasNext()) 
					paramsReqSb.append(iteratorAdjustments.next()).append(",");
				paramsReqSb.deleteCharAt(paramsReqSb.length()-1);
			}	
			if(count!=null) {
				if(paramsReqSb.toString().contains("?"))
					paramsReqSb.append("&");
				else
					paramsReqSb.append("?");
				paramsReqSb.append("count=" + count);
			}
			return paramsReqSb.toString();
		}

}

