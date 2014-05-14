package com.appdynamics.extensions.pagerduty.api;


import com.appdynamics.extensions.alerts.customevents.HealthRuleViolationEvent;
import com.appdynamics.extensions.pagerduty.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class AlertBuilderTest {

    AlertBuilder alertBuilderTest = new AlertBuilder();

    @Test
    public void canSerializeHealthRuleViolationIntoAlertJson() throws JsonProcessingException {
        HealthRuleViolationEvent hrv = createHealthRuleViolationEvent();
        Configuration config = createConfig();
        Alert alert = alertBuilderTest.buildAlertFromHealthRuleViolationEvent(hrv, config);
        String alertJson = alertBuilderTest.convertIntoJsonString(alert);
        Assert.assertTrue(alertJson != null);
    }

    private Configuration createConfig() {
        Configuration config = new Configuration();
        config.setProtocol("https");
        config.setHost("alertHost");
        config.setUrlPath("urlPath");
        return config;
    }

    private HealthRuleViolationEvent createHealthRuleViolationEvent() {
        HealthRuleViolationEvent hrv = new HealthRuleViolationEvent();
        hrv.setAffectedEntityName("affectedEntityName");
        hrv.setEventType("eventType");
        hrv.setAppName("appName");
        hrv.setAffectedEntityType("affectedEntityType");
        hrv.setIncidentID("incidentId");
        hrv.setSummaryMessage("summaryMessage");
        hrv.setDeepLinkUrl("url");
        hrv.setHealthRuleID("ruleId");
        hrv.setHealthRuleName("ruleName");
        hrv.setPvnAlertTime("pvnAlertTime");
        hrv.setPvnTimePeriodInMinutes("period");
        hrv.setAppID("124");
        hrv.setAppName("Appname");
        hrv.setPriority("HIGH");
        hrv.setSeverity("ALERT");
        hrv.setTag("Appd");
        hrv.setAffectedEntityID("AffEntityID");
        return hrv;
    }


}
