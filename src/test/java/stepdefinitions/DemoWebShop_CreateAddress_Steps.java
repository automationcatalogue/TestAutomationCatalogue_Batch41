package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.DemoWebShop_AddressesPage;
import pages.demoWebshop.DemoWebShop_HomePage;
import runner.CucumberHooks;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

public class DemoWebShop_CreateAddress_Steps {
    static Logger log;
    private static String base64, sheetName, firstName, lastName;
    static int rowNum, rowNum_Index;
    @Given("User loads {string} excel data")
    public void userLoadsExcelData(String arg0) {
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
    public void user_enters_the_create_address_details(String email, String company, String city, String address1, String address2, String zipPostalCode, String phoneNumber, String faxNumber) throws Exception {
        DemoWebShop_AddressesPage.createAddress(firstName, lastName, email, company, city, address1, address2, zipPostalCode, phoneNumber, faxNumber);
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_AddressPage");
        log.info("DemoWebShop created address details");

    }

    @Then("User verifies the firstname and lastname of address")
    public void user_verifies_the_firstname_and_lastname_of_address() {
        DemoWebShop_AddressesPage.verifyAddress(firstName, lastName);
    }


}
