package javaPrograms.exceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='abcd']")).sendKeys("India");



    }
}
