package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemo4 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement element_btn = driver.findElement(By.xpath("//span[text()='right click me']"));

        Actions action = new Actions(driver);
        action.contextClick(element_btn).build().perform();
        Thread.sleep(3000);
        WebElement element_PasteBtn = driver.findElement(By.xpath("//span[text()='Paste']"));
        action.click(element_PasteBtn).perform();
        Thread.sleep(3000);
        Alert al = driver.switchTo().alert();
        al.accept();
        Thread.sleep(3000);
        WebElement element_doubleBtn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        action.doubleClick(element_doubleBtn).perform();
        Thread.sleep(3000);
        al = driver.switchTo().alert();
        al.accept();


    }
}
