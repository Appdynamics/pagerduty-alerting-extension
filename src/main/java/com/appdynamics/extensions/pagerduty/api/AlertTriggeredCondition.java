package com.appdynamics.extensions.pagerduty.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertTriggeredCondition {

    @JsonProperty("Scope Type")
    private String scopeType;

    @JsonProperty("Scope Name")
    private String scopeName;

    @JsonProperty("Scope ID")
    private String scopeId;

    @JsonProperty("Condition Name")
    private String conditionName;

    @JsonProperty("Condition Id")
    private String conditionId;

    @JsonProperty("Operator")
    private String operator;

    @JsonProperty("Condition Unit Type")
    private String conditionUnitType;

    @JsonProperty("Use Default Baseline")
    private boolean useDefaultBaseline;

    @JsonProperty("Baseline name")
    private String baselineName;

    @JsonProperty("Baseline id")
    private String baselineId;

    @JsonProperty("Threshold value")
    private String thresholdValue;

    @JsonProperty("Observed value")
    private String observedValue;

    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getConditionUnitType() {
        return conditionUnitType;
    }

    public void setConditionUnitType(String conditionUnitType) {
        this.conditionUnitType = conditionUnitType;
    }

    public boolean isUseDefaultBaseline() {
        return useDefaultBaseline;
    }

    public void setUseDefaultBaseline(boolean useDefaultBaseline) {
        this.useDefaultBaseline = useDefaultBaseline;
    }

    public String getBaselineName() {
        return baselineName;
    }

    public void setBaselineName(String baselineName) {
        this.baselineName = baselineName;
    }

    public String getBaselineId() {
        return baselineId;
    }

    public void setBaselineId(String baselineId) {
        this.baselineId = baselineId;
    }

    public String getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(String thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public String getObservedValue() {
        return observedValue;
    }

    public void setObservedValue(String observedValue) {
        this.observedValue = observedValue;
    }
}
