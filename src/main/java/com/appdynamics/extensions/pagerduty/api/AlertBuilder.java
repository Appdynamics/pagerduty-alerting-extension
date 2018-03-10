/*
 * Copyright 2018. AppDynamics LLC and its affiliates.
 * All Rights Reserved.
 * This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 * The copyright notice above does not evidence any actual or intended publication of such source code.
 */

package com.appdynamics.extensions.pagerduty.api;

import com.appdynamics.extensions.alerts.customevents.*;
import com.appdynamics.extensions.pagerduty.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import org.apache.log4j.Logger;

/**
 * Builds an Alert from Health Rule violation event.
 */

public class AlertBuilder {

    public static final String DASH_SEPARATOR = "-";
    public static final String SLASH_SEPARATOR = "/";
    public static final String APP_DYNAMICS = "AppDynamics";
    public static final String DASH = "-";
    public static final String POLICY_CLOSE = "POLICY_CLOSE";
    public static final String RESOLVE = "resolve";
    public static final String TRIGGER = "trigger";
    public static final String POLICY_CANCELED = "POLICY_CANCELED";
    private static Logger logger = Logger.getLogger(AlertBuilder.class);

    public Alert buildAlertFromHealthRuleViolationEvent(HealthRuleViolationEvent violationEvent, Configuration config) {
        if(violationEvent != null && config != null){
            Alert alert = new Alert();
            alert.setServiceKey(config.getServiceKey());
            alert.setIncidentKey(getIncidentKey(violationEvent));
            alert.setEventType(getEventType(violationEvent.getEventType()));
            setSeverity(violationEvent.getSeverity(),violationEvent);
            alert.setDetails(getSummary(violationEvent,Boolean.valueOf(config.getShowDetails())));
            alert.setDescription(getDescription(violationEvent));
            alert.setClient(APP_DYNAMICS);
            alert.setClientUrl(getAlertUrl(config.getControllerUrl(),violationEvent));
            return alert;
        }
        return null;
    }



    private String getEventType(String eventType){
        if(shouldResolveEvent(eventType)){
            return RESOLVE;
        }
        return TRIGGER;
    }

    private boolean shouldResolveEvent(String eventType) {
        return eventType != null && (eventType.startsWith(POLICY_CLOSE) || eventType.startsWith(POLICY_CANCELED));
    }

    private void setSeverity(String severity, Event event) {
        if(severity.equalsIgnoreCase("WARN")){
            event.setSeverity("WARNING");
        }
        else if(severity.equalsIgnoreCase("INFO")){
            event.setSeverity("INFORMATION");
        }
        else{
            event.setSeverity("CRITICAL");
        }
    }



    public Alert buildAlertFromOtherEvent(OtherEvent otherEvent, Configuration config) {
        if (otherEvent != null && config != null) {
            Alert alert = new Alert();
            setSeverity(otherEvent.getSeverity(),otherEvent);
            alert.setServiceKey(config.getServiceKey());
            alert.setIncidentKey(getIncidentKey(otherEvent));
            alert.setEventType(TRIGGER);
            alert.setDetails(getSummary(otherEvent, Boolean.valueOf(config.getShowDetails())));
            alert.setDescription(getDescription(otherEvent));
            alert.setClient(APP_DYNAMICS);
            alert.setClientUrl(getAlertUrl(config.getControllerUrl(),otherEvent));
            return alert;
        }
        return null;
    }

    private String getDescription(OtherEvent otherEvent) {
        return "Event : " + otherEvent.getEventNotificationName() + " Severity: " + otherEvent.getSeverity();
    }

    private String getDescription(HealthRuleViolationEvent violationEvent) {
        return "Health Rule: " + violationEvent.getHealthRuleName() + " Severity: " + violationEvent.getSeverity();
    }

    private String getIncidentKey(HealthRuleViolationEvent violationEvent) {
        return violationEvent.getAppID() + DASH + violationEvent.getAffectedEntityID() + DASH + violationEvent.getHealthRuleID();
    }

    private String getIncidentKey(OtherEvent otherEvent) {
        return otherEvent.getAppID() + DASH + otherEvent.getEventNotificationId();
    }

    private String getEventTypes(OtherEvent otherEvent) {
        StringBuffer sb = new StringBuffer();
        for(EventType type : otherEvent.getEventTypes()){
            sb.append(type.getEventType());
            sb.append(",");
        }
        return sb.toString();
    }

    private String getEventSummaries(OtherEvent otherEvent) {
        StringBuffer sb = new StringBuffer();
        for(EventSummary summary : otherEvent.getEventSummaries()){
            sb.append(summary.getEventSummaryString());
            sb.append(",");
        }
        return sb.toString();
    }


    public String convertIntoJsonString(Alert alert) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(alert);
    }



    private AlertDetails getSummary(HealthRuleViolationEvent violationEvent,boolean showDetails) {
        AlertHeatlhRuleVioEventDetails details = new AlertHeatlhRuleVioEventDetails();
        details.setApplicationId(violationEvent.getAppID());
        details.setApplicationName(violationEvent.getAppName());
        details.setPolicyViolationAlertTime(violationEvent.getPvnAlertTime());
        details.setSeverity(violationEvent.getSeverity());
        details.setPriority(violationEvent.getPriority());
        details.setHealthRuleName(violationEvent.getHealthRuleName());
        details.setAffectedEntityType(violationEvent.getAffectedEntityType());
        details.setAffectedEntityName(violationEvent.getAffectedEntityName());
        details.setIncidentId(violationEvent.getIncidentID());
        if(showDetails) {
            for (EvaluationEntity eval : violationEvent.getEvaluationEntity()) {
                AlertEvaluationEntity alertEval = buildAlertEvalutionEntity(eval);
                details.getEvaluationEntities().add(alertEval);
            }
        }
        return details;
    }

    private AlertDetails getSummary(OtherEvent otherEvent,boolean showDetails) {
        AlertOtherEventDetails details = new AlertOtherEventDetails();
        details.setApplicationId(otherEvent.getAppID());
        details.setApplicationName(otherEvent.getAppName());
        details.setEventNotificationIntervalInMins(otherEvent.getEventNotificationIntervalInMin());
        details.setSeverity(otherEvent.getSeverity());
        details.setPriority(otherEvent.getPriority());
        details.setEventNotificationName(otherEvent.getEventNotificationName());
        details.setEventNotificationId(otherEvent.getEventNotificationId());
        for(EventType eventType : otherEvent.getEventTypes()){
            AlertEventType alertEventType = new AlertEventType();
            alertEventType.setEventType(eventType.getEventType());
            alertEventType.setEventTypeNum(eventType.getEventTypeNum());
            details.getEventTypes().add(alertEventType);
        }
        if(showDetails) {
            for (EventSummary eventSummary : otherEvent.getEventSummaries()) {
                AlertEventSummary alertSummary = new AlertEventSummary();
                alertSummary.setEventSummaryId(eventSummary.getEventSummaryId());
                alertSummary.setEventSummaryTime(eventSummary.getEventSummaryTime());
                alertSummary.setEventSummaryType(eventSummary.getEventSummaryType());
                alertSummary.setEventSummarySeverity(eventSummary.getEventSummarySeverity());
                alertSummary.setEventSummaryString(eventSummary.getEventSummaryString());
                alertSummary.setEventSummaryDeepLinkUrl(otherEvent.getDeepLinkUrl() + alertSummary.getEventSummaryId());
                details.getEventSummaries().add(alertSummary);
            }
        }
        return details;
    }

    private AlertEvaluationEntity buildAlertEvalutionEntity(EvaluationEntity eval) {
        AlertEvaluationEntity alertEval = new AlertEvaluationEntity();
        alertEval.setName(eval.getName());
        alertEval.setId(eval.getId());
        alertEval.setType(eval.getType());
        alertEval.setNumberOfTriggeredConditions(eval.getNumberOfTriggeredConditions());
        for(TriggerCondition tc : eval.getTriggeredConditions()){
            AlertTriggeredCondition alertTrigger =  buildAlertTriggeredConditions(tc);
            alertEval.getTriggeredConditions().add(alertTrigger);
        }
        return alertEval;
    }

    private AlertTriggeredCondition buildAlertTriggeredConditions(TriggerCondition tc) {
        AlertTriggeredCondition alertTrigger = new AlertTriggeredCondition();
        alertTrigger.setScopeName(tc.getScopeName());
        alertTrigger.setScopeId(tc.getScopeId());
        alertTrigger.setScopeType(tc.getScopeType());
        alertTrigger.setConditionName(tc.getConditionName());
        alertTrigger.setConditionUnitType(tc.getConditionUnitType());
        alertTrigger.setConditionId(tc.getConditionId());
        alertTrigger.setBaselineId(tc.getBaselineId());
        alertTrigger.setBaselineName(tc.getBaselineName());
        alertTrigger.setUseDefaultBaseline(tc.isUseDefaultBaseline());
        alertTrigger.setOperator(tc.getOperator());
        alertTrigger.setObservedValue(tc.getObservedValue());
        alertTrigger.setThresholdValue(tc.getThresholdValue());
        return alertTrigger;
    }




    private String getEntityDisplayName(OtherEvent otherEvent) {
        return otherEvent.getAppName()  + SLASH_SEPARATOR + otherEvent.getEventNotificationName();
    }

    private String getAlertUrl(String controllerUrl, Event event) {
        String url = event.getDeepLinkUrl();
        if(Strings.isNullOrEmpty(controllerUrl)){
            return url;
        }
        int startIdx = 0;
        if(url.startsWith("http://")){
            startIdx = "http://".length();
        }
        else if(url.startsWith("https://")){
            startIdx = "https://".length();
        }
        int endIdx = url.indexOf("/",startIdx + 1);
        String toReplace = url.substring(0,endIdx);
        String alertUrl = url.replaceFirst(toReplace,controllerUrl);
        if(event instanceof HealthRuleViolationEvent){
            alertUrl += ((HealthRuleViolationEvent) event).getIncidentID();
        }
        else{
            alertUrl += ((OtherEvent) event).getEventSummaries().get(0).getEventSummaryId();
        }
        return alertUrl;
    }

}
