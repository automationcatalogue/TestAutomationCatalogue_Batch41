package testcases.demoWebshop;

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
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

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
    @BeforeClass
 public void prerequisite_Setup() throws Exception {
     wbk= ExcelUtils.setExcelFilePath();
     sheetName = "DemoWebshop_UpdateShoppingCart";
     row = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
     row_index = ExcelUtils.getRowNumber(Config.TestCase_ID,"Index");
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
      System.out.println("Browser is closed");
  }
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(orderNumber, sheetName,row, Config.col_UpdateCart_OrderNumber);
            System.out.println(orderNumber+" is written back to the Excel file");

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

