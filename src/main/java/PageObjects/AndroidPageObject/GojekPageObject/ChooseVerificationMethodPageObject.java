package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ChooseVerificationMethodPageObject {

    @AndroidFindBy(id = "com.gojek.app.staging:id/text_title")
    public WebElement chooseVerificationMethodPageTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(2)")
    public WebElement chooseSms;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(3)")
    public WebElement chooseWhatsapp;

    @AndroidFindBy(id = "com.gojek.app.staging:id/cvs_help_button")
    public WebElement chooseVerificationMethodPageHelpIcon;


    @AndroidFindBy(id = "com.gojek.app.staging:id/title")
    public WebElement frictionDialogueTitleCVM;

    @AndroidFindBy(id = "com.gojek.app.staging:id/description")
    public WebElement frictionDialogueSubTitleCVM;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ll_button_container\").instance(0)")
    public WebElement verifyMyNumberCtaCVM;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/ll_button_container\").instance(1)")
    public WebElement notNowCtaCVM;

    @AndroidFindBy(id = "com.gojek.app.staging:id/auth_back_button")
    public WebElement chooseVerificationScreenBackButton;







}
