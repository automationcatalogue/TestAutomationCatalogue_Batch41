package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsDemo1 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser window is launched");

        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");

        driver.get("https://www.amazon.in/");
        System.out.println("Amazon website is loaded");

        WebElement element_searchbox = driver.findElement(By.id("twotabsearchtextbox"));

        element_searchbox.sendKeys("toys");
        System.out.println("Toys is entered in Amazon website");

        Thread.sleep(4000);

        element_searchbox.clear();
        System.out.println("Search box text is cleared");

        Thread.sleep(4000);

        element_searchbox.sendKeys("iphone");
        System.out.println("iphone is entered in the Amazon website");

        element_searchbox.submit();
        System.out.println("Form is submitted and search result is came");

        /*driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("Search icon is clicked");*/

        String elementText = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).getText();
        System.out.println("Element Text is :"+elementText);

        boolean b = elementText.contains("iPhone");
        if(b){
            System.out.println("Search result is correct");
        }else{
            System.out.println("Search result is incorrect");
        }

        Thread.sleep(4000);

        //boolean c=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).isDisplayed();
        boolean c = driver.findElement(By.id("a-popover-s-safe-modal-singleton")).isDisplayed();
        System.out.println(c);

        driver.close();
        System.out.println("Browser window is closed");



    }
}
