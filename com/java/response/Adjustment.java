
package com.java.response;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Generated("jsonschema2pojo")
public enum Adjustment {

    EXCHANGE_CORRECTION("exchangeCorrection"),
    MANUAL_CORRECTION("manualCorrection"),
    CCH("CCH"),
    CRE("CRE"),
    RPO("RPO"),
    RTS("RTS"),
    UNADJUSTED("unadjusted"),
    QUALIFIERS("qualifiers");
    private final String value;
    private final static Map<String, Adjustment> CONSTANTS = new HashMap<String, Adjustment>();

    static {
        for (Adjustment c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    Adjustment(String value) {
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
    public static Adjustment fromValue(String value) {
        Adjustment constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
