package testcases.orangeHRM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.OrangeHRM_AddEmployeePage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import pages.OrangeHRM_LogoutPage;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;


public class TC02_OrangeHRM_AddEmployee {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sht;
    static XSSFRow row;
    static XSSFCell username_cell, password_cell, newPassword_cell, firstName_cell, lastName_cell, location_cell, maritalStatus_cell, gender_cell, region_cell, fte_cell, tempdept_cell;
    static String userName, pswd, newPassword, firstName, lastName, location, marital_Status, gender, region, fte, temp_dept;
    static String projectPath;
    static FileOutputStream  fos;
    static String empid;

    @BeforeClass
    public void prerequisite_setup() throws Exception {
        wbk= ExcelUtils.setExcelFilePath();
        String sheetName = "OrangeHRM_AddEmployee";
        int rowNum = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
        userName = ExcelUtils.getCellData(sheetName,rowNum, Config.col_UserName);
        pswd = ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        firstName = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_FirstName);
        lastName = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_LastName);
        location = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_Location);
        marital_Status = ExcelUtils.getCellData(sheetName,rowNum, Config.col_AddEmployee_MaritalStatus);
        gender = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_Gender);
        region = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_Region);
        fte = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_FTE);
        temp_dept = ExcelUtils.getCellData(sheetName,rowNum,Config.col_AddEmployee_TempDepartment);

    }
    @Test
    @Parameters({"browserName"})
    public void addEmployee(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch("Chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        String title = driver.getTitle();
        System.out.println("Title of the page is:" + title);

        OrangeHRM_LoginPage.login(userName, pswd);
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_AddEmployeePage.enterFirstNameAndLastName(firstName,lastName);
        OrangeHRM_AddEmployeePage.selectLocation(location);
        OrangeHRM_AddEmployeePage.selectMaritalStatus(marital_Status);
        OrangeHRM_AddEmployeePage.selectGender(gender);
        OrangeHRM_AddEmployeePage.selectRegion(region);
        OrangeHRM_AddEmployeePage.selectFTE(fte);
        OrangeHRM_AddEmployeePage.selectTempDept(temp_dept);
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_AddEmployeePage.searchEmployee(firstName,lastName);
        OrangeHRM_AddEmployeePage.verifyEmployeeId_name(firstName,lastName);
        OrangeHRM_LogoutPage.logout();
        driver.quit();

    }

    @AfterClass
    public void teardown() throws Exception{
        try{
        Row rowToUpdate = sht.getRow(1);
        Cell resultCell = rowToUpdate.createCell(13);
        resultCell.setCellValue(empid);
            FileOutputStream fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
            wbk.write(fos);
            System.out.println(empid+" is written back to the Excel file");
            fos.close();
            System.out.println("ExcelFile Writing is closed");
            fis.close();
            System.out.println("ExcelFile reading is closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
