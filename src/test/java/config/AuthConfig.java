package config;

import org.aeonbits.owner.Config;

public interface AuthConfig extends Config {
    @Key("username")
    String getUserLogin();

    @Key("password")
    String getUserPassword();

    @Key("remoteUrl")
    String getRemoteUrl();
}
