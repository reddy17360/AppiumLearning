package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TurnOnLocationPageObject {

    @AndroidFindBy(id = "com.gojek.app.staging:id/tvDoodleTitle")
    public WebElement turnOnLocationTitle;

    @AndroidFindBy(id = "com.gojek.app.staging:id/tv_location_permission_desc")
    public WebElement turnOnLocationSubTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ll_button_container\")")
    public WebElement turnOnLocationCta;
}
