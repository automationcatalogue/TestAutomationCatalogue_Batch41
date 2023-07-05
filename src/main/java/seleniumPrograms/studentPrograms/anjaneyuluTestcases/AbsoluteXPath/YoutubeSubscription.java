package seleniumPrograms.studentPrograms.anjaneyuluTestcases.AbsoluteXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeSubscription {
    public static void main(String[] args)throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        System.out.println("Browser is opened");
        String main = driver.getTitle();
        System.out.println("Title of the main page is:"+main);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div/ytd-guide-section-renderer[1]/div/ytd-guide-entry-renderer[3]/a")).click();
        System.out.println("Subscriptions Icon is clicked");
        String subs = driver.getTitle();
        System.out.println("Title of the Subscriptions page is:"+subs);
        Thread.sleep(5000);
        driver.quit();
        System.out.print("Browser is closed");

    }
}
