package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.OrangeHRM_AddEmployeePage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC02_OrangeHRM_AddEmployee extends TestRunner {

    static String userName, password, firstName, lastName, location, maritalStatus, gender, region, fte, tempDept;
    static String empid;
    static String sheetName;
    static int rowNum, rowNum_Index;
    static Logger log = LogManager.getLogger(TC02_OrangeHRM_AddEmployee.class);
    static WebDriver driver;
    private String base64;

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisite_setup(@Optional(Config.AddEmployeeTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest("OrangeHRMAddEmployee_" + testID);
        Log.startTestCase(TC02_OrangeHRM_AddEmployee.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "OrangeHRM_AddEmployee";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("Password from excel sheet is :" + password);
        firstName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_FirstName);
        log.info("FirstName from excel sheet is :" + firstName);
        lastName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_LastName);
        log.info("LastName from excel sheet is :" + lastName);
        location = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Location);
        log.info("Location from excel sheet is :" + location);
        maritalStatus = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_MaritalStatus);
        log.info("Marital Status from excel sheet is :" + maritalStatus);
        gender = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Gender);
        log.info("Gender from excel sheet is :" + gender);
        region = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_Region);
        log.info("Region from excel sheet is :" + region);
        fte = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_FTE);
        log.info("FTE from excel sheet is :" + fte);
        tempDept = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddEmployee_TempDepartment);
        log.info("Temp Department from excel sheet is :" + tempDept);
    }

    @Test
    @Parameters({"browserName"})
    public void addEmployee(@Optional(Config.browserName) String browserName) throws Exception {
        //Browser Launch
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        //Loading OrangeHRM URL
        driver.get(Config.orangeHRM_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_LoginPage");
        log.info("OrangeHRM URL is loaded :" + Config.orangeHRM_URL);
        logger.log(Status.INFO, "OrangeHRM Application is loaded" + Config.orangeHRM_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_LoginPage").build());

        OrangeHRM_LoginPage.login(userName, password);
        log.info("OrangeHRM Login is Successful");

        OrangeHRM_HomePage.verifyTitle();
        log.info("OrangeHRM Title is Verified");
        logger.log(Status.INFO, "OrangeHRM Title is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HomePage");
        logger.log(Status.INFO, "OrangeHRM Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HomePage").build());

        OrangeHRM_HomePage.clickEmployeeManagementLink();
        log.info("Employee Management Page is Loaded");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_EmployeeManagementPage");
        logger.log(Status.INFO, "Employee Management Page is Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_EmployeeManagementPage").build());

        OrangeHRM_AddEmployeePage.enterAddEmployee_FirstPage(firstName, lastName, location);
        log.info("Add Employee FirstPage Data is entered");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_AddEmployee_FirstPage");
        logger.log(Status.INFO, "Add Employee FirstPage Data is entered", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_AddEmployee_FirstPage").build());

        OrangeHRM_AddEmployeePage.enterAddEmployee_SecondPage(maritalStatus, gender);
        log.info("Add Employee SecondPage Data is entered");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_AddEmployee_SecondPage");
        logger.log(Status.INFO, "Add Employee SecondPage Data is entered", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_AddEmployee_SecondPage").build());

        OrangeHRM_AddEmployeePage.enterAddEmployee_ThirdPage(region, fte, tempDept);
        log.info("Add Employee ThirdPage Data is entered");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_AddEmployee_ThirdPage");
        logger.log(Status.INFO, "Add Employee ThirdPage Data is entered", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_AddEmployee_ThirdPage").build());

        OrangeHRM_HomePage.clickEmployeeManagementLink();
        log.info("Employee Management Page is Loaded");
        logger.log(Status.INFO, "Employee Management Page is Loaded");

        OrangeHRM_AddEmployeePage.searchEmployee(firstName, lastName);
        log.info("Searched for New Employee Data");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_AddEmployee_SearchNewEmployee");
        logger.log(Status.INFO, "Searched for New Employee Data", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_AddEmployee_SearchNewEmployee").build());

        empid = OrangeHRM_AddEmployeePage.verifyEmployeeId_name(firstName, lastName);
        log.info("Verified New Employee Data");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_AddEmployee_VerifyNewEmployee");
        logger.log(Status.INFO, "Verified New Employee Data", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_AddEmployee_VerifyNewEmployee").build());

        OrangeHRM_HomePage.logout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

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

                logger.fail("OrangeHRM AddEmployee testcase is failed");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");

            logger.fail("OrangeHRM AddEmployee testcase is skipped");
        }
        driver.quit();
        Log.endTestCase();
    }

}
