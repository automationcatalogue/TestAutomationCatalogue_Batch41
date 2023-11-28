package pages.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.BaseClass;

public class DemoWebShop_HomePage {

    static Logger log = LogManager.getLogger(DemoWebShop_HomePage.class);

    public static By link_Login = By.xpath("//a[text()='Log in']");
    public static By link_Email = By.xpath("(//a[@class='account'])[1]");
    public static By link_Orders = By.xpath("//div[@class='block block-account-navigation']//ul//a[text()='Orders']");
    public static By link_HeaderBooks = By.xpath("//ul[@class='top-menu']/li[1]/a");
    public static By link_HeaderJewels = By.xpath("//ul[@class='top-menu']/li[6]/a");
    public static By link_ShoppingCart = By.xpath("//div[@class='header-links']/ul/li[3]/a");
    public static By link_mailID = By.xpath("(//a[@href='/customer/info'])[1]");
    public static By link_Address = By.xpath("(//a[text()='Addresses'])[1]");
    public static By btn_Logout = By.xpath("//a[text()='Log out']");

    public static void clickLoginLink() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Login).click();
        log.info("Login Link is clicked");
    }
    public static void openOrdersPage(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Email).click();
        log.info("Email Link is clicked");
        driver.findElement(link_Orders).click();
        log.info("Order link is clicked");
    }
    public static void logout(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Logout).click();
        log.info("log out is clicked");
    }
    public static void clickShoppingCartLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_ShoppingCart).click();
        log.info("Shopping cart link is clicked");
    }

    public static void select_ShoppingCart() throws Exception{
        WebDriver driver = BaseClass.getDriver();
        Thread.sleep(2000);
        driver.findElement(DemoWebShop_HomePage.link_ShoppingCart).click();
        log.info("Clicked on Shopping Cart Link");
    }

    public static void openMyAccount(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebShop_HomePage.link_mailID).click();
        log.info("clicked on the email.id");
        driver.findElement(DemoWebShop_HomePage.link_Address).click();
        log.info("clicked on Address ");
    }

    public static void createContactNumbers(String zip, String PhNo, String FxNo){
        WebDriver driver = BaseClass.getDriver();
    }

    public static void verifyTitle() {
        WebDriver driver = BaseClass.getDriver();

        String title = driver.getTitle();
        String expectedTitle = "Demo Web Shop";

        BaseClass.failureReason = "Title is not matched";
        Assert.assertEquals(expectedTitle, title, "Title is not matched");
        log.info("Title is verified, Login is Successful");
    }

    public static void logOut(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebShop_HomePage.btn_Logout).click();
        log.info("log out is clicked");
    }
}
