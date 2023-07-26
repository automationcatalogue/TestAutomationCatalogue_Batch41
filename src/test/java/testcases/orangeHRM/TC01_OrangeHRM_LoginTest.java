package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import pages.OrangeHRM_LoginPage;
import utilities.CommonUtils;

import java.io.FileInputStream;
import java.time.Duration;

public class TC01_OrangeHRM_LoginTest {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;

    @BeforeClass
    public void prerequisite_setup() throws Exception{
        fis = new FileInputStream("C:\\AutomationCatalogue\\Projects\\TestAutomationCatalogue_Batch41\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk = new XSSFWorkbook(fis);
        sh = wbk.getSheet("OrangeHRM_Login");
        row = sh.getRow(1);

        cell_userName = row.getCell(3);
        userName = cell_userName.getStringCellValue();
        System.out.println("UserName from excel sheet is :"+userName);

        cell_password = row.getCell(4);
        password =cell_password.getStringCellValue();
        System.out.println("Password from excel sheet is:"+password);

    }

    @Test
    @Parameters({"browserName"})
    public static void login(@Optional("chrome") String browserName) throws Exception{

        WebDriver driver = CommonUtils.browserLaunch(browserName);

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(userName);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(password);
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();

        Thread.sleep(6000);

        driver.quit();
    }

    @AfterClass
    public void tearDown() throws Exception{
        fis.close();
        System.out.println("ExcelFile reading is closed");
    }
}
