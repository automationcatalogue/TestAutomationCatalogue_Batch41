package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome browser window is maximized");

        driver.get("https://www.google.com");
        System.out.println("Google search is loaded");

        driver.findElement(By.xpath("//textarea[@name='s' or @id='APjFqb']")).sendKeys("India");
        System.out.println("India is entered in google search");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//textarea[@name='q']")).submit();
        //System.out.println("Google Search form is submitted");

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
        System.out.println("3rd option from the drop-down is selected");
    }
}
