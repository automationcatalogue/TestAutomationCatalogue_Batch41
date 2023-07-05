package seleniumPrograms.studentPrograms.anjaneyuluTestcases.AbsoluteXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Paytm {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://paytm.com/");
        System.out.println("Website is opened");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul/li[2]/div/a")).click();
        System.out.println("Paytm for Business is clicked");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul/li[2]/ul/li[4]/div/a")).click();
        System.out.println("Financial Services is clicked");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul/li[2]/ul/li[4]/ul/li[5]/div/a")).click();
        System.out.println("Insurance is clicked");
    }
}
