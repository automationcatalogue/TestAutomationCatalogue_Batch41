package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.orangeHRM.*;
import utilities.Config;
import utilities.ExcelUtils;
import static runner.CucumberHooks.*;

public class OrangeHRM_Goals_Steps {

    static int rowNum, rowNum_Index;
    static String employeeName, sheetName;
    static String firstGoalPriority, firstGoalDate, secondGoalPriority, secondGoalDate, thirdGoalPriority, thirdGoalDate;
    static String actualUserName, supervisorName, supervisorActualUserName, updateFirstGoalPercentage, updateSecondGoalPercentage;
    static String firstGoalStatus, secondGoalStatus, thirdGoalStatus, approveGoalNote;
    static String firstGoalName, firstGoalDescription, secondGoalName, secondGoalDescription, thirdGoalName, thirdGoalDescription;

    @Given("User loads {string} goals excel sheet")
    public void user_loads_OrangeHRM_Goals_excel_data(String sheetName) {
        OrangeHRM_Goals_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.GoalsRequestTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.GoalsRequestTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }

    @When("User finds username on Users Page")
    public void user_finds_users_name_on_users_page() {
        employeeName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_OrangeHRMGoals_empName);
        actualUserName = OrangeHRM_UsersPage.getUserName(employeeName);
        log.info("Actual UserName received for the Employee" + employeeName + " is " + actualUserName);
    }

    @Given("User login into OrangeHRM application with employee username")
    public void user_login_into_orange_hrm_application_with_employee_username() {
        actualUserName = OrangeHRM_UsersPage.getUserName(employeeName);
        log.info("Actual UserName received for the Employee" + employeeName + " is " + actualUserName);
    }

    @Given("User login into OrangeHRM application with  the supervisor username")
    public void user_login_into_orange_hrm_application_with_the_supervisor_username() {
        supervisorActualUserName = OrangeHRM_UsersPage.getUserName(supervisorName);
        log.info("Supervisor Actual UserName received for the Employee" + employeeName + " is " + supervisorActualUserName);
    }

    @When("User finds Supervisor name")
    public void user_finds_supervisor_name() {
        supervisorName = OrangeHRM_EmployeeManagementPage.getSupervisorName(employeeName);
        log.info("SupervisorName received for the Employee" + employeeName + " is " + supervisorName);
    }

    @When("User finds Supervisor userName")
    public void user_finds_supervisor_user_name() {
        supervisorActualUserName = OrangeHRM_UsersPage.getUserName(supervisorName);
        log.info("Supervisor Actual UserName received for the Employee" + employeeName + " is " + supervisorActualUserName);
    }

    @Then("User clicks on selectPerformance link")
    public void user_clicks_on_select_performance_link() throws Exception {
        OrangeHRM_HomePage.selectPerformance();
        log.info("OrangeHRM Performance link is clicked");
    }

    @Then("User clicks on selectMyGoals link")
    public void user_clicks_on_select_my_goals_link() throws Exception {
        OrangeHRM_PerformancePage.selectMyGoals();
        log.info("MyGoals Link is opened");
    }

    @Then("User creates three goals")
    public void user_creates_three_goals() throws Exception {
        OrangeHRM_GoalsPage.createGoal(firstGoalPriority, firstGoalDate, firstGoalName, firstGoalDescription);
        log.info("First Goal Creation is completed");
        OrangeHRM_GoalsPage.createGoal(secondGoalPriority, secondGoalDate, secondGoalName, secondGoalDescription);
        log.info("Second Goal Creation is completed");
        OrangeHRM_GoalsPage.createGoal(thirdGoalPriority, thirdGoalDate, thirdGoalName, thirdGoalDescription);
        log.info("Third Goal Creation is completed");
    }

    @Then("User clicks on selectGoalsList link")
    public void user_clicks_on_select_goals_list_link() throws Exception {

        OrangeHRM_PerformancePage.selectGoalsList();
        log.info("GoalList Link is opened");
    }

    @Then("User clicks on supervisor_ApproveGoals")
    public void user_clicks_on_supervisor_approve_goals() throws Exception {
        OrangeHRM_GoalsPage.supervisor_ApproveGoals(approveGoalNote);
        log.info("Supervisor Approved All Goals");
    }

    @Then("User is Updating Goals Progress")
    public void user_is_updating_goals_progress() throws Exception {
        OrangeHRM_GoalsPage.updateGoalPercentage(updateFirstGoalPercentage, "First");
        log.info("Completed in Updating the First Goal " + updateFirstGoalPercentage + "%");
        OrangeHRM_GoalsPage.updateGoalPercentage(updateSecondGoalPercentage, "Second");
        log.info("Completed in Updating the Second Goal " + updateSecondGoalPercentage + "%");
        OrangeHRM_GoalsPage.updateGoalStatus(thirdGoalStatus, "Third");
        log.info("Completed in Updating the Third Goal Status to " + thirdGoalStatus);
    }

    @Then("User does Goals Verification")
    public void user_does_goals_verification() throws Exception {
        OrangeHRM_GoalsPage.verifyInProgressGoalStatus("first", firstGoalStatus);
        log.info("Verified First Goal Status " + firstGoalStatus);
        OrangeHRM_GoalsPage.verifyAchievedGoalStatus("second", secondGoalStatus);
        log.info("Verified Second Goal Status " + secondGoalStatus);
        OrangeHRM_GoalsPage.verifyOnHoldGoalStatus("third", thirdGoalStatus);
        log.info("Verified Third Goal Status " + thirdGoalStatus);
    }
}




