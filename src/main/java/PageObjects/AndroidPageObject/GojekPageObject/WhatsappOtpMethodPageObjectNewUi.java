package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WhatsappOtpMethodPageObjectNewUi {

    @AndroidFindBy(id = "com.gojek.app.staging:id/text_title")
    public WebElement whatsappOtpMethodTitle;

    @AndroidFindBy(id = "com.gojek.app.staging:id/tv_toast")
    public WebElement whatsAppToast;

    @AndroidFindBy(id = "com.gojek.app.staging:id/pin_input_edit_text")
    public WebElement whatsAppOtpTextField;


    @AndroidFindBy(id = "com.gojek.app.staging:id/ll_button_container")
    public WebElement openWhatsAppCta;



    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.view.ViewGroup\").instance(6)")
    public WebElement whatsAppMethodSmsOtpOption ;

    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.view.ViewGroup\").instance(7)")
    public WebElement whatsAppMethodWhatsAppOtpOption;

    @AndroidFindBy(id = "com.gojek.app.staging:id/cvs_help_button")
    public WebElement whatsAppMethodHelpIcon;

    @AndroidFindBy(id="com.gojek.app.staging:id/input_field_error")
    public WebElement invalidOtpInlineErrorWhatsApp;

    @AndroidFindBy(id="com.gojek.app.staging:id/auth_back_button")
    public WebElement whatsAppOtpBackButton;





}
