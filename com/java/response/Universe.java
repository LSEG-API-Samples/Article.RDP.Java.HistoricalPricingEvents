
package com.java.response;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The entity universe may contain RIC or PermID depending on your request
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "permId",
    "ric"
})
@Generated("jsonschema2pojo")
public class Universe {

    /**
     * Refinitiv Permanent Identifiers
     * 
     */
    @JsonProperty("permId")
    @JsonPropertyDescription("Refinitiv Permanent Identifiers")
    private String permId;
    @JsonProperty("ric")
    private String ric;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Refinitiv Permanent Identifiers
     * 
     */
    @JsonProperty("permId")
    public String getPermId() {
        return permId;
    }

    /**
     * Refinitiv Permanent Identifiers
     * 
     */
    @JsonProperty("permId")
    public void setPermId(String permId) {
        this.permId = permId;
    }

    @JsonProperty("ric")
    public String getRic() {
        return ric;
    }

    @JsonProperty("ric")
    public void setRic(String ric) {
        this.ric = ric;
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
