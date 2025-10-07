package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PhoneInputPageObject {

    @AndroidFindBy(id="com.gojek.app.staging:id/ivBack")
    public WebElement phoneInputBackButton;

    @AndroidFindBy(id="com.gojek.app.staging:id/input_field_country_picker")
    public WebElement countryPickerIcon;

    @AndroidFindBy(id="com.gojek.app.staging:id/input_search")
    public WebElement searchForCountry;

    @AndroidFindBy(id="com.gojek.app.staging:id/text_country_name")
    public WebElement pickCountry;

    @AndroidFindBy(id="com.gojek.app.staging:id/inputPhoneNumber")
    public WebElement phoneInputTextField;

    @AndroidFindBy(accessibility = "login_sdk_continue")
    public WebElement continueCta;

    @AndroidFindBy(id = "com.gojek.app.staging:id/container")
    public WebElement continueWithGoogleCTa;

    @AndroidFindBy(id = "com.gojek.app.staging:id/btnLanguage")
    public WebElement languagePickerPhoneInputScreen;

    @AndroidFindBy(id = "com.gojek.app.staging:id/btn_positive")
    public WebElement consentAgreeCta;

    @AndroidFindBy(id = "com.gojek.app.staging:id/circular_btn")
    public WebElement consentDismiss;

    @AndroidFindBy(id = "com.gojek.app.staging:id/input_field_error")
    public WebElement shortPhoneNumber;

    @AndroidFindBy(id = "com.gojek.app.staging:id/input_field_error")
    public WebElement longPhoneNumber;

    @AndroidFindBy(id  = "com.google.android.gms:id/credential_picker_layout")
    public WebElement phoneNumberPicker;

    @AndroidFindBy(id="com.google.android.gms:id/cancel")
    public WebElement selectNoneOfTheAbove;



    @AndroidFindBy(id="com.gojek.app.staging:id/input_field_clear")
    public WebElement phoneInputFieldClear;







}
