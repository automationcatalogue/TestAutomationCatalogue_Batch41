package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_JewelsPage {
    public static By link_FirstItem = By.xpath("//div[@class='product-grid']//a[1]");
    public static By txtbx_LngthInsideFrstItm = By.xpath("(//input[@type='text'])[3]");
    public static By btn_AddCartInsideFrstItm=By.xpath("(//input[@value='Add to cart'])[1]");

    static Logger log = LogManager.getLogger(DemoWebshop_JewelsPage.class);
    public static void adding_firstJewelToCart(String jewel_Length)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_JewelsPage.link_FirstItem).click();
        log.info("Clicked on first item in jewellery ");

        driver.findElement(DemoWebshop_JewelsPage.txtbx_LngthInsideFrstItm).sendKeys(jewel_Length);
        Thread.sleep(2000);
        driver.findElement(DemoWebshop_JewelsPage.btn_AddCartInsideFrstItm).click();
        log.info("Clicked on Add to Cart Button in Jewellery");
    }
}
