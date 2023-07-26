package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OrangeHRM_AddEmployeePage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import pages.OrangeHRM_LogoutPage;
import utilities.CommonUtils;


import java.io.FileInputStream;
import java.time.Duration;


public class TC02_OrangeHRM_AddEmployee {

    FileInputStream fis;
    XSSFWorkbook wbk;
    XSSFSheet sht;
    XSSFRow row;
    XSSFCell username_cell, password_cell, newPassword_cell, firstName_cell, lastName_cell, location_cell, maritalStatus_cell, gender_cell, region_cell, fte_cell, tempdept_cell;
    String userName, pswd, newPassword, firstName, lastName, location, marital_Status, gender, region, fte, temp_dept;

    @BeforeClass
    public void preRequisites() throws Exception {

        fis = new FileInputStream("C:\\Automation Catalogue\\TestAutomationCatalogue_Batch41\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk = new XSSFWorkbook(fis);
        sht = wbk.getSheet("OrangeHRM_AddEmployee");
        row = sht.getRow(4);
        username_cell = row.getCell(3);
        userName = username_cell.getStringCellValue();
        password_cell = row.getCell(4);
        pswd = password_cell.getStringCellValue();
        firstName_cell = row.getCell(5);
        firstName = firstName_cell.getStringCellValue();
        lastName_cell = row.getCell(6);
        lastName = lastName_cell.getStringCellValue();
        location_cell = row.getCell(7);
        location = location_cell.getStringCellValue();
        maritalStatus_cell = row.getCell(8);
        marital_Status = maritalStatus_cell.getStringCellValue();
        gender_cell = row.getCell(9);
        gender = gender_cell.getStringCellValue();
        region_cell = row.getCell(10);
        region = region_cell.getStringCellValue();
        fte_cell = row.getCell(11);
        fte = fte_cell.getStringCellValue();
        tempdept_cell = row.getCell(12);
        temp_dept = tempdept_cell.getStringCellValue();

    }
    @Test
    @Parameters({"browserName"})
    public void addEmployee(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch("Chrome");

        Automation_Ramya
        driver.get("https://seleniumautom-trials710.orangehrmlive.com");

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        master
        System.out.println("OrangeHRM website is launched");

        String title = driver.getTitle();
        System.out.println("Title of the page is:" + title);

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(userName);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(pswd);
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Logged in as Admin");

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.link_add).click();
        System.out.println("Clicked on Add button ");

        driver.findElement(OrangeHRM_AddEmployeePage.txtbx_EmpFirstName).sendKeys(firstName);
        System.out.println("First Name is entered");

        driver.findElement(OrangeHRM_AddEmployeePage.txtbx_EmpLastName).sendKeys(lastName);
        System.out.println("Last Name is entered");

        driver.findElement(OrangeHRM_AddEmployeePage.drpdwn_location).click();
        System.out.println("Location drop-down is clicked ");

        if (location.equals("India Office")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_indiaOption).click();
            System.out.println("India Office value is selected from a drop-down");
        } else if (location.equals("Australia office")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_australiaOption).click();
            System.out.println("Australia office value is selected from a drop-down");
        } else if (location.equals("Australian Regional HQ")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_australiaHQOption).click();
            System.out.println("Australian Regional HQ value is selected from a drop-down");

        } else if (location.equals("Canadian Development Center")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_canadianDevCenteroption).click();
            System.out.println("Canadian Development Center value is selected from a drop-down");
        } else if (location.equals("Jamaica training center")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_jamaica_trainingCenterOption).click();
            System.out.println("Jamaica training center value is selected from a drop-down");

        } else if (location.equals("Kenya Satalite office")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_kenya_Sat_officeOption).click();
            System.out.println("Kenya Satalite office value is selected from a drop-down");
        } else if (location.equals("Mexico Office")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_mexicoOfficeOption).click();
            System.out.println("Mexico Office value is selected from a drop-down");
        } else if (location.equals("Philippine call center")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_philippine_calcenterOption).click();
            System.out.println("Philippine call center value is selected from a drop-down");
        } else if (location.equals("Singapore Regional HQ")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_singaporeregionalHQOption).click();
            System.out.println("Singapore Regional HQ value is selected from a drop-down");
        } else if (location.equals("European Office")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_europeanOfficeOption).click();
            System.out.println("European Office value is selected from a drop-down");
        } else if (location.equals("Sheffield Office")) {
            driver.findElement(OrangeHRM_AddEmployeePage.location_sheffieldOfficeOption).click();
            System.out.println("Sheffield Office value is selected from a drop-down");
        } else if (location.equals("US Office")){
            driver.findElement(OrangeHRM_AddEmployeePage.location_UsofficeOption).click();
            System.out.println("US Office value is selected from a drop-down");
        } else {
            System.out.println("Location not found");
        }

        driver.findElement(OrangeHRM_AddEmployeePage.btn_next).click();
        System.out.println("Next button is clicked");

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_maritalStatus).click();
        System.out.println("Marital Status drop-down is clicked");

        if (marital_Status.equals("Single")) {
            driver.findElement(OrangeHRM_AddEmployeePage.maritalStatus_singleOption).click();
            System.out.println("Single is selected");
        } else if (marital_Status.equals("Married")) {
            driver.findElement(OrangeHRM_AddEmployeePage.maritalstatus_marriedOption).click();
            System.out.println("Married is selected");
        } else if (marital_Status.equals("Other")) {
            driver.findElement(OrangeHRM_AddEmployeePage.maritalstatus_otherOption).click();
            System.out.println("Marital_status is selected as Other");
        } else {
            System.out.println("Marital Status is not found");
        }

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_gender).click();
        System.out.println("Gender drop-down is clicked");

        if (gender.equals("Male")) {
            driver.findElement(OrangeHRM_AddEmployeePage.gender_maleOption).click();
            System.out.println("Male is selected");
        } else if (gender.equals("Female")) {

            driver.findElement(OrangeHRM_AddEmployeePage.gender_femaleOption).click();
            System.out.println("Male is selected");
        } else if (gender.equals("Non-Binary")) {
            driver.findElement(OrangeHRM_AddEmployeePage.gender_nonBinaryOption).click();
            System.out.println("Male is selected");
        } else {
            System.out.println("gender is not found");
        }

        driver.findElement(OrangeHRM_AddEmployeePage.next_btn1).click();
        System.out.println("Clicked on Next");

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_region).click();
        System.out.println("Region drop-down is clicked");
        if (region.equals("Region-1")) {
            driver.findElement(OrangeHRM_AddEmployeePage.region_region1Option).click();
            System.out.println("Region-1 is selected ");
        } else if (region.equals("Region-2")) {
            driver.findElement(OrangeHRM_AddEmployeePage.region_region2Option).click();
            System.out.println("Region-2 is selected ");
        } else if (region.equals("Region-3")) {
            driver.findElement(OrangeHRM_AddEmployeePage.region_region3Option).click();
            System.out.println("Region-3 is selected ");
        } else {
            System.out.println("region is not found");
        }

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_fteOption).click();
        System.out.println("FTE drop-down is clicked");

        if (fte.equals("0.5")) {
            driver.findElement(OrangeHRM_AddEmployeePage.fte_Option1).click();
            System.out.println("0.75 is selected");
        } else if (fte.equals("0.75")){
            driver.findElement(OrangeHRM_AddEmployeePage.fte_option2).click();
            System.out.println("0.75 is selected");
        } else if (fte.equals("1")) {
            driver.findElement(OrangeHRM_AddEmployeePage.fte_option3).click();
            System.out.println("0.75 is selected");
        } else {
            System.out.println("FTE is not found");
        }

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_tempDept).click();
        System.out.println("Temp Department drop-down is clicked");

        if (temp_dept.equals("Sub unit -1")) {
            driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitOneOption).click();
            System.out.println("Sub unit -2 is selected");
        } else if (temp_dept.equals("Sub unit-2")) {
            driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitTwoOption).click();
            System.out.println("Sub unit -2 is selected");
        } else if (temp_dept.equals("Sub unit-3")) {
            driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitThreeOption).click();
            System.out.println("Sub unit -2 is selected");
        } else if (temp_dept.equals("Sub unit-4")) {
            driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitFourOption).click();
            System.out.println("Sub unit -2 is selected");
        } else {
            System.out.println("TempDepartment is not found");
        }

        driver.findElement(OrangeHRM_AddEmployeePage.btn_save).click();
        System.out.println("clicked on Save");

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.search_icon).sendKeys(firstName+" "+ lastName);
        driver.findElement(OrangeHRM_AddEmployeePage.txtbx_searchEmployee).click();
        System.out.println("Searched with Employee first and last name");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchedEmployeeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(OrangeHRM_AddEmployeePage.searched_Employee));
        String elementText = searchedEmployeeElement.getText().trim();
        System.out.println("Element Text is: " + elementText);


        String expectedFullName = firstName + " " + lastName;
        if (elementText.equalsIgnoreCase(expectedFullName)) {
            System.out.println("Search result is correct");
        } else {
            System.out.println("Search result is incorrect");
        }

        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("log out is clicked");

        driver.quit();

    }

}
