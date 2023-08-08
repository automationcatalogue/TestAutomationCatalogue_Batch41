package testcases.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import utilities.ExcelUtils;
import utilities.Log;


import java.io.FileInputStream;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
public class TC04_OrangeHRM_EditEmployee {
    String projectPath;
    FileInputStream fis;
    XSSFWorkbook wbk;
    XSSFSheet ws;
    XSSFRow row;
    XSSFCell userName_cell;String userName;
    XSSFCell passWord_cell;String passWord;
    XSSFCell lastName_Cell;String lastName;
    XSSFCell DateOfBirth_Cell;String DateOfBirth;
    XSSFCell nationality_Cell;String nationality;
    XSSFCell allergies_Cell;String allergies;
    XSSFCell dietaryRequire1_Cell;String dietaryRequire1;
    XSSFCell dietaryRequire2_Cell;String dietaryRequire2;
    static Logger log = LogManager.getLogger(TC04_OrangeHRM_EditEmployee.class);
    @BeforeClass
    public void prerequisite_Setup() throws Exception{
        Log.startTestCase(TC04_OrangeHRM_EditEmployee.class.getName());
        wbk= ExcelUtils.setExcelFilePath();
        ws = wbk.getSheet("OrangeHRM_EditEmployee");
        row = ws.getRow(1);
        userName_cell = row.getCell(3);
        userName=userName_cell.getStringCellValue();
        passWord_cell = row.getCell(4);
        passWord = passWord_cell.getStringCellValue();
        lastName_Cell = row.getCell(5);
        lastName = lastName_Cell.getStringCellValue();
        DateOfBirth_Cell = row.getCell(6);
        DateOfBirth = DateOfBirth_Cell.getStringCellValue();
        nationality_Cell = row.getCell(7);
        nationality = nationality_Cell.getStringCellValue();
        allergies_Cell = row.getCell(8);
        allergies = allergies_Cell.getStringCellValue();
        dietaryRequire1_Cell = row.getCell(9);
        dietaryRequire1 = dietaryRequire1_Cell.getStringCellValue();
        dietaryRequire2_Cell = row.getCell(10);
        dietaryRequire2 = dietaryRequire2_Cell.getStringCellValue();


    }
   @Test
   @Parameters({"browserName"})
    public void EditEmployee(@Optional("chrome") String browserName) throws Exception{
       WebDriver driver =CommonUtils.browserLaunch(browserName);
       BaseClass ob = new BaseClass(driver);

       JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        log.info("OrangeHRM website is launched");

        OrangeHRM_LoginPage.login(userName,passWord);

        //title verification
        String title = driver.getTitle();
        String ExpectedTitle = "Employee Management";
        if(title.equalsIgnoreCase(ExpectedTitle)){
            log.info("Login is Successful");
        }else{
            log.info("Login is Unsuccessful");
        }

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        log.info("Employee Management is selected");

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_FirstEmployee).click();
       log.info("Click on First Employee Data");

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_PersonalDetails).click();
       log.info("Clicked on Personal Details tab");

        driver.findElement(OrangeHRM_EditEmployeePage.txtBox_LastName).clear();
       log.info("Cleared the last name");

        driver.findElement(OrangeHRM_EditEmployeePage.txtBox_LastName).sendKeys(lastName);
       log.info("Updated the last name");

        driver.findElement(OrangeHRM_EditEmployeePage.link_DateOfBirthIcon).click();
       log.info("Date picker icon is clicked");

        String date = DateOfBirth;
        String date_Array[]=date.split("-");
        String day=date_Array[0];
        String month=date_Array[1];
        String year=date_Array[2];

        //month selector
        driver.findElement(OrangeHRM_EditEmployeePage.monthDropDown_DateOfBirth).click();
        CommonUtils.selectDropdownValue(OrangeHRM_EditEmployeePage.monthsList_DateOfBirth, month);

        //year selector
        driver.findElement(OrangeHRM_EditEmployeePage.yearDropDown_DateOfBirth).click();
        CommonUtils.selectDropdownValue(OrangeHRM_EditEmployeePage.yearsList_DateOfBirth, year);

        //date selector
        CommonUtils.selectDropdownValue(OrangeHRM_EditEmployeePage.datesList_DateOfBirth, day);
        driver.findElement(OrangeHRM_EditEmployeePage.dropDown_Nationality).click();

        if(nationality=="India") {
            driver.findElement(OrangeHRM_EditEmployeePage.txt_IndiaDropDown).click();
            log.info("Nationality selected as Indian");
        }else {
            log.info("Nationality is not Found");
        }
        driver.findElement(OrangeHRM_EditEmployeePage.btn_FirstSave).click();
       log.info("Clicked on first save button");

        Boolean isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_EditEmployeePage.form,"Successfully Updated"));
        if(isSuccessful){
            log.info("Successfully Updated");
        }else {
            log.info("Not Successful");
        }

        if(allergies=="No") {
            driver.findElement(OrangeHRM_EditEmployeePage.radioBtn_NoAllergies).click();
            log.info("Radio Button for NO is selected");
        }else {
            log.info("Allergies radio Button is not clicked");
        }
        driver.findElement(OrangeHRM_EditEmployeePage.btn_SecondSave).click();
       log.info("Clicked on Hygiene save button");

        Boolean hygiene_isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_EditEmployeePage.form,"Successfully Updated"));
        if(hygiene_isSuccessful){
            log.info("Hygiene is Successfully Updated");
        }else {
            log.info("Hygiene is not Successful Updated");
        }

        if(dietaryRequire1=="Koshler") {
            for (int i = 1; i <= 3; ++i) {
                try {
                    Thread.sleep(1000);
                    driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Kosher).click();
                    log.info("Dietary Requirements check-box Koshler is clicked");
                    break;
                } catch (StaleElementReferenceException se) {
                    log.info("Stale Element Reference Exception is occurred for " + i + " time");
                }
            }
        } else if (dietaryRequire1=="Vegetarian") {
            for (int i = 1; i <= 3; ++i) {
                try {
                    driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Vegetarian).click();
                    log.info("Dietary Requirements check-box Vegeterian is clicked");
                    break;
                } catch (StaleElementReferenceException se) {
                    log.info("Stale Element Reference Exception is occurred for " + i + " time");
                }
            }
        }else {
            log.info("Dietary Requirements (1) are not available ");
        }

       if(dietaryRequire2=="Koshler") {
           for (int i = 1; i <= 3; ++i) {
               try {
                   Thread.sleep(1000);
                   driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Kosher).click();
                   log.info("Dietary Requirements check-box Koshler is clicked");
                   break;
               } catch (StaleElementReferenceException se) {
                   log.info("Stale Element Reference Exception is occurred for " + i + " time");
               }
           }
       } else if (dietaryRequire2=="Vegetarian") {
           for (int i = 1; i <= 3; ++i) {
               try {
                   driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Vegetarian).click();
                   log.info("Dietary Requirements check-box Vegeterian is clicked");
                   break;
               } catch (StaleElementReferenceException se) {
                   log.info("Stale Element Reference Exception is occurred for " + i + " time");
               }
           }
       }else {
           log.info("Dietary Requirements (2) are not available ");
       }

       log.info("clicked on Kosher and Vegetarian check boxes");

        driver.findElement(OrangeHRM_EditEmployeePage.btn_SecondSave).click();
       log.info("Clicked on Dietary Requirements save button");

        Boolean Dietary_isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_EditEmployeePage.form,"Successfully Updated"));

        if(Dietary_isSuccessful){
            log.info("Dietary Requirements are successfully Updated");
        }else {
            log.info("Dietary Requirements are not successfully Updated");
        }

        //Logout
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
       log.info("Clicked on Log out Button");

        driver.quit();
       log.info("browser is closed");
    }

}























