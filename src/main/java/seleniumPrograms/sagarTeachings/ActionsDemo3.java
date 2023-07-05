package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemo3 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://jqueryui.com/droppable/");

        WebElement element_frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(element_frame);
        Thread.sleep(3000);

        Actions action = new Actions(driver);
        WebElement element_source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement element_target = driver.findElement(By.xpath("//div[@id='droppable']"));

        //action.dragAndDrop(element_source, element_target).perform();
        action.clickAndHold(element_source);
        action.moveToElement(element_target);
        action.release(element_target).build().perform();
    }
}
