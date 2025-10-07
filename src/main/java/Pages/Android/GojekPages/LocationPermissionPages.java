package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.LocationPermissionPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.PageFactory;

public class LocationPermissionPages {

    public   AppiumDriver driver;
    public LocationPermissionPageObject locationPermissionPageObject;

    public LocationPermissionPages(AppiumDriver driver){
        this.driver=driver;

        locationPermissionPageObject = new LocationPermissionPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver) , locationPermissionPageObject);
    }


    public void clickOnAllowUsingApp(){
        locationPermissionPageObject.allowWhileUsingAppPermission.click();

    }

    public void clickOnOnlyOnce(){

        locationPermissionPageObject.onlyOneTimeAppPermission.click();
    }
    public void clickOnDenyPermission(){

        locationPermissionPageObject.denyAppPermission.click();
    }
}
