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

public class TC09_DemoWebShop_UpdateShoppingCart extends TestRunner {

    static Logger log = LogManager.getLogger(TC09_DemoWebShop_UpdateShoppingCart.class);
    static int row, rowNum_Index, row_index;
    static String userName, password, jewel_Length, update_Qty, orderNumber, sheetName;
    static String firstItemPrice, secondItemPrice;
    static WebDriver driver;
    private static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_Setup(@Optional(Config.UpdateShoppingCartRequestTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest(testID + "_UpdateShoppingCart");
        Log.startTestCase(TC09_DemoWebShop_UpdateShoppingCart.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "DemoWebshop_UpdateShoppingCart";
        row = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(row + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        log.info("Password from excel sheet is:" + password);
        jewel_Length = ExcelUtils.getCellData(sheetName, row, Config.col_UpdateCart_Length);
        log.info("jewel_Length from excel sheet is:" + jewel_Length);
        update_Qty = ExcelUtils.getCellData(sheetName, row, Config.col_UpdateCart_Quantity);
        log.info("update_Qty from excel sheet is:" + update_Qty);
    }

    @Test
    @Parameters({"browserName"})
    public void Update_ShoppingCart(@Optional(Config.browserName) String browserName) throws Exception {
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

        DemoWebShop_CataloguePage.jewelry_FirstItem(jewel_Length);
        log.info("DemoWebShop First Jewelry Item is added into Cart");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_FirstJewelryItem");
        logger.log(Status.INFO, "DemoWebShop First Jewelry Item is added into Cart", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_FirstJewelryItem").build());

        firstItemPrice = DemoWebShop_CartPage.itemPrice_BeforeIncreasingQty("first");
        log.info("FirstItem Price Before Increasing Qty");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "Price_FirstItemBeforeIncreasingQty");
        logger.log(Status.INFO, "FirstItem Price Before Increasing Qty", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "Price_FirstItemBeforeIncreasingQty").build());

        DemoWebShop_CartPage.increaseQuantity("first", update_Qty);
        log.info("First Item Quantity is increased to " + update_Qty);
        logger.log(Status.INFO, "First Item Quantity is increased to " + update_Qty);

        secondItemPrice = DemoWebShop_CartPage.itemPrice_BeforeIncreasingQty("second");
        log.info("SecondItem Price Before Increasing Qty");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "Price_SecondItemBeforeIncreasingQty");
        logger.log(Status.INFO, "SecondItem Price Before Increasing Qty", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "Price_SecondItemBeforeIncreasingQty").build());

        DemoWebShop_CartPage.increaseQuantity("second", update_Qty);
        log.info("Second Item Quantity is increased to " + update_Qty);
        logger.log(Status.INFO, "Second Item Quantity is increased to " + update_Qty);

        DemoWebShop_CartPage.verify_BookTotalPriceChange(update_Qty);
        log.info("Verified Book Item Total price changed");
        logger.log(Status.INFO, "Verified Book Item Total price changed");

        DemoWebShop_CartPage.verify_JewelTotalPriceChange(update_Qty);
        log.info("Verified Jewelery Item Total price changed");
        logger.log(Status.INFO, "Verified Jewelery Item Total price changed");

        DemoWebShop_CartPage.verify_grandTotal();
        log.info("Verified Total price of both Items");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "VerifyGrandTotal");
        logger.log(Status.INFO, "Verified Total price of both Items", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "VerifyGrandTotal").build());

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
            ExcelUtils.setCellData(orderNumber, sheetName, row, Config.col_UpdateCart_OrderNumber);
            log.info(orderNumber + " is written back to the Excel file");
            ExcelUtils.setCellData("PASSED", "Index", row_index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
            logger.log(Status.PASS, "DemoWebShop Update Shopping Cart TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", row_index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", row_index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
                logger.log(Status.FAIL, "DemoWebShop Update Shopping Cart TestCase is Failed and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", row_index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
            logger.log(Status.SKIP, "DemoWebShop Update Shopping Cart TestCase is Skipped and status is updated in Excel sheet");
        }
        driver.quit();
        Log.endTestCase();
    }
}

