package seleniumPrograms.sagarTeachings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class TakeScreenshotDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testcataloguea-trials79.orangehrmlive.com/auth/login");

        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\AutomationCatalogue\\Screenshots\\Batch41\\OrangeHRM_LoginPage.jpg");
        FileUtils.copyFile(src, dest);

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));



        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[3]")));

        src = ts.getScreenshotAs(OutputType.FILE);
        dest = new File("C:\\AutomationCatalogue\\Screenshots\\Batch41\\OrangeHRM_HomePage.jpg");
        FileUtils.copyFile(src,dest);


        driver.quit();
    }
}
