package testcases.demoWebshop;

import javaPrograms.assignments.Assignment_16.D;
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

public class TC18_DemoWebshop_ApplyDiscount {
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

        @BeforeClass
        public void prerequisite_setup() throws Exception {
                System.out.println("Pre Requisites Setup");
                System.out.println("Apply discount testcase");
                projectPath = System.getProperty("user.dir");
                fis = new FileInputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
                wbk = new XSSFWorkbook(fis);
                sh = wbk.getSheet("DemoWebshop_ApplyDiscount");
                row = sh.getRow(1);

                cell_userName = row.getCell(3);
                userName = cell_userName.getStringCellValue();
                System.out.println("UserName from excel sheet is :" + userName);

                cell_password = row.getCell(4);
                password = cell_password.getStringCellValue();
                System.out.println("Password from excel sheet is:" + password);

                cell_ApplyCoupon =row.getCell(5);
                ApplyCoupon = cell_ApplyCoupon.getStringCellValue();
                System.out.println("ApplyCoupon from excel sheet is:" + ApplyCoupon);

        }

    @Test
    @Parameters({"browserName"})
    //public static WebDriver TotalOrder() {
    public void TotalOrder(@Optional("chrome") String browserName) throws Exception{

            WebDriver driver = CommonUtils.browserLaunch("chrome");

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

            driver.findElement(DemoWebshop_BooksPage.link_Books).click();
            System.out.println("Books link is clicked");

            driver.findElement(DemoWebshop_BooksPage.btn_AddToCart).click();
            System.out.println("Add to cart button is clicked");

            driver.findElement(DemoWebshop_HomePage.link_ShoppingCart).click();
            System.out.println("Shopping cart link is clicked");

            String total_BeforeDiscount=driver.findElement(DemoWebshop_CartPage.txt_BeforeDiscountTotal).getText();
            System.out.println("value of total:"+total_BeforeDiscount);
            double totalValue_BeforeDiscount = Double.parseDouble(total_BeforeDiscount);

            driver.findElement(DemoWebshop_CartPage.txtbx_Coupon).click();
            System.out.println("coupon test box is clicked");

            driver.findElement(DemoWebshop_CartPage.txt_EnterCoupon).sendKeys(ApplyCoupon);
            System.out.println("coupon code is Entered");

            driver.findElement(DemoWebshop_CartPage.btn_ApplyCoupon).click();
            System.out.println("ApplyCoupon button is clicked");

            String message=driver.findElement(DemoWebshop_CartPage.getTxt_MessagePrinted).getText();
            System.out.println("message:"+message);
            if(message.trim().equalsIgnoreCase("The coupon code was applied")){
                System.out.println("Coupon applied successfully");
            }else{
                System.out.println("Coupon applied is not successful");
            }

            String discount = driver.findElement(DemoWebshop_CartPage.txt_DiscountAmount).getText();
            System.out.println("Applied Discount Amount is :"+discount);
            double discountValue = Double.parseDouble(discount);

            String total_AfterDiscount=driver.findElement(DemoWebshop_CartPage.txt_AfterDiscountTotal).getText();
            System.out.println("After discount value of total:"+total_AfterDiscount);
            double totalValue_AfterDocunt = Double.parseDouble(total_AfterDiscount);

            if(totalValue_AfterDocunt == (totalValue_BeforeDiscount-discountValue)){
                System.out.println("Discount value is correctly applied on Cart and verified");
            }else{
                System.out.println("Discount value is not correctly applied on Cart");
            }

            driver.findElement(DemoWebshop_CartPage.checkbox_Iagree).click();
            System.out.println("check-box is clicked");

            driver.findElement(DemoWebshop_CartPage.btn_Checkout).click();
            System.out.println("Checkout is clicked");

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
            if(element_OrderNumber.isDisplayed()){
                    orderNumber = element_OrderNumber.getText();
                System.out.println("order number is generated "+orderNumber);
            }else{
                System.out.println("OrderNumber is not generated");
            }

            driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
            System.out.println("log out is clicked");

            driver.close();

        }

        @AfterClass
        public void tearDown() throws Exception {

                cell_OrderNumber = row.getCell(6);
                if(cell_OrderNumber==null){
                        cell_OrderNumber=row.createCell(6);
                }
                cell_OrderNumber.setCellValue(orderNumber);
                fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
                wbk.write(fos);
                System.out.println(orderNumber+" is written back to the Excel file");

                fos.close();
                System.out.println("ExcelFile Writing is closed");
                fis.close();
                System.out.println("ExcelFile reading is closed");
        }
}


