package testcases.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

    XSSFWorkbook wbk;
    int row;
    String userName_1;
    String password;
    String empName;
    String addUser;
    String confirm_pwd;
    String newPassword;
    static String sheetName;
    static int rowNum_Index;
    static WebDriver driver;
    static Logger log = LogManager.getLogger(TC03_OrangeHRM_AddUser.class);

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisites(@Optional(Config.AddUserTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC03_OrangeHRM_AddUser.class.getName());
        sheetName = "OrangeHRM_AddUser";

        row = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName_1 = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        empName = ExcelUtils.getCellData(sheetName, row, Config.col_AddUser_EmployeeName);
        addUser = RandomGenerator.getRandomData("username");
        newPassword = ExcelUtils.getCellData(sheetName, row, Config.col_AddUser_ConfirmPassword);
        confirm_pwd = ExcelUtils.getCellData(sheetName, row, Config.col_AddUser_ConfirmPassword);
    }

    @Test
    @Parameters({"browserName"})
    public void login(@Optional("chrome") String browserName) throws Exception {
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String userName = RandomGenerator.getRandomData("userName");
        log.info("Randomly generated username is :" + userName);
        driver.get("https://automatetest-trials710.orangehrmlive.com/");

        //Enter the UserName as "Admin"
        OrangeHRM_LoginPage.login(userName_1, password);
        OrangeHRM_HomePage.verifyTitle();

        //Click on HR Administration link
        OrangeHRM_HomePage.clickHrAdministrationLink();
        OrangHRM_AddUserPage.clickAddUser();
        OrangHRM_AddUserPage.enterAddUserDetails(empName, addUser, newPassword, confirm_pwd);
        OrangHRM_AddUserPage.clickSave();
        OrangeHRM_HomePage.clickLogout();
        OrangeHRM_LoginPage.login(addUser, confirm_pwd);
        //Verify the Employee Name as Charlie Carter
        OrangeHRM_HomePage.verify_empName(empName);
        OrangeHRM_HomePage.clickLogout();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.SUCCESS) {

            ExcelUtils.setCellData(addUser, "OrangeHRM_AddUser", row, Config.col_AddUser_NewUser);
            log.info(addUser+"is updated in Excel sheet as New UserName");

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
        ExcelUtils.closeExcelFile();
        log.info("ExcelFile reading is closed");
        Log.endTestCase();

    }
}

