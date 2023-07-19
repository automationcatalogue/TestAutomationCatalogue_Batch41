package testcases.demoWebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import utilities.CommonUtils;

import java.time.Duration;
import java.util.List;

public class TC12_DemoWebShop_CreateAddress {
    @Test
    @Parameters({"browserName"})
    public void login(@Optional("chrome") String browserName) throws Exception {
        WebDriver driver = CommonUtils.browserLaunch(browserName);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebShop Website is launched");

        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        System.out.println("clicked on login button");

        driver.findElement(DemoWebshop_LoginPage.txtbx_UserName).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email ID is entered");

        driver.findElement(By.cssSelector(".password")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//input[contains(@class,'login-button')]")).click();
        System.out.println("Clicked on login button");

        driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).click();
        System.out.println("clicked on the email.id");

        driver.findElement(By.xpath("(//a[text()='Addresses'])[1]")).click();
        System.out.println("clicked on adresses ");

        driver.findElement(By.xpath("//input[@value='Add new']")).click();
        System.out.println("Clicked on the Add New Button");

        driver.findElement(By.cssSelector("#Address_FirstName")).sendKeys("Rama");
        System.out.println("Entered Random First Name");

        driver.findElement(By.cssSelector("#Address_LastName")).sendKeys("Krishna");
        System.out.println("Entered Random last name");

        driver.findElement(By.cssSelector("#Address_Email")).sendKeys("ram@gmail.com");
        System.out.println("Entered Random Email");

        driver.findElement(By.cssSelector("#Address_Company")).sendKeys("Amazon");
        System.out.println("Entered Random company name");

        WebElement element_Country = driver.findElement(By.xpath("//select[@id='Address_CountryId']"));
        Select select_Country = new Select(element_Country);
        select_Country.selectByVisibleText("India");
        System.out.println("India is selected from the Country drop-down");

        driver.findElement(By.cssSelector("#Address_City")).sendKeys("Hyderabad");
        System.out.println("Entered Random city");

        driver.findElement(By.cssSelector("#Address_Address1")).sendKeys("Uppal");
        System.out.println("Entered Random Address1");

        driver.findElement(By.cssSelector("#Address_Address2")).sendKeys("Ramanthapur");
        System.out.println("Entered Random Address2");

        driver.findElement(By.cssSelector("#Address_ZipPostalCode")).sendKeys("500013");
        System.out.println("Entered Random Zip code");

        driver.findElement(By.cssSelector("#Address_PhoneNumber")).sendKeys("8688881838");
        System.out.println("Entered Random Phone number");

        driver.findElement(By.cssSelector("#Address_FaxNumber")).sendKeys("12354");
        System.out.println("Entered Fax Number");

        driver.findElement(By.xpath("//input[@value='Save']")).click();
        System.out.println("Clicked on Save Button");

        driver.findElement(By.xpath("(//a[text()='Addresses'])[1]")).click();
        System.out.println("Clicked on Address link");

        List<WebElement> address_list = driver.findElements(By.xpath("//div[contains(@class,'st-page')]/div[2]/div[1]/div/div[1]"));

        boolean isAddressFound = false;
        for(WebElement name:address_list){
            String present_name=name.getText();
            if(present_name.equalsIgnoreCase("Rama Krishna")){
                isAddressFound=true;
                break;
            }
        }

        if(isAddressFound){
            System.out.println("Address Creation is successful");
        }else{
            System.out.println("Address Creation is not successful");
        }

        driver.findElement(By.xpath("//a[text()='Log out']")).click();
        System.out.println("Clicked on Log out Button");

        Thread.sleep(6000);

        driver.quit();
        System.out.println("Browser is closed");

    }
}
