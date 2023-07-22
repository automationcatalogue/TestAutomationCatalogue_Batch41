package testcases.demoWebshop;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import utilities.CommonUtils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TC15_DemoWebShop_TotalOrders {


    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell cell_userName;
    static String userName;
    static XSSFCell cell_password;
    static String password;

    @BeforeClass
    public void prerequisite_setup() throws Exception {
        String projectPath = System.getProperty("user.dir");
        fis = new FileInputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk = new XSSFWorkbook(fis);
        sh = wbk.getSheet("DemoWebShop_TotalOrders");
        row = sh.getRow(1);

        cell_userName = row.getCell(3);
        userName = cell_userName.getStringCellValue();
        System.out.println("UserName from excel sheet is :" + userName);

        cell_password = row.getCell(4);
        password = cell_password.getStringCellValue();
        System.out.println("Password from excel sheet is:" + password);

    }


    @Test
    @Parameters({"browserName"})
    //public static WebDriver TotalOrder() {
        public void TotalOrder(@Optional("chrome") String browserName) throws Exception{

        WebDriver driver = CommonUtils.browserLaunch("chrome");

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(DemoWebshop_HomePage.link_Login).click();
        driver.findElement(DemoWebshop_LoginPage.txtbx_UserName).sendKeys(userName);
        driver.findElement(DemoWebshop_LoginPage.txtbx_Password).sendKeys(password);
        driver.findElement(DemoWebshop_LoginPage.btn_Login).click();
        driver.findElement(DemoWebshop_HomePage.link_Email).click();
        driver.findElement(DemoWebShop_OrdersPage.link_Orders).click();
        List<WebElement> OrderNumbers = driver.findElements(DemoWebShop_OrdersPage.listOfAllOrders);
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

    }

}

