package com.appdynamics.extensions.pagerduty;


import com.appdynamics.extensions.pagerduty.common.ConfigUtil;
import org.junit.Test;

import java.io.FileNotFoundException;

public class PagerDutyAlertExtensionTest {


    EventArgs eventArgs = new EventArgs();
    ConfigUtil<Configuration> configUtil = new ConfigUtil<Configuration>();

    @Test
    public void canPostHRViolationEventWithMultipleEntityAndTriggerMultipleBaselineToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        PagerDutyAlertExtension alertExtension = new PagerDutyAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline());
    }

    @Test
    public void canPostOtherEventToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        PagerDutyAlertExtension alertExtension = new PagerDutyAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getOtherEvent());
    }

    @Test
    public void canPostHRViolationEventWithMultipleEvalEntityAndTriggerMultipleBaselineNoDetailsToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.noDetails").getFile(),Configuration.class);
        PagerDutyAlertExtension alertExtension = new PagerDutyAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline());
    }


    @Test
    public void canPostOtherEventWithNoDetailsToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.noDetails").getFile(),Configuration.class);
        PagerDutyAlertExtension alertExtension = new PagerDutyAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getOtherEvent());
    }

}
