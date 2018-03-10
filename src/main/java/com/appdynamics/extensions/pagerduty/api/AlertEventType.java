/*
 * Copyright 2018. AppDynamics LLC and its affiliates.
 * All Rights Reserved.
 * This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 * The copyright notice above does not evidence any actual or intended publication of such source code.
 */

package com.appdynamics.extensions.pagerduty.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertEventType {

    @JsonProperty("Event Type")
    private String eventType;

    @JsonProperty("Event Type Number")
    private String eventTypeNum;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeNum() {
        return eventTypeNum;
    }

    public void setEventTypeNum(String eventTypeNum) {
        this.eventTypeNum = eventTypeNum;
    }
}
