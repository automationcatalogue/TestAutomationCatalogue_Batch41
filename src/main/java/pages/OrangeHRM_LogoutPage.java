package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_LogoutPage {

    public static By btn_logout=By.xpath("//span[text()='Log Out']");

    public static void logout(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("log out is clicked");
    }
}
