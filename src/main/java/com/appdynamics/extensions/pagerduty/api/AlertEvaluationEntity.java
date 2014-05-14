package com.appdynamics.extensions.pagerduty.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AlertEvaluationEntity {
    @JsonProperty("Entity type")
    private String type;

    @JsonProperty("Entity name")
    private String name;

    @JsonProperty("Entity id")
    private String id;

    @JsonProperty("No of triggered conds")
    private String numberOfTriggeredConditions;

    @JsonProperty("Triggerd Conds")
    private List<AlertTriggeredCondition> triggeredConditions = new ArrayList<AlertTriggeredCondition>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfTriggeredConditions() {
        return numberOfTriggeredConditions;
    }

    public void setNumberOfTriggeredConditions(String numberOfTriggeredConditions) {
        this.numberOfTriggeredConditions = numberOfTriggeredConditions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AlertTriggeredCondition> getTriggeredConditions() {
        return triggeredConditions;
    }

    public void setTriggeredConditions(List<AlertTriggeredCondition> triggeredConditions) {
        this.triggeredConditions = triggeredConditions;
    }
}
