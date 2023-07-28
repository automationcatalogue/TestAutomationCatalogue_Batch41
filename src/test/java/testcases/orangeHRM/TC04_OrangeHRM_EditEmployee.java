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
import utilities.CommonUtils;


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
    @BeforeClass
    public void prerequisite_Setup() throws Exception{
        projectPath=System.getProperty("user.dir");
        fis = new FileInputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk = new XSSFWorkbook(fis);
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

       JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");


        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(userName);
        System.out.println("Admin is entered as a UserName");

        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(passWord);
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Login button is clicked");

        //title verification
        String title = driver.getTitle();
        String ExpectedTitle = "Employee Management";
        if(title.equalsIgnoreCase(ExpectedTitle)){
            System.out.println("Login is Successful");
        }else{
            System.out.println("Login is Unsuccessful");
        }

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management is selected");

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_FirstEmployee).click();
        System.out.println("Click on First Employee Data");

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_PersonalDetails).click();
        System.out.println("Clicked on Personal Details tab");

        driver.findElement(OrangeHRM_EditEmployeePage.txtBox_LastName).clear();
        System.out.println("Cleared the last name");

        driver.findElement(OrangeHRM_EditEmployeePage.txtBox_LastName).sendKeys(lastName);
        System.out.println("Updated the last name");

        driver.findElement(OrangeHRM_EditEmployeePage.link_DateOfBirthIcon).click();
        System.out.println("Date picker icon is clicked");

        String date = DateOfBirth;
        String date_Array[]=date.split("-");
        String day=date_Array[0];
        String month=date_Array[1];
        String year=date_Array[2];

        //month selector
        driver.findElement(OrangeHRM_EditEmployeePage.monthDropDown_DateOfBirth).click();
        Thread.sleep(5000);
        List<WebElement> list_month = driver.findElements(OrangeHRM_EditEmployeePage.monthsList_DateOfBirth);
        for (WebElement mon:list_month)
        {
            String ActualMonth = mon.getText();
            if (ActualMonth.equalsIgnoreCase(month)){
                mon.click();
                System.out.println("selected"+month);
                break;
            }
        }

        //year selector
        driver.findElement(OrangeHRM_EditEmployeePage.yearDropDown_DateOfBirth).click();
        //Thread.sleep(10000);
        List<WebElement> list_years = driver.findElements(OrangeHRM_EditEmployeePage.yearsList_DateOfBirth);
        for( WebElement year_1:list_years )
        {
            String ActualYear =year_1.getText();
            if(ActualYear.equalsIgnoreCase(year)){
                year_1.click();
                System.out.println("Selected the year as "+year);
                break;
            }
        }

        //date selector
        //Thread.sleep(2000);
        List<WebElement> list_date = driver.findElements(OrangeHRM_EditEmployeePage.datesList_DateOfBirth);
        for(WebElement dt:list_date)
        {   String ActualDate = dt.getText();
            if(ActualDate.equalsIgnoreCase(day)){
                dt.click();
                System.out.println("date is selected as"+day);
                break;
            }
        }
        driver.findElement(OrangeHRM_EditEmployeePage.dropDown_Nationality).click();

        if(nationality=="India") {
            driver.findElement(OrangeHRM_EditEmployeePage.txt_IndiaDropDown).click();
            System.out.println("Nationality selected as Indian");
        }else {
            System.out.println("Nationality is not Found");
        }
        driver.findElement(OrangeHRM_EditEmployeePage.btn_FirstSave).click();
        System.out.println("Clicked on first save button");

        Boolean isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_EditEmployeePage.form,"Successfully Updated"));
        if(isSuccessful){
            System.out.println("Successfully Updated");
        }else {
            System.out.println("Not Successful");
        }

        if(allergies=="No") {
            driver.findElement(OrangeHRM_EditEmployeePage.radioBtn_NoAllergies).click();
            System.out.println("Radio Button for NO is selected");
        }else {
            System.out.println("Allergies radio Button is not clicked");
        }
        driver.findElement(OrangeHRM_EditEmployeePage.btn_SecondSave).click();
        System.out.println("Clicked on Hygiene save button");

        Boolean hygiene_isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_EditEmployeePage.form,"Successfully Updated"));
        if(hygiene_isSuccessful){
            System.out.println("Hygiene is Successfully Updated");
        }else {
            System.out.println("Hygiene is not Successful Updated");
        }

        if(dietaryRequire1=="Koshler") {
            for (int i = 1; i <= 3; ++i) {
                try {
                    Thread.sleep(1000);
                    driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Kosher).click();
                    System.out.println("Dietary Requirements check-box Koshler is clicked");
                    break;
                } catch (StaleElementReferenceException se) {
                    System.out.println("Stale Element Reference Exception is occurred for " + i + " time");
                }
            }
        } else if (dietaryRequire1=="Vegetarian") {
            for (int i = 1; i <= 3; ++i) {
                try {
                    driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Vegetarian).click();
                    System.out.println("Dietary Requirements check-box Vegeterian is clicked");
                    break;
                } catch (StaleElementReferenceException se) {
                    System.out.println("Stale Element Reference Exception is occurred for " + i + " time");
                }
            }
        }else {
            System.out.println("Dietary Requirements (1) are not available ");
        }

       if(dietaryRequire2=="Koshler") {
           for (int i = 1; i <= 3; ++i) {
               try {
                   Thread.sleep(1000);
                   driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Kosher).click();
                   System.out.println("Dietary Requirements check-box Koshler is clicked");
                   break;
               } catch (StaleElementReferenceException se) {
                   System.out.println("Stale Element Reference Exception is occurred for " + i + " time");
               }
           }
       } else if (dietaryRequire2=="Vegetarian") {
           for (int i = 1; i <= 3; ++i) {
               try {
                   driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Vegetarian).click();
                   System.out.println("Dietary Requirements check-box Vegeterian is clicked");
                   break;
               } catch (StaleElementReferenceException se) {
                   System.out.println("Stale Element Reference Exception is occurred for " + i + " time");
               }
           }
       }else {
           System.out.println("Dietary Requirements (2) are not available ");
       }

        System.out.println("clicked on Kosher and Vegetarian check boxes");

        driver.findElement(OrangeHRM_EditEmployeePage.btn_SecondSave).click();
        System.out.println("Clicked on Dietary Requirements save button");

        Boolean Dietary_isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_EditEmployeePage.form,"Successfully Updated"));

        if(Dietary_isSuccessful){
            System.out.println("Dietary Requirements are successfully Updated");
        }else {
            System.out.println("Dietary Requirements are not successfully Updated");
        }

        //Logout
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Clicked on Log out Button");

        driver.quit();
        System.out.println("browser is closed");
    }

}























