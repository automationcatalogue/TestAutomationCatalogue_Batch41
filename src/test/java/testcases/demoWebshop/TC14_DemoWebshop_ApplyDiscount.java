package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.*;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

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

    @BeforeClass
    public void prerequisite_setup() throws Exception {
        wbk= ExcelUtils.setExcelFilePath();
        sh = wbk.getSheet("DemoWebshop_ApplyDiscount");
        rowNum_testCase = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(Config.TestCase_ID,"Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_Password);
        ApplyCoupon = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_ApplyCoupon);

    }

    @Test
    @Parameters({"browserName"})
    //public static WebDriver TotalOrder() {
    public void TotalOrder(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch("chrome");

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Demo website is loaded");

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
            System.out.println("Discount value is correctly applied on Cart and verified");
        } else {
            System.out.println("Discount value is not correctly applied on Cart");
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
            System.out.println("order number is generated " + orderNumber);
        } else {
            System.out.println("OrderNumber is not generated");
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
        System.out.println(orderNumber + " is written back to the Excel file");

        fos.close();
        System.out.println("ExcelFile Writing is closed");
        fis.close();
        System.out.println("ExcelFile reading is closed");
    }
}


