package pages;

import org.openqa.selenium.By;

public class DemoWebshop_CartPage {
    public static By txt_FirstItemTotal = By.xpath("(//table[@class='cart']/tbody/tr)[1]/td[6]/span[2]");
    public static By txtbx_FirstItemQty = By.xpath("(//table[@class='cart']/tbody/tr/td[5]/input)[1]");
    public static By txt_SecondItemTotal = By.xpath("(//table[@class='cart']/tbody/tr)[2]/td[6]/span[2]");
    public static By txtbx_SecondItemQty = By.xpath("//table[@class='cart']/tbody/tr[2]/td[5]/input");
    public static By btn_UpdateShopCart = By.xpath("//input[@value='Update shopping cart']");
    public static By txt_PriceFirstItem = By.xpath("//table[@class='cart']/tbody/tr/td[4]/span[2]");
    public static By txtbx_Address = By.xpath("(//a[text()='Addresses'])[1]");
    public static By Link_Address = By.xpath("//div[contains(@class,'st-page')]/div[2]/div[1]/div/div[1]");

}
