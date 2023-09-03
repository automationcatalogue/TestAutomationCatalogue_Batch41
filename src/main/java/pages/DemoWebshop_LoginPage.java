package pages;

import javaPrograms.oops.Inheritance_1.B;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_LoginPage {
    public static By txtbx_UserName = By.cssSelector("#Email");
    public static By txtbx_Password = By.cssSelector("#Password");
    public static By btn_Login = By.xpath("//input[@value='Log in']");
    static Logger log = LogManager.getLogger(OrangeHRM_LoginPage.class);
    public static void login(String userName, String password){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        log.info("Clicked on the login link");
        driver.findElement(DemoWebshop_LoginPage.txtbx_UserName).sendKeys(userName);
        driver.findElement(DemoWebshop_LoginPage.txtbx_Password).sendKeys(password);
        driver.findElement(DemoWebshop_LoginPage.btn_Login).click();
    }
}
