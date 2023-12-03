package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.DemoWebShop_CartPage;
import pages.demoWebshop.DemoWebShop_CataloguePage;
import runner.CucumberHooks;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

public class DemoWebShop_UpdateShoppingCart_Steps {
    static Logger log;
    private static String base64, sheetName;
    private static String jewelLength, update_Qty;
    static int rowNum, rowNum_Index;

    @Given("User loads {string} update shopping cart excel sheet")
    public void userLoadsExcelData(String sheetName) {
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        DemoWebShop_UpdateShoppingCart_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.UpdateShoppingCartRequestTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.UpdateShoppingCartRequestTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }

    @When("User add the first item to the cart")
    public void user_add_the_first_item_to_the_cart() throws Exception {
        jewelLength = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UpdateCart_Length);
        DemoWebShop_CataloguePage.book_FirstItem();
        DemoWebShop_CataloguePage.jewelry_FirstItem(jewelLength);
    }

    @When("User get the item price before increase the quantity and increase the item quantity")
    public void user_get_the_item_price_before_increase_the_quantity_and_increase_the_item_quantity() throws Exception {
        update_Qty = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UpdateCart_Quantity);
        DemoWebShop_CartPage.itemPrice_BeforeIncreasingQty("first");
        DemoWebShop_CartPage.increaseQuantity("first", update_Qty);
        DemoWebShop_CartPage.itemPrice_BeforeIncreasingQty("second");
        DemoWebShop_CartPage.increaseQuantity("second", update_Qty);
    }

    @Then("User Verify the Items Total price change")
    public void user_verify_the_book_item_total_price_change() throws Exception {
        update_Qty = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UpdateCart_Quantity);
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

    @Then("User update order number and status in {string} update shopping cart excel sheet")
    public void user_Update_OrderNumber_Status_in_Excel_sheet(String sheetName) throws Exception {
        if (!CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData(DemoWebShop_Steps.orderNumber, sheetName, rowNum, Config.col_UpdateCart_OrderNumber);
            log.info(DemoWebShop_Steps.orderNumber + " is written back to the Excel file");
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

