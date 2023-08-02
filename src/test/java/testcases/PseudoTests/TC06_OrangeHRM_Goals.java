package testcases.PseudoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class TC06_OrangeHRM_Goals {
    public void OrangeHRM_Goals() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
   /*     WebElement UserName_Element = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement PassWord_Element = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement Submit_Element = driver.findElement(By.xpath("//button[@type='submit']"));

        UserName_Element.sendKeys("Admin");
        PassWord_Element.sendKeys("Admin@123");
        Submit_Element.click();
        String employee_name = "Aaliyah Haq";
        String Actual_UserName = null;
        driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]")).click();

        //Finding Username of Employee
        List<WebElement> userName_List = driver.findElements(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[4]"));
        for (WebElement userName : userName_List) {
            String Name = userName.getText();
            if (Name.equalsIgnoreCase(employee_name)) {
                userName.findElement(By.xpath(".//following-sibling::td[4]")).click();
                WebElement Username_Element = driver.findElement(By.xpath("//input[@id='user_name']"));
                Actual_UserName = (String) js.executeScript("return arguments[0].value", Username_Element);
                System.out.println(Actual_UserName);
                driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
            }
        }
        //Finding Supervisor name
        driver.findElement(By.xpath("(//a[@data-tooltip='Employee Management'])[1]")).click();
        System.out.println("Clicked on the Employee Management");
        String supervisor_name = null;
        List<WebElement> employee_List = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]"));
        for (WebElement employee_Ref : employee_List) {
            String employee = employee_Ref.getText();
            if (employee.equalsIgnoreCase(employee_name)) {
                supervisor_name = employee_Ref.findElement(By.xpath(".//following-sibling::td[6]")).getText();
                System.out.println(supervisor_name);
            }
        }
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Clicked on Log Out Button");

        //Logging in with the Employee Username
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Actual_UserName);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//span[text()='More']")).click();
        driver.findElement(By.xpath("(//a[@data-tooltip='Performance'])[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'space')]/top-level-menu-item[3]/div/a")).click();
        driver.findElement(By.xpath("//a[contains(@data-automation-id,'myGoals')]")).click();
        System.out.println("Clicked on My Goals");


        //First goal
        driver.findElement(By.xpath("//span[text()='Create Goal']")).click();
        driver.findElement(By.cssSelector("#name_value")).sendKeys("Automation for E-Commerce Website");

        WebElement iframe_goal1 = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
        driver.switchTo().frame(iframe_goal1);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Automate the Payment Gateways for all bank debit cards and credit cards after applying promo codes");
        driver.switchTo().defaultContent();

        Select select_goal1 = new Select(driver.findElement(By.cssSelector("#goalPriority")));
        select_goal1.selectByVisibleText("Low");

        driver.findElement(By.xpath("//i[text()='date_range']")).click();

        String date_goal1 = "23-September-2023";
        String date_ArrayGoal1[] = date_goal1.split("-");
        String day_goal1 = date_ArrayGoal1[0];
        String month_goal1 = date_ArrayGoal1[1];
        String year_goal1 = date_ArrayGoal1[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal1 = new Select(driver.findElement(By.xpath("//select[@title='Select a month']")));
        select_MonthGoal1.selectByVisibleText(month_goal1);
        System.out.println("month is selected");

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal1 = new Select(driver.findElement(By.xpath("//select[@title='Select a year']")));
        select_YearGoal1.selectByVisibleText(year_goal1);
        System.out.println("year is selected");

        //date selector
        Thread.sleep(2000);
        List<WebElement> list_dateGoal1 = driver.findElements(By.xpath("//table[@class='picker__table']/tbody/tr/td/div"));
        for (WebElement dt_goal1 : list_dateGoal1) {
            String ActualDate_Goal1 = dt_goal1.getText();
            if (ActualDate_Goal1.equalsIgnoreCase(day_goal1)) {
                dt_goal1.click();
                System.out.println("date is selected");
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='form-row form-buttons-row']/div[3]/button")).click();
        System.out.println("Submit button is clicked");

        driver.findElement(By.xpath("//a[@data-tooltip='My Goals']")).click();
        System.out.println("clicked on the back arrow link");

        //Second goal
        driver.findElement(By.xpath("//span[text()='Create Goal']")).click();
        driver.findElement(By.cssSelector("#name_value")).sendKeys("Automation for Telecom Website");

        WebElement iframe_goal2 = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
        driver.switchTo().frame(iframe_goal2);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Automate the new customer entries in the server and check the activation of the user");
        driver.switchTo().defaultContent();

        Select select_goal2 = new Select(driver.findElement(By.cssSelector("#goalPriority")));
        select_goal2.selectByVisibleText("High");

        driver.findElement(By.xpath("//i[text()='date_range']")).click();

        String date_goal2 = "28-January-2024";
        String date_ArrayGoal2[] = date_goal2.split("-");
        String day_goal2 = date_ArrayGoal2[0];
        String month_goal2 = date_ArrayGoal2[1];
        String year_goal2 = date_ArrayGoal2[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal2 = new Select(driver.findElement(By.xpath("//select[@title='Select a month']")));
        select_MonthGoal2.selectByVisibleText(month_goal2);
        System.out.println("month is selected");

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal2 = new Select(driver.findElement(By.xpath("//select[@title='Select a year']")));
        select_YearGoal2.selectByVisibleText(year_goal2);
        System.out.println("year is selected");

        //date selector
        Thread.sleep(2000);
        List<WebElement> list_dateGoal2 = driver.findElements(By.xpath("//table[@class='picker__table']/tbody/tr/td/div"));
        for (WebElement dt_goal2 : list_dateGoal2) {
            String ActualDate_goal2 = dt_goal2.getText();
            if (ActualDate_goal2.equalsIgnoreCase(day_goal2)) {
                dt_goal2.click();
                System.out.println("date is selected");
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='form-row form-buttons-row']/div[3]/button")).click();
        System.out.println("Submit button is clicked");

        driver.findElement(By.xpath("//a[@data-tooltip='My Goals']")).click();
        System.out.println("clicked on the back arrow link");


        //Third goal
        driver.findElement(By.xpath("//span[text()='Create Goal']")).click();
        driver.findElement(By.cssSelector("#name_value")).sendKeys("Automation for Fiancial Website");

        WebElement iframe_goal3 = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
        driver.switchTo().frame(iframe_goal3);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Automate the new customer entries with the valid account numbers and other account details");
        driver.switchTo().defaultContent();

        Select select_goal3 = new Select(driver.findElement(By.cssSelector("#goalPriority")));
        select_goal3.selectByVisibleText("Medium");

        driver.findElement(By.xpath("//i[text()='date_range']")).click();

        String date_goal3 = "12-March-2024";
        String date_ArrayGoal3[] = date_goal3.split("-");
        String day_goal3 = date_ArrayGoal3[0];
        String month_goal3 = date_ArrayGoal3[1];
        String year_goal3 = date_ArrayGoal3[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal3 = new Select(driver.findElement(By.xpath("//select[@title='Select a month']")));
        select_MonthGoal3.selectByVisibleText(month_goal3);
        System.out.println("month is selected");

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal3 = new Select(driver.findElement(By.xpath("//select[@title='Select a year']")));
        select_YearGoal3.selectByVisibleText(year_goal3);
        System.out.println("year is selected");

        //date selector
        Thread.sleep(2000);
        List<WebElement> list_dateGoal3 = driver.findElements(By.xpath("//table[@class='picker__table']/tbody/tr/td/div"));
        for (WebElement dt_goal3 : list_dateGoal3) {
            String ActualDate_goal3 = dt_goal3.getText();
            if (ActualDate_goal3.equalsIgnoreCase(day_goal3)) {
                dt_goal3.click();
                System.out.println("date is selected");
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='form-row form-buttons-row']/div[3]/button")).click();
        System.out.println("Submit button is clicked");

        driver.findElement(By.xpath("//a[@data-tooltip='My Goals']")).click();
        System.out.println("clicked on the back arrow link");

        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Clicked on Log Out Button");

        //Supervisor's username
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        String supervisor_ActualUserName = null;
        driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]")).click();

        //Finding Username of Employee
        List<WebElement> supervisorUserName_List = driver.findElements(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[4]"));
        for (WebElement supervisorName : supervisorUserName_List) {
            String name = supervisorName.getText();
            if (name.equalsIgnoreCase(supervisor_name)) {
                supervisorName.findElement(By.xpath(".//following-sibling::td[4]")).click();
                WebElement SupervisorUsername_Element = driver.findElement(By.xpath("//input[@id='user_name']"));
                supervisor_ActualUserName = (String) js.executeScript("return arguments[0].value", SupervisorUsername_Element);
                System.out.println(supervisor_ActualUserName);
                driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
            }
        }
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Clicked on Log Out Button");*/

       // driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(supervisor_ActualUserName);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("brody");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Goal List");
        driver.findElement(By.xpath("//div[text()='Goal List']")).click();
    }
}