package seleniumPrograms.studentPrograms.anjaneyuluTestcases.AbsoluteXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MonsterMobileNumber {
    public static void main(String[] args)throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.foundit.in/");
        driver.findElement(By.xpath("/html/body/div[4]/section/div[1]/div[3]/div[1]")).click();
        System.out.println("Register Button is clicked");
        WebElement mobile = driver.findElement(By.xpath("/html/body/div[3]/div/section/div/div[1]/div[8]/div/div[2]/input"));
        mobile.click();
        mobile.sendKeys("9999999999");
        System.out.println("Mobile Number was entered");
        Thread.sleep(5000);
        driver.quit();

    }
}
