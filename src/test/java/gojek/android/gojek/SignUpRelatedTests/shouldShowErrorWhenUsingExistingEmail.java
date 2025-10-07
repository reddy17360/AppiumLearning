package gojek.android.gojek.SignUpRelatedTests;
import BaseTestClass.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class shouldShowErrorWhenUsingExistingEmail extends BaseTest{

    @Test
    public void errorValidationForExistingEmail() throws Exception {
        //step-1 click on login
        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle(), 20);
        gojekWelcomePage.clickOnLogin();

        //step-2 enter phone number

        phoneInputPages.enterPhones(appiumUtilities.randomNumberGenerator("ID"));

        //step-3 enter otp
        chooseVerificationMethodPages.selectWhatsApp();
        whatsappOtpMethodPages.enterOtp();


        //step-4 enter name
        nameInputPages.enterName(appiumUtilities.userName()).clickOnContinue().click();

        //step-5 enter email & validate
        emailInputPages.enterEmail("sanjeeva.r.testyantra@aux.gojek.com").clickOnEmailContinue();

        Assert.assertEquals(emailInputPages.getEmailInlineError(), "This email is already registered." , "Expected inline error for existing email did not appear");

    }
}
