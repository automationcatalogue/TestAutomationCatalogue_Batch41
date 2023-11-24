package stepdefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.orangeHRM.OrangeHRM_AddUserPage;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import runner.CucumberHooks;
import utilities.Config;
import utilities.ExcelUtils;
import utilities.RandomGenerator;

public class OrangeHRM_AddUser_Steps {
    static Logger log;
    private static String sheetName;
    static int rowNum, rowNum_Index;
    private String empName, newUserName, newPassword, confirm_Password;

    @Given("User loads {string} add user excel data")
    public void user_loads_OrangeHRM_Add_Employee_excel_data(String sheetName){
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        OrangeHRM_AddUser_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.AddUserTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.AddUserTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }

    @When("User clicks on OrangeHRM HR Administration link")
    public void user_clicks_on_orange_hrm_hr_administration_link() throws Exception{
        OrangeHRM_HomePage.clickHrAdministrationLink();
        log.info("HR administration Page is Loaded");
    }
    @When("User clicks on Add User button")
    public void user_clicks_on_add_user_button() {
        OrangeHRM_AddUserPage.clickAddUser();
        log.info("Add User Page is Loaded");
    }
    @When("User enters EmployeeName, UserName, Password and Confirm Password")
    public void user_enters_employee_name_user_name_password_and_confirm_password() throws Exception{
        empName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_EmployeeName);
        newUserName = RandomGenerator.getRandomData("username");
        log.info("Random New UserName is :" + newUserName);
        newPassword = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_Password);
        confirm_Password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_ConfirmPassword);
        OrangeHRM_AddUserPage.enterAddUserDetails(empName, newUserName, newPassword, confirm_Password);
        log.info("Add User details is entered");
    }
    @Given("User login into OrangeHRM application with new username")
    public void user_login_into_orange_hrm_application_with_new_username() throws Exception{
        OrangeHRM_LoginPage.login(newUserName, newPassword);
        log.info("OrangeHRM Login is Successful with New UserName :"+newUserName);
    }
    @Then("User verifies new userName")
    public void user_verifies_new_user_name() {
        OrangeHRM_HomePage.verifyNewEmpName(empName);
        log.info("OrangeHRM empName is Verified");
    }

    @Then("User Update the new username in {string} add user excel sheet")
    public void user_Update_the_EmployeeId_in_Excel_sheet(String sheetName) throws Exception{
        if (!CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData(newUserName, sheetName, rowNum, Config.col_AddUser_NewUser);
            log.info(newUserName + "is updated in Excel sheet as New UserName");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Failed and status is updated in Excel sheet");
        }
    }
}
