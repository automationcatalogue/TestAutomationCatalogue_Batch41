package testcases.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Demo1 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test-Demo1!!!!");
        System.out.println("Haritha!!!");
        System.out.println("************************");
    }

    @BeforeClass
    public void browserLaunch(){
        System.out.println("Before Class-Demo1!!!");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("************************");
    }

    @Test (priority = 2)
    public void orangeHRMLogin(){
        System.out.println("Test2-Demo1!!!");
        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("************************");
    }

    @Test (priority = 1)
    public void demoWebshopLogin(){
        System.out.println("Test1-Demo1!!!");
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Demo website is loaded");
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        System.out.println("Login link is clicked");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email ID is entered");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin@123");
        System.out.println("Password is entered");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        System.out.println("************************");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After Class-Demo1!!!");
        driver.quit();
        System.out.println("************************");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("After Suite-Demo3");
        System.out.println("Ravali!!!");
        System.out.println("***********************");
    }

}
