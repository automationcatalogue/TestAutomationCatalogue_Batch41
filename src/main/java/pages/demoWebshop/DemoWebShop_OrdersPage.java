package pages.demoWebshop;

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

    static Logger log = LogManager.getLogger(DemoWebShop_OrdersPage.class);

    public static By link_Email = By.xpath("//div[@class='master-wrapper-content']//a[@class='account']");
    public static By btn_FirstOrderDetails = By.xpath("//div[@class='order-list']/div[1]//input");

    public static By listOfAllOrders = By.xpath("//div[@class='section order-item']/div/strong");

    public static By listOfAllOrderTotal = By.xpath("//li[contains(text(),'Order Total')]");

    public static By listOfOrdersDayWise = By.xpath("//div[@class='page account-page order-list-page']//ul/li[2]");

    public static By orderValue = By.xpath("./../li[3]");

    public static By orderNumber = By.xpath("//div[@class='section order-item']/div/strong");

    public static By orderTotals = By.xpath("//li[contains(text(),'Order Total')]");

    public static By allOrdersElements = By.xpath("//div[@class='page account-page order-list-page']//ul/li[2]");
    public static By orderValues= By.xpath("./../li[3]");


    static int TotalNumberOfOrders;


    public static void clickFirstOrderDetailsBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_FirstOrderDetails).click();
        log.info("First Order details button is clicked");
    }

    public static int totalNumberOfOrders(){
        WebDriver driver = BaseClass.getDriver();
        List<WebElement> OrderNumbers = driver.findElements(orderNumber);
        TotalNumberOfOrders = OrderNumbers.size();
        log.info("Total number of orders :" + TotalNumberOfOrders);
        return OrderNumbers.size();
    }

    public static float sumOfAllOrdersPlaced(){
        WebDriver driver = BaseClass.getDriver();
        List<WebElement> list_Orders = driver.findElements(orderTotals);
        String actualOrderValue;
        float totalValue = 0.0f;
        for (WebElement element_Order : list_Orders) {
            String orderPrice = element_Order.getText();
            actualOrderValue = orderPrice.split(":")[1];
            float orderValue = Float.parseFloat(actualOrderValue);
            totalValue = totalValue + orderValue;
        }
        log.info("Total value of all orders placed is : " + totalValue);
        return totalValue;
    }

    public static void sumOfOrdersDayWise(){
        WebDriver driver = BaseClass.getDriver();
        HashMap<String, Double> map_DayWiseOrders = new HashMap<String, Double>();
        List<WebElement> elements_allOrders = driver.findElements(allOrdersElements);
        for (WebElement element_Order : elements_allOrders) {
            String orderDate = element_Order.getText();
            orderDate = orderDate.split(":")[1].trim();
            orderDate = orderDate.split(" ")[0];

            String orderValue = element_Order.findElement(orderValues).getText();
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
            log.info("Order Date is :" + eachEntry_Daywise.getKey() + " Sum of all Orders :" + eachEntry_Daywise.getValue());
        }
    }
}
