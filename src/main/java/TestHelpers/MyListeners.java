package TestHelpers;
import Utils.AppiumUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class MyListeners implements ITestListener {
    ExtentReports extentReports = new ExtentReportGenerator().getExtentReport();
    AppiumUtilities utilities = new AppiumUtilities();
    ExtentTest extentTest;
    AppiumDriver driver;
    @Override
    public void onTestStart(ITestResult result){
     extentTest =  extentReports.createTest(result.getMethod().getMethodName());
    }

//    @Override
//    public void onTestFailure(ITestResult result){
////        try {
////           driver =(AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
//        extentTest.log(Status.FAIL , result.getThrowable());
//        //Log the failure along with the exact exception/error message that TestNG caught when the test failed.”
//        try {
//            extentTest.addScreenCaptureFromPath(utilities.getScreenShot(result.getMethod().getMethodName()),result.getMethod().getMethodName());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log the failure + exception in Extent report
        extentTest.log(Status.FAIL, result.getThrowable());

        try {
            // Add screenshot to the report
            String screenshotPath = utilities.getScreenShot(result.getMethod().getMethodName());
            extentTest.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.log(Status.PASS , "Passed bro");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

    }



}
