package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo2 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("Browser is maximized");

        driver.get("https://www.amazon.in/");
        System.out.println("Amazon website is loaded");

        String s1=driver.getTitle();
        System.out.println("Title of the Amazon website is :"+s1);

        driver.navigate().to("https://www.facebook.com");
        System.out.println("Facebook website is loaded");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(5000);

        driver.navigate().forward();

        Thread.sleep(4000);

        driver.quit();
        System.out.println("Closing the browser");

    }
}
