package seleniumPrograms.studentPrograms.anjaneyuluTestcases.AbsoluteXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInJobs {
    public static void main(String[] args)throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://in.linkedin.com/");
        System.out.println("Browser is opened");
        String main = driver.getTitle();
        System.out.println("Title of the main login page is:"+main);
        driver.findElement(By.xpath("/html/body/nav/ul/li[4]/a")).click();
        System.out.println("Jobs Icon is clicked");
        String jobs = driver.getTitle();
        System.out.println("Title of the jobs page is:"+jobs);
        Thread.sleep(5000);
        driver.quit();
        System.out.print("Browser is closed");


    }
}
