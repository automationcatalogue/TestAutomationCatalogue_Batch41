package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

import static utilities.Config.browserName;

public class TC10_DemoWebShop_CreateAddress extends TestRunner {
    static XSSFWorkbook wbk;
    ;
    static String sheetName, UserName, Password, LastName, Email, Company, FirstName,
            City, Address1, Address2, ZipPostalCode, PhoneNumber, FaxNumber;
    static int rowNum, row_index;
    static WebDriver driver;
    static Logger log = LogManager.getLogger(TC10_DemoWebShop_CreateAddress.class);
    static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.CreateAddressRequestTestCase_ID) String testID) throws Exception {
        logger = extent.createTest("DemoWebShop_CreateAddress" + testID);
        Log.startTestCase(TC10_DemoWebShop_CreateAddress.class.getName());
        sheetName = "DemoWebshop_CreateAddress";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        row_index = ExcelUtils.getRowNumber(testID, "Index");
        UserName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        Password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        // FirstName = RandomGenerator.getRandomData("firstName");
        FirstName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_FirstName);
        // LastName = RandomGenerator.getRandomData("lastName");
        LastName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_LastName);
        //Email = RandomGenerator.getRandomEmail(8);
        Email = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_Email);
        //Company = RandomGenerator.getRandomData("company");
        Company = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_Company);
        //City = RandomGenerator.getRandomData("city");
        City = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_City);
        // Address1 = RandomGenerator.getRandomData("address1");
        Address1 = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_Address1);
        //Address2 = RandomGenerator.getRandomData("address2");
        Address2 = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_Address2);
        // ZipPostalCode = RandomGenerator.getRandomData("zipcode");
        ZipPostalCode = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_ZipCode);
        // PhoneNumber = RandomGenerator.getRandomData("phoneNumber");
        PhoneNumber = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_PhoneNumber);
        // FaxNumber = RandomGenerator.getRandomNumeric(8);
        FaxNumber = ExcelUtils.getCellData(sheetName, rowNum, Config.col_createAddress_FaxNumber);
    }

    @Test
    @Parameters({"browserName"})
    public void createAddress(@Optional(Config.browserName) String browserName) throws Exception {
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);
        //launching WebShop Application
        driver.get(Config.demoWebshop_URL);
        log.info("DemoWebShop URL is loaded :" + Config.demoWebshop_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_LoginPage");
        logger.log(Status.INFO, "DemoWebShop Application is loaded" + Config.demoWebshop_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_LoginPage").build());


        DemoWebshop_LoginPage.login(UserName, Password);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_HomePage");
        logger.log(Status.INFO, "DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_HomePage").build());

        DemoWebshop_HomePage.click_mailId();
        log.info("DemoWebShop login mailid clicked");
        DemoWebshop_HomePage.select_AddressLink();
        log.info("DemoWebShop address link clicked");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_AddressPage");
        logger.log(Status.INFO, "DemoWebShop Address page is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_AddressPage").build());

        DemoWebshop_HomePage.createName(FirstName, LastName);
        log.info("DemoWebShop FirstName and LastName details entered");


        DemoWebshop_HomePage.createEmailAndCompany(Email, Company);
        log.info("DemoWebShop Email,Company details entered");

        DemoWebshop_HomePage.createCityAndAddresses(City, Address1, Address2);
        log.info("DemoWebShop City,Address1,Address2 details entered");

        DemoWebshop_HomePage.createContactNumbers(ZipPostalCode, PhoneNumber, FaxNumber);
        log.info("DemoWebShop ipPostalCode, PhoneNumber, FaxNumber details entered");

        DemoWebshop_HomePage.select_AddressLink();
        log.info("DemoWebShop clicked on Address link");

        DemoWebshop_HomePage.verify_Address(FirstName, LastName);
        log.info("DemoWebShop verified home page Address");

        DemoWebshop_HomePage.logOut();
        log.info("DemoWebShop application logout");

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(FirstName, sheetName, rowNum, Config.col_createAddress_FirstName);
            ExcelUtils.setCellData(LastName, sheetName, rowNum, Config.col_createAddress_LastName);
            ExcelUtils.setCellData(Email, sheetName, rowNum, Config.col_createAddress_Email);
            ExcelUtils.setCellData(Company, sheetName, rowNum, Config.col_createAddress_Company);
            ExcelUtils.setCellData(City, sheetName, rowNum, Config.col_createAddress_City);
            ExcelUtils.setCellData(Address1, sheetName, rowNum, Config.col_createAddress_Address1);
            ExcelUtils.setCellData(Address2, sheetName, rowNum, Config.col_createAddress_Address2);
            ExcelUtils.setCellData(ZipPostalCode, sheetName, rowNum, Config.col_createAddress_ZipCode);
            ExcelUtils.setCellData(PhoneNumber, sheetName, rowNum, Config.col_createAddress_PhoneNumber);
            ExcelUtils.setCellData(FaxNumber, sheetName, rowNum, Config.col_createAddress_FaxNumber);

            ExcelUtils.setCellData("PASSED", "Index", row_index, Config.col_Status);

            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", row_index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", row_index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", row_index, Config.col_Status);

            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        driver.quit();
        Log.endTestCase();
    }
}
