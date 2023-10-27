package testcases.demoWebshop;

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
import testcases.setup.TestRunner;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static testcases.demoWebshop.TC11_DemoWebshop_ReOrder.sheetName;

public class TC14_DemoWebshop_ApplyDiscount extends TestRunner {
    static XSSFWorkbook wbk;
    static String userName;
    static String password;
    static String ApplyCoupon;
    static String orderNumber;
    static int rowNum_testCase;
    static int rowNum_Index;
    static Logger log = LogManager.getLogger(TC14_DemoWebshop_ApplyDiscount.class);
    static WebDriver driver;
    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.ApplyDiscountRequestTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC14_DemoWebshop_ApplyDiscount.class.getName());

        sheetName = "DemoWebshop_ApplyDiscount";
        rowNum_testCase = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_Password);
        ApplyCoupon = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_ApplyDiscount_Coupon);
    }

    @Test
    @Parameters({"browserName"})
    public void TotalOrder(@Optional("chrome") String browserName) throws Exception {
        driver = CommonUtils.browserLaunch("chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get("https://demowebshop.tricentis.com/");
        log.info("Demo website is loaded");

        String title = driver.getTitle();
        log.info("Title of the page is:" + title);

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
            log.info("Discount value is correctly applied on Cart and verified");
        } else {
            log.info("Discount value is not correctly applied on Cart");
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


