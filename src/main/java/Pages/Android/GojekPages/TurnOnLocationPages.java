package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.TurnOnLocationPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.PageFactory;

public class TurnOnLocationPages {
    public AppiumDriver driver;
   public TurnOnLocationPageObject turnOnLocationPageObject;
   public TurnOnLocationPages(AppiumDriver driver){
       turnOnLocationPageObject = new TurnOnLocationPageObject();
       PageFactory.initElements(new AppiumFieldDecorator(driver) , turnOnLocationPageObject);
   }

   public void clickOnTurnOnLocationCta(){
       turnOnLocationPageObject.turnOnLocationCta.click();
   }

   public WebElement TurnOnLocationPageTitle(){
      return turnOnLocationPageObject.turnOnLocationTitle;
   }

}
