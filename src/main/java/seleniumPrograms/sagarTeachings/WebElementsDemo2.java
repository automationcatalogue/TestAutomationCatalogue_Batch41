package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsDemo2 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser window is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://phppot.com/demo/enable-disable-submit-button-based-on-validation/");
        System.out.println("Website is loaded");

        boolean enabledStatus=driver.findElement(By.name("btn-submit")).isEnabled();
        System.out.println("Element Enabled Status is :"+enabledStatus);

        driver.findElement(By.id("name")).sendKeys("Automation Catalogue");
        System.out.println("Automation Catalogue is entered as Name");
        Thread.sleep(4000);
        driver.findElement(By.id("email")).sendKeys("automationcatalogue.sagar@gmail.com");
        System.out.println("Email is entered");
        Thread.sleep(4000);

        driver.findElement(By.id("email")).sendKeys(Keys.TAB);
        Thread.sleep(4000);

        enabledStatus=driver.findElement(By.name("btn-submit")).isEnabled();
        System.out.println("Element Enabled Status is :"+enabledStatus);

    }
}
