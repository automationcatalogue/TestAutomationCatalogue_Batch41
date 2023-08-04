package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;


import java.io.FileInputStream;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
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
    String sheetName; int row;
    @BeforeClass
    public void prerequisite_Setup() throws Exception{
        sheetName ="OrangeHRM_EditEmployee";
        wbk= ExcelUtils.setExcelFilePath();
        row = ExcelUtils.getRowNumber("TC04-01",sheetName);
        userName = ExcelUtils.getCellData(sheetName,row, Config.col_UserName);
        passWord = ExcelUtils.getCellData(sheetName,row,Config.col_Password);
        lastName = ExcelUtils.getCellData(sheetName,row,Config.col_EditEmployee_LastName);
        DateOfBirth = ExcelUtils.getCellData(sheetName,row,Config.col_EditEmployee_DOB);
        nationality = ExcelUtils.getCellData(sheetName,row,Config.col_EditEmployee_Nationality);
        allergies = ExcelUtils.getCellData(sheetName,row,Config.col_EditEmployee_Allergies);
        dietaryRequire1 = ExcelUtils.getCellData(sheetName,row,Config.col_EditEmployee_DietaryRequirement_1);
        dietaryRequire2 = ExcelUtils.getCellData(sheetName,row,Config.col_EditEmployee_DietaryRequirement_2);


    }
   @Test
   @Parameters({"browserName"})
    public void EditEmployee(@Optional("chrome") String browserName) throws Exception{
       WebDriver driver =CommonUtils.browserLaunch(browserName);
       BaseClass ob = new BaseClass(driver);

       JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        OrangeHRM_LoginPage.login(userName,passWord);
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_EmployeeManagementPage.personalDetails_firstEmployee();
        OrangeHRM_EditEmployeePage.enterLastName(lastName);
        OrangeHRM_EditEmployeePage.Selection_DateOfBirth(DateOfBirth);
        OrangeHRM_EditEmployeePage.select_Nationality(nationality);
        OrangeHRM_EditEmployeePage.firstSave();
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Data");
        OrangeHRM_EditEmployeePage.select_Allergies(allergies);
        OrangeHRM_EditEmployeePage.secondSave();
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Hygiene");
        OrangeHRM_EditEmployeePage.select_diet(dietaryRequire1);
        OrangeHRM_EditEmployeePage.select_diet(dietaryRequire2);
        OrangeHRM_EditEmployeePage.thirdSave();
        OrangeHRM_EditEmployeePage.verify_SuccessfullyUpdated("Dietary Requirement");
        OrangeHRM_LogoutPage.logout();
        driver.quit();
        System.out.println("browser is closed");
    }

}























