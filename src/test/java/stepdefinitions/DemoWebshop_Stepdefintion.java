package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import pages.demoWebshop.*;
import runner.CucumberHooks;
import utilities.*;


public class DemoWebshop_Stepdefintion {
    public static WebDriver driver;
    static XSSFWorkbook wbk;
    static int rowNum, row_index;
    static String UserName;
    static String Password;
    static String ApplyCoupon;
    static String FirstName, LastName, Email, Company;
    static String City, Address1, Address2;
    static String ZipPostalCode, PhoneNumber, FaxNumber;
    static String testID;
    static Logger log = LogManager.getLogger(DemoWebshop_Stepdefintion.class);
    static String userName, password, sheetName;
    static String jewel_Length, update_Qty;
    static int TotalNumberOfOrders, row;
    static float SumOfAllOrders;
    static int rowNum_testCase, rowNum_Index;
    static String text_BookPrice, text_updatedQuty, text_JewelPrice, total_1, total_2, orderNumber;

    @Given("User reads CreateAddress Data from {string} using TestID {string}")
    public void readExcelData_CreateAddress(String sheetName, String testID) throws Exception {
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        row_index = ExcelUtils.getRowNumber(testID, "Index");
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

    @Given("User loads DemoWebshop Application")
    public void user_loads_demo_webshop_application() {
        driver = CommonUtils.browserLaunch(Config.browserName);
        BaseClass ob = new BaseClass(driver);
        driver.get(Config.demoWebshop_URL);
        log.info("DemoWebShop Website is launched");
    }

    @Given("User loads DemoWebshop Application in {string} browser")
    public void loadDemoWebshopApplication(String browserName) {
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass baseClass = new BaseClass(driver);
        driver.get("https://demowebshop.tricentis.com/");
        log.info("Demo website is loaded");
    }

    @Then("User clicks on Login link")
    public void user_clicks_on_Login_link(){
        DemoWebshop_HomePage.clickLoginLink();
    }
    @When("User Login into DemoWebshop Application with UserName as {string} and Password as {string}")
    public void loginDemoWebshop(String userName, String password) {
        DemoWebshop_LoginPage.login(userName, password);
    }



    @And("User Clicks on OrderDetails button")
    public void user_clicks_on_OrderDetails_button() {
        DemoWebShop_OrdersPage.clickFirstOrderDetailsBtn();
    }

    @Then("User Clicks on ReOrder button")
    public void user_clicks_on_orderdetails_button() {
        DemoWebshop_OrderInformationPage.clickReorderBtn();
    }

    @And("User clicks on Addtocart button")
    public void user_clicks_on_Addtocart_button(){
        DemoWebshop_CataloguePage.clickAddToCartBtn();
    }
    @And("User clicks on Shopping cart link")
    public void user_clicks_on_Shopping_cart_link(){
        DemoWebshop_HomePage.clickShoppingCartLink();
    }
    @And("User get Cartprice Beforediscount")
    public void user_get_Cartprice_Beforediscount(){
        double totalValue_BeforeDiscount = DemoWebshop_CartPage.getCartPriceBeforeDiscount();
    }
    @When("User clicks on Txtbox coupon")
    public void user_clicks_on_Txtbox_coupon(){
        DemoWebshop_CartPage.clickTxtbxCoupon();
    }
    @Then("User enter Txtbox coupon as {string}")
    public void user_enter_Txtbox_coupon(){
        DemoWebshop_CartPage.enterTxtbxCoupon(ApplyCoupon);
    }


    @And("User Clicks on Checkout button")
    public void clickscheckoutbutton() {
        DemoWebshop_CartPage.clickCheckoutBtn();
    }



    @Then("User Get OrderNumber")
    public void getordernumber() {
        DemoWebshop_CheckoutPage.getOrderNumber();
    }

    @And("User logout after verification")
    public void logut_after_verification(){
        DemoWebshop_HomePage.logout();
    }

    @When("User login into DemoWebshop Application with UserName {string} and Password {string}")
    public void user_login_into_demo_webshop_application_with_user_name_and_password(String UserName, String Password) {
        DemoWebshop_LoginPage.login(UserName, Password);
    }

    @Then("User Verifies Successful login of DemoWebshop application")
    public void user_verifies_successful_login_of_demo_webshop_application() {
        DemoWebshop_HomePage.verifyTitle();
    }


    /*@When("User Enters PhoneNumber as {string} and FaxNumber as {string}")
    public void user_enters_phone_number_as_and_fax_number_as(String string, String string2) {
        DemoWebshop_HomePage.createContactNumbers(ZipPostalCode, PhoneNumber, FaxNumber);
    }*/






    @Then("User Updates the Status in ExcelSheet for CreateAddress")
    public void User_Updates_the_Status_in_ExcelSheet_for_CreateAddress(ITestResult result) throws Exception
    {
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
    }

    @When("User performs Total Orders count")
    public void user_performs_total_orders_count() {

        TotalNumberOfOrders = DemoWebShop_OrdersPage.totalNumberOfOrders();
    }

    @Then("User Performs Sum of All Orders Placed")
    public void user_performs_sum_of_all_orders_Placed() {

        SumOfAllOrders=DemoWebShop_OrdersPage.sumOfAllOrdersPlaced();
    }

    @Then("User displays Sum of orders DateWise")
    public void user_displays_sum_of_orders_date_wise() {
        DemoWebShop_OrdersPage.sumOfOrdersDayWise();
    }

    @Given("User reads TotalOrder Data from {string} using TestID {string}")
    public void readExcelSheetData_TotalOrders(String sheetName, String testID) throws Exception {
        Log.startTestCase(DemoWebshop_Stepdefintion.class.getName());
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        rowNum_testCase = ExcelUtils.getRowNumber(testID, sheetName);
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");

        userName = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);

        password = ExcelUtils.getCellData(sheetName, rowNum_testCase, Config.col_Password);
        log.info("Password from excel sheet is:" + password);

    }
    /*@Then("User logout from the application")
    public void logout(){
        OrangeHRM_LogoutPage.logout();
    }*/
    @Then("User Updates the Status in ExcelSheet for Total Orders")
    public void updateExcelSheetStatus() throws Exception{

                CucumberHooks.rowNum_Index = rowNum_Index;
                ExcelUtils.setCellData(String.valueOf(TotalNumberOfOrders), "DemoWebShop_TotalOrders", rowNum_testCase, Config.col_TotalOrders_NumberOfOrders);
                log.info(TotalNumberOfOrders + " is updated as Total Number of Orders");

                ExcelUtils.setCellData(String.valueOf(SumOfAllOrders), "DemoWebShop_TotalOrders", rowNum_testCase, Config.col_TotalOrders_SumOfAllOrders);
                log.info(SumOfAllOrders + " is updated as Sum Of All Orders");

                ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
                log.info("TestCase is Passed and status is updated in Excel sheet");

        }


    @Given("User Reads Update Shopping Cart Data from {string} using TestID {string}")
    public void readExcelData_Update_Shopping_Cart(String sheetName, String testID) throws Exception {
        String projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        row_index = ExcelUtils.getRowNumber(testID, "Index");
        userName = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UserName);
        Password = ExcelUtils.getCellData(sheetName, rowNum, Config.col_Password);
        jewel_Length = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UpdateCart_Length);
        update_Qty = ExcelUtils.getCellData(sheetName, rowNum, Config.col_UpdateCart_Quantity);
    }

    @Then("User Updates the Status in ExcelSheet for Update Shopping Cart")
    public void userUpdatesTheStatusInExcelSheetForUpdateShoppingCart(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelUtils.setCellData(orderNumber, sheetName, row, Config.col_UpdateCart_OrderNumber);
            log.info(orderNumber + " is written back to the Excel file");

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

    }
}




