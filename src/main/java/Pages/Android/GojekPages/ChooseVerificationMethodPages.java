package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.ChooseVerificationMethodPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ChooseVerificationMethodPages {
    ChooseVerificationMethodPageObject chooseVerificationMethodPageObject;
    public AppiumDriver driver;
    public ChooseVerificationMethodPages(AppiumDriver driver){
        this.driver=driver;
       chooseVerificationMethodPageObject = new  ChooseVerificationMethodPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , chooseVerificationMethodPageObject);
    }

    public void selectWhatsApp(){
        chooseVerificationMethodPageObject.chooseWhatsapp.click();
    }

    public void selectSms(){
        chooseVerificationMethodPageObject.chooseSms.click();
    }

    public void clickOnBackNavigationButton(){
        chooseVerificationMethodPageObject.chooseVerificationScreenBackButton.click();
    }

}
