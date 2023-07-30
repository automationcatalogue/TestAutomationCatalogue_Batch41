package testcases.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC20_OrangeHRM_Goals {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String employee_name="Aaliyah Haq";
        String Actual_UserName=null;
        driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]")).click();
        List<WebElement> userName_List=driver.findElements(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[4]"));
        for(WebElement userName:userName_List){
            String Name = userName.getText();
            if(Name.equalsIgnoreCase(employee_name)){
                userName.findElement(By.xpath(".//following-sibling::td[4]")).click();
                Actual_UserName=driver.findElement(By.xpath("//input[@id='user_name']/..")).getText();
                System.out.println(Actual_UserName);
                driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
            }
        }
     /*   driver.findElement(By.xpath("(//a[@data-tooltip='Employee Management'])[1]")).click();
        System.out.println("Clicked on the Employee Management");
        String supervisor_name=null;
        List<WebElement> employee_List = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]"));
        for(WebElement employee_Ref:employee_List){
           String  employee=employee_Ref.getText();
           if(employee.equalsIgnoreCase(employee_name)){
               supervisor_name = employee_Ref.findElement(By.xpath(".//following-sibling::td[6]")).getText();
               System.out.println(supervisor_name);
           }
        }
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Clicked on Log Out Button");

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Actual_UserName);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();*/


    }
}
