package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;

public class OrangHRM_AddUserPage {
    public static By txtbx_EmployeeName = By.xpath("//input[@id='selectedEmployee_value']");
    public static By icon_AddUser = By.xpath("//i[@class='material-icons'][text()='add']");

    public static By txtbx_RandomUserName = By.xpath("//input[@id='user_name']");
    public static By txtbx_Pwd = By.xpath("//input[@placeholder='Enter Password']");
    public static By txtbx_ConfirmPwd = By.xpath("//input[@placeholder='Confirm Password']");
    public static By btn_Save = By.xpath("//button[@id='modal-save-button']");

    public static By empName_Visibility = By.xpath("//div[@id='systemUserDiv']//table//tbody/tr[1]/td[2]//span[text()]");
    public static By empName_DropdownVisibility = By.xpath("//div[@id='selectedEmployee_dropdown']//div[@class='title-section']");
public static void clickAddUser(){
    WebDriver driver=BaseClass.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(empName_Visibility));
    driver.findElement(icon_AddUser).click();

}
    public static void enterAddUserDetails(String empName,String userName, String password, String confirm_pwd) {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        //Enter Employee Name as Charlie Carter
        driver.findElement(txtbx_EmployeeName).sendKeys(empName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(empName_DropdownVisibility));
        driver.findElement(empName_DropdownVisibility).click();
        //Enter some Random UserName
        driver.findElement(txtbx_RandomUserName).sendKeys(userName);
        //Enter the Password as "Admin@123"
        driver.findElement(txtbx_Pwd).sendKeys(password);
        //Enter the Confirm Password as "Admin@123"
        driver.findElement(txtbx_ConfirmPwd).sendKeys(confirm_pwd);
}        public static void clickSave()
{         WebDriver driver=BaseClass.getDriver();
    //Click on Save button
    WebElement element_SaveBtn =  driver.findElement(btn_Save);
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();",element_SaveBtn);
}
}