
package com.java.response;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "headers"
})
@Generated("jsonschema2pojo")
public class BlendingEntry {

    @JsonProperty("data")
    private List<List<Object>> data;
    @JsonProperty("headers")
    private List<Header__1> headers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("data")
    public List<List<Object>> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<List<Object>> data) {
        this.data = data;
    }

    @JsonProperty("headers")
    public List<Header__1> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(List<Header__1> headers) {
        this.headers = headers;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
