package pages.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class DemoWebshop_AddressesPage {

    static Logger log = LogManager.getLogger(DemoWebshop_HomePage.class);

    public static By btn_AddNew = By.xpath("//input[@value='Add new']");
    public static By txtbx_FirstName = By.cssSelector("#Address_FirstName");
    public static By txtbx_LastName = By.cssSelector("#Address_LastName");
    public static By link_mailID = By.cssSelector("#Address_Email");
    public static By txtbx_companyName = By.cssSelector("#Address_Company");
    public static By dropdown_Country = By.xpath("//select[@id='Address_CountryId']");
    public static By dropdown_State = By.xpath("//select[@id='Address_StateProvinceId']");
    public static By txtbx_City = By.cssSelector("#Address_City");
    public static By txtbx_Address1 = By.cssSelector("#Address_Address1");
    public static By txtbx_Address2 = By.cssSelector("#Address_Address2");
    public static By txtbx_Zipcode = By.cssSelector("#Address_ZipPostalCode");
    public static By txtbx_Phonenumber = By.cssSelector("#Address_PhoneNumber");
    public static By txtbx_Faxnumber = By.cssSelector("#Address_FaxNumber");
    public static By btn_Save = By.xpath("//input[@value='Save']");

    public static By txtbx_AddressList = By.xpath("//div[contains(@class,'st-page')]/div[2]/div[1]/div/div[1]");
    public static String randomCountryName, randomStateName;

    public static void createAddress(String firstName, String lastName, String email, String companyName, String city, String address1, String address2, String zipCode, String phoneNumber, String faxNumber){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.btn_AddNew).click();
        log.info("Clicked on the Add New Button");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_FirstName).sendKeys(firstName);
        log.info(firstName + " is entered as First Name");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_LastName).sendKeys(lastName);
        log.info(lastName + " is entered as last Name");
        driver.findElement(DemoWebshop_AddressesPage.link_mailID).sendKeys(email);
        log.info(email + " is entered as Email");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_companyName).sendKeys(companyName);
        log.info(companyName + " is entered as Company Name");
        randomCountryName = CommonUtils.selectRandomDataFromDropdown(dropdown_Country);
        randomStateName = CommonUtils.selectRandomDataFromDropdown(dropdown_State);
        driver.findElement(DemoWebshop_AddressesPage.txtbx_City).sendKeys(city);
        log.info(city + " is entered as City");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address1).sendKeys(address1);
        log.info(address1 + " is entered as Address1");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address2).sendKeys(address2);
        log.info(address2 + " is entered as Address2");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_Zipcode).sendKeys(zipCode);
        log.info(zipCode + " is entered as ZipCode");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_Phonenumber).sendKeys(phoneNumber);
        log.info(phoneNumber + " is entered as Phone Number");
        driver.findElement(DemoWebshop_AddressesPage.txtbx_Faxnumber).sendKeys(faxNumber);
        log.info(faxNumber + " is entered as Fax Number");
        driver.findElement(DemoWebshop_AddressesPage.btn_Save).click();
        log.info("Clicked on Save Button");
    }

    public static void verifyAddress(String firstname, String lastname){
        WebDriver driver = BaseClass.getDriver();
        List<WebElement> list_Addresses = driver.findElements(DemoWebshop_AddressesPage.txtbx_AddressList);
        boolean isAddressPresent = false;
        for (WebElement address : list_Addresses) {
            String actualName = address.getText();
            if (actualName.equalsIgnoreCase(firstname + " " + lastname)) {
                isAddressPresent = true;
                break;
            }
        }
        Assert.assertTrue(isAddressPresent,"Address is Not Created");
        log.info("New Address is Created for "+(firstname+lastname));
    }

}
