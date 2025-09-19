package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomePageObjects {

    @AndroidFindBy(accessibility = "Gojek")
    public WebElement gojekTitle;


    @AndroidFindBy(id = "com.gojek.app.staging:id/pill_language_picker")
    public WebElement languagePicker;

    @AndroidFindBy(id = "com.gojek.app.staging:id/btn_login")
    public WebElement loginButton;

    @AndroidFindBy(id = "com.gojek.app.staging:id/btn_signup")
    public WebElement signUpButton;

    //to get click on links we have toRequest devs to provide proper
    // accessibility IDs or separate elements.
    @AndroidFindBy(id = "com.gojek.app.staging:id/text_terms")
    public WebElement termsAndConditionsText;

    @AndroidFindBy(id = "com.gojek.app.staging:id/auth_on_boarding_carousel")
    public WebElement corouselSequence;

    @AndroidFindBy(id= "com.gojek.app.staging:id/text_welcome")
    public WebElement welcomeTitle;
    @AndroidFindBy(id= "com.gojek.app.staging:id/text_welcome_body")
    public WebElement welcomeSubTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/img_country_selected\").instance(0)")
    public WebElement english;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/img_country_selected\").instance(1)")
    public WebElement bahasa;

    @AndroidFindBy(id = "com.gojek.app.staging:id/btn_confirm_selection")
    public WebElement submitLanguage;












}
