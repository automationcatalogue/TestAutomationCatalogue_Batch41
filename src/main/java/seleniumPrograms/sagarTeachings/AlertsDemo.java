package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://demoqa.com/alerts");
        System.out.println("Demoqa website is loaded");

        driver.findElement(By.xpath("(//button[text()='Click me'])[4]")).click();
        System.out.println("4th Click me button is clicked");
        Thread.sleep(4000);

        Alert al =  driver.switchTo().alert();
        al.sendKeys("Automation Catalogue");
        Thread.sleep(4000);

        al.accept();
        System.out.println("Alert is accepted");

        al.dismiss();
        System.out.println("Alert is dismissed");

        String str = al.getText();
        System.out.println("Alert Text is :"+str);


    }
}
