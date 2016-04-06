package com.appdynamics.extensions.pagerduty;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.appdynamics.extensions.pagerduty.common.ConfigUtil;

public class PagerDutyProxyTest {
	
    EventArgs eventArgs = new EventArgs();
    ConfigUtil<Configuration> configUtil = new ConfigUtil<Configuration>();

 //   @Test
    public void canPostHRViolationEventWithProxyWithMultipleEntityAndTriggerMultipleBaselineToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.proxy").getFile(),Configuration.class);
        PagerDutyAlertExtension alertExtension = new PagerDutyAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline());
    }

 //   @Test
    public void canPostOtherEventWithProxyToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.proxy").getFile(),Configuration.class);
        PagerDutyAlertExtension alertExtension = new PagerDutyAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getOtherEvent());
    }

}
