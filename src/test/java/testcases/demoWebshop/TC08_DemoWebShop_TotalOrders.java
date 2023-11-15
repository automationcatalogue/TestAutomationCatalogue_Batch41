package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.demoWebshop.DemoWebShop_OrdersPage;
import pages.demoWebshop.DemoWebshop_HomePage;
import pages.demoWebshop.DemoWebshop_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC08_DemoWebShop_TotalOrders extends TestRunner {

    static String userName,password,sheetName;
    static int totalNumberOfOrders,rowNum_testCase,rowNum_Index;
    static float sumOfAllOrders;
    static Logger log = LogManager.getLogger(TC08_DemoWebShop_TotalOrders.class);
    static WebDriver driver;

    private static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.TotalOrdersRequestTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest(testID+"_DemoWebShop_TotalOrders");
        Log.startTestCase(TC08_DemoWebShop_TotalOrders.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index =ExcelUtils.getRowNumber(testID,"Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "DemoWebShop_TotalOrders";
        int rowNum = ExcelUtils.getRowNumber(testID,sheetName);
        log.info(rowNum + "Row Number is picked from "+sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName,rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :"+userName);
        password = ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        log.info("Password from excel sheet is:"+password);
    }

    @Test
    @Parameters({"browserName"})
    public void TotalOrder(@Optional(Config.browserName) String browserName) throws Exception {
        //Browser Launch
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        //launching WebShop Application
        driver.get(Config.demoWebshop_URL);
        log.info("DemoWebShop URL is loaded :" + Config.demoWebshop_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_LoginPage");
        logger.log(Status.INFO, "DemoWebShop Application is loaded" + Config.demoWebshop_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_LoginPage").build());

        DemoWebshop_LoginPage.login(userName, password);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_HomePage");
        logger.log(Status.INFO, "DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_HomePage").build());

        DemoWebshop_HomePage.openOrdersPage();
        log.info("DemoWebShop Orders Page is Opened");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_OrdersPage");
        logger.log(Status.INFO, "DemoWebShop Orders Page is Opened", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_OrdersPage").build());

        totalNumberOfOrders = DemoWebShop_OrdersPage.totalNumberOfOrders();
        log.info("Total Number of Orders present in Orders Page is :"+totalNumberOfOrders);
        logger.log(Status.INFO, "Total Number of Orders present in Orders Page is :"+totalNumberOfOrders);

        sumOfAllOrders = DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
        log.info("Total value of all Orders present in Orders Page is :"+sumOfAllOrders);
        logger.log(Status.INFO, "Total value of all Orders present in Orders Page is :"+sumOfAllOrders);

        DemoWebShop_OrdersPage.sumOfOrdersDayWise();
        log.info("Day wise Total Order value is displayed");
        logger.log(Status.INFO, "Day wise Total Order value is displayed");

        DemoWebshop_HomePage.logout();
        log.info("DemoWebShop application logout");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(String.valueOf(totalNumberOfOrders), sheetName, rowNum_testCase, Config.col_TotalOrders_NumberOfOrders);
            log.info(totalNumberOfOrders + " is updated as Total Number of Orders");
            ExcelUtils.setCellData(String.valueOf(sumOfAllOrders), sheetName, rowNum_testCase, Config.col_TotalOrders_SumOfAllOrders);
            log.info(sumOfAllOrders + " is updated as Sum Of All Orders");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", rowNum_Index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }

        driver.quit();
        Log.endTestCase();
    }
}
