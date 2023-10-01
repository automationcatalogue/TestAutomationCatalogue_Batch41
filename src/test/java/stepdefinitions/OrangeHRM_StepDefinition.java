package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import pages.*;
import testcases.orangeHRM.TC03_OrangeHRM_AddUser;
import utilities.*;

public class OrangeHRM_StepDefinition {
    static WebDriver driver;
    static Logger log = LogManager.getLogger(OrangeHRM_StepDefinition.class);
    static XSSFWorkbook wbk;
    static int rowNum, rowNum_Index;
    static String userName, pswd, firstName, lastName, location, marital_Status, gender, region, fte, temp_dept;
    static String empName, addUser, newPassword, confirm_pwd;
    static String sheetName;
    static String testID;
    static String userName_1;
    static String password, empid;
    static int row;


    @Given("OrangeHRM application is loaded")
    public void orangeHRM_load() {
        driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");
        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");
        driver.get("https://automationo-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM website is loaded");
    }

    @When("User entered username as {string}")
    public void enterUserName(String userName) {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
        System.out.println(userName + " is entered as UserName");
    }

    @And("User entered password as {string}")
    public void enterPassword(String password) {
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        System.out.println(password + " is entered as Password");
    }

    @And("User Clicks on Login button")
    public void clickLogin() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");
    }

    @Then("User verified Login is successful")
    public void verifyLogin() {
        boolean isPresent = driver.findElement(By.xpath("//i[text()='oxd_home_menu']")).isDisplayed();
        Assert.assertTrue(isPresent, "Home Menu icon is not displayed");
        System.out.println("Home Menu icon is displayed and Login is successful");
    }

    @And("User Verified title of the Homepage")
    public void verifyTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Employee Management";
        Assert.assertEquals(actualTitle, expectedTitle, "Title of the webpage is not matched");
        System.out.println("Title of the webpage is matched and verified");
    }

    @Given("User loads OrangeHRM Application in {string} browser")
    public void loadOrangeHRMApplication(String browserName) {
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass baseClass = new BaseClass(driver);
        driver.get("https://automatetest-trials710.orangehrmlive.com/");
        log.info("OrangeHRM website is launched");
    }

    @When("User Login into OrangeHRM Application with UserName as {string} and Password as {string}")
    public void loginOrangeHRM(String userName, String password) {
        OrangeHRM_LoginPage.login(userName, password);
    }

    @Then("User Verifies Successful Login")
    public void user_verifies_successful_login() {
        OrangeHRM_HomePage.verifyTitle();
    }

    @When("User Opens Add Employee Page")
    public void user_opens_add_employee_page() throws Exception {
        OrangeHRM_EmployeeManagementPage.openAddEmployee();
    }

    @When("User Provides FirstName, LastName, Location in Add EmployeePage and Clicks on Next")
    public void user_provides_first_name_last_name_location_in_add_employee_page_and_clicks_on_next() {
        OrangeHRM_AddEmployeePage.enterFirstName_LastName_Location(firstName, lastName, location);
    }

    @When("User Selects Marital Status and Gender and Clicks on Next")
    public void user_selects_marital_status_and_gender_and_clicks_on_next() {
        OrangeHRM_AddEmployeePage.clickMaritalStatus_Gender(marital_Status, gender);
    }

    @When("User Selects Region, FTE, Temporary Department and Clicks on Save button")
    public void user_selects_region_fte_temporary_department_and_clicks_on_save_button() {
        OrangeHRM_AddEmployeePage.selectFTE_Region_TempDepartment(fte, region, temp_dept);
    }

    @Then("User Search for New Employee")
    public void user_search_for_new_employee() throws Exception{
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_AddEmployeePage.searchEmployee(firstName, lastName);
    }

    @Then("User Verifies New Employee information")
    public void user_verifies_new_employee_information() {
        empid = OrangeHRM_AddEmployeePage.verifyEmployeeId_name(firstName, lastName);
    }

    @Given("User reads AddEmployee Data from {string} using TestID {string}")
    public void readExcelSheetData_AddEmployee(String sheetName, String testID) throws Exception {

        wbk = ExcelUtils.setExcelFilePath();
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        pswd = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        firstName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_FirstName);
        lastName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_LastName);
        location = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Location);
        marital_Status = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_MaritalStatus);
        gender = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Gender);
        region = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Region);
        fte = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_FTE);
        temp_dept = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_TempDepartment);
    }

    @Given("User Reads the Data from ExcelSheet {string} using TestID {string}")
    public void readExcelSheetData_AddUser(String sheetName, String testID) throws Exception {
        Log.startTestCase(OrangeHRM_StepDefinition.class.getName());
        wbk = ExcelUtils.setExcelFilePath();
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        pswd = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);

    }

    @Given("User adds new user details in AddUser Data from {string} using TestID {string}")
    public void user_adds_new_user_details_in_add_user_data_from_using_test_id(String sheetName, String testID) throws Exception {
        Log.startTestCase(OrangeHRM_StepDefinition.class.getName());
        wbk = ExcelUtils.setExcelFilePath();
        row = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName_1 = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        empName = ExcelUtils.getCellData(sheetName, row, Config.col_AddUser_EmployeeName);
        addUser = RandomGenerator.getRandomData("username");
        newPassword = ExcelUtils.getCellData(sheetName, row, Config.col_AddUser_ConfirmPassword);
        confirm_pwd = ExcelUtils.getCellData(sheetName, row, Config.col_AddUser_ConfirmPassword);

    }

    @When("User opens HR Administration page")
    public void user_opens_hr_administration_page() throws Exception {
        OrangeHRM_HomePage.clickHrAdministrationLink();
        OrangHRM_AddUserPage.clickAddUser();
    }

    @When("User enters employee,  username, Password, confirm password and clicks on save button")
    public void user_enters_employee_username_password_confirm_password_and_clicks_on_save_button() throws Exception {
        OrangHRM_AddUserPage.enterAddUserDetails(empName, addUser, newPassword, confirm_pwd);
        OrangHRM_AddUserPage.clickSave();

    }

    @When("User clicks on logout button")
    public void user_clicks_on_logout_button() {
        OrangeHRM_HomePage.clickLogout();
    }

    @When("User enters username as new username")
    public void user_enters_username_as_new_username() {
        OrangeHRM_LoginPage.login(addUser, confirm_pwd);


    }

    @Then("User verifies new user login")
    public void user_verifies_new_user_login() {
        //Verify the Employee Name as Charlie Carter
        OrangeHRM_HomePage.verify_empName(empName);
    }
    @And("User logout from orangeHRM application")
    public void logOut_afterNewUser(){
        OrangeHRM_HomePage.clickLogout();
    }


    @Then("User Updates the Status in ExcelSheet for Add Employee")
    public void updateExcelSheetStatus(ITestResult result) throws Exception{
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(empid, sheetName, rowNum, Config.col_AddEmployee_EmployeeId);
            log.info(empid + " is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", rowNum_Index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
    }


}
