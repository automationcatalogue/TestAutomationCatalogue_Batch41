package pages;

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

    public static double getCartPriceBeforeDiscount(){
        WebDriver driver = BaseClass.getDriver();
        String total_BeforeDiscount=driver.findElement(txt_BeforeDiscountTotal).getText();
        System.out.println("value of total:"+total_BeforeDiscount);
        double totalValue_BeforeDiscount = Double.parseDouble(total_BeforeDiscount);
        return totalValue_BeforeDiscount;
    }

    public static String price_FirstItemBeforeIncreasingQty(){
        WebDriver driver = BaseClass.getDriver();
        WebElement total1 = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal);
        String total_1 = total1.getText();
        System.out.println("Total of the first item before increasing the quantity is :" + total_1);
        return total_1;
    }

    public static void price_FirstItemAfterIncreasingQty(String Update){
        WebDriver driver = BaseClass.getDriver();
        WebElement books_qty1 = driver.findElement(DemoWebshop_CartPage.txtbx_FirstItemQty);
        books_qty1.clear();
        books_qty1.sendKeys(Update);
        System.out.println("Quantity is increased in first item");
    }

    public static String price_SecondItemBeforeIncreasingQty(){
        WebDriver driver = BaseClass.getDriver();
        WebElement total2 = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal);
        String total_2 = total2.getText();
        System.out.println("Total of the second item before increasing the quantity is :" + total_2);
        return total_2;
    }

    public static void price_SecondItemAfterIncreasingQty(String Update){
        WebDriver driver = BaseClass.getDriver();
        WebElement jewel_qty2 = driver.findElement(DemoWebshop_CartPage.txtbx_SecondItemQty);
        jewel_qty2.clear();
        jewel_qty2.sendKeys(Update);
        System.out.println("Quantity is increased in second item");
    }

    public static void select_updateCartButton(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_CartPage.btn_UpdateShopCart).click();
        System.out.println("Clicked on the Update cart button");
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

            System.out.println("Update Quantity is successful for Book Item!!!");
            String text_BookTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal).getText();

            double bookPrice = Double.parseDouble(text_BookPrice);
            double UpdateQty = Double.parseDouble(text_updatedQty);
            double bookTotalPrice = Double.parseDouble(text_BookTotalPrice);
            double expectedTotalPrice = bookPrice * UpdateQty;
            if(expectedTotalPrice == bookTotalPrice){
                System.out.println("Update Shopping Cart is successful for Book Item and Price is matched i.e :"+bookTotalPrice);
            }else{
                System.out.println("Update Shopping Cart is not successful for Book Item and Price is not matched!!!");
            }

        }else{
            System.out.println("Update Quantity is not successful for Book Item!!!");
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

            System.out.println("Update Quantity is successful for Jewel Item!!!");
            String text_JewelTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal).getText();

            double JewelPrice = Double.parseDouble(text_JewelPrice);
            double UpdateQty = Double.parseDouble(text_updatedQty);
            double JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);

            double expectedTotalPrice = JewelPrice * UpdateQty;
            if(expectedTotalPrice == JewelTotalPrice){
                System.out.println("Update Shopping Cart is successful for Jewel Item and Price is matched i.e :"+JewelTotalPrice);
            }else{
                System.out.println("Update Shopping Cart is not successful for Jewel Item and Price is not matched!!!");
            }

        }else{
            System.out.println("Update Quantity is not successful for Jewel Item!!!");
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
        System.out.println("Check-box is clicked");

        driver.findElement(DemoWebshop_CartPage.btn_Checkout).click();
        System.out.println("Checkout button is clicked");
    }
}
