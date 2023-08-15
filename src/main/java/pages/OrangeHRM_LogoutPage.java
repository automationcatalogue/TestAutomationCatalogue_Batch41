package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_LogoutPage {

    public static By btn_logout=By.xpath("//span[text()='Log Out']");
    static Logger log = LogManager.getLogger(OrangeHRM_LogoutPage.class);

    public static void logout(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_logout).click();
        log.info("log out is clicked");
    }
}
