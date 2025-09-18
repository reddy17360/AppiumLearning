package androidTests.generalStore;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.ProductsListPage;
import Utils.AndroidActions;
import coreDriver.Drivers;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObjects.AndroidPageObject.GeneralStorePageObjects.FillFormPage;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

//@Listeners(TestHelpers.MyListeners.class)
public class FillFormLoginTest  {

    FillFormPage fillFormPage;
    AndroidActions actions;

    @BeforeClass
    public void initPages() throws Exception {
        Drivers.initDriver();
        fillFormPage = new FillFormPage(Drivers.getDrivers());
        actions = new AndroidActions(Drivers.getDrivers());
    }

    @Test(priority = 0)
    public void loginErrorValidation() throws InterruptedException {
        fillFormPage.setCountryPicker("Angola");
        fillFormPage.setGender("Female");
        fillFormPage.submitForm();
        WebElement toast = Drivers.getDrivers().findElement(By.xpath("(//android.widget.Toast)[1]"));
        System.out.println(toast.getAttribute("name"));
        Assert.assertEquals(toast.getAttribute("name"), "Please enter your name");
    }
    @Test(priority = 1, dataProvider = "getData")
    public void loginToGeneralStore(HashMap<String ,String> data) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Drivers.getDrivers() , Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")));
        fillFormPage.setName(data.get("name"));
        fillFormPage.setCountryPicker(data.get("country"));
        fillFormPage.setGender(data.get("gender"));
        fillFormPage.submitForm();
        Thread.sleep(2000);
        new ProductsListPage(Drivers.getDrivers()).clickOnBack();
    }



    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String ,String>> data = actions.getJsonData(System.getProperty("user.dir") + "//src//test//TestData//GeneralStoreTestData.json");

         Object[][] obj = new Object[data.size()][1]; // [rows][columns]
//we’re wrapping each HashMap inside a 2D array so that TestNG can use it.
        for (int i = 0; i < data.size(); i++) {
            obj[i][0] = data.get(i);
            // json -->list of hashmap --> 2d array
        }
        return obj;

      //  We wrapped the HashMap inside Object[][] only because TestNG demands it.
        //  Once TestNG unwraps the row, it sees a HashMap, and since your test
        //  method parameter type matches (HashMap<String,String>), it passes it directly.
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
//        Drivers.quitDriver();   // quit driver after test
    }

    @Test
    public void devBranch(){




        System.out.println("1");
        System.out.println("2");

        System.out.println("sanju");

        System.out.println("reddy");




        System.out.println("123");
        System.out.println("456");
    }
}


