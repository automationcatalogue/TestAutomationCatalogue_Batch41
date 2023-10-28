package testcases.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebshop_CheckoutPage;
import pages.DemoWebshop_LoginPage;
import pages.DemoWebshop_CartPage;
import pages.DemoWebshop_OrderInformationPage;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC11_DemoWebshop_ReOrder extends TestRunner {

    static XSSFWorkbook wbk;
    static String userName;
    static String password;
    static String orderNumber;
    static String sheetName;
    static int rowNum_testCase;
    static int rowNum_Index;
    static Logger log = LogManager.getLogger(TC11_DemoWebshop_ReOrder.class);
    static WebDriver driver;

    @Parameters("{testID}")
    @BeforeClass
    public void prerequisite_setup(@Optional(Config.ReOrderRequestTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC11_DemoWebshop_ReOrder.class.getName());

        sheetName = "DemoWebshop_ReOrder";
        rowNum_testCase = ExcelUtils.getRowNumber(testID,sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID,"Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_Password);
    }

    @Test
    @Parameters({"browserName"})
    public static void ReOrder(@Optional("chrome") String browserName) throws Exception {

        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        driver.get("https://demowebshop.tricentis.com/");
        log.info("Demo website is loaded");

        String title = driver.getTitle();
        log.info("Title of the page is:" + title);

        DemoWebshop_HomePage.clickLoginLink();
        DemoWebshop_LoginPage.login(userName,password);
        DemoWebshop_HomePage.clickEmailLink();
        DemoWebShop_OrdersPage.clickLinkOrders();
        DemoWebShop_OrdersPage.clickOrderDetailsBtn();
        DemoWebshop_OrderInformationPage.clickReorderBtn();
        DemoWebshop_CartPage.clickCheckboxIagree();
        DemoWebshop_CartPage.clickCheckoutBtn();
        DemoWebshop_CheckoutPage.clickBillingContinue();
        DemoWebshop_CheckoutPage.clickShippingAddressBtn();
        DemoWebshop_CheckoutPage.clickShippingMethodBtn();
        DemoWebshop_CheckoutPage.clickPaymentMethodBtn();
        DemoWebshop_CheckoutPage.clickPaymentInformationBtn();
        DemoWebshop_CheckoutPage.clickConfirmOrderBtn();
        orderNumber=DemoWebshop_CheckoutPage.getOrderNumber();
        DemoWebshop_HomePage.logout();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(orderNumber, sheetName, rowNum_testCase, Config.col_Reorder_OrderNumber);
            log.info(orderNumber+" is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",rowNum_Index,Config.col_reason);
                log.info("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }

        driver.quit();
        ExcelUtils.closeExcelFile();
        Log.endTestCase();
    }
}
