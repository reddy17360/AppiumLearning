package gojek.android.gojek.SignUpRelatedTests;
import BaseTestClass.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidNameErrorValidation extends BaseTest {

    @Test
    public void onlyAlphabets() throws Exception {
        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle() , 20);

        gojekWelcomePage.clickOnLogin();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.enterPhones(appiumUtilities.randomNumberGenerator("ID"));

        phoneInputPages.clickOnConsent();
        chooseVerificationMethodPages.selectWhatsApp();
        whatsappOtpMethodPages.enterOtp();
        androidActions.pressBack(driver);
        androidActions.pressBack(driver);
        nameInputPages.clickOnNameInputField();
        nameInputPages.enterName("Sanju");
        Assert.assertTrue(nameInputPages.clickOnContinue().isEnabled());

    }

    @Test
    public void onlySpcialChars() throws Exception {
        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle() , 20);

        gojekWelcomePage.clickOnLogin();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.enterPhones(appiumUtilities.randomNumberGenerator("ID"));
        phoneInputPages.clickOnConsent();
        chooseVerificationMethodPages.selectWhatsApp();

        whatsappOtpMethodPages.enterOtp();
        nameInputPages.enterName("@#$%^&");
        WebElement error =  nameInputPages.nameInlineError();
        System.out.println(error.getText());
        Assert.assertEquals(error.getText() , "Use your real name, no Gojek related, letters only.");
        Assert.assertFalse(nameInputPages.clickOnContinue().isEnabled());
    }

    @Test
    public void onlyNumbers() throws Exception {
        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle() , 20);

        gojekWelcomePage.clickOnLogin();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.enterPhones(appiumUtilities.randomNumberGenerator("ID"));
        phoneInputPages.clickOnConsent();
        chooseVerificationMethodPages.selectWhatsApp();
        whatsappOtpMethodPages.enterOtp();
        nameInputPages.enterName(appiumUtilities.userName());
        nameInputPages.enterName("17360");
        WebElement error =  nameInputPages.nameInlineError();
        System.out.println(error.getText());
        Assert.assertEquals(error.getText() , "Use your real name, no Gojek related, letters only.");
        Assert.assertFalse(nameInputPages.clickOnContinue().isEnabled());
    }

    @Test
    public void onlyEmojis() throws Exception {
        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle() , 20);

        gojekWelcomePage.clickOnLogin();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.enterPhones(appiumUtilities.randomNumberGenerator("ID"));
        phoneInputPages.clickOnConsent();
        chooseVerificationMethodPages.selectWhatsApp();
        whatsappOtpMethodPages.enterOtp();

         nameInputPages.enterName("\uD83D\uDE0A\uD83D\uDD25\uD83D\uDE80\"");
        WebElement error =  nameInputPages.nameInlineError();
        System.out.println(error.getText());
        Assert.assertEquals(error.getText() , "Use your real name, no Gojek related, letters only.");
        Assert.assertFalse(nameInputPages.clickOnContinue().isEnabled());
    }

    @Test
    public void combinationOfNumberSpecialCharEmojis() throws Exception {
        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle() , 20);

        gojekWelcomePage.clickOnLogin();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.clickOnPhoneInputField();
        phoneInputPages.enterPhones(appiumUtilities.randomNumberGenerator("ID"));
        phoneInputPages.clickOnConsent();
        chooseVerificationMethodPages.selectWhatsApp();
        whatsappOtpMethodPages.enterOtp();

        nameInputPages.enterName("\uD83D\uDE0A\uD83D\uDD25\uD83D\uDE80\"" + "1111" + "!@#$%");
        WebElement error =  nameInputPages.nameInlineError();
        System.out.println(error.getText());
        Assert.assertEquals(error.getText() , "Use your real name, no Gojek related, letters only.");
        Assert.assertFalse(nameInputPages.clickOnContinue().isEnabled());
    }



}
