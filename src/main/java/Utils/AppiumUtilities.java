package Utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumUtilities {

    AppiumDriverLocalService service;

    public Double getFormatedPrice(WebElement price){
       return Double.parseDouble(price.getText().substring(1));
    }

    public List<HashMap<String,String>> getJsonData(String filePath ) throws IOException {

        //convert the json file to json string
        String jsonData = FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);
        //convert json string to list of hashmap
        ObjectMapper map = new ObjectMapper();
       return map.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>(){});

    }

    public AppiumDriverLocalService getStartServer(String address , int port){
       service = new AppiumServiceBuilder().
              withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))///usr/local/lib/node_modules
              .withIPAddress(address)
              .usingPort(port)
               .withTimeout(Duration.ofSeconds(100))//Wait up to 60 seconds for the Appium server to start and be ready.”
               .build();
       service.start();
       return service;



    }

    public String getScreenShot(String testName) throws IOException {
        // Capture the screenshot from the thread-safe driver
        File source = Drivers.getDrivers().getScreenshotAs(OutputType.FILE);

        // Save the screenshot into ExtentReports folder
        String destination = System.getProperty("user.dir") + "/ExtentReports/reports/" + testName + ".png";
        FileUtils.copyFile(source, new File(destination));

        return destination;
    }
}
