package seleniumPrograms.studentPrograms.Trivenitestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLoginTestCase {
    public static void main(String[] args) throws Exception {
        WebDriver driver=new ChromeDriver();

        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Maximize chrome browser window");

        driver.get("http://demowebshop.tricentis.com/login");
        System.out.println("Demo Webshop URL is loaded");
        Thread.sleep(5000);


        driver.findElement(By.name("Email")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email is entered");
        Thread.sleep(5000);

        driver.findElement(By.id("Password")).sendKeys("Admin@123");
        System.out.println("Password is entered");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
        System.out.println("Login button is clicked");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")).click();
        System.out.println("books list are opened");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();
        System.out.println("first book is added to the cart");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        System.out.println("shopping cart is opened");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();
        System.out.println("Accepting terms and conditions");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        System.out.println("checkout button is clicked");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
        System.out.println("In Billing section continue button is clicked");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        System.out.println("In Shipping Address section continue button is clicked");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
        System.out.println("In Shipping Method section continue button is clicked");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
        System.out.println("In Payment Method section continue button is clicked");
        Thread.sleep(5000);


        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
        System.out.println("In Payment Information section continue button is clicked");
        Thread.sleep(5000);


        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
        System.out.println("In The Order section confirm button is clicked");
        Thread.sleep(5000);


        System.out.println("Order is placed");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        System.out.println("Logout button is clicked");
        Thread.sleep(5000);

        driver.quit();


    }
}
