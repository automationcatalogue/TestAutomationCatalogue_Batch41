package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class OrangeHRM_HRAdministrationPage {

    public static By link_users = By.xpath("//a[text()='Users ']");
    static Logger log = LogManager.getLogger(OrangeHRM_HRAdministrationPage.class);

    public static String username_Employee(String employeeName){
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String Actual_UserName = null;
        List<WebElement> userName_List = driver.findElements(OrangeHRM_UsersPage.list_users);
        for (WebElement userName : userName_List) {
            String Name = userName.getText();
            if (Name.equalsIgnoreCase(employeeName)) {
                userName.findElement(OrangeHRM_UsersPage.btn_edit).click();
                WebElement Username_Element = driver.findElement(OrangeHRM_UsersPage.txtbx_userName);
                Actual_UserName = (String) js.executeScript("return arguments[0].value", Username_Element);
                System.out.println("Username of the Employee is :"+Actual_UserName);
                driver.findElement(OrangeHRM_UsersPage.icon_crossExit).click();
                break;
            }
        }
        return Actual_UserName;
    }

    public static String username_Supervisor(String supervisorName){
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String supervisor_ActualUserName = null;
        List<WebElement> supervisorUserName_List = driver.findElements(OrangeHRM_UsersPage.list_users);
        for (WebElement SupervisorName : supervisorUserName_List) {
            String name = SupervisorName.getText();
            if (name.equalsIgnoreCase(supervisorName)) {
                SupervisorName.findElement(OrangeHRM_UsersPage.btn_edit).click();
                WebElement SupervisorUsername_Element = driver.findElement(OrangeHRM_UsersPage.txtbx_userName);
                supervisor_ActualUserName = (String) js.executeScript("return arguments[0].value", SupervisorUsername_Element);
                System.out.println("username of the Supervisor is :"+supervisor_ActualUserName);
                driver.findElement(OrangeHRM_UsersPage.icon_crossExit).click();
                break;
            }
        }
        return supervisor_ActualUserName;
    }

    public static void clickOnUsersLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_users).click();
        log.info("clicked on Users button");
    }
}
