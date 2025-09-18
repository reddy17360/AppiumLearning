package PageObjects.AndroidPageObject.GeneralStorePageObjects;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {
    public AppiumDriver driver;
    public AndroidActions androidActions;
    public ProductsListPage(AppiumDriver driver){
        this.driver  = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
        androidActions = new AndroidActions(driver);
    }
    @AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
    private WebElement productsListPageTitle;


    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartIcon;
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_back")
    private WebElement backButtonOnProduceListPage;



    public void getAddToCartButton(String productName) {
        androidActions.scrollItTill(productName);
       driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + productName + "\").fromParent(new UiSelector().text(\"ADD TO CART\"))")).click();

    }

    public WebElement getTitleOfProductListPage(){
        return  productsListPageTitle;
    }
    public void clickOnCart(){
        cartIcon.click();
    }

public void clickOnBack(){
        backButtonOnProduceListPage.click();
}


}





