
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
    "approximateCount",
    "chunkDuration",
    "chunkStart",
    "href"
})
@Generated("jsonschema2pojo")
public class Chunk {

    /**
     * The approximate count of the chunk data
     * (Required)
     * 
     */
    @JsonProperty("approximateCount")
    @JsonPropertyDescription("The approximate count of the chunk data")
    private Double approximateCount;
    /**
     * The duration of the chunk data start from the chunkStart in ISO8601 e.g. PT78H22M
     * (Required)
     * 
     */
    @JsonProperty("chunkDuration")
    @JsonPropertyDescription("The duration of the chunk data start from the chunkStart in ISO8601 e.g. PT78H22M")
    private String chunkDuration;
    /**
     * The start date and timestamp of the chunk data in ISO8601 with UTC only e.g. 2021-01-17T17:38:00.000000000Z
     * (Required)
     * 
     */
    @JsonProperty("chunkStart")
    @JsonPropertyDescription("The start date and timestamp of the chunk data in ISO8601 with UTC only e.g. 2021-01-17T17:38:00.000000000Z")
    private String chunkStart;
    /**
     * The url for requesting the chunk data
     * (Required)
     * 
     */
    @JsonProperty("href")
    @JsonPropertyDescription("The url for requesting the chunk data")
    private String href;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * The approximate count of the chunk data
     * (Required)
     * 
     */
    @JsonProperty("approximateCount")
    public Double getApproximateCount() {
        return approximateCount;
    }

    /**
     * The approximate count of the chunk data
     * (Required)
     * 
     */
    @JsonProperty("approximateCount")
    public void setApproximateCount(Double approximateCount) {
        this.approximateCount = approximateCount;
    }

    /**
     * The duration of the chunk data start from the chunkStart in ISO8601 e.g. PT78H22M
     * (Required)
     * 
     */
    @JsonProperty("chunkDuration")
    public String getChunkDuration() {
        return chunkDuration;
    }

    /**
     * The duration of the chunk data start from the chunkStart in ISO8601 e.g. PT78H22M
     * (Required)
     * 
     */
    @JsonProperty("chunkDuration")
    public void setChunkDuration(String chunkDuration) {
        this.chunkDuration = chunkDuration;
    }

    /**
     * The start date and timestamp of the chunk data in ISO8601 with UTC only e.g. 2021-01-17T17:38:00.000000000Z
     * (Required)
     * 
     */
    @JsonProperty("chunkStart")
    public String getChunkStart() {
        return chunkStart;
    }

    /**
     * The start date and timestamp of the chunk data in ISO8601 with UTC only e.g. 2021-01-17T17:38:00.000000000Z
     * (Required)
     * 
     */
    @JsonProperty("chunkStart")
    public void setChunkStart(String chunkStart) {
        this.chunkStart = chunkStart;
    }

    /**
     * The url for requesting the chunk data
     * (Required)
     * 
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * The url for requesting the chunk data
     * (Required)
     * 
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
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
