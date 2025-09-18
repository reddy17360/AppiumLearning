package PageObjects.IosPageObjects.UiCatlogappPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UiCatalogHomepage {
   public AppiumDriver driver;

  public  UiCatalogHomepage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this) ;

    }

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Alert Views\"")
    private WebElement activityIndicators;

    @iOSXCUITFindBy(iOSNsPredicate ="name == \"Alert Views\"")
    private WebElement alertViews;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Buttons\"")
    private WebElement buttons;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Date Picker\"")
    private WebElement datePicker;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Image View\"")
    private WebElement imagePicker;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Sliders\"")
    private WebElement sliders;


    public AlertViewPage clickOnAlertViews(){
        alertViews.click();
        return new AlertViewPage(driver);
    }

    public void clickOnButtons(){
        buttons.click();
    }
    public void clickOnDatePicker(){
        datePicker.click();
    }
    public void clickOnImagePicker(){
        imagePicker.click();
    }
    public void clickOnSliders(){
        sliders.click();
    }






}
