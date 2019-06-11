package com.java;

import java.util.HashMap;
import java.util.Vector;
import java.util.Iterator;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.*;
@JsonIgnoreProperties(value = {
	    "universe",
	    "adjustments",
	    "defaultPricingField",
	    "qos",
	    "meta",
	    "status"
	})

public class HistoricalPricingEventsData {
	//the map of name and type of each field
	private LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
	//data - the list of fields' value
	private Vector<Vector<Object>> dataJson = new Vector<Vector<Object>>();
	
    @JsonProperty("headers")
	private void unpackMultipleJsonObjects(Vector<HashMap<String, Object>> headersJson) {
    	Iterator<HashMap<String, Object>> fieldList = headersJson.iterator(); 
    	while (fieldList.hasNext()) { 
    		HashMap<String, Object> afield = (HashMap<String, Object>)fieldList.next();
            headers.put(afield.get("name").toString(), afield.get("type").toString());
        } 
	}
    public LinkedHashMap<String, String> getHeaders() {
    	return headers;
    }
    @JsonProperty("data")
    public Vector<Vector<Object>>  getData() {
    	return dataJson;
    }
    
    
    
}
