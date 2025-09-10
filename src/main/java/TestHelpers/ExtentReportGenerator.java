package TestHelpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
    ExtentSparkReporter reporter;
    ExtentReports extentReports;
    public ExtentReports getExtentReport(){
        //he is responsible to make a nice html report ,it knows where to save the file & what the report looks like
        reporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//ExtentReports//reports//index.html");

        reporter.config().setDocumentTitle("General store automation results");
        reporter.config().setReportName("Automation results");

        //he is like manager , he will track of all test cases & results or holding all the test results
        extentReports = new ExtentReports();
        //they will work together
        extentReports.attachReporter(reporter);
        return  extentReports;
    }
}
