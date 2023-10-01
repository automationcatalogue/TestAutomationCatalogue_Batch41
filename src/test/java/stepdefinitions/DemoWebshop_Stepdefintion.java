package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import testcases.orangeHRM.TC01_OrangeHRM_LoginTest;
import utilities.*;

public class DemoWebshop_Stepdefintion {
    public static WebDriver driver;
    static XSSFWorkbook wbk;
    static String sheetName;
    static int rowNum, row_index;

    static String UserName;
    static String Password;
    static String FirstName, LastName, Email, Company;
    static String City, Address1, Address2;

    static String ZipPostalCode, PhoneNumber, FaxNumber;
    static String testID;

    @Given("User reads CreateAddress Data from {string} using TestID {string}")
    public void readExcelData_CreateAddress(String sheetName, String testID) throws Exception {
        wbk = ExcelUtils.setExcelFilePath();
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        row_index = ExcelUtils.getRowNumber(testID, "Index");
        UserName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        Password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        FirstName = RandomGenerator.getRandomData("firstName");
        LastName = RandomGenerator.getRandomData("lastName");
        Email = RandomGenerator.getRandomEmail(8);
        Company = RandomGenerator.getRandomData("company");
        City = RandomGenerator.getRandomData("city");
        Address1 = RandomGenerator.getRandomData("address1");
        Address2 = RandomGenerator.getRandomData("address2");
        ZipPostalCode = RandomGenerator.getRandomData("zipcode");
        PhoneNumber = RandomGenerator.getRandomData("phoneNumber");
        FaxNumber = RandomGenerator.getRandomNumeric(8);
    }


    @Given("User loads DemoWebshop Application")
    public void user_loads_demo_webshop_application() {
        driver = CommonUtils.browserLaunch(Config.browserName);
        BaseClass ob = new BaseClass(driver);
        driver.get(Config.url_DemoWebshop);
        System.out.println("DemoWebShop Website is launched");
    }

    @When("User login into DemoWebshop Application with UserName {string} and Password {string}")
    public void user_login_into_demo_webshop_application_with_user_name_and_password(String UserName, String Password) {
        DemoWebshop_LoginPage.login(UserName, Password);
    }

    @When("User Opens Address page")
    public void user_opens_address_page() {
        DemoWebshop_HomePage.click_mailId();
        DemoWebshop_HomePage.select_AddressLink();
    }


    @When("User Enters address fields data for FirstName, LastName, Email and Company")
    public void user_enters_address_fields_data_for_first_name_last_name_email_and_company() {
        DemoWebshop_HomePage.createName(FirstName, LastName);

        DemoWebshop_HomePage.createEmailAndCompany(Email, Company);
    }

    @When("User Provides City, Address1, Address2, ZipPostalCode, PhoneNumber and FaxNumber")
    public void user_provides_city_address1_address2_zip_postal_code_phone_number_and_fax_number() {
        DemoWebshop_HomePage.createCityAndAddresses(City, Address1, Address2);

        DemoWebshop_HomePage.createContactNumbers(ZipPostalCode, PhoneNumber, FaxNumber);
    }

    @Then("User Verifies Address is added")
    public void user_verifies_address_is_added() {
        DemoWebshop_HomePage.verify_Address(FirstName, LastName);
    }

    @And("User logout after verification")
    public void User_logout_after_verification() {
        DemoWebshop_HomePage.logOut();
    }
}
