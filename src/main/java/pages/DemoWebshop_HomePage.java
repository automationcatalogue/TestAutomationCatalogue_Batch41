package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_HomePage {
    public static By link_Login = By.xpath("//a[text()='Log in']");
    public static By link_Email = By.xpath("(//a[@class='account'])[1]");

    public static By link_HeaderBooks = By.xpath("//ul[@class='top-menu']/li[1]/a");
    public static By link_HeaderJewels = By.xpath("//ul[@class='top-menu']/li[6]/a");
    public static By link_ShoppingCart = By.xpath("//div[@class='header-links']/ul/li[3]/a");
    public static By link_mailID = By.xpath("(//a[@href='/customer/info'])[1]");
    public static By link_Address = By.xpath("(//a[text()='Addresses'])[1]");
    public static By btn_Logout = By.xpath("//a[text()='Log out']");


}
