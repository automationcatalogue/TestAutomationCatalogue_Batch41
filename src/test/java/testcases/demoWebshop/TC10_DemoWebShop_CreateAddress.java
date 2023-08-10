package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebshop_AddressesPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import utilities.*;

import java.io.FileInputStream;
import java.util.List;

public class TC10_DemoWebShop_CreateAddress {
    static XSSFWorkbook wbk; static String sheetName;
    static String UserName; static String Password;
    static String FirstName; static String LastName;
    static String Email; static String Company;
    static String City; static String Address1;static String Address2;
    static String ZipPostalCode;static String PhoneNumber;static String FaxNumber;
    static int rowNum; static int row_index;

    @Parameters("{testID}")
    @BeforeClass
    public void prerequisite_setup(@Optional(Config.TestCase_ID) String testID) throws Exception {
        wbk = ExcelUtils.setExcelFilePath();
        sheetName = "DemoWebshop_CreateAddress";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        row_index = ExcelUtils.getRowNumber(testID,"Index");
        UserName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        Password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        FirstName = RandomGenerator.getRandomData("firstName");
        LastName = RandomGenerator.getRandomData("lastName");
        Email = RandomGenerator.getRandomEmail(8);
        Company = RandomGenerator.getRandomData("company");
        City = RandomGenerator.getRandomData("city");
        Address1 = RandomGenerator.getRandomData("address1");
        Address2 = RandomGenerator.getRandomData("address2");
        ZipPostalCode = RandomGenerator.getRandomData("zipcode");
        PhoneNumber = RandomGenerator.getRandomData("phoneNumber");
        FaxNumber = RandomGenerator.getRandomNumeric(8);
    }
    @Test
    @Parameters({"browserName"})
    public void login(@Optional("chrome") String browserName) throws Exception {
        WebDriver driver = CommonUtils.browserLaunch(browserName);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebShop Website is launched");

        DemoWebshop_LoginPage.login(UserName,Password);

        DemoWebshop_HomePage.click_mailId();

        DemoWebshop_HomePage.select_AddressLink();

        DemoWebshop_HomePage.createName(FirstName,LastName);

        DemoWebshop_HomePage.createEmailAndCompany(Email,Company);

        DemoWebshop_HomePage.createCityAndAddresses(City,Address1,Address2);

        DemoWebshop_HomePage.createContactNumbers(ZipPostalCode, PhoneNumber, FaxNumber);

        DemoWebshop_HomePage.select_AddressLink();

        DemoWebshop_HomePage.verify_Address(FirstName,LastName);

        DemoWebshop_HomePage.logOut();

        Thread.sleep(6000);

        driver.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(FirstName, sheetName,rowNum, Config.col_createAddress_FirstName);
            ExcelUtils.setCellData(LastName,sheetName,rowNum, Config.col_createAddress_LastName);
            ExcelUtils.setCellData(Email, sheetName, rowNum, Config.col_createAddress_Email);
            ExcelUtils.setCellData(Company, sheetName, rowNum, Config.col_createAddress_Company);
            ExcelUtils.setCellData(City,sheetName,rowNum, Config.col_createAddress_City);
            ExcelUtils.setCellData(Address1,sheetName,rowNum, Config.col_createAddress_Address1);
            ExcelUtils.setCellData(Address2,sheetName,rowNum, Config.col_createAddress_Address2);
            ExcelUtils.setCellData(ZipPostalCode,sheetName,rowNum, Config.col_createAddress_ZipCode);
            ExcelUtils.setCellData(PhoneNumber,sheetName,rowNum, Config.col_createAddress_PhoneNumber);
            ExcelUtils.setCellData(FaxNumber,sheetName,rowNum, Config.col_createAddress_FaxNumber);

            ExcelUtils.setCellData("PASSED", "Index",row_index, Config.col_Status);
            System.out.println("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index",row_index, Config.col_Status);
                System.out.println("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",row_index,Config.col_reason);
                System.out.println("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index",row_index, Config.col_Status);
            System.out.println("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        ExcelUtils.closeExcelFile();
    }
}
