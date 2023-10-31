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
import pages.*;
import runner.CucumberHooks;
import testcases.demoWebshop.TC13_DemoWebShop_UpdateShoppingCart;
import utilities.*;
;

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
    static int TotalNumberOfOrders;
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

    @Then("User clicks Email link")
    public void user_clicks_email_link() {
        DemoWebshop_HomePage.clickEmailLink();
    }

    @And("User Clicks on Orders link")
    public void user_clicks_on_orders_link() {
        DemoWebShop_OrdersPage.clickLinkOrders();
    }

    @And("User Clicks on OrderDetails button")
    public void user_clicks_on_OrderDetails_button() {
        DemoWebShop_OrdersPage.clickOrderDetailsBtn();
    }

    @Then("User Clicks on ReOrder button")
    public void user_clicks_on_orderdetails_button() {
        DemoWebshop_OrderInformationPage.clickReorderBtn();
    }

    @Then("User clicks on Books link")
    public void user_clicks_on_books_link(){
        DemoWebshop_BooksPage.clickBooksLink();
    }
    @And("User clicks on Addtocart button")
    public void user_clicks_on_Addtocart_button(){
        DemoWebshop_BooksPage.clickAddToCartBtn();
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
    @And("User clicks on Applydiscount button")
    public void user_clicks_on_Applydiscount_button(){
        DemoWebshop_CartPage.clickApplyCouponBtn();
    }
    @When("User get txtmessage printed")
    public void user_get_txtmessage_printed(){
        DemoWebshop_CartPage.getTxtMessagePrinted();
    }
    @Then("User get Discount amount")
    public void user_get_Discount_amount(){
        double discountValue = DemoWebshop_CartPage.getDiscountAmount();
    }
    @And("User get Cartprice Afterdiscount")
    public void user_get_Cartprice_Afterdiscount(){
        double totalValue_AfterDiscount = DemoWebshop_CartPage.getCartPriceAfterDiscount();
    }

    @And("User Clicks on Iagree button")
    public void user_clicks_on_iagree_button() {
        DemoWebshop_CartPage.clickCheckboxIagree();
    }

    @And("User Clicks on Checkout button")
    public void clickscheckoutbutton() {
        DemoWebshop_CartPage.clickCheckoutBtn();
    }

    @When("User Clicks on BillingContinue button")
    public void clicksbillingcontinuebutton() {
        DemoWebshop_CheckoutPage.clickBillingContinue();
    }

    @Then("User Clicks on ShippingAddress button")
    public void clickshippingaddressbutton() {
        DemoWebshop_CheckoutPage.clickShippingAddressBtn();
    }

    @And("User Clicks on ShippingMethod button")
    public void clickshippingmethodbutton() {
        DemoWebshop_CheckoutPage.clickShippingMethodBtn();
    }

    @And("User Clicks on PaymentMethod button")
    public void click_paymentmethod_button() {
        DemoWebshop_CheckoutPage.clickPaymentMethodBtn();
    }

    @And("User Clicks on PaymentInformation button")
    public void click_paymentinformation_button() {
        DemoWebshop_CheckoutPage.clickPaymentInformationBtn();
    }

    @When("User Clicks on ConfirmOrder button")
    public void click_confirmorder_button() {
        DemoWebshop_CheckoutPage.clickConfirmOrderBtn();
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

    @When("User Opens Address page")
    public void user_opens_address_page() {
        DemoWebshop_HomePage.click_mailId();
        DemoWebshop_HomePage.select_AddressLink();
    }

    @When("User Enters PhoneNumber as {string} and FaxNumber as {string}")
    public void user_enters_phone_number_as_and_fax_number_as(String string, String string2) {
        DemoWebshop_HomePage.createContactNumbers(ZipPostalCode, PhoneNumber, FaxNumber);
    }

    @When("User Provides City, Address1, Address2, ZipPostalCode, PhoneNumber and FaxNumber")
    public void user_provides_city_address1_address2_zip_postal_code_phone_number_and_fax_number() {
        DemoWebshop_HomePage.createCityAndAddresses(City, Address1, Address2);
    }

    @Then("User Verifies Address is added")
    public void user_verifies_address_is_added() {
        DemoWebshop_HomePage.verify_Address(FirstName, LastName);
    }

    @When("User clicks on Email Address and click on orders link")
    public void user_clicks_on_email_address_and_click_on_orders_link() {
        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        log.info("Clicked on Email address link");
        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        log.info("Clicked on orders link on MyAccount Page");
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
    @Then("User logout from the application")
    public void logout(){
        OrangeHRM_LogoutPage.logout();
    }
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

    @When("User Enters address fields data for FirstName, LastName, Email and Company")
    public void user_enters_address_fields_data_for_first_name_last_name_email_and_company() {
        DemoWebshop_HomePage.createName(FirstName, LastName);

        DemoWebshop_HomePage.createEmailAndCompany(Email, Company);
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

    @Then("User added the Products to Cart")
    public void userAddedTheProductsToCart() throws Exception {
        DemoWebshop_HomePage.select_BooksLink();
        DemoWebshop_BooksPage.adding_FirstBookToCart();
        DemoWebshop_HomePage.select_JewelsLink();
        DemoWebshop_JewelsPage.adding_firstJewelToCart(jewel_Length);

    }

    @And("User update the shopping cart")
    public void userUpdateTheShoppingCart() {
        DemoWebshop_HomePage.select_ShoppingCart();
        total_1 = DemoWebshop_CartPage.price_FirstItemBeforeIncreasingQty();
        DemoWebshop_CartPage.price_FirstItemAfterIncreasingQty(update_Qty);
        total_2 = DemoWebshop_CartPage.price_SecondItemBeforeIncreasingQty();
        DemoWebshop_CartPage.price_SecondItemAfterIncreasingQty(update_Qty);
        DemoWebshop_CartPage.select_updateCartButton();
    }

    @Then("User verifies the updated price and total")
    public void userVerifiesTheUpdatedPriceAndTotal() {
        text_BookPrice = DemoWebshop_CartPage.price_textBook();
        text_updatedQuty = DemoWebshop_CartPage.updatedQty_Text();
        DemoWebshop_CartPage.verify_BookTotalPriceChange(update_Qty, text_BookPrice, text_updatedQuty);
        text_JewelPrice = DemoWebshop_CartPage.price_Jewel();
        DemoWebshop_CartPage.verify_JewelTotalPriceChange(update_Qty, text_JewelPrice, text_updatedQuty);
        DemoWebshop_CartPage.verify_grandTotal();

    }


    @And("User checkout and Process the payment gateway")
    public void userCheckoutAndProcessThePaymentGateway() {
        DemoWebshop_CartPage.select_checkOut();
        orderNumber = DemoWebshop_CheckoutPage.checking_paymentGateway();
    }
}



