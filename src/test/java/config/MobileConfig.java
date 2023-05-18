package config;

import org.aeonbits.owner.Config;

/*@MobileConfig.LoadPolicy(MobileConfig.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:${env}.properties",
                "classpath:credentials.properties"})*/

@Config.Sources({
        "classpath:${env}.properties"
})
public interface MobileConfig extends Config {

    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("os_version")
    @DefaultValue("12.0")
    String getVersion();

    @Key("appUrl")
    String getApp();
}