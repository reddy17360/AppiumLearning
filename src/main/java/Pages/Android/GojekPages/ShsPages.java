package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.SHSPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ShsPages {
    public AppiumDriver driver;
    public SHSPageObject shsPageObject;
    public ShsPages(AppiumDriver driver){
        shsPageObject = new SHSPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , shsPageObject);
    }
    public WebElement clickOnSkipShs(){
       return shsPageObject.skipTheTreatCta;
    }

    public WebElement getGrid(){
        return shsPageObject.shsGrid;
    }

}
