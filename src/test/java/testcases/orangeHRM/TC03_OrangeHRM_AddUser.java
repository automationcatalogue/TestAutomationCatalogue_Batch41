package testcases.orangeHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumPrograms.sagarTeachings.JavaScriptExecutorDemo;
import seleniumPrograms.sagarTeachings.KeysDemo;

import java.time.Duration;

public class TC03_OrangeHRM_AddUser {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Open the Orange HRM Application https://automation41-trials79.orangehrmlive.com

        driver.get("https://testcataloguea-trials79.orangehrmlive.com/auth/login");

        //Enter the UserName as "Admin"
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");

        //Enter the Password as "Admin@123"
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(6000);
//Verify the title of a page --> Whether Login is successful or not
        String Orange_title=driver.getTitle();
        String expected_title="Employee Management";
      if(Orange_title.equalsIgnoreCase(expected_title)){
          System.out.println("Title is verified");

      }
      else {
          System.out.println("Title is not verified");
      }
//Click on HR Administration link
        driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//crud-panel[@listdata='systemUsersCtrl.listData.systemUsers']//table//tbody/tr[1]//span[text()])[1]")));

      //Click on + (Add User) Icon
        driver.findElement(By.xpath("//i[@class='material-icons'][text()='add']")).click();

        //Enter Employee Name as Charlie Carter
        driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys("Charlie Carter");
        driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(Keys.TAB);
 //       Enter some Random UserName ( DOUBT)
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Charlie12345");
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
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Charlie12345");

        //Enter the Password as "Admin@123"
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the Employee Name as Charlie Carter

        String Employee_Name=driver.findElement(By.xpath("")).getText();
        String expected_name="Charlie Carter";
        if(Employee_Name.equalsIgnoreCase(expected_name)){
            System.out.println("Nmae is verified");

        }
        else {
            System.out.println("Name is not verified");
        }
//Click on Logout button

        driver.findElement(By.xpath("//span[@class='profile-name']")).click();

        driver.quit();
    }
}

