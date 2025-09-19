package gojek.android.gojek;



import Pages.Android.GojekPages.GojekWelcomePage;
import coreDriver.Drivers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class GojekWelcomeScreenVerificationTest{
    public GojekWelcomePage gojekWelcomePage;
    @BeforeClass
    public void preRequisit() throws IOException {
        Drivers.initDriver();
        gojekWelcomePage = new GojekWelcomePage(Drivers.getDrivers());
    }

    @Test
    public void verifyWelcomeScreen() throws IOException, InterruptedException {
        Assert.assertEquals(gojekWelcomePage.getWelcomeTitle(),"Gojek");
        for(int i=0 ;i<4;i++) {
            gojekWelcomePage.swipeTheCarousel();
            Thread.sleep(4000);
        }
    }

    @Test
    public void changeAppLanguage(){
        gojekWelcomePage.clickOnLanguagePicker();
        String defaultLanguage = gojekWelcomePage.appLanguage();
        gojekWelcomePage.selectLanguage("English");
        gojekWelcomePage.confirmLanguage();
         String latestLanguage = gojekWelcomePage.appLanguage();
         Assert.assertEquals(defaultLanguage, latestLanguage);
    }


}
