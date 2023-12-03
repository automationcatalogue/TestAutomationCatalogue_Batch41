package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.demoWebshop.DemoWebShop_CartPage;
import pages.demoWebshop.DemoWebShop_CheckoutPage;
import pages.demoWebshop.DemoWebShop_HomePage;
import pages.demoWebshop.DemoWebShop_LoginPage;
import runner.CucumberHooks;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;

public class DemoWebShop_Steps {
    static WebDriver driver;
    public static String base64, orderNumber;
    static Logger log;

    @Given("User opens DemoWebShop application")
    public void user_opens_demo_web_shop_application() throws Exception {
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        driver = BaseClass.getDriver();
        driver.get(Config.demoWebshop_URL);
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_LoginPage");
        log.info("DemoWebShop URL is loaded :" + Config.demoWebshop_URL);
    }
    @When("User login into DemoWebShop application with username as {string} and {string}")
    public void user_login_into_demo_web_shop_application_with_username_as_and(String userName, String password) throws Exception {
        DemoWebShop_LoginPage.login(userName, password);
        log.info("DemoWebShop Login is Successful");
    }

    @Then("User verify title of DemoWebShop home page")
    public void user_verify_title_of_demo_web_shop_home_page() throws Exception {
        DemoWebShop_HomePage.verifyTitle();
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_HomePage");
    }
    @When("User click on checkout selected items")
    public void user_click_on_checkout_selected_items() {
        DemoWebShop_CartPage.checkoutSelectedItems();
    }
    @When("User place an Order")
    public void user_place_an_order() throws Exception {
        DemoWebShop_CheckoutPage.placeOrder();
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_ChekoutPage");
        log.info("DemoWebShop places the order successfully");
    }
    @Then("User get the Order Number")
    public void user_get_the_order_number() {
        orderNumber = DemoWebShop_CheckoutPage.getOrderNumber();
    }

    @Then("User logged out from DemoWebShop application")
    public void user_logged_out_from_demo_web_shop_application() {
        DemoWebShop_HomePage.logOut();
    }
}


