package testcases.PseudoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC14_DemoWebshop_ReOrder {

    public static void main(String args[]) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Demo website is loaded");

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        System.out.println("Login link is clicked");

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email ID is entered");


        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        System.out.println("Login Button is clicked");

        driver.findElement(By.xpath("//div[@class='master-wrapper-content']//a[@class='account']")).click();
        System.out.println("Email Link is clicked");

        driver.findElement(By.xpath("//div[@class='block block-account-navigation']//ul//a[text()='Orders']")).click();
        System.out.println("Order link is clicked");

        driver.findElement(By.xpath("//div[@class='order-list']/div[1]//input")).click();
        System.out.println("Order details button is clicked");

        driver.findElement(By.xpath("//input[@type='button'][@value='Re-order']")).click();
        System.out.println("Re-order button is clicked");

        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        System.out.println("Check-box is clicked");

        driver.findElement(By.xpath("//button[@value='checkout']")).click();
        System.out.println("Checkout button is clicked");

        driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
        System.out.println("Continue button is clicked under Billing Address");

        driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
        System.out.println("Continue button is clicked under Shipping Address");

        driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
        System.out.println("Continue button is clicked under Shipping Method");

        driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
        System.out.println("Continue button is clicked under Payment Method");

        driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
        System.out.println("Continue button is clicked under Payment Information");

        driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
        System.out.println("Confirm button is clicked under Confirm Order");

        WebElement element_OrderNumber = driver.findElement(By.xpath("//ul[@class='details']/li[1]"));
        if(element_OrderNumber.isDisplayed()){
            String ordernumber = element_OrderNumber.getText();
            System.out.println("order number is generated "+ordernumber);
        }else{
            System.out.println("OrderNumber is not generated");
        }

        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        System.out.println("log out is clicked");

        driver.close();

    }
}
