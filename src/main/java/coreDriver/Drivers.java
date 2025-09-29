package coreDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import com.browserstack.local.Local;
import org.openqa.selenium.MutableCapabilities;
import org.testng.internal.Yaml;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Drivers {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private static AppiumDriverLocalService service;

    /** Get driver instance, decides Local vs BrowserStack based on system property */
    public static AppiumDriver getDrivers() throws Exception {
        if (driver.get() == null) {

            boolean useBrowserStack = "true".equalsIgnoreCase(System.getProperty("USE_BROWSERSTACK"));
            System.out.println("▶ USE_BROWSERSTACK: " + useBrowserStack);

            driver.set(createDriver(useBrowserStack));
        }
        return driver.get();
    }

    public static AppiumDriver createDriver(boolean useBrowserStack) throws Exception {
        if (useBrowserStack) return createBrowserStackDriver();
        else return createLocalDriver();
    }

    /** Local Appium Driver */
    private static AppiumDriver createLocalDriver() throws Exception {
        if (service == null || !service.isRunning()) {
            service = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                            .withIPAddress("127.0.0.1")
                            .usingAnyFreePort()
            );
            service.start();
        }
        System.out.println("▶ Local Appium URL: " + service.getUrl());

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName(System.getProperty("deviceName", "emulator-5554"));
        options.setPlatformVersion(System.getProperty("platformVersion", "11"));
        options.setApp(System.getProperty("LOCAL_APP_PATH", "//Users//sanjeevareddysj//Downloads//gojek.apk"));

        System.out.println("▶ Running locally on: " + options.getDeviceName());
        AppiumDriver driver =  new AndroidDriver(service.getUrl(), options);
        return driver;
    }

    /** BrowserStack Driver */
    private static AppiumDriver createBrowserStackDriver() throws Exception {




        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

        if (username == null || accessKey == null || username.isEmpty() || accessKey.isEmpty()) {
            throw new RuntimeException("BrowserStack credentials missing!");
        }





        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("app", System.getProperty("BROWSERSTACK_APP", "bs://<YOUR_APP_ID>"));
        System.out.println("▶ Runtime BROWSERSTACK_APP = " + System.getProperty("BROWSERSTACK_APP"));

        caps.setCapability("deviceName", System.getProperty("BROWSERSTACK_DEVICE", "Samsung Galaxy S22 Ultra"));
        caps.setCapability("platformVersion", System.getProperty("BROWSERSTACK_PLATFORM_VERSION", "12.0"));
        caps.setCapability("platformName", "Android");
        caps.setCapability("project", "BrowserStack Sample");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "Sample Test");

        // if (bsLocal != null && bsLocal.isRunning()) caps.setCapability("browserstack.local", "true");

        String hubUrl = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
        System.out.println("▶ Running on BrowserStack device: " + caps.getCapability("deviceName"));

        return new AndroidDriver(new URL(hubUrl), caps);
    }

    /** Quit driver and stop services */
    public static void quitDriver() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
                System.out.println("▶ Driver quit");
            }
            if (service != null && service.isRunning()) service.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
