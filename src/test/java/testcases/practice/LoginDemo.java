package testcases.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginDemo {

    @Test
    public void orangeHRMLogin() throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(6000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Employee abcd";
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));

        driver.quit();
    }

    @Test
    public void demoWebShopLogin(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("aarosagarch@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
    }
}
