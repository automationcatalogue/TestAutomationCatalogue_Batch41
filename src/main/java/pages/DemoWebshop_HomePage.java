package pages;

import org.openqa.selenium.By;

public class DemoWebshop_HomePage {
    public static By link_Login = By.xpath("//a[text()='Log in']");
    public static By link_mailID = By.xpath("(//a[@href='/customer/info'])[1]");
    public static By link_Address = By.xpath("(//a[text()='Addresses'])[1]");
    public static By btn_Logout = By.xpath("//a[text()='Log out']");
}
