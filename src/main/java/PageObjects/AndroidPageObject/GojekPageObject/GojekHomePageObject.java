package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class GojekHomePageObject {

    @AndroidFindBy(id = "com.gojek.app.staging:id/iv_profile_image")
    public WebElement ProfileIcon;

}
