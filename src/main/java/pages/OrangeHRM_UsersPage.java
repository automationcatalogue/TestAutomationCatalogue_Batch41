package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class OrangeHRM_UsersPage {

    public static By link_firstUserName = By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]/td[2]//span");
    public static By icon_edit = By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]//i");
    public static By chkbx_changePassword = By.xpath("//span[text()='Change Password']");
    public static By txtbx_enterPassword = By.xpath("(//input[@type='password'])[1]");
    public static By txtbx_confirmPassword = By.xpath("(//input[@type='password'])[2]");
    public static By btn_save = By.xpath("//button[text()='Save']");
    public static By list_users = By.xpath("//table[@class='highlight bordered']/tbody/tr/td[4]");
    // corresponding supervisor edit button
    public static By btn_edit = By.xpath(".//following-sibling::td[4]");

    static String supervisor_name=null;
    public static void changeEmployeePassword(String newPassword) {
        WebDriver driver = BaseClass.getDriver();

        String userName = driver.findElement(OrangeHRM_UsersPage.link_firstUserName).getText();
        System.out.println("First UserName from the Users List is :" + userName);

        driver.findElement(OrangeHRM_UsersPage.icon_edit).click();
        System.out.println("Clicked on edit button");

        driver.findElement(OrangeHRM_UsersPage.chkbx_changePassword).click();
        System.out.println("change password check  box is selected");

        driver.findElement(OrangeHRM_UsersPage.txtbx_enterPassword).sendKeys(newPassword);
        System.out.println("entered the new password");

        driver.findElement(OrangeHRM_UsersPage.txtbx_confirmPassword).sendKeys(newPassword);
        System.out.println("re-entered the new password");

        driver.findElement(OrangeHRM_UsersPage.btn_save).click();
        System.out.println("Clicked on Save");
    }

    public static void changeSupervisorPassword(String pswd, String supervisor_name) {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> sup_name = driver.findElements(OrangeHRM_UsersPage.list_users);

        for (WebElement supervisor : sup_name) {
            String currentSupervisorName = supervisor.getText();
            if (currentSupervisorName.equalsIgnoreCase(supervisor_name)) {
                supervisor.findElement(OrangeHRM_UsersPage.btn_edit).click();
                System.out.println("Clicked on Edit button");

                WebElement changepswd_chkbox = driver.findElement(OrangeHRM_UsersPage.chkbx_changePassword);
                js.executeScript("arguments[0].click();", changepswd_chkbox);
                driver.findElement(OrangeHRM_UsersPage.txtbx_enterPassword).sendKeys(pswd);
                driver.findElement(OrangeHRM_UsersPage.txtbx_confirmPassword).sendKeys(pswd);
                driver.findElement(OrangeHRM_UsersPage.btn_save).click();
                System.out.println("Supervisor's username and password is updated.");
            }
        }
    }

}