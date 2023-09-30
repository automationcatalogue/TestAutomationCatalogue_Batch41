package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaPrograms.assignments.Assignment_16.D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import pages.*;
import seleniumPrograms.sagarTeachings.DemoWebshop_ReOrder;
import testcases.demoWebshop.TC11_DemoWebshop_ReOrder;
import testcases.orangeHRM.TC01_OrangeHRM_LoginTest;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;


public class DemoWebshop_Stepdefintion {
    public static WebDriver driver;
    static Logger log = LogManager.getLogger(DemoWebshop_ReOrder.class);

    @Given("User loads DemoWebshop Application")
    public void user_loads_demo_webshop_application() {
        driver = CommonUtils.browserLaunch(Config.browserName);
        BaseClass ob = new BaseClass(driver);
        driver.get(Config.url_DemoWebshop);
        System.out.println("DemoWebShop Website is launched");
    }
    @Given("User loads DemoWebshop Application in {string} browser")
    public void loadDemoWebshopApplication(String browserName) {
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass baseClass = new BaseClass(driver);
        driver.get("https://demowebshop.tricentis.com/");
        log.info("Demo website is loaded");
    }
    @When("User Login into DemoWebshop Application with UserName as {string} and Password as {string}")
    public void loginDemoWebshop(String userName, String password) {
        DemoWebshop_LoginPage.login(userName, password);
    }
    @Then("User clicks Email link")
    public void user_clicks_email_link(){
        DemoWebshop_HomePage.clickEmailLink();
    }
    @And("User Clicks on Orders link")
    public void user_clicks_on_orders_link(){
        DemoWebShop_OrdersPage.clickLinkOrders();
    }
    @And("User Clicks on OrderDetails button")
    public void user_clicks_on_OrderDetails_button(){
        DemoWebShop_OrdersPage.clickOrderDetailsBtn();
    }
    @Then("User Clicks on ReOrder button")
    public void user_clicks_on_orderdetails_button(){
        DemoWebshop_OrderInformationPage.clickReorderBtn();
    }
    @And("User Clicks on Iagree button")
    public void user_clicks_on_iagree_button(){
        DemoWebshop_CartPage.clickCheckboxIagree();
    }
    @And("User Clicks on Checkout button")
    public void clickscheckoutbutton(){
        DemoWebshop_CartPage.clickCheckoutBtn();
    }
    @When("User Clicks on BillingContinue button")
    public void clicksbillingcontinuebutton(){
        DemoWebshop_CheckoutPage.clickBillingContinue();
    }
    @Then("User Clicks on ShippingAddress button")
    public void clickshippingaddressbutton(){
        DemoWebshop_CheckoutPage.clickShippingAddressBtn();
    }
    @And("User Clicks on ShippingMethod button")
    public void clickshippingmethodbutton(){
        DemoWebshop_CheckoutPage.clickShippingMethodBtn();
    }
    @And("User Clicks on PaymentMethod button")
    public void click_paymentmethod_button(){
        DemoWebshop_CheckoutPage.clickPaymentMethodBtn();
    }
    @And("User Clicks on PaymentInformation button")
    public void click_paymentinformation_button(){
        DemoWebshop_CheckoutPage.clickPaymentInformationBtn();
    }
    @When("User Clicks on ConfirmOrder button")
    public void click_confirmorder_button(){
        DemoWebshop_CheckoutPage.clickConfirmOrderBtn();
    }
    @Then("User Get OrderNumber")
    public void getordernumber(){
        DemoWebshop_CheckoutPage.getOrderNumber();
    }
    @Then("User Verifies Successful login of DemoWebshop application")
    public void user_verifies_successful_login_of_demo_webshop_application() {

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
}
