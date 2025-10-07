package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.EmailInputPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.PageFactory;

public class EmailInputPages {

   public EmailInputPageObject emailInputPageObject;
   public AppiumDriver driver;
   public EmailInputPages(AppiumDriver driver){
       emailInputPageObject = new EmailInputPageObject();
       this.driver=driver;

       PageFactory.initElements(new AppiumFieldDecorator(driver) , emailInputPageObject);
   }


   public EmailInputPages enterEmail(String email){
       emailInputPageObject.emailInputTextField.click();
       emailInputPageObject.emailInputTextField.sendKeys(email);
       return this;
   }
   public void clickOnEmailContinue(){
       emailInputPageObject.emailContinueCta.click();
   }
   public String getEmailInlineError(){
      return emailInputPageObject.registeredEmailInlineError.getText();
   }

}
