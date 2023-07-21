package testcases.demoWebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utilities.CommonUtils;

import java.time.Duration;

public class TC14_DemoWebshop_ReOrder {
    @Test
    @Parameters({"browserName"})
    public static void ReOrder(@Optional("chrome")String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch(browserName);

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Demo website is loaded");

        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        System.out.println("Login link is clicked");

        driver.findElement(DemoWebshop_LoginPage.txtbx_UserName).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email ID is entered");

        driver.findElement(DemoWebshop_LoginPage.txtbx_Password).sendKeys("Admin@123");
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
        if(element_OrderNumber.isDisplayed()){
            String ordernumber = element_OrderNumber.getText();
            System.out.println("order number is generated "+ordernumber);
        }else{
            System.out.println("OrderNumber is not generated");
        }

        driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
        System.out.println("log out is clicked");

        driver.close();

    }
}
