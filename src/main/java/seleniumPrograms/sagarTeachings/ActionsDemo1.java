package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemo1 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://testcataloguea-trials79.orangehrmlive.com/");
        Actions action = new Actions(driver);
        WebElement element_username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        action.click(element_username).perform();
        Thread.sleep(2000);
        action.sendKeys("Admin").perform();
        Thread.sleep(2000);

        WebElement element_password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        action.sendKeys(element_password,"Admin@123").perform();

        WebElement element_loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
        action.moveToElement(element_loginbtn);
        action.click();
        action.build().perform();

    }
}
