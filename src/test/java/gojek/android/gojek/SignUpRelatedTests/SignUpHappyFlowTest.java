package gojek.android.gojek.SignUpRelatedTests;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTestClass.*;

public class SignUpHappyFlowTest  extends  BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SignUpHappyFlowTest.class);



    @Test
    public void happySignUpFlowWithOtpSmsAndWhileUsing() throws Exception {

        System.out.println("Log4j2 config location: " +
                org.apache.logging.log4j.core.config.Configurator.initialize(null, "log4j2.xml"));
        String countryName = "ID";
        logger.info("Step 1: Verify welcome page and click on login");
        appiumUtilities.waitBroUntilVisibility(gojekWelcomePage.getWelcomeTitle(), 20);
        gojekWelcomePage.clickOnLogin();

        logger.info("step-2 entering the phone");
        phoneInputPages.enterPhones(countryName);

        logger.info("step-3 selecting the verification type and add the otp");
        chooseVerificationMethodPages.selectSms();
        smsOtpMethodPages.enterOtp();

        logger.info("step-4 entering the name");
        nameInputPages
        .enterName(appiumUtilities.userName())
        .clickOnContinue();

        logger.info("step-5 entering the email");
        emailInputPages
                .enterEmail(androidActions.userName() + "@gmail.com")
                .clickOnEmailContinue();


        logger.info("step-6 moving to turn on location page");
        turnOnLocationPages.clickOnTurnOnLocationCta();

        logger.info("step-7 allow the permission");
        locationPermissionPages.clickOnAllowUsingApp();

        logger.info("step-8 select the country");
        countrySelectPages.selectCountry(countryName);

        logger.info("skip the shs");
        shsPages.clickOnSkipShs();

        logger.info("landed on gojek home orrrayyyyyyy");
        Assert.assertEquals("true", gojekHomePage.isUserOnHome());

    }


}