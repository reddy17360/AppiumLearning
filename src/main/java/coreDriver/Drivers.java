

package coreDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import java.time.Duration;


public class Drivers {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private static AppiumDriverLocalService service;
    // simple static counter for unique systemPorts


    public static AppiumDriver createDriver() throws Exception {
        if (service == null || !service.isRunning()) {
            service = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder().usingAnyFreePort().withIPAddress("127.0.0.1"));
            service.start();
        }

        if(driver.get()== null) {
            System.out.println("▶ Local Appium URL: " + service.getUrl());

            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setDeviceName(System.getProperty("deviceName", "emulator-5554"));
            options.setPlatformVersion(System.getProperty("platformVersion", "11"));
            options.setApp(System.getProperty("app", "//Users//sanjeevareddysj//Downloads//gojek.apk"));
            options.setNewCommandTimeout(Duration.ofSeconds(80));
            options.setAppWaitForLaunch(true);
            options.setCapability("unicodeKeyboard", true);
            options.setCapability("resetKeyboard" , true);
             //options.setSystemPort(port);
             ////options.setUdid(udId);


           driver.set( new AndroidDriver(service.getUrl(), options));



        }
    return driver.get();
    }

    public static AppiumDriver getDriver() throws Exception {

        return driver.get();
    }

    /** BrowserStack Driver */

    /** Quit driver and stop services */
    public static void quitDriver() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
                System.out.println("▶ Driver quit");
            }
            if (service != null && service.isRunning())
                service.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
