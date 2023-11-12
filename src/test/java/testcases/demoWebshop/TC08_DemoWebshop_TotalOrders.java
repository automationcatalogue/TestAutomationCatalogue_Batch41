package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC08_DemoWebshop_TotalOrders extends TestRunner {
    static XSSFWorkbook wbk;
    static String userName,password,sheetName;
    static int TotalNumberOfOrders,rowNum_testCase,rowNum_Index;
    static float SumOfAllOrders;
    static Logger log = LogManager.getLogger(TC08_DemoWebshop_TotalOrders.class);
    static WebDriver driver;

    private static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.TotalOrdersRequestTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest("DemoWebShop_TotalOrders"+testID);
        Log.startTestCase(TC08_DemoWebshop_TotalOrders.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index =ExcelUtils.getRowNumber(testID,"Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        String sheetName = "DemoWebShop_TotalOrders";
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
    public void TotalOrder(@Optional("chrome") String browserName) throws Exception {
        driver = CommonUtils.browserLaunch("chrome");
        BaseClass ob = new BaseClass(driver);

        //Loading OrangeHRM URL
        driver.get(Config.demoWebshop_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_LoginPage");
        log.info("DemoWebShop URL is loaded :"+Config.demoWebshop_URL);
        logger.log(Status.INFO,"DemoWebShop Application is loaded"+Config.demoWebshop_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_LoginPage").build());

        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        DemoWebshop_LoginPage.login(userName, password);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_HomePage");
        logger.log(Status.INFO,"DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_HomePage").build());

        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_MyAccountPage");
        logger.log(Status.INFO,"DemoWebShop MyAccountPage is loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_MyAccountPage").build());

        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();

        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_OrdersPage");
        logger.log(Status.INFO,"DemoWebShop OrdersPage is loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_OrdersPage").build());

        TotalNumberOfOrders = DemoWebShop_OrdersPage.totalNumberOfOrders();
        SumOfAllOrders = DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
        DemoWebShop_OrdersPage.sumOfOrdersDayWise();
        driver.close();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(String.valueOf(TotalNumberOfOrders), "DemoWebShop_TotalOrders", rowNum_testCase, Config.col_TotalOrders_NumberOfOrders);
            log.info(TotalNumberOfOrders + " is updated as Total Number of Orders");

            ExcelUtils.setCellData(String.valueOf(SumOfAllOrders), "DemoWebShop_TotalOrders", rowNum_testCase, Config.col_TotalOrders_SumOfAllOrders);
            log.info(TotalNumberOfOrders + " is updated as Sum Of All Orders");

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
        ExcelUtils.closeExcelFile();
        Log.endTestCase();
    }
}
