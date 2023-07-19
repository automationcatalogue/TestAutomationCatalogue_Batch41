package testcases.PseudoTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class TC04_OrangeHRM_EditEmployee {

    public static void main(String args[]) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));


        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");


        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        System.out.println("Admin is entered as a UserName");

        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        //title verification
        String title = driver.getTitle();
        String ExpectedTitle = "Employee Management";
        if(title.equalsIgnoreCase(ExpectedTitle)){
            System.out.println("Login is Successful");
        }else{
            System.out.println("Login is Unsuccessful");
        }

        driver.findElement(By.xpath("//span[text()='Employee Management']")).click();
        System.out.println("Employee Management is selected");

        driver.findElement(By.xpath("//tr[contains(@ng-repeat,'employee.empNumber')][1]/td[2]")).click();
        System.out.println("Click on First Employee Data");

        driver.findElement(By.xpath("//a[contains(@ui-sref,'l_details')]")).click();
        System.out.println("Clicked on Personal Details tab");

        driver.findElement(By.xpath("//input[@id='lastName']")).clear();
        System.out.println("Cleared the last name");

        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Naidu");
        System.out.println("Updated the last name");

        driver.findElement(By.xpath("(//i[contains(@class,'material-icons action')])[1]")).click();
        System.out.println("Date picker icon is clicked");

        String date = "23-January-1990";
        String date_Array[]=date.split("-");
        String day=date_Array[0];
        String month=date_Array[1];
        String year=date_Array[2];

        //month selector
        driver.findElement(By.xpath("//div[contains(@class,'--month')]")).click();
        //Thread.sleep(5000);
        List<WebElement> list_month = driver.findElements(By.xpath("//div[contains(@class,'--month')]//li/span"));
        for (WebElement mon:list_month)
        {
            String ActualMonth = mon.getText();
            if (ActualMonth.equalsIgnoreCase(month)){
                mon.click();
                System.out.println("selected"+month);
                break;
            }
        }

        //year selector
        driver.findElement(By.xpath("//div[contains(@class,'select--year')]")).click();
        //Thread.sleep(10000);
        List<WebElement> list_years = driver.findElements(By.xpath("//div[contains(@class,'select--year')]//li/span"));
        for( WebElement year_1:list_years )
        {
            String ActualYear =year_1.getText();
            if(ActualYear.equalsIgnoreCase(year)){
                year_1.click();
                System.out.println("Selected the year as "+year);
                break;
            }
        }

        //date selector
        //Thread.sleep(2000);
        List<WebElement> list_date = driver.findElements(By.xpath("(//table[@class='picker__table'])[1]//td"));
        for(WebElement dt:list_date)
        {   String ActualDate = dt.getText();
            if(ActualDate.equalsIgnoreCase(day)){
                dt.click();
                System.out.println("date is selected as"+day);
                break;
            }
        }
        driver.findElement(By.xpath("//div[contains(@id,'nation_code')]/div/input")).click();
        driver.findElement(By.xpath("//span[text()='Indian']")).click();
        System.out.println("Nationality selected as Indian");

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        System.out.println("Clicked on first save button");

        Boolean isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//html/body"),"Successfully Updated"));
        if(isSuccessful){
            System.out.println("Successfully Updated");
        }else {
            System.out.println("Not Successful");
        }

        driver.findElement(By.xpath("//ul[@class='radiobutton-container']/li[1]")).click();
        System.out.println("Radio Button for NO is selected");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        System.out.println("Clicked on Hygiene save button");

        Boolean hygiene_isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//html/body"),"Successfully Updated"));
        if(hygiene_isSuccessful){
            System.out.println("Hygiene is Successfully Updated");
        }else {
            System.out.println("Hygiene is not Successful Updated");
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
        System.out.println("Clicked on Dietary Requirements save button");

        Boolean Dietary_isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//html/body"),"Successfully Updated"));

        if(Dietary_isSuccessful){
            System.out.println("Dietary Requirements are successfully Updated");
        }else {
            System.out.println("Dietary Requirements are not successfully Updated");
        }

        //Logout
        driver.findElement(By.xpath("//li[@id='navbar-logout']")).click();
        System.out.println("Clicked on Log out Button");

        driver.quit();
        System.out.println("browser is closed");
    }

}























