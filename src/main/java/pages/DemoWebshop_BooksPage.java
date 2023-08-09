package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class DemoWebshop_BooksPage {
    public static By link_FirstItem = By.xpath("//div[@class='product-grid']//a[1]");
    public static By btn_AddCartInsideFirstItem = By.xpath("(//input[@value='Add to cart'])[1]");

    public static By link_Books = By.xpath("//div//ul[@class='top-menu']//a[@href='/books']");
    public static By btn_AddToCart = By.xpath("(//div[@class='product-grid']//input)[1]");

    public static void adding_FirstBookToCart(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(DemoWebshop_BooksPage.link_FirstItem).click();
        System.out.println("Clicked on first item in books ");

        driver.findElement(DemoWebshop_BooksPage.btn_AddCartInsideFirstItem).click();
        System.out.println("Clicked on Add to Cart Button in Books");

    }
}
