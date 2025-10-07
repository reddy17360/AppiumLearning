package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.EmailInputPageObject;
import PageObjects.AndroidPageObject.GojekPageObject.GojekHomePageObject;
import Utils.AppiumUtilities;
import com.github.javafaker.App;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class GojekHomePage {
      AppiumDriver driver;
    public GojekHomePageObject gojekHomePageObject;
public AppiumUtilities appiumUtilities;
    public GojekHomePage(AppiumDriver driver){
        gojekHomePageObject= new GojekHomePageObject();
        this.driver=driver;
        appiumUtilities = new AppiumUtilities();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , gojekHomePageObject);
    }



    public String isUserOnHome() throws Exception {
              appiumUtilities.waitBroUntilVisibility(gojekHomePageObject.ProfileIcon, 10);
     return    gojekHomePageObject.ProfileIcon.getAttribute("displayed");
    }
}
