package pages;

import org.openqa.selenium.By;

public class DemoWebShop_OrdersPage {

    public static By link_Email = By.xpath("//div[@class='master-wrapper-content']//a[@class='account']");
    public static By btn_OrderDetails = By.xpath("//div[@class='order-list']/div[1]//input");
    public static By link_Orders = By.xpath("//div[@class='block block-account-navigation']//ul//a[text()='Orders']");
    public static By listOfAllOrders = By.xpath("//div[@class='section order-item']/div/strong");

    public static By listOfAllOrderTotal = By.xpath("//li[contains(text(),'Order Total')]");

    public static By listOfOrdersDayWise = By.xpath("//div[@class='page account-page order-list-page']//ul/li[2]");

    public static By orderValue = By.xpath("./../li[3]");
}
