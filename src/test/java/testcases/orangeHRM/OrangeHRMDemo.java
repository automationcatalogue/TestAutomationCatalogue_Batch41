package testcases.orangeHRM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OrangeHRMDemo {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(projectPath+"//reports//TestAutomationCatalogue.html");
        sparkReporter.config().setDocumentTitle("TestAutomationCatalogue_batch41");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("OrangeHRM TestCases Results");


        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS","Windows11");
        extent.setSystemInfo("Author","Batch41");
        extent.setSystemInfo("Browser","Chrome");

        ExtentTest test = extent.createTest("OrangeHRMLogin");
        test.log(Status.PASS,"OrangeHRM Application is Loaded");
        test.log(Status.INFO,"UserName is entered");
        test.log(Status.WARNING,"Password is entered");
        test.log(Status.FAIL,"Login functionality is failed");
        test.log(Status.SKIP,"Login functionality is skipped");

        ExtentTest test1 = extent.createTest("OrangeHRMAddEmployee");
        test1.log(Status.PASS,"OrangeHRM Application is Loaded");
        test1.log(Status.INFO,"AddEmployee is entered");
        test1.log(Status.WARNING,"FirstName is entered");
        test1.log(Status.FAIL,"LastName is failed");
        test1.log(Status.SKIP,"Login functionality is skipped");

        extent.flush();
    }
}
