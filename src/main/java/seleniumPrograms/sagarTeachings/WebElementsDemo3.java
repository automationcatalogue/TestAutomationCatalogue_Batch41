package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsDemo3 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser window is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://demowebshop.tricentis.com/login");
        System.out.println("Website is loaded");

        WebElement element_checkobx = driver.findElement(By.id("RememberMe"));

        boolean b = element_checkobx.isSelected();
        System.out.println("Element selected Status is :"+b);
        Thread.sleep(2000);

        element_checkobx.click();
        System.out.println("Remember is check-box is clicked");
        Thread.sleep(2000);

        b = element_checkobx.isSelected();
        System.out.println("Element selected Status is :"+b);

    }
}
