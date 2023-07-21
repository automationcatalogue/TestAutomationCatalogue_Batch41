package testcases.PseudoTests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TC05_OrangeHRM_TravelRequest{

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Logged in as admin");

        //title verification
        String actual_title = driver.getTitle();
        String expected_title = "Employee Management";
        if (actual_title.equalsIgnoreCase(expected_title)) {
            System.out.println("Title is verified");

        } else {
            System.out.println("Title is not verified");
        }

        driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]")).click();
        System.out.println("HR Administration is selected");

        driver.findElement(By.xpath("//a[text()='Users ']")).click();
        System.out.println("clicked on Users button");

        String userName = driver.findElement(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]/td[2]//span")).getText();
        System.out.println("First UserName from the Users List is :" + userName);

        driver.findElement((By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]//i"))).click();
        System.out.println("Clicked on edit button");

        driver.findElement((By.xpath("//span[text()='Change Password']"))).click();
        System.out.println("change password check  box is selected");

        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Admin@123");
        System.out.println("entered the new password");

        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Admin@123");
        System.out.println("re-entered the new password");

        driver.findElement((By.xpath("//button[text()='Save']"))).click();
        System.out.println("Clicked on Save");

        WebElement emp_mgmt = driver.findElement(By.xpath("(//a[@data-tooltip='Employee Management'])[1]"));
        js.executeScript("arguments[0].click();", emp_mgmt);
        driver.findElement(By.xpath("//a[text()='Employee List ']")).click();

        String supervisor_name = null;
        List<WebElement> emp_namesList = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]"));

        for (WebElement employee_name : emp_namesList) {
            String actual_empname = employee_name.getText();
            if (actual_empname.equalsIgnoreCase("Aaliyah Haq")) {
                supervisor_name = employee_name.findElement(By.xpath(".//following-sibling::td[6]")).getText();
                System.out.println("Supervisor name is :" + supervisor_name);
                break;
            }
        }
        driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]")).click();
        System.out.println("HR Administration is selected");

        driver.findElement(By.xpath("//a[text()='Users ']")).click();
        System.out.println("clicked on Users button");

        List<WebElement> sup_name = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr/td[4]"));

        for (WebElement supervisor : sup_name) {
            String currentSupervisorName = supervisor.getText();
            if (currentSupervisorName.equalsIgnoreCase(supervisor_name)) {
                supervisor.findElement(By.xpath(".//following-sibling::td[4]")).click();
                System.out.println("Clicked on Edit button");

                WebElement changepswd_chkbox = driver.findElement(By.cssSelector("#changepassword"));
                js.executeScript("arguments[0].click();", changepswd_chkbox);
                driver.findElement(By.cssSelector("#password")).sendKeys("Admin@123");
                driver.findElement(By.cssSelector("#confirmpassword")).sendKeys("Admin@123");
                driver.findElement(By.cssSelector("#modal-save-button")).click();
                System.out.println("Supervisor's username and password is updated.");
            }
        }

        WebElement save = driver.findElement(By.xpath("//a[@href='/auth/logout']/span"));
        js.executeScript("arguments[0].click();", save);
        System.out.println("Clicked on log out");

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(userName);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Logged into " + userName + " portal");

        WebElement travelexp_Element = driver.findElement(By.xpath("(//a[@data-tooltip='Travel and Expense'])[1]"));
        travelexp_Element.click();
        js.executeScript("arguments[0].click;", travelexp_Element);
        System.out.println("Travel and Expense is selected");

        WebElement element_iframe = driver.findElement(By.xpath("//iframe[@id='noncoreIframe']"));
        driver.switchTo().frame(element_iframe);

        driver.findElement(By.xpath("//a[@data-tooltip='Submit Travel Request']")).click();
        System.out.println("Add button is selected to submit travel expense");

        driver.findElement(By.xpath("//label[contains(@for,'localCurrency')]/../div/input")).click();
        driver.findElement(By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='CAD - Canadian Dollar']")).click();
        driver.findElement(By.xpath("//a[text()='Next']")).click();
        System.out.println("Clicked on currency drop-down and selected CAD and submitted");

        driver.findElement(By.xpath("//button[@id='addTravelInformationBtn']")).click();
        driver.findElement(By.xpath("//input[@aria-required='true']")).sendKeys("NewYork");

        String from_date = "3-June-2022";
        String from_calender[] = from_date.split("-");
        String from_day = from_calender[0];
        String from_month = from_calender[1];
        String from_year = from_calender[2];

        driver.findElement(By.xpath("//input[contains(@name,'[travel_period_from]')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'picker__select--month')]")).click();

        List<WebElement> fromMonth_list = driver.findElements(By.xpath("//div[contains(@class,'picker__select--month')]/ul/li/span"));
        for (WebElement fromMonthOption : fromMonth_list) {
            String actualFrom_month = fromMonthOption.getText();
            if (actualFrom_month.equalsIgnoreCase(from_month)) {
                fromMonthOption.click();
                System.out.println("Month is selected from the FROM drop-down");
                break;
            }
        }

        driver.findElement(By.xpath("//div[contains(@class,'picker__select--year')]")).click();
        List<WebElement> fromYear_list = driver.findElements(By.xpath("//div[contains(@class,'picker__select--year')]/ul/li/span"));

        for (WebElement fromYear_option : fromYear_list) {
            String fromActual_year = fromYear_option.getText();
            if (fromActual_year.equalsIgnoreCase(from_year)) {
                fromYear_option.click();
                System.out.println("Year is selected from the FROM Drop-down");
                break;
            }
        }

        List<WebElement> fromDay_list = driver.findElements(By.xpath("(//table[@class='picker__table'])[2]/tbody/tr/td/div"));
        for (WebElement fromDay_option : fromDay_list) {
            String fromActual_day = fromDay_option.getText();
            if (fromActual_day.equalsIgnoreCase(from_day)) {
                fromDay_option.click();
                System.out.println("Day is selected ");
                break;
            }
        }

        String toDate = "10-June-2022";
        String toCalendar[] = toDate.split("-");
        String toDay = toCalendar[0];
        String toMonth = toCalendar[1];
        String toYear = toCalendar[2];

        WebElement element_TravelPeriodTo = driver.findElement(By.xpath("//input[contains(@name,'[travel_period_to]')]"));
        js.executeScript("arguments[0].click();",element_TravelPeriodTo);
        driver.findElement(By.xpath("(//div[contains(@class,'picker__select--month')])[2]")).click();

        List<WebElement> toMonth_list = driver.findElements(By.xpath("(//div[contains(@class,'picker__select--month')])[2]/ul/li/span"));
        for (WebElement toMonth_option : toMonth_list) {
            String toActual_month = toMonth_option.getText();
            if (toActual_month.equalsIgnoreCase(toMonth)) {
                toMonth_option.click();
                System.out.println("Month is selected from the TO drop-down");
                break;
            }
        }

        driver.findElement(By.xpath("(//div[contains(@class,'picker__select--year')])[2]")).click();
        List<WebElement> toYearList = driver.findElements(By.xpath("(//div[contains(@class,'picker__select--year')])[2]/ul/li/span"));
        for (WebElement toYearOption : toYearList) {
            String toActualYear = toYearOption.getText();
            if (toActualYear.equalsIgnoreCase(toYear)) {
                toYearOption.click();
                System.out.println("Year is selected from the TO Drop-down");
                break;
            }
        }

        List<WebElement> todayList = driver.findElements(By.xpath("//table[contains(@id,'travel_period_to_table')]/tbody/tr/td"));
        for (WebElement toDayOption : todayList) {
            String toActualDay = toDayOption.getText();
            if (toActualDay.equalsIgnoreCase(toDay)) {
                toDayOption.click();
                System.out.println("Day is selected ");
                break;
            }
        }

        driver.findElement(By.xpath("//a[@id='travelInformationSave']")).click();
        System.out.println("clicked on travel information save button");

        driver.findElement(By.xpath("//button[@id='addExpenseTypeBtn']")).click();
        System.out.println("clicked on Add expense button");

        driver.findElement(By.xpath("//label[text()='Expense Types']/../div/input")).click();
        driver.findElement(By.xpath("//label[text()='Expense Types']/../div/ul/li[2]/span")).click();
        System.out.println("Airfare is selected");

        for (int count = 1; count <= 3; ++count) {
            try {
                WebElement element_Currency = driver.findElement(By.xpath("//label[@for='estimation_currency_id']//following-sibling::div/input"));
                js.executeScript("arguments[0].click();", element_Currency);
                System.out.println("Currency drop-down is clicked");
                break;
            } catch (StaleElementReferenceException e) {

                System.out.println("Stale Element Reference Exception is occurred for " + count + " time.");
            }
        }

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@for='estimation_currency_id']//following-sibling::div/ul//span[text()='CAD - Canadian Dollar']"), "CAD - Canadian Dollar"));
        driver.findElement(By.xpath("//label[@for='estimation_currency_id']//following-sibling::div/ul//span[text()='CAD - Canadian Dollar']")).click();
        System.out.println("Currency is selected");

        driver.findElement(By.xpath("//label[@for='estimation_amount']/../input")).sendKeys("2500");
        driver.findElement(By.xpath("//label[@for='estimation_amount']/../../div[3]/div")).click();
        driver.findElement(By.xpath("//label[text()='Paid By']/..//ul/li[2]/span[text()='Staff']")).click();
        System.out.println("paid by is selected");


        WebElement save_expense = driver.findElement(By.cssSelector("#formSave"));
        js.executeScript("arguments[0].click();", save_expense);
        System.out.println("Clicked on save button");

        WebElement submit = driver.findElement(By.xpath("//a[text()='Submit']"));
        js.executeScript("arguments[0].click();", submit);
        System.out.println("Submitted the expense");

        WebElement ok = driver.findElement(By.xpath("//a[text()='OK']"));
        js.executeScript("arguments[0].click();", ok);
        System.out.println("Confirmed the submit");

        WebElement arrow_back = driver.findElement(By.xpath("//i[text()='arrow_back']"));
        js.executeScript("arguments[0].click();", arrow_back);
        System.out.println("Clicked on arrow back");

        WebElement requestElement = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a"));
        String request_id = requestElement.getText();
        System.out.println("Travel Request ID :" + request_id);

        WebElement statusElement = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]"));
        String status = statusElement.getText();
        System.out.println("Request status is :" + status);

        if (status.equalsIgnoreCase("Pending Supervisor Approval")) {
            System.out.println("Request status is :" + status);
        } else {
            System.out.println("Incorrect request status");
        }

        WebElement logout = driver.findElement(By.xpath("//span [text()='Log Out']"));
        js.executeScript("arguments[0].click();", logout);
        System.out.println("Clicked on log out");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Brody");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Logged in to Brody's Account");

        WebElement element_travelexp = driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[17]/a/span"));
        element_travelexp.click();
        js.executeScript("arguments[0].click();", element_travelexp);
        System.out.println("Travel and Expense is selected");
        Thread.sleep(5000);
        element_iframe = driver.findElement(By.xpath("//iframe[@id='noncoreIframe']"));
        driver.switchTo().frame(element_iframe);

        List<WebElement> travel_request_id = driver.findElements(By.xpath("//table[@id='resultTable']/tbody//td/a"));

        for (WebElement req_id : travel_request_id) {
            String id = req_id.getText();

            if (id.equalsIgnoreCase(request_id)) {
                System.out.println("Travel Request ID :" + request_id);
                req_id.click();
                System.out.println("clicked on Travel req id ");
                break;
            }
        }

        driver.findElement(By.xpath("//a[@status='Approve']")).click();
        System.out.println("Approved the Expense request");
        driver.findElement(By.xpath("//a[text()='OK']")).click();
        driver.findElement(By.xpath("//span [text()='Log Out']")).click();
        System.out.println("Clicked on log out");
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("aaliyah.haq");
        System.out.println("aaliyah.haq is entered as a UserName");

        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        WebElement element_travelexp1 = driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[14]/a[1]/span"));
        element_travelexp1.click();

        WebElement element_travelreqid = driver.findElement(By.xpath("//iframe[@id='noncoreIframe']"));
        driver.switchTo().frame(element_travelreqid);
        String travelreqid = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[2]")).getText();
        System.out.println("Travel Request ID :" + travelreqid);

        WebElement element_reqstatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[4]"));
        String updated_status = element_reqstatus.getText();
        System.out.println("Request status is :" + updated_status);

        driver.findElement(By.xpath("//span [text()='Log Out']")).click();
        System.out.println("Clicked on log out");
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Entered the user name as admin and password as Admin@123 and logged in to the Admin portal");

        WebElement travelexp_Element1 = driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[17]/a[1]/span"));
        travelexp_Element1.click();
        js.executeScript("arguments[0].click;", travelexp_Element1);
        System.out.println("Travel and Expense is selected");

        WebElement element_travelreqid2 = driver.findElement(By.xpath("//iframe[@id='noncoreIframe']"));
        driver.switchTo().frame(element_travelreqid2);

        List<WebElement> updated_reqid = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td/a"));

        for (WebElement updated_req_id : updated_reqid) {
            String updated_id = updated_req_id.getText();

            if (updated_id.equalsIgnoreCase(request_id)) {
                System.out.println("Travel Request ID :" + request_id);
                updated_req_id.click();
                break;
            }
        }
        System.out.println("clicked on Travel req id ");
        driver.findElement(By.xpath("//a[text()='Approve']")).click();
        System.out.println("Approved the Expense request");
        driver.findElement(By.xpath("//a[text()='OK']")).click();
        System.out.println("Clicked on OK");
        driver.findElement(By.xpath("//span [text()='Log Out']")).click();
        System.out.println("Clicked on log out");
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("aaliyah.haq");
        System.out.println("aaliyah.haq is entered as a UserName");

        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        WebElement element_travelexp2 = driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[14]/a[1]"));
        element_travelexp2.click();
        System.out.println("Clicked on Travel and expense");

        WebElement element_travelreqid3 = driver.findElement(By.xpath("//iframe[@id='noncoreIframe']"));
        driver.switchTo().frame(element_travelreqid3);

        List<WebElement> final_statusList = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a"));
        for (WebElement final_idElement : final_statusList) {
            String final_id = final_idElement.getText();
            if (final_id.equalsIgnoreCase(request_id)) {
                System.out.println("Approved request id is " + request_id);
                String final_Status = final_idElement.findElement(By.xpath("./..//following-sibling::td[2]")).getText();
                System.out.println("Final status of the request is " + final_Status);
                break;
            }
        }
        driver.findElement(By.xpath("//span [text()='Log Out']")).click();
        System.out.println("Clicked on log out");

    }

}
