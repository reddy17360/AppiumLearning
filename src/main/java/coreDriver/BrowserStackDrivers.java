package coreDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class BrowserStackDrivers {

    public static AppiumDriver initsDriver() throws Exception {
        String runEnv = System.getProperty("runEnv", "local");

        if ("cloud".equalsIgnoreCase(runEnv)) {
            String user = System.getProperty("bsUsername");
            String key = System.getProperty("bsAccessKey");
            String appId = System.getProperty("bsAppId");
            String device = System.getProperty("deviceName");
            String osVer = System.getProperty("osVersion");

            DesiredCapabilities caps = new DesiredCapabilities();
            // credentials
            caps.setCapability("userName", user);
            caps.setCapability("accessKey", key);
            // app and device
            caps.setCapability("app", appId);
            caps.setCapability("deviceName", device);
            caps.setCapability("os_version", osVer);
            caps.setCapability("platformName", "Android");

            // optional extras
            caps.setCapability("projectName", "My Project");
            caps.setCapability("buildName", "Gradle-BStack");
            caps.setCapability("automationName", "UIAutomator2");
            caps.setCapability("newCommandTimeout", 300);
            caps.setCapability("networkLogs", true);
            caps.setCapability("video", true);

            URL hubUrl = new URL("https://hub-cloud.browserstack.com/wd/hub");
            AndroidDriver driver = new AndroidDriver(hubUrl, caps);
            return driver;
        } else {
            // your existing local setup (emulator) — same as before
            // ...
            return null;
        }
    }
}
