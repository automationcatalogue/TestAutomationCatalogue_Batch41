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
        String total_BeforeDiscount=driver.findElement(DemoWebshop_CartPage.txt_BeforeDiscountTotal).getText();
        System.out.println("value of total:"+total_BeforeDiscount);
        double totalValue_BeforeDiscount = Double.parseDouble(total_BeforeDiscount);
        return totalValue_BeforeDiscount;
    }
    public static void clickCheckboxIagree(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(checkbox_Iagree).click();
        System.out.println("Check-box is clicked");
    }
    public  static void clickCheckoutBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Checkout).click();
        System.out.println("Checkout button is clicked");
    }
    public static void clickTxtbxCoupon(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txtbx_Coupon).click();
        System.out.println("coupon test box is clicked");
    }
    public static void enterTxtbxCoupon(String ApplyCoupon){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txt_EnterCoupon).sendKeys(ApplyCoupon);
        System.out.println("coupon code is Entered");
    }
    public static void clickApplyCouponBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_ApplyCoupon).click();
        System.out.println("ApplyCoupon button is clicked");
    }

    public static void getTxtMessagePrinted(){
        WebDriver driver = BaseClass.getDriver();
        String message = driver.findElement(DemoWebshop_CartPage.getTxt_MessagePrinted).getText();
        System.out.println("message:" + message);
        if (message.trim().equalsIgnoreCase("The coupon code was applied")) {
            System.out.println("Coupon applied successfully");
        } else {
            System.out.println("Coupon applied is not successful");
        }
    }
    public static double getDiscountAmount(){
        WebDriver driver = BaseClass.getDriver();
        String discount = driver.findElement(DemoWebshop_CartPage.txt_DiscountAmount).getText();
        System.out.println("Applied Discount Amount is :" + discount);
        double discountValue = Double.parseDouble(discount);
        return discountValue;
    }
    public static double getCartPriceAfterDiscount() {
        WebDriver driver = BaseClass.getDriver();
        String total_AfterDiscount = driver.findElement(DemoWebshop_CartPage.txt_AfterDiscountTotal).getText();
        System.out.println("After discount value of total:" + total_AfterDiscount);
        double totalValue_AfterDiscount = Double.parseDouble(total_AfterDiscount);
        return totalValue_AfterDiscount;
    }

}
