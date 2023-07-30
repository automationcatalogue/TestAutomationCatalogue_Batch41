package testcases.orangeHRM;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OrangHRM_AddUserPage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import seleniumPrograms.sagarTeachings.JavaScriptExecutorDemo;
import seleniumPrograms.sagarTeachings.KeysDemo;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.RandomGenerator;

import java.time.Duration;

public class TC03_OrangeHRM_AddUser {
    @Test
    @Parameters({"browserName"})
    public void login(@Optional("chrome") String browserName) throws Exception{
        WebDriver driver= CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        String userName = RandomGenerator.getRandomData("userName");
        System.out.println("Randomly generated username is :"+userName);

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");

        //Enter the UserName as "Admin"
        OrangeHRM_LoginPage.login("Admin","Admin@123");

        OrangeHRM_HomePage.verifyTitle();

        //Click on HR Administration link
        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='systemUserDiv']//table//tbody/tr[1]/td[2]//span[text()]")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//crud-panel[contains(@listdata,'systemUsers')]//table//tbody/tr[1]//span[text()])[1]")));

        //Click on + (Add User) Icon
        driver.findElement(By.xpath("//i[@class='material-icons'][text()='add']")).click();

        //Enter Employee Name as Charlie Carter
        driver.findElement(OrangHRM_AddUserPage.txtbx_EmployeeName).sendKeys("Charlie Car");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='selectedEmployee_dropdown']//div[@class='title-section']")));
        driver.findElement(By.xpath("//div[@id='selectedEmployee_dropdown']//div[@class='title-section']")).click();

        //Enter some Random UserName
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        //Enter the Password as "Admin@123"
        driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Admin@123");

        //Enter the Confirm Password as "Admin@123"
        driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("Admin@123");

        //Click on Save button
        WebElement element_SaveBtn =  driver.findElement(By.xpath("//button[@id='modal-save-button']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element_SaveBtn);

        //Click on Logout button
        driver.findElement(By.xpath("//span[@class='profile-name'][text()='Log Out']")).click();

        //Enter the UserName as "Charlie"
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);

        //Enter the Password as "Admin@123"
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the Employee Name as Charlie Carter
        String Employee_Name=driver.findElement(OrangeHRM_HomePage.lbl_ProfileName).getText();
        String expected_name="Charlie Carter";
        if(Employee_Name.equalsIgnoreCase(expected_name)){
            System.out.println("UserName is matched and verified");
        }else {
            System.out.println("UserName is not matched");
        }

        //Click on Logout button
        driver.findElement(By.xpath("//span[@class='profile-name'][text()='Log Out']")).click();

        driver.quit();
    }
}

