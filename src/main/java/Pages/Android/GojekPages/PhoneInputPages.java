package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.PhoneInputPageObject;
import Utils.AndroidActions;
import Utils.AppiumUtilities;
import com.aventstack.extentreports.reporter.configuration.Theme;
import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PhoneInputPages {

   public    AppiumDriver driver;
    public PhoneInputPageObject phoneInputPageObject;
    public PhoneInputPages(AppiumDriver driver){
        this.driver=driver;

         phoneInputPageObject = new PhoneInputPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver) ,phoneInputPageObject );
    }


    public void clickOnBackButtonOfPhoneInputScreen(){
        phoneInputPageObject.phoneInputBackButton.click();
    }

    public void selectCountryCode(String countryName) throws InterruptedException {
         phoneInputPageObject.countryPickerIcon.click();
         phoneInputPageObject.searchForCountry.sendKeys(countryName);
        Thread.sleep(2000);
         phoneInputPageObject.pickCountry.click();
    }
    public void enterPhone(String country){
        AppiumUtilities appiumUtilities = new AppiumUtilities();
        phoneInputPageObject.phoneInputTextField.sendKeys(appiumUtilities.randomNumberGenerator(country));
        phoneInputPageObject.continueCta.click();
        phoneInputPageObject.consentAgreeCta.click();
        }

        public void clickOnPhoneInputField(){
        phoneInputPageObject.phoneInputTextField.click();
        }
        public PhoneInputPages enterPhones(String country)  {
            // as idenetity team confirms it is an consicious decision made by them about this pop-up issue
            AppiumUtilities appiumUtilities = new AppiumUtilities();

            phoneInputPageObject.phoneInputTextField.click();
            phoneInputPageObject.phoneInputTextField.click();
            phoneInputPageObject.phoneInputTextField.sendKeys( appiumUtilities.randomNumberGenerator(country));
            phoneInputPageObject.continueCta.click();
            phoneInputPageObject.consentAgreeCta.click();

            if(!driver.findElements(By.id("com.gojek.app.staging:id/input_field_error")).isEmpty()){
                   phoneInputPageObject.phoneInputFieldClear.click();
                   phoneInputPageObject.phoneInputTextField.sendKeys( appiumUtilities.randomNumberGenerator(country));
                   phoneInputPageObject.continueCta.click();
                   phoneInputPageObject.consentAgreeCta.click();

                       if (!driver.findElements(By.id("com.gojek.app.staging:id/input_field_error")).isEmpty()){
                           phoneInputPageObject.phoneInputFieldClear.click();
                           phoneInputPageObject.phoneInputTextField.sendKeys( appiumUtilities.randomNumberGenerator(country));
                           phoneInputPageObject.continueCta.click();
                           phoneInputPageObject.consentAgreeCta.click();
                       }

           }
           return this;
        }

        public void clickOnContinue(){
        phoneInputPageObject.continueCta.click();
        }
        public void clickOnConsent(){
        phoneInputPageObject.consentAgreeCta.click();
        }

        public String shortErrorValidation(){
          return  phoneInputPageObject.shortPhoneNumber.getText();
        }
    public String longErrorValidation(){
        return  phoneInputPageObject.longPhoneNumber.getText();

    }

    public WebElement googleNumberPopUp(){
      return  phoneInputPageObject.phoneNumberPicker;
    }
    public void clickOnNoneOfTheAbove(){
        phoneInputPageObject.selectNoneOfTheAbove.click();
    }

    public void clickOnPhoneInputTwice(){
        phoneInputPageObject.phoneInputTextField.click();
    }
    }





