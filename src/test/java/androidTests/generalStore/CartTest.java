package androidTests.generalStore;


import PageObjects.AndroidPageObject.GeneralStorePageObjects.CartPage;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.FillFormPage;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.ProductsListPage;
import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class CartTest    {



    FillFormPage fillFormPage;
    CartPage cartPage;
    ProductsListPage productsListPage;
 AppiumDriver driver;
    @BeforeClass
    public void initPages() throws Exception {
    driver = Drivers.getDriver();
        fillFormPage = new FillFormPage(driver);
        productsListPage = new ProductsListPage(driver);
        cartPage = new CartPage(driver);

    }

    @Test()
    public void getSumOfItems() throws Exception {
        fillFormPage.setName("SanjeevReddy");
        fillFormPage.setCountryPicker("Angola");
        fillFormPage.setGender("Female");
        fillFormPage.submitForm();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productsListPage.getTitleOfProductListPage()));
        String[] productNames = {"Air Jordan 4 Retro" ,"Air Jordan 9 Retro" };
        for(int i=0 ;i<productNames.length ; i++) {
            productsListPage.getAddToCartButton(productNames[i]);
        }
        productsListPage.clickOnCart();
        Thread.sleep(4000);

        cartPage.getProductNames();
        Double price =cartPage.getProductPrice();
        Double grandTotal = cartPage.grandTotal();
        if(price.equals(grandTotal)){
            System.out.println("sum of cart itmes & grand total is correct");
        }

        cartPage.setCheckBox();
        cartPage.readTermsAndConditions();
    }

    @Test
    public void doIt(){
        System.out.println("hey");
        fillFormPage.setName("SanjeevReddy");
    }

@AfterClass(alwaysRun = true)
    public void killMe(){
        Drivers.quitDriver();


}
}
