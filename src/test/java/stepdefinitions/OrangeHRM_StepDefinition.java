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
import runner.CucumberHooks;
import testcases.orangeHRM.TC03_OrangeHRM_AddUser;
import utilities.*;

public class OrangeHRM_StepDefinition {
    static WebDriver driver;
    static Logger log = LogManager.getLogger(OrangeHRM_StepDefinition.class);
    static XSSFWorkbook wbk;
    static int rowNum, rowNum_Index, row_index, row;
    static String userName, pswd, firstName, lastName, location, marital_Status, gender, region, fte, temp_dept;
    static String empName, addUser, newPassword, confirm_pwd;
    static String sheetName;
    static String testID;
    static String userName_1;
    static String password, empid;

    static String Actual_UserName, employeeName, passWord, supervisor_name, supervisor_ActualUserName,
            firstGoalPriority, firstGoalDate, secondGoalPriority, secondGoalDate, thirdGoalPriority, thirdGoalDate,
            firstGoal_status, secondGoal_status, thirdGoal_status;
    static String amount;

    static String currency, destination, travelFrom, travelTo, expenseType, currencyPaidIn, paidBy, travelReqId, reqStatus;
    static String employee_UserName;

    static String supervisor_username;

    static String request_id;
    static String requestStatus;
    static String Id, status;

    static String Status;


    @Given("OrangeHRM application is loaded")
    public void orangeHRM_load() {
        driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");
        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");
        driver.get("https://automatetest-trials710.orangehrmlive.com/");
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
    public void user_provides_first_name_last_name_location_in_add_employee_page_and_clicks_on_next() throws Exception{
        OrangeHRM_AddEmployeePage.enterAddEmployee_FirstPage(firstName, lastName, location);
    }

    @When("User Selects Marital Status and Gender and Clicks on Next")
    public void user_selects_marital_status_and_gender_and_clicks_on_next() throws Exception{
        OrangeHRM_AddEmployeePage.enterAddEmployee_SecondPage(marital_Status, gender);
    }

    @When("User Selects Region, FTE, Temporary Department and Clicks on Save button")
    public void user_selects_region_fte_temporary_department_and_clicks_on_save_button() throws Exception{
        OrangeHRM_AddEmployeePage.enterAddEmployee_ThirdPage(fte, region, temp_dept);
    }

    @Then("User Search for New Employee")
    public void user_search_for_new_employee() throws Exception {
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_AddEmployeePage.searchEmployee(firstName, lastName);
    }

    @Then("User Verifies New Employee information")
    public void user_verifies_new_employee_information() {
        empid = OrangeHRM_AddEmployeePage.verifyEmployeeId_name(firstName, lastName);
    }

    @Given("User reads AddEmployee Data from {string} using TestID {string}")
    public void readExcelSheetData_AddEmployee(String sheetName, String testID) throws Exception {
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
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
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        pswd = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);

    }

    @Given("User adds new user details in AddUser Data from {string} using TestID {string}")
    public void user_adds_new_user_details_in_add_user_data_from_using_test_id(String sheetName, String testID) throws Exception {
        Log.startTestCase(OrangeHRM_StepDefinition.class.getName());
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
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
        OrangeHRM_HomePage.verifyNewEmpName(empName);
    }

    @And("User logout from orangeHRM application")
    public void logOut_afterNewUser() {
        OrangeHRM_HomePage.clickLogout();
    }


    @Then("User Updates the Status in ExcelSheet for Add Employee")
    public void updateExcelSheetStatus(ITestResult result) throws Exception {
        CucumberHooks.rowNum_Index = rowNum_Index;
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(empid, sheetName, rowNum, Config.col_AddEmployee_EmployeeId);
            log.info(empid + " is written back to the Excel file");
        }
    }

    @Given("User reads TravelRequest Data from {string} using TestID {string}")
    public void readExcelSheetData_TravelRequest(String sheetName, String testID) throws Exception {
        Log.startTestCase(OrangeHRM_StepDefinition.class.getName());
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"//src//main//resources//AutomationCatalogue_Batch41_TestData.xlsx");
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        pswd = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        newPassword = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_newPassword);
        currency = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_currency);
        destination = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_destination);
        travelFrom = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_travelFrom);
        travelTo = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_travelTo);
        expenseType = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_expenseType);
        currencyPaidIn = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_currencyPaidIn);
        amount = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_amount);
        paidBy = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_paidBy);
        employeeName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_employeeName);

    }
    @When("User clicks on HR Administration page")
    public void user_clicks_on_hr_administration_page() throws Exception {
        OrangeHRM_HomePage.clickHrAdministrationLink();
    }

    @Then("User clicks on Users Tab and change password for both Employee and Supervisor and logout")
    public void user_clicks_on_hr_administration_link_and_change_password_for_both_employee_and_supervisor() throws Exception {
        OrangeHRM_HRAdministrationPage.clickOnUsersLink();
        employee_UserName = OrangeHRM_UsersPage.getEmployeeDetails();
        OrangeHRM_UsersPage.changeEmployeePassword(newPassword);
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        supervisor_name = OrangeHRM_EmployeeManagementPage.getSupervisorName(employeeName);
        OrangeHRM_HomePage.clickHrAdministrationLink();
        supervisor_username = OrangeHRM_UsersPage.username_Supervisor(supervisor_name);
        OrangeHRM_UsersPage.changeSupervisorPassword(supervisor_name, newPassword);
        OrangeHRM_LogoutPage.logout();
    }
    @When("User Login into OrangeHRM Application with Employee credentials as employee_UserName and newPassword and clicks on Travel and Expense Link")
    public void user_login_into_orange_hrm_application_with_employee_credentials_employee_user_name_as_and_new_password_as() throws Exception{
        OrangeHRM_LoginPage.login_employee(employee_UserName, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);

    }
    @When("creates a travel request providing currency,destination,travelFrom,travelTo,expenseType,amount,paidBy")
    public void creates_a_travel_request_providing_currency_destination_travel_from_travel_to_expense_type_amount_paid_by() throws Exception {
        OrangeHRM_TravelExpensePage.clickAddTravelExp();
        OrangeHRM_TravelExpensePage.selectCurrency(currency);
        OrangeHRM_TravelExpensePage.addTravelinfo();
        OrangeHRM_TravelExpensePage.destination(destination);
        OrangeHRM_TravelExpensePage.travelFrom(travelFrom);
        OrangeHRM_TravelExpensePage.travelto(travelTo);
        OrangeHRM_TravelExpensePage.saveTravelexp();
        OrangeHRM_TravelExpensePage.travelRequestEstimateAddBtn();
        OrangeHRM_TravelExpensePage.selectExpenseType(expenseType);
        OrangeHRM_TravelExpensePage.currency_paidin(currency);// check th travel page and correct code as its only showing corresponding currency
        OrangeHRM_TravelExpensePage.amount(amount);
        OrangeHRM_TravelExpensePage.selectPaidby(paidBy);
        OrangeHRM_TravelExpensePage.submit_travelexp();

    }
    @Then("User check the status of the TravelRequest and logout from the application")
    public void user_check_the_status_of_the_travel_request_and_logout_from_the_application() {
        request_id = OrangeHRM_TravelExpensePage.reqestId();
        requestStatus = OrangeHRM_TravelExpensePage.request_Status();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();
    }

    @When("User login as Supervisor and provides the Supervisor approval for the TravelRequest and Logout")
    public void user_login_as_supervisor_and_provides_the_supervisor_approval_for_the_travel_request_and_logout() throws Exception {
        //login as supervisor
        OrangeHRM_LoginPage.login_supervisor(supervisor_username, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        Thread.sleep(5000);
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        OrangeHRM_TravelExpensePage.supervisor_approval();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

    }

    @Then("User login as Employee and check for TravelRequest Status and Logout")
    public void user_login_as_employee_and_check_for_travel_request_status_and_logout() {

        OrangeHRM_LoginPage.login(employee_UserName, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        Id = OrangeHRM_TravelExpensePage.updatedStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Request is id " + Id);
        Status = OrangeHRM_TravelExpensePage.getStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Status of the request is " + status);
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();
    }

    @Then("User Login as Admin and provides admin approval and logout")
    public void user_login_as_admin_and_provides_admin_approval_and_logout() throws Exception{
        // Log in as Admin and Approve the request
        OrangeHRM_LoginPage.login(userName, pswd);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        OrangeHRM_TravelExpensePage.finalApproval();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();
    }

    @Then("User Login as Employee and checks for final approval Status and logout")
    public void user_login_as_employee_and_checks_for_final_approval_status_and_logout() {


        //login as Employee to check the final status
        OrangeHRM_LoginPage.login(employee_UserName, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        Id = OrangeHRM_TravelExpensePage.updatedStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Request is id " + Id);
        Status = OrangeHRM_TravelExpensePage.getStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Status of the request is " + status);
        OrangeHRM_LogoutPage.logout();
    }

    @Then("User Updates the Status in ExcelSheet for TravelRequest")
    public void updateExcelSheetStatus_TravelRequest() throws Exception{
        CucumberHooks.rowNum_Index = rowNum_Index;
        ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
        log.info("TestCase is Passed and status is updated in Excel sheet");

    }

    //Orange HRM Goals implementation ====================================================================
    @When("Finding Username of Employee in HrAdministration")
    public void findingUsernameOfEmployeeInHrAdministration() throws Exception {
        OrangeHRM_HomePage.clickHrAdministrationLink();
        Actual_UserName = OrangeHRM_UsersPage.getUserName(employeeName);
    }

    @And("Finding Supervisor name in EmployeeManagement")
    public void findingSupervisorNameInEmployeeManagement() throws Exception {
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        supervisor_name = OrangeHRM_EmployeeManagementPage.getSupervisorName(employeeName);
    }

    @And("Finding Supervisor's username in HrAdministration")
    public void findingSupervisorSUsernameInHrAdministration() throws Exception {
        OrangeHRM_HomePage.clickHrAdministrationLink();
        supervisor_ActualUserName = OrangeHRM_UsersPage.getUserName(supervisor_name);
    }

    @When("Log in with the Employee Username")
    public void logInWithTheEmployeeUsername() throws Exception {
        OrangeHRM_LoginPage.login(Actual_UserName, passWord);
        log.info("Logged in with the Employee credentials");
        OrangeHRM_HomePage.selectPerformance();
        OrangeHRM_PerformancePage.selectMyGoals();
    }


    @And("Create all goals and logout")
    public void createAllGoals_and_logout() throws Exception {
        OrangeHRM_GoalsPage.createGoal(firstGoalPriority, firstGoalDate,"","");
        OrangeHRM_GoalsPage.createGoal(secondGoalPriority, secondGoalDate,"","");
        OrangeHRM_GoalsPage.createGoal(thirdGoalPriority, thirdGoalDate,"","createGoal");
        OrangeHRM_HomePage.clickLogout();
    }


    @When("Logging in with the supervisor username")
    public void loggingInWithTheSupervisorUsername() throws Exception{
        OrangeHRM_LoginPage.login(supervisor_ActualUserName, passWord);
        log.info("Logged in with the supervisor credentials");
        OrangeHRM_PerformancePage.selectGoalsList();
        OrangeHRM_GoalsPage.supervisor_ApproveGoals("");
        OrangeHRM_HomePage.clickLogout();
    }

    @And("Logging in with the employee username")
    public void loggingInWithTheEmployeeUsername() throws Exception {
        OrangeHRM_LoginPage.login(Actual_UserName, passWord);
        log.info("Logged in with the employee credentials");
        OrangeHRM_HomePage.selectPerformance();
        OrangeHRM_PerformancePage.selectMyGoals();

    }

    @When("All goals progress")
    public void allGoalsProgress() {
        //First goal progress
        OrangeHRM_GoalsPage.progress_firstGoal();
        //Second goal progress
        OrangeHRM_GoalsPage.progress_secondGoal();
        //Third goal progress
        OrangeHRM_GoalsPage.progress_thirdGoal();
    }

    @Then("All goals Verification")
    public void allGoalsVerification() {
        //First goal Verification
        firstGoal_status = OrangeHRM_GoalsPage.verify_firstGoal();
        //Second goal Verification
        secondGoal_status = OrangeHRM_GoalsPage.verify_secondGoal();
        //Third goal Verification
        thirdGoal_status = OrangeHRM_GoalsPage.verify_thirdGoal();
    }

    @Given("User reads Goals Data from {string} using TestID {string}")
    public void userReadsGoalsDataFromUsingTestID(String sheetName, String testID) throws Exception {
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"//src//main//resources//AutomationCatalogue_Batch41_TestData.xlsx");
        //sheetName = "OrangeHRM_Goals";
        row = ExcelUtils.getRowNumber(testID, sheetName);
        row_index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        passWord = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        employeeName = ExcelUtils.getCellData(sheetName, row, Config.col_OrangeHRMGoals_empName);
        firstGoalPriority = ExcelUtils.getCellData(sheetName, row, Config.col_OrangeHRMGoals_firstGoalPriority);
        firstGoalDate = ExcelUtils.getCellData(sheetName, row, Config.col_OrangeHRMGoals_firstGoalDate);
        secondGoalPriority = ExcelUtils.getCellData(sheetName, row, Config.col_OrangeHRMGoals_secondGoalPriority);
        secondGoalDate = ExcelUtils.getCellData(sheetName, row, Config.col_OrangeHRMGoals_secondGoalDate);
        thirdGoalPriority = ExcelUtils.getCellData(sheetName, row, Config.col_OrangeHRMGoals_thirdGoalPriority);
        thirdGoalDate = ExcelUtils.getCellData(sheetName, row, Config.col_OrangeHRMGoals_thirdGoalDate);
    }

    @Then("User Updates the Status in ExcelSheet for Goals")
    public void userUpdatesTheStatusInExcelSheetForGoals(ITestResult result ) throws Exception {
        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(firstGoal_status, sheetName,row, Config.col_OrangeHRMGoals_firstGoalStatus);
            log.info(firstGoal_status+" is written back to the Excel file");
            ExcelUtils.setCellData(secondGoal_status, sheetName,row, Config.col_OrangeHRMGoals_secondGoalStatus);
            log.info(secondGoal_status+" is written back to the Excel file");
            ExcelUtils.setCellData(thirdGoal_status, sheetName,row, Config.col_OrangeHRMGoals_thirdGoalStatus);
            log.info(thirdGoal_status+" is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index",row_index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index",row_index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",row_index,Config.col_reason);
                log.info("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index",row_index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
    }
}
