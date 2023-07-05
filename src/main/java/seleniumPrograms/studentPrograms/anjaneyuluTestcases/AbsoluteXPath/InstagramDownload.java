package seleniumPrograms.studentPrograms.anjaneyuluTestcases.AbsoluteXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramDownload {
    public static void main(String[] args)throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");
        System.out.println("Instagram website is opened");
        WebElement Insta =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/section/main/article/div[2]/div[3]/div[2]/a[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",Insta);
        String InstagramTitle = driver.getTitle();
        System.out.println("Title of the page is:"+InstagramTitle);
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Browser is closed");

    }
}
