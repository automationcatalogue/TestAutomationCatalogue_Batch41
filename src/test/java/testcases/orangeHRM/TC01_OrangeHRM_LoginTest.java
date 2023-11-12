package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC01_OrangeHRM_LoginTest extends TestRunner {

    static String userName;
    static String password;
    static String sheetName;
    static Logger log = LogManager.getLogger(TC01_OrangeHRM_LoginTest.class);
    static WebDriver driver;
    static int rowNum, rowNum_Index;
    private static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.LoginTestCase_ID) String testID) throws Exception {
        //To Create the Test in Extent Report
        logger = extent.createTest("OrangeHRMLogin_" + testID);
        Log.startTestCase(TC01_OrangeHRM_LoginTest.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "OrangeHRM_Login";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("Password from excel sheet is:" + password);
    }

    @Test
    @Parameters({"browserName"})
    public static void login(@Optional(Config.browserName) String browserName) throws Exception {
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
        logger.log(Status.INFO, "OrangeHRM Title is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HomePage");
        logger.log(Status.INFO, "OrangeHRM Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HomePage").build());

        //OrangeHRM Logout
        OrangeHRM_HomePage.logout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.SUCCESS) {

            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
            logger.pass("OrangeHRM Login testcase is passed");

        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", rowNum_Index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");

                logger.fail("OrangeHRM Login testcase is failed");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");

            logger.skip("OrangeHRM Login testcase is skipped");
        }
        driver.quit();
        Log.endTestCase();
    }
}
