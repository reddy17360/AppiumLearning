package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.SmsOtpMethodPageObjectNewUi;
import PageObjects.AndroidPageObject.GojekPageObject.WhatsappOtpMethodPageObjectNewUi;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class WhatsappOtpMethodPages {


     WhatsappOtpMethodPageObjectNewUi whatsappOtpMethodPageObjectNewUi;
    public AppiumDriver driver;
    public WhatsappOtpMethodPages(AppiumDriver driver){
         whatsappOtpMethodPageObjectNewUi = new WhatsappOtpMethodPageObjectNewUi();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , whatsappOtpMethodPageObjectNewUi);
    }

    public void enterOtp(){
        whatsappOtpMethodPageObjectNewUi.whatsAppOtpTextField.click();
        whatsappOtpMethodPageObjectNewUi.whatsAppOtpTextField.sendKeys("1234");
    }


    public String enterInvalidOtp(){
        whatsappOtpMethodPageObjectNewUi.whatsAppOtpTextField.click();
        whatsappOtpMethodPageObjectNewUi.whatsAppOtpTextField.sendKeys("1244");
        return whatsappOtpMethodPageObjectNewUi.invalidOtpInlineErrorWhatsApp.getText();
        //Incorrect OTP, please try again
    }

    public void clickOnOpenWhatsAppCta(){
        whatsappOtpMethodPageObjectNewUi.openWhatsAppCta.click();

    }
    public void clickOnBackNavigationButton(){
        whatsappOtpMethodPageObjectNewUi.whatsAppOtpBackButton.click();
    }
}
