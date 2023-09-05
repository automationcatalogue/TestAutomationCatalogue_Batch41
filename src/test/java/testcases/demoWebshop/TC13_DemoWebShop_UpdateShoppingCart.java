package testcases.demoWebshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import testcases.orangeHRM.TC04_OrangeHRM_EditEmployee;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

public class TC13_DemoWebShop_UpdateShoppingCart {
    XSSFWorkbook wbk;
    static int row; static int row_index;
    static String userName;
    static String passWord;
    static String jewel_Length;
    static String update_Qty;
    static String orderNumber;
    static  String total_1; static String total_2;
    static String text_BookPrice; static String text_updatedQuty;
    static String text_JewelPrice;static String sheetName;
    static Logger log = LogManager.getLogger(TC13_DemoWebShop_UpdateShoppingCart.class);

    @Parameters("{testID}")
    @BeforeClass
 public void prerequisite_Setup(@Optional(Config.UpdateShoppingCartRequestTestCase_ID) String testID) throws Exception {
        Log.startTestCase(TC13_DemoWebShop_UpdateShoppingCart.class.getName());
     wbk= ExcelUtils.setExcelFilePath();
     sheetName = "DemoWebshop_UpdateShoppingCart";
     row = ExcelUtils.getRowNumber(testID,sheetName);
     row_index = ExcelUtils.getRowNumber(testID,"Index");
     userName = ExcelUtils.getCellData(sheetName,row,Config.col_UserName);
     passWord = ExcelUtils.getCellData(sheetName,row,Config.col_Password);
     jewel_Length = ExcelUtils.getCellData(sheetName,row,Config.col_UpdateCart_Length);
     update_Qty = ExcelUtils.getCellData(sheetName,row,Config.col_UpdateCart_Quantity);
 }
     @Test
     @Parameters({"browserName"})
     public void Update_ShoppingCart(@Optional("chrome")String browserName) throws Exception {
       WebDriver driver = CommonUtils.browserLaunch("Chrome");
       BaseClass ob = new BaseClass(driver);

       driver.manage().window().maximize();
       JavascriptExecutor js = (JavascriptExecutor) driver;
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

      driver.get("https://demowebshop.tricentis.com/");

      DemoWebshop_LoginPage.login(userName,passWord);

      DemoWebshop_HomePage.select_BooksLink();
      DemoWebshop_BooksPage.adding_FirstBookToCart();
      DemoWebshop_HomePage.select_JewelsLink();
      DemoWebshop_JewelsPage.adding_firstJewelToCart(jewel_Length);
      DemoWebshop_HomePage.select_ShoppingCart();
      total_1 = DemoWebshop_CartPage.price_FirstItemBeforeIncreasingQty();
      DemoWebshop_CartPage.price_FirstItemAfterIncreasingQty(update_Qty);
      total_2 = DemoWebshop_CartPage.price_SecondItemBeforeIncreasingQty();
      DemoWebshop_CartPage.price_SecondItemAfterIncreasingQty(update_Qty);
      DemoWebshop_CartPage.select_updateCartButton();
      text_BookPrice = DemoWebshop_CartPage.price_textBook();
      text_updatedQuty = DemoWebshop_CartPage.updatedQty_Text();
      DemoWebshop_CartPage.verify_BookTotalPriceChange(update_Qty,text_BookPrice,text_updatedQuty);
      text_JewelPrice = DemoWebshop_CartPage.price_Jewel();
      DemoWebshop_CartPage.verify_JewelTotalPriceChange(update_Qty,text_JewelPrice,text_updatedQuty);
      DemoWebshop_CartPage.verify_grandTotal();
      DemoWebshop_CartPage.select_checkOut();
      orderNumber = DemoWebshop_CheckoutPage.checking_paymentGateway();

      driver.quit();
      log.info("Browser is closed");
  }
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Log.endTestCase();
        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(orderNumber, sheetName,row, Config.col_UpdateCart_OrderNumber);
            log.info(orderNumber+" is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index",row_index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index",row_index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",row_index,Config.col_reason);
                log.info("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index",row_index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        ExcelUtils.closeExcelFile();
        Log.endTestCase();
    }
}

