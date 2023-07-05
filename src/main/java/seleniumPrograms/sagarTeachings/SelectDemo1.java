package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDemo1 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        System.out.println("Website is loaded");

        WebElement element = driver.findElement(By.xpath("//select[@id='ide']"));
        String str = element.getAttribute("multiple");
        System.out.println("Returned Attribute value is :"+str);




        Select ob = new Select(element);

        boolean flag = ob.isMultiple();
        if(flag){
            System.out.println("Drop-down is allowing multiple selection");
        }else{
            System.out.println("Drop-down is allowing only Single selection");
        }

        ob.selectByVisibleText("NetBeans");
        System.out.println("NetBeans is selected from List-box");
        Thread.sleep(3000);

        ob.selectByVisibleText("IntelliJ IDEA");
        System.out.println("IntelliJ IDEA is selected from List-box");
        Thread.sleep(3000);

        ob.selectByVisibleText("Visual Studio");
        System.out.println("Visual Studio is selected from List-box");
        Thread.sleep(3000);

        /*ob.deselectByIndex(0);
        System.out.println("Deselected the 0th index value from List-box");
        Thread.sleep(3000);

        ob.deselectByValue("vs");
        System.out.println("Deselected the vs value from List-box");

        ob.deselectAll();
        System.out.println("Deselected all the values from List-box");*/

        WebElement element1 = ob.getFirstSelectedOption();
        String str1 = element1.getText();
        System.out.println("First Selected Element option element is :"+str1);

        List<WebElement> selectedElements = ob.getAllSelectedOptions();
        for(int i=0;i<selectedElements.size();i++){
            WebElement element3 = selectedElements.get(i);
            System.out.println(element3.getText());
        }

    }
}
