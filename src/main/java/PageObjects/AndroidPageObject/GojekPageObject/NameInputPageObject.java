package PageObjects.AndroidPageObject.GojekPageObject;

import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NameInputPageObject {

    @AndroidFindBy(id ="com.google.android.gms:id/action_bar_root")
    public WebElement googlePopUp;

@AndroidFindBy(id="com.gojek.app.staging:id/input_name")
    public WebElement nameInputTextField;


    @AndroidFindBy(id="com.gojek.app.staging:id/input_field_error")
    public WebElement nameInputTextFieldInlineError;

    @AndroidFindBy(id="com.gojek.app.staging:id/ll_button_container")
    public WebElement nameScreenContinueCta;



    @AndroidFindBy(id="com.gojek.app.staging:id/navigation_back")
    public WebElement nameInputScreenBackNavigation;

    @AndroidFindBy(id="com.gojek.app.staging:id/navigation_menu_icon_1")
    public WebElement nameInputScreenHelpIcon;


    @AndroidFindBy(uiAutomator=" new UiSelector().resourceId(\"com.gojek.app.staging:id/ll_button_container\").instance(1)")
    public WebElement nameInputFrictionLetsContinueCta;

    @AndroidFindBy(uiAutomator=" new UiSelector().resourceId(\"com.gojek.app.staging:id/ll_button_container\").instance(2)")
    public WebElement nameInputFrictionRegisterLaterCta;













}
