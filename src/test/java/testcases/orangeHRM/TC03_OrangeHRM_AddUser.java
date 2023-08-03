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
import utilities.BaseClass;
import utilities.CommonUtils;
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
    XSSFCell confirm_Pwd_cell; String confirm_pwd;
    XSSFCell newPassword_cell; String newPassword;
    @BeforeClass
    public void prerequisites() throws Exception
    {
        Projectpath=System.getProperty("user.dir");
         fis=new FileInputStream(Projectpath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk=new XSSFWorkbook(fis);
      ws= wbk.getSheet("OrangeHRM_AddUser");
      row=ws.getRow(1);
      username_cell=row.getCell(3);
      userName_1=username_cell.getStringCellValue(); //
       password_cell=row.getCell(4);
       password=password_cell.getStringCellValue();
       empName_cell= row.getCell(5);
       empName=empName_cell.getStringCellValue();
       username_AddUser= row.getCell(6);
       addUser=username_AddUser.getStringCellValue();
       newPassword_cell=row.getCell(7);
       newPassword=newPassword_cell.getStringCellValue();
        confirm_Pwd_cell=row.getCell(8);
        confirm_pwd=confirm_Pwd_cell.getStringCellValue();
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

