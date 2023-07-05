package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandlingDemo {
    public static void main(String[] args) throws Exception{
        WindowHandlingDemo ob = new WindowHandlingDemo();
        ob.validateWindowActions();
    }

    //instance method
    //method without arguments and without return type
    public void validateWindowActions() throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Brwoser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://www.amazon.in/");
        System.out.println("Amazon website is loaded");

        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")){
            System.out.println("Website is loaded");
        }else{
            System.out.println("Website is not loaded");
        }

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone");
        System.out.println("iPhone is entered in the search text-box");

        driver.findElement(By.xpath("//input[contains(@class,'nav-input nav-progressive') and @value='Go']")).click();
        System.out.println("Search Icon is clicked");

        Thread.sleep(4000);

        String element_text = driver.findElement(By.xpath("//span[contains(text(),'iPhone') and @class='a-color-state a-text-bold']")).getText();
        if(element_text.contains("iPhone")){
            System.out.println("iPhone Search results are displayed");
        }else{
            System.out.println("iPhone Search results are not displayed");
        }

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Session Id is "+parentWindow);

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        System.out.println("Clicked on the First Search result");

        Set<String> allWindowIds = driver.getWindowHandles();
        System.out.println(allWindowIds);

        for(String windowId:allWindowIds){
            driver.switchTo().window(windowId);
        }
        System.out.println("Switched to the latest window");

        Thread.sleep(15000);

        WebElement element=driver.findElement(By.xpath("//span[text()='Add to Cart']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
        System.out.println("Add To Cart button is clicked");
        driver.close();

        driver.switchTo().window(parentWindow);
        System.out.println("Switched to the parent window");

    }
}
