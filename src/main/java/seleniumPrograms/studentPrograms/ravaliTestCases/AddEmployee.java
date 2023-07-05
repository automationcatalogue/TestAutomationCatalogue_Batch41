package seleniumPrograms.studentPrograms.ravaliTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddEmployee {

    public static void main(String[] args) throws Exception{
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automation41-trials79.orangehrmlive.com");
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@type ='submit']")).click();
        //Thread.sleep(3000);
        String title=driver.getTitle();
        if(title.equalsIgnoreCase("Employee Management")){
            System.out.println("Login is successfull");
        }
        else {
            System.out.println("Login is not Successful");
        }
        //driver.findElement(By.xpath("//*[@data-automation-id='menu_admin_viewSystemUsers' and @class=' main-menu-item-1']")).click();
        driver.findElement(By.className("top-level-menu-item")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='addEmployeeButton']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='first-name-box']")).sendKeys("Ramya");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='last-name-box']")).sendKeys("Krishna");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='filter-option-inner-inner']")).click();
        Thread.sleep(3000);
        //contains(@class,'value')
        //for handling bootstrap dropdown
        List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu inner show')]//li//a//span"));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().contains("India Office")){
                list.get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@id='modal-save-button' and @class='btn btn-secondary']")).click();
        driver.findElement(By.xpath("(//*[@class='select-dropdown'])[1]")).click();
        Thread.sleep(3000);
        List<WebElement> list1=driver.findElements(By.xpath("//ul[contains(@id,'select-options-31482cee-d90f-1b9d-e3e2-7e3118ce3724')]//li//span"));
        System.out.println(list1.size());
        for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i).getText());
            if(list1.get(i).getText().contains("Married")){
                list1.get(i).click();
                break;
            }
        }

    }
}
