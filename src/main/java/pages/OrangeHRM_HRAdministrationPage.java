package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_HRAdministrationPage {

    public static By link_users = By.xpath("//a[text()='Users ']");

    public static void clickOnUsersLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_HRAdministrationPage.link_users).click();
        System.out.println("clicked on Users button");
    }

}
