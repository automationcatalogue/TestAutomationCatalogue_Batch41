package seleniumPrograms.studentPrograms.Trivenitestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testcataloguea-trials79.orangehrmlive.com/auth/login");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //username
       js.executeScript("document.getElementById('txtUsername').value='Admin'");

        //password
        WebElement element_password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
       js.executeScript("arguments[0].value='Admin@123';",element_password);

        //Login button
        WebElement element_loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].click();",element_loginBtn);

    }
}
