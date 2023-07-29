package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import pages.DemoWebshop_AddressesPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import utilities.CommonUtils;

import javax.naming.Name;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import static org.testng.reporters.jq.BasePanel.C;

public class TC12_DemoWebShop_CreateAddress {
    String ProjectPath;
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


    @BeforeClass
    public void prerequisite_setup() throws Exception{
        ProjectPath = System.getProperty("user.dir");
         fis = new FileInputStream(ProjectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
         wbk = new XSSFWorkbook(fis);
         sh = wbk.getSheet("DemoWebShop Create Address");
         row = sh.getRow(1);

         cell_UserName = row.getCell(3);
         UserName = cell_UserName.getStringCellValue();
         System.out.println("Email from Excel sheet is :"+UserName);

         cell_Password = row.getCell(4);
         Password = cell_Password.getStringCellValue();
         System.out.println("Password from Excel sheet is:"+Password);

         cell_FirstName = row.getCell(5);
         FirstName = cell_FirstName.getStringCellValue();
         System.out.println("FirstName from Excel sheet is: "+FirstName);

        cell_LastName = row.getCell(6);
        LastName = cell_LastName.getStringCellValue();
        System.out.println("LastName from Excel sheet is: "+LastName);

        cell_Email = row.getCell(7);
        Email = cell_Email.getStringCellValue();
        System.out.println("Email from Excel sheet is:"+Email);

        cell_Company = row.getCell(8);
        Company = cell_Company.getStringCellValue();
        System.out.println("Company from Excel sheet is: "+Company);

        cell_City = row.getCell(9);
        City = cell_City.getStringCellValue();
        System.out.println("City from Excel sheet is: "+City);

        cell_Address1 = row.getCell(10);
        Address1 = cell_Address1.getStringCellValue();
        System.out.println("Address1 from Excel sheet is: "+Address1);

        cell_Address2 = row.getCell(11);
        Address2 = cell_Address2.getStringCellValue();
        System.out.println("Address from Excel sheet is: "+Address2);

        cell_ZipPostalCode = row.getCell(12);
        ZipPostalCode = cell_ZipPostalCode.getStringCellValue();
        System.out.println("ZipPostalCode from Excel sheet is: "+ZipPostalCode);

        cell_PhoneNumber = row.getCell(13);
        PhoneNumber = cell_PhoneNumber.getStringCellValue();
        System.out.println("PhoneNumber from Excel sheet is: "+PhoneNumber);

        cell_FaxNumber = row.getCell(14);
        FaxNumber = cell_FaxNumber.getStringCellValue();
        System.out.println("FaxNumber from Excel sheet is:"+FaxNumber);
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
    @AfterClass
    public void tearDown() throws Exception{
        fis.close();
        System.out.println("Excel file reading is closed");
    }

}
