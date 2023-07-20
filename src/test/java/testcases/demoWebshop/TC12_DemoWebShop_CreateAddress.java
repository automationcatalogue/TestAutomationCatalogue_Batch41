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
import pages.*;
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

        driver.findElement(DemoWebshop_LoginPage.txtbx_Password).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(DemoWebshop_LoginPage.btn_login).click();
        System.out.println("Clicked on login button");

        driver.findElement(DemoWebshop_HomePage.link_mailID).click();
        System.out.println("clicked on the email.id");

        driver.findElement(DemoWebshop_HomePage.link_Address).click();
        System.out.println("clicked on adresses ");

        driver.findElement(DemoWebshop_AddressesPage.btn_AddNew).click();
        System.out.println("Clicked on the Add New Button");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_FirstName).sendKeys("Rama");
        System.out.println("Entered Random First Name");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_LastName).sendKeys("Krishna");
        System.out.println("Entered Random last name");

        driver.findElement(DemoWebshop_AddressesPage.link_mailID).sendKeys("ram@gmail.com");
        System.out.println("Entered Random Email");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_companyName).sendKeys("Amazon");
        System.out.println("Entered Random company name");

        WebElement element_Country = driver.findElement(DemoWebshop_AddressesPage.dropdown_Country);
        Select select_Country = new Select(element_Country);
        select_Country.selectByVisibleText("India");
        System.out.println("India is selected from the Country drop-down");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_City).sendKeys("Hyderabad");
        System.out.println("Entered Random city");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address1).sendKeys("Uppal");
        System.out.println("Entered Random Address1");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address2).sendKeys("Ramanthapur");
        System.out.println("Entered Random Address2");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Zipcode).sendKeys("500013");
        System.out.println("Entered Random Zip code");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Phonenumber).sendKeys("8688881838");
        System.out.println("Entered Random Phone number");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Faxnumber).sendKeys("12354");
        System.out.println("Entered Fax Number");

        driver.findElement(DemoWebshop_AddressesPage.btn_Save).click();
        System.out.println("Clicked on Save Button");

        driver.findElement(DemoWebshop_CartPage.txtbx_Address).click();
        System.out.println("Clicked on Address link");

        List<WebElement> address_list = driver.findElements(DemoWebshop_CartPage.Link_Address);

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

        driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
        System.out.println("Clicked on Log out Button");

        Thread.sleep(6000);

        driver.quit();
        System.out.println("Browser is closed");

    }
}
