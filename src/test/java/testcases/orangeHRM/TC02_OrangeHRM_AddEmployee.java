package testcases.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.OrangeHRM_AddEmployeePage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import pages.OrangeHRM_LogoutPage;
import utilities.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;


public class TC02_OrangeHRM_AddEmployee {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sht;
    static XSSFRow row;
    static XSSFCell username_cell, password_cell, newPassword_cell, firstName_cell, lastName_cell, location_cell, maritalStatus_cell, gender_cell, region_cell, fte_cell, tempdept_cell;
    static String userName, pswd, newPassword, firstName, lastName, location, marital_Status, gender, region, fte, temp_dept;
    static String projectPath;
    static FileOutputStream  fos;
    static String empid;
    static String sheetName;
    static int rowNum;
    static int rowNum_Index;
    static Logger log = LogManager.getLogger(TC02_OrangeHRM_AddEmployee.class);

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisite_setup(@Optional(Config.TestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC02_OrangeHRM_AddEmployee.class.getName());
        wbk= ExcelUtils.setExcelFilePath();
        sheetName = "OrangeHRM_AddEmployee";
        rowNum = ExcelUtils.getRowNumber(testID,sheetName);
        rowNum_Index =ExcelUtils.getRowNumber(testID,"Index");
        userName = ExcelUtils.getCellData(sheetName,rowNum, Config.col_UserName);
        pswd = ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        firstName = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_FirstName);
        lastName = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_LastName);
        location = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_Location);
        marital_Status = ExcelUtils.getCellData(sheetName,rowNum, Config.col_AddEmployee_MaritalStatus);
        gender = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_Gender);
        region = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_Region);
        fte = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_FTE);
        temp_dept = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_TempDepartment);

    }
    @Test
    @Parameters({"browserName"})
    public void addEmployee(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch("Chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        log.info("OrangeHRM website is launched");

        String title = driver.getTitle();
        log.info("Title of the page is:" + title);

        OrangeHRM_LoginPage.login(userName, pswd);
        CommonUtils.takeScreenshot("LoginPage");

        OrangeHRM_HomePage.clickEmployeeManagementLink();
        CommonUtils.takeScreenshot("EmployeeManagementLink");

        OrangeHRM_AddEmployeePage.enterFirstNameAndLastName(firstName,lastName);
        CommonUtils.takeScreenshot("FirstName_LastName");

        OrangeHRM_AddEmployeePage.selectLocation(location);
        OrangeHRM_AddEmployeePage.selectMaritalStatus(marital_Status);
        OrangeHRM_AddEmployeePage.selectGender(gender);
        OrangeHRM_AddEmployeePage.selectRegion(region);
        OrangeHRM_AddEmployeePage.selectFTE(fte);
        OrangeHRM_AddEmployeePage.selectTempDept(temp_dept);
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_AddEmployeePage.searchEmployee(firstName,lastName);
        empid=OrangeHRM_AddEmployeePage.verifyEmployeeId_name(firstName,lastName);
        OrangeHRM_LogoutPage.logout();
        driver.quit();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(empid,sheetName,rowNum, Config.col_AddEmployee_EmployeeId);
            log.info(empid+" is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",rowNum_Index,Config.col_reason);
                log.info("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        ExcelUtils.closeExcelFile();
    }


}
