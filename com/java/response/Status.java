
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
 * Message status object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "message"
})
@Generated("jsonschema2pojo")
public class Status {

    /**
     * Status code
     * <p>
     * An application-specific status code, expressed as a string value
     * (Required)
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("An application-specific status code, expressed as a string value")
    private String code;
    /**
     * Status message
     * <p>
     * A human-readable explanation/reason specific to this occurrence of the problem. This field's value can be localized.
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("A human-readable explanation/reason specific to this occurrence of the problem. This field's value can be localized.")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Status code
     * <p>
     * An application-specific status code, expressed as a string value
     * (Required)
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * Status code
     * <p>
     * An application-specific status code, expressed as a string value
     * (Required)
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Status message
     * <p>
     * A human-readable explanation/reason specific to this occurrence of the problem. This field's value can be localized.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Status message
     * <p>
     * A human-readable explanation/reason specific to this occurrence of the problem. This field's value can be localized.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
