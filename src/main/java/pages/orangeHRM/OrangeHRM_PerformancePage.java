package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;
import java.time.Duration;

public class OrangeHRM_PerformancePage {

    static Logger log = LogManager.getLogger(OrangeHRM_PerformancePage.class);

    public static By link_goals = By.xpath("//a[@data-automation-id='menu_performance_Goals']");
    public static By link_MyGoals = By.xpath("//a[contains(@data-automation-id,'myGoals')]");
    public static By link_GoalList = By.xpath("//a[contains(@data-automation-id,'menu_performance_viewEmployeeGoalList')]");

    public static void selectMyGoals() throws Exception {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(link_goals).click();
        log.info("Clicked on Goals link");
        wait.until(ExpectedConditions.elementToBeClickable(link_MyGoals));
        driver.findElement(link_MyGoals).click();
        log.info("Clicked on My Goals");
    }

    public static void selectGoalsList() throws Exception {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(link_goals).click();
        log.info("Clicked on Goals link");
        wait.until(ExpectedConditions.elementToBeClickable(link_GoalList));
        driver.findElement(link_GoalList).click();
        log.info("Clicked on Goal List");
    }
}
