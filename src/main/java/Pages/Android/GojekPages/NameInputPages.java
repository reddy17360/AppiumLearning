package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.NameInputPageObject;
import Utils.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NameInputPages {
    NameInputPageObject nameInputPageObject;
 public  AppiumDriver driver;
    public NameInputPages(AppiumDriver driver){
        this.driver = driver;
        nameInputPageObject = new NameInputPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver) ,nameInputPageObject );
    }

    public void clickOnNameInputField(){
        nameInputPageObject.nameInputTextField.click();
    }
    public NameInputPages enterName(String name) throws Exception {

       for(int i=0;i<2;i++) {
           new AndroidActions( ).pressBack(driver);
       }
        nameInputPageObject.nameInputTextField.sendKeys(name);
       nameInputPageObject.nameScreenContinueCta.click();
       return this;
    }
    public WebElement clickOnContinue(){
       return nameInputPageObject.nameScreenContinueCta;
    }
    public void clickOnBackNavigationNameScreen(){
        nameInputPageObject.nameInputScreenBackNavigation.click();
    }


    public WebElement nameInlineError(){
        return nameInputPageObject.nameInputTextFieldInlineError;
    }

    public void clickOnRegisterLater(){
        nameInputPageObject.nameInputFrictionRegisterLaterCta.click();
    }
    public void clickOnLetsContinue(){
        nameInputPageObject.nameInputFrictionLetsContinueCta.click();
    }

    public WebElement emailIstPopupOnEmailScreen(){
       return nameInputPageObject.googlePopUp;
    }




}
