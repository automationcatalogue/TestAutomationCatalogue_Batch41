package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='txtPassword'][id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        System.out.println("Login button is clicked");
        


    }
}
