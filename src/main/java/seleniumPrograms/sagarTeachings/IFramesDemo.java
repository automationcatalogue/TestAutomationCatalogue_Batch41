package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        System.out.println("HDFC NetBanking URL is loaded");

        Thread.sleep(5000);

        //driver.switchTo().frame("login_page");
        //driver.switchTo().frame(0);

        WebElement element_UserId= driver.findElement(By.xpath("//frame[@name='login_page']"));
        driver.switchTo().frame(element_UserId);
        System.out.println("Switched into the iFrame");

        driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("5387653847");
        System.out.println("Customer ID is entered");

        driver.switchTo().defaultContent();
        System.out.println("Exited from the iFrame");


    }
}
