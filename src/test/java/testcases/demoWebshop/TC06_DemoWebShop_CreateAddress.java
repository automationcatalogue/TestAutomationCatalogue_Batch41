package testcases.demoWebshop;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.demoWebshop.DemoWebShop_AddressesPage;
import pages.demoWebshop.DemoWebShop_HomePage;
import pages.demoWebshop.DemoWebShop_LoginPage;
import testcases.setup.TestRunner;
import utilities.*;

public class TC06_DemoWebShop_CreateAddress extends TestRunner {

    static String sheetName, userName, password, lastName, email, company, firstName,
            city, state, address1, address2, zipPostalCode, phoneNumber, faxNumber;
    static int rowNum, row_index;
    static WebDriver driver;
    static Logger log = LogManager.getLogger(TC06_DemoWebShop_CreateAddress.class);
    static String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_setup(@Optional(Config.CreateAddressRequestTestCase_ID) String testID) throws Exception {
        logger = extent.createTest(testID + "_DemoWebShop_CreateAddress");
        Log.startTestCase(TC06_DemoWebShop_CreateAddress.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        row_index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(row_index + "Row Number is picked from Index Sheet");
        sheetName = "DemoWebshop_CreateAddress";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        log.info("Password from excel sheet is :" + password);
        firstName = RandomGenerator.getRandomData("firstName");
        log.info("Random Generated first name is " + firstName);
        lastName = RandomGenerator.getRandomData("lastName");
        log.info("Random Generated last name is " + lastName);
        email = RandomGenerator.getRandomEmail(8);
        log.info("Random Generated email is " + email);
        company = RandomGenerator.getRandomData("company");
        log.info("Random Generated email is " + company);
        city = RandomGenerator.getRandomData("city");
        log.info("Random Generated city is " + city);
        address1 = RandomGenerator.getRandomData("address1");
        log.info("Random Generated address1 is " + address1);
        address2 = RandomGenerator.getRandomData("address2");
        log.info("Random Generated address2 is " + address2);
        zipPostalCode = RandomGenerator.getRandomData("zipcode");
        log.info("Random Generated Zip PostalCode is " + zipPostalCode);
        phoneNumber = RandomGenerator.getRandomData("phoneNumber");
        log.info("Random Generated Phone Number is " + phoneNumber);
        faxNumber = RandomGenerator.getRandomNumeric(8);
        log.info("Random Generated Fax Number is " + faxNumber);
    }

    @Test
    @Parameters({"browserName"})
    public void createAddress(@Optional(Config.browserName) String browserName) throws Exception {
        //Browser Launch
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        //launching WebShop Application
        driver.get(Config.demoWebshop_URL);
        log.info("DemoWebShop URL is loaded :" + Config.demoWebshop_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_LoginPage");
        logger.log(Status.INFO, "DemoWebShop Application is loaded" + Config.demoWebshop_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_LoginPage").build());

        DemoWebShop_LoginPage.login(userName, password);
        log.info("DemoWebShop Login is Successful");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_HomePage");
        logger.log(Status.INFO, "DemoWebShop Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_HomePage").build());

        DemoWebShop_HomePage.openMyAccount();
        log.info("DemoWebShop My Account Addresses Page is Opened");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_AddressPage");
        logger.log(Status.INFO, "DemoWebShop My Account Addresses Page is Opened", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_AddressPage").build());

        DemoWebShop_AddressesPage.createAddress(firstName, lastName, email, company, city, address1, address2, zipPostalCode, phoneNumber, faxNumber);
        log.info("DemoWebShop New Address is Created");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_NewAddressPage");
        logger.log(Status.INFO, "DemoWebShop New Address is Created", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_NewAddressPage").build());

        DemoWebShop_AddressesPage.verifyAddress(firstName, lastName);
        log.info("DemoWebShop New Address is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "DemoWebShop_VerifyAddressPage");
        logger.log(Status.INFO, "DemoWebShop New Address is Verified", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "DemoWebShop_NewAddressPage").build());

        DemoWebShop_HomePage.logOut();
        log.info("DemoWebShop application logout");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(firstName, sheetName, rowNum, Config.col_createAddress_FirstName);
            log.info(firstName + "is updated in Excel sheet as firstName");
            ExcelUtils.setCellData(lastName, sheetName, rowNum, Config.col_createAddress_LastName);
            log.info(lastName + "is updated in Excel sheet as lastName");
            ExcelUtils.setCellData(email, sheetName, rowNum, Config.col_createAddress_Email);
            log.info(email + "is updated in Excel sheet as Email");
            ExcelUtils.setCellData(company, sheetName, rowNum, Config.col_createAddress_Company);
            log.info(company + "is updated in Excel sheet as Company");
            ExcelUtils.setCellData(DemoWebShop_AddressesPage.randomCountryName, sheetName, rowNum, Config.col_createAddress_Country);
            log.info(DemoWebShop_AddressesPage.randomCountryName + "is updated in Excel sheet as Country");
            ExcelUtils.setCellData(DemoWebShop_AddressesPage.randomStateName, sheetName, rowNum, Config.col_createAddress_State);
            log.info(DemoWebShop_AddressesPage.randomStateName + "is updated in Excel sheet as State");
            ExcelUtils.setCellData(city, sheetName, rowNum, Config.col_createAddress_City);
            log.info(city + "is updated in Excel sheet as City");
            ExcelUtils.setCellData(address1, sheetName, rowNum, Config.col_createAddress_Address1);
            log.info(address1 + "is updated in Excel sheet as Address1");
            ExcelUtils.setCellData(address2, sheetName, rowNum, Config.col_createAddress_Address2);
            log.info(address2 + "is updated in Excel sheet as Address2");
            ExcelUtils.setCellData(zipPostalCode, sheetName, rowNum, Config.col_createAddress_ZipCode);
            log.info(zipPostalCode + "is updated in Excel sheet as Zip Code");
            ExcelUtils.setCellData(phoneNumber, sheetName, rowNum, Config.col_createAddress_PhoneNumber);
            log.info(phoneNumber + "is updated in Excel sheet as PhoneNumber");
            ExcelUtils.setCellData(faxNumber, sheetName, rowNum, Config.col_createAddress_FaxNumber);
            log.info(faxNumber + "is updated in Excel sheet as FaxNumber");
            ExcelUtils.setCellData("PASSED", "Index", row_index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
            logger.log(Status.PASS, "DemoWebShop Create Address TestCase is Passed and status is updated in Excel sheet");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")) {
                ExcelUtils.setCellData("FAILED", "Index", row_index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason, "Index", row_index, Config.col_reason);
                log.info("Failure Reason is :" + BaseClass.failureReason + " and status is updated in Excel sheet");
                logger.log(Status.FAIL, "DemoWebShop Create Address TestCase is Failed and status is updated in Excel sheet");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExcelUtils.setCellData("SKIPPED", "Index", row_index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
            logger.log(Status.SKIP, "DemoWebShop Create Address TestCase is Skipped and status is updated in Excel sheet");
        }
        driver.quit();
        Log.endTestCase();
    }
}
