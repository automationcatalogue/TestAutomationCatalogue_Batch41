package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

    public static void clickLoginLink() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Login).click();
        System.out.println("Login Link is clicked");
    }
        public static void clickEmailLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Email).click();
        System.out.println("Email Link is clicked");
    }
    public static void logout(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Logout).click();
        System.out.println("log out is clicked");
    }
    public static void clickShoppingCartLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_ShoppingCart).click();
        System.out.println("Shopping cart link is clicked");
    }
    public static void select_BooksLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_HeaderBooks).click();
        System.out.println("Clicked on Books link");
    }

    public static void select_JewelsLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_HeaderJewels).click();
        System.out.println("Clicked on Jewellery link");
    }

    public static void select_ShoppingCart(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_ShoppingCart).click();
        System.out.println("Clicked on Shopping Cart Link");
    }

    public static void click_mailId(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_mailID).click();
        System.out.println("clicked on the email.id");

    }

    public static void select_AddressLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.link_Address).click();
        System.out.println("clicked on Address ");
    }

    public static void createName(String FN, String LN){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.btn_AddNew).click();
        System.out.println("Clicked on the Add New Button");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_FirstName).sendKeys(FN);
        System.out.println("Entered Random First Name");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_LastName).sendKeys(LN);
        System.out.println("Entered Random last name");
    }

    public static void createEmailAndCompany(String mail,String com){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.link_mailID).sendKeys(mail);
        System.out.println("Entered Random Email");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_companyName).sendKeys(com);
        System.out.println("Entered Random company name");

        WebElement element_Country = driver.findElement(DemoWebshop_AddressesPage.dropdown_Country);
        Select select_Country = new Select(element_Country);
        select_Country.selectByVisibleText("India");
        System.out.println("India is selected from the Country drop-down");
    }

    public static void createCityAndAddresses(String cty, String ad1, String ad2){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.txtbx_City).sendKeys(cty);
        System.out.println("Entered Random city");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address1).sendKeys(ad1);
        System.out.println("Entered Random Address1");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address2).sendKeys(ad2);
        System.out.println("Entered Random Address2");
    }

    public static void createContactNumbers(String zip, String PhNo, String FxNo){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_AddressesPage.txtbx_Zipcode).sendKeys(zip);
        System.out.println("Entered Random Zip code");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Phonenumber).sendKeys(PhNo);
        System.out.println("Entered Random Phone number");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Faxnumber).sendKeys(FxNo);
        System.out.println("Entered Fax Number");

        driver.findElement(DemoWebshop_AddressesPage.btn_Save).click();
        System.out.println("Clicked on Save Button");
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
            System.out.println("Address Creation is successful");
        } else {
            System.out.println("Address Creation is not successful");
        }
    }

    public static void logOut(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
        System.out.println("log out is clicked");
    }
}
