
package com.java.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * The quality of service of the user for a given RIC universe for the delayed users. The back-end will only return qos (QoS Delayed) for delayed  users no matter whether the query range [start,end) is within the exchange embargo period (e.g. 15 minute delay) or not. The data in the response may or may not be truncated due to the exchange embargo period.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timeliness"
})
@Generated("jsonschema2pojo")
public class Qos {

    /**
     * Timeliness information
     * (Required)
     * 
     */
    @JsonProperty("timeliness")
    @JsonPropertyDescription("Timeliness information")
    private Qos.Timeliness timeliness;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Timeliness information
     * (Required)
     * 
     */
    @JsonProperty("timeliness")
    public Qos.Timeliness getTimeliness() {
        return timeliness;
    }

    /**
     * Timeliness information
     * (Required)
     * 
     */
    @JsonProperty("timeliness")
    public void setTimeliness(Qos.Timeliness timeliness) {
        this.timeliness = timeliness;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    /**
     * Timeliness information
     * 
     */
    @Generated("jsonschema2pojo")
    public enum Timeliness {

        DELAYED("delayed");
        private final String value;
        private final static Map<String, Qos.Timeliness> CONSTANTS = new HashMap<String, Qos.Timeliness>();

        static {
            for (Qos.Timeliness c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Timeliness(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Qos.Timeliness fromValue(String value) {
            Qos.Timeliness constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
