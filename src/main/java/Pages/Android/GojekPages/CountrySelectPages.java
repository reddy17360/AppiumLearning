package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.CountrySelectionPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CountrySelectPages {

    public AppiumDriver driver;
    public CountrySelectionPageObject countrySelectionPageObject;

    public CountrySelectPages(AppiumDriver driver){
        countrySelectionPageObject = new CountrySelectionPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , countrySelectionPageObject);
    }

    public void clickOnIndonesia(){
        countrySelectionPageObject.selectIndonesia.click();
        countrySelectionPageObject.confirmCountry.click();
    }
    public void clickOnSingapore(){
        countrySelectionPageObject.selectSingapore.click();
        countrySelectionPageObject.confirmCountry.click();
    }

    public WebElement countrySelectorTitle(){
       return countrySelectionPageObject.countrySelectorScreenTitle;
    }


}
