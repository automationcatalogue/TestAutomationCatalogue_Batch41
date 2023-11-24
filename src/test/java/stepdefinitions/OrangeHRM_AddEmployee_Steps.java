package stepdefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import pages.orangeHRM.OrangeHRM_AddEmployeePage;
import pages.orangeHRM.OrangeHRM_HomePage;
import runner.CucumberHooks;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

public class OrangeHRM_AddEmployee_Steps {
    static Logger log;
    private static String base64;
    private static String sheetName;
    static int rowNum, rowNum_Index;
    private static String firstName, lastName;
    public static String empid;

    @Given("User loads {string} add employee excel sheet")
    public void user_loads_OrangeHRM_Add_Employee_excel_data(String sheetName){
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        OrangeHRM_AddEmployee_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.AddEmployeeTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.AddEmployeeTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }
    @When("User clicks on OrangeHRM EmployeeManagement link")
    public void user_clicks_on_orange_hrm_employee_management_link() throws Exception{
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        log.info("Employee Management Page is Loaded");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_EmployeeManagementPage");
    }
    @When("User enters firstName, lastName and location from excel file")
    public void user_enters_first_name_last_name_and_location_from_excel_file() throws Exception{
        firstName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_FirstName);
        lastName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_LastName);
        String location = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Location);

        OrangeHRM_AddEmployeePage.enterAddEmployee_FirstPage(firstName, lastName, location);
        log.info("Add Employee FirstPage Data is entered");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_AddEmployee_FirstPage");
    }
    @When("User enters maritalStatus and gender from from excel file")
    public void user_enters_marital_status_and_gender_from_from_excel_file() throws Exception{
        String maritalStatus = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_MaritalStatus);
        String gender = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Gender);
        OrangeHRM_AddEmployeePage.enterAddEmployee_SecondPage(maritalStatus, gender);
        log.info("Add Employee SecondPage Data is entered");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_AddEmployee_SecondPage");
    }
    @When("User enters region, fte and temp dept from excel file")
    public void user_enters_region_fte_and_temp_dept_from_excel_file() throws Exception{
        String region = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Region);
        String fte = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_FTE);
        String tempDept = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_TempDepartment);

        OrangeHRM_AddEmployeePage.enterAddEmployee_ThirdPage(region, fte, tempDept);
        log.info("Add Employee ThirdPage Data is entered");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_AddEmployee_ThirdPage");
    }
    @Then("User searches for new employee with firstname and lastname")
    public void user_searches_for_new_employee_with_firstname_and_lastname() throws Exception{
        OrangeHRM_AddEmployeePage.searchEmployee(firstName, lastName);
        log.info("Searched for New Employee Data");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_AddEmployee_SearchNewEmployee");
    }
    @Then("User verify new employee Id and Name")
    public void user_verify_new_employee_id_and_name() throws Exception{
        empid = OrangeHRM_AddEmployeePage.verifyEmployeeId_name(firstName, lastName);
        log.info("Verified New Employee Data");
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_AddEmployee_VerifyNewEmployee");
    }

    @Then("User Update the EmployeeId in {string} add employee excel sheet")
    public void user_Update_the_EmployeeId_in_Excel_sheet(String sheetName) throws Exception{
        if (!CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData(empid, sheetName, rowNum, Config.col_AddEmployee_EmployeeId);
            log.info(empid + " is written back to the Excel file");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (CucumberHooks.scenario.isFailed()) {
            ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Failed and status is updated in Excel sheet");
        }
    }

}
