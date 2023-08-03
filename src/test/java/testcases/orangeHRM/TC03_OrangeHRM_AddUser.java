package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.ExcelUtils;
import utilities.RandomGenerator;
import java.io.FileInputStream;
import java.time.Duration;

public class TC03_OrangeHRM_AddUser {


    String Projectpath;
    FileInputStream  fis;
    XSSFWorkbook wbk;
    XSSFSheet  ws;
    XSSFRow row;
    XSSFCell username_cell; String userName_1;
    XSSFCell password_cell; String password;
    XSSFCell empName_cell; String empName;
    XSSFCell username_AddUser; String addUser;

    @BeforeClass
    public void prerequisites() throws Exception
    {
      wbk= ExcelUtils.setExcelFilePath();
      ws= wbk.getSheet("OrangeHRM_AddUser");
      row=ws.getRow(1);
      username_cell=row.getCell(3);
      userName_1=username_cell.getStringCellValue();
       password_cell=row.getCell(4);
       password=password_cell.getStringCellValue();
       empName_cell= row.getCell(5);
       empName=empName_cell.getStringCellValue();
       username_AddUser= row.getCell(6);
       addUser=username_AddUser.getStringCellValue();


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
        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OrangHRM_AddUserPage.empName_Visibility));
        //Click on + (Add User) Icon
        driver.findElement(OrangHRM_AddUserPage.icon_AddUser).click();

        //Enter Employee Name as Charlie Carter
        driver.findElement(OrangHRM_AddUserPage.txtbx_EmployeeName).sendKeys(empName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrangHRM_AddUserPage.empName_DropdownVisibility));
        driver.findElement(OrangHRM_AddUserPage.empName_DropdownVisibility).click();

        //Enter some Random UserName
        driver.findElement(OrangHRM_AddUserPage.txtbx_RandomUserName).sendKeys(userName);

        //Enter the Password as "Admin@123"
        driver.findElement(OrangHRM_AddUserPage.txtbx_Pwd).sendKeys(password);

        //Enter the Confirm Password as "Admin@123"
        driver.findElement(OrangHRM_AddUserPage.txtbx_ConfirmPwd).sendKeys(password);

        //Click on Save button
        WebElement element_SaveBtn =  driver.findElement(OrangHRM_AddUserPage.btn_Save);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element_SaveBtn);

        //Click on Logout button
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();

        //Enter the UserName as "Charlie"
        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(userName);

        //Enter the Password as "Admin@123"
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(password);

        //Click on Login button
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();

        //Verify the Employee Name as Charlie Carter
        String Employee_Name=driver.findElement(OrangeHRM_HomePage.lbl_ProfileName).getText();
        String expected_name=empName;
        if(Employee_Name.equalsIgnoreCase(expected_name)){
            System.out.println("UserName is matched and verified");
        }else {
            System.out.println("UserName is not matched");
        }

        //Click on Logout button
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();

        driver.quit();
    }
}

