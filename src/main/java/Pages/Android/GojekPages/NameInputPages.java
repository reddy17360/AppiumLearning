package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.NameInputPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NameInputPages {
    NameInputPageObject nameInputPageObject;
   public AppiumDriver driver;
    public NameInputPages(AppiumDriver driver){
        nameInputPageObject = new NameInputPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver) ,nameInputPageObject );
    }

    public void clickOnNameInputField(){
        nameInputPageObject.nameInputTextField.click();
    }
    public void enterName(String name){
        nameInputPageObject.nameInputTextField.sendKeys(name);
    }
    public void clickOnContinue(){
        nameInputPageObject.nameScreenContinueCta.click();
    }
    public void clickOnBackNavigationNameScreen(){
        nameInputPageObject.nameInputScreenBackNavigation.click();
    }


    public String nameInlineError(){
        return nameInputPageObject.nameInputTextFieldInlineError.getText();
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
