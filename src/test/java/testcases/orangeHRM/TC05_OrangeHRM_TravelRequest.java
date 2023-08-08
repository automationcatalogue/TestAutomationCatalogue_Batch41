package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;


public class TC05_OrangeHRM_TravelRequest {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sht;
    static int rowNum,rowNum_Index;
    static XSSFCell username_cell, password_cell, newPassword_cell, employeeName_Cell;
    static XSSFCell currency_cell, destination_cell, travelFrom_cell, travelTO_cell, expenseType_cell, currencyPaidIn_cell, amount_cell, paidBy_cell, travelReqId_cell, reqStatus_cell;
    static String userName, pswd, newPassword, currency, destination, travelFrom, travelTo, expenseType, currencyPaidIn, paidBy, travelReqId, reqStatus;
    static String projectPath, employeeName,supervisor_username;
    static FileOutputStream fos;
    static String amount;
    static String Id,Status;
    static String status;
    static String request_id;
    static String requestStatus;
    static String sheetName;
    static String supervisor_name;

    @BeforeClass
    public void prerequisite_setup() throws Exception {


        wbk= ExcelUtils.setExcelFilePath();
        sheetName = "OrangeHRM_TravelExpense";
        rowNum = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
        rowNum_Index =ExcelUtils.getRowNumber(Config.TestCase_ID,"Index");
        userName=ExcelUtils.getCellData(sheetName,rowNum,Config.col_UserName);
        pswd=ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        newPassword = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_newPassword);
        currency = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_currency);
        destination = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_destination);
        travelFrom =ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_travelFrom);
        travelTo = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_travelTo);
        expenseType = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_expenseType);
        currencyPaidIn = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_currencyPaidIn);
        amount = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_amount);
        paidBy = ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_paidBy);
        employeeName=ExcelUtils.getCellData(sheetName,rowNum,Config.col_TravelExpense_employeeName);

    }

    @Test
    @Parameters({"browserName"})
    public void travelExpense(@Optional("chrome") String browserName) throws Exception {
        WebDriver driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        //logged in as admin
        OrangeHRM_LoginPage.login(userName, pswd);

        //title verification
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickHrAdministrationLink();
        OrangeHRM_HRAdministrationPage.clickOnUsersLink();

        //select a first employee from employee list and change password
        OrangeHRM_UsersPage.getEmployeeDetails();
        OrangeHRM_UsersPage.changeEmployeePassword(newPassword);

        // find supervisor of the employee *** should it return sup name???


        OrangeHRM_HomePage.clickEmployeeManagementLink();

        supervisor_name =OrangeHRM_EmployeeManagementPage.clickEmployeeList_getSupervisorName(employeeName);
        OrangeHRM_HomePage.clickHrAdministrationLink();
        supervisor_username =OrangeHRM_UsersPage.username_Supervisor(supervisor_name);

        OrangeHRM_UsersPage.changeSupervisorPassword(supervisor_name,newPassword);
        OrangeHRM_LogoutPage.logout();


        //Login to employee's account, create and submit the travel request
        OrangeHRM_LoginPage.login_employee(OrangeHRM_UsersPage.userName, newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        OrangeHRM_TravelExpensePage.clickAddTravelExp();
        OrangeHRM_TravelExpensePage.selectcurrency(currency);
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

        request_id = OrangeHRM_TravelExpensePage.reqestId();
        requestStatus = OrangeHRM_TravelExpensePage.request_Status();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        //login as supervisor
        OrangeHRM_LoginPage.login_supervisor(supervisor_username,newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        Thread.sleep(5000);
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        OrangeHRM_TravelExpensePage.supervisor_approval();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        OrangeHRM_LoginPage.login(OrangeHRM_UsersPage.userName,newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);

        Id =OrangeHRM_TravelExpensePage.updatedStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        System.out.println("Request is id " +Id);

        Status=OrangeHRM_TravelExpensePage.getStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        System.out.println("Status of the request is " +status);

        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        // Log in as Admin and Approve the request
        OrangeHRM_LoginPage.login(userName, pswd);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        OrangeHRM_TravelExpensePage.finalApproval();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        //login as Employee to check the final status

        OrangeHRM_LoginPage.login(OrangeHRM_UsersPage.userName,newPassword);
        OrangeHRM_HomePage.clickTRavelExpLink();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);

        Id =OrangeHRM_TravelExpensePage.updatedStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        System.out.println("Request is id " +Id);

        Status=OrangeHRM_TravelExpensePage.getStatus(OrangeHRM_TravelExpensePage.list_travelReqId, request_id);
        System.out.println("Status of the request is " +status);

        OrangeHRM_LogoutPage.logout();


    }
    /*@AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(travelReqId, sheetName, rowNum_testCase, Config.col_Reorder_OrderNumber);
            System.out.println(orderNumber+" is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            System.out.println("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                System.out.println("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",rowNum_Index,Config.col_reason);
                System.out.println("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            System.out.println("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        ExcelUtils.closeExcelFile();
    }*/
}