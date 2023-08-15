package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_BooksPage {
    public static By link_FirstItem = By.xpath("//div[@class='product-grid']//a[1]");
    public static By btn_AddCartInsideFirstItem = By.xpath("(//input[@value='Add to cart'])[1]");

    public static By link_Books = By.xpath("//div//ul[@class='top-menu']//a[@href='/books']");
    public static By btn_AddToCart = By.xpath("(//div[@class='product-grid']//input)[1]");

    static Logger log = LogManager.getLogger(DemoWebshop_BooksPage.class);
    public static void clickBooksLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Books).click();
        log.info("Books link is clicked");
    }
    public static void clickAddToCartBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_AddToCart).click();
        log.info("Add to cart button is clicked");
    }
    public static void adding_FirstBookToCart(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_BooksPage.link_FirstItem).click();
        log.info("Clicked on first item in books ");

        driver.findElement(DemoWebshop_BooksPage.btn_AddCartInsideFirstItem).click();
        log.info("Clicked on Add to Cart Button in Books");

    }
}
