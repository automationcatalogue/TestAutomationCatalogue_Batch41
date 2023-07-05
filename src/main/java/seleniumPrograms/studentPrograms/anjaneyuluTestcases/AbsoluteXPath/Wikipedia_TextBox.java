package seleniumPrograms.studentPrograms.anjaneyuluTestcases.AbsoluteXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipedia_TextBox {
    public static void main(String[] args)throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input")).sendKeys("Selenium Automation");
        Thread.sleep(4000);
        driver.quit();
    }
}
