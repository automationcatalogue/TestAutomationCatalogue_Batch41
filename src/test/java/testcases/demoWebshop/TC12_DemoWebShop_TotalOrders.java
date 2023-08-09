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
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import testcases.orangeHRM.TC01_OrangeHRM_LoginTest;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TC12_DemoWebShop_TotalOrders {


    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;

    static XSSFCell cell_TotalNumberOfOrders;

    static XSSFCell cell_SumOfAllOrders;
    static String TotalNumberOfOrders;

    static  String SumOfAllOrders;

    static FileOutputStream fos;
    static String projectPath;

    static String sheetName;
    static int rowNum_testCase;
    static int rowNum_Index;

    static Logger log = LogManager.getLogger(TC12_DemoWebShop_TotalOrders.class);


    @BeforeClass
    public void prerequisite_setup() throws Exception {
        Log.startTestCase(TC12_DemoWebShop_TotalOrders.class.getName());
        wbk= ExcelUtils.setExcelFilePath();
        sheetName="DemoWebShop_TotalOrders";
        rowNum_testCase = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(Config.TestCase_ID,"Index");
        //int rowNum = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);

        userName = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);

        password = ExcelUtils.getCellData(sheetName,rowNum_testCase,Config.col_Password);
        log.info("Password from excel sheet is:" + password);

    }


    @Test
    @Parameters({"browserName"})
    //public static WebDriver TotalOrder() {
        public void TotalOrder(@Optional("chrome") String browserName) throws Exception{

        WebDriver driver = CommonUtils.browserLaunch("chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        DemoWebshop_LoginPage.login(userName,password);

        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        DemoWebShop_OrdersPage.totalNumberOfOrders();
        DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
        DemoWebShop_OrdersPage.sumOfOrdersDayWise();
       driver.close();
    }

    @AfterClass
    public void tearDown(ITestResult result) throws Exception {

        /*if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(SumOfAllOrders, sheetName, rowNum_testCase, Config.col_TotalOrders_SumOfAllOrders);
            log.info(SumOfAllOrders+" is written back to the Excel file");

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
    }*/

        cell_TotalNumberOfOrders = row.getCell(5);
        cell_SumOfAllOrders = row.getCell(6);

        if(cell_TotalNumberOfOrders==null){
            cell_TotalNumberOfOrders=row.createCell(5);
        }
        cell_TotalNumberOfOrders.setCellValue(TotalNumberOfOrders);
        fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
        System.out.println(TotalNumberOfOrders+" is written back to the Excel file");

        if(cell_SumOfAllOrders==null)
        {
            cell_SumOfAllOrders=row.createCell(6);
        }
        cell_SumOfAllOrders.setCellValue(SumOfAllOrders);
        fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
        System.out.println(SumOfAllOrders+" is written back to the Excel file");
        fos.close();
        System.out.println("ExcelFile Writing is closed");
        fis.close();
        System.out.println("ExcelFile reading is closed");

    }

}

