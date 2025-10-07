package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.SHSPageObject;
import Utils.AppiumUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ShsPages {
     public AppiumDriver driver;
     public AppiumUtilities appiumUtilities;
    public SHSPageObject shsPageObject;
    public ShsPages(AppiumDriver driver){
        shsPageObject = new SHSPageObject();
        this.driver=driver;
        appiumUtilities = new AppiumUtilities();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , shsPageObject);
    }
    public void clickOnSkipShs() throws Exception {
        appiumUtilities.waitBroUntilVisibility(shsPageObject.shsGrid, 20);
        shsPageObject.skipTheTreatCta.click();

    }



}
