package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import testcases.demoWebshop.TC12_DemoWebshop_TotalOrders;
import testcases.orangeHRM.TC01_OrangeHRM_LoginTest;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;

public class DemoWebshop_Stepdefintion {
    public static WebDriver driver;
    static Logger log = LogManager.getLogger(TC12_DemoWebshop_TotalOrders.class);
    @Given("User loads DemoWebshop Application")
    public void user_loads_demo_webshop_application() {
        driver = CommonUtils.browserLaunch(Config.browserName);
        BaseClass ob = new BaseClass(driver);
        driver.get(Config.url_DemoWebshop);
        log.info("DemoWebShop Website is launched");
    }
    @When("User login into DemoWebshop Application with UserName {string} and Password {string}")
    public void user_login_into_demo_webshop_application_with_user_name_and_password(String userName, String password) {
        DemoWebshop_LoginPage.login(userName, password);
    }
    @Then("User Verifies Successful login of DemoWebshop application")
    public void user_verifies_successful_login_of_demo_webshop_application() {
       DemoWebshop_HomePage.verifyTitle();
    }
    @When("User Opens Address page")
    public void user_opens_address_page() {

    }
    @When("User Clicks on AddNew button")
    public void user_clicks_on_add_new_button() {

    }
    @When("User Enters address fields data for FirstName as {string} LastName as {string} and Email as {string}")
    public void user_enters_address_fields_data_for_first_name_as_last_name_as_and_email_as(String string, String string2, String string3) {

    }
    @When("User Selects Country as {string} State as {string} Address1 as {string} Address2 as {string} station and Postal Code as {string}")
    public void user_selects_country_as_state_as_address1_as_address2_as_station_and_postal_code_as(String string, String string2, String string3, String string4, String string5) {

    }
    @When("User Enters PhoneNumber as {string} and FaxNumber as {string}")
    public void user_enters_phone_number_as_and_fax_number_as(String string, String string2) {

    }

    @Then("User Verifies Address is added")
    public void user_verifies_address_is_added() {

    }

    @When("User clicks on Email Address and click on orders link")
    public void user_clicks_on_email_address_and_click_on_orders_link() {
        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        log.info("Clicked on Email address link");
        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        log.info("Clicked on orders link on MyAccount Page");
    }

    @When("User performs Total Orders count")
    public void user_performs_total_orders_count() {
        DemoWebShop_OrdersPage.totalNumberOfOrders();
    }
    @Then("User Performs Sum of All Orders Placed")
    public void user_performs_sum_of_all_orders_Placed() {
        DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
    }
    @Then("User displays Sum of orders DateWise")
    public void user_displays_sum_of_orders_date_wise() {
        DemoWebShop_OrdersPage.sumOfOrdersDayWise();
    }
}
