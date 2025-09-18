package PageObjects.AndroidPageObject.GeneralStorePageObjects;

import Utils.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FillFormPage{
    private FillFormPage fillFormPage ;
    private AppiumDriver driver;
    public AndroidActions actions;
    public FillFormPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
        actions = new AndroidActions(driver);
    }


    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
   private   WebElement enterName;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
   private    WebElement genderFemale;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    private    WebElement genderMale;


    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
 private    WebElement shopButton;

    @AndroidFindBy(id="android:id/text1")
    private    WebElement countryPicker;

    @AndroidFindBy(xpath ="//android.widget.Toast")
    private List<WebElement> toastMessage;



    public void setName(String name){
        enterName.sendKeys("reddy");
    }

    public void setGender(String gender){
        if(gender.contains("Female")){
            genderFemale.click();
        }else {
            genderMale.click();
        }
    }
    public void submitForm(){
        shopButton.click();
    }


    public void setCountryPicker(String country) throws InterruptedException {
        Thread.sleep(2000);
        countryPicker.click();
      actions.scrollItTill(country);
    }

    public List<WebElement> toastMessageHandler(){
       return  toastMessage;
    }
}
