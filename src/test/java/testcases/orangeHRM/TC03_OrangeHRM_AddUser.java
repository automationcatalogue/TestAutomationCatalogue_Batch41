package testcases.orangeHRM;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.OrangHRM_AddUserPage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import pages.OrangeHRM_LogoutPage;
import utilities.*;

import java.io.FileInputStream;
import java.time.Duration;

public class TC03_OrangeHRM_AddUser {

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
    @BeforeClass
    public void prerequisites() throws Exception
    {
        sheetName="OrangeHRM_AddUser";
        wbk= ExcelUtils.setExcelFilePath();
        row=ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(Config.TestCase_ID,"Index");
        userName_1=ExcelUtils.getCellData(sheetName,row, Config.col_UserName);
       password= ExcelUtils.getCellData(sheetName,row,Config.col_Password);
       empName= ExcelUtils.getCellData(sheetName,row,Config.col_AddUser_EmployeeName);
       addUser= ExcelUtils.getCellData(sheetName,row,Config.col_AddUser_NewUser);
       newPassword=ExcelUtils.getCellData(sheetName,row,Config.col_AddUser_ConfirmPassword);
       confirm_pwd=ExcelUtils.getCellData(sheetName,row,Config.col_AddUser_ConfirmPassword);


    }
    @Test
    @Parameters({"browserName"})
    public void login(@Optional("chrome") String browserName) throws Exception{
        WebDriver driver= CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String userName = RandomGenerator.getRandomData("userName");
        System.out.println("Randomly generated username is :"+userName);
        driver.get("https://seleniumautom-trials710.orangehrmlive.com");

        //Enter the UserName as "Admin"
        OrangeHRM_LoginPage.login(userName_1,password);
        OrangeHRM_HomePage.verifyTitle();

        //Click on HR Administration link
       OrangeHRM_HomePage.clickHrAdministrationLink();
       OrangHRM_AddUserPage.clickAddUser();
       OrangHRM_AddUserPage.enterAddUserDetails(empName,addUser,newPassword,confirm_pwd);
          OrangHRM_AddUserPage.clickSave();
        OrangeHRM_HomePage.clickLogout();
        OrangeHRM_LoginPage.login(addUser,confirm_pwd);
        //Verify the Employee Name as Charlie Carter
       OrangeHRM_HomePage.verify_empName(empName);
       OrangeHRM_HomePage.clickLogout();
        driver.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            System.out.println("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
                System.out.println("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",rowNum_Index,Config.col_reason);
                System.out.println("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index", rowNum_Index, Config.col_Status);
            System.out.println("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        ExcelUtils.closeExcelFile();
    }
}

