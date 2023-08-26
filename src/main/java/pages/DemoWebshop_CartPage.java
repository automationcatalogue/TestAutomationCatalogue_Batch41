package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    static Logger log = LogManager.getLogger(DemoWebshop_CartPage.class);
    public static double getCartPriceBeforeDiscount(){
        WebDriver driver = BaseClass.getDriver();
        String total_BeforeDiscount=driver.findElement(txt_BeforeDiscountTotal).getText();
        log.info("value of total:"+total_BeforeDiscount);
        double totalValue_BeforeDiscount = Double.parseDouble(total_BeforeDiscount);
        return totalValue_BeforeDiscount;
    }
    public static void clickCheckboxIagree(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(checkbox_Iagree).click();
        log.info("Check-box is clicked");
    }
    public  static void clickCheckoutBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Checkout).click();
        log.info("Checkout button is clicked");
    }
    public static void clickTxtbxCoupon(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txtbx_Coupon).click();
        log.info("coupon test box is clicked");
    }
    public static void enterTxtbxCoupon(String ApplyCoupon){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txt_EnterCoupon).sendKeys(ApplyCoupon);
        log.info("coupon code is Entered");
    }
    public static void clickApplyCouponBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_ApplyCoupon).click();
        log.info("ApplyCoupon button is clicked");
    }

    public static void getTxtMessagePrinted(){
        WebDriver driver = BaseClass.getDriver();
        String message = driver.findElement(DemoWebshop_CartPage.getTxt_MessagePrinted).getText();
        log.info("message:" + message);
        if (message.trim().equalsIgnoreCase("The coupon code was applied")) {
            log.info("Coupon applied successfully");
        } else {
            log.info("Coupon applied is not successful");
        }
    }
    public static double getDiscountAmount(){
        WebDriver driver = BaseClass.getDriver();
        String discount = driver.findElement(DemoWebshop_CartPage.txt_DiscountAmount).getText();
        log.info("Applied Discount Amount is :" + discount);
        double discountValue = Double.parseDouble(discount);
        return discountValue;
    }
    public static double getCartPriceAfterDiscount() {
        WebDriver driver = BaseClass.getDriver();
        String total_AfterDiscount = driver.findElement(DemoWebshop_CartPage.txt_AfterDiscountTotal).getText();
        log.info("After discount value of total:" + total_AfterDiscount);
        double totalValue_AfterDiscount = Double.parseDouble(total_AfterDiscount);
        return totalValue_AfterDiscount;
    }

    public static String price_FirstItemBeforeIncreasingQty(){
        WebDriver driver = BaseClass.getDriver();
        WebElement total1 = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal);
        String total_1 = total1.getText();
        log.info("Total of the first item before increasing the quantity is :" + total_1);
        return total_1;
    }

    public static void price_FirstItemAfterIncreasingQty(String Update){
        WebDriver driver = BaseClass.getDriver();
        WebElement books_qty1 = driver.findElement(DemoWebshop_CartPage.txtbx_FirstItemQty);
        books_qty1.clear();
        books_qty1.sendKeys(Update);
        log.info("Quantity is increased in first item");
    }

    public static String price_SecondItemBeforeIncreasingQty(){
        WebDriver driver = BaseClass.getDriver();
        WebElement total2 = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal);
        String total_2 = total2.getText();
        log.info("Total of the second item before increasing the quantity is :" + total_2);
        return total_2;
    }

    public static void price_SecondItemAfterIncreasingQty(String Update){
        WebDriver driver = BaseClass.getDriver();
        WebElement jewel_qty2 = driver.findElement(DemoWebshop_CartPage.txtbx_SecondItemQty);
        jewel_qty2.clear();
        jewel_qty2.sendKeys(Update);
        log.info("Quantity is increased in second item");
    }

    public static void select_updateCartButton(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_CartPage.btn_UpdateShopCart).click();
        log.info("Clicked on the Update cart button");
    }

    public static String price_textBook(){
        WebDriver driver = BaseClass.getDriver();
        String text_BookPrice = driver.findElement(DemoWebshop_CartPage.txt_PriceFirstItem).getText();
        return text_BookPrice;
    }

    public static String updatedQty_Text(){
        WebDriver driver = BaseClass.getDriver();
        String text_updatedQuty = driver.findElement(DemoWebshop_CartPage.txtbx_FirstItemQty).getAttribute("value");
        return text_updatedQuty;
    }

    public static void verify_BookTotalPriceChange(String updateQty,String text_BookPrice,String text_updatedQty){
        WebDriver driver = BaseClass.getDriver();
        if(updateQty.equalsIgnoreCase(text_updatedQty)){

            log.info("Update Quantity is successful for Book Item!!!");
            String text_BookTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal).getText();

            double bookPrice = Double.parseDouble(text_BookPrice);
            double UpdateQty = Double.parseDouble(text_updatedQty);
            double bookTotalPrice = Double.parseDouble(text_BookTotalPrice);
            double expectedTotalPrice = bookPrice * UpdateQty;
            if(expectedTotalPrice == bookTotalPrice){
                log.info("Update Shopping Cart is successful for Book Item and Price is matched i.e :"+bookTotalPrice);
            }else{
                log.info("Update Shopping Cart is not successful for Book Item and Price is not matched!!!");
            }

        }else{
            log.info("Update Quantity is not successful for Book Item!!!");
        }
    }

    public static String price_Jewel(){
        WebDriver driver = BaseClass.getDriver();
        String text_JewelPrice = driver.findElement(DemoWebshop_CartPage.txt_PriceSecondItem).getText();
        return text_JewelPrice;
    }

    public static void verify_JewelTotalPriceChange(String updateQty,String text_JewelPrice,String text_updatedQty){
        WebDriver driver = BaseClass.getDriver();
        if(updateQty.equalsIgnoreCase(text_updatedQty)){

            log.info("Update Quantity is successful for Jewel Item!!!");
            String text_JewelTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal).getText();

            double JewelPrice = Double.parseDouble(text_JewelPrice);
            double UpdateQty = Double.parseDouble(text_updatedQty);
            double JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);

            double expectedTotalPrice = JewelPrice * UpdateQty;
            if(expectedTotalPrice == JewelTotalPrice){
                log.info("Update Shopping Cart is successful for Jewel Item and Price is matched i.e :"+JewelTotalPrice);
            }else{
                log.info("Update Shopping Cart is not successful for Jewel Item and Price is not matched!!!");
            }

        }else{
            log.info("Update Quantity is not successful for Jewel Item!!!");
        }
    }

    public static void verify_grandTotal(){
        WebDriver driver = BaseClass.getDriver();
        String text_BookTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal).getText();
        double dou_BookTotalPrice = Double.parseDouble(text_BookTotalPrice);
        String text_JewelTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal).getText();
        double dou_JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);


        double grandTotal=dou_BookTotalPrice+dou_JewelTotalPrice;
        String actualTotal=driver.findElement(DemoWebshop_CartPage.txt_ActualGrandTotal).getText();
        double TOTAL=Double.parseDouble(actualTotal);

        if(grandTotal==TOTAL){
            System.out.println("Cart total is accurate i.e :"+TOTAL);
        }else{
            System.out.println("Cart total is not accurate");
        }
    }

    public static void select_checkOut(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_CartPage.checkbox_Iagree).click();
        log.info("Check-box is clicked");

        driver.findElement(DemoWebshop_CartPage.btn_Checkout).click();
        log.info("Checkout button is clicked");
    }
}
