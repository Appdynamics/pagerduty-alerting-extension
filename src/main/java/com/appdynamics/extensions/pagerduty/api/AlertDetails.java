package com.appdynamics.extensions.pagerduty.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertDetails {

    @JsonProperty("Application Id")
    private String applicationId;

    @JsonProperty("Application Name")
    private String applicationName;

    @JsonProperty("Severity")
    private String severity;

    @JsonProperty("Priority")
    private String priority;


    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
