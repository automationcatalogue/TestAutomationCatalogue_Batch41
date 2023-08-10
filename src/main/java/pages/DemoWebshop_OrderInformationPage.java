package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_OrderInformationPage {

    public static By btn_Reorder = By.xpath("//input[@type='button'][@value='Re-order']");

    public static void clickReorderBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Reorder).click();
        System.out.println("Re-order button is clicked");
    }


}