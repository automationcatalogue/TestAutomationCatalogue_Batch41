package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("OrangeHRM website is loaded");

        driver.navigate().to("http://demowebshop.tricentis.com/");
        System.out.println("Demo Webshop URL is loaded");

        driver.quit();
        System.out.println("Closing the browser");

    }
}
