package iostests;

import PageObjects.IosPageObjects.UiCatlogappPages.AlertViewPage;
import PageObjects.IosPageObjects.UiCatlogappPages.UiCatalogHomepage;
import Utils.AndroidActions;
import Utils.IosActions;
import coreDriver.IosDrivers;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class AlertTest{
   IosDrivers driverIos = new IosDrivers();
    public AppiumDriver driver;
    AlertViewPage alertView;
    UiCatalogHomepage uiCatalogHomepage;

    @BeforeClass
    public void getInfo() throws IOException, InterruptedException {
        driverIos.getIosDetails();
       driver= driverIos.getIosDriver();
       uiCatalogHomepage = new UiCatalogHomepage(driver);
      // alertView = new AlertViewPage(driver);

    }

    @Test
    public void enterTextMad(){
      alertView =  uiCatalogHomepage.clickOnAlertViews();
        alertView.enterTheText("Reddy");
        String str = alertView.confimrClick();
        Assert.assertEquals(str , "A message should be a short, complete sentence.");

        IosActions act = new IosActions(driver);


    }


}
