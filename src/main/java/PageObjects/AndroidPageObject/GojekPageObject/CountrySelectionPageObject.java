package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CountrySelectionPageObject {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(0)")
    public WebElement selectIndonesia;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(1)")
    public WebElement selectSingapore;

    @AndroidFindBy(id = "com.gojek.app.staging:id/ll_button_container")
    public WebElement confirmCountry;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.gojek.app.staging:id/tvTitle\")")
    public WebElement countrySelectorScreenTitle;


}
