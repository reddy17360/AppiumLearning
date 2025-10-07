package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.CountrySelectionPageObject;
import Utils.AppiumUtilities;
import com.github.javafaker.App;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CountrySelectPages {

     public AppiumDriver driver;
     public AppiumUtilities appiumUtilities;
    public CountrySelectionPageObject countrySelectionPageObject;
    public CountrySelectPages(AppiumDriver driver){
        countrySelectionPageObject = new CountrySelectionPageObject();
        this.driver=driver;
       appiumUtilities = new AppiumUtilities();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , countrySelectionPageObject);
    }

    public void selectCountry(String name) throws Exception {
        appiumUtilities.waitBroUntilVisibility(countrySelectionPageObject.countrySelectorScreenTitle, 20);
        if (name.equals("ID")) {
            countrySelectionPageObject.selectIndonesia.click();
            countrySelectionPageObject.confirmCountry.click();
        } else {
            countrySelectionPageObject.selectSingapore.click();
            countrySelectionPageObject.confirmCountry.click();
        }
    }
    public WebElement countrySelectorTitle(){
       return countrySelectionPageObject.countrySelectorScreenTitle;
    }


}
