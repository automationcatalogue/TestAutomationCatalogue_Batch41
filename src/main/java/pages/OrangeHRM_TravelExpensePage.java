package pages;

import org.openqa.selenium.By;

public class OrangeHRM_TravelExpensePage {
     public static By switchto_Iframe= By.xpath("//iframe[@id='noncoreIframe']");
     public static By btn_travelRequestAdd= By.xpath("//a[@data-tooltip='Submit Travel Request']");


     public static By drpdown_Currency=By.xpath("//label[contains(@for,'localCurrency')]/../div/input");
     public static By currency_CADOption= By.xpath("//label[contains(@for,'localCurrency')]//following-sibling::div/ul//span[text()='CAD - Canadian Dollar']");
     public static By btn_next=By.xpath("//a[text()='Next']");

     public static By btn_addTravelInfo=By.xpath("//button[@id='addTravelInformationBtn']");
     public static By txtbx_destination=By.xpath("//input[@aria-required='true']");

     public static By Calender_travelFrom=By.xpath("//input[contains(@name,'[travel_period_from]')]");
     public static By dropdwn_monthFrom = By.xpath("//div[contains(@class,'picker__select--month')]");
     public static By list_monthsFrom =By.xpath("//div[contains(@class,'picker__select--month')]/ul/li/span");
     public static By dropdwn_yearFrom= By.xpath("//div[contains(@class,'picker__select--year')]");
     public static By list_yearsFrom =By.xpath("//div[contains(@class,'picker__select--year')]/ul/li/span");
     public static By list_daysFrom=By.xpath("(//table[@class='picker__table'])[2]/tbody/tr/td/div");

     public static By Calender_travelTo=By.xpath("//input[contains(@name,'[travel_period_to]')]");
     public static By dropdwn_monthTo = By.xpath("(//div[contains(@class,'picker__select--month')])[2]");
     public static By list_monthsTo =By.xpath("(//div[contains(@class,'picker__select--month')])[2]/ul/li/span");
     public static By dropdwn_yearTo= By.xpath("(//div[contains(@class,'picker__select--year')])[2]");
     public static By list_yearsTo =By.xpath("(//div[contains(@class,'picker__select--year')])[2]/ul/li/span");
     public static By list_daysTo=By.xpath("//table[contains(@id,'travel_period_to_table')]/tbody/tr/td");
     public static By btn_saveTravelReq=By.xpath("//a[@id='travelInformationSave']");
     public static By btn_addTravelReqEstimate=By.xpath("//button[@id='addExpenseTypeBtn']");

     public static By dropdown_expenseType=By.xpath("//label[text()='Expense Types']/../div/input");
     public static By ExpType_airfare=By.xpath("//label[text()='Expense Types']/../div/ul/li[2]/span");

     public static By dropdown_currencyPaidin=By.xpath("//label[@for='estimation_currency_id']//following-sibling::div/input");
     public static By currencyPaidin_CAD=By.xpath("//label[@for='estimation_currency_id']//following-sibling::div/ul//span[text()='CAD - Canadian Dollar']");

     public static By textbox_amount =By.xpath("//label[@for='estimation_amount']/../input");
     public static By dropdwn_paidBy=By.xpath("//label[@for='estimation_amount']/../../div[3]/div");
     public static By paidby_staff=By.xpath("//label[text()='Paid By']/..//ul/li[2]/span[text()='Staff']");
     public static By btn_saveTravelExpEst= By.cssSelector("#formSave");
     public static By btn_submit =By.xpath("//a[text()='Submit']");
     public static By btn_oktoConfirm=By.xpath("//a[text()='OK']");
     public static By navLink_backarrow=By.xpath("//i[text()='arrow_back']");
     public static By list_travelReqId=By.xpath("//table[@id='resultTable']/tbody//td/a");
     public static By list_reqStatus=By.xpath("//table[@id='resultTable']/tbody/tr/td[4]");
     public static By btn_approve=By.xpath("//a[@status='Approve']");





}
