package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.EmailInputPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.PageFactory;

public class EmailInputPages {

   public EmailInputPageObject emailInputPageObject;
   public AppiumDriver driver;
   public EmailInputPages(AppiumDriver driver){
       emailInputPageObject = new EmailInputPageObject();
       PageFactory.initElements(new AppiumFieldDecorator(driver) , emailInputPageObject);
   }


   public void enterEmail(String email){
       emailInputPageObject.emailInputTextField.click();
       emailInputPageObject.emailInputTextField.sendKeys(email);

   }
   public void clickOnEmailContinue(){
       emailInputPageObject.emailContinueCta.click();
   }
   public String getError(){
      return emailInputPageObject.registeredEmailInlineError.getText();
   }

}
