package seleniumPrograms.studentPrograms.HarithaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestcase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome driver is launched");
        driver.manage().window().maximize();
        System.out.println("Chrome window is maximized");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("website is launched");

        String title=driver.getTitle();
        System.out.println("Title of the page is:"+title);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        Thread.sleep(3000);
        System.out.println("Username is entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        Thread.sleep(3000);
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[4]/button")).click();
        System.out.println("Login is done");
        Thread.sleep(5000);

        driver.quit();



    }
}
