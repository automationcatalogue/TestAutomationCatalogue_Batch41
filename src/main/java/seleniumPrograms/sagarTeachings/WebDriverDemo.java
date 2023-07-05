package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {

    public static void main(String[] args) {
        System.out.println("This is first Selenium WebDriver program");

        WebDriver ob = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        ob.get("https://www.gmail.com");
        System.out.println("Gmail website is opened");

        ob.get("https://www.facebook.com");
        System.out.println("Facebook website is opened");
    }

}
