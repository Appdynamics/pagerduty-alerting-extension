/*
 * Copyright 2018. AppDynamics LLC and its affiliates.
 * All Rights Reserved.
 * This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 * The copyright notice above does not evidence any actual or intended publication of such source code.
 */

package com.appdynamics.extensions.pagerduty.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertEventSummary {

    @JsonProperty("Event Summary Id")
    private String eventSummaryId;

    @JsonProperty("Event Summary Time")
    private String eventSummaryTime;

    @JsonProperty("Event Summary Type")
    private String eventSummaryType;

    @JsonProperty("Event Summary Severity")
    private String eventSummarySeverity;

    @JsonProperty("Event Summary String")
    private String eventSummaryString;

    @JsonProperty("Event Summary Url")
    private String eventSummaryDeepLinkUrl;

    public String getEventSummaryId() {
        return eventSummaryId;
    }

    public void setEventSummaryId(String eventSummaryId) {
        this.eventSummaryId = eventSummaryId;
    }

    public String getEventSummaryTime() {
        return eventSummaryTime;
    }

    public void setEventSummaryTime(String eventSummaryTime) {
        this.eventSummaryTime = eventSummaryTime;
    }

    public String getEventSummaryType() {
        return eventSummaryType;
    }

    public void setEventSummaryType(String eventSummaryType) {
        this.eventSummaryType = eventSummaryType;
    }

    public String getEventSummarySeverity() {
        return eventSummarySeverity;
    }

    public void setEventSummarySeverity(String eventSummarySeverity) {
        this.eventSummarySeverity = eventSummarySeverity;
    }

    public String getEventSummaryString() {
        return eventSummaryString;
    }

    public void setEventSummaryString(String eventSummaryString) {
        this.eventSummaryString = eventSummaryString;
    }

    public String getEventSummaryDeepLinkUrl() {
        return eventSummaryDeepLinkUrl;
    }

    public void setEventSummaryDeepLinkUrl(String eventSummaryDeepLinkUrl) {
        this.eventSummaryDeepLinkUrl = eventSummaryDeepLinkUrl;
    }
}
