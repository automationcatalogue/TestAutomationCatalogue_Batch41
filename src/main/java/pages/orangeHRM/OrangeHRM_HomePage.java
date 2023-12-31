package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BaseClass;

public class OrangeHRM_HomePage {

    static Logger log = LogManager.getLogger(OrangeHRM_HomePage.class);

    public static By link_HRAdministration = By.xpath("(//span[text()='HR Administration'])[1]");
    public static By lbl_ProfileName = By.xpath("//div[@id='sidebar-profile-picture']/a");
    public static By link_EmployeeManagement = By.xpath("(//a[@data-tooltip='Employee Management'])[1]");
    public static By btn_More = By.xpath("//span[text()='More']");
    public static By link_Performance = By.xpath("(//a[@data-tooltip='Performance'])[1]");
    public static By btn_Logout = By.xpath("//span[text()='Log Out']");

    public static void verifyTitle() {
        WebDriver driver = BaseClass.getDriver();
        String title = driver.getTitle();
        String expectedTitle = "Employee Management";
        BaseClass.failureReason = "Title is not matched";
        Assert.assertEquals(expectedTitle, title, "Title is not matched");
        log.info("Title is verified, Login is Successful");
    }

    public static void clickEmployeeManagementLink() throws Exception {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emp_mgmt = driver.findElement(link_EmployeeManagement);
        js.executeScript("arguments[0].click();", emp_mgmt);
        log.info("Employee Management is selected");
    }

    public static void clickHrAdministrationLink() throws Exception {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_HRAdministration).click();
        log.info("HR Administration link is clicked");
    }

    public static void verifyNewEmpName(String expectedEmpName) {
        WebDriver driver = BaseClass.getDriver();
        String empName = driver.findElement(lbl_ProfileName).getText();
        Assert.assertEquals(expectedEmpName, empName, "New Employee Name is not matched");
        log.info("New Employee Name is matched");
    }

    public static void selectPerformance() {
        WebDriver driver = BaseClass.getDriver();
        try {
            driver.findElement(OrangeHRM_HomePage.btn_More).click();
            log.info("More button is visible and clicked");
        } catch (Exception e) {
            log.info("More button is not visible");
        }
        driver.findElement(OrangeHRM_HomePage.link_Performance).click();
        log.info("Performance link is clicked");
    }

    public static void clickTRavelExpLink() {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement travelexp_Element = driver.findElement(By.xpath("//a[@data-automation-id='menu_expense_TravelandExpense']//span[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", travelexp_Element);
        //WebElement element= wait.until(ExpectedConditions.elementToBeClickable(travelexp_Element));
        travelexp_Element.click();
        js.executeScript("arguments[0].click;", travelexp_Element);
        log.info("Travel and Expense is selected");
    }

    public static void logout() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Logout).click();
        log.info("Logout button is clicked");
    }
}

