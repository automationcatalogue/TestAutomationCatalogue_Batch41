package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_HomePage {
    public static By link_HRAdministration = By.xpath("(//span[text()='HR Administration'])[1]");
    public static By lbl_ProfileName = By.xpath("//div[@id='sidebar-profile-picture']/a");
    public static By link_EmployeeManagement = By.xpath("//span[text()='Employee Management']");
    public static By link_travelandExpense = By.xpath("(//a[@data-tooltip='Travel and Expense'])[1]");
    public static By btn_More = By.xpath("//span[text()='More']");
    public static By link_Performance = By.xpath("(//a[@data-tooltip='Performance'])[1]");
    public static By txtbx_Search = By.xpath("//input[@placeholder='Search']");
    public static By link_MyGoals = By.xpath("//div[text()='Goal List']");


    public static void verifyTitle(){
        WebDriver driver = BaseClass.getDriver();

        String title=driver.getTitle();
        String expectedTitle="Employee Management";
        if(title.equalsIgnoreCase(expectedTitle)){
            System.out.println("Title is verified, Login is Successful");
        }else {
            System.out.println("Title is not verified, Login not Successful");
        }
    }
}
