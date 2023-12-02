package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.DemoWebShop_CartPage;
import pages.demoWebshop.DemoWebShop_CataloguePage;
import pages.demoWebshop.DemoWebShop_CheckoutPage;
import runner.CucumberHooks;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

public class DemoWebShop_UpdateShoppingCart_Steps {
    static Logger log;
    private static String base64, sheetName, firstName, lastName, orderNumber, firstItemPrice, secondItemPrice ;
    static int rowNum, rowNum_Index;

    @Given("User loads {string} excel data")
    public void userLoadsExcelData(String arg0) {
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        DemoWebShop_UpdateShoppingCart_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.UpdateShoppingCartRequestTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.UpdateShoppingCartRequestTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }
    @When("User add the first item to the cart")
    public void user_add_the_first_item_to_the_cart(String jewel_Length) throws Exception {
        DemoWebShop_CataloguePage.book_FirstItem();
        DemoWebShop_CataloguePage.jewelry_FirstItem(jewel_Length);
    }

    @When("User get the item price before increase the quantity and increase the item quantity")
    public void user_get_the_item_price_before_increase_the_quantity_and_increase_the_item_quantity(String update_Qty) throws Exception {
        firstItemPrice = DemoWebShop_CartPage.itemPrice_BeforeIncreasingQty("first");
        DemoWebShop_CartPage.increaseQuantity("first", update_Qty);
        secondItemPrice = DemoWebShop_CartPage.itemPrice_BeforeIncreasingQty("second");
        DemoWebShop_CartPage.increaseQuantity("second", update_Qty);
    }

    @Then("User Verify the Items Total price change")
    public void user_verify_the_book_item_total_price_change(String update_Qty) throws Exception {
        DemoWebShop_CartPage.verify_BookTotalPriceChange(update_Qty);
        DemoWebShop_CartPage.verify_JewelTotalPriceChange(update_Qty);
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_CartPage");
        log.info("DemoWebShop Items Total price changed successfully");
    }

    @Then("User verify the grand total")
    public void user_verify_the_grand_total() throws Exception {
        DemoWebShop_CartPage.verify_grandTotal();
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_CartPage");
        log.info("DemoWebShop verify the grand total successfully");
    }

    @When("User click on checkout selected items")
    public void user_click_on_checkout_selected_items() {
        DemoWebShop_CartPage.checkoutSelectedItems();
    }

    @When("User place an Order")
    public void user_place_an_order() {
        DemoWebShop_CheckoutPage.placeOrder();
    }

    @Then("User get the Order Number")
    public void user_get_the_order_number() {
        orderNumber = DemoWebShop_CheckoutPage.getOrderNumber();
    }

}

