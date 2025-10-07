package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.ChooseVerificationMethodPageObject;
import PageObjects.AndroidPageObject.GojekPageObject.SmsOtpMethodPageObjectNewUi;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SmsOtpMethodPages {


    SmsOtpMethodPageObjectNewUi smsOtpMethodPageObjectNewUi;
     public AppiumDriver driver;
    public SmsOtpMethodPages(AppiumDriver driver){
      smsOtpMethodPageObjectNewUi = new SmsOtpMethodPageObjectNewUi();
        this.driver=driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver) , smsOtpMethodPageObjectNewUi);
    }

    public void enterOtp(){
        smsOtpMethodPageObjectNewUi.smsTextField.click();
        smsOtpMethodPageObjectNewUi.smsTextField.sendKeys("1234");
    }


    public String enterInvalidOtp(){
        smsOtpMethodPageObjectNewUi.smsTextField.sendKeys("4321");
        return smsOtpMethodPageObjectNewUi.invalidOtpInlineErrorSms.getText();
        //Incorrect OTP, please try again
    }
    public void clickOnBackNavigationButton(){
        smsOtpMethodPageObjectNewUi.smsOtpBackButton.click();
    }
}
