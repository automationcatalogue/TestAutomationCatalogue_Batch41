package pages;

import org.openqa.selenium.By;

public class DemoWebshop_CheckoutPage {
    public static By btn_BillingContinue = By.xpath("//input[@onclick='Billing.save()']");
    public static By btn_ShippingAddress = By.xpath("//input[@onclick='Shipping.save()']");
    public static By btn_ShippingMethod  = By.xpath("//input[@onclick='ShippingMethod.save()']");
    public static By btn_PaymentMethod   = By.xpath("//input[@onclick='PaymentMethod.save()']");
    public static By btn_PaymentInformation = By.xpath("//input[@onclick='PaymentInfo.save()']");
    public static By btn_ConfirmOrder   = By.xpath("//input[@onclick='ConfirmOrder.save()']");
    public static By txt_OrderNumber    = By.xpath("//ul[@class='details']/li[1]");
}
