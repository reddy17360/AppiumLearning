package BaseTestClass;

import Pages.Android.GojekPages.GojekWelcomePage;
import Utils.AppiumUtilities;
import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
public AppiumDriver driver;
public GojekWelcomePage gojekWelcomePage;
public AppiumUtilities appiumUtilities;

    @BeforeMethod
    public void setUp() throws Exception {
        Drivers.createDriver();
       driver = Drivers.getDriver();
       gojekWelcomePage = new GojekWelcomePage(driver);
       appiumUtilities = new AppiumUtilities();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown(){
        Drivers.quitDriver();
    }
}
