package testcases.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebshop_CheckoutPage;
import pages.DemoWebshop_LoginPage;
import pages.DemoWebshop_CartPage;
import pages.DemoWebshop_OrderInformationPage;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import testcases.orangeHRM.TC02_OrangeHRM_AddEmployee;
import utilities.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

public class TC11_DemoWebshop_ReOrder {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;
    static XSSFCell cell_OrderNumber;
    static String orderNumber;
    static FileOutputStream fos;
    static String projectPath;
    static String sheetName;
    static int rowNum_testCase;
    static int rowNum_Index;
    static Logger log = LogManager.getLogger(TC11_DemoWebshop_ReOrder.class);

    @Parameters("{testID}")
    @BeforeClass
    public void prerequisite_setup(@Optional(Config.ReOrderRequestTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC11_DemoWebshop_ReOrder.class.getName());
        wbk= ExcelUtils.setExcelFilePath();
        sheetName = "DemoWebshop_ReOrder";
        rowNum_testCase = ExcelUtils.getRowNumber(testID,sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID,"Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_Password);
    }

    @Test
    @Parameters({"browserName"})
    public static void ReOrder(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch(browserName);
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
        DemoWebshop_CheckoutPage.getOrderNumber();

        DemoWebshop_HomePage.logout();
        driver.close();

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
        ExcelUtils.closeExcelFile();
    }
}
