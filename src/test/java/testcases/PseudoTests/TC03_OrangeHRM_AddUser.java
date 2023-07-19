package testcases.PseudoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC03_OrangeHRM_AddUser {

    public static void main(String args[]) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String userName="CharlieABCG";

        //Open the Orange HRM Application https://automation41-trials79.orangehrmlive.com
        driver.get("https://testcataloguea-trials79.orangehrmlive.com/auth/login");

        //Enter the UserName as "Admin"
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        System.out.println("UserName is Entered");

        //Enter the Password as "Admin@123"
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the title of a page --> Whether Login is successful or not
        String Orange_title=driver.getTitle();
        String expected_title="Employee Management";
        if(Orange_title.equalsIgnoreCase(expected_title)){
              System.out.println("Title is verified");
        }else {
          System.out.println("Title is not verified");
        }

        //Click on HR Administration link
        driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//crud-panel[contains(@listdata='systemUsersCtrl.listData.systemUsers']//table//tbody/tr[1]//span[text()])[1]")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//crud-panel[contains(@listdata,'systemUsers')]//table//tbody/tr[1]//span[text()])[1]")));

        //Click on + (Add User) Icon
        driver.findElement(By.xpath("//i[@class='material-icons'][text()='add']")).click();

        //Enter Employee Name as Charlie Carter
        driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys("Charlie Car");
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
        String Employee_Name=driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']/a")).getText();
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

