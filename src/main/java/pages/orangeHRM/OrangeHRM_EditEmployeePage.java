package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseClass;
import utilities.CommonUtils;
import java.time.Duration;

public class OrangeHRM_EditEmployeePage {

    static Logger log = LogManager.getLogger(OrangeHRM_EditEmployeePage.class);

    public static By link_DateOfBirthIcon = By.xpath("(//i[contains(@class,'material-icons action')])[1]");
    public static By drpdwn_Month = By.xpath("//div[contains(@class,'--month')]");
    public static By list_Months = By.xpath("//div[contains(@class,'--month')]//li/span");
    public static By drpdwn_Year = By.xpath("//div[contains(@class,'select--year')]");
    public static By list_Years = By.xpath("//div[contains(@class,'select--year')]//li/span");
    public static By list_Dates = By.xpath("(//table[@class='picker__table'])[1]//td");
    public static By dropDown_Nationality = By.xpath("//div[@id='nation_code_inputfileddiv']/div/input");
    public static By element_nations = By.xpath("//div[@id='nation_code_inputfileddiv']/div/ul/li/span");
    public static By btn_PersonalDetailsSave = By.xpath("(//button[@type='submit'])[1]");
    public static By rbtn_NoAllergies = By.xpath("//ul[@class='radiobutton-container']/li[1]/label");
    public static By rbtn_YesAllergies = By.xpath("//ul[@class='radiobutton-container']/li[2]/label");
    public static By btn_HealthSave = By.xpath("(//button[@type='submit'])[2]");
    public static By checkBox_Kosher = By.xpath("//div[@sf-array='form']/div[4]/label");
    public static By checkBox_Vegetarian = By.xpath("//div[@sf-array='form']/div[5]/label");
    public static By link_Profile = By.xpath("//a[@data-automation-id='menu_employee_profile_Profile']");
    public static By txt_Mobile = By.xpath("//div[contains(text(),'Mobile')]/span");
    public static By link_ContactDetails = By.xpath("//a[@data-automation-id='menu_employee_profile_ContactDetails']");
    public static By txtbx_MobileNumber = By.xpath("//input[@id='emp_mobile']");
    public static By btn_ContactDetailsSave = By.xpath("//button[@id='modal-save-button']");

    public static void edit_DOB_Nationality(String dateOfBirth, String nationName) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_EditEmployeePage.link_DateOfBirthIcon).click();
        log.info("Date picker icon is clicked");
        CommonUtils.selectCalendarDate(dateOfBirth, drpdwn_Month, list_Months, drpdwn_Year, list_Years, list_Dates);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(dropDown_Nationality));
        driver.findElement(dropDown_Nationality).click();
        log.info("Nationality Dropdown is clicked");
        CommonUtils.selectDropdownValue(element_nations, nationName);
        log.info("Nationality selected as " + nationName);
        driver.findElement(btn_PersonalDetailsSave).click();
        log.info("Clicked on Personal Details save button");
    }

    public static void editHealth(String allergy, String dietaryType1, String dietaryType2) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(rbtn_YesAllergies));
        if (allergy.equalsIgnoreCase("Yes")) {
            driver.findElement(rbtn_YesAllergies).click();
            log.info("Radio button Allergies Yes is clicked");
        } else {
            driver.findElement(rbtn_NoAllergies).click();
            log.info("Radio button Allergies No is clicked");
        }
        clickDietaryRequirement(dietaryType1);
        clickDietaryRequirement(dietaryType2);
        driver.findElement(btn_HealthSave).click();
        log.info("Clicked on Health save button");
    }

    public static void editMobileNumber(String mobileNumber) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(link_ContactDetails));
        driver.findElement(link_ContactDetails).click();
        log.info("Contact Details link is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtbx_MobileNumber));
        driver.findElement(txtbx_MobileNumber).clear();
        driver.findElement(txtbx_MobileNumber).sendKeys(mobileNumber);
        log.info(mobileNumber + " is entered as Mobile Number");
        driver.findElement(btn_ContactDetailsSave).click();
        log.info("Clicked on Contact Details Save button");
    }

    public static void clickDietaryRequirement(String dietaryType) {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox_Kosher));
        if (dietaryType.equalsIgnoreCase("Kosher")) {
            driver.findElement(checkBox_Kosher).click();
            log.info("Dietary Requirements check-box Koshler is clicked");
        } else if (dietaryType.equalsIgnoreCase("Vegetarian")) {
            driver.findElement(checkBox_Vegetarian).click();
            log.info("Dietary Requirements check-box Vegetarian is clicked");
        } else {
            log.warn("Dietary Requirement " + dietaryType + " is not available ");
        }
    }

    public static void validateEditEmployeeData(String expMobileNumber) {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(link_Profile));
        driver.findElement(link_Profile).click();
        log.info("Profile Link is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Mobile));
        String actualMobileNumber = driver.findElement(txt_Mobile).getText();
        Assert.assertEquals(actualMobileNumber, expMobileNumber, "Edit Employee data is not saved successfully");
        log.info("Mobile Number is verified and Edit Employee data not saved successfully");
    }
}
