package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class OrangeHRM_UsersPage {
    public static By link_firstUserName =By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]/td[2]//span");
    public static By icon_edit= By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]//i");
    public static By chkbx_changePassword=By.xpath("//span[text()='Change Password']");
    public static By txtbx_enterPassword=By.xpath("(//input[@type='password'])[1]");
    public static By txtbx_confirmPassword=By.xpath("(//input[@type='password'])[2]");
    public static By btn_save =By.xpath("//button[text()='Save']");
    public static By list_users =By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[4]");
    // corresponding supervisor edit button
    public static By btn_edit =By.xpath(".//following-sibling::td[4]");
    public static By txtbx_userName = By.xpath("//input[@id='user_name']");
    public static By icon_crossExit = By.xpath("//button[@aria-label='Close']");


    public static String userName=null;
    static Logger log = LogManager.getLogger(OrangeHRM_UsersPage.class);

    public static void getEmployeeDetails(){
        WebDriver driver = BaseClass.getDriver();
        userName = driver.findElement(link_firstUserName).getText();
        log.info("First UserName from the Users List is :" + userName);
        driver.findElement(icon_edit).click();
        log.info("Clicked on edit button");
    }

    public static void changeEmployeePassword(String newPassword) {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(chkbx_changePassword).click();
        log.info("change password check  box is selected");

        driver.findElement(txtbx_enterPassword).sendKeys(newPassword);
        log.info("entered the new password");

        driver.findElement(txtbx_confirmPassword).sendKeys(newPassword);
        log.info("re-entered the new password");

        driver.findElement(btn_save).click();
        log.info("Clicked on Save");
    }

    public static void changeSupervisorPassword(String supervisor_name,String pswd) {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> sup_name = driver.findElements(list_users);

        for (WebElement supervisor : sup_name) {
            String currentSupervisorName = supervisor.getText();
            if (currentSupervisorName.equalsIgnoreCase(supervisor_name)) {
                supervisor.findElement(btn_edit).click();
                log.info("Clicked on Edit button");

                WebElement changepswd_chkbox = driver.findElement(chkbx_changePassword);
                js.executeScript("arguments[0].click();", changepswd_chkbox);
                driver.findElement(txtbx_enterPassword).sendKeys(pswd);
                driver.findElement(txtbx_confirmPassword).sendKeys(pswd);
                driver.findElement(btn_save).click();

                log.info("Supervisor's password is updated.");
            }
        }
    }
    public static String username_Supervisor(String supervisorName){
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String supervisor_userName = null;
        List<WebElement> supervisorUserName_List = driver.findElements(list_users);
        for (WebElement SupervisorName : supervisorUserName_List) {
            String name = SupervisorName.getText();
            if (name.equalsIgnoreCase(supervisorName)) {
                SupervisorName.findElement(btn_edit).click();
                WebElement SupervisorUsername_Element = driver.findElement(txtbx_userName);
                supervisor_userName = (String) js.executeScript("return arguments[0].value", SupervisorUsername_Element);
                log.info("username of the Supervisor is :"+supervisor_userName);
                driver.findElement(icon_crossExit).click();
                break;
            }
        }
        return supervisor_userName;
    }

}