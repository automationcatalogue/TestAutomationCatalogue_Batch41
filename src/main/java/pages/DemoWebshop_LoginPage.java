package pages;

import javaPrograms.oops.Inheritance_1.B;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_LoginPage {
    public static By txtbx_UserName = By.cssSelector("#Email");
    public static By txtbx_Password = By.cssSelector("#Password");
    public static By btn_Login = By.xpath("//input[@value='Log in']");

    public static void login(String userName, String password){
        WebDriver driver = BaseClass.getDriver();

        driver.findElement(txtbx_UserName).sendKeys(userName);
        driver.findElement(txtbx_Password).sendKeys(password);
        driver.findElement(btn_Login).click();
    }


}
