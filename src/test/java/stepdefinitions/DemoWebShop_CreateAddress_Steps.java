package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.DemoWebShop_AddressesPage;
import pages.demoWebshop.DemoWebShop_HomePage;
import runner.CucumberHooks;
import utilities.*;

public class DemoWebShop_CreateAddress_Steps {
    static Logger log;
    private static String base64, sheetName, firstName, lastName;
    private static String email, company, city, address1, address2, zipPostalCode, phoneNumber, faxNumber;
    static int rowNum, rowNum_Index;
    @Given("User loads {string} create address excel data")
    public void userLoadsExcelData(String sheetName) {
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        DemoWebShop_CreateAddress_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.CreateAddressRequestTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.CreateAddressRequestTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }
    @When("User clicks on MyAccount and Addresses link")
    public void user_clicks_on_my_account_and_addresses_link() {
        DemoWebShop_HomePage.openMyAccount();
    }

    @When("User enters the Create Address details")
    public void user_enters_the_create_address_details() throws Exception {
        firstName = RandomGenerator.getRandomData("firstName");
        log.info("Random Generated first name is " + firstName);
        lastName = RandomGenerator.getRandomData("lastName");
        log.info("Random Generated last name is " + lastName);
        email = RandomGenerator.getRandomEmail(8);
        log.info("Random Generated email is " + email);
        company = RandomGenerator.getRandomData("company");
        log.info("Random Generated email is " + company);
        city = RandomGenerator.getRandomData("city");
        log.info("Random Generated city is " + city);
        address1 = RandomGenerator.getRandomData("address1");
        log.info("Random Generated address1 is " + address1);
        address2 = RandomGenerator.getRandomData("address2");
        log.info("Random Generated address2 is " + address2);
        zipPostalCode = RandomGenerator.getRandomData("zipcode");
        log.info("Random Generated Zip PostalCode is " + zipPostalCode);
        phoneNumber = RandomGenerator.getRandomData("phoneNumber");
        log.info("Random Generated Phone Number is " + phoneNumber);
        faxNumber = RandomGenerator.getRandomNumeric(8);
        log.info("Random Generated Fax Number is " + faxNumber);
        DemoWebShop_AddressesPage.createAddress(firstName, lastName, email, company, city, address1, address2, zipPostalCode, phoneNumber, faxNumber);
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_AddressPage");
        log.info("DemoWebShop created address details");
    }

    @Then("User verifies the firstname and lastname of address")
    public void user_verifies_the_firstname_and_lastname_of_address() {
        DemoWebShop_AddressesPage.verifyAddress(firstName, lastName);
    }

    @Then("User update address fields data and status in {string} create address excel sheet")
    public void user_Update_AddressFields_Status_Excel_sheet(String sheetName) throws Exception {
        if (!CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData(firstName, sheetName, rowNum, Config.col_createAddress_FirstName);
            log.info(firstName + "is updated in Excel sheet as firstName");
            ExcelUtils.setCellData(lastName, sheetName, rowNum, Config.col_createAddress_LastName);
            log.info(lastName + "is updated in Excel sheet as lastName");
            ExcelUtils.setCellData(email, sheetName, rowNum, Config.col_createAddress_Email);
            log.info(email + "is updated in Excel sheet as Email");
            ExcelUtils.setCellData(company, sheetName, rowNum, Config.col_createAddress_Company);
            log.info(company + "is updated in Excel sheet as Company");
            ExcelUtils.setCellData(DemoWebShop_AddressesPage.randomCountryName, sheetName, rowNum, Config.col_createAddress_Country);
            log.info(DemoWebShop_AddressesPage.randomCountryName + "is updated in Excel sheet as Country");
            ExcelUtils.setCellData(DemoWebShop_AddressesPage.randomStateName, sheetName, rowNum, Config.col_createAddress_State);
            log.info(DemoWebShop_AddressesPage.randomStateName + "is updated in Excel sheet as State");
            ExcelUtils.setCellData(city, sheetName, rowNum, Config.col_createAddress_City);
            log.info(city + "is updated in Excel sheet as City");
            ExcelUtils.setCellData(address1, sheetName, rowNum, Config.col_createAddress_Address1);
            log.info(address1 + "is updated in Excel sheet as Address1");
            ExcelUtils.setCellData(address2, sheetName, rowNum, Config.col_createAddress_Address2);
            log.info(address2 + "is updated in Excel sheet as Address2");
            ExcelUtils.setCellData(zipPostalCode, sheetName, rowNum, Config.col_createAddress_ZipCode);
            log.info(zipPostalCode + "is updated in Excel sheet as Zip Code");
            ExcelUtils.setCellData(phoneNumber, sheetName, rowNum, Config.col_createAddress_PhoneNumber);
            log.info(phoneNumber + "is updated in Excel sheet as PhoneNumber");
            ExcelUtils.setCellData(faxNumber, sheetName, rowNum, Config.col_createAddress_FaxNumber);
            log.info(faxNumber + "is updated in Excel sheet as FaxNumber");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Failed and status is updated in Excel sheet");

            ExcelUtils.setCellData(BaseClass.failureReason, "Index", rowNum_Index, Config.col_reason);
            log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
        }
    }
}
