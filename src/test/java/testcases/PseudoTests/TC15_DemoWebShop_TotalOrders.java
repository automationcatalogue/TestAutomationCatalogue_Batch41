package testcases.PseudoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TC15_DemoWebShop_TotalOrders {
    public static void main(String args[]) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("aarosagarch@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        driver.findElement(By.xpath("(//a[@class='account'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='Orders' and @class='inactive']")).click();
        List<WebElement> OrderNumbers = driver.findElements(By.xpath("//div[@class='section order-item']/div/strong"));
        System.out.println("Total number of orders is :" + OrderNumbers.size());
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
        System.out.println("The total value of all orders placed is : " + TotalValue);

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


