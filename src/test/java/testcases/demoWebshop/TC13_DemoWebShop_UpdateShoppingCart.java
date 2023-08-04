package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

public class TC13_DemoWebShop_UpdateShoppingCart {
    String projectPath;
    FileInputStream fis;
    FileOutputStream fos;
    XSSFWorkbook wbk;
    XSSFSheet ws;
    XSSFRow row;
    XSSFCell userName_cell; String userName;
    XSSFCell passWord_cell; String passWord;
    XSSFCell length_cell; String jewel_Length;
    XSSFCell updateQty_cell; String update_Qty;
    XSSFCell orderNumber_cell; String orderNumber;
 @BeforeClass
 public void prerequisite_Setup() throws Exception {
     wbk= ExcelUtils.setExcelFilePath();
     String sheetName = "DemoWebshop_UpdateShoppingCart";

     userName = ExcelUtils.getCellData(sheetName,1,3);
     passWord = ExcelUtils.getCellData(sheetName,1,4);
     length_cell = row.getCell(5);
     jewel_Length = length_cell.getStringCellValue();
     updateQty_cell = row.getCell(6);
     update_Qty = updateQty_cell.getStringCellValue();
 }
     @Test
  @Parameters({"browserName"})
    public void Update_ShoppingCart(@Optional("chrome")String browserName){
       WebDriver driver = CommonUtils.browserLaunch("Chrome");
       BaseClass ob = new BaseClass(driver);

       driver.manage().window().maximize();
       JavascriptExecutor js = (JavascriptExecutor) driver;
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

      driver.get("https://demowebshop.tricentis.com/");
      driver.findElement(DemoWebshop_HomePage.link_Login).click();
      System.out.println("Clicked on the login link");

      DemoWebshop_LoginPage.login(userName,passWord);

      /*driver.findElement(DemoWebshop_HomePage.link_HeaderBooks).click();
      System.out.println("Clicked on Books link");

      driver.findElement(DemoWebshop_BooksPage.link_FirstItem).click();
      System.out.println("Clicked on first item in books ");

      driver.findElement(DemoWebshop_BooksPage.btn_AddCartInsideFirstItem).click();
      System.out.println("Clicked on Add to Cart Button in Books");

      driver.findElement(DemoWebshop_HomePage.link_HeaderJewels).click();
      System.out.println("Clicked on Jewellery link");

      driver.findElement(DemoWebshop_JewelsPage.link_FirstItem).click();
      System.out.println("Clicked on first item in jewellery ");

      driver.findElement(DemoWebshop_JewelsPage.txtbx_LngthInsideFrstItm).sendKeys(jewel_Length);

      driver.findElement(DemoWebshop_JewelsPage.btn_AddCartInsideFrstItm).click();
      System.out.println("Clicked on Add to Cart Button in Jewellery");

      driver.findElement(DemoWebshop_HomePage.link_ShoppingCart).click();
      System.out.println("Clicked on Shopping Cart Link");

      String actual_updateQty=update_Qty;

      WebElement total1 = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal);
      String total_1 = total1.getText();
      System.out.println("Total of the first item before increasing the quantity is :" + total_1);

      WebElement books_qty1 = driver.findElement(DemoWebshop_CartPage.txtbx_FirstItemQty);
      books_qty1.clear();
      books_qty1.sendKeys(actual_updateQty);
      System.out.println("Quantity is increased in first item");

      WebElement total2 = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal);
      String total_2 = total2.getText();
      System.out.println("Total of the second item before increasing the quantity is :" + total_2);


      WebElement jewel_qty2 = driver.findElement(DemoWebshop_CartPage.txtbx_SecondItemQty);
      jewel_qty2.clear();
      jewel_qty2.sendKeys(actual_updateQty);
      System.out.println("Quantity is increased in second item");

      driver.findElement(DemoWebshop_CartPage.btn_UpdateShopCart).click();
      System.out.println("Clicked on the Update cart button");

      String text_BookPrice = driver.findElement(DemoWebshop_CartPage.txt_PriceFirstItem).getText();
      String text_updatedQuty = driver.findElement(DemoWebshop_CartPage.txtbx_FirstItemQty).getAttribute("value");

      if(actual_updateQty.equalsIgnoreCase(text_updatedQuty)){

          System.out.println("Update Quantity is successful for Book Item!!!");
          String text_BookTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal).getText();

          double bookPrice = Double.parseDouble(text_BookPrice);
          double updateQty = Double.parseDouble(text_updatedQuty);
          double bookTotalPrice = Double.parseDouble(text_BookTotalPrice);

          double expectedTotalPrice = bookPrice * updateQty;
          if(expectedTotalPrice == bookTotalPrice){
              System.out.println("Update Shopping Cart is successful for Book Item and Price is matched i.e :"+bookTotalPrice);
          }else{
              System.out.println("Update Shopping Cart is not successful for Book Item and Price is not matched!!!");
          }

      }else{
          System.out.println("Update Quantity is not successful for Book Item!!!");
      }

      String text_JewelPrice = driver.findElement(DemoWebshop_CartPage.txt_PriceSecondItem).getText();
      String text_updatedQutyJew = driver.findElement(DemoWebshop_CartPage.txtbx_SecondItemQty).getAttribute("value");
      if(actual_updateQty.equalsIgnoreCase(text_updatedQutyJew)){

          System.out.println("Update Quantity is successful for Jewel Item!!!");
          String text_JewelTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal).getText();

          double JewelPrice = Double.parseDouble(text_JewelPrice);
          double updateQty = Double.parseDouble(text_updatedQuty);
          double JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);

          double expectedTotalPrice = JewelPrice * updateQty;
          if(expectedTotalPrice == JewelTotalPrice){
              System.out.println("Update Shopping Cart is successful for Jewel Item and Price is matched i.e :"+JewelTotalPrice);
          }else{
              System.out.println("Update Shopping Cart is not successful for Jewel Item and Price is not matched!!!");
          }

      }else{
          System.out.println("Update Quantity is not successful for Jewel Item!!!");
      }

      String text_BookTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_FirstItemTotal).getText();
      double dou_BookTotalPrice = Double.parseDouble(text_BookTotalPrice);
      String text_JewelTotalPrice = driver.findElement(DemoWebshop_CartPage.txt_SecondItemTotal).getText();
      double dou_JewelTotalPrice = Double.parseDouble(text_JewelTotalPrice);


      double grandTotal=dou_BookTotalPrice+dou_JewelTotalPrice;
      String actualTotal=driver.findElement(DemoWebshop_CartPage.txt_ActualGrandTotal).getText();
      double TOTAL=Double.parseDouble(actualTotal);

      if(grandTotal==TOTAL){
          System.out.println("Cart total is accurate i.e :"+TOTAL);
      }else{
          System.out.println("Cart total is not accurate");
      }

      driver.findElement(DemoWebshop_CartPage.checkbox_Iagree).click();
      System.out.println("Check-box is clicked");

      driver.findElement(DemoWebshop_CartPage.btn_Checkout).click();
      System.out.println("Checkout button is clicked");

      driver.findElement(DemoWebshop_CheckoutPage.btn_BillingContinue).click();
      System.out.println("Continue button is clicked under Billing Address");

      driver.findElement(DemoWebshop_CheckoutPage.btn_ShippingAddress).click();
      System.out.println("Continue button is clicked under Shipping Address");

      driver.findElement(DemoWebshop_CheckoutPage.btn_ShippingMethod).click();
      System.out.println("Continue button is clicked under Shipping Method");

      driver.findElement(DemoWebshop_CheckoutPage.btn_PaymentMethod).click();
      System.out.println("Continue button is clicked under Payment Method");

      driver.findElement(DemoWebshop_CheckoutPage.btn_PaymentInformation).click();
      System.out.println("Continue button is clicked under Payment Information");

      driver.findElement(DemoWebshop_CheckoutPage.btn_ConfirmOrder).click();
      System.out.println("Confirm button is clicked under Confirm Order");

      orderNumber = driver.findElement(DemoWebshop_CheckoutPage.txt_OrderNumber).getText();
      System.out.println("Order Number:"+orderNumber);


      driver.findElement(DemoWebshop_HomePage.btn_Logout).click();
      System.out.println("log out is clicked");

      driver.quit();
      System.out.println("Browser is closed");
  }
    @AfterClass
    public void tearDown() throws Exception {

        orderNumber_cell = row.getCell(7);
        if(orderNumber_cell==null){
            orderNumber_cell=row.createCell(7);
        }
        orderNumber_cell.setCellValue(orderNumber);
        fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
        System.out.println(orderNumber+" is written back to the Excel file");

        fos.close();
        System.out.println("Excel File Writing is closed");
        fis.close();
        System.out.println("Excel File reading is closed");*/
    }
}

