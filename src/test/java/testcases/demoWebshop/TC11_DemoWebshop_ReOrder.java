package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

public class TC11_DemoWebshop_ReOrder {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;
    static XSSFCell cell_OrderNumber;
    static String orderNumber;
    static FileOutputStream fos;
    static String projectPath;
    static String sheetName;
    static int rowNum;

    @BeforeClass
    public void prerequisite_setup() throws Exception {
        wbk= ExcelUtils.setExcelFilePath();
        sheetName = "DemoWebshop_ReOrder";
        rowNum = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        System.out.println("UserName from excel sheet is :" + userName);

        password = ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        System.out.println("Password from excel sheet is:" + password);

    }

    @Test
    @Parameters({"browserName"})
    public static void ReOrder(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch(browserName);

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Demo website is loaded");

        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        System.out.println("Login link is clicked");

        driver.findElement(DemoWebshop_LoginPage.txtbx_UserName).sendKeys(userName);
        System.out.println("Email ID is entered");

        driver.findElement(DemoWebshop_LoginPage.txtbx_Password).sendKeys(password);
        System.out.println("Password is entered");

        driver.findElement(DemoWebshop_LoginPage.btn_Login).click();
        System.out.println("Login Button is clicked");

        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        System.out.println("Email Link is clicked");

        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        System.out.println("Order link is clicked");

        driver.findElement(DemoWebShop_OrdersPage.btn_OrderDetails).click();
        System.out.println("Order details button is clicked");

        driver.findElement(DemoWebshop_OrderInformationPage.btn_Reorder).click();
        System.out.println("Re-order button is clicked");

        driver.findElement(DemoWebshop_CartPage.checkbox_Iagree).click();
        System.out.println("Check-box is clicked");

        driver.findElement(DemoWebshop_CartPage.btn_Checkout).click();
        System.out.println("Checkout button is clicked");

        driver.findElement(DemoWebshop_CheckoutPage.btn_BillingContinue).click();
        System.out.println("Continue button is clicked under Billing Address");

        driver.findElement(DemoWebshop_CheckoutPage.btn_ShippingAddress).click();
        System.out.println("Continue button is clicked under Shipping Address");

        driver.findElement(DemoWebshop_CheckoutPage.btn_ShippingMethod).click();
        System.out.println("Continue button is clicked under Shipping Method");

        driver.findElement(DemoWebshop_CheckoutPage.btn_PaymentMethod).click();
        System.out.println("Continue button is clicked under Payment Method");

        driver.findElement(DemoWebshop_CheckoutPage.btn_PaymentInformation).click();
        System.out.println("Continue button is clicked under Payment Information");

        driver.findElement(DemoWebshop_CheckoutPage.btn_ConfirmOrder).click();
        System.out.println("Confirm button is clicked under Confirm Order");

        WebElement element_OrderNumber = driver.findElement(DemoWebshop_CheckoutPage.txt_OrderNumber);
        if (element_OrderNumber.isDisplayed()) {
            orderNumber = element_OrderNumber.getText();
            System.out.println("order number is generated " + orderNumber);
        } else {
            System.out.println("OrderNumber is not generated");
        }

        driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
        System.out.println("log out is clicked");

        driver.close();

    }

    @AfterClass
    public void tearDown() throws Exception {

        ExcelUtils.setCellData(orderNumber, sheetName, rowNum, Config.col_Reorder_OrderNumber);
        System.out.println(orderNumber+" is written back to the Excel file");

        fis.close();
        System.out.println("ExcelFile reading is closed");
    }
}
