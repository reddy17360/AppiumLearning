package coreDriver;



import Utils.AppiumUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class IosDrivers {
    public AppiumDriver driver;
    public AppiumDriverLocalService service;

    public void getIosDetails() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//ConfigData.proprties");
        prop.load(fileInputStream);


        if(service == null) {
            service=  new AppiumUtilities().getStartServer(prop.getProperty("ipAddress") ,Integer.parseInt(prop.getProperty("port")));

            //service object knows all the server details

            Thread.sleep(4000);
     XCUITestOptions options = new XCUITestOptions();
     options.setDeviceName("iPhone 16 Pro");
     options.setApp("//Users//sanjeevareddysj//IdeaProjects//LearAumatingApp//LearAumatingApp//src//test//resources//UI.app");
     options.setPlatformVersion("18.4");
     options.setWdaLaunchTimeout(Duration.ofSeconds(50));

     driver = new AppiumDriver(service.getUrl(), options);
 }
    }
    public AppiumDriver getIosDriver(){
        return driver;
    }
}
