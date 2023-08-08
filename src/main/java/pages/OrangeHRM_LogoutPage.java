package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

public class OrangeHRM_LogoutPage {

    public static By btn_logout=By.xpath("//span[text()='Log Out']");
    static Logger log = LogManager.getLogger(OrangeHRM_LogoutPage.class);
    public static void logout(){
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement logout = driver.findElement(btn_logout);
        js.executeScript("arguments[0].click();",logout);
        log.info("log out is clicked");
    }
}
