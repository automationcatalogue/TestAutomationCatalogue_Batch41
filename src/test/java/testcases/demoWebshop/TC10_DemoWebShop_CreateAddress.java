package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import pages.DemoWebshop_AddressesPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;
import utilities.RandomGenerator;

import java.io.FileInputStream;
import java.util.List;

public class TC10_DemoWebShop_CreateAddress {
    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_UserName;
    static String UserName;
    static XSSFCell cell_Password;
    static String Password;
    static XSSFCell cell_FirstName;
    static String FirstName;
    static XSSFCell cell_LastName;
    static String LastName;
    static XSSFCell cell_Email;
    static String Email;
    static XSSFCell cell_Company;
    static String Company;
    static XSSFCell cell_City;
    static String City;
    static XSSFCell cell_Address1;
    static String Address1;
    static XSSFCell cell_Address2;
    static String Address2;
    static XSSFCell cell_ZipPostalCode;
    static String ZipPostalCode;
    static XSSFCell cell_PhoneNumber;
    static String PhoneNumber;
    static XSSFCell cell_FaxNumber;
    static String FaxNumber;
    static String projectPath;
    static String sheetName;
    static int rowNum;

    @BeforeClass
    public void prerequisite_setup() throws Exception {
        wbk = ExcelUtils.setExcelFilePath();
        sheetName = "DemoWebshop_CreateAddress";
        rowNum = ExcelUtils.getRowNumber(Config.TestCase_ID, sheetName);

        UserName = ExcelUtils.getCellData(sheetName, 1, Config.col_UserName);
        System.out.println("Email from Excel sheet is :" + UserName);

        Password = ExcelUtils.getCellData(sheetName, 1, Config.col_Password);
        System.out.println("Password from Excel sheet is:" + Password);

        FirstName = RandomGenerator.getRandomData("firstName");
        ExcelUtils.setCellData(FirstName, sheetName,rowNum, Config.col_createAddress_FirstName);

        LastName = RandomGenerator.getRandomData("lastName");
        ExcelUtils.setCellData(LastName, sheetName,rowNum, Config.col_createAddress_LastName);

        Email = RandomGenerator.getRandomEmail(8);
        ExcelUtils.setCellData(Email, sheetName, rowNum, Config.col_createAddress_Email);

        Company = RandomGenerator.getRandomData("company");
        ExcelUtils.setCellData(Company, sheetName, rowNum, Config.col_createAddress_Company);

        City = RandomGenerator.getRandomData("city");
        Address1 = RandomGenerator.getRandomData("address1");
        Address2 = RandomGenerator.getRandomData("address2");
        ZipPostalCode = RandomGenerator.getRandomData("zipcode");
        PhoneNumber = RandomGenerator.getRandomData("phoneNumber");
        FaxNumber = RandomGenerator.getRandomNumeric(8);
    }

    @Test
    @Parameters({"browserName"})
    public void login(@Optional("chrome") String browserName) throws Exception {
        WebDriver driver = CommonUtils.browserLaunch(browserName);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebShop Website is launched");

        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        System.out.println("clicked on login button");

        driver.findElement(DemoWebshop_LoginPage.txtbx_UserName).sendKeys(UserName);
        System.out.println("Email ID is entered");

        driver.findElement(DemoWebshop_LoginPage.txtbx_Password).sendKeys(Password);
        System.out.println("Password is entered");

        driver.findElement(DemoWebshop_LoginPage.btn_Login).click();
        System.out.println("Clicked on login button");

        driver.findElement(DemoWebshop_HomePage.link_mailID).click();
        System.out.println("clicked on the email.id");

        driver.findElement(DemoWebshop_HomePage.link_Address).click();
        System.out.println("clicked on Address ");

        driver.findElement(DemoWebshop_AddressesPage.btn_AddNew).click();
        System.out.println("Clicked on the Add New Button");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_FirstName).sendKeys(FirstName);
        System.out.println("Entered Random First Name");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_LastName).sendKeys(LastName);
        System.out.println("Entered Random last name");

        driver.findElement(DemoWebshop_AddressesPage.link_mailID).sendKeys(Email);
        System.out.println("Entered Random Email");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_companyName).sendKeys(Company);
        System.out.println("Entered Random company name");

        WebElement element_Country = driver.findElement(DemoWebshop_AddressesPage.dropdown_Country);
        Select select_Country = new Select(element_Country);
        select_Country.selectByVisibleText("India");
        System.out.println("India is selected from the Country drop-down");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_City).sendKeys(City);
        System.out.println("Entered Random city");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address1).sendKeys(Address1);
        System.out.println("Entered Random Address1");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Address2).sendKeys(Address2);
        System.out.println("Entered Random Address2");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Zipcode).sendKeys(ZipPostalCode);
        System.out.println("Entered Random Zip code");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Phonenumber).sendKeys(PhoneNumber);
        System.out.println("Entered Random Phone number");

        driver.findElement(DemoWebshop_AddressesPage.txtbx_Faxnumber).sendKeys(FaxNumber);
        System.out.println("Entered Fax Number");

        driver.findElement(DemoWebshop_AddressesPage.btn_Save).click();
        System.out.println("Clicked on Save Button");

        driver.findElement(DemoWebshop_HomePage.link_Address).click();
        System.out.println("Clicked on Address link");

        List<WebElement> address_list = driver.findElements(DemoWebshop_AddressesPage.txtbx_AddressList);

        boolean isAddressFound = false;
        for (WebElement name : address_list) {
            String present_name = name.getText();
            if (present_name.equalsIgnoreCase("Rama Krishna")) {
                isAddressFound = true;
                break;
            }
        }

        if (isAddressFound) {
            System.out.println("Address Creation is successful");
        } else {
            System.out.println("Address Creation is not successful");
        }

        driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
        System.out.println("Clicked on Log out Button");

        Thread.sleep(6000);

        driver.quit();
        System.out.println("Browser is closed");

    }

    @AfterClass
    public void tearDown() throws Exception {
        fis.close();
        System.out.println("Excel file reading is closed");
    }

}
