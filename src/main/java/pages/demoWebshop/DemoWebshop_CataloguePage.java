package pages.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_CataloguePage {

    static Logger log = LogManager.getLogger(DemoWebshop_CataloguePage.class);

    public static By link_FirstItem = By.xpath("//div[@class='product-grid']//a[1]");
    public static By btn_FirstItem_AddToCart = By.xpath("(//input[@value='Add to cart'])[1]");
    public static By link_Books = By.xpath("//div//ul[@class='top-menu']//a[@href='/books']");
    public static By btn_AddToCart = By.xpath("(//div[@class='product-grid']//input)[1]");
    public static By txtbx_lengthFirstItem = By.xpath("(//input[@type='text'])[3]");

    public static void clickAddToCartBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_AddToCart).click();
        log.info("Add to cart button is clicked");
    }
    public static void book_FirstItem(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Books).click();
        log.info("Books link is clicked");
        driver.findElement(DemoWebshop_CataloguePage.link_FirstItem).click();
        log.info("Clicked on first item in books ");
        driver.findElement(DemoWebshop_CataloguePage.btn_FirstItem_AddToCart).click();
        log.info("Clicked on Add to Cart Button in Books");
    }

    public static void jewelry_FirstItem(String jewelLength)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_HeaderJewels).click();
        log.info("Clicked on Jewellery link");
        driver.findElement(link_FirstItem).click();
        log.info("Clicked on first item in jewellery");
        driver.findElement(txtbx_lengthFirstItem).sendKeys(jewelLength);
        Thread.sleep(2000);
        driver.findElement(btn_FirstItem_AddToCart).click();
        log.info("Clicked on First Item Add to Cart Button in Jewellery");
    }
}
