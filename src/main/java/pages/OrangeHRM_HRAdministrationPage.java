package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_HRAdministrationPage {

    public static By link_users = By.xpath("//a[text()='Users ']");
    static Logger log = LogManager.getLogger(OrangeHRM_HRAdministrationPage.class);
    public static void clickOnUsersLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_users).click();
        log.info("clicked on Users button");
    }

}
