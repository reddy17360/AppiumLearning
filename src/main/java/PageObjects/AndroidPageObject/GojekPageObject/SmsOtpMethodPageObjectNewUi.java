package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SmsOtpMethodPageObjectNewUi {

    @AndroidFindBy(id="com.gojek.app.staging:id/text_title")
    public WebElement smsOtpMethodTitle;

    @AndroidFindBy(id="com.gojek.app.staging:id/tv_toast")
    public WebElement smsToast;
    @AndroidFindBy(id="com.gojek.app.staging:id/cvs_help_button")
    public WebElement smsOtpHelpIcon;
    @AndroidFindBy(id = "com.gojek.app.staging:id/pin_input_edit_text")
    public WebElement smsTextField;

    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.view.ViewGroup\").instance(6)")
    public WebElement smsMethodSmsOtpOption ;

    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.view.ViewGroup\").instance(7)")
    public WebElement smsMethodWhatsAppOtpOption;

    @AndroidFindBy(id="com.gojek.app.staging:id/input_field_error")
    public WebElement invalidOtpInlineErrorSms;

    @AndroidFindBy(id="com.gojek.app.staging:id/auth_back_button")
    public WebElement smsOtpBackButton;

}
