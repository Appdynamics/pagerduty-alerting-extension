package com.appdynamics.extensions.pagerduty.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AlertOtherEventDetails extends AlertDetails{

    @JsonProperty("Event Notification Name")
    private String eventNotificationName;

    @JsonProperty("Event Notification Id")
    private String eventNotificationId;

    @JsonProperty("Event Notification Interval In Mins")
    private String eventNotificationIntervalInMins;

    @JsonProperty("Event Types")
    private List<AlertEventType> eventTypes = new ArrayList<AlertEventType>();

    @JsonProperty("Event Summaries")
    private List<AlertEventSummary> eventSummaries = new ArrayList<AlertEventSummary>();

    public String getEventNotificationName() {
        return eventNotificationName;
    }

    public void setEventNotificationName(String eventNotificationName) {
        this.eventNotificationName = eventNotificationName;
    }

    public String getEventNotificationId() {
        return eventNotificationId;
    }

    public void setEventNotificationId(String eventNotificationId) {
        this.eventNotificationId = eventNotificationId;
    }

    public String getEventNotificationIntervalInMins() {
        return eventNotificationIntervalInMins;
    }

    public void setEventNotificationIntervalInMins(String eventNotificationIntervalInMins) {
        this.eventNotificationIntervalInMins = eventNotificationIntervalInMins;
    }

    public List<AlertEventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<AlertEventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public List<AlertEventSummary> getEventSummaries() {
        return eventSummaries;
    }

    public void setEventSummaries(List<AlertEventSummary> eventSummaries) {
        this.eventSummaries = eventSummaries;
    }
}
