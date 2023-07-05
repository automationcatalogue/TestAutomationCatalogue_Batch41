package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTableDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testcataloguea-trials79.orangehrmlive.com/auth/login");

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[3]")));

        driver.findElement(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[3]")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]")));

        List<WebElement> list_elementNames= driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]"));
        boolean isFound = false;

        for(WebElement element_EmpName:list_elementNames){
            String empName=element_EmpName.getText();
            String location = element_EmpName.findElement(By.xpath("./../td[8]")).getText();

            if(empName.equalsIgnoreCase("Jenny Fisher") && location.equalsIgnoreCase("Canadian Development Center")){
                isFound=true;
                break;
            }
        }

        if(isFound){
            System.out.println("EmployeeName is found in the EmployeeList");
        }else{
            System.out.println("EmployeeName is not found in the EmployeeList");
        }

    }
}
