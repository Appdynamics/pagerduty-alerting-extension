package com.appdynamics.extensions.pagerduty.common;


import com.appdynamics.extensions.pagerduty.Configuration;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ConfigUtilTest {

    ConfigUtil<Configuration> configUtil = new ConfigUtil<Configuration>();

    @Test
    public void canLoadConfigFile() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        Assert.assertTrue(configuration != null);
    }

    @Test(expected = Exception.class)
    public void throwsExceptionForErrorConfigFile() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.error").getFile(),Configuration.class);
    }

    @Test
    public void canLoadIncompleteConfigFile() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.incomplete").getFile(),Configuration.class);
        Assert.assertTrue(configuration != null);
    }
}
