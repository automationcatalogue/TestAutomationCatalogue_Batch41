package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

import java.util.Base64;

public class OrangeHRM_LoginPage {
    static Logger log = LogManager.getLogger(OrangeHRM_LoginPage.class);

    public static By txtbx_userName = By.xpath("//input[@id='txtUsername']");
    public static By txtbx_Password = By.xpath("//input[@id='txtPassword']");
    public static By btn_Login = By.xpath("//button[@type='submit']");

    public static void login(String userName, String password) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txtbx_userName).sendKeys(userName);
        log.info("UserName is Entered :" + userName);
        String decodedPassword = new String(Base64.getDecoder().decode(password.getBytes()));
        driver.findElement(txtbx_Password).sendKeys(decodedPassword);
        log.info("Password is Entered :" + password);
        driver.findElement(btn_Login).click();
        log.info("Login button is clicked");
    }

}
