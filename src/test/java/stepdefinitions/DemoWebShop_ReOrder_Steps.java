package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.*;
import runner.CucumberHooks;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

public class DemoWebShop_ReOrder_Steps {
    static Logger log;
    private static String base64, sheetName, firstName, lastName, orderNumber;
    static int rowNum, rowNum_Index;

    @Given("User loads {string} excel data")
    public void userLoadsExcelData(String arg0) {
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        DemoWebShop_ReOrder_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.ReOrderRequestTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.ReOrderRequestTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }

    @When("User open on Orders Page")
    public void user_open_on_orders_page() {
        DemoWebShop_HomePage.openOrdersPage();
    }

    @When("User click on First Order Details and Reorder")
    public void user_click_on_first_order_details_and_reorder() {
        DemoWebShop_OrdersPage.clickFirstOrderDetailsBtn();
        DemoWebShop_OrderInformationPage.clickReorderBtn();
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
}
