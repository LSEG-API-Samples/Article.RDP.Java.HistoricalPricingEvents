
package com.java.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adjustments",
    "chunks",
    "data",
    "defaultPricingField",
    "headers",
    "interval",
    "meta",
    "qos",
    "status",
    "summaryTimestampLabel",
    "universe"
})
@Generated("jsonschema2pojo")
public class HistoricalPricingEvent {

    /**
     * The list of adjustments types (comma delimiter) which the back-end applied to the returned historical time series data.
     * The supported values of adjustments
     * * exchangeCorrection - Apply exchange correction adjustment to historical pricing
     * * manualCorrection - Apply manual correction adjustment to historical pricing i.e. annotations made by content analysts
     * * CCH - Apply Capital Change adjustment to historical Pricing due to Corporate Actions e.g. stock split
     * * CRE - Apply Currency Redenomination adjustment when there is redenomination of currency
     * * RPO - Apply Refinitiv Price Only adjustment to adjust historical price only not volume
     * * RTS - Apply Refinitiv TimeSeries adjustment to adjust both historical price and volume
     * * unadjusted - Not apply both exchange/manual corrections and CORAX
     * * qualifiers - Apply price or volume adjustment to historical pricing according to trade/quote qualifier summarization actions e.g. noPrice, noVolume, noPriceAndVolume, noBid, noAsk, noBidAndAsk, outOfSequenceIntraday, outOfSequenceInterday. This adjustment is for events data only.
     * 
     * 
     */
    @JsonProperty("adjustments")
    @JsonPropertyDescription("The list of adjustments types (comma delimiter) which the back-end applied to the returned historical time series data.\nThe supported values of adjustments\n* exchangeCorrection - Apply exchange correction adjustment to historical pricing\n* manualCorrection - Apply manual correction adjustment to historical pricing i.e. annotations made by content analysts\n* CCH - Apply Capital Change adjustment to historical Pricing due to Corporate Actions e.g. stock split\n* CRE - Apply Currency Redenomination adjustment when there is redenomination of currency\n* RPO - Apply Refinitiv Price Only adjustment to adjust historical price only not volume\n* RTS - Apply Refinitiv TimeSeries adjustment to adjust both historical price and volume\n* unadjusted - Not apply both exchange/manual corrections and CORAX\n* qualifiers - Apply price or volume adjustment to historical pricing according to trade/quote qualifier summarization actions e.g. noPrice, noVolume, noPriceAndVolume, noBid, noAsk, noBidAndAsk, outOfSequenceIntraday, outOfSequenceInterday. This adjustment is for events data only.\n")
    private List<Adjustment> adjustments;
    /**
     * The chunk list to request chunk data
     * 
     */
    @JsonProperty("chunks")
    @JsonPropertyDescription("The chunk list to request chunk data")
    private List<Chunk> chunks;
    @JsonProperty("data")
    private List<List<Object>> data;
    @JsonProperty("defaultPricingField")
    private String defaultPricingField;
    /**
     * The headers section of tabular respose
     * 
     */
    @JsonProperty("headers")
    @JsonPropertyDescription("The headers section of tabular respose")
    private List<Header> headers;
    /**
     * The consolidation interval for summaries data only.
     * 
     */
    @JsonProperty("interval")
    @JsonPropertyDescription("The consolidation interval for summaries data only.")
    private String interval;
    @JsonProperty("meta")
    private Meta meta;
    /**
     * The quality of service of the user for a given RIC universe for the delayed users. The back-end will only return qos (QoS Delayed) for delayed  users no matter whether the query range [start,end) is within the exchange embargo period (e.g. 15 minute delay) or not. The data in the response may or may not be truncated due to the exchange embargo period.
     * 
     */
    @JsonProperty("qos")
    @JsonPropertyDescription("The quality of service of the user for a given RIC universe for the delayed users. The back-end will only return qos (QoS Delayed) for delayed  users no matter whether the query range [start,end) is within the exchange embargo period (e.g. 15 minute delay) or not. The data in the response may or may not be truncated due to the exchange embargo period.")
    private Qos qos;
    /**
     * Message status object
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Message status object")
    private Status status;
    @JsonProperty("summaryTimestampLabel")
    private HistoricalPricingEvent.SummaryTimestampLabel summaryTimestampLabel;
    /**
     * The entity universe may contain RIC or PermID depending on your request
     * (Required)
     * 
     */
    @JsonProperty("universe")
    @JsonPropertyDescription("The entity universe may contain RIC or PermID depending on your request")
    private Universe universe;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * The list of adjustments types (comma delimiter) which the back-end applied to the returned historical time series data.
     * The supported values of adjustments
     * * exchangeCorrection - Apply exchange correction adjustment to historical pricing
     * * manualCorrection - Apply manual correction adjustment to historical pricing i.e. annotations made by content analysts
     * * CCH - Apply Capital Change adjustment to historical Pricing due to Corporate Actions e.g. stock split
     * * CRE - Apply Currency Redenomination adjustment when there is redenomination of currency
     * * RPO - Apply Refinitiv Price Only adjustment to adjust historical price only not volume
     * * RTS - Apply Refinitiv TimeSeries adjustment to adjust both historical price and volume
     * * unadjusted - Not apply both exchange/manual corrections and CORAX
     * * qualifiers - Apply price or volume adjustment to historical pricing according to trade/quote qualifier summarization actions e.g. noPrice, noVolume, noPriceAndVolume, noBid, noAsk, noBidAndAsk, outOfSequenceIntraday, outOfSequenceInterday. This adjustment is for events data only.
     * 
     * 
     */
    @JsonProperty("adjustments")
    public List<Adjustment> getAdjustments() {
        return adjustments;
    }

    /**
     * The list of adjustments types (comma delimiter) which the back-end applied to the returned historical time series data.
     * The supported values of adjustments
     * * exchangeCorrection - Apply exchange correction adjustment to historical pricing
     * * manualCorrection - Apply manual correction adjustment to historical pricing i.e. annotations made by content analysts
     * * CCH - Apply Capital Change adjustment to historical Pricing due to Corporate Actions e.g. stock split
     * * CRE - Apply Currency Redenomination adjustment when there is redenomination of currency
     * * RPO - Apply Refinitiv Price Only adjustment to adjust historical price only not volume
     * * RTS - Apply Refinitiv TimeSeries adjustment to adjust both historical price and volume
     * * unadjusted - Not apply both exchange/manual corrections and CORAX
     * * qualifiers - Apply price or volume adjustment to historical pricing according to trade/quote qualifier summarization actions e.g. noPrice, noVolume, noPriceAndVolume, noBid, noAsk, noBidAndAsk, outOfSequenceIntraday, outOfSequenceInterday. This adjustment is for events data only.
     * 
     * 
     */
    @JsonProperty("adjustments")
    public void setAdjustments(List<Adjustment> adjustments) {
        this.adjustments = adjustments;
    }

    /**
     * The chunk list to request chunk data
     * 
     */
    @JsonProperty("chunks")
    public List<Chunk> getChunks() {
        return chunks;
    }

    /**
     * The chunk list to request chunk data
     * 
     */
    @JsonProperty("chunks")
    public void setChunks(List<Chunk> chunks) {
        this.chunks = chunks;
    }

    @JsonProperty("data")
    public List<List<Object>> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<List<Object>> data) {
        this.data = data;
    }

    @JsonProperty("defaultPricingField")
    public String getDefaultPricingField() {
        return defaultPricingField;
    }

    @JsonProperty("defaultPricingField")
    public void setDefaultPricingField(String defaultPricingField) {
        this.defaultPricingField = defaultPricingField;
    }

    /**
     * The headers section of tabular respose
     * 
     */
    @JsonProperty("headers")
    public List<Header> getHeaders() {
        return headers;
    }

    /**
     * The headers section of tabular respose
     * 
     */
    @JsonProperty("headers")
    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    /**
     * The consolidation interval for summaries data only.
     * 
     */
    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    /**
     * The consolidation interval for summaries data only.
     * 
     */
    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * The quality of service of the user for a given RIC universe for the delayed users. The back-end will only return qos (QoS Delayed) for delayed  users no matter whether the query range [start,end) is within the exchange embargo period (e.g. 15 minute delay) or not. The data in the response may or may not be truncated due to the exchange embargo period.
     * 
     */
    @JsonProperty("qos")
    public Qos getQos() {
        return qos;
    }

    /**
     * The quality of service of the user for a given RIC universe for the delayed users. The back-end will only return qos (QoS Delayed) for delayed  users no matter whether the query range [start,end) is within the exchange embargo period (e.g. 15 minute delay) or not. The data in the response may or may not be truncated due to the exchange embargo period.
     * 
     */
    @JsonProperty("qos")
    public void setQos(Qos qos) {
        this.qos = qos;
    }

    /**
     * Message status object
     * 
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * Message status object
     * 
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("summaryTimestampLabel")
    public HistoricalPricingEvent.SummaryTimestampLabel getSummaryTimestampLabel() {
        return summaryTimestampLabel;
    }

    @JsonProperty("summaryTimestampLabel")
    public void setSummaryTimestampLabel(HistoricalPricingEvent.SummaryTimestampLabel summaryTimestampLabel) {
        this.summaryTimestampLabel = summaryTimestampLabel;
    }

    /**
     * The entity universe may contain RIC or PermID depending on your request
     * (Required)
     * 
     */
    @JsonProperty("universe")
    public Universe getUniverse() {
        return universe;
    }

    /**
     * The entity universe may contain RIC or PermID depending on your request
     * (Required)
     * 
     */
    @JsonProperty("universe")
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Generated("jsonschema2pojo")
    public enum SummaryTimestampLabel {

        START_PERIOD("startPeriod"),
        END_PERIOD("endPeriod");
        private final String value;
        private final static Map<String, HistoricalPricingEvent.SummaryTimestampLabel> CONSTANTS = new HashMap<String, HistoricalPricingEvent.SummaryTimestampLabel>();

        static {
            for (HistoricalPricingEvent.SummaryTimestampLabel c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        SummaryTimestampLabel(String value) {
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
        public static HistoricalPricingEvent.SummaryTimestampLabel fromValue(String value) {
            HistoricalPricingEvent.SummaryTimestampLabel constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
