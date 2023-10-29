package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.OrangHRM_AddUserPage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

import java.time.Duration;

public class TC03_OrangeHRM_AddUser extends TestRunner {


    static int rowNum, rowNum_Index;
    static String newUserName, userName, password, empName, addUser, confirm_Password, newPassword;
    static WebDriver driver;
    private String base64;
    static Logger log = LogManager.getLogger(TC03_OrangeHRM_AddUser.class);

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisites(@Optional(Config.AddUserTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest("OrangeHRMAdduser_" + testID);
        Log.startTestCase(TC03_OrangeHRM_AddUser.class.getName());


        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        String sheetName = "OrangeHRM_AddUser";
        int rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);


        //Reading the TestData from Excel file
        newUserName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + newUserName);
        password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("password from excel sheet is :" + password);
        empName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_EmployeeName);
        log.info("empName from excel sheet is :" + empName);
        addUser = RandomGenerator.getRandomData("username");
        log.info("addUser from excel sheet is :" + addUser);

        newPassword = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_ConfirmPassword);
        log.info("newPassword from excel sheet is :" + newPassword);
        confirm_Password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_AddUser_ConfirmPassword);
        log.info("confirm_pwd from excel sheet is :" + confirm_Password);
    }

    @Test
    @Parameters({"browserName"})
    public void login(@Optional("chrome") String browserName) throws Exception {
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String userName = RandomGenerator.getRandomData("userName");
        log.info("Randomly generated username is :" + userName);
        driver.get("https://automatetest-trials710.orangehrmlive.com/");


        //Click on HR Administration link
        OrangeHRM_HomePage.clickHrAdministrationLink();

        log.info("HR administration Page is Loaded");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HRadministrationPage");
        logger.log(Status.INFO, "HR Administation Page is Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HRadministation Page").build());

        OrangHRM_AddUserPage.clickAddUser();
        log.info("Add User Page is Loaded");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_Add UserPage");
        logger.log(Status.INFO, "Add User Page is Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_Add UserPage").build());


        OrangHRM_AddUserPage.enterAddUserDetails(empName, addUser, newPassword, confirm_Password);
        log.info("Add User details is entered");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_Add User details Page");
        logger.log(Status.INFO, "Add User details Page is Loaded", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_Add User Details Page").build());


        OrangHRM_AddUserPage.clickSave();
        logger.log(Status.INFO, " OrangeHRM AddUserde page is saved ");


        OrangeHRM_HomePage.clickLogout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");

        OrangeHRM_LoginPage.login(addUser, confirm_Password);
        log.info("OrangeHRM Login is Successful");


        //Verify the Employee Name as Charlie Carter
        OrangeHRM_HomePage.verify_empName(empName);
        log.info("OrangeHRM empName is Verified");
        logger.log(Status.INFO, "OrangeHRMempName is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_empName");
        logger.log(Status.INFO, "OrangeHRM Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_empName").build());


        OrangeHRM_HomePage.clickLogout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.SUCCESS) {

            ExcelUtils.setCellData(addUser, "OrangeHRM_AddUser", rowNum, Config.col_AddUser_NewUser);
            log.info(addUser + "is updated in Excel sheet as New UserName");

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

