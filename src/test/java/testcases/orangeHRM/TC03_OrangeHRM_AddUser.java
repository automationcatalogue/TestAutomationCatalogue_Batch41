package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.orangeHRM.OrangeHRM_AddUserPage;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC03_OrangeHRM_AddUser extends TestRunner {

    static int rowNum, rowNum_Index;
    static String newUserName, userName, password, empName, confirm_Password, newPassword;
    static WebDriver driver;
    static String sheetName;
    private String base64;
    static Logger log = LogManager.getLogger(TC03_OrangeHRM_AddUser.class);

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisites(@Optional(Config.AddUserTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest(testID + "_OrangeHRMAdduser");
        Log.startTestCase(TC03_OrangeHRM_AddUser.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "OrangeHRM_AddUser";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("Password from excel sheet is :" + password);
        empName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_EmployeeName);
        log.info("EmpName from excel sheet is :" + empName);
        newUserName = RandomGenerator.getRandomData("username");
        log.info("Random New UserName is :" + newUserName);
        newPassword = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_ConfirmPassword);
        log.info("New Password from excel sheet is :" + newPassword);
        confirm_Password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_ConfirmPassword);
        log.info("Confirm Password from excel sheet is :" + confirm_Password);
    }

    @Test
    @Parameters({"browserName"})
    public void addUser(@Optional(Config.browserName) String browserName) throws Exception {
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

        //Click on HR Administration link
        OrangeHRM_HomePage.clickHrAdministrationLink();
        log.info("HR administration Page is Loaded");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HRAdministrationPage");
        logger.log(Status.INFO, "HR Administration Page is Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HRAdministrationPage").build());

        OrangeHRM_AddUserPage.clickAddUser();
        log.info("Add User Page is Loaded");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_AddUserPage");
        logger.log(Status.INFO, "Add User Page is Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_AddUserPage").build());

        OrangeHRM_AddUserPage.enterAddUserDetails(empName, newUserName, newPassword, confirm_Password);
        log.info("Add User details is entered");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_AddUserDetails");
        logger.log(Status.INFO, "Add User details Page is entered", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_AddUserDetails").build());

        OrangeHRM_HomePage.logout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");

        OrangeHRM_LoginPage.login(newUserName, confirm_Password);
        log.info("OrangeHRM Login is Successful");

        //New User Verification
        OrangeHRM_HomePage.verifyNewEmpName(empName);
        log.info("OrangeHRM empName is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_NewEmpName");
        logger.log(Status.INFO, "OrangeHRM EmpName is Verified", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_NewEmpName").build());

        OrangeHRM_HomePage.logout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(newUserName, sheetName, rowNum, Config.col_AddUser_NewUser);
            log.info(newUserName + "is updated in Excel sheet as New UserName");
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
            logger.log(Status.PASS, "OrangeHRM Add User TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", rowNum_Index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
                logger.log(Status.FAIL, "OrangeHRM Add User TestCase is Failed and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
            logger.log(Status.SKIP, "OrangeHRM Add User TestCase is Skipped and status is updated in Excel sheet");
        }
        driver.quit();
        Log.endTestCase();
    }
}

