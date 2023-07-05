package seleniumPrograms.studentPrograms.aparnaTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage
{
    public static void main (String[] args ) throws Exception
    {
        WebDriver driver = new ChromeDriver();

        System.out.println("Chrome browser is launched");

        driver.navigate().to("http://demowebshop.tricentis.com/login/");
        System.out.println("Demo Webshop URL is loaded");

        String title = driver.getTitle();
        System.out.println("Title of the page is " + title);

        driver.findElement(By.id("Email")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email is entered ");
         Thread.sleep(3000);
        driver.findElement(By.id("Password")).sendKeys("Admin@123");
        System.out.println("Password is entered");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
        System.out.println("Login button clicked");
        Thread.sleep(3000);

    }


}
