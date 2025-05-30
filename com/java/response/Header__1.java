
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "decimalChar",
    "isEnum",
    "name",
    "type"
})
@Generated("jsonschema2pojo")
public class Header__1 {

    /**
     * The decimal character used for decimal number.
     * 
     */
    @JsonProperty("decimalChar")
    @JsonPropertyDescription("The decimal character used for decimal number.")
    private String decimalChar;
    /**
     * The boolean indicates an enumerated field.
     * 
     */
    @JsonProperty("isEnum")
    @JsonPropertyDescription("The boolean indicates an enumerated field.")
    private Boolean isEnum;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * Json data type i.e. string, number.
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Json data type i.e. string, number.")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * The decimal character used for decimal number.
     * 
     */
    @JsonProperty("decimalChar")
    public String getDecimalChar() {
        return decimalChar;
    }

    /**
     * The decimal character used for decimal number.
     * 
     */
    @JsonProperty("decimalChar")
    public void setDecimalChar(String decimalChar) {
        this.decimalChar = decimalChar;
    }

    /**
     * The boolean indicates an enumerated field.
     * 
     */
    @JsonProperty("isEnum")
    public Boolean getIsEnum() {
        return isEnum;
    }

    /**
     * The boolean indicates an enumerated field.
     * 
     */
    @JsonProperty("isEnum")
    public void setIsEnum(Boolean isEnum) {
        this.isEnum = isEnum;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Json data type i.e. string, number.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Json data type i.e. string, number.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
