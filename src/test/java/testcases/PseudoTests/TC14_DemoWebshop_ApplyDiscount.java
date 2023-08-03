package testcases.PseudoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC14_DemoWebshop_ApplyDiscount {

        public static void main(String args[]) throws Exception{
            WebDriver driver=new ChromeDriver();
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

            driver.findElement(By.xpath("//input[contains(@class,'login-button'])")).click();
            System.out.println("Login Button is clicked");

            driver.findElement(By.xpath("//div//ul[@class='top-menu']//a[@href='/books']")).click();
            System.out.println("Books button is clicked");

            driver.findElement(By.xpath("(//div[@class='product-grid']//input)[1]")).click();
            System.out.println("Add to cart button is clicked");

            driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
            System.out.println("Shopping cart button is clicked");

            String total_BeforeDiscount=driver.findElement(By.xpath("//span[@class='product-price order-total']/strong")).getText();
            System.out.println("value of total:"+total_BeforeDiscount);
            double totalValue_BeforeDiscount = Double.parseDouble(total_BeforeDiscount);

            driver.findElement(By.xpath("(//div[@class='coupon-code']//input)[1]")).click();
            System.out.println("coupon test box is clicked");

            driver.findElement(By.xpath("//input[@name='discountcouponcode']")).sendKeys("AutomationDiscount2");
            System.out.println("coupon code is Entered");

            driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']")).click();
            System.out.println("ApplyCoupon button is clicked");

            String message=driver.findElement(By.xpath("//div[@class='message']")).getText();
            System.out.println("message:"+message);
            if(message.trim().equalsIgnoreCase("The coupon code was applied")){
                System.out.println("Coupon applied successfully");
            }else{
                System.out.println("Coupon applied is not successful");
            }

            String discount = driver.findElement(By.xpath("//span[contains(text(),'Discount')]/..//following-sibling::td/span/span")).getText();
            System.out.println("Applied Discount Amount is :"+discount);
            double discountValue = Double.parseDouble(discount);

            String total_AfterDiscount=driver.findElement(By.xpath("//span[@class='product-price order-total']/strong")).getText();
            System.out.println("After discount value of total:"+total_AfterDiscount);
            double totalValue_AfterDocunt = Double.parseDouble(total_AfterDiscount);

            if(totalValue_AfterDocunt == (totalValue_BeforeDiscount-discountValue)){
                System.out.println("Discount value is correctly applied on Cart and verified");
            }else{
                System.out.println("Discount value is not correctly applied on Cart");
            }

            driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
            System.out.println("check-box is clicked");

            driver.findElement(By.xpath("//button[@id='checkout']")).click();
            System.out.println("Checkout is clicked");

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

