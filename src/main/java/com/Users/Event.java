
package com.Users;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventId",
    "eventResourceId",
    "eventType",
    "eventSource",
    "eventCreated",
    "eventData",
    "metaData"
})
public class Event {

    @JsonProperty("eventId")
    private String eventId;
    @JsonProperty("eventResourceId")
    private String eventResourceId;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("eventSource")
    private Object eventSource;
    @JsonProperty("eventCreated")
    private String eventCreated;
    @JsonProperty("eventData")
    private EventData eventData;
    @JsonProperty("metaData")
    private MetaData metaData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("eventId")
    public String getEventId() {
        return eventId;
    }

    @JsonProperty("eventId")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @JsonProperty("eventResourceId")
    public String getEventResourceId() {
        return eventResourceId;
    }

    @JsonProperty("eventResourceId")
    public void setEventResourceId(String eventResourceId) {
        this.eventResourceId = eventResourceId;
    }

    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("eventSource")
    public Object getEventSource() {
        return eventSource;
    }

    @JsonProperty("eventSource")
    public void setEventSource(Object eventSource) {
        this.eventSource = eventSource;
    }

    @JsonProperty("eventCreated")
    public String getEventCreated() {
        return eventCreated;
    }

    @JsonProperty("eventCreated")
    public void setEventCreated(String eventCreated) {
        this.eventCreated = eventCreated;
    }

    @JsonProperty("eventData")
    public EventData getEventData() {
        return eventData;
    }

    @JsonProperty("eventData")
    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }

    @JsonProperty("metaData")
    public MetaData getMetaData() {
        return metaData;
    }

    @JsonProperty("metaData")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
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
