package gojek.android.gojek;

import Pages.Android.GojekPages.*;
import Utils.AppiumUtilities;

import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SignUpHappyFlowTest {
    GojekWelcomePage gojekWelcomePage;
   PhoneInputPages phoneInputPages;
   ChooseVerificationMethodPages chooseVerificationMethodPages;
    SmsOtpMethodPages smsOtpMethodPages;
    NameInputPages nameInputPages;
    EmailInputPages emailInputPages;
    LocationPermissionPages locationPermissionPages;
    CountrySelectPages countrySelectPages;
    public AppiumDriver driver;
    ShsPages shsPages;
    AppiumUtilities appiumUtilities;
    TurnOnLocationPages turnOnLocationPages;

     @BeforeClass
    public void preRequisite() throws Exception {
        driver= Drivers.getDriver();
         gojekWelcomePage = new GojekWelcomePage(driver);
         phoneInputPages = new PhoneInputPages(driver);
         chooseVerificationMethodPages = new ChooseVerificationMethodPages(driver);
         smsOtpMethodPages = new SmsOtpMethodPages(driver);
         nameInputPages = new NameInputPages(driver);
         emailInputPages = new EmailInputPages(driver);
         locationPermissionPages = new LocationPermissionPages(driver);
         countrySelectPages =  new CountrySelectPages(driver);
           shsPages = new ShsPages(driver);
           turnOnLocationPages = new TurnOnLocationPages(driver);

           appiumUtilities = new AppiumUtilities( );

     }

     @Test
    public void happySignUpTest() throws Exception {

       //  String user =appiumUtilities.autoUser();
         appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle() , 20);
         String user = "reddySanjuReddy";
         gojekWelcomePage.clickOnLogin();

         phoneInputPages.clickOnPhoneInputField();
            appiumUtilities.waitBroUntilVisibility(phoneInputPages.googleNumberPopUp() , 10);
               if( phoneInputPages.googleNumberPopUp().isDisplayed()){
                 System.out.println("pop-up appeared");
                 phoneInputPages.clickOnNoneOfTheAbove();
                 phoneInputPages.clickOnPhoneInputField();
                   phoneInputPages.clickOnPhoneInputField();
                 phoneInputPages.enterPhones(new AppiumUtilities().randomNumberGenerator());
                 phoneInputPages.clickOnContinue();
                 phoneInputPages.clickOnConsent();
              }else{
                   phoneInputPages.clickOnPhoneInputField();
                 phoneInputPages.enterPhones(new AppiumUtilities().randomNumberGenerator());
                 phoneInputPages.clickOnContinue();
                 phoneInputPages.clickOnConsent();
              }

         chooseVerificationMethodPages.selectSms();
            smsOtpMethodPages.enterOtp();

         appiumUtilities.waitBroUntilVisibility(nameInputPages.emailIstPopupOnEmailScreen(), 10);
            ((AndroidDriver) Drivers.getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
            nameInputPages.clickOnNameInputField();
            nameInputPages.enterName(user);
            nameInputPages.clickOnContinue();


         emailInputPages.enterEmail(user+"@gmail.com");
            emailInputPages.clickOnEmailContinue();

         appiumUtilities.waitBroUntilVisibility(turnOnLocationPages.TurnOnLocationPageTitle() , 20);
            turnOnLocationPages.clickOnTurnOnLocationCta();

         locationPermissionPages.clickOnAllowUsingApp();
         appiumUtilities.waitBroUntilVisibility(countrySelectPages.countrySelectorTitle() , 20);
            countrySelectPages.clickOnIndonesia();

         appiumUtilities.waitBroUntilVisibility(shsPages.getGrid(), 20);
            shsPages.clickOnSkipShs().click();
     }
}
