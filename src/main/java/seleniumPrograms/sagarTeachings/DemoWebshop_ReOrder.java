package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebshop_ReOrder {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome browser window is maximized");

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Demowebshop website is loaded");

        driver.findElement(By.xpath("//div[@class='header-logo']/..//ul/li[2]/a[@class='ico-login']")).click();
        System.out.println("Login link is clicked");

        driver.findElement(By.xpath("//label[@for='Email']//ancestor::div[1]/input")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email ID is entered");

        driver.findElement(By.xpath("//label[@for='Email']//ancestor::div[1]/input//ancestor::form/div[3]/input")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//input[contains(@class,'login-button')]")).click();
        System.out.println("Login button is clicked");

        driver.findElement(By.xpath("(//div[@class='master-wrapper-page']//a[@class='account'])[1]")).click();
        System.out.println("Email Link is clicked");

        driver.findElement(By.xpath("//div[@class='title']//ancestor::div[@class='block block-account-navigation']//a[text()='Orders']")).click();
        System.out.println("Orders link is clicked");

        driver.findElement(By.xpath("//h1[text()='My account - Orders']//ancestor::div[@class='page account-page order-list-page']/div[2]/div/div[1]//input")).click();
        System.out.println("Order Details button is clicked");

        driver.findElement(By.xpath("//div[@class='page-title']//following::input")).click();
        System.out.println("Re-order button is clicked");

        driver.findElement(By.xpath("//div[@class='cart-footer']//child::input[@id='termsofservice']")).click();
        System.out.println("Check-box is clicked");

        driver.findElement(By.xpath("//div[@class='total-info']//following-sibling::div[3]/button")).click();
        System.out.println("Checkout button is clicked");

        driver.findElement(By.xpath("//h2[text()='Shipping address']//preceding::input[1]")).click();
        System.out.println("Continue button is clicked under Billing Address");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@id='shipping-please-wait']//preceding-sibling::input")).click();
        System.out.println("Continue button is clicked under Shipping Address");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@id='shipping-method-please-wait']//parent::div/input")).click();
        System.out.println("Continue button is clicked under Shipping Method");

        Thread.sleep(1000);

        driver.findElement(By.xpath("(//div[@id='checkout-step-payment-method']//child::input)[5]")).click();
        System.out.println("Continue button is clicked under Payment Method");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/input")).click();
        System.out.println("Continue button is clicked under Payment Information");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/input")).click();
        System.out.println("Confirm button is clicked under Confirm Order");

        Thread.sleep(1000);

        String orderNumber = driver.findElement(By.xpath("//li[contains(text(),'Order number')]")).getText();
        orderNumber = orderNumber.trim();

        String str[]=orderNumber.split(":");

        System.out.println(str[1]);

    }
}
