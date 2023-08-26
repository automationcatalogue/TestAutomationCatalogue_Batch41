package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_LoginPage {
    static Logger log = LogManager.getLogger(OrangeHRM_LoginPage.class);
    public static By txtbx_userName = By.xpath("//input[@id='txtUsername']");
    public static By txtbx_Password = By.xpath("//input[@id='txtPassword']");
    public static By btn_Login = By.xpath("//button[@type='submit']");
    static String supervisor_username;
    static String newPassword;


    public static void login(String userName, String password) {
        WebDriver driver = BaseClass.getDriver();

        driver.findElement(txtbx_userName).sendKeys(userName);
        log.info("UserName is Entered :" + userName);
        driver.findElement(txtbx_Password).sendKeys(password);
        log.info("Password is Entered :" + password);
        driver.findElement(btn_Login).click();
        log.info("Login button is clicked");
    }

    public static void login_employee(String userName, String pswd) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(userName);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(pswd);
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        log.info("Logged into " + userName + " portal");
    }

    public static void login_supervisor(String username, String newPassword) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(username);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(newPassword);
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        log.info("Logged in as " + username);
    }

}
