package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestcase {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Maximized Chrome browser window");

        driver.get("https://www.facebook.com");
        System.out.println("Facebook website is loaded");

        String title=driver.getTitle();
        System.out.println("Title of the page is :"+title);

        Thread.sleep(3000);

        driver.findElement(By.name("email")).sendKeys("sagar.automationcatalogue@gmail.com");
        System.out.println("Email is entered");

        Thread.sleep(3000);

        driver.findElement(By.id("pass")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        Thread.sleep(3000);

        driver.findElement(By.xpath("login")).click();
        System.out.println("Login button is clicked");

        Thread.sleep(3000);

        driver.quit();
        System.out.println("Closed the chrome browser");



    }
}
