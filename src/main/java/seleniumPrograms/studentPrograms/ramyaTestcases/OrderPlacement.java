package seleniumPrograms.studentPrograms.ramyaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderPlacement {


    public static void main(String[] args)throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome driver is launched");

        driver.manage().window().maximize();
        System.out.println("Broser is maximised");

        driver. navigate().to("http://demowebshop.tricentis.com/login");
        System.out.println("Demowebshop is Launched");

        driver.findElement(By.className("ico-login")).click();
        System.out.println("Clicked on Login button");

        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("aarosagarch@gmail.com");
        System.out.println("entered the email address");

        driver.findElement(By.id("Password")).sendKeys("Admin@123");
        System.out.println("entered the password");

        driver. findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
        System.out.println("Clicked on login");

        Thread.sleep(3000);

        driver.findElement(By.linkText("Books")).click();
        System.out.println("Clicked on books link");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();
        System.out.println("Clicked on add to cart button");
        Thread.sleep(3000);

        driver.navigate().refresh();
        System.out.println("refresh and reloaded the webpage");

        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        System.out.println("Clicked on shopping cart link");

        driver.findElement(By.name("termsofservice")).click();
        System.out.println("checkbox for accepting terms and conditions checked.");

       // driver.findElement(By.name("itemquantity3250117")).clear();
        //driver.findElement(By.name("itemquantity3250117")).sendKeys("1");
        driver.findElement(By.id("checkout")).click();
        System.out.println("Clicked on Checkout");

        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
        System.out.println("In the Billing Address section --> click on Continue button");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        System.out.println("In the Shipping method section --> click on Continue button");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
        System.out.println("In the Payment method section --> click on Continue button");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
        System.out.println("In the Payment Information section --> click on Continue button");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
        System.out.println("In the confirm order section --> click on Confirm button");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(3000);
        driver.quit();



    }
}