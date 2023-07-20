package pages;

import org.openqa.selenium.By;

public class DemoWebshop_JewelsPage {
    public static By link_FirstItem = By.xpath("//div[@class='product-grid']//a[1]");
    public static By txtbx_LngthInsideFrstItm = By.xpath("(//input[@type='text'])[3]");
    public static By btn_AddCartInsideFrstItm=By.xpath("(//input[@value='Add to cart'])[1]");
}
