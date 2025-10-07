package gojek.android.gojek.SignUpRelatedTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTestClass.*;

//@Listeners(TestHelpers.MyListeners.class)
public class GojekWelcomeScreenVerificationTest  extends BaseTest  {

    private static final Logger logger = LoggerFactory.getLogger(SignUpHappyFlowTest.class);

    @Test
    public void verifyWelcomeScreen() throws Exception {
        System.out.println("Log4j2 config location: " +
                org.apache.logging.log4j.core.config.Configurator.initialize(null, "log4j2.xml"));
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
