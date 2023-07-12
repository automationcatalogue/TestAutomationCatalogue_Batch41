package tetscases.DemoWebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC14_DemoWebshop_ReOrder {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Demo website is loaded");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        System.out.println("Login link is clicked");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email ID is entered");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin@123");
        System.out.println("Password is entered");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        System.out.println("Login Button is cicked");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='master-wrapper-content']//a[@class='account']")).click();
        System.out.println("Email Link is clicked");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div/div[2]/ul/li[3]/a")).click();
        System.out.println("Order link is clicked");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/div[2]/input")).click();
        System.out.println("Order details button is clicked");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='button'][@value='Re-order']")).click();
        System.out.println("Re-order button is clicked");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        System.out.println("Check-box is clicked");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@value='checkout']")).click();
        System.out.println("Checkout button is clicked");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
        System.out.println("Continue button is clicked under Billing Address");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
        System.out.println("Continue button is clicked under Shipping Address");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
        System.out.println("Continue button is clicked under Shipping Method");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
        System.out.println("Continue button is clicked under Payment Method");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
        System.out.println("Continue button is clicked under Payment Information");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
        System.out.println("Confirm button is clicked under Confirm Order");
        Thread.sleep(2000);

        driver.quit();

    }
}
