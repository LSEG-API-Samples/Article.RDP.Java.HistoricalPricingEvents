package com.java;

import java.util.Vector;
import java.util.Iterator;
import java.util.LinkedHashMap;
//Jackson
import com.fasterxml.jackson.annotation.*;
//The following fields/properties in historical pricing event are ignored
@JsonIgnoreProperties(value = {
	    "universe",
	    "adjustments",
	    "defaultPricingField",
	    "qos",
	    "meta",
	    "status",
	    "summaryTimestampLabel"
	})

public class HistoricalPricingEventsData {
	//the map keeps all "name" and "type" got from JSON objects in the "headers" field
	private LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
	//the vector keeps the array of all data events in the "data" field 
	private Vector<Vector<Object>> dataJson = new Vector<Vector<Object>>();
	//Add only all "name" and "type" got from JSON objects in the "headers" field into the map
	//key is "name" and the value is "type"
	@JsonProperty("headers")
	private void unpackMultipleJsonObjects(Vector<LinkedHashMap<String, Object>> headersJson) {
    	Iterator<LinkedHashMap<String, Object>> fieldList = headersJson.iterator(); 
    	while (fieldList.hasNext()) { 
    		LinkedHashMap<String, Object> afield = (LinkedHashMap<String, Object>)fieldList.next();
            headers.put(afield.get("name").toString(), afield.get("type").toString());
        } 
	}
	//Get headers which is the map of "name" and "type"
    public LinkedHashMap<String, String> getHeaders() {
    	return headers;
    }
    //Map the array of all data events from the "data" field to vector of vector
    //internal vector keeps all values of an event e.g. "2019-07-08T02:55:01.303000000Z","trade",62094,...
    //external vector keeps all events
    //Return the vector of data events 
    @JsonProperty("data")
    public Vector<Vector<Object>>  getData() {
    	return dataJson;
    }
    
}
