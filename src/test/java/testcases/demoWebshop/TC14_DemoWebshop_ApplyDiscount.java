package testcases.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.*;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static testcases.demoWebshop.TC11_DemoWebshop_ReOrder.sheetName;

public class TC14_DemoWebshop_ApplyDiscount {
    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;
    static XSSFCell cell_ApplyCoupon;
    static String ApplyCoupon;
    static XSSFCell cell_OrderNumber;
    static String orderNumber;
    static FileOutputStream fos;
    static String projectPath;
    static int rowNum_testCase;
    static int rowNum_Index;
    static Logger log = LogManager.getLogger(TC14_DemoWebshop_ApplyDiscount.class);

    @Parameters("{testID}")
    @BeforeClass
    public void prerequisite_setup(@Optional(Config.TestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC14_DemoWebshop_ApplyDiscount.class.getName());
        wbk= ExcelUtils.setExcelFilePath();
        sh = wbk.getSheet("DemoWebshop_ApplyDiscount");
        rowNum_testCase = ExcelUtils.getRowNumber(testID,sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID,"Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_Password);
        ApplyCoupon = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_ApplyDiscount_Coupon);

    }

    @Test
    @Parameters({"browserName"})
    //public static WebDriver TotalOrder() {
    public void TotalOrder(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch("chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get("https://demowebshop.tricentis.com/");
        log.info("Demo website is loaded");

        String title = driver.getTitle();
        log.info("Title of the page is:" + title);

        DemoWebshop_HomePage.clickLoginLink();
        DemoWebshop_LoginPage.login(userName,password);
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
        driver.close();

    }

    @AfterClass
    public void tearDown() throws Exception {

        cell_OrderNumber = row.getCell(6);
        if (cell_OrderNumber == null) {
            cell_OrderNumber = row.createCell(6);
        }
        cell_OrderNumber.setCellValue(orderNumber);
        fos = new FileOutputStream(projectPath + "\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
       log.info(orderNumber + " is written back to the Excel file");

        fos.close();
        log.info("ExcelFile Writing is closed");
        fis.close();
        log.info("ExcelFile reading is closed");
    }
}


