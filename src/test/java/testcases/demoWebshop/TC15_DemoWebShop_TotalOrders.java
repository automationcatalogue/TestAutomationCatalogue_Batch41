package testcases.demoWebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoWebShop_OrdersPage;
import pages.DemoWebshop_HomePage;
import pages.DemoWebshop_LoginPage;
import utilities.CommonUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TC15_DemoWebShop_TotalOrders {

    @Test
    @Parameters({"browserName"})
    //public static WebDriver TotalOrder() {
        public void TotalOrder(@Optional("chrome") String browserName) throws Exception{

        WebDriver driver = CommonUtils.browserLaunch("chrome");

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(DemoWebshop_LoginPage.link_Login).click();
        driver.findElement(DemoWebshop_LoginPage.txtbx_UserName).sendKeys("aarosagarch@gmail.com");
        driver.findElement(DemoWebshop_LoginPage.txtbx_Passwod).sendKeys("Admin@123");
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

