package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseClass;
import utilities.CommonUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

public class TC05_OrangeHRM_TravelRequest {

    static FileInputStream fis;
    static XSSFWorkbook wbk;
    static XSSFSheet sht;
    static XSSFRow row;
    static XSSFCell username_cell, password_cell, newPassword_cell, employeeName_Cell;
    static XSSFCell currency_cell, destination_cell, travelFrom_cell, travelTO_cell, expenseType_cell, currencyPaidIn_cell, amount_cell, paidBy_cell, travelReqId_cell, reqStatus_cell;
    static String userName, pswd, newPassword, currency, destination, travelFrom, travelTo, expenseType, currencyPaidIn, paidBy, travelReqId, reqStatus;
    static String projectPath, employeeName;
    static FileOutputStream fos;
    static String amount;
    static String req_id;
    static String status;




    @BeforeClass
    public void prerequisite_setup() throws Exception {
        projectPath = System.getProperty("user.dir");
        fis = new FileInputStream(projectPath + "\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk = new XSSFWorkbook(fis);
        sht = wbk.getSheet("OrangeHRM_TravelExpense");
        row = sht.getRow(1);
        username_cell = row.getCell(3);
        userName = username_cell.getStringCellValue();
        password_cell = row.getCell(4);
        pswd = password_cell.getStringCellValue();
        newPassword_cell = row.getCell(5);
        newPassword = newPassword_cell.getStringCellValue();
        currency_cell = row.getCell(6);
        currency = currency_cell.getStringCellValue();
        destination_cell = row.getCell(7);
        destination = destination_cell.getStringCellValue();
        travelFrom_cell = row.getCell(8);
        travelFrom = travelFrom_cell.getStringCellValue();
        travelTO_cell = row.getCell(9);
        travelTo = travelTO_cell.getStringCellValue();
        expenseType_cell = row.getCell(10);
        expenseType = expenseType_cell.getStringCellValue();
        currencyPaidIn_cell = row.getCell(11);
        currencyPaidIn = currencyPaidIn_cell.getStringCellValue();
        amount_cell = row.getCell(12);
        amount = amount_cell.getStringCellValue();
        paidBy_cell = row.getCell(13);
        paidBy = paidBy_cell.getStringCellValue();
        employeeName_Cell = row.getCell(14);
        employeeName = employeeName_Cell.getStringCellValue();

    }


    @Test
    @Parameters({"browserName"})
    public void EditEmployee(@Optional("chrome") String browserName) throws Exception{
        WebDriver driver =CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        //logged in as admin
        OrangeHRM_LoginPage.login(userName,pswd);

        //title verification
        OrangeHRM_HomePage.verifyTitle();
        OrangeHRM_HomePage.clickHRAdministrationLink();
        OrangeHRM_HRAdministrationPage.clickOnUsersLink();

        //select a first employee from employee list and change password
        OrangeHRM_UsersPage.changeEmployeePassword(newPassword);

        // find supervisor of the employee *** should it return sup name???
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        OrangeHRM_EmployeeManagementPage.clickEmployeeList_getSupervisorName(employeeName);
        OrangeHRM_HomePage.clickHRAdministrationLink();
        OrangeHRM_HomePage.clickHRAdministrationLink();
        OrangeHRM_UsersPage.changeSupervisorPassword(newPassword,supervisor_name); // why are we passing two parameters
        OrangeHRM_LogoutPage.logout();

        //Login to Aliah's account, create and submit the travel request
        OrangeHRM_LoginPage.login_employee(userName, pswd);
        OrangeHRM_HomePage.clickTravelExp();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        OrangeHRM_TravelExpensePage.clickAddTravelExp();
        OrangeHRM_TravelExpensePage.selectcurrency(currency);
        OrangeHRM_TravelExpensePage.addTravelinfo();
        OrangeHRM_TravelExpensePage.destination(destination);
        OrangeHRM_TravelExpensePage.travelFrom(travelFrom);
        OrangeHRM_TravelExpensePage.travelto(travelTo);


        /*String from_date = "3-June-2022";
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

        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_monthsTo,toMonth);
        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_yearTo).click();
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_yearsTo,toYear);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_daysTo,toDay);
*/
        OrangeHRM_TravelExpensePage.saveTravelexp();
        OrangeHRM_TravelExpensePage.travelRequestEstimateAddBtn();
        OrangeHRM_TravelExpensePage.selectExpenseType(expenseType);
        OrangeHRM_TravelExpensePage.currency_paidin();// check th travel page and correct code as its only showing corresponding currency
        OrangeHRM_TravelExpensePage.amount(amount);
        OrangeHRM_TravelExpensePage.selectPaidby(paidBy);
        OrangeHRM_TravelExpensePage.submit_travelexp();

        String request_id = OrangeHRM_TravelExpensePage.reqestId();
        String requestStatus = OrangeHRM_TravelExpensePage.request_Status();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        //login as supervisor
        OrangeHRM_LoginPage.login(employeeName, pswd);
        OrangeHRM_HomePage.clickTravelExp();
        Thread.sleep(5000);
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, req_id);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, status);
        OrangeHRM_TravelExpensePage.supervisor_approval();
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        OrangeHRM_LoginPage.login(employeeName, pswd);
        OrangeHRM_HomePage.clickTravelExp();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, req_id);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, status);
        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        OrangeHRM_LoginPage.login(userName, pswd);
        OrangeHRM_HomePage.clickTravelExp();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, req_id);

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



        OrangeHRM_LogoutPage.logout();
        driver.switchTo().defaultContent();

        //login as Employee
        OrangeHRM_LoginPage.login(employeeName,pswd);
        OrangeHRM_HomePage.clickTravelExp();
        CommonUtils.switchToiFrame(OrangeHRM_TravelExpensePage.switchto_Iframe);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, req_id);
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_travelReqId, status);



 /*       List<WebElement> final_statusList = driver.findElements(OrangeHRM_TravelExpensePage.list_travelReqId);
        for (WebElement final_idElement : final_statusList) {
            String final_id = final_idElement.getText();
            if (final_id.equalsIgnoreCase(request_id)) {
                System.out.println("Approved request id is " + request_id);
                String final_Status = final_idElement.findElement(OrangeHRM_TravelExpensePage.list_reqStatus).getText();
                System.out.println("Final status of the request is " + final_Status);
                break;
            }
        }*/
        OrangeHRM_LogoutPage.logout();

    }

}