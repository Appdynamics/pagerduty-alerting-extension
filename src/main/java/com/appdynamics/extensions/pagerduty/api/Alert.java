package com.appdynamics.extensions.pagerduty.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Alert {

    @JsonProperty("service_key")
    private String serviceKey;

    @JsonProperty("incident_key")
    private String incidentKey;

    @JsonProperty("event_type")
    private String eventType;

    @JsonProperty("details")
    private AlertDetails details;

    @JsonProperty("description")
    private String description;

    public String getServiceKey() {
        return serviceKey;
    }

    public void setServiceKey(String serviceKey) {
        this.serviceKey = serviceKey;
    }

    public String getIncidentKey() {
        return incidentKey;
    }

    public void setIncidentKey(String incidentKey) {
        this.incidentKey = incidentKey;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public AlertDetails getDetails() {
        return details;
    }

    public void setDetails(AlertDetails details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
