package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_HRAdministrationPage {

    static Logger log = LogManager.getLogger(OrangeHRM_HRAdministrationPage.class);

    public static By link_users = By.xpath("//a[text()='Users ']");

    public static void clickOnUsersLink() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_HRAdministrationPage.link_users).click();
        log.info("clicked on Users button");
    }
}
