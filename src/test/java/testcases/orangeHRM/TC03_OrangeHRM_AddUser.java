package testcases.orangeHRM;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
    @BeforeClass
    public void prerequisites() throws Exception
    {
        sheetName="OrangeHRM_AddUser";
        wbk= ExcelUtils.setExcelFilePath();
        row=ExcelUtils.getRowNumber("TC03-01",sheetName);
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
}

