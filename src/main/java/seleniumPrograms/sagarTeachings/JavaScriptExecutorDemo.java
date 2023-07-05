package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.com/");
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(4000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,-100)");
        Thread.sleep(4000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//span[text()='Frequently repurchased in Home']"));
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(4000);
        js.executeScript("history.go(0)");
        Thread.sleep(4000);
        js.executeScript("window.location = 'https://testcataloguea-trials79.orangehrmlive.com/auth/seamlessLogin'");
        Thread.sleep(4000);
        String title = js.executeScript("return document.title").toString();
        System.out.println("Title of the webpage is :"+title);
        String url = js.executeScript("return document.URL").toString();
        System.out.println("Current URL is :"+url);
        String domain = js.executeScript("return document.domain;").toString();
        System.out.println("Domain of the webpage is :"+domain);

    }
}
