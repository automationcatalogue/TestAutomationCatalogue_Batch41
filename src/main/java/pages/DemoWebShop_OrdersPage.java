package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DemoWebShop_OrdersPage {

    public static By link_Email = By.xpath("//div[@class='master-wrapper-content']//a[@class='account']");
    public static By btn_OrderDetails = By.xpath("//div[@class='order-list']/div[1]//input");
    public static By link_Orders = By.xpath("//div[@class='block block-account-navigation']//ul//a[text()='Orders']");
    public static By listOfAllOrders = By.xpath("//div[@class='section order-item']/div/strong");

    public static By listOfAllOrderTotal = By.xpath("//li[contains(text(),'Order Total')]");

    public static By listOfOrdersDayWise = By.xpath("//div[@class='page account-page order-list-page']//ul/li[2]");

    public static By orderValue = By.xpath("./../li[3]");
    static Logger log = LogManager.getLogger(DemoWebShop_OrdersPage.class);

    public static void clickLinkOrders(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Orders).click();
        log.info("Order link is clicked");
    }
    public static void clickOrderDetailsBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_OrderDetails).click();
        log.info("Order details button is clicked");
    }

    public static int totalNumberOfOrders(){
        WebDriver driver = BaseClass.getDriver();
        List<WebElement> OrderNumbers = driver.findElements(By.xpath("//div[@class='section order-item']/div/strong"));
        log.info("Total number of orders is :" + OrderNumbers.size());
        return OrderNumbers.size();
    }

    public static float sumOfAllOrdersPlaced(){
        WebDriver driver = BaseClass.getDriver();
        List<WebElement> OrderTotal = driver.findElements(By.xpath("//li[contains(text(),'Order Total')]"));
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
        log.info("The total value of all orders placed is : " + TotalValue);
        return TotalValue;
    }

    public static void sumOfOrdersDayWise(){
        WebDriver driver = BaseClass.getDriver();
        HashMap<String, Double> map_DayWiseOrders = new HashMap<String, Double>();
        List<WebElement> elements_allOrders = driver.findElements(By.xpath("//div[@class='page account-page order-list-page']//ul/li[2]"));
        //List<WebElement> elements_allOrders=listOfOrdersForDayWise;
        for (WebElement element_Order : elements_allOrders) {
            String orderDate = element_Order.getText();
            orderDate = orderDate.split(":")[1].trim();
            orderDate = orderDate.split(" ")[0];

            String orderValue = element_Order.findElement(By.xpath("./../li[3]")).getText();
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
