package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebshop_CheckoutPage;
import pages.DemoWebshop_LoginPage;
import pages.DemoWebshop_CartPage;
import pages.DemoWebshop_OrderInformationPage;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC11_DemoWebshop_ReOrder extends TestRunner {

    static XSSFWorkbook wbk;
    static String userName, password, orderNumber, sheetName;
    static int rowNum_testCase, rowNum_Index;
    static Logger log = LogManager.getLogger(TC11_DemoWebshop_ReOrder.class);
    static WebDriver driver;
    static String base64;

    @Parameters("{testID}")
    @BeforeClass
    public void prerequisite_setup(@Optional(Config.ReOrderRequestTestCase_ID) String testID) throws Exception {
        logger = extent.createTest("DemoWebShop_ReOrder" + testID);
        Log.startTestCase(TC11_DemoWebshop_ReOrder.class.getName());

        sheetName = "DemoWebshop_ReOrder";
        rowNum_testCase = ExcelUtils.getRowNumber(testID,sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID,"Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_Password);
    }

    @Test
    @Parameters({"browserName"})
    public static void ReOrder(@Optional(Config.browserName) String browserName) throws Exception {

        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        //launching WebShop Application
        driver.get(Config.demoWebshop_URL);
        log.info("DemoWebShop URL is loaded :" + Config.demoWebshop_URL);
        String title = driver.getTitle();
        log.info("Title of the page is:" + title);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_LoginPage");
       logger.log(Status.INFO, "DemoWebShop Application is loaded" + Config.demoWebshop_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_LoginPage").build());
        //DemoWebshop_HomePage.clickLoginLink();

        DemoWebshop_LoginPage.login(userName,password);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_HomePage");
        logger.log(Status.INFO, "DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_HomePage").build());


        DemoWebshop_HomePage.clickEmailLink();
        log.info("DemoWebShop login mailid clicked");
        DemoWebShop_OrdersPage.clickLinkOrders();
        log.info("DemoWebShop clicked on Orders");
        DemoWebShop_OrdersPage.clickOrderDetailsBtn();
        log.info("DemoWebShop clicked on Order details button");
        DemoWebshop_OrderInformationPage.clickReorderBtn();
        log.info("DemoWebShop clicked on Re-Orders button");
        DemoWebshop_CartPage.clickCheckboxIagree();
        log.info("DemoWebShop clicked on Agree the terms");
        DemoWebshop_CartPage.clickCheckoutBtn();
        log.info("DemoWebShop clicked on Check Out button");
        DemoWebshop_CheckoutPage.clickBillingContinue();
        log.info("DemoWebShop clicked on Billing continue button");
        DemoWebshop_CheckoutPage.clickShippingAddressBtn();
        log.info("DemoWebShop clicked on Shipping Address continue button");
        DemoWebshop_CheckoutPage.clickShippingMethodBtn();
        log.info("DemoWebShop clicked on Shipping button continue button");
        DemoWebshop_CheckoutPage.clickPaymentMethodBtn();
        log.info("DemoWebShop clicked on Payment Method continue button");
        DemoWebshop_CheckoutPage.clickPaymentInformationBtn();
        log.info("DemoWebShop clicked on Payment Information continue button");
        DemoWebshop_CheckoutPage.clickConfirmOrderBtn();
        log.info("DemoWebShop clicked on Confirm Order continue button");
        orderNumber=DemoWebshop_CheckoutPage.getOrderNumber();
        log.info("DemoWebShop clicked on get Order number");
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
