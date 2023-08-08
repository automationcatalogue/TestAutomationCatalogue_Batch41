package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_CartPage {
    public static By txt_FirstItemTotal = By.xpath("(//table[@class='cart']/tbody/tr)[1]/td[6]/span[2]");
    public static By txtbx_FirstItemQty = By.xpath("(//table[@class='cart']/tbody/tr/td[5]/input)[1]");
    public static By txt_SecondItemTotal = By.xpath("(//table[@class='cart']/tbody/tr)[2]/td[6]/span[2]");
    public static By txtbx_SecondItemQty = By.xpath("//table[@class='cart']/tbody/tr[2]/td[5]/input");
    public static By btn_UpdateShopCart = By.xpath("//input[@value='Update shopping cart']");
    public static By txt_PriceFirstItem = By.xpath("//table[@class='cart']/tbody/tr/td[4]/span[2]");

    public static By txt_PriceSecondItem = By.xpath("//table[@class='cart']/tbody/tr[2]/td[4]/span[2]");
    public static By txt_ActualGrandTotal = By.xpath("//table[@class='cart-total']//tr[4]/td[2]/span/span");

    public static By txtbx_Address = By.xpath("(//a[text()='Addresses'])[1]");
    public static By Link_Address = By.xpath("//div[contains(@class,'st-page')]/div[2]/div[1]/div/div[1]");

    public static By txt_BeforeDiscountTotal = By.xpath("//span[@class='product-price order-total']/strong");
    public static By txtbx_Coupon = By.xpath("(//div[@class='coupon-code']//input)[1]");
    public static By txt_EnterCoupon = By.xpath("//input[@name='discountcouponcode']");
    public static By btn_ApplyCoupon = By.xpath("//input[@name='applydiscountcouponcode']");
    public static By getTxt_MessagePrinted = By.xpath("//div[@class='message']");
    public static By txt_DiscountAmount = By.xpath("//span[contains(text(),'Discount')]/..//following-sibling::td/span/span");
    public static By txt_AfterDiscountTotal = By.xpath("//span[@class='product-price order-total']/strong");
    public static By checkbox_Iagree = By.xpath("//input[@id='termsofservice']");
    public static By btn_Checkout = By.xpath("//button[@value='checkout']");

    public static double getCartPriceBeforeDiscount(){
        WebDriver driver = BaseClass.getDriver();
        String total_BeforeDiscount=driver.findElement(txt_BeforeDiscountTotal).getText();
        System.out.println("value of total:"+total_BeforeDiscount);
        double totalValue_BeforeDiscount = Double.parseDouble(total_BeforeDiscount);
        return totalValue_BeforeDiscount;
    }

}
