package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import testcases.orangeHRM.TC01_OrangeHRM_LoginTest;
import testcases.setup.TestRunner;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static testcases.demoWebshop.TC11_DemoWebshop_ReOrder.sheetName;

public class TC14_DemoWebshop_ApplyDiscount extends TestRunner {

    static String userName,password,ApplyCoupon,orderNumber;
    static int rowNum_testCase,rowNum_Index;
    static Logger log = LogManager.getLogger(TC14_DemoWebshop_ApplyDiscount.class);
    static WebDriver driver;

    private static String base64;
    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.ApplyDiscountRequestTestCase_ID) String testID) throws Exception {

        //To Create the Test in Extent Report
        logger = extent.createTest("ApplyDiscount_"+testID);
        Log.startTestCase(TC14_DemoWebshop_ApplyDiscount.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index =ExcelUtils.getRowNumber(testID,"Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        String sheetName = "DemoWebshop_ApplyDiscount";
        int rowNum = ExcelUtils.getRowNumber(testID,sheetName);
        log.info(rowNum + "Row Number is picked from "+sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName,rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :"+userName);
        password = ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        log.info("Password from excel sheet is:"+password);
        ApplyCoupon = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_ApplyDiscount_Coupon);
        log.info("ApplyCoupon from excel sheet is:"+ApplyCoupon);
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

        DemoWebshop_HomePage.clickLoginLink();
        DemoWebshop_LoginPage.login(userName, password);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath,"DemoWebShop_HomePage");
        logger.log(Status.INFO,"DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"DemoWebShop_HomePage").build());

        DemoWebshop_HomePage.clickLoginLink();
        DemoWebshop_LoginPage.login(userName, password);
        DemoWebshop_BooksPage.clickBooksLink();
        DemoWebshop_BooksPage.clickAddToCartBtn();
        DemoWebshop_HomePage.clickShoppingCartLink();
        double totalValue_BeforeDiscount = DemoWebshop_CartPage.getCartPriceBeforeDiscount();
        DemoWebshop_CartPage.clickTxtbxCoupon();
        DemoWebshop_CartPage.enterTxtbxCoupon(ApplyCoupon);
        DemoWebshop_CartPage.clickApplyCouponBtn();
        DemoWebshop_CartPage.getTxtMessagePrinted();
        double discountValue = DemoWebshop_CartPage.getDiscountAmount();
        double totalValue_AfterDiscount = DemoWebshop_CartPage.getCartPriceAfterDiscount();

        if (totalValue_AfterDiscount == (totalValue_BeforeDiscount - discountValue)) {
            base64 = CommonUtils.takeScreenshot(screenshotsPath,"TotalValue_AfterDiscount");
            logger.log(Status.INFO,"Discount value is correctly applied on Cart and verified", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"TotalValue_AfterDiscount").build());

        } else {
            base64 = CommonUtils.takeScreenshot(screenshotsPath,"Discount_Not_Applied");
            logger.log(Status.INFO,"Discount value is not correctly applied on Cart", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Discount_Not_Applied").build());
        }

        DemoWebshop_CartPage.clickCheckboxIagree();
        DemoWebshop_CartPage.clickCheckoutBtn();
        DemoWebshop_CheckoutPage.clickBillingContinue();
        DemoWebshop_CheckoutPage.clickShippingAddressBtn();
        DemoWebshop_CheckoutPage.clickShippingMethodBtn();
        DemoWebshop_CheckoutPage.clickPaymentMethodBtn();
        DemoWebshop_CheckoutPage.clickPaymentInformationBtn();
        DemoWebshop_CheckoutPage.clickConfirmOrderBtn();

        WebElement element_OrderNumber = driver.findElement(DemoWebshop_CheckoutPage.txt_OrderNumber);
        if (element_OrderNumber.isDisplayed()) {
            orderNumber = element_OrderNumber.getText();
            base64 = CommonUtils.takeScreenshot(screenshotsPath,"orderNumber");
            logger.log(Status.INFO,"order number is generated", MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"orderNumber").build());
            log.info("order number is generated " + orderNumber);
        } else {
            log.info("OrderNumber is not generated");
        }
        DemoWebshop_HomePage.logout();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Log.endTestCase();
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(orderNumber, sheetName, rowNum_testCase, Config.col_ApplyDiscount_OrderNumber);
            log.info(orderNumber + " is written back to the Excel file");

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


