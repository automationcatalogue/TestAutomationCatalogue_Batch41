package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.demoWebshop.DemoWebshop_CheckoutPage;
import pages.demoWebshop.DemoWebshop_LoginPage;
import pages.demoWebshop.DemoWebshop_CartPage;
import pages.demoWebshop.DemoWebshop_OrderInformationPage;
import pages.demoWebshop.DemoWebShop_OrdersPage;
import pages.demoWebshop.DemoWebshop_HomePage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC07_DemoWebShop_ReOrder extends TestRunner {

    static Logger log = LogManager.getLogger(TC07_DemoWebShop_ReOrder.class);
    static String userName, password, orderNumber, sheetName;
    static int rowNum_testCase, rowNum_Index;
    static WebDriver driver;
    static String base64;

    @Parameters("{testID}")
    @BeforeClass
    public void prerequisite_setup(@Optional(Config.ReOrderRequestTestCase_ID) String testID) {
        logger = extent.createTest(testID+"_DemoWebShop_ReOrder");
        Log.startTestCase(TC07_DemoWebShop_ReOrder.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "DemoWebshop_ReOrder";
        rowNum_testCase = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum_testCase + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_Password);
        log.info("Password from excel sheet is :" + password);
    }

    @Test
    @Parameters({"browserName"})
    public static void ReOrder(@Optional(Config.browserName) String browserName) throws Exception {
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

        DemoWebShop_OrdersPage.clickFirstOrderDetailsBtn();
        log.info("DemoWebShop First Order Details are opened");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_FirstOrdersDetails");
        logger.log(Status.INFO, "DemoWebShop First Order Details are opened", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_FirstOrdersDetails").build());

        DemoWebshop_OrderInformationPage.clickReorderBtn();
        log.info("DemoWebShop Re-Orders action is performed");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_ReOrder");
        logger.log(Status.INFO, "DemoWebShop Re-Orders action is performed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_ReOrder").build());

        DemoWebshop_CartPage.checkoutSelectedItems();
        log.info("DemoWebShop Checked out Selected Items");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_CheckoutItems");
        logger.log(Status.INFO, "DemoWebShop Checked out Selected Items", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_CheckoutItems").build());

        DemoWebshop_CheckoutPage.placeOrder();
        log.info("DemoWebShop Order is Placed");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_PlaceOrder");
        logger.log(Status.INFO, "DemoWebShop Order is Placed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_PlaceOrder").build());

        orderNumber=DemoWebshop_CheckoutPage.getOrderNumber();
        log.info("DemoWebShop Order Number is generated");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_ReOrderNumber");
        logger.log(Status.INFO, "DemoWebShop Order Number is generated", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_ReOrderNumber").build());

        DemoWebshop_HomePage.logout();
        log.info("DemoWebShop application logout");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(orderNumber, sheetName, rowNum_testCase, Config.col_Reorder_OrderNumber);
            log.info(orderNumber+" is written back to the Excel file");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",rowNum_Index,Config.col_reason);
                log.info("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        driver.quit();
        Log.endTestCase();
    }
}
