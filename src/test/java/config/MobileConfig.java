package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})
public interface MobileConfig extends Config {

    @Key("deviceName")
    @DefaultValue("Pixel 4 API 30")
    String deviceName();

    @Key("platformVersion")
    @DefaultValue("android")
    String platformVersion();

    @Key("osVersion")
    @DefaultValue("11.0")
    String osVersion();

    @Key("appUrl")
    String getApp();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}