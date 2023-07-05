package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_Assignment {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser window is launched");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Orange HRM website is loaded");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        System.out.println("UserName is entered");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        System.out.println("Admin link is clicked");

        driver.findElement(By.xpath("//span[contains(text(),'Job')]")).click();
        System.out.println("Job drop-down is clicked");
        Thread.sleep(2000);
        List<WebElement> elementList_Job = driver.findElements(By.xpath("//span[contains(text(),'Job')]//following-sibling::ul/li"));
        for(WebElement element:elementList_Job){
            String element_text = element.getText();
            if(element_text.contains("Job Titles")){
                element.click();
                System.out.println("Job Titles is selected");
                break;
            }
        }

        driver.findElement(By.xpath("//h6[contains(@class,'orangehrm-main-title')]//following-sibling::div/button")).click();
        System.out.println("+Add button is clicked");

        driver.findElement(By.xpath("//label[text()='Job Title']/..//following-sibling::div/input")).sendKeys("Administrator");
        System.out.println("Administrator is entered as Job Title");

        driver.findElement(By.xpath("//label[text()='Job Description']/..//following-sibling::div/textarea")).sendKeys("Needs to perform all admin activities");
        System.out.println("Job Description is entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Save button is clicked");

        List<WebElement> elements_JobTitles =driver.findElements(By.xpath("//div[@class='oxd-table-body']/div/div/div[2]/div"));
        boolean isTitleFound = false;
        for(WebElement element:elements_JobTitles){
            String element_text = element.getText();
            if(element_text.equalsIgnoreCase("Administrator")){
                isTitleFound=true;
                break;
            }
        }
        if(isTitleFound){
            System.out.println("Job title is not added");
        }else{
            System.out.println("Job Title adding is successful");
        }

        driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
        System.out.println("Recruitment link is clicked");

        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
        System.out.println("+Add button is clicked");

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Test");
        System.out.println("FirstName is entered");

        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Automation");
        System.out.println("LastName is entered");

        driver.findElement(By.xpath("//label[text()='Email']/..//following-sibling::div/input")).sendKeys("test@gmail.com");
        System.out.println("EmailId is entered");

        driver.findElement(By.xpath("//label[text()='Notes']/..//following-sibling::div/textarea")).sendKeys("Adding New candidate");
        System.out.println("Notes is entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Save button is clicked");

        String name = driver.findElement(By.xpath("//label[text()='Name']/..//following-sibling::div/p")).getText();
        if(name.contains("Test") && name.contains("Automation")){
            System.out.println("Adding New Candidate is successful");
        }else{
            System.out.println("Adding New Candidate is not successful");
        }

        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        System.out.println("Admin link is clicked");

        driver.findElement(By.xpath("//span[contains(text(),'Job')]")).click();
        System.out.println("Job drop-down is clicked");
        Thread.sleep(2000);
        elementList_Job = driver.findElements(By.xpath("//span[contains(text(),'Job')]//following-sibling::ul/li"));
        for(WebElement element:elementList_Job){
            String element_text = element.getText();
            if(element_text.contains("Job Titles")){
                element.click();
                System.out.println("Job Titles is selected");
                break;
            }
        }

        List<WebElement> elements =driver.findElements(By.xpath("//div[@class='oxd-table-body']/div/div"));
        for(WebElement element:elements){
            WebElement element1 = element.findElement(By.xpath("./div[2]/div"));
            String element_text = element1.getText();
            if(element_text.equalsIgnoreCase("Administrator")){
                element.findElement(By.xpath("./div[4]/div/button")).click();
                System.out.println("Delete button is clicked for the Administrator Job Title");
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']/button[2]")).click();
        System.out.println("Yes, Delete button is clicked");

    }
}
