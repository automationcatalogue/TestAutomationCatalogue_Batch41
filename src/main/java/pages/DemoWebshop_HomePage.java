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

    public static void clickLoginLink() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Login).click();
        System.out.println("Login Link is clicked");
    }
        public static void clickEmailLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Email).click();
        System.out.println("Email Link is clicked");
    }
    public static void logout(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Logout).click();
        System.out.println("log out is clicked");
    }
    public static void clickShoppingCartLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_ShoppingCart).click();
        System.out.println("Shopping cart link is clicked");
    }
}
