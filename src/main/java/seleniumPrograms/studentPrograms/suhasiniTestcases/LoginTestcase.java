package seleniumPrograms.studentPrograms.suhasiniTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestcase {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("maximized chrome browser is launched");

        driver.get("https://automation41-trials79.orangehrmlive.comauth/login");
        System.out.println("website is loaded");

        String title = driver.getTitle();
        System.out.println("Title of the page is" + title);

        driver.findElement(By.name("txtusername")).sendKeys("suhasini0903@gmail.com");
        System.out.println("Email is entered");
        Thread.sleep(4000);

        driver.findElement(By.id("txtpassword")).sendKeys("Sravani1984");
        System.out.println("password is entered");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"frmlogin\"]/div[4]/button")).click();
        System.out.println("login button is clicked");

        Thread.sleep(4000);

        driver.close();
        System.out.println("closing browser");


    }
}
