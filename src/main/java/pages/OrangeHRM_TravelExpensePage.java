package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    static Logger log = LogManager.getLogger(OrangeHRM_TravelExpensePage.class);
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
    public static By list_reqStatus=By.xpath("//table[@id='resultTable']/tbody/tr/td[4]");
    public static By btn_approve = By.xpath("//a[@status='Approve']");
    static String request_id, status;

    public static void clickAddTravelExp() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_travelRequestAdd).click();
        log.info("Add button is selected to submit travel expense");
    }

    public static void selectcurrency(String currency) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(drpdown_Currency).click();
        log.info("Currency Dropdown is clicked");
        if (currency.equalsIgnoreCase("AED - Utd. Arab Emir. Dirham")) {
            driver.findElement(currency_AED).click();
            log.info("Arab Emir. Dirham is selected");
        } else if (currency.equalsIgnoreCase("CAD - Canadian Dollar")) {
            driver.findElement(currency_CADOption).click();
            log.info("CAD is selected");

        } else if (currency.equalsIgnoreCase("AUD - Australian Dollar")) {
            driver.findElement(currency_AUD).click();
            log.info("AUD is selected");
        } else if (currency.equalsIgnoreCase("EUR - Euro")) {
            driver.findElement(currency_EUR).click();
            log.info("EUR is selected");
        } else if (currency.equalsIgnoreCase("JPY - Japanese Yen")) {
            driver.findElement(currency_JPY).click();
            log.info("JPY - Japanese Yen is selected");
        } else if (currency.equalsIgnoreCase("LKR - Sri Lanka Rupee")) {
            driver.findElement(currency_LKR).click();
            log.info("LKR is selected");
        } else if (currency.equalsIgnoreCase("PHP - Philippine Peso")) {
            driver.findElement(currency_PHP).click();
            log.info("Philippine peso is selected");
        } else if (currency.equalsIgnoreCase("USD - United States Dollar")) {
            driver.findElement(currency_USD).click();
            log.info("USD is selected");
        } else if (currency.equalsIgnoreCase("MXN - Mexican New Peso")) {
            driver.findElement(currency_MXN).click();
            log.info("Mexican peso is selected");
        } else if (currency.equalsIgnoreCase("ZMK - Zambian Kwacha")) {
            driver.findElement(currency_ZMK).click();
            log.info("Zambian currency is selected");
        } else {
            log.info("wrong currency selected");
        }
        driver.findElement(btn_next).click();
    }

    public static void addTravelinfo() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_addTravelInfo).click();
    }

    public static void destination(String destination) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(txtbx_destination).sendKeys(destination);
    }

    public static void travelFrom(String travelFrom) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        String from_date = travelFrom;
        String from_calender[] = from_date.split("-");
        String from_day = from_calender[0];
        String from_month = from_calender[1];
        String from_year = from_calender[2];

        driver.findElement(Calender_travelFrom).click();
        driver.findElement(dropdwn_monthFrom).click();
        CommonUtils.selectDropdownValue(list_monthsFrom, from_month);

        driver.findElement(dropdwn_yearFrom).click();
        CommonUtils.selectDropdownValue(list_yearsFrom, from_year);

        CommonUtils.selectDropdownValue(list_daysFrom, from_day);
    }

    public static void travelto(String travelTo) throws Exception{
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String toDate = travelTo;
        String toCalendar[] = toDate.split("-");
        String toDay = toCalendar[0];
        String toMonth = toCalendar[1];
        String toYear = toCalendar[2];

        WebElement element_TravelPeriodTo = driver.findElement(Calender_travelTo);
        js.executeScript("arguments[0].click();", element_TravelPeriodTo);
        driver.findElement(dropdwn_monthTo).click();
        CommonUtils.selectDropdownValue(list_monthsTo, toMonth);

        driver.findElement(dropdwn_yearTo).click();
        CommonUtils.selectDropdownValue(list_yearsTo, toYear);

        CommonUtils.selectDropdownValue(list_daysTo, toDay);
    }

    public static void saveTravelexp() {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement save_expreq = driver.findElement(btn_saveTravelReq);
        js.executeScript("arguments[0].click();", save_expreq);
        log.info("clicked on travel information save button");
    }

    public static void travelRequestEstimateAddBtn() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_addTravelReqEstimate).click();
        log.info("clicked on Add expense button");
    }

    public static void selectExpenseType(String expenseType) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(dropdown_expenseType).click();
        log.info("Expense Type drop-down is clicked ");

        if (expenseType.equalsIgnoreCase("Airfare")) {
            driver.findElement(ExpType_airfare).click();
            log.info("Arifare is selected");
        } else if (expenseType.equalsIgnoreCase("Charitable Donations")) {
            driver.findElement(ExpType_CharitableDonation).click();
            log.info("Charitable Donations is selected");
        } else if (expenseType.equalsIgnoreCase("Entertainment")) {
            driver.findElement(ExpType_Entertainment).click();
            log.info("Entertainment is selected");
        } else if (expenseType.equalsIgnoreCase("Food & Beverage")) {
            driver.findElement(ExpType_FoodandBeverage).click();
            log.info("Food & Beverage is selected");
        } else if (expenseType.equalsIgnoreCase("Fuel")) {
            driver.findElement(ExpType_Fuel).click();
            log.info("Fuel is selected");
        } else if (expenseType.equalsIgnoreCase("Ground Transportation")) {
            driver.findElement(ExpType_GroundTransportation).click();
            log.info("Ground Transportation is selected");
        } else if (expenseType.equalsIgnoreCase("Hotel")) {
            driver.findElement(ExpType_Hotel).click();
            log.info("Hotel is selected");
        } else if (expenseType.equalsIgnoreCase("Maintenance & Repairs")) {
            driver.findElement(ExpType_Maintenance_Repairs).click();
            log.info("Maintenance & Repairs is selected");
        } else if (expenseType.equalsIgnoreCase("Office Supplies")) {
            driver.findElement(ExpType_OfficeSupplies).click();
            log.info("Office Supplies is selected");
        } else {
            log.info("invalid expense type is selected");
        }
    }

    public static void currency_paidin(String Currency) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for (int count = 1; count <= 3; ++count) {
            try {
                WebElement element_Currency = driver.findElement(dropdown_currencyPaidin);
                js.executeScript("arguments[0].click();", element_Currency);
                log.info("Currency drop-down is clicked");
                wait.until(ExpectedConditions.textToBePresentInElementLocated(currencyPaid, Currency));
                driver.findElement(currencyPaid).click();
                log.info("Currency is selected");
                break;
            } catch (Exception e) {

                log.info(" Exception is occurred for " + count + " time.");
            }
        }
    }

    public static void amount(String amount) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(textbox_amount).sendKeys(amount);
    }

    public static void selectPaidby(String paidBy) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(dropdwn_paidBy).click();
        if (paidBy.equalsIgnoreCase("Staff")) {
            driver.findElement(paidby_staff).click();
            log.info("Expense paid by Staff");

        } else if (paidBy.equalsIgnoreCase("Company")) {
            driver.findElement(paidby_company).click();
            log.info("Expense paid by the Company");
        } else {
            log.info("invalid expense paid by is selected");
        }
    }

    public static void submit_travelexp() {
        WebDriver driver = BaseClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement save_expense = driver.findElement(btn_saveTravelExpEst);
        js.executeScript("arguments[0].click();", save_expense);
        log.info("Clicked on save button");

        WebElement submit = driver.findElement(btn_submit);
        js.executeScript("arguments[0].click();", submit);
        log.info("Submitted the expense");

        WebElement ok = driver.findElement(btn_oktoConfirm);
        js.executeScript("arguments[0].click();", ok);
        log.info("Confirmed the submit");

        WebElement arrow_back = driver.findElement(navLink_backarrow);
        js.executeScript("arguments[0].click();", arrow_back);
        log.info("Clicked on arrow back");
    }

    public static String reqestId() {
        WebDriver driver = BaseClass.getDriver();
        WebElement requestElement = driver.findElement(list_travelReqId);
        request_id = requestElement.getText();
        log.info("Travel Request ID :" + request_id);
        return request_id;
    }

    public static String request_Status() {
        WebDriver driver = BaseClass.getDriver();
        WebElement statusElement = driver.findElement(list_reqStatus);
        status = statusElement.getText();
        log.info("Request status is:"+status);
        return status;
    }

    public static void supervisor_approval() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_approve).click();
        log.info("Approved the Expense request");
        driver.findElement(btn_oktoConfirm).click();
    }

    public static void finalApproval() {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_approve).click();
        log.info("Approved the Expense request");
        driver.findElement(btn_oktoConfirm).click();
        log.info("Clicked on OK");
    }

}