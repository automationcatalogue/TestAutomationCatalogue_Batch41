package testcases.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import utilities.*;

import java.time.Duration;

public class TC04_OrangeHRM_EditEmployee {
    XSSFWorkbook wbk;
    String userName;
    String passWord;
    String lastName;
    String DateOfBirth;
    String nationality;
    String allergies;
    String dietaryRequire1;
    String dietaryRequire2;
    String sheetName;
    int row, rowNum_Index;
    static WebDriver driver;
    static Logger log = LogManager.getLogger(TC04_OrangeHRM_EditEmployee.class);
    static TC04_OrangeHRM_EditEmployee ob = new TC04_OrangeHRM_EditEmployee();
    static String className = ob.getClass().getName();

    @Parameters({"testID"})
    @BeforeMethod
    public void prerequisite_Setup(@Optional(Config.EditEmployeeTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC04_OrangeHRM_EditEmployee.class.getName());
        sheetName = "OrangeHRM_EditEmployee";
        wbk = ExcelUtils.setExcelFilePath();
        row = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        passWord = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        lastName = ExcelUtils.getCellData(sheetName, row, Config.col_EditEmployee_LastName);
        DateOfBirth = ExcelUtils.getCellData(sheetName, row, Config.col_EditEmployee_DOB);
        nationality = ExcelUtils.getCellData(sheetName, row, Config.col_EditEmployee_Nationality);
        allergies = ExcelUtils.getCellData(sheetName, row, Config.col_EditEmployee_Allergies);
        dietaryRequire1 = ExcelUtils.getCellData(sheetName, row, Config.col_EditEmployee_DietaryRequirement_1);
        dietaryRequire2 = ExcelUtils.getCellData(sheetName, row, Config.col_EditEmployee_DietaryRequirement_2);

    }

    @Test
    @Parameters({"browserName"})
    public void EditEmployee(@Optional("chrome") String browserName) throws Exception {
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://automationo-trials710.orangehrmlive.com");
        log.info("OrangeHRM website is launched");

        OrangeHRM_LoginPage.login(userName, passWord);
        // CommonUtils.takeScreenshot();

        OrangeHRM_HomePage.verifyTitle();
        //CommonUtils.takeScreenshot(className,"Title verification");

        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_EmployeeManagementPage.personalDetails_firstEmployee();
        OrangeHRM_EditEmployeePage.enterLastName(lastName);
        //CommonUtils.takeScreenshot(className,"Entered last name");

        OrangeHRM_EditEmployeePage.Selection_DateOfBirth(DateOfBirth);
        OrangeHRM_EditEmployeePage.select_Nationality(nationality);
        OrangeHRM_EditEmployeePage.firstSave();
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Data");
        //CommonUtils.takeScreenshot(className,"Verification primary details");

        OrangeHRM_EditEmployeePage.select_Allergies(allergies);
        OrangeHRM_EditEmployeePage.secondSave();
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Hygiene");
        //CommonUtils.takeScreenshot(className,"Verification hygiene details");

        OrangeHRM_EditEmployeePage.select_diet(dietaryRequire1);
        OrangeHRM_EditEmployeePage.select_diet(dietaryRequire2);
        OrangeHRM_EditEmployeePage.thirdSave();
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Dietary Requirement");
        //CommonUtils.takeScreenshot(className,"Verification dietary details");

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
        ExcelUtils.closeExcelFile();
        log.info("ExcelFile reading is closed");
        Log.endTestCase();

    }
}























