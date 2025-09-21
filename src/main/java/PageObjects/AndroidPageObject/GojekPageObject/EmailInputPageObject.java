package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class EmailInputPageObject {

    @AndroidFindBy(id="com.gojek.app.staging:id/navigation_back")
    public WebElement emailInputScreenBackNavigation;


    @AndroidFindBy(id="com.gojek.app.staging:id/navigation_menu_icon_1")
    public WebElement emailInputScreenHelpIcon;


    @AndroidFindBy(id="com.gojek.app.staging:id/input_email")
    public WebElement emailInputTextField;

    @AndroidFindBy(id="com.gojek.app.staging:id/ll_button_container")
    public WebElement emailContinueCta;

    @AndroidFindBy(id="com.gojek.app.staging:id/input_field_error")
    public WebElement registeredEmailInlineError;




    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ll_button_container\").instance(1)")
    public WebElement emailInputFrictionGetItDoneCta;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ll_button_container\").instance(2)")
    public WebElement emailInputFrictionNotNowCta;







}
