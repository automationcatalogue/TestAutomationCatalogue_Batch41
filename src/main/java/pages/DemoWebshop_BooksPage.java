package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_BooksPage {
    public static By link_FirstItem = By.xpath("//div[@class='product-grid']//a[1]");
    public static By btn_AddCartInsideFirstItem = By.xpath("(//input[@value='Add to cart'])[1]");

    public static By link_Books = By.xpath("//div//ul[@class='top-menu']//a[@href='/books']");
    public static By btn_AddToCart = By.xpath("(//div[@class='product-grid']//input)[1]");

    public static void clickBooksLink(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_Books).click();
        System.out.println("Books link is clicked");
    }
    public static void clickAddToCartBtn(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_AddToCart).click();
        System.out.println("Add to cart button is clicked");
    }

}
