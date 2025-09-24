package coreDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Drivers {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static AppiumDriverLocalService service;

    /**
     * Initialize driver for the current thread.
     * @throws IOException when config fails
     */
    public static void initDriver() throws IOException {
        if (driver.get() != null) return;

        // Read properties file if needed
        Properties prop = new Properties();
        FileInputStream fileInputStream =
                new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ConfigData.properties");
        prop.load(fileInputStream);

        // Decide environment: local or cloud
        String runEnv = System.getProperty("runEnv", "local").toLowerCase();

        if (runEnv.equals("cloud")) {
            String user = System.getenv("BROWSERSTACK_USERNAME");
            String key  = System.getenv("BROWSERSTACK_ACCESS_KEY");
            String appUrl = System.getProperty("bsAppUrl", "bs://<APP-ID>");
            System.out.println(">>> Running on BrowserStack with device: " + System.getProperty("bsDevice"));

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("app", appUrl);
            caps.setCapability("device", System.getProperty("bsDevice", "Google Pixel 8"));
            caps.setCapability("os_version", System.getProperty("bsOSVersion", "14.0"));
            caps.setCapability("project", "Gradle Appium Demo");
            caps.setCapability("build", "Build-1");

            System.out.println(">>> Connecting to BrowserStack…");

            // include credentials in the URL
            URL hub = new URL("https://" + user + ":" + key + "@hub.browserstack.com/wd/hub");
            AppiumDriver appiumDriver = new AndroidDriver(hub, caps);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.set(appiumDriver);
        } else {
            // -------------------- Local Emulator Setup --------------------
            if (service == null) {
                service = AppiumDriverLocalService.buildService(
                        new AppiumServiceBuilder().usingAnyFreePort());
            }
            service.start();
            System.out.println("Appium server started at: " + service.getUrl());

            UiAutomator2Options options = new UiAutomator2Options();

            String deviceName = System.getProperty("deviceName", "emulator-5554");
            String platformVersion = System.getProperty("platformVersion", "11");

            options.setDeviceName(deviceName);
            options.setPlatformVersion(platformVersion);
            options.setChromedriverExecutable("/Users/sanjeevareddysj/Downloads/chromedriver 2");
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setApp(System.getProperty("user.dir") + "/src/test/resources/GeneralStore.apk");
            options.setNewCommandTimeout(Duration.ofSeconds(500));

            AppiumDriver appiumDriver = new AndroidDriver(service.getUrl(), options);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.set(appiumDriver);
        }
    }

    public static AppiumDriver getDrivers() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static void stopService() {
        if (service != null) {
            service.stop();
            service = null;
        }
    }
}
