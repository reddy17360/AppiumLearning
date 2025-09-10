package androidTests.generalStore;

import coreDriver.Drivers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.FillFormPage;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.ProductsListPage;

import java.io.IOException;

public class ProductListTest   {
    public FillFormPage fillFormPage;
    public ProductsListPage productsListPage;

    @BeforeClass(alwaysRun = true)
    public void initPages() throws IOException {
        Drivers.initDriver();
        fillFormPage = new FillFormPage(Drivers.getDrivers());
        productsListPage = new ProductsListPage(Drivers.getDrivers());
    }

    @Test(groups = {"Smoke"})
    public void addItemsToCart() throws InterruptedException {

        fillFormPage.setName("SanjeevReddy");
        fillFormPage.setCountryPicker("Angola");
        fillFormPage.setGender("Female");
        fillFormPage.submitForm();


        String[] productNames = {"Air Jordan 4 Retro" ,"Air Jordan 9 Retro" };
        for(int i=0 ;i<productNames.length ; i++) {
            productsListPage.getAddToCartButton(productNames[i]);
        }
        productsListPage.clickOnCart();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        Drivers.quitDriver();   // quit driver after test
    }
}
