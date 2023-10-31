package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import testcases.setup.TestRunner;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;


public class TC05_OrangeHRM_TravelRequest extends TestRunner {

    static int rowNum, rowNum_Index;
    static String userName, passWord, newPassword, currency, destination, travelFrom, travelTo, expenseType, currencyPaidIn, paidBy, travelReqId, reqStatus;
    static String employeeName, supervisor_username, amount, Id, Status_1, status, request_id, requestStatus ;

    static String sheetName, employee_UserName, supervisor_name;

    static Logger log = LogManager.getLogger(TC04_OrangeHRM_EditEmployee.class);
    static WebDriver driver;
    private String base64;

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisite_setup(@Optional(Config.TravelRequestTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest("OrangeHRMTravelRequest" + testID);
        Log.startTestCase(TC05_OrangeHRM_TravelRequest.class.getName());
        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "OrangeHRM_TravelExpense";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);
        //Reading the TestData from Excel file

        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from " + sheetName);

        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        passWord = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("Password from excel sheet is :" + passWord);

        newPassword = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_newPassword);
        log.info("new Password from excel sheet is :" + newPassword);
        currency = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_currency);
        log.info("currency from excel sheet is :" + currency);

        destination = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_destination);
        log.info("destination from excel sheet is :" + destination);

        travelFrom = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_travelFrom);
        log.info("travelFrom from excel sheet is :" +  travelFrom);

        travelTo = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_travelTo);
        log.info("travelTo from excel sheet is :" + travelTo);

        expenseType = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_expenseType);
        log.info("expenseType from excel sheet is :" + expenseType);

        currencyPaidIn = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_currencyPaidIn);
        log.info("currencyPaidIn from excel sheet is :" + currencyPaidIn );

        amount = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_amount);
        log.info(" amount from excel sheet is :" +  amount);

        paidBy = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_paidBy);
        log.info(" paidByfrom excel sheet is :" +  paidBy);

        employeeName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_TravelExpense_employeeName);
        log.info("employeeName from excel sheet is :" + employeeName);
    }

    @Test
    @Parameters({"browserName"})
    public void travelExpense(@Optional("chrome") String browserName) throws Exception {
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        //Loading OrangeHRM URL
        driver.get(Config.orangeHRM_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_LoginPage");
        log.info("OrangeHRM URL is loaded :" + Config.orangeHRM_URL);
        logger.log(com.aventstack.extentreports.Status.INFO, "OrangeHRM Application is loaded" + Config.orangeHRM_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_LoginPage").build());


        //logged in as admin
        OrangeHRM_LoginPage.login(userName, passWord);
        log.info("OrangeHRM Login is Successful");

        OrangeHRM_HomePage.verifyTitle();
        log.info("OrangeHRM Title is Verified");
        logger.log(Status.INFO, "OrangeHRM Title is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HomePage");
        logger.log(Status.INFO, "OrangeHRM Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HomePage").build());

        OrangeHRM_HomePage.clickHrAdministrationLink();

        OrangeHRM_HRAdministrationPage.clickOnUsersLink();

        log.info("HRAdministrationPage is Loaded");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HRAdministrationPage");
        logger.log(Status.INFO, "HRAdministrationPageis Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HRAdministrationPage").build());

        employee_UserName = OrangeHRM_UsersPage.getEmployeeDetails();
        log.info("employee_UserName details  is entered");
        OrangeHRM_UsersPage.changeEmployeePassword(newPassword);
        log.info("newPassword is entered");
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        log.info("EmployeeManagement is clicked");
        supervisor_name = OrangeHRM_EmployeeManagementPage.getSupervisorName(employeeName);
        log.info(" supervisor_name is entered");
        OrangeHRM_HomePage.clickHrAdministrationLink();
        log.info("HrAdministration link is saved");
        supervisor_username = OrangeHRM_UsersPage.username_Supervisor(supervisor_name);
        log.info("Add Employee FirstPage Data is entered");
        OrangeHRM_UsersPage.changeSupervisorPassword(supervisor_name, newPassword);
        log.info("supervisor_username Data is entered");
        OrangeHRM_LogoutPage.logout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");

        //Login to employee's account, create and submit the travel request
        OrangeHRM_LoginPage.login_employee(employee_UserName, newPassword);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_HomePage.clickTRavelExpLink();
        log.info("Orange HRM travel Expense page details are entered");
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.clickAddTravelExp();
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.selectCurrency(currency);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.addTravelinfo();
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.destination(destination);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.travelFrom(travelFrom);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.travelto(travelTo);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.saveTravelexp();
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.travelRequestEstimateAddBtn();
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.selectExpenseType(expenseType);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.currency_paidin(currency);
        log.info("Orange HRM travel Expense page details are entered");// check th travel page and correct code as its only showing corresponding currency
        OrangeHRM_TravelExpensePage.amount(amount);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.selectPaidby(paidBy);
        log.info("Orange HRM travel Expense page details are entered");
        OrangeHRM_TravelExpensePage.submit_travelexp();
        log.info("Orange HRM travel Expense page details are entered");
        request_id = OrangeHRM_TravelExpensePage.reqestId();
        log.info("request-id details are entered");
        requestStatus = OrangeHRM_TravelExpensePage.request_Status();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        //login as supervisor
        OrangeHRM_LoginPage.login_supervisor(supervisor_username, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();

        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        OrangeHRM_TravelExpensePage.supervisor_approval();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();
        OrangeHRM_LoginPage.login(employee_UserName, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        Id = OrangeHRM_TravelExpensePage.updatedStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Request is id " + Id);
        Status_1 = OrangeHRM_TravelExpensePage.getStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Status of the request is " + status);
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        // Log in as Admin and Approve the request
        OrangeHRM_LoginPage.login(userName, passWord);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        OrangeHRM_TravelExpensePage.finalApproval();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        //login as Employee to check the final status
        OrangeHRM_LoginPage.login(employee_UserName, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        Id = OrangeHRM_TravelExpensePage.updatedStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Request is id " + Id);
        Status_1 = OrangeHRM_TravelExpensePage.getStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        log.info("Status of the request is " + status);
        OrangeHRM_LogoutPage.logout();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.SUCCESS) {
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
        driver.quit();

        Log.endTestCase();
    }
}