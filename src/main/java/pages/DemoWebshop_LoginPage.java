package pages;

import javaPrograms.oops.Inheritance_1.B;
import org.openqa.selenium.By;

public class DemoWebshop_LoginPage {
    public static By txtbx_UserName = By.cssSelector("#Email");
    public static By txtbx_userName = By.xpath("//input[@id='Email']");
    public static By txtbx_Password = By.xpath("//input[@id='Password']");
    public static By btn_Login = By.xpath("//input[@class='button-1 login-button']");
}
