package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://automation41-trials79.orangehrmlive.com");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[3]")).click();

        driver.findElement(By.xpath("//a[@id='addEmployeeButton']/i")).click();

        driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys("Automation");
        driver.findElement(By.xpath("//button[@data-id='location']")).click();

        driver.findElement(By.xpath("//span[text()='India Office']")).click();
        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();

        //Selection of Date Picker
        driver.findElement(By.xpath("//input[@id='emp_birthday']//following-sibling::span//i")).click();


        String date = "26-September-2009";
        String calendar[] = date.split("-");

        String day = calendar[0];
        String month = calendar[1];
        String year = calendar[2];

        //year selection
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input")).click();


        List<WebElement> list_years = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for(WebElement element_year:list_years){

            String actualYear = element_year.getText();

            if(actualYear.equalsIgnoreCase(year)){
                element_year.click();
                System.out.println(year+" is selected from the year drop-down");
                break;
            }
        }


        //month selection
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']/input")).click();


        List<WebElement> list_months =driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for(WebElement element_month:list_months){

            String actualMonth = element_month.getText();
            if(actualMonth.equalsIgnoreCase(month)){
                element_month.click();
                System.out.println(month+" month is selected from the Month drop-down");
                break;
            }
        }


        List<WebElement> list_dates = driver.findElements(By.xpath("(//div[@class='picker__calendar-container'])[1]/table/tbody/tr/td/div"));
        for(WebElement element_date:list_dates){

            String actualDay =element_date.getText();
            if(actualDay.equalsIgnoreCase(day)){
                element_date.click();
                System.out.println(day+" is selected from the calendar as day");
                break;
            }

        }

    }
}
















