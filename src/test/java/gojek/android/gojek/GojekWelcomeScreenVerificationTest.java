package gojek.android.gojek;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTestClass.*;

public class GojekWelcomeScreenVerificationTest  extends BaseTest  {

    @Test
    public void verifyWelcomeScreen() throws Exception {
        String title = gojekWelcomePage.getWelcomeTitle().getAttribute("content-desc");

        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle() , 40);
        Assert.assertEquals(title,"Gojek");
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
