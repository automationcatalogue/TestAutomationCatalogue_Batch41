package seleniumPrograms.studentPrograms.ramyaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAddress {
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


        driver.findElement(By.linkText("aarosagarch@gmail.com")).click();
        System.out.println("Clicked on email address link");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div/div[2]/ul/li[2]/a")).click();
        System.out.println("Clicked on Addresses Link");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")).click();
        System.out.println("Clicked on add new button");
        Thread.sleep(2000);

        driver.findElement(By.id("Address_FirstName")).sendKeys("John");
        System.out.println("entered the First Name");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_LastName")).sendKeys("Wick");
        System.out.println("Entered the Last name");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_Email")).sendKeys("john.wick@gmail.com");
        System.out.println("Entered the email address");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_Company")).sendKeys("Universal Studios");
        System.out.println("Entered the company name");
        Thread.sleep(3000);

        Select dropdown = new Select(driver.findElement(By.id("Address_CountryId")));
        dropdown.selectByVisibleText("Canada");
        System.out.println("Click on Canada value from Country drop-down");
        Thread.sleep(3000);

        Select statedropdown = new Select(driver.findElement(By.name("Address.StateProvinceId")));
        statedropdown.selectByVisibleText("Nova Scotia");
        System.out.println("Click on Nova scotia value from state/ province drop-down");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_City")).sendKeys("Halifax");
        System.out.println("entered the city");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_Address1")).sendKeys("99 Escala Cres");
        System.out.println("enetered the address");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("M1R1AK");
        System.out.println("entered the postal code");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_PhoneNumber")).sendKeys("6471234567");
        System.out.println("entered the phone number");
        Thread.sleep(3000);

        driver.findElement(By.id("Address_FaxNumber")).sendKeys("4161234567");
        System.out.println("entered the fax number");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/input")).click();
        System.out.println("clicked on save button");

        driver.findElement(By.linkText("Log out")).click();
        System.out.println("logged out");
        Thread.sleep(3000);
        driver.quit();






    }
}
