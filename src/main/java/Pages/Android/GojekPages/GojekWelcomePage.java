package Pages.Android.GojekPages;

import PageObjects.AndroidPageObject.GojekPageObject.WelcomePageObjects;
import Utils.AndroidActions;
import coreDriver.Drivers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GojekWelcomePage {
    public WelcomePageObjects welcomePageObjects;
    public AppiumDriver driver;

    public GojekWelcomePage(AppiumDriver driver) {

        welcomePageObjects = new WelcomePageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), welcomePageObjects);
    }


    public String getWelcomeTitle() {
        return welcomePageObjects.gojekTitle.getAttribute("content-desc");
    }

    public void swipeTheCarousel() throws   InterruptedException {
        AndroidActions androidActions = new AndroidActions(Drivers.getDrivers());

            androidActions.swipeIt(welcomePageObjects.corouselSequence);
            System.out.println(welcomePageObjects.welcomeTitle.getText());
            System.out.println(welcomePageObjects.welcomeSubTitle.getText());

        }
        public void clickOnLanguagePicker(){
        welcomePageObjects.languagePicker.click();
        }
        public void selectLanguage(String language){
        if(language.equals("English"))
            welcomePageObjects.english.click();
        else
            welcomePageObjects.bahasa.click();
        }
        public void confirmLanguage(){
        welcomePageObjects.submitLanguage.click();
        }

        public String appLanguage(){
        return welcomePageObjects.languagePicker.getAttribute("content-desc");
        }
    }
