package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://www.amazon.in/");
        System.out.println("Amazon website is loaded");

        WebElement element = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select ob = new Select(element);

        ob.selectByIndex(5);
        System.out.println("5th Index value is select from a drop-down");

        Thread.sleep(5000);

        ob.selectByValue("search-alias=electronics");
        System.out.println("Electornics is selected from the drop-down");

        Thread.sleep(5000);

        ob.selectByVisibleText("Tools & Home Improvement");
        System.out.println("Tools & Home Imporvement value is selected from a drop-down");

        boolean flag= ob.isMultiple();
        if(flag){
            System.out.println("Drop-down is allowing multiple selections");
        }else{
            System.out.println("Drop-down is allowing only Single Selection");
        }

        System.out.println("************* Printing All Available options ***************");
        List<WebElement> allElements = ob.getOptions();

        for(int i=0;i<allElements.size();i++){

            WebElement element1 = allElements.get(i);
            System.out.println(element1.getText());

        }



    }
}
