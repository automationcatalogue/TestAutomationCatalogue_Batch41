package testcases.orangeHRM;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
public class TC04_OrangeHRM_EditEmployee {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        String title = driver.getTitle();
        System.out.println("Title of the page is:" + title);

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        System.out.println("Admin is entered as a UserName");

        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        driver.findElement(By.xpath("//span[text()='Employee Management']")).click();
        System.out.println("Employee Management is selected");

        driver.findElement(By.xpath("//tr[contains(@ng-repeat,'employee.empNumber')][1]/td[2]")).click();
        System.out.println("Click on First Employee Data");

        driver.findElement(By.xpath("//ui-view[@name='customTopRibbon']/div/div[1]/top-level-menu-item[2]/div")).click();
        System.out.println("Clicked on Personal Details tab");

        driver.findElement(By.xpath("//input[@id='lastName']")).clear();
        System.out.println("Cleared the last name");

        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Naidu");
        System.out.println("Updated the last name");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//i[contains(@class,\"material-icons action\")])[1]")).click();
        System.out.println("Date picker icon is clicked");


        //month selector
        WebElement dy = driver.findElement(By.xpath("(//div[@class='picker__calendar-container'])[1]/div/div[1]"));
        dy.click();

        Thread.sleep(5000);
        List<WebElement> list_month = driver.findElements(By.xpath("(//div[@class='picker__calendar-container'])[1]/div/div[1]/ul/li/span"));
        for (WebElement month:list_month)
        {
            String ActualMonth = month.getText();
            if (ActualMonth.equalsIgnoreCase("January")){
                month.click();
                System.out.println("selected January");
                break;
            }

        }

        //year selector
        driver.findElement(By.xpath("(//div[@class='picker__calendar-container'])[1]/div/div[2]")).click();
        Thread.sleep(10000);
        List<WebElement> list_year = driver.findElements(By.xpath("(//div[@class='picker__calendar-container'])[1]/div/div[2]/ul/li/span"));

        for( WebElement year:list_year )
        {
            String ActualYear =year.getText();

            if(ActualYear.equalsIgnoreCase("1990")){
                year.click();
                System.out.println("Selected the year as 1990");
                break;
            }
        }

        //date selector
        Thread.sleep(2000);
        List<WebElement> list_date = driver.findElements(By.xpath("(//div[@class='picker__calendar-container'])[1]/table/tbody/tr/td"));
        for(WebElement date:list_date)
        {   String ActualDate = date.getText();
            if(ActualDate.equalsIgnoreCase("23")){
                date.click();
                System.out.println("date is selected");
                break;
            }

        }


        driver.findElement(By.xpath("//div[contains(@id,'nation_code')]/div/input")).click();
        driver.findElement(By.xpath("//span[text()='Indian']")).click();
        System.out.println("Nationality selected as Indian");

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        System.out.println("Clicked on first save button");

        Boolean flag = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//html/body"),"Successfully Updated"));

        if(flag){
            System.out.println("Succesfully Updated");
        }else {
            System.out.println("Not Successful");
        }

        driver.findElement(By.xpath("//ul[@class='radiobutton-container']/li[1]")).click();
        System.out.println("Radio Button for NO is selected");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        System.out.println("Clicked on second save button");

        Boolean flag_1 = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//html/body"),"Successfully Updated"));

        if(flag_1){
            System.out.println("Succesfully Updated");
        }else {
            System.out.println("Not Successful");
        }


        for(int i=1;i<=3;++i){
            try{
                Thread.sleep(1000);
                driver.findElement(By.xpath("//div[@sf-array='form']/div[4]/label")).click();
                System.out.println("Dietary Requirements check-box Koshler is clicked");
                break;
            }catch(StaleElementReferenceException se){
                System.out.println("Stale Element Reference Exception is occurred for "+i+" time");
            }
        }

        for(int i=1;i<=3;++i){
            try{
                driver.findElement(By.xpath("//div[@sf-array='form']/div[5]/label")).click();
                System.out.println("Dietary Requirements check-box Vegeterian is clicked");
                break;
            }catch(StaleElementReferenceException se){
                System.out.println("Stale Element Reference Exception is occurred for "+i+" time");
            }
        }

        System.out.println("clicked on Kosher and Vegetarian check boxes");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        System.out.println("Clicked on second save button");

        Boolean flag_2 = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//html/body"),"Successfully Updated"));

        if(flag_2){
            System.out.println("Succesfully Updated");
        }else {
            System.out.println("Not Successful");
        }
        driver.quit();
        System.out.println("browser is closed");
    }

}























