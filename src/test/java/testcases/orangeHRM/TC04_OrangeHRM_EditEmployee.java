package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import testcases.setup.TestRunner;
import utilities.*;


public class TC04_OrangeHRM_EditEmployee extends TestRunner {

    String userName, passWord, lastName, DateOfBirth, nationality, allergies;
    String dietaryRequire1, dietaryRequire2, sheetName;
    int rowNum, rowNum_Index;
    static WebDriver driver;
    private String base64;
    static Logger log = LogManager.getLogger(TC04_OrangeHRM_EditEmployee.class);

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisite_Setup(@Optional(Config.EditEmployeeTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest("OrangeHRMEditEmployee_" + testID);
        Log.startTestCase(TC04_OrangeHRM_EditEmployee.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "OrangeHRM_EditEmployee";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        passWord = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("Password from excel sheet is :" + passWord);
        lastName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_LastName);
        log.info("LastName from excel sheet is :" + lastName);
        DateOfBirth = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_DOB);
        log.info("DateOfBirth from excel sheet is :" + DateOfBirth);
        nationality = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_Nationality);
        log.info("Nationality from excel sheet is :" + nationality);
        allergies = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_Allergies);
        log.info("Allergies from excel sheet is :" + allergies);
        dietaryRequire1 = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_DietaryRequirement_1);
        log.info("DietaryRequire1 from excel sheet is :" + dietaryRequire1);
        dietaryRequire2 = ExcelUtils.getCellData(sheetName, rowNum, Config.col_EditEmployee_DietaryRequirement_2);
        log.info("DietaryRequire2 from excel sheet is :" + dietaryRequire2);
    }

    @Test
    @Parameters({"browserName"})
    public void EditEmployee(@Optional("chrome") String browserName) throws Exception {
        //Browser Launch
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        //Loading OrangeHRM URL
        driver.get(Config.orangeHRM_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_LoginPage");
        log.info("OrangeHRM URL is loaded :" + Config.orangeHRM_URL);
        logger.log(Status.INFO, "OrangeHRM Application is loaded" + Config.orangeHRM_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_LoginPage").build());

        OrangeHRM_LoginPage.login(userName, passWord);
        log.info("OrangeHRM Login is Successful");

        OrangeHRM_HomePage.verifyTitle();
        log.info("OrangeHRM Title is Verified");
        logger.log(Status.INFO, "OrangeHRM Title is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HomePage");
        logger.log(Status.INFO, "OrangeHRM Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HomePage").build());

        OrangeHRM_HomePage.clickEmployeeManagementLink();
        log.info("EmployeeManagement Page is Loaded");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_EmployeeManagementPage");
        logger.log(Status.INFO, "EmployeeManagement Page is Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_EmployeeManagement Page").build());

        OrangeHRM_EmployeeManagementPage.clickEmployeePersonalDetails(empN);
        log.info("OrangeHRM_EmployeeManagementPage firstEmployee details are entered");

        OrangeHRM_EditEmployeePage.enterLastName(lastName);
        log.info("OrangeHRM_EmployeeManagementPage lastName  is entered");


        OrangeHRM_EditEmployeePage.Selection_DateOfBirth(DateOfBirth);
        log.info("OrangeHRM_EmployeeManagementPage DateOfBirth  is entered");
        OrangeHRM_EditEmployeePage.select_Nationality(nationality);
        log.info("OrangeHRM_EmployeeManagementPage nationality is entered");

        OrangeHRM_EditEmployeePage.firstSave();
        log.info("OrangeHRM_EmployeeManagementPage  first time  is saved");
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Data");
        log.info("OrangeHRM_EmployeeManagementPage Data is updated");


        OrangeHRM_EditEmployeePage.select_Allergies(allergies);
        log.info("OrangeHRM_EmployeeManagementPage allergies  is entered");
        OrangeHRM_EditEmployeePage.secondSave();
        log.info("OrangeHRM_EmployeeManagementPage second time is saved ");
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Hygiene");
        log.info("OrangeHRM_EmployeeManagementPage Hygiene  is updated");


        OrangeHRM_EditEmployeePage.select_diet(dietaryRequire1);
        log.info("OrangeHRM_EmployeeManagementPage dietaryRequire1 is selected");
        OrangeHRM_EditEmployeePage.select_diet(dietaryRequire2);
        log.info("OrangeHRM_EmployeeManagementPage dietaryRequire2 is selected");
        OrangeHRM_EditEmployeePage.thirdSave();
        log.info("OrangeHRM_EmployeeManagementPage third time is saved");
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Dietary Requirement");
        log.info("OrangeHRM_EmployeeManagementPage Dietary Requirement  is updated");


        OrangeHRM_LogoutPage.logout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");
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























