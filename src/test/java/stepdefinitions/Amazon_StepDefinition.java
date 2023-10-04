package stepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Amazon_StepDefinition {

    @Given("Amazon website is loaded")
    public void amazon_website_is_loaded() {
        System.out.println("Amazon wesbite is loaded");
    }
    @When("User Selects the Category and Search for an Item and reads result data")
    public void user_selects_the_category_and_search_for_an_item_and_reads_result_data(DataTable table) {
        List<Map<String, String>> data = table.asMaps();
        for(Map<String, String> row:data){
            String category = row.get("Category");
            String searchItem = row.get("SearchItem");
            System.out.println("Category-"+category+"-SearchItem-"+searchItem);
        }
    }
    @Then("User performs Search Results in Amazon website")
    public void user_performs_search_results_in_amazon_website() {
        System.out.println("User Performed Search result in Amazon website");
    }

}
