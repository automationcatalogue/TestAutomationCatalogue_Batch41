package pages;

import org.openqa.selenium.By;

public class DemoWebshop_LoginPage {
    public static By txtbx_UserName = By.cssSelector("#Email");
    public static By txtbx_Password = By.cssSelector(".password");
    public static By btn_login = By.xpath("//input[contains(@class,'login-button')]");
}
