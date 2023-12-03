package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.*;
import runner.CucumberHooks;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

public class DemoWebShop_ReOrder_Steps {
    static Logger log;
    private static String base64, sheetName, orderNumber;
    static int rowNum, rowNum_Index;

    @Given("User loads {string} reorder excel sheet")
    public void userLoadsExcelData(String sheetName) {
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







    @Then("User update order number and status in {string} reorder excel sheet")
    public void user_Update_OrderNumber_Status_in_Excel_sheet(String sheetName) throws Exception {
        if (!CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData(orderNumber, sheetName, rowNum, Config.col_Reorder_OrderNumber);
            log.info(orderNumber + " is written back to the Excel file");
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
