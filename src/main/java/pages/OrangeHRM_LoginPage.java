package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_LoginPage {
    public static By txtbx_userName = By.xpath("//input[@id='txtUsername']");
    public static By txtbx_Password = By.xpath("//input[@id='txtPassword']");
    public static By btn_Login = By.xpath("//button[@type='submit']");

    public static void login(String userName, String password){
        WebDriver driver =BaseClass.getDriver();

        driver.findElement(txtbx_userName).sendKeys(userName);
        driver.findElement(txtbx_Password).sendKeys(password);
        driver.findElement(btn_Login).click();
    }

    public static void login_employee(String userName,String pswd){
        WebDriver driver =BaseClass.getDriver();
        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(userName);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(pswd);
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Logged into " + userName + " portal");
    }
}
