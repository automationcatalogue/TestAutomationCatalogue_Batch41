package testcases.PseudoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC02_OrangeHRM_AddEmployee {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        String title = driver.getTitle();
        System.out.println("Title of the page is:"+title);

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        System.out.println("Admin is entered as a UserName");

        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        driver.findElement(By.xpath("//span[text()='Employee Management']")).click();
        System.out.println("Employee Management is selected");

        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("Clicked on Add button ");

        driver.findElement((By.xpath("//input[@id='first-name-box']"))).sendKeys("Shawn");
        System.out.println("First Name is entered");

        driver.findElement((By.xpath("//input[@id='last-name-box']"))).sendKeys("Desman");
        System.out.println("Last Name is entered");

        driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).click();
        System.out.println("Location drop-down is clicked ");

        driver.findElement(By.xpath("//span[text()='India Office']")).click();
        System.out.println("India Office value is selected from a drop-down");

        driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
        System.out.println("Next button is clicked");

        driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/input")).click();
        System.out.println("Marital Status drop-down is clicked");

        driver.findElement(By.xpath("//span[text()='Single']")).click();
        System.out.println("Single is selected");

        driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']/div/input")).click();
        System.out.println("Marital Status drop-down is clicked");

        driver.findElement(By.xpath("//span[text()='Male']")).click();
        System.out.println("Single is selected");

        driver.findElement(By.xpath("//button[@class='btn btn-secondary right']")).click();
        System.out.println("Clicked on Next");

        driver.findElement((By.xpath("//label[text()='Region']//following-sibling::div[1]//div[text()='-- Select --']"))).click();
        System.out.println("Region drop-down is clicked");

        driver.findElement(By.xpath("//span[text()='Region-3']")).click();
        System.out.println("Region-3 is selected ");

        driver.findElement(By.xpath("//label[text()='FTE']//following-sibling::div[1]//div[text()='-- Select --']")).click();
        System.out.println("FTE drop-down is clicked");

        driver.findElement(By.xpath("//span[contains(text(),'0.75')]")).click();
        System.out.println("0.75 is selected");

        driver.findElement(By.xpath("//label[text()='Temporary Department']//following-sibling::div[1]//div[text()='-- Select --']")).click();
        System.out.println("Temp Department drop-down is clicked");

        driver.findElement(By.xpath("//span[contains(text(),'Sub unit-2')]")).click();
        System.out.println("Sub unit -2 is selected");

        driver.findElement(By.xpath("//button[@ng-show='vm.showFinishButton']")).click();
        System.out.println("clicked on Save");

        driver.findElement(By.xpath("//span[text()='Employee Management']")).click();
        System.out.println("Employee Management is selected");

        driver.findElement(By.xpath("//input[contains(@id,'employee_name_quick_filter')]")).sendKeys("Shawn Desman");
        driver.findElement(By.xpath("//input[contains(@id,'employee_name_quick_filter')]")).click();
        System.out.println("Searched with Employee first and last name");

       String elementText = driver.findElement(By.xpath("//div[@class='emp-name'][text()='Shawn  Desman']")).getText();
       System.out.println("Element Text is :"+elementText);


       if(elementText.equalsIgnoreCase("Shawn Desman")){
            System.out.println("Search result is correct");
        }else{
            System.out.println("Search result is incorrect");
        }

        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("log out is clicked");

        driver.close();






    }
}
