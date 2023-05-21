package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackDriver implements WebDriverProvider {

    static MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());


    public static URL getBrowserstackUrl() {
        try {
            return new URL(authConfig.getRemoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", authConfig.getUserLogin());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getUserPassword());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", config.getApp());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", config.deviceName());
        mutableCapabilities.setCapability("os_version", config.platformVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("browserstack.networkLogs", "true");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}
