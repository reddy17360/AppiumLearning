package androidTests.generalStore;


import PageObjects.AndroidPageObject.GeneralStorePageObjects.CartPage;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.FillFormPage;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.ProductsListPage;
import coreDriver.Drivers;
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

    @BeforeClass
    public void initPages() throws IOException {
        Drivers.initDriver();
        fillFormPage = new FillFormPage(Drivers.getDrivers());
        productsListPage = new ProductsListPage(Drivers.getDrivers());
        cartPage = new CartPage(Drivers.getDrivers());

    }

    @Test()
    public void getSumOfItems() throws InterruptedException {
        fillFormPage.setName("SanjeevReddy");
        fillFormPage.setCountryPicker("Angola");
        fillFormPage.setGender("Female");
        fillFormPage.submitForm();

        WebDriverWait wait = new WebDriverWait(Drivers.getDrivers() , Duration.ofSeconds(10));
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
        Drivers.stopService();

}
}
