package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BaseClass;

public class OrangeHRM_HomePage {
    public static By link_HRAdministration = By.xpath("(//span[text()='HR Administration'])[1]");
    public static By lbl_ProfileName = By.xpath("//div[@id='sidebar-profile-picture']/a");
    public static By link_EmployeeManagement = By.xpath("(//a[@data-tooltip='Employee Management'])[1]");
    public static By link_travelandExpense = By.xpath("(//a[@data-tooltip='Travel and Expense'])[1]");
    public static By btn_More = By.xpath("//span[text()='More']");
    public static By link_Performance = By.xpath("(//a[@data-tooltip='Performance'])[1]");
    public static By txtbx_Search = By.xpath("//input[@placeholder='Search']");
    public static By link_MyGoals = By.xpath("//div[text()='Goal List']");


    public static void verifyTitle() {
        WebDriver driver = BaseClass.getDriver();

        String title = driver.getTitle();
        String expectedTitle = "Employee Management";

        BaseClass.failureReason = "Title is not matched";
        Assert.assertEquals(expectedTitle, title, "Title is not matched");
        System.out.println("Title is verified, Login is Successful");
    }

    public static void clickEmployeeManagementLink() throws Exception {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emp_mgmt = driver.findElement(link_EmployeeManagement);
        js.executeScript("arguments[0].click();", emp_mgmt);
        System.out.println("Employee Management is selected");
    }

    public static void clickHrAdministrationLink() throws Exception{

        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_HRAdministration).click();
    }

        public static void verify_empName(String empName){
        WebDriver driver=BaseClass.getDriver();
        String Employee_Name=driver.findElement(lbl_ProfileName).getText();
            String expected_name=empName;
            if(Employee_Name.equalsIgnoreCase(expected_name)){
                System.out.println("UserName is matched and verified");
            }else {
                System.out.println("UserName is not matched");
            }
        }

        public static void select_Performance(){
            WebDriver driver = BaseClass.getDriver();
            driver.findElement(OrangeHRM_HomePage.btn_More).click();
            driver.findElement(OrangeHRM_HomePage.link_Performance).click();
    }

    public static void select_MyGoals() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_HomePage.txtbx_Search).sendKeys("Goal List");
        driver.findElement(OrangeHRM_HomePage.link_MyGoals).click();

    }
    public static void clickTRavelExpLink(){

        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement travelexp_Element = driver.findElement(By.xpath("(//a[@data-tooltip='Travel and Expense'])[1]"));
        travelexp_Element.click();
        js.executeScript("arguments[0].click;", travelexp_Element);
        System.out.println("Travel and Expense is selected");
    }

    public static void clickLogout() {
        WebDriver driver = BaseClass.getDriver();
        //Click on Logout button
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
    }
}

