package pages;

import org.openqa.selenium.By;

public class DemoWebShop_OrdersPage {

    public static By link_Email = By.xpath("//div[@class='master-wrapper-content']//a[@class='account']");
    public static By link_Orders = By.xpath("//div[@class='block block-account-navigation']//ul//a[text()='Orders']");
    public static By btn_Orderdetails =By.xpath("//div[@class='order-list']/div[1]//input");
}

