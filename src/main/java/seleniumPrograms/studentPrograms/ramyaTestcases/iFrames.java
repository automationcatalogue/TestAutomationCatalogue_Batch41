package seleniumPrograms.studentPrograms.ramyaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrames {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Browser is maximised");

        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_intro_inner_html");
        System.out.println("W3schools URL is launched");
        Thread.sleep(5000);

        //driver.findElement(By.xpath("//button[text()='Click Me!']")).click();
        //System.out.println("Clicked on click me button");

        driver.switchTo().frame("iframeResult");
        System.out.println("Switched to the frame");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[text()='Click Me!']")).click();
        System.out.println("Clicked on click me button");
        Thread.sleep(5000);

        driver.switchTo().defaultContent();
        System.out.println("Came out of the iframe");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@id='runbtn']")).click();
        System.out.println("Clicked on Run button");
        Thread.sleep(5000);

        driver.switchTo().frame("iframeResult");
        System.out.println("Switched back to the iframe");
        Thread.sleep(5000);

        WebElement textElement=driver.findElement(By.xpath("//p[text()='JavaScript can change HTML content.']"));
        String text = textElement.getText();
        System.out.println("Text in the iframe :"+textElement);

        driver.close();
        System.out.println("Browser is closed");

    }
}
