package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;

import utilities.BaseClass;

public class DemoWebshop_CheckoutPage {
    public static By btn_BillingContinue = By.xpath("//input[@onclick='Billing.save()']");
    public static By btn_ShippingAddress = By.xpath("//input[@onclick='Shipping.save()']");
    public static By btn_ShippingMethod  = By.xpath("//input[@onclick='ShippingMethod.save()']");
    public static By btn_PaymentMethod   = By.xpath("//input[@onclick='PaymentMethod.save()']");
    public static By btn_PaymentInformation = By.xpath("//input[@onclick='PaymentInfo.save()']");
    public static By btn_ConfirmOrder   = By.xpath("//input[@onclick='ConfirmOrder.save()']");
    public static By txt_OrderNumber    = By.xpath("//ul[@class='details']/li[1]");


    public static void clickBillingContinue(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_BillingContinue).click();
        System.out.println("Continue button is clicked under Billing Address");
    }
    public static void clickShippingAddressBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_ShippingAddress).click();
        System.out.println("Continue button is clicked under Shipping Address");
    }
    public static void clickShippingMethodBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_ShippingMethod).click();
        System.out.println("Continue button is clicked under Shipping Method");
    }
    public static void clickPaymentMethodBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_PaymentMethod).click();
        System.out.println("Continue button is clicked under Payment Method");
    }
    public static void clickPaymentInformationBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_PaymentInformation).click();
        System.out.println("Continue button is clicked under Payment Information");
    }
    public static void clickConfirmOrderBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_ConfirmOrder).click();
        System.out.println("Confirm button is clicked under Confirm Order");
    }
    public static void getOrderNumber(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txt_OrderNumber).getText();
        WebElement element_OrderNumber = driver.findElement(DemoWebshop_CheckoutPage.txt_OrderNumber);
        if (element_OrderNumber.isDisplayed()) {
            String orderNumber = element_OrderNumber.getText();
            System.out.println("order number is generated " + orderNumber);
        } else {
            System.out.println("OrderNumber is not generated");
        }

    }

    static String orderNumber;
    public static String checking_paymentGateway(){
        WebDriver driver = BaseClass.getDriver();
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

        orderNumber = driver.findElement(DemoWebshop_CheckoutPage.txt_OrderNumber).getText();
        System.out.println("Order Number:"+orderNumber);

        return orderNumber;
    }

}
