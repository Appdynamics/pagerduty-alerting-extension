package com.appdynamics.extensions.pagerduty.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AlertHeatlhRuleVioEventDetails extends AlertDetails{

    @JsonProperty("Policy Violation Alert Time")
    private String policyViolationAlertTime;

    @JsonProperty("Name of Violated Health Rule")
    private String healthRuleName;

    @JsonProperty("Affected Entity Type")
    private String affectedEntityType;

    @JsonProperty("Name of Affected Entity")
    private String affectedEntityName;

    @JsonProperty("Incident ID")
    private String incidentId;

    @JsonProperty("Evaluation Entities")
    private List<AlertEvaluationEntity> evaluationEntities = new ArrayList<AlertEvaluationEntity>();

    public String getPolicyViolationAlertTime() {
        return policyViolationAlertTime;
    }

    public void setPolicyViolationAlertTime(String policyViolationAlertTime) {
        this.policyViolationAlertTime = policyViolationAlertTime;
    }

    public String getHealthRuleName() {
        return healthRuleName;
    }

    public void setHealthRuleName(String healthRuleName) {
        this.healthRuleName = healthRuleName;
    }

    public String getAffectedEntityType() {
        return affectedEntityType;
    }

    public void setAffectedEntityType(String affectedEntityType) {
        this.affectedEntityType = affectedEntityType;
    }

    public String getAffectedEntityName() {
        return affectedEntityName;
    }

    public void setAffectedEntityName(String affectedEntityName) {
        this.affectedEntityName = affectedEntityName;
    }

    public List<AlertEvaluationEntity> getEvaluationEntities() {
        return evaluationEntities;
    }

    public void setEvaluationEntities(List<AlertEvaluationEntity> evaluationEntities) {
        this.evaluationEntities = evaluationEntities;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }
}
