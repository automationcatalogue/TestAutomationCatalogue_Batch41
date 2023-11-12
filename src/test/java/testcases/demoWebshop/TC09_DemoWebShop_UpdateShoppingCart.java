package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import testcases.setup.TestRunner;
import utilities.*;

public class TC09_DemoWebShop_UpdateShoppingCart extends TestRunner {
    XSSFWorkbook wbk;
    static int row,rowNum_Index,row_index;
    static String userName,passWord,jewel_Length,update_Qty,orderNumber,total_1,total_2,text_BookPrice,text_updatedQuty,text_JewelPrice,sheetName;
    static Logger log = LogManager.getLogger(TC09_DemoWebShop_UpdateShoppingCart.class);
    static WebDriver driver;

    private static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_Setup(@Optional(Config.UpdateShoppingCartRequestTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC09_DemoWebShop_UpdateShoppingCart.class.getName());

        //To Create the Test in Extent Report
        logger = extent.createTest("UpdateShoppingCart_"+testID);
        Log.startTestCase(TC09_DemoWebShop_UpdateShoppingCart.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index =ExcelUtils.getRowNumber(testID,"Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        String sheetName = "DemoWebshop_UpdateShoppingCart";
        int rowNum = ExcelUtils.getRowNumber(testID,sheetName);
        log.info(rowNum + "Row Number is picked from "+sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName,rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :"+userName);
        passWord = ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        log.info("Password from excel sheet is:"+passWord);
        jewel_Length = ExcelUtils.getCellData(sheetName, row, Config.col_UpdateCart_Length);
        log.info("jewel_Length from excel sheet is:"+jewel_Length);
        update_Qty = ExcelUtils.getCellData(sheetName, row, Config.col_UpdateCart_Quantity);
        log.info("update_Qty from excel sheet is:"+update_Qty);

    }

    @Test
    @Parameters({"browserName"})
    public void Update_ShoppingCart(@Optional("chrome") String browserName) throws Exception {
        driver = CommonUtils.browserLaunch("Chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get(Config.demoWebshop_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_LoginPage");
        log.info("DemoWebShop URL is loaded :"+Config.demoWebshop_URL);
        logger.log(Status.INFO,"DemoWebShop Application is loaded"+Config.demoWebshop_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_LoginPage").build());


        DemoWebshop_LoginPage.login(userName, passWord);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_HomePage");
        logger.log(Status.INFO,"DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_HomePage").build());

        DemoWebshop_HomePage.select_BooksLink();
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_BooksLink");
        logger.log(Status.INFO,"BooksLink is Clicked", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_BooksLink").build());

        DemoWebshop_BooksPage.adding_FirstBookToCart();
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"Adding_FirstBookToCart");
        logger.log(Status.INFO,"FirstBook is added to Cart", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Adding_FirstBookToCart").build());

        DemoWebshop_HomePage.select_JewelsLink();
        DemoWebshop_JewelsPage.adding_firstJewelToCart(jewel_Length);
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"Adding_firstJewelToCart");
        logger.log(Status.INFO,"Added firstJewel To Cart", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Adding_firstJewelToCart").build());

        DemoWebshop_HomePage.select_ShoppingCart();
        total_1 = DemoWebshop_CartPage.price_FirstItemBeforeIncreasingQty();
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"Price_FirstItemBeforeIncreasingQty");
        logger.log(Status.INFO,"FirstItem Price Before Increasing Qty", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Price_FirstItemBeforeIncreasingQty").build());

        DemoWebshop_CartPage.price_FirstItemAfterIncreasingQty(update_Qty);
        total_2 = DemoWebshop_CartPage.price_SecondItemBeforeIncreasingQty();
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"Price_FirstItemAfterIncreasingQty");
        logger.log(Status.INFO,"FirstItem Price After Increasing Qty", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"price_FirstItemAfterIncreasingQty").build());

        DemoWebshop_CartPage.price_SecondItemAfterIncreasingQty(update_Qty);
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"Price_SecondItemAfterIncreasingQty");
        logger.log(Status.INFO,"SecondItem Price After Increasing Qty", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"price_SecondItemAfterIncreasingQty").build());

        DemoWebshop_CartPage.select_updateCartButton();
        text_BookPrice = DemoWebshop_CartPage.price_textBook();
        text_updatedQuty = DemoWebshop_CartPage.updatedQty_Text();
        DemoWebshop_CartPage.verify_BookTotalPriceChange(update_Qty, text_BookPrice, text_updatedQuty);
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"BookTotalPriceChange");
        logger.log(Status.INFO,"Chceking whether TotalPrice is Changed or not", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"BookTotalPriceChange").build());

        text_JewelPrice = DemoWebshop_CartPage.price_Jewel();
        DemoWebshop_CartPage.verify_JewelTotalPriceChange(update_Qty, text_JewelPrice, text_updatedQuty);
        DemoWebshop_CartPage.verify_grandTotal();
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"verify_grandTotal");
        logger.log(Status.INFO,"Verfifing Grand Total", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"verify_grandTotal").build());
        DemoWebshop_CartPage.select_checkOut();
        orderNumber = DemoWebshop_CheckoutPage.checking_paymentGateway();
        DemoWebshop_HomePage.logout();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Log.endTestCase();
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(orderNumber, sheetName, row, Config.col_UpdateCart_OrderNumber);
            log.info(orderNumber + " is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index", row_index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", row_index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", row_index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", row_index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        driver.quit();
        ExcelUtils.closeExcelFile();
        Log.endTestCase();
    }
}

