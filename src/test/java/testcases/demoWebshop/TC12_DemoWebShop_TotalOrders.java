package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TC12_DemoWebShop_TotalOrders {


    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;

    static XSSFCell cell_TotalNumberOfOrders;

    static XSSFCell cell_SumOfAllOrders;
    static String TotalNumberOfOrders;

    static  String SumOfAllOrders;

    static FileOutputStream fos;
    static String projectPath;

    @Parameters("{testID}")
    @BeforeClass
    public void prerequisite_setup(@Optional(Config.TestCase_ID) String testID) throws Exception {
        wbk= ExcelUtils.setExcelFilePath();
        String sheetName="DemoWebShop_TotalOrders";
        int rowNum = ExcelUtils.getRowNumber(testID,sheetName);

        userName = ExcelUtils.getCellData(sheetName,rowNum,Config.col_UserName);
        System.out.println("UserName from excel sheet is :" + userName);

        password = ExcelUtils.getCellData(sheetName,rowNum,Config.col_Password);
        System.out.println("Password from excel sheet is:" + password);

    }


    @Test
    @Parameters({"browserName"})
    //public static WebDriver TotalOrder() {
        public void TotalOrder(@Optional("chrome") String browserName) throws Exception{

        WebDriver driver = CommonUtils.browserLaunch("chrome");
        BaseClass ob = new BaseClass(driver);

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        DemoWebshop_LoginPage.login(userName,password);

        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        List<WebElement> OrderNumbers = driver.findElements(DemoWebShop_OrdersPage.listOfAllOrders);
        TotalNumberOfOrders = String.valueOf((int) OrderNumbers.size());
        System.out.println("Total number of orders is :" + OrderNumbers.size());
        List<WebElement> OrderTotal = driver.findElements(DemoWebShop_OrdersPage.listOfAllOrderTotal);
        String temp = "", temp1 = "", temp2 = "";
        float TotalValue = 0.0f;
        Float OrderValue = null;
        Float TotalValue1 = 0.0f;
        for (WebElement OrderStatement : OrderTotal) {
            String TotalOrderStatement = OrderStatement.getText();

            String str1[] = TotalOrderStatement.split(":");
            temp = str1[1];
            OrderValue = Float.valueOf(temp);
            TotalValue = TotalValue + OrderValue;

            SumOfAllOrders = String.valueOf(TotalValue);


        }
        System.out.println("The total value of all orders placed is : " + TotalValue);

        HashMap<String, Double> map_DayWiseOrders = new HashMap<String, Double>();
        List<WebElement> elements_allOrders = driver.findElements(DemoWebShop_OrdersPage.listOfOrdersDayWise);
        //List<WebElement> elements_allOrders=listOfOrdersForDayWise;
        for (WebElement element_Order : elements_allOrders) {
            String orderDate = element_Order.getText();
            orderDate = orderDate.split(":")[1].trim();
            orderDate = orderDate.split(" ")[0];

            String orderValue = element_Order.findElement(DemoWebShop_OrdersPage.orderValue).getText();
            orderValue = orderValue.split(":")[1].trim();
            Double dOrderValue = Double.parseDouble(orderValue);

            if (map_DayWiseOrders.containsKey(orderDate)) {
                double dtotalOrderValue = map_DayWiseOrders.get(orderDate);
                dtotalOrderValue += dOrderValue;
                map_DayWiseOrders.put(orderDate, dtotalOrderValue);
            } else {
                map_DayWiseOrders.put(orderDate, dOrderValue);
            }
        }
        //Printing sumOf Orders Daywise
        Set<Map.Entry<String, Double>> allEntries_Daywise = map_DayWiseOrders.entrySet();
        for (Map.Entry<String, Double> eachEntry_Daywise : allEntries_Daywise) {
            System.out.println("Order Date is :" + eachEntry_Daywise.getKey() + " Sum of all Orders :" + eachEntry_Daywise.getValue());
        }
       driver.close();
    }

    @AfterClass
    public void tearDown() throws Exception {

        cell_TotalNumberOfOrders = row.getCell(5);
        cell_SumOfAllOrders = row.getCell(6);

        if(cell_TotalNumberOfOrders==null){
            cell_TotalNumberOfOrders=row.createCell(5);
        }
        cell_TotalNumberOfOrders.setCellValue(TotalNumberOfOrders);
        fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
        System.out.println(TotalNumberOfOrders+" is written back to the Excel file");

        if(cell_SumOfAllOrders==null)
        {
            cell_SumOfAllOrders=row.createCell(6);
        }
        cell_SumOfAllOrders.setCellValue(SumOfAllOrders);
        fos = new FileOutputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk.write(fos);
        System.out.println(SumOfAllOrders+" is written back to the Excel file");
        fos.close();
        System.out.println("ExcelFile Writing is closed");
        fis.close();
        System.out.println("ExcelFile reading is closed");
    }

}

