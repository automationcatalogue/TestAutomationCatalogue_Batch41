package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.orangeHRM.OrangeHRM_EditEmployeePage;
import pages.orangeHRM.OrangeHRM_EmployeeManagementPage;
import utilities.Config;
import utilities.ExcelUtils;
import utilities.RandomGenerator;

import static runner.CucumberHooks.*;

public class OrangeHRM_EditEmp_Steps {

    private static String sheetName;
    static int rowNum, rowNum_Index;
    private static String empName, dateOfBirth, nationality, allergies, dietaryRequire1, dietaryRequire2, mobileNumber;

    @Given("User loads {string} edit employee excel data")
    public void user_loads_edit_employee_excel_data(String sheetName) {
        OrangeHRM_EditEmp_Steps.sheetName = sheetName;
        rowNum_Index = ExcelUtils.getRowNumber(Config.EditEmployeeTestCase_ID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        rowNum = ExcelUtils.getRowNumber(Config.EditEmployeeTestCase_ID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
    }

    @When("User clicks on employee personal details tab")
    public void user_clicks_on_employee_personal_details_tab() {
        empName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_EmpName);
        OrangeHRM_EmployeeManagementPage.clickEmployeePersonalDetails(empName);
        log.info(empName + " Employee Name is Opened for Edit");
    }

    @When("User edits employee dob and nationality")
    public void user_edits_employee_dob_and_nationality() throws Exception {
        dateOfBirth = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_DOB);
        nationality = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_Nationality);
        OrangeHRM_EditEmployeePage.edit_DOB_Nationality(dateOfBirth, nationality);
        log.info("OrangeHRM Edit Employee Personal Details are Saved");
    }

    @When("User edits employee health information")
    public void user_edits_employee_health_information() throws Exception {
        allergies = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_Allergies);
        dietaryRequire1 = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_DietaryRequirement_1);
        dietaryRequire2 = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_DietaryRequirement_2);
        OrangeHRM_EditEmployeePage.editHealth(allergies, dietaryRequire1, dietaryRequire2);
        log.info("OrangeHRM Edit Health Details are Saved");
    }

    @When("User edits employee mobile number")
    public void user_edits_employee_mobile_number() throws Exception{
        mobileNumber = RandomGenerator.getRandomData("phoneNumber").replace(".", "").trim();
        OrangeHRM_EditEmployeePage.editMobileNumber(mobileNumber);
        log.info("OrangeHRM Edit Contact Details are Saved");
    }

    @Then("User validates edit employee data")
    public void user_validates_edit_employee_data() {
        OrangeHRM_EditEmployeePage.validateEditEmployeeData(mobileNumber);
        log.info("OrangeHRM Edit Employee is successful");
    }

    @Then("User Update status in {string} edit employee excel sheet")
    public void user_update_status_in_edit_employee_excel_sheet(String sheetName) throws Exception {
        if (!scenario.isFailed()) {
            ExcelUtils.setCellData(mobileNumber, sheetName, rowNum, Config.col_EditEmployee_MobileNumber);
            log.info(mobileNumber + "is updated in Excel sheet as Mobile Number");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (scenario.isFailed()) {
            ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Failed and status is updated in Excel sheet");
        }
    }
}
