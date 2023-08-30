package testcases.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

import java.io.File;
import java.io.FileInputStream;


public class TC01_OrangeHRM_LoginTest  extends TestRunner {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;
    static String projectPath;
    static Logger log = LogManager.getLogger(TC01_OrangeHRM_LoginTest.class);
    static File file;

    @BeforeClass
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.TestCase_ID) String testID) throws Exception{

        Log.startTestCase(TC01_OrangeHRM_LoginTest.class.getName());

        wbk= ExcelUtils.setExcelFilePath();
        String sheetName = "OrangeHRM_Login";

        int roNum = ExcelUtils.getRowNumber(testID,sheetName);
        userName = ExcelUtils.getCellData(sheetName,roNum, Config.col_UserName);
        log.info("UserName from excel sheet is :"+userName);

        password = ExcelUtils.getCellData(sheetName,roNum,Config.col_Password);
        log.info("Password from excel sheet is:"+password);
    }

    @Test
    @Parameters({"browserName"})
    public static void login(@Optional("chrome") String browserName) throws Exception{

        WebDriver driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        driver.get("https://automationo-trials710.orangehrmlive.com");
        log.info("OrangeHRM URL is loaded :https://seleniumautom-trials710.orangehrmlive.com");

        OrangeHRM_LoginPage.login(userName, password);
        Thread.sleep(6000);
        OrangeHRM_HomePage.verifyTitle();
        CommonUtils.takeScreenshot(screenshotsPath,"OrangeHRM_HomePage");

        driver.quit();
    }

    @AfterClass
    public void tearDown() throws Exception{
        fis.close();
        log.info("ExcelFile reading is closed");
        Log.endTestCase();
    }
}
