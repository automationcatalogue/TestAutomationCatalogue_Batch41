package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.demoWebshop.*;
import testcases.setup.TestRunner;
import utilities.*;

import static testcases.demoWebshop.TC07_DemoWebShop_ReOrder.sheetName;

public class TC10_DemoWebShop_ApplyDiscount extends TestRunner {

    static String userName, password, applyCoupon, orderNumber;
    static int rowNum, rowNum_Index;
    static Logger log = LogManager.getLogger(TC10_DemoWebShop_ApplyDiscount.class);
    static WebDriver driver;
    private static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.ApplyDiscountRequestTestCase_ID) String testID) throws Exception {

        //To Create the Test in Extent Report
        logger = extent.createTest(testID + "_ApplyDiscount");
        Log.startTestCase(TC10_DemoWebShop_ApplyDiscount.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "DemoWebshop_ApplyDiscount";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("Password from excel sheet is:" + password);
        applyCoupon = ExcelUtils.getCellData(sheetName, rowNum, Config.col_ApplyDiscount_Coupon);
        log.info("ApplyCoupon from excel sheet is:" + applyCoupon);
    }

    @Test()
    @Parameters({"browserName"})
    public void applyDiscount(@Optional(Config.browserName) String browserName) throws Exception {
        driver = CommonUtils.browserLaunch("Chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get(Config.demoWebshop_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_LoginPage");
        log.info("DemoWebShop URL is loaded :" + Config.demoWebshop_URL);
        logger.log(Status.INFO, "DemoWebShop Application is loaded" + Config.demoWebshop_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_LoginPage").build());

        DemoWebShop_LoginPage.login(userName, password);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_HomePage");
        logger.log(Status.INFO, "DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_HomePage").build());

        DemoWebShop_CataloguePage.book_FirstItem();
        log.info("DemoWebShop First Book Item is added into Cart");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_FirstBookItem");
        logger.log(Status.INFO, "DemoWebShop First Book Item is added into Cart", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_FirstBookItem").build());

        double priceBeforeApplyDiscount = DemoWebShop_CartPage.applyCoupon(applyCoupon);
        log.info("Discount Coupon is Applied as :" + applyCoupon);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_ApplyCoupon");
        logger.log(Status.INFO, "Discount Coupon is Applied as :" + applyCoupon, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_FirstBookItem").build());

        DemoWebShop_CartPage.verifyPriceAfterDiscount(priceBeforeApplyDiscount);
        log.info("Verified Cart Price After Discount");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_VerifyPriceAfterDiscount");
        logger.log(Status.INFO, "Verified Cart Price After Discount", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_VerifyPriceAfterDiscount").build());

        DemoWebShop_CartPage.checkoutSelectedItems();
        log.info("DemoWebShop Checked out Selected Items");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_CheckoutItems");
        logger.log(Status.INFO, "DemoWebShop Checked out Selected Items", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_CheckoutItems").build());

        DemoWebShop_CheckoutPage.placeOrder();
        log.info("DemoWebShop Order is Placed");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_PlaceOrder");
        logger.log(Status.INFO, "DemoWebShop Order is Placed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_PlaceOrder").build());

        orderNumber = DemoWebShop_CheckoutPage.getOrderNumber();
        log.info("DemoWebShop Order Number is generated");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_ReOrderNumber");
        logger.log(Status.INFO, "DemoWebShop Order Number is generated", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_ReOrderNumber").build());

        DemoWebShop_HomePage.logout();
        log.info("DemoWebShop application logout");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Log.endTestCase();
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(orderNumber, sheetName, rowNum, Config.col_ApplyDiscount_OrderNumber);
            log.info(orderNumber + " is written back to the Excel file");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
            logger.log(Status.PASS, "DemoWebShop Apply Discount TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", rowNum_Index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
                logger.log(Status.FAIL, "DemoWebShop Apply Discount TestCase is Failed and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
            logger.log(Status.SKIP, "DemoWebShop Apply Discount TestCase is Skipped and status is updated in Excel sheet");
        }
        driver.quit();
        Log.endTestCase();
    }
}


