package PageObjects.AndroidPageObject.GeneralStorePageObjects;

import Utils.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public AppiumDriver driver;
    public AndroidActions  androidActions;
    public CartPage(AppiumDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
        androidActions = new AndroidActions(driver);
    }


    @AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
    private WebElement cartPageTitle;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/appbar_btn_back")
    private WebElement cartPageBackButton;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/productName")
    private List<WebElement> productsName;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productsPrice;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy(xpath=" //android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
    private WebElement checkBox;


    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/termsButton\")")
    private WebElement termsAndCondition;


    public void getProductNames(){
        System.out.println("The products present in cart");
        for(WebElement name : productsName){
            System.out.println(name.getText());
        }
    }
    public double getProductPrice(){
        Double sum = 0.0;
        for(WebElement price : productsPrice){
           sum =sum +  androidActions.getFormatedPrice(price);

        }
      return sum;
    }


    public double grandTotal(){
        return Double.parseDouble((totalAmount.getText().substring(1)));
    }

    public void setCheckBox(){
        checkBox.click();
    }


    public void readTermsAndConditions(){
        androidActions.longPress(termsAndCondition);

    }




}
