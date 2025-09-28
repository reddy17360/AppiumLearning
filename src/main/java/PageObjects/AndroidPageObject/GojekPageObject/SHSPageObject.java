package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SHSPageObject {

    @AndroidFindBy(id="com.gojek.app.staging:id/ll_button_container")
     public WebElement skipTheTreatCta;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ivFullImage\").instance(0)")
    public WebElement goFoodTile;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ivFullImage\").instance(1)")
    public WebElement goMartTile;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ivFullImage\").instance(2)")
    public WebElement goRideTile;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ivFullImage\").instance(3)")
    public WebElement goCarTile;

    @AndroidFindBy(id = "com.gojek.app.staging:id/recyclerView")
    public WebElement shsGrid;

}
