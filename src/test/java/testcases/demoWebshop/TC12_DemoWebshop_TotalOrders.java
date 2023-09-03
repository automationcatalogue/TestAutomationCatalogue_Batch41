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
import java.util.concurrent.Callable;

public class TC12_DemoWebshop_TotalOrders {

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

    static Logger log = LogManager.getLogger(TC12_DemoWebshop_TotalOrders.class);


    @BeforeClass
    public void prerequisite_setup() throws Exception {
        Log.startTestCase(TC12_DemoWebshop_TotalOrders.class.getName());
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
        String className= this.getClass().getName();

        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        DemoWebshop_LoginPage.login(userName,password);
        //CommonUtils.takeScreenshot(screenshotsPath,"LoginPage");

        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        //CommonUtils.takeScreenshot("MyAccountPage");
        //CommonUtils.takeScreenshot(screenshotsPath,"MyAccountPage");
        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        //CommonUtils.takeScreenshot(screenshotsPath,"OrdersPage");
        //DemoWebShop_OrdersPage.totalNumberOfOrders();
        //DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
        //DemoWebShop_OrdersPage.sumOfOrdersDayWise();
        driver.close();
    }

    @AfterClass
    public void tearDown(ITestResult result) throws Exception {


       cell_TotalNumberOfOrders = row.getCell(5);
        cell_SumOfAllOrders = row.getCell(6);

        if(cell_TotalNumberOfOrders==null){
            cell_TotalNumberOfOrders=row.createCell(5);
        }
        cell_TotalNumberOfOrders.setCellValue(TotalNumberOfOrders);
        fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
        log.info(TotalNumberOfOrders+" is written back to the Excel file");

        if(cell_SumOfAllOrders==null)
        {
            cell_SumOfAllOrders=row.createCell(6);
        }
        cell_SumOfAllOrders.setCellValue(SumOfAllOrders);
        fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
        log.info(SumOfAllOrders+" is written back to the Excel file");
        fos.close();
        log.info("ExcelFile Writing is closed");
        fis.close();
        log.info("ExcelFile reading is closed");

    }

}



