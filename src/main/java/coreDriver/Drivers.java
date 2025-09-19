package coreDriver;

import Utils.AppiumUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Drivers {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static AppiumDriverLocalService service;

    /**
     * Initialize driver for the current thread.
     */
    // static because we want a single global driver manager.
    public static void initDriver() throws IOException {
        if (driver.get() == null) {
            Properties prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ConfigData.properties");
            prop.load(fileInputStream);

            if (service == null) {
                service = AppiumDriverLocalService.buildService(
                        new AppiumServiceBuilder()
                                .usingAnyFreePort()   // Let Appium pick an available port
                );
            }

            service.start();

            System.out.println("Appium server started at: " + service.getUrl());



            UiAutomator2Options options = new UiAutomator2Options();
//if(System.getProperty("deviceName") != null && System.getProperty("androidVersion") != null) {
           String deviceName= System.getProperty("deviceName");
          String platformVersion =  System.getProperty("platformVersion");
                  options.setDeviceName(deviceName);
                  options.setPlatformVersion(platformVersion);


            System.out.println(platformVersion);
            System.out.println(deviceName);

            options.setChromedriverExecutable("/Users/sanjeevareddysj/Downloads/chromedriver 2");

            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setApp("/Users//sanjeevareddysj//Downloads//gojek-integration-6f8b9c1.apk");
           // options.setApp(System.getProperty("user.dir") + "/src/test/resources/GeneralStore.apk");
            options.setNewCommandTimeout(Duration.ofSeconds(500));


            AppiumDriver appiumDriver = new AndroidDriver(service.getUrl(), options);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.set(appiumDriver);
        }
    }

    /**
     * Get driver for the current thread.
     */
    public static AppiumDriver getDrivers() {
        return driver.get();
    }

    /**
     * Quit driver for the current thread.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    /**
     * Stop Appium service.
     */
    public static void stopService() {
        if (service != null) {
            service.stop();
            service = null;
        }
    }
}
