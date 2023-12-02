package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.demoWebshop.DemoWebShop_HomePage;
import pages.demoWebshop.DemoWebShop_OrdersPage;
import runner.CucumberHooks;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

public class DemoWebShop_TotalOrders_Steps {
    static Logger log;

    static float sumOfAllOrders;
    private static String base64;
    private static String sheetName;
    static int rowNum, rowNum_Index,totalNumberOfOrders;
    @Given("User loads {string} total orders excel sheet")
    public void user_loads_excel_sheet(String sheetName) {
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        DemoWebShop_TotalOrders_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.TotalOrdersRequestTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.TotalOrdersRequestTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }
    @When("User opens OrdersPage by clicking on Email link and then on Orders")
    public void user_clicks_on_email_address_and_click_on_orders_link() throws Exception {
        DemoWebShop_HomePage.openOrdersPage();
        log.info("DemoWebShop Orders Page is Opened");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "DemoWebShop_OrdersPage");
    }
    @Then("User performs Total Orders count")
    public void user_performs_total_orders_count() {
        totalNumberOfOrders = DemoWebShop_OrdersPage.totalNumberOfOrders();
        log.info("Total Number of Orders present in Orders Page is :" + totalNumberOfOrders);
    }
    @Then("User Performs Sum of All Orders Placed")
    public void user_performs_sum_of_all_orders_placed() {
        sumOfAllOrders = DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
        log.info("Total value of all Orders present in Orders Page is :" + sumOfAllOrders);
    }
    @Then("User displays Sum of orders DateWise")
    public void user_displays_sum_of_orders_date_wise() {
        DemoWebShop_OrdersPage.sumOfOrdersDayWise();
        log.info("Day wise Total Order value is displayed");
    }
    @Then("User Updates the Status in {string} ExcelSheet for Total Orders")
    public void user_updates_the_status_in_excel_sheet_for_total_orders(String string) throws Exception {
        if (!CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData(String.valueOf(totalNumberOfOrders), sheetName, rowNum, Config.col_TotalOrders_NumberOfOrders);
            log.info(totalNumberOfOrders + " is updated as Total Number of Orders");
            ExcelUtils.setCellData(String.valueOf(sumOfAllOrders), sheetName, rowNum, Config.col_TotalOrders_SumOfAllOrders);
            log.info(sumOfAllOrders + " is updated as Sum Of All Orders");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Failed and status is updated in Excel sheet");
        }
    }


}
