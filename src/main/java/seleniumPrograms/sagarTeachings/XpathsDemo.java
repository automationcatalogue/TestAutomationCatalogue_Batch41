package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathsDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser window is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("Website is loaded");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[4]/button")).click();
        System.out.println("Login button is clicked");

    }
}
