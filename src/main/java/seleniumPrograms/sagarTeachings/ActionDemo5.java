package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionDemo5 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demoqa.com/text-box");
        WebElement element_userName = driver.findElement(By.cssSelector("#userName"));
        WebElement element_email = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        WebElement element_currentAddress = driver.findElement(By.cssSelector("form[id='userForm']>div:nth-child(3)>div:nth-child(2)>textarea"));
        WebElement element_permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        WebElement element_SubmitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));

        Actions action = new Actions(driver);
        /*action.click(element_userName);
        action.sendKeys("AutomationCatalogue");
        action.build().perform();*/
        action.click(element_userName).sendKeys("AutomationCatalogue").build().perform();

        Thread.sleep(3000);
        action.sendKeys(element_email,"automation.cataglogue@gmail.com").build().perform();

        Thread.sleep(3000);
        element_currentAddress.sendKeys("H.No:15-18, Near tankbund, Hyderabad, India");

        Thread.sleep(3000);
        action.keyDown(element_currentAddress, Keys.CONTROL);
        action.sendKeys("a");
        //action.keyUp(Keys.CONTROL);
        //action.build().perform();

        Thread.sleep(3000);
        //action.keyDown(element_currentAddress, Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        Cookie cookie = new Cookie("","");
        driver.manage().addCookie(cookie);

        Thread.sleep(3000);
        action.keyDown(element_permanentAddress, Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        Thread.sleep(3000);
        element_SubmitBtn.click();

    }
}
