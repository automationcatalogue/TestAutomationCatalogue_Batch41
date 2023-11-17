package pages.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebShop_OrderInformationPage {

    static Logger log = LogManager.getLogger(DemoWebShop_OrderInformationPage.class);

    public static By btn_Reorder = By.xpath("//input[@type='button'][@value='Re-order']");

    public static void clickReorderBtn() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Reorder).click();
        log.info("Re-order button is clicked");
    }
}