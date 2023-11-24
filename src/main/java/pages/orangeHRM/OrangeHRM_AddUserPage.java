package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;
import java.util.Base64;

public class OrangeHRM_AddUserPage {

    static Logger log = LogManager.getLogger(OrangeHRM_AddUserPage.class);

    public static By txtbx_EmployeeName = By.xpath("//input[@id='selectedEmployee_value']");
    public static By icon_AddUser = By.xpath("//i[@class='material-icons'][text()='add']");
    public static By txtbx_RandomUserName = By.xpath("//input[@id='user_name']");
    public static By txtbx_Pwd = By.xpath("//input[@placeholder='Enter Password']");
    public static By txtbx_ConfirmPwd = By.xpath("//input[@placeholder='Confirm Password']");
    public static By btn_Save = By.xpath("//button[@id='modal-save-button']");
    public static By empName_Visibility = By.xpath("//div[@id='systemUserDiv']//table//tbody/tr[1]/td[2]//span[text()]");
    public static By empName_DropdownVisibility = By.xpath("//div[@id='selectedEmployee_dropdown']//div[@class='title-section']");

    public static void clickAddUser() {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(empName_Visibility));
        driver.findElement(icon_AddUser).click();
        log.info("Add User button is clicked");
    }

    public static void enterAddUserDetails(String empName, String userName, String password, String confirm_Password) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Enter Employee Name
        driver.findElement(txtbx_EmployeeName).sendKeys(empName);
        log.info(empName + " is entered as EmployeeName");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(empName_DropdownVisibility));
            driver.findElement(empName_DropdownVisibility).click();
            log.info("EmployeeName Dropdown element is visible and it is clicked");
        } catch (TimeoutException te) {
            log.info("EmployeeName Dropdown element is not visible");
        }
        driver.findElement(txtbx_RandomUserName).sendKeys(userName);
        log.info(userName + " is entered as UserName");
        String decodedPassword = new String(Base64.getDecoder().decode(password.getBytes()));
        driver.findElement(txtbx_Pwd).sendKeys(decodedPassword);
        log.info("Decoded Password is entered in the Password text-box");
        decodedPassword = new String(Base64.getDecoder().decode(confirm_Password.getBytes()));
        driver.findElement(txtbx_ConfirmPwd).sendKeys(decodedPassword);
        log.info("Decoded Password is entered in the Confirm Password text-box");
        clickSave();
    }

    public static void clickSave() throws Exception {
        WebDriver driver = BaseClass.getDriver();
        WebElement element_SaveBtn = driver.findElement(btn_Save);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_SaveBtn);
        log.info("Save button is clicked");
    }
}