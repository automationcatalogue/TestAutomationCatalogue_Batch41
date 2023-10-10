package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import pages.OrangeHRM_LogoutPage;
import testcases.setup.TestRunner;
import utilities.*;
public class TC01_OrangeHRM_LoginTest  extends TestRunner {

    static XSSFWorkbook wbk;
    static String userName;
    static String password;
    static Logger log = LogManager.getLogger(TC01_OrangeHRM_LoginTest.class);
    static WebDriver driver;
    static int rowNum_Index;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.LoginTestCase_ID) String testID) throws Exception{
        logger = extent.createTest("OrangeHRMLogin_"+testID);
        Log.startTestCase(TC01_OrangeHRM_LoginTest.class.getName());

        wbk= ExcelUtils.setExcelFilePath();
        String sheetName = "OrangeHRM_Login";

        int roNum = ExcelUtils.getRowNumber(testID,sheetName);
        userName = ExcelUtils.getCellData(sheetName,roNum, Config.col_UserName);
        log.info("UserName from excel sheet is :"+userName);

        password = ExcelUtils.getCellData(sheetName,roNum,Config.col_Password);
        log.info("Password from excel sheet is:"+password);
        rowNum_Index =ExcelUtils.getRowNumber(testID,"Index");
    }

    @Test
    @Parameters({"browserName"})
    public static void login(@Optional("chrome") String browserName) throws Exception{
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);
        String url ="https://automatetest-trials710.orangehrmlive.com/";
        driver.get(url);

        log.info("OrangeHRM URL is loaded :"+url);
        logger.log(Status.INFO,"OrangeHRM Application is loaded"+url);
        CommonUtils.takeScreenshot(screenshotsPath,"OrangeHRM_LoginPage");
        log.info(screenshotsPath+"\\OrangeHRM_LoginPage.jpg");
        logger.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshotsPath+"\\OrangeHRM_LoginPage.jpg").build());
        //logger.addScreenCaptureFromPath(screenshotsPath+"\\OrangeHRM_LoginPage.jpg");

        OrangeHRM_LoginPage.login(userName, password);
        logger.log(Status.INFO,"OrangeHRM Login is Successful");
        Thread.sleep(6000);
        CommonUtils.takeScreenshot(screenshotsPath,"OrangeHRM_HomePage");
        //logger.addScreenCaptureFromPath(screenshotsPath+"\\OrangeHRM_HomePage.jpg");
        logger.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshotsPath+"\\OrangeHRM_HomePage.jpg").build());

        OrangeHRM_HomePage.verifyTitle();
        logger.log(Status.INFO,"OrangeHRM Title is Verified");

        OrangeHRM_LogoutPage.logout();
        logger.log(Status.INFO,"Logged out from OrangeHRM application");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");

            logger.pass("OrangeHRM Login testcase is passed");

        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",rowNum_Index,Config.col_reason);
                log.info("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");

                logger.pass("OrangeHRM Login testcase is failed");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");

            logger.pass("OrangeHRM Login testcase is skipped");
        }

        driver.quit();
        ExcelUtils.closeExcelFile();
        Log.endTestCase();
    }
}
