package testcases.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC12_DemoWebshop_TotalOrders extends TestRunner {
    static XSSFWorkbook wbk;
    static String userName;
    static String password;
    static int TotalNumberOfOrders;
    static float SumOfAllOrders;
    static String sheetName;
    static int rowNum_testCase;
    static int rowNum_Index;
    static Logger log = LogManager.getLogger(TC12_DemoWebshop_TotalOrders.class);
    static WebDriver driver;

    @BeforeClass
    public void prerequisite_setup(@Optional(Config.TotalOrdersRequestTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC12_DemoWebshop_TotalOrders.class.getName());
        wbk = ExcelUtils.setExcelFilePath();
        sheetName = "DemoWebShop_TotalOrders";
        rowNum_testCase = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");

        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);

        password = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_Password);
        log.info("Password from excel sheet is:" + password);
    }


    @Test
    @Parameters({"browserName"})
    public void TotalOrder(@Optional("chrome") String browserName) throws Exception {
        driver = CommonUtils.browserLaunch("chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get("https://demowebshop.tricentis.com/");
        String className = this.getClass().getName();

        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        DemoWebshop_LoginPage.login(userName, password);
        CommonUtils.takeScreenshot(screenshotsPath, "LoginPage");

        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        CommonUtils.takeScreenshot(screenshotsPath, "MyAccountPage");
        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        CommonUtils.takeScreenshot(screenshotsPath, "OrdersPage");
        TotalNumberOfOrders = DemoWebShop_OrdersPage.totalNumberOfOrders();
        SumOfAllOrders = DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
        DemoWebShop_OrdersPage.sumOfOrdersDayWise();
        driver.close();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(String.valueOf(TotalNumberOfOrders), "DemoWebShop_TotalOrders", rowNum_testCase, Config.col_TotalOrders_NumberOfOrders);
            log.info(TotalNumberOfOrders + " is updated as Total Number of Orders");

            ExcelUtils.setCellData(String.valueOf(SumOfAllOrders), "DemoWebShop_TotalOrders", rowNum_testCase, Config.col_TotalOrders_SumOfAllOrders);
            log.info(TotalNumberOfOrders + " is updated as Sum Of All Orders");

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
        Log.endTestCase();
    }
}
