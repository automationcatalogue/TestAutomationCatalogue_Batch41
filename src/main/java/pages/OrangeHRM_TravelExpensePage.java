package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseClass;
import utilities.CommonUtils;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_TravelExpensePage {
    public static By switchto_Iframe = By.xpath("//iframe[@id='noncoreIframe']");
    public static By btn_travelRequestAdd = By.xpath("//a[@data-tooltip='Submit Travel Request']");

    public static By drpdown_Currency = By.xpath("//label[contains(@for,'localCurrency')]/../div/input");
    public static By currency_CADOption = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='CAD - Canadian Dollar']");
    public static By currency_AED = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='AED - Utd. Arab Emir. Dirham']");
    public static By currency_AUD = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='AUD - Australian Dollar']");
    public static By currency_EUR = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='EUR - Euro']");
    public static By currency_JPY = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='JPY - Japanese Yen']");
    public static By currency_LKR = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='LKR - Sri Lanka Rupee']");
    public static By currency_PHP = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='PHP - Philippine Peso']");
    public static By currency_USD = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='USD - United States Dollar']");
    public static By currency_MXN = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='MXN - Mexican New Peso']");
    public static By currency_ZMK = By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='ZMK - Zambian Kwacha']");


    public static By btn_next = By.xpath("//a[text()='Next']");

    public static By btn_addTravelInfo = By.xpath("//button[@id='addTravelInformationBtn']");
    public static By txtbx_destination = By.xpath("//input[@aria-required='true']");

    public static By Calender_travelFrom = By.xpath("//input[contains(@name,'[travel_period_from]')]");
    public static By dropdwn_monthFrom = By.xpath("//div[contains(@class,'picker__select--month')]");
    public static By list_monthsFrom = By.xpath("//div[contains(@class,'picker__select--month')]/ul/li/span");
    public static By dropdwn_yearFrom = By.xpath("//div[contains(@class,'picker__select--year')]");
    public static By list_yearsFrom = By.xpath("//div[contains(@class,'picker__select--year')]/ul/li/span");
    public static By list_daysFrom = By.xpath("(//table[@class='picker__table'])[2]/tbody/tr/td/div");

    public static By Calender_travelTo = By.xpath("//input[contains(@name,'[travel_period_to]')]");
    public static By dropdwn_monthTo = By.xpath("(//div[contains(@class,'picker__select--month')])[2]");
    public static By list_monthsTo = By.xpath("(//div[contains(@class,'picker__select--month')])[2]/ul/li/span");
    public static By dropdwn_yearTo = By.xpath("(//div[contains(@class,'picker__select--year')])[2]");
    public static By list_yearsTo = By.xpath("(//div[contains(@class,'picker__select--year')])[2]/ul/li/span");
    public static By list_daysTo = By.xpath("//table[contains(@id,'travel_period_to_table')]/tbody/tr/td");
    public static By btn_saveTravelReq = By.xpath("//a[@id='travelInformationSave']");
    public static By btn_addTravelReqEstimate = By.xpath("//button[@id='addExpenseTypeBtn']");

    public static By dropdown_expenseType = By.xpath("//label[text()='Expense Types']/../div/input");
    public static By ExpType_airfare = By.xpath("//label[text()='Expense Types']/../div/ul/li[2]/span");
    public static By ExpType_CharitableDonation = By.xpath("//label[text()='Expense Types']/../div/ul/li[3]/span");
    public static By ExpType_Entertainment = By.xpath("//label[text()='Expense Types']/../div/ul/li[4]/span");
    public static By ExpType_FoodandBeverage = By.xpath("//label[text()='Expense Types']/../div/ul/li[5]/span");
    public static By ExpType_Fuel = By.xpath("//label[text()='Expense Types']/../div/ul/li[6]/span");
    public static By ExpType_GroundTransportation = By.xpath("//label[text()='Expense Types']/../div/ul/li[7]/span");
    public static By ExpType_Hotel = By.xpath("//label[text()='Expense Types']/../div/ul/li[8]/span");
    public static By ExpType_Maintenance_Repairs = By.xpath("//label[text()='Expense Types']/../div/ul/li[9]/span");
    public static By ExpType_OfficeSupplies = By.xpath("//label[text()='Expense Types']/../div/ul/li[10]/span");

    public static By dropdown_currencyPaidin = By.xpath("//label[@for='estimation_currency_id']//following-sibling::div/input");
    public static By currencyPaid = By.xpath("//label[@for='estimation_currency_id']//following-sibling::div/ul/li[2]/span");

    public static By textbox_amount = By.xpath("//label[@for='estimation_amount']/../input");

    public static By dropdwn_paidBy = By.xpath("//label[@for='estimation_amount']/../../div[3]/div");
    public static By paidby_staff = By.xpath("//label[text()='Paid By']/..//ul/li[2]/span[text()='Staff']");
    public static By paidby_company = By.xpath("//label[text()='Paid By']/..//ul/li[3]/span[text()='Company']");

    public static By btn_saveTravelExpEst = By.cssSelector("#formSave");
    public static By btn_submit = By.xpath("//a[text()='Submit']");
    public static By btn_oktoConfirm = By.xpath("//a[text()='OK']");
    public static By navLink_backarrow = By.xpath("//i[text()='arrow_back']");
    public static By list_travelReqId = By.xpath("//table[@id='resultTable']/tbody//td/a");
    public static By list_reqStatus = By.xpath("//./../../td[5]");
    public static By btn_approve = By.xpath("//a[@status='Approve']");

    static String request_id, status;
    static String element;
    static String updatedStatus;

    public static void clickAddTravelExp() {
        WebDriver driver = BaseClass.getDriver();

        driver.findElement(OrangeHRM_TravelExpensePage.btn_travelRequestAdd).click();
        System.out.println("Add button is selected to submit travel expense");

    }

    public static void selectcurrency(String currency) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.drpdown_Currency).click();
        System.out.println("Currency Dropdown is clicked");
        if (currency.equalsIgnoreCase("AED - Utd. Arab Emir. Dirham")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_AED).click();
            System.out.println("Arab Emir. Dirham is selected");
        } else if (currency.equalsIgnoreCase("CAD - Canadian Dollar")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_CADOption).click();
            System.out.println("CAD is selected");

        } else if (currency.equalsIgnoreCase("AUD - Australian Dollar")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_AUD).click();
            System.out.println("AUD is selected");
        } else if (currency.equalsIgnoreCase("EUR - Euro")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_EUR).click();
            System.out.println("EUR is selected");
        } else if (currency.equalsIgnoreCase("JPY - Japanese Yen")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_JPY).click();
            System.out.println("JPY - Japanese Yen is selected");
        } else if (currency.equalsIgnoreCase("LKR - Sri Lanka Rupee")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_LKR).click();
            System.out.println("LKR is selected");
        } else if (currency.equalsIgnoreCase("PHP - Philippine Peso")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_PHP).click();
            System.out.println("Philippine peso is selected");
        } else if (currency.equalsIgnoreCase("USD - United States Dollar")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_USD).click();
            System.out.println("USD is selected");
        } else if (currency.equalsIgnoreCase("MXN - Mexican New Peso")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_MXN).click();
            System.out.println("Mexican peso is selected");
        } else if (currency.equalsIgnoreCase("ZMK - Zambian Kwacha")) {
            driver.findElement(OrangeHRM_TravelExpensePage.currency_ZMK).click();
            System.out.println("Zambian currency is selected");
        } else {
            System.out.println("wrong currency selected");
        }
        driver.findElement(OrangeHRM_TravelExpensePage.btn_next).click();
    }

    public static void addTravelinfo() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.btn_addTravelInfo).click();
    }

    public static void destination(String destination) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.txtbx_destination).sendKeys(destination);
    }

    public static void travelFrom(String travelFrom)  throws Exception{
        WebDriver driver = BaseClass.getDriver();
        String from_date = travelFrom;
        String from_calender[] = from_date.split("-");
        String from_day = from_calender[0];
        String from_month = from_calender[1];
        String from_year = from_calender[2];

        driver.findElement(OrangeHRM_TravelExpensePage.Calender_travelFrom).click();
        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_monthFrom).click();
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_monthsFrom, from_month);

        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_yearFrom).click();
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_yearsFrom, from_year);

        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_daysFrom, from_day);
    }

    public static void travelto(String travelTo) throws Exception{
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String toDate = travelTo;
        String toCalendar[] = toDate.split("-");
        String toDay = toCalendar[0];
        String toMonth = toCalendar[1];
        String toYear = toCalendar[2];

        WebElement element_TravelPeriodTo = driver.findElement(OrangeHRM_TravelExpensePage.Calender_travelTo);
        js.executeScript("arguments[0].click();", element_TravelPeriodTo);
        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_monthTo).click();
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_monthsTo, toMonth);

        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_yearTo).click();
        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_yearsTo, toYear);

        CommonUtils.selectDropdownValue(OrangeHRM_TravelExpensePage.list_daysTo, toDay);
    }

    public static void saveTravelexp() {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement save_expreq = driver.findElement(OrangeHRM_TravelExpensePage.btn_saveTravelReq);
        js.executeScript("arguments[0].click();", save_expreq);
        System.out.println("clicked on travel information save button");
    }

    public static void travelRequestEstimateAddBtn() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.btn_addTravelReqEstimate).click();
        System.out.println("clicked on Add expense button");
    }

    public static void selectExpenseType(String expenseType) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.dropdown_expenseType).click();
        System.out.println("Expense Type drop-down is clicked ");

        if (expenseType.equalsIgnoreCase("Airfare")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_airfare).click();
            System.out.println("Arifare is selected");
        } else if (expenseType.equalsIgnoreCase("Charitable Donations")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_CharitableDonation).click();
            System.out.println("Charitable Donations is selected");
        } else if (expenseType.equalsIgnoreCase("Entertainment")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_Entertainment).click();
            System.out.println("Entertainment is selected");
        } else if (expenseType.equalsIgnoreCase("Food & Beverage")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_FoodandBeverage).click();
            System.out.println("Food & Beverage is selected");
        } else if (expenseType.equalsIgnoreCase("Fuel")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_Fuel).click();
            System.out.println("Fuel is selected");
        } else if (expenseType.equalsIgnoreCase("Ground Transportation")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_GroundTransportation).click();
            System.out.println("Ground Transportation is selected");
        } else if (expenseType.equalsIgnoreCase("Hotel")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_Hotel).click();
            System.out.println("Hotel is selected");
        } else if (expenseType.equalsIgnoreCase("Maintenance & Repairs")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_Maintenance_Repairs).click();
            System.out.println("Maintenance & Repairs is selected");
        } else if (expenseType.equalsIgnoreCase("Office Supplies")) {
            driver.findElement(OrangeHRM_TravelExpensePage.ExpType_OfficeSupplies).click();
            System.out.println("Office Supplies is selected");
        } else {
            System.out.println("invalid expense type is selected");
        }

    }

    public static void currency_paidin(String Currency) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for (int count = 1; count <= 3; ++count) {
            try {
                WebElement element_Currency = driver.findElement(OrangeHRM_TravelExpensePage.dropdown_currencyPaidin);
                js.executeScript("arguments[0].click();", element_Currency);
                System.out.println("Currency drop-down is clicked");
                wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_TravelExpensePage.currencyPaid, Currency));
                driver.findElement(OrangeHRM_TravelExpensePage.currencyPaid).click();
                System.out.println("Currency is selected");
                /*  List<WebElement> currencyOptions = driver.findElements(By.xpath("//label[text()='Currency Paid In']/../div/ul/li"));

                // select any available currency option
                for (WebElement currency : currencyOptions) {
                    js.executeScript("arguments[0].click();", currency);
                    System.out.println("Selected Currency: " + currency.getText());
                    break;
                }*/
                break;
            } catch (Exception e) {

                System.out.println(" Exception is occurred for " + count + " time.");
            }
        }

        /*wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_TravelExpensePage.currencyPaidin_CAD, Currency));
        driver.findElement(OrangeHRM_TravelExpensePage.currencyPaidin_CAD).click();
        System.out.println("Currency is selected");*/

    }

    public static void amount(String amount) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.textbox_amount).sendKeys(amount);
    }

    public static void selectPaidby(String paidBy) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.dropdwn_paidBy).click();
        if (paidBy.equalsIgnoreCase("Staff")) {
            driver.findElement(OrangeHRM_TravelExpensePage.paidby_staff).click();
            System.out.println("Expense paid by Staff");

        } else if (paidBy.equalsIgnoreCase("Company")) {
            driver.findElement(OrangeHRM_TravelExpensePage.paidby_company).click();
            System.out.println("Expense paid by the Company");
        } else {
            System.out.println("invalid expense paid by is selected");
        }
    }

    public static void submit_travelexp() {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
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
    }

    public static String reqestId() {
        WebDriver driver = BaseClass.getDriver();
        WebElement requestElement = driver.findElement(OrangeHRM_TravelExpensePage.list_travelReqId);
        request_id = requestElement.getText();
        System.out.println("Travel Request ID :" + request_id);
        return request_id;

    }

    public static String request_Status() {
        WebDriver driver = BaseClass.getDriver();
        WebElement statusElement = driver.findElement(OrangeHRM_TravelExpensePage.list_reqStatus);
        status = statusElement.getText();
        System.out.println("Request status is:"+status);
        /*if (status.equalsIgnoreCase("Pending Supervisor Approval")) {
            System.out.println("Request status is :" + status);
        } else {
            System.out.println("Incorrect request status");
        }*/
        return status;
    }

    public static void supervisor_approval() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.btn_approve).click();
        System.out.println("Approved the Expense request");
        driver.findElement(OrangeHRM_TravelExpensePage.btn_oktoConfirm).click();
    }

    public static void verifyRequestIdAndStatus(String requestId, String requestStatus) {
        WebDriver driver = BaseClass.getDriver();
        String travelreqid = driver.findElement(OrangeHRM_TravelExpensePage.list_travelReqId).getText();
        System.out.println("Travel Request ID :" + travelreqid);
        Assert.assertEquals(requestId, travelreqid, "RequestID is not matched");
        System.out.println("Request ID is matched");


        WebElement element_reqstatus = driver.findElement(OrangeHRM_TravelExpensePage.list_reqStatus);
        String updated_status = element_reqstatus.getText();
        System.out.println("Request status is :" + updated_status);
        Assert.assertEquals(requestId, updated_status, "RequestStatus is not matched");
        System.out.println("Request Status is matched");
    }

    public static void finalApproval() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_TravelExpensePage.btn_approve).click();
        System.out.println("Approved the Expense request");
        driver.findElement(OrangeHRM_TravelExpensePage.btn_oktoConfirm).click();
        System.out.println("Clicked on OK");
    }

    public static String updatedStatus(By locator, String data) {
        WebDriver driver = BaseClass.getDriver();

        List<WebElement> list_Elements = driver.findElements(locator);
        for (WebElement element : list_Elements) {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(data)) {
                break;
            }
        }
        return element;
    }
    public static String getStatus(By locator, String data) {
        WebDriver driver = BaseClass.getDriver();

        List<WebElement> list_Elements = driver.findElements(locator);
        for (WebElement element : list_Elements) {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(data)) {
                String updatedStatus=element.findElement(list_reqStatus).getText();
                System.out.println(updatedStatus);
                break;
            }
        }
        return updatedStatus;
    }

}