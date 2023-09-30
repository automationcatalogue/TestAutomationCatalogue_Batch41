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
import pages.OrangeHRM_AddEmployeePage;
import pages.OrangeHRM_EmployeeManagementPage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import utilities.*;

public class OrangeHRM_StepDefinition {
    static WebDriver driver;
    static Logger log = LogManager.getLogger(OrangeHRM_StepDefinition.class);
    static XSSFWorkbook wbk;
    static int rowNum, rowNum_Index;
    static String userName, pswd, firstName, lastName, location, marital_Status, gender, region, fte, temp_dept;

    @Given("OrangeHRM application is loaded")
    public void orangeHRM_load(){
        driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");
        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");
        driver.get("https://automationo-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM website is loaded");
    }

    @When("User entered username as {string}")
    public void enterUserName(String userName){
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
        System.out.println(userName+" is entered as UserName");
    }

    @And("User entered password as {string}")
    public void enterPassword(String password){
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        System.out.println(password+" is entered as Password");
    }

    @And("User Clicks on Login button")
    public void clickLogin(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");
    }

    @Then("User verified Login is successful")
    public void verifyLogin(){
        boolean isPresent = driver.findElement(By.xpath("//i[text()='oxd_home_menu']")).isDisplayed();
        Assert.assertTrue(isPresent,"Home Menu icon is not displayed");
        System.out.println("Home Menu icon is displayed and Login is successful");
    }

    @And("User Verified title of the Homepage")
    public void verifyTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle="Employee Management";
        Assert.assertEquals(actualTitle,expectedTitle,"Title of the webpage is not matched");
        System.out.println("Title of the webpage is matched and verified");
    }

    @Given("User loads OrangeHRM Application in {string} browser")
    public void loadOrangeHRMApplication(String browserName){
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass baseClass = new BaseClass(driver);
        driver.get("https://automatetest-trials710.orangehrmlive.com/");
        log.info("OrangeHRM website is launched");
    }

    @When("User Login into OrangeHRM Application with UserName as {string} and Password as {string}")
    public void loginOrangeHRM(String userName, String password){
        OrangeHRM_LoginPage.login(userName, password);
    }

    @Then("User Verifies Successful Login")
    public void user_verifies_successful_login() {
        OrangeHRM_HomePage.verifyTitle();
    }
    @When("User Opens Add Employee Page")
    public void user_opens_add_employee_page() throws Exception{
        OrangeHRM_EmployeeManagementPage.openAddEmployee();
    }
    @When("User Provides FirstName, LastName, Location in Add EmployeePage and Clicks on Next")
    public void user_provides_first_name_last_name_location_in_add_employee_page_and_clicks_on_next() {
        OrangeHRM_AddEmployeePage.enterFirstName_LastName_Location(firstName, lastName, location);
    }
    @When("User Selects Marital Status and Gender and Clicks on Next")
    public void user_selects_marital_status_and_gender_and_clicks_on_next() {

    }
    @When("User Selects Region, FTE, Temporary Department and Clicks on Save button")
    public void user_selects_region_fte_temporary_department_and_clicks_on_save_button() {

    }
    @Then("User Search for New Employee")
    public void user_search_for_new_employee() {

    }
    @Then("User Verifies New Employee information")
    public void user_verifies_new_employee_information() {

    }

    @Given("User reads AddEmployee Data from {string} using TestID {string}")
    public void readExcelSheetData_AddEmployee(String sheetName, String testID) throws Exception{
        Log.startTestCase(OrangeHRM_StepDefinition.class.getName());
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
    public void readExcelSheetData_AddUser(String sheetName, String testID) throws Exception{
        Log.startTestCase(OrangeHRM_StepDefinition.class.getName());
        wbk = ExcelUtils.setExcelFilePath();
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        pswd = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);

    }
}
