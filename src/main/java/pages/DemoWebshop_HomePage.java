package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.BaseClass;

import java.util.List;

public class DemoWebshop_HomePage {
    public static By link_Login = By.xpath("//a[text()='Log in']");
    public static By link_Email = By.xpath("(//a[@class='account'])[1]");

    public static By link_HeaderBooks = By.xpath("//ul[@class='top-menu']/li[1]/a");
    public static By link_HeaderJewels = By.xpath("//ul[@class='top-menu']/li[6]/a");
    public static By link_ShoppingCart = By.xpath("//div[@class='header-links']/ul/li[3]/a");
    public static By link_mailID = By.xpath("(//a[@href='/customer/info'])[1]");
    public static By link_Address = By.xpath("(//a[text()='Addresses'])[1]");
    public static By btn_Logout = By.xpath("//a[text()='Log out']");
    static Logger log = LogManager.getLogger(DemoWebshop_HomePage.class);

    public static void clickLoginLink() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Login).click();
        log.info("Login Link is clicked");
    }
        public static void clickEmailLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Email).click();
        log.info("Email Link is clicked");
    }
    public static void logout(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Logout).click();
        log.info("log out is clicked");
    }
    public static void clickShoppingCartLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_ShoppingCart).click();
        log.info("Shopping cart link is clicked");
    }
    public static void select_BooksLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_HeaderBooks).click();
        log.info("Clicked on Books link");
    }

    public static void select_JewelsLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_HeaderJewels).click();
        log.info("Clicked on Jewellery link");
    }

    public static void select_ShoppingCart(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_ShoppingCart).click();
        log.info("Clicked on Shopping Cart Link");
    }

    public static void click_mailId(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_mailID).click();
        log.info("clicked on the email.id");

    }

    public static void select_AddressLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_Address).click();
        log.info("clicked on Address ");
    }

    public static void createName(String FN, String LN){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.btn_AddNew).click();
        log.info("Clicked on the Add New Button");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_FirstName).sendKeys(FN);
        log.info("Entered Random First Name");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_LastName).sendKeys(LN);
        log.info("Entered Random last name");
    }

    public static void createEmailAndCompany(String mail,String com){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.link_mailID).sendKeys(mail);
        log.info("Entered Random Email");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_companyName).sendKeys(com);
        log.info("Entered Random company name");

        WebElement element_Country = driver.findElement(DemoWebshop_AddressesPage.dropdown_Country);
        Select select_Country = new Select(element_Country);
        select_Country.selectByVisibleText("India");
        log.info("India is selected from the Country drop-down");
    }

    public static void createCityAndAddresses(String cty, String ad1, String ad2){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.txtbx_City).sendKeys(cty);
        log.info("Entered Random city");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address1).sendKeys(ad1);
        log.info("Entered Random Address1");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address2).sendKeys(ad2);
        log.info("Entered Random Address2");
    }

    public static void createContactNumbers(String zip, String PhNo, String FxNo){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.txtbx_Zipcode).sendKeys(zip);
        log.info("Entered Random Zip code");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Phonenumber).sendKeys(PhNo);
        log.info("Entered Random Phone number");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Faxnumber).sendKeys(FxNo);
        log.info("Entered Fax Number");

        driver.findElement(DemoWebshop_AddressesPage.btn_Save).click();
        log.info("Clicked on Save Button");
    }

    public static void verify_Address(String firstname, String lastname){
        WebDriver driver = BaseClass.getDriver();
        List<WebElement> address_list = driver.findElements(DemoWebshop_AddressesPage.txtbx_AddressList);

        boolean isAddressFound = false;
        for (WebElement name : address_list) {
            String present_name = name.getText();
            if (present_name.equalsIgnoreCase(firstname +lastname)) {
                isAddressFound = true;
                break;
            }
        }
        if (isAddressFound) {
            log.info("Address Creation is successful");
        } else {
            log.info("Address Creation is not successful");
        }
    }
    public static void verifyTitle() {
        WebDriver driver = BaseClass.getDriver();

        String title = driver.getTitle();
        String expectedTitle = "Demo Web Shop";

        BaseClass.failureReason = "Title is not matched";
        Assert.assertEquals(expectedTitle, title, "Title is not matched");
        log.info("Title is verified, Login is Successful");
    }

    public static void logOut(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
        log.info("log out is clicked");
    }
}
