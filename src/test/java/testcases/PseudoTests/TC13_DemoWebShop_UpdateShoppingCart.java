package testcases.PseudoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC13_DemoWebShop_UpdateShoppingCart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        System.out.println("Clicked on the login link");

        driver.findElement(By.cssSelector("#Email")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Entered Email id");

        driver.findElement(By.cssSelector("#Password")).sendKeys("Admin@123");
        System.out.println("Password is Entered");

        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        System.out.println("Clicked on the Login button");

        driver.findElement(By.xpath("//ul[@class='top-menu']/li[1]/a")).click();
        System.out.println("Clicked on Books link");

        driver.findElement(By.xpath("//div[@class='product-grid']//a[1]")).click();
        System.out.println("Clicked on first item in books ");

        driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
        System.out.println("Clicked on Add to Cart Button in Books");

        driver.findElement(By.xpath("//ul[@class='top-menu']/li[6]/a")).click();
        System.out.println("Clicked on Jewellery link");

        driver.findElement(By.xpath("//div[@class='product-grid']//a[1]")).click();
        System.out.println("Clicked on first item in jewellery ");

        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("10");

        driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
        System.out.println("Clicked on Add to Cart Button in Jewellery");

        driver.findElement(By.xpath("//div[@class='header-links']/ul/li[3]/a")).click();
        System.out.println("Clicked on Shopping Cart Link");

        String actual_updateQty="2";

        WebElement total1 = driver.findElement(By.xpath("(//table[@class='cart']/tbody/tr)[1]/td[6]/span[2]"));
        String total_1 = total1.getText();
        System.out.println("Total of the first item before increasing the quantity is :" + total_1);

        WebElement books_qty1 = driver.findElement(By.xpath("(//table[@class='cart']/tbody/tr/td[5]/input)[1]"));
        books_qty1.clear();
        books_qty1.sendKeys(actual_updateQty);
        System.out.println("Quantity is increased in first item");

        WebElement total2 = driver.findElement(By.xpath("(//table[@class='cart']/tbody/tr)[2]/td[6]/span[2]"));
        String total_2 = total2.getText();
        System.out.println("Total of the second item before increasing the quantity is :" + total_2);


        WebElement jewel_qty2 = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr[2]/td[5]/input"));
        jewel_qty2.clear();
        jewel_qty2.sendKeys(actual_updateQty);
        System.out.println("Quantity is increased in second item");

        driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
        System.out.println("Clicked on the Update cart button");

        String text_BookPrice = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[4]/span[2]")).getText();
        String text_updatedQuty = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr[1]//input[contains(@name,'itemquantity')]")).getAttribute("value");

        if(actual_updateQty.equalsIgnoreCase(text_updatedQuty)){

            System.out.println("Update Quantity is successful for Book Item!!!");
            String text_BookTotalPrice = driver.findElement(By.xpath("(//table[@class='cart']/tbody/tr)[1]/td[6]/span[2]")).getText();

            double bookPrice = Double.parseDouble(text_BookPrice);
            double updateQty = Double.parseDouble(text_updatedQuty);
            double bookTotalPrice = Double.parseDouble(text_BookTotalPrice);

            double expectedTotalPrice = bookPrice * updateQty;
            if(expectedTotalPrice == bookTotalPrice){
                System.out.println("Update Shopping Cart is successful for Book Item and Price is matched i.e :"+bookTotalPrice);
            }else{
                System.out.println("Update Shopping Cart is not successful for Book Item and Price is not matched!!!");
            }

        }else{
            System.out.println("Update Quantity is not successful for Book Item!!!");
        }

        String text_JewelPrice = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr[2]/td[4]/span[2]")).getText();
        String text_updatedQutyJew = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr[2]//input[contains(@name,'itemquantity')]")).getAttribute("value");
        if(actual_updateQty.equalsIgnoreCase(text_updatedQutyJew)){

            System.out.println("Update Quantity is successful for Jewel Item!!!");
            String text_JewelTotalPrice = driver.findElement(By.xpath("(//table[@class='cart']/tbody/tr)[2]/td[6]/span[2]")).getText();

            double JewelPrice = Double.parseDouble(text_JewelPrice);
            double updateQty = Double.parseDouble(text_updatedQuty);
            double JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);

            double expectedTotalPrice = JewelPrice * updateQty;
            if(expectedTotalPrice == JewelTotalPrice){
                System.out.println("Update Shopping Cart is successful for Jewel Item and Price is matched i.e :"+JewelTotalPrice);
            }else{
                System.out.println("Update Shopping Cart is not successful for Jewel Item and Price is not matched!!!");
            }

        }else{
            System.out.println("Update Quantity is not successful for Jewel Item!!!");
        }

        String text_BookTotalPrice = driver.findElement(By.xpath("(//table[@class='cart']/tbody/tr)[1]/td[6]/span[2]")).getText();
        double dou_BookTotalPrice = Double.parseDouble(text_BookTotalPrice);
        String text_JewelTotalPrice = driver.findElement(By.xpath("(//table[@class='cart']/tbody/tr)[2]/td[6]/span[2]")).getText();
        double dou_JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);


        double grandTotal=dou_BookTotalPrice+dou_JewelTotalPrice;
        String actualTotal=driver.findElement(By.xpath("//table[@class='cart-total']//tr[4]/td[2]/span/span")).getText();
        double TOTAL=Double.parseDouble(actualTotal);

        if(grandTotal==TOTAL){
            System.out.println("Cart total is accurate i.e :"+TOTAL);
        }else{
            System.out.println("Cart total is not accurate");
        }

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

        String Ordernumber = driver.findElement(By.xpath("//ul[@class='details']/li[1]")).getText();
        System.out.println(Ordernumber);

        if(Ordernumber.equalsIgnoreCase(Ordernumber)){
            System.out.println("order number is printed");
        }else{
            System.out.println("order number is not printed");
        }

        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        System.out.println("log out is clicked");

        driver.quit();
        System.out.println("Browser is closed");

    }
}
