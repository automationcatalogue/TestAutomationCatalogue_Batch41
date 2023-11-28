package pages.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BaseClass;

public class DemoWebShop_CartPage {

    static Logger log = LogManager.getLogger(DemoWebShop_CartPage.class);

    public static By txt_FirstItemTotal = By.xpath("(//table[@class='cart']/tbody/tr)[1]/td[6]/span[2]");
    public static By txtbx_FirstItemQty = By.xpath("(//table[@class='cart']/tbody/tr/td[5]/input)[1]");
    public static By txt_SecondItemTotal = By.xpath("(//table[@class='cart']/tbody/tr)[2]/td[6]/span[2]");
    public static By txtbx_SecondItemQty = By.xpath("//table[@class='cart']/tbody/tr[2]/td[5]/input");
    public static By btn_UpdateShopCart = By.xpath("//input[@value='Update shopping cart']");
    public static By txt_PriceFirstItem = By.xpath("//table[@class='cart']/tbody/tr/td[4]/span[2]");
    public static By txt_PriceSecondItem = By.xpath("//table[@class='cart']/tbody/tr[2]/td[4]/span[2]");
    public static By txt_ActualGrandTotal = By.xpath("//table[@class='cart-total']//tr[4]/td[2]/span/span");
    public static By txt_BeforeDiscountTotal = By.xpath("//span[@class='product-price order-total']/strong");
    public static By txtbx_Coupon = By.xpath("(//div[@class='coupon-code']//input)[1]");
    public static By txt_EnterCoupon = By.xpath("//input[@name='discountcouponcode']");
    public static By btn_ApplyCoupon = By.xpath("//input[@name='applydiscountcouponcode']");
    public static By getTxt_MessagePrinted = By.xpath("//div[@class='message']");
    public static By txt_DiscountAmount = By.xpath("//span[contains(text(),'Discount')]/..//following-sibling::td/span/span");
    public static By txt_AfterDiscountTotal = By.xpath("//span[@class='product-price order-total']/strong");
    public static By checkbox_Iagree = By.xpath("//input[@id='termsofservice']");
    public static By btn_Checkout = By.xpath("//button[@value='checkout']");

    public static double getCartPriceBeforeDiscount() {
        WebDriver driver = BaseClass.getDriver();
        String total_BeforeDiscount = driver.findElement(txt_BeforeDiscountTotal).getText();
        log.info("value of total:" + total_BeforeDiscount);
        return Double.parseDouble(total_BeforeDiscount);
    }

    public static void checkoutSelectedItems() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(checkbox_Iagree).click();
        log.info("Check-box is clicked");
        driver.findElement(btn_Checkout).click();
        log.info("Checkout button is clicked");
    }

    public static void clickTxtbxCoupon() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txtbx_Coupon).click();
        log.info("coupon test box is clicked");
    }

    public static void enterTxtbxCoupon(String ApplyCoupon) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txt_EnterCoupon).sendKeys(ApplyCoupon);
        log.info("coupon code is Entered");
    }

    public static double applyCoupon(String applyCoupon) {
        WebDriver driver = BaseClass.getDriver();
        DemoWebShop_HomePage.clickShoppingCartLink();
        double totalValue_BeforeDiscount = DemoWebShop_CartPage.getCartPriceBeforeDiscount();
        DemoWebShop_CartPage.clickTxtbxCoupon();
        DemoWebShop_CartPage.enterTxtbxCoupon(applyCoupon);
        driver.findElement(btn_ApplyCoupon).click();
        log.info("ApplyCoupon button is clicked");
        return totalValue_BeforeDiscount;
    }

    public static void verifyCouponMessage() {
        WebDriver driver = BaseClass.getDriver();
        String message = driver.findElement(DemoWebShop_CartPage.getTxt_MessagePrinted).getText().trim();
        log.info("Displayed Message is:" + message);
        Assert.assertEquals(message, "The coupon code was applied", "Coupon applied is not successful");
        log.info("Coupon applied is successful");
    }

    public static double getDiscountAmount() {
        WebDriver driver = BaseClass.getDriver();
        String discount = driver.findElement(DemoWebShop_CartPage.txt_DiscountAmount).getText();
        log.info("Applied Discount Amount is :" + discount);
        return Double.parseDouble(discount);
    }

    public static void verifyPriceAfterDiscount(double totalValue_BeforeDiscount) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        verifyCouponMessage();
        double discountValue = getDiscountAmount();
        Thread.sleep(1000);
        String total_AfterDiscount = driver.findElement(DemoWebShop_CartPage.txt_AfterDiscountTotal).getText();
        log.info("After discount value of total:" + total_AfterDiscount);
        double totalValue_AfterDiscount = Double.parseDouble(total_AfterDiscount);
        double expectedTotalValue = totalValue_BeforeDiscount + discountValue;
        Assert.assertEquals(expectedTotalValue, totalValue_AfterDiscount, "Discount value is not correctly applied on Cart");
        log.info("Discount value is correctly applied on Cart and verified");
    }

    public static String itemPrice_BeforeIncreasingQty(String itemNumber) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        DemoWebShop_HomePage.select_ShoppingCart();
        WebElement element_ItemTotal;
        String totalValue_Item = "";
        if (itemNumber.equalsIgnoreCase("first")) {
            element_ItemTotal = driver.findElement(DemoWebShop_CartPage.txt_FirstItemTotal);
            totalValue_Item = element_ItemTotal.getText();
        } else if (itemNumber.equalsIgnoreCase("second")) {
            element_ItemTotal = driver.findElement(DemoWebShop_CartPage.txt_SecondItemTotal);
            totalValue_Item = element_ItemTotal.getText();
        }
        log.info("Total value of the " + itemNumber + " item before increasing the quantity is :" + totalValue_Item);
        return totalValue_Item;
    }

    public static void increaseQuantity(String itemNumber, String updateQuantity) {
        WebDriver driver = BaseClass.getDriver();
        WebElement element_Quantity;
        if (itemNumber.equalsIgnoreCase("first")) {
            element_Quantity = driver.findElement(txtbx_FirstItemQty);
            element_Quantity.clear();
            element_Quantity.sendKeys(updateQuantity);
            log.info("Increased Quantity for " + itemNumber + " is increased to " + updateQuantity);
        } else if (itemNumber.equalsIgnoreCase("second")) {
            element_Quantity = driver.findElement(txtbx_SecondItemQty);
            element_Quantity.clear();
            element_Quantity.sendKeys(updateQuantity);
            log.info("Increased Quantity for " + itemNumber + " is increased to " + updateQuantity);
        }
        clickUpdateCartButton();
    }

    public static void clickUpdateCartButton() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebShop_CartPage.btn_UpdateShopCart).click();
        log.info("Clicked on the Update cart button");
    }

    public static String price_textBook() {
        WebDriver driver = BaseClass.getDriver();
        return driver.findElement(DemoWebShop_CartPage.txt_PriceFirstItem).getText();
    }

    public static String getUpdatedQuantityValue(String itemNumber) {
        WebDriver driver = BaseClass.getDriver();
        if (itemNumber.equalsIgnoreCase("first")) {
            return driver.findElement(DemoWebShop_CartPage.txtbx_FirstItemQty).getAttribute("value");
        } else {
            return driver.findElement(DemoWebShop_CartPage.txtbx_SecondItemQty).getAttribute("value");
        }
    }

    public static void verify_BookTotalPriceChange(String updateQty) {
        WebDriver driver = BaseClass.getDriver();
        String text_BookPrice = price_textBook();
        String text_UpdatedQty = getUpdatedQuantityValue("first");
        Assert.assertEquals(updateQty, text_UpdatedQty, "Update Quantity is not successful for Book Item");
        log.info("Update Quantity is successful for Book Item");
        String text_BookTotalPrice = driver.findElement(DemoWebShop_CartPage.txt_FirstItemTotal).getText();
        double bookPrice = Double.parseDouble(text_BookPrice);
        double UpdateQty = Double.parseDouble(text_UpdatedQty);
        double bookTotalPrice = Double.parseDouble(text_BookTotalPrice);
        double expectedTotalPrice = bookPrice * UpdateQty;
        Assert.assertEquals(expectedTotalPrice, bookTotalPrice, "Update Shopping Cart is not successful for Book Item and Price is not matched");
        log.info("Update Shopping Cart is successful for Book Item and Price is matched :" + bookTotalPrice);
    }

    public static String getJeweleryPrice() {
        WebDriver driver = BaseClass.getDriver();
        return driver.findElement(DemoWebShop_CartPage.txt_PriceSecondItem).getText();
    }

    public static void verify_JewelTotalPriceChange(String updateQty) {
        WebDriver driver = BaseClass.getDriver();
        String text_JewelPrice = getJeweleryPrice();
        String text_UpdatedQty = getUpdatedQuantityValue("second");
        Assert.assertEquals(updateQty, text_UpdatedQty, "Update Quantity is not successful for Jewel Item");
        log.info("Update Quantity is successful for Jewel Item");
        String text_JewelTotalPrice = driver.findElement(DemoWebShop_CartPage.txt_SecondItemTotal).getText();
        double JewelPrice = Double.parseDouble(text_JewelPrice);
        double UpdateQty = Double.parseDouble(text_UpdatedQty);
        double JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);
        double expectedTotalPrice = JewelPrice * UpdateQty;
        Assert.assertEquals(expectedTotalPrice, JewelTotalPrice, "Update Shopping Cart is not successful for Jewel Item and Price is not matched");
        log.info("Update Shopping Cart is successful for Jewel Item and Price is matched :" + JewelTotalPrice);
    }

    public static void verify_grandTotal() {
        WebDriver driver = BaseClass.getDriver();
        String text_BookTotalPrice = driver.findElement(DemoWebShop_CartPage.txt_FirstItemTotal).getText();
        double dou_BookTotalPrice = Double.parseDouble(text_BookTotalPrice);
        String text_JewelTotalPrice = driver.findElement(DemoWebShop_CartPage.txt_SecondItemTotal).getText();
        double dou_JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);
        double grandTotal = dou_BookTotalPrice + dou_JewelTotalPrice;
        String actualTotal = driver.findElement(DemoWebShop_CartPage.txt_ActualGrandTotal).getText();
        double total = Double.parseDouble(actualTotal);
        Assert.assertEquals(grandTotal, total, "Cart total is not accurate");
        log.info("Cart total is accurate " + total);
    }

    public static void clickCheckoutBtn() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebShop_CartPage.checkbox_Iagree).click();
        log.info("Check-box is clicked");
        driver.findElement(DemoWebShop_CartPage.btn_Checkout).click();
        log.info("Checkout button is clicked");
    }
}
