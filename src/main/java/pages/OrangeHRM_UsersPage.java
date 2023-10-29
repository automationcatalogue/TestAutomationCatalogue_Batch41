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

    static String employee_UserName=null;
    static String supervisor_name=null;
    public static String userName=null;
    public static String employeeName;
    static Logger log = LogManager.getLogger(OrangeHRM_UsersPage.class);
    public static String getEmployeeDetails(){
        WebDriver driver = BaseClass.getDriver();
        userName = driver.findElement(OrangeHRM_UsersPage.link_firstUserName).getText();
        log.info("First UserName from the Users List is :" + userName);

        driver.findElement(OrangeHRM_UsersPage.icon_edit).click();
        log.info("Clicked on edit button");
        return userName;
    }

    public static void getSupervisorDetails(){

    }
    public static void changeEmployeePassword(String newPassword) {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

       //String userName = driver.findElement(OrangeHRM_UsersPage.link_firstUserName).getText();
       //System.out.println("First UserName from the Users List is :" + userName);

        //driver.findElement(OrangeHRM_UsersPage.icon_edit).click();
       // System.out.println("Clicked on edit button");

       // WebElement emp_UserName=driver.findElement(OrangeHRM_UsersPage.txtbx_employeeUserName);
       // employee_UserName = (String) js.executeScript("return arguments[0].value", emp_UserName);

       // System.out.println(employee_UserName);

        driver.findElement(OrangeHRM_UsersPage.chkbx_changePassword).click();
        log.info("change password check  box is selected");

        driver.findElement(OrangeHRM_UsersPage.txtbx_enterPassword).sendKeys(newPassword);
        log.info("entered the new password");

        driver.findElement(OrangeHRM_UsersPage.txtbx_confirmPassword).sendKeys(newPassword);
        log.info("re-entered the new password");

        driver.findElement(OrangeHRM_UsersPage.btn_save).click();
        log.info("Clicked on Save");

        //return employee_UserName;l
    }

    public static void changeSupervisorPassword(String supervisor_name,String pswd) {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> sup_name = driver.findElements(OrangeHRM_UsersPage.list_users);

        for (WebElement supervisor : sup_name) {
            String currentSupervisorName = supervisor.getText();
            if (currentSupervisorName.equalsIgnoreCase(supervisor_name)) {
                supervisor.findElement(OrangeHRM_UsersPage.btn_edit).click();
                log.info("Clicked on Edit button");

                WebElement changepswd_chkbox = driver.findElement(OrangeHRM_UsersPage.chkbx_changePassword);
                js.executeScript("arguments[0].click();", changepswd_chkbox);
                driver.findElement(OrangeHRM_UsersPage.txtbx_enterPassword).sendKeys(pswd);
                driver.findElement(OrangeHRM_UsersPage.txtbx_confirmPassword).sendKeys(pswd);
                driver.findElement(OrangeHRM_UsersPage.btn_save).click();
                log.info("Supervisor's username and password is updated.");
            }
        }
    }
    public static String username_Supervisor(String supervisorName){
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String supervisor_userName = null;
        List<WebElement> supervisorUserName_List = driver.findElements(OrangeHRM_UsersPage.list_users);
        for (WebElement SupervisorName : supervisorUserName_List) {
            String name = SupervisorName.getText();
            if (name.equalsIgnoreCase(supervisorName)) {
                SupervisorName.findElement(OrangeHRM_UsersPage.btn_edit).click();
                WebElement SupervisorUsername_Element = driver.findElement(OrangeHRM_UsersPage.txtbx_userName);
                supervisor_userName = (String) js.executeScript("return arguments[0].value", SupervisorUsername_Element);
                log.info("username of the Supervisor is :"+supervisor_userName);
                driver.findElement(OrangeHRM_UsersPage.icon_crossExit).click();
                break;
            }
        }
        return supervisor_userName;
    }

    public static String getUserName(String employeeName){
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualUserName = "";
        List<WebElement> elements_UserNamesList = driver.findElements(OrangeHRM_UsersPage.list_users);
        for (WebElement element_UserName : elements_UserNamesList) {
            String Name = element_UserName.getText();
            if (Name.equalsIgnoreCase(employeeName)) {
                element_UserName.findElement(OrangeHRM_UsersPage.btn_edit).click();
                WebElement Username_Element = driver.findElement(OrangeHRM_UsersPage.txtbx_userName);
                actualUserName = (String) js.executeScript("return arguments[0].value", Username_Element);
                log.info("Username of the Employee is :"+actualUserName);
                driver.findElement(OrangeHRM_UsersPage.icon_crossExit).click();
                break;
            }
        }
        return actualUserName;
    }

}