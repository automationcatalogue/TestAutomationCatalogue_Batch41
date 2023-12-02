package stepdefinitions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.DemoWebShop_CartPage;
import pages.demoWebshop.DemoWebShop_CataloguePage;
import pages.demoWebshop.DemoWebShop_CheckoutPage;
import runner.CucumberHooks;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;


public class DemoWebShop_ApplyDiscount_Steps {

        static Logger log;

        static String applyCoupon, orderNumber;

        private static String base64;
        private static String sheetName;
        static int rowNum, rowNum_Index;

        double priceBeforeApplyDiscount;
        @Given("User loads {string} excel sheet")
        public void user_loads_excel_sheet(String string) {
            log = LogManager.getLogger(CucumberHooks.scenario.getName());
            DemoWebShop_ApplyDiscount_Steps.sheetName = sheetName;
            rowNum_Index = ExcelUtils.getRowNumber(Config.ApplyDiscountRequestTestCase_ID, "Index");
            log.info(rowNum_Index + "Row Number is picked from Index Sheet");
            rowNum = ExcelUtils.getRowNumber(Config.ApplyDiscountRequestTestCase_ID, sheetName);
            log.info(rowNum + "Row Number is picked from " + sheetName);
        }
    @Then("User adds first book item into the cart")
    public void user_adds_first_book_item_into_the_cart() throws Exception {
        DemoWebShop_CataloguePage.book_FirstItem();
        log.info("DemoWebShop First Book Item is added into Cart");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_FirstBookItem");

    }

    @Then("User applied discount coupon")
    public void user_applied_discount_coupon() throws Exception {
        priceBeforeApplyDiscount = DemoWebShop_CartPage.applyCoupon(applyCoupon);
        log.info("Discount Coupon is Applied as :" + applyCoupon);
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_FirstBookItem");
    }

    @Then("User verifies cart price after applying discount coupon.")
    public void user_verifies_cart_price_after_applying_discount_coupon() throws Exception {

        DemoWebShop_CartPage.verifyPriceAfterDiscount(priceBeforeApplyDiscount);
        log.info("Verified Cart Price After Discount");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_verifyPriceAfterDiscount");


    }

    @Then("User checkout the selected item")
    public void user_checkout_the_selected_item() throws Exception {
        DemoWebShop_CartPage.checkoutSelectedItems();
        log.info("DemoWebShop Checked out Selected Items");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_checkoutSelectedItems");
    }

    @Then("User places the order")
    public void user_places_the_order() throws Exception {
        DemoWebShop_CheckoutPage.placeOrder();
        log.info("DemoWebShop Order is Placed");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_placeOrder");
        orderNumber = DemoWebShop_CheckoutPage.getOrderNumber();
        log.info("DemoWebShop Order Number is generated");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_ReOrderNumber");
    }

    @Then("User Updates the Status in {string} ExcelSheet for ApplyDiscount")
    public void user_updates_the_status_in_excel_sheet_for_apply_discount(String string) throws Exception {
        if (!CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData(orderNumber, sheetName, rowNum, Config.col_ApplyDiscount_OrderNumber);
            log.info(orderNumber + " is written back to the Excel file");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Failed and status is updated in Excel sheet");
        }
    }

}
