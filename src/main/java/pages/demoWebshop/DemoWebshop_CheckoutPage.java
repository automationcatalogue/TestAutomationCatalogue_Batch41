package pages.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import utilities.BaseClass;

public class DemoWebshop_CheckoutPage {

    static Logger log = LogManager.getLogger(DemoWebshop_CheckoutPage.class);

    public static By btn_BillingContinue = By.xpath("//input[@onclick='Billing.save()']");
    public static By btn_ShippingAddress = By.xpath("//input[@onclick='Shipping.save()']");
    public static By btn_ShippingMethod  = By.xpath("//input[@onclick='ShippingMethod.save()']");
    public static By btn_PaymentMethod   = By.xpath("//input[@onclick='PaymentMethod.save()']");
    public static By btn_PaymentInformation = By.xpath("//input[@onclick='PaymentInfo.save()']");
    public static By btn_ConfirmOrder   = By.xpath("//input[@onclick='ConfirmOrder.save()']");
    public static By txt_OrderNumber    = By.xpath("//ul[@class='details']/li[1]");

    static String orderNumber;

    public static void placeOrder(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_BillingContinue).click();
        log.info("Continue button is clicked under Billing Address");
        driver.findElement(btn_ShippingAddress).click();
        log.info("Continue button is clicked under Shipping Address");
        driver.findElement(btn_ShippingMethod).click();
        log.info("Continue button is clicked under Shipping Method");
        driver.findElement(btn_PaymentMethod).click();
        log.info("Continue button is clicked under Payment Method");
        driver.findElement(btn_PaymentInformation).click();
        log.info("Continue button is clicked under Payment Information");
        driver.findElement(btn_ConfirmOrder).click();
        log.info("Confirm button is clicked under Confirm Order");
    }

    public static String getOrderNumber(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txt_OrderNumber).getText();
        WebElement element_OrderNumber = driver.findElement(DemoWebshop_CheckoutPage.txt_OrderNumber);
        String orderNumber = element_OrderNumber.getText();
        log.info("order number is generated " + orderNumber);
        return orderNumber;
    }
}
