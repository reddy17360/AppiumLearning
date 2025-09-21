package gojek.android.gojek;

import Pages.Android.GojekPages.GojekWelcomePage;
import Pages.Android.GojekPages.PhoneInputPages;
import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PhoneNumberErrorValidation {
    GojekWelcomePage gojekWelcomePage;
    PhoneInputPages phoneInputPages;
    public AppiumDriver driver;
    @BeforeClass
    public void preRequisite() throws IOException {
        Drivers.initDriver();
        driver = Drivers.getDrivers();
      gojekWelcomePage = new  GojekWelcomePage(Drivers.getDrivers());
      phoneInputPages = new PhoneInputPages(Drivers.getDrivers());
    }

    @Test
    public void shortNumberErrorValidation() throws InterruptedException {
        gojekWelcomePage.clickOnLogin();
       phoneInputPages.enterPhones("8100008");
       phoneInputPages.clickOnContinue();
       phoneInputPages.clickOnConsent();
       String errorForShortNumber = phoneInputPages.shortErrorValidation();
        System.out.println(errorForShortNumber);
        Assert.assertEquals(errorForShortNumber, "Doesn't look right. Try again?");
        phoneInputPages.clickOnBackButtonOfPhoneInputScreen();

    }
    @Test
    public void longNumberErrorValidation() throws InterruptedException {
        gojekWelcomePage.clickOnLogin();
        phoneInputPages.enterPhones("810000891010101");
        phoneInputPages.clickOnContinue();
        String errorForLongNumber = phoneInputPages.longErrorValidation();
        Assert.assertEquals(errorForLongNumber, "Phone number entered seems to be incorrect");
        phoneInputPages.clickOnBackButtonOfPhoneInputScreen();

    }
}
