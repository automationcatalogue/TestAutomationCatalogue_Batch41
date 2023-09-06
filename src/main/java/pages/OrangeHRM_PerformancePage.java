package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;
import utilities.BaseClass;

public class OrangeHRM_PerformancePage {
    public static By link_goals = By.xpath("//a[@data-automation-id='menu_performance_Goals']");
    public static By link_MyGoals = By.xpath("//a[contains(@data-automation-id,'myGoals')]");
    static Logger log = LogManager.getLogger(OrangeHRM_PerformancePage.class);

    public static void selectMyGoals() throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_PerformancePage.link_goals).click();
        log.info("Clicked on Goals link");

        Thread.sleep(1000);
        driver.findElement(OrangeHRM_PerformancePage.link_MyGoals).click();
        log.info("Clicked on My Goals");

    }
}
