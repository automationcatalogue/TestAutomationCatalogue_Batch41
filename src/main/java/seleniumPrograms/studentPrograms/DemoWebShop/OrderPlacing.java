package seleniumPrograms.studentPrograms.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderPlacing {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("http://demowebshop.tricentis.com/login");

        driver.findElement(By.id("Email")).sendKeys("aarosagarch@gmail.com");

        driver.findElement(By.id("Password")).sendKeys("Admin@123");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();

        driver.findElement(By.partialLinkText("Books")).click();

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();

        driver.findElement(By.linkText("Shopping cart")).click();

        driver.findElement(By.id("termsofservice")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();

        System.out.println("Billing is confirmed");

        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        System.out.println("Shipping Address is selected");
        driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.checkout-page div.page-body.checkout-data:nth-child(2) ol.opc li.tab-section.allow.active:nth-child(2) div.step.a-item div.buttons:nth-child(3) > input.button-1.new-address-next-step-button")).click();
        System.out.println("Shipping Method is selected");
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();

        driver.findElement(By.className("ico-logout")).click();

        driver.quit();
    }
}
