package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandlingDemo1 {
    public static void main(String[] args) throws Exception{

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

            WebElement txtbx_Search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            txtbx_Search.sendKeys("iPhone");
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

            WebElement lbl_firstsearchresult = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));

            lbl_firstsearchresult.click();
            System.out.println("Clicked on the First Search result");

            Thread.sleep(15000);

            driver.switchTo().window(parentWindow);
            System.out.println("Switched to the parent window");
            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
            System.out.println("Search text is cleared");

            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus");
            System.out.println("Oneplus is entered");

            driver.findElement(By.xpath("//input[contains(@class,'nav-input nav-progressive') and @value='Go']")).click();
            System.out.println("Search Icon is clicked");

            driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
            System.out.println("First Search result is clicked for oneplus");

            Thread.sleep(15000);

            driver.switchTo().window(parentWindow);
            System.out.println("Switched to the parent window");
            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
            System.out.println("Search text is cleared");

            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("realme");
            System.out.println("Oneplus is entered");

            driver.findElement(By.xpath("//input[contains(@class,'nav-input nav-progressive') and @value='Go']")).click();
            System.out.println("Search Icon is clicked");

            driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
            System.out.println("First Search result is clicked for realme");


            driver.switchTo().window(parentWindow);
            System.out.println("Switched to the parent window");

            Set<String> allSessions=driver.getWindowHandles();
            for(String session:allSessions){
                Thread.sleep(4000);
                driver.switchTo().window(session);

                String title1 = driver.getTitle();
                if(title1.contains("OnePlus")){
                    System.out.println("Switched to the OnePlus window");
                    break;
                }
            }








    }
}
