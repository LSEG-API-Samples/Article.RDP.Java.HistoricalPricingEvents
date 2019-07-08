package com.java;

import java.util.HashMap;
import java.util.Vector;
import java.util.Iterator;
import java.util.LinkedHashMap;
//Jackson
import com.fasterxml.jackson.annotation.*;
//The following fields/properies in historical pricing event are ignored
@JsonIgnoreProperties(value = {
	    "universe",
	    "adjustments",
	    "defaultPricingField",
	    "qos",
	    "meta",
	    "status",
	    "summaryTimestampLabel",
	    "interval"
	})

public class HistoricalPricingEventsData {
	//the map keeping name and type of all fields
	private LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
	//the vector keeping the data of all events
	private Vector<Vector<Object>> dataJson = new Vector<Vector<Object>>();
	//deserialize headers fields into the map
    @JsonProperty("headers")
	private void unpackMultipleJsonObjects(Vector<HashMap<String, Object>> headersJson) {
    	Iterator<HashMap<String, Object>> fieldList = headersJson.iterator(); 
    	while (fieldList.hasNext()) { 
    		HashMap<String, Object> afield = (HashMap<String, Object>)fieldList.next();
            headers.put(afield.get("name").toString(), afield.get("type").toString());
        } 
	}
  //get deserialized headers map
    public LinkedHashMap<String, String> getHeaders() {
    	return headers;
    }
    //deserialize all events in data field into a vector of vector
  	//return the vector
    @JsonProperty("data")
    public Vector<Vector<Object>>  getData() {
    	return dataJson;
    }
    
}
