package BaseTestClass;

import Pages.Android.GojekPages.*;
import Utils.AndroidActions;
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
public PhoneInputPages phoneInputPages;
public ChooseVerificationMethodPages chooseVerificationMethodPages;
public SmsOtpMethodPages smsOtpMethodPages;
public NameInputPages nameInputPages;
public EmailInputPages emailInputPages;
public LocationPermissionPages locationPermissionPages;
public CountrySelectPages countrySelectPages;
public ShsPages shsPages;
public TurnOnLocationPages turnOnLocationPages;
public AndroidActions androidActions;
public WhatsappOtpMethodPages whatsappOtpMethodPages;
public  GojekHomePage gojekHomePage;
public AppiumUtilities utilities;

    @BeforeMethod
    public void setUp() throws Exception {
        Drivers.createDriver();
       driver = Drivers.getDriver();
       appiumUtilities = new AppiumUtilities();
       gojekWelcomePage = new GojekWelcomePage(driver);
       appiumUtilities = new AppiumUtilities();
        phoneInputPages = new PhoneInputPages(driver);
        chooseVerificationMethodPages = new ChooseVerificationMethodPages(driver);
        smsOtpMethodPages = new SmsOtpMethodPages(driver);
        nameInputPages = new NameInputPages(driver);
        emailInputPages = new EmailInputPages(driver);
        locationPermissionPages = new LocationPermissionPages(driver);
        countrySelectPages =  new CountrySelectPages(driver);
        shsPages = new ShsPages(driver);
        turnOnLocationPages = new TurnOnLocationPages(driver);
     androidActions = new AndroidActions( );
        appiumUtilities = new AppiumUtilities( );
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       whatsappOtpMethodPages = new WhatsappOtpMethodPages(driver);
       gojekHomePage= new GojekHomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        Drivers.quitDriver();
    }
}
