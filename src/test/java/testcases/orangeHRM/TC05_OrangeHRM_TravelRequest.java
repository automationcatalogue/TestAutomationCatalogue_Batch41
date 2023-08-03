package testcases.orangeHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseClass;
import utilities.CommonUtils;

import java.time.Duration;
import java.util.List;

public class TC05_OrangeHRM_TravelRequest {

    @Test
    @Parameters({"browserName"})
    public void addEmployee(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch("Chrome");
        BaseClass ob = new BaseClass(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys("Admin");
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Logged in as Admin");


        //title verification
        String actual_title = driver.getTitle();
        String expected_title = "Employee Management";
        if (actual_title.equalsIgnoreCase(expected_title)) {
            System.out.println("Title is verified");

        } else {
            System.out.println("Title is not verified");
        }

        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();
        System.out.println("HR Administration is selected");

        driver.findElement(OrangeHRM_HRAdministrationPage.link_users).click();
        System.out.println("clicked on Users button");

        String userName = driver.findElement(OrangeHRM_UsersPage.link_firstUserName).getText();
        System.out.println("First UserName from the Users List is :" + userName);

        driver.findElement(OrangeHRM_UsersPage.icon_edit).click();
        System.out.println("Clicked on edit button");

        driver.findElement(OrangeHRM_UsersPage.chkbx_changePassword).click();
        System.out.println("change password check  box is selected");

        driver.findElement(OrangeHRM_UsersPage.txtbx_enterPassword).sendKeys("Admin@123");
        System.out.println("entered the new password");

        driver.findElement(OrangeHRM_UsersPage.txtbx_confirmPassword).sendKeys("Admin@123");
        System.out.println("re-entered the new password");

        driver.findElement(OrangeHRM_UsersPage.btn_save).click();
        System.out.println("Clicked on Save");

        WebElement emp_mgmt = driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement);
        js.executeScript("arguments[0].click();", emp_mgmt);
        driver.findElement(OrangeHRM_EmployeeManagementPage.link_EmployeeList).click();

        String supervisor_name = null;
        List<WebElement> emp_namesList = driver.findElements(OrangeHRM_EmployeeManagementPage.list_employee);

        for (WebElement employee_name : emp_namesList) {
            String actual_empname = employee_name.getText();
            if (actual_empname.equalsIgnoreCase("Aaliyah Haq")) {
                supervisor_name = employee_name.findElement(OrangeHRM_EmployeeManagementPage.txt_supervisorName).getText();
                System.out.println("Supervisor name is :" + supervisor_name);
                break;
            }
        }
        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();
        System.out.println("HR Administration is selected");

        driver.findElement(OrangeHRM_HRAdministrationPage.link_users).click();
        System.out.println("clicked on Users button");

        List<WebElement> sup_name = driver.findElements(OrangeHRM_UsersPage.list_users);

        for (WebElement supervisor : sup_name) {
            String currentSupervisorName = supervisor.getText();
            if (currentSupervisorName.equalsIgnoreCase(supervisor_name)) {
                supervisor.findElement(OrangeHRM_UsersPage.btn_edit).click();
                System.out.println("Clicked on Edit button");

                WebElement changepswd_chkbox = driver.findElement(OrangeHRM_UsersPage.chkbx_changePassword);
                js.executeScript("arguments[0].click();", changepswd_chkbox);
                driver.findElement(OrangeHRM_UsersPage.txtbx_enterPassword).sendKeys("Admin@123");
                driver.findElement(OrangeHRM_UsersPage.txtbx_confirmPassword).sendKeys("Admin@123");
                driver.findElement(OrangeHRM_UsersPage.btn_save).click();
                System.out.println("Supervisor's username and password is updated.");
            }
        }

        WebElement save = driver.findElement(OrangeHRM_LogoutPage.btn_logout);
        js.executeScript("arguments[0].click();", save);
        System.out.println("Clicked on log out");

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys(userName);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Logged into " + userName + " portal");

        WebElement travelexp_Element = driver.findElement(OrangeHRM_HomePage.link_travelandExpense);
        travelexp_Element.click();
        js.executeScript("arguments[0].click;", travelexp_Element);
        System.out.println("Travel and Expense is selected");

        WebElement element_iframe = driver.findElement(OrangeHRM_TravelExpensePage.switchto_Iframe);
        driver.switchTo().frame(element_iframe);

        driver.findElement(OrangeHRM_TravelExpensePage.btn_travelRequestAdd).click();
        System.out.println("Add button is selected to submit travel expense");

        driver.findElement(OrangeHRM_TravelExpensePage.drpdown_Currency).click();
        driver.findElement(OrangeHRM_TravelExpensePage.currency_CADOption).click();
        driver.findElement(OrangeHRM_TravelExpensePage.btn_next).click();
        System.out.println("Clicked on currency drop-down and selected CAD and submitted");

        driver.findElement(OrangeHRM_TravelExpensePage.btn_addTravelInfo).click();
        driver.findElement(OrangeHRM_TravelExpensePage.txtbx_destination).sendKeys("NewYork");

        String from_date = "3-June-2022";
        String from_calender[] = from_date.split("-");
        String from_day = from_calender[0];
        String from_month = from_calender[1];
        String from_year = from_calender[2];

        driver.findElement(OrangeHRM_TravelExpensePage.Calender_travelFrom).click();
        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_monthFrom).click();

        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_monthsFrom,from_month);

        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_yearFrom).click();
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_yearsFrom,from_year);

        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_daysFrom, from_day);

        String toDate = "10-June-2022";
        String toCalendar[] = toDate.split("-");
        String toDay = toCalendar[0];
        String toMonth = toCalendar[1];
        String toYear = toCalendar[2];

        WebElement element_TravelPeriodTo = driver.findElement(OrangeHRM_TravelExpensePage.Calender_travelTo);
        js.executeScript("arguments[0].click();",element_TravelPeriodTo);
        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_monthTo).click();

        List<WebElement> toMonth_list = driver.findElements(OrangeHRM_TravelExpensePage.list_monthsTo);
        for (WebElement toMonth_option : toMonth_list) {
            String toActual_month = toMonth_option.getText();
            if (toActual_month.equalsIgnoreCase(toMonth)) {
                toMonth_option.click();
                System.out.println("Month is selected from the TO drop-down");
                break;
            }
        }

        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_yearTo).click();
        List<WebElement> toYearList = driver.findElements(OrangeHRM_TravelExpensePage.list_yearsTo);
        for (WebElement toYearOption : toYearList) {
            String toActualYear = toYearOption.getText();
            if (toActualYear.equalsIgnoreCase(toYear)) {
                toYearOption.click();
                System.out.println("Year is selected from the TO Drop-down");
                break;
            }
        }

        List<WebElement> todayList = driver.findElements(OrangeHRM_TravelExpensePage.list_daysTo);
        for (WebElement toDayOption : todayList) {
            String toActualDay = toDayOption.getText();
            if (toActualDay.equalsIgnoreCase(toDay)) {
                toDayOption.click();
                System.out.println("Day is selected ");
                break;
            }
        }

        driver.findElement(OrangeHRM_TravelExpensePage.btn_saveTravelReq).click();
        System.out.println("clicked on travel information save button");

        driver.findElement(OrangeHRM_TravelExpensePage.btn_addTravelReqEstimate).click();
        System.out.println("clicked on Add expense button");

        driver.findElement(OrangeHRM_TravelExpensePage.dropdown_expenseType).click();
        driver.findElement(OrangeHRM_TravelExpensePage.ExpType_airfare).click();
        System.out.println("Airfare is selected");

        for (int count = 1; count <= 3; ++count) {
            try {
                WebElement element_Currency = driver.findElement(OrangeHRM_TravelExpensePage.dropdown_currencyPaidin);
                js.executeScript("arguments[0].click();", element_Currency);
                System.out.println("Currency drop-down is clicked");
                break;
            } catch (StaleElementReferenceException e) {

                System.out.println("Stale Element Reference Exception is occurred for " + count + " time.");
            }
        }

        wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_TravelExpensePage.currencyPaidin_CAD, "CAD - Canadian Dollar"));
        driver.findElement(OrangeHRM_TravelExpensePage.currencyPaidin_CAD).click();
        System.out.println("Currency is selected");

        driver.findElement(OrangeHRM_TravelExpensePage.textbox_amount).sendKeys("2500");
        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_paidBy).click();
        driver.findElement(OrangeHRM_TravelExpensePage.paidby_staff).click();
        System.out.println("paid by is selected");


        WebElement save_expense = driver.findElement(OrangeHRM_TravelExpensePage.btn_saveTravelExpEst);
        js.executeScript("arguments[0].click();", save_expense);
        System.out.println("Clicked on save button");

        WebElement submit = driver.findElement(OrangeHRM_TravelExpensePage.btn_submit);
        js.executeScript("arguments[0].click();", submit);
        System.out.println("Submitted the expense");

        WebElement ok = driver.findElement(OrangeHRM_TravelExpensePage.btn_oktoConfirm);
        js.executeScript("arguments[0].click();", ok);
        System.out.println("Confirmed the submit");

        WebElement arrow_back = driver.findElement(OrangeHRM_TravelExpensePage.navLink_backarrow);
        js.executeScript("arguments[0].click();", arrow_back);
        System.out.println("Clicked on arrow back");

        WebElement requestElement = driver.findElement(OrangeHRM_TravelExpensePage.list_travelReqId);
        String request_id = requestElement.getText();
        System.out.println("Travel Request ID :" + request_id);

        WebElement statusElement = driver.findElement(OrangeHRM_TravelExpensePage.list_reqStatus);
        String status = statusElement.getText();
        System.out.println("Request status is :" + status);

        if (status.equalsIgnoreCase("Pending Supervisor Approval")) {
            System.out.println("Request status is :" + status);
        } else {
            System.out.println("Incorrect request status");
        }

        WebElement logout = driver.findElement(OrangeHRM_LogoutPage.btn_logout);
        js.executeScript("arguments[0].click();", logout);
        System.out.println("Clicked on log out");

        driver.switchTo().defaultContent();

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys("Brody");
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Logged in to Brody's Account");

        WebElement element_travelexp = driver.findElement(OrangeHRM_HomePage.link_travelandExpense);
        element_travelexp.click();
        js.executeScript("arguments[0].click();", element_travelexp);
        System.out.println("Travel and Expense is selected");
        Thread.sleep(5000);
        element_iframe = driver.findElement(OrangeHRM_TravelExpensePage.switchto_Iframe);
        driver.switchTo().frame(element_iframe);

        List<WebElement> travel_request_id = driver.findElements(OrangeHRM_TravelExpensePage.list_travelReqId);

        for (WebElement req_id : travel_request_id) {
            String id = req_id.getText();

            if (id.equalsIgnoreCase(request_id)) {
                System.out.println("Travel Request ID :" + request_id);
                req_id.click();
                System.out.println("clicked on Travel req id ");
                break;
            }
        }

        driver.findElement(OrangeHRM_TravelExpensePage.btn_approve).click();
        System.out.println("Approved the Expense request");
        driver.findElement(OrangeHRM_TravelExpensePage.btn_oktoConfirm).click();
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Clicked on log out");
        driver.switchTo().defaultContent();

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys("aaliyah.haq");
        System.out.println("aaliyah.haq is entered as a UserName");

        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Login button is clicked");

        WebElement element_travelexp1 = driver.findElement(OrangeHRM_HomePage.link_travelandExpense);
        element_travelexp1.click();

        WebElement element_travelreqid = driver.findElement(OrangeHRM_TravelExpensePage.switchto_Iframe);
        driver.switchTo().frame(element_travelreqid);
        String travelreqid = driver.findElement(OrangeHRM_TravelExpensePage.list_travelReqId).getText();
        System.out.println("Travel Request ID :" + travelreqid);

        WebElement element_reqstatus = driver.findElement(OrangeHRM_TravelExpensePage.list_reqStatus);
        String updated_status = element_reqstatus.getText();
        System.out.println("Request status is :" + updated_status);

        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Clicked on log out");
        driver.switchTo().defaultContent();

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys("Admin");
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Entered the user name as admin and password as Admin@123 and logged in to the Admin portal");

        WebElement travelexp_Element1 = driver.findElement(OrangeHRM_HomePage.link_travelandExpense);
        travelexp_Element1.click();
        js.executeScript("arguments[0].click;", travelexp_Element1);
        System.out.println("Travel and Expense is selected");

        WebElement element_travelreqid2 = driver.findElement(OrangeHRM_TravelExpensePage.switchto_Iframe);
        driver.switchTo().frame(element_travelreqid2);

        List<WebElement> updated_reqid = driver.findElements(OrangeHRM_TravelExpensePage.list_travelReqId);

        for (WebElement updated_req_id : updated_reqid) {
            String updated_id = updated_req_id.getText();

            if (updated_id.equalsIgnoreCase(request_id)) {
                System.out.println("Travel Request ID :" + request_id);
                updated_req_id.click();
                break;
            }
        }
        System.out.println("clicked on Travel req id ");
        driver.findElement(OrangeHRM_TravelExpensePage.btn_approve).click();
        System.out.println("Approved the Expense request");
        driver.findElement(OrangeHRM_TravelExpensePage.btn_oktoConfirm).click();
        System.out.println("Clicked on OK");
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Clicked on log out");
        driver.switchTo().defaultContent();

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys("aaliyah.haq");
        System.out.println("aaliyah.haq is entered as a UserName");

        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Login button is clicked");

        WebElement element_travelexp2 = driver.findElement(OrangeHRM_HomePage.link_travelandExpense);
        element_travelexp2.click();
        System.out.println("Clicked on Travel and expense");

        WebElement element_travelreqid3 = driver.findElement(OrangeHRM_TravelExpensePage.switchto_Iframe);
        driver.switchTo().frame(element_travelreqid3);

        List<WebElement> final_statusList = driver.findElements(OrangeHRM_TravelExpensePage.list_travelReqId);
        for (WebElement final_idElement : final_statusList) {
            String final_id = final_idElement.getText();
            if (final_id.equalsIgnoreCase(request_id)) {
                System.out.println("Approved request id is " + request_id);
                String final_Status = final_idElement.findElement(OrangeHRM_TravelExpensePage.list_reqStatus).getText();
                System.out.println("Final status of the request is " + final_Status);
                break;
            }
        }
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Clicked on log out");

    }

}
