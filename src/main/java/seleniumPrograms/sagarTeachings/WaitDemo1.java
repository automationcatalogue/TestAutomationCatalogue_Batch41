package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitDemo1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("login_page"));
        //driver.switchTo().frame("login_page");
        driver.findElement(By.cssSelector(".btn.btn-primary.login-btn")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert al = driver.switchTo().alert();
        al.accept();

    }
}
