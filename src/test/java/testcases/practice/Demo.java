package testcases.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Demo {

    @Test (priority = 1)
    public void orangeHRMLogin() throws Exception{


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(6000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Employee abcd";
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("OrangeHRM Login is successful");
        }else{
            System.out.println("OrangeHRM Login is not successful");
        }

        driver.quit();

    }

    @Test (priority = 3)
    public void addEmployee(){

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

    @Test (priority = 2)
    public void editEmployee() throws Exception{
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

    @Test (priority = -1)
    public void reorder() throws Exception{
        {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            driver.get("https://demowebshop.tricentis.com/");
            System.out.println("Demo website is loaded");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//a[@class='ico-login']")).click();
            System.out.println("Login link is clicked");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("aarosagarch@gmail.com");
            System.out.println("Email ID is entered");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin@123");
            System.out.println("Password is entered");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
            System.out.println("Login Button is cicked");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//div[@class='master-wrapper-content']//a[@class='account']")).click();
            System.out.println("Email Link is clicked");
            Thread.sleep(1000);

            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div/div[2]/ul/li[3]/a")).click();
            System.out.println("Order link is clicked");
            Thread.sleep(1000);

            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/div[2]/input")).click();
            System.out.println("Order details button is clicked");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@type='button'][@value='Re-order']")).click();
            System.out.println("Re-order button is clicked");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
            System.out.println("Check-box is clicked");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[@value='checkout']")).click();
            System.out.println("Checkout button is clicked");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
            System.out.println("Continue button is clicked under Billing Address");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
            System.out.println("Continue button is clicked under Shipping Address");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
            System.out.println("Continue button is clicked under Shipping Method");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
            System.out.println("Continue button is clicked under Payment Method");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
            System.out.println("Continue button is clicked under Payment Information");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
            System.out.println("Confirm button is clicked under Confirm Order");
            Thread.sleep(2000);

            driver.quit();

        }
    }
}
