package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseClass;
import utilities.CommonUtils;

import java.time.Duration;

public class OrangeHRM_AddEmployeePage {

    static Logger log = LogManager.getLogger(OrangeHRM_AddEmployeePage.class);

    public static By link_add = By.xpath("//i[text()='add']");
    public static By txtbx_EmpFirstName = By.xpath("//input[@id='first-name-box']");
    public static By txtbx_EmpLastName = By.xpath("//input[@id='last-name-box']");
    public static By drpdwn_location = By.xpath("//div[@class='filter-option-inner-inner']");
    public static By list_locations = By.xpath("//button[@data-id='location']//following-sibling::div//ul/li//span");
    public static By btn_next = By.xpath("//button[text()='Next']");
    public static By drpdwn_MaritalStatus = By.xpath("(//div[@class='select-wrapper initialized'])[1]/input");
    public static By list_MaritalStatus = By.xpath("//label[text()='Marital Status']/..//ul/li/span");
    public static By drpdwn_Gender = By.xpath("//div[@id='emp_gender_inputfileddiv']/div/input");
    public static By list_Gender = By.xpath("//label[text()='Gender']/..//ul/li/span");
    public static By drpdwn_Region = By.xpath("//label[text()='Region']//following-sibling::div[1]//div[text()='-- Select --']");
    public static By list_Region = By.xpath("//label[text()='Region']//following-sibling::div//ul/li//span");
    public static By drpdwn_FTE = By.xpath("//label[text()='FTE']//following-sibling::div[1]//div[text()='-- Select --']");
    public static By list_FTE = By.xpath("//label[text()='FTE']//following-sibling::div//ul/li//span");
    public static By drpdwn_TempDept = By.xpath("//label[text()='Temporary Department']//following-sibling::div[1]//div[text()='-- Select --']");
    public static By list_TempDept = By.xpath("//label[text()='Temporary Department']//following-sibling::div//ul/li//span");
    public static By btn_save = By.xpath("//button[@ng-show='vm.showFinishButton']");
    public static By search_icon = By.xpath("//input[contains(@id,'employee_name_quick_filter')]");
    public static By txtbx_searchEmployee = By.xpath("//input[contains(@id,'employee_name_quick_filter')]");
    public static By searched_Employee = By.xpath("//div[@class='employee-details']/div[1]");
    public static By empId = By.xpath("//div[text()='Employee Id: ']/span");

    public static void enterAddEmployee_FirstPage(String firstName, String lastName, String location) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_add).click();
        log.info("Clicked on Add button ");
        driver.findElement(txtbx_EmpFirstName).sendKeys(firstName);
        log.info("First Name is entered as " + firstName);
        driver.findElement(txtbx_EmpLastName).sendKeys(lastName);
        log.info("Last Name is entered is entered as " + lastName);
        driver.findElement(drpdwn_location).click();
        log.info("Location drop-down is clicked ");
        CommonUtils.selectDropdownValue(list_locations, location);
        driver.findElement(btn_next).click();
        log.info("Next button is clicked");
    }

    public static void enterAddEmployee_SecondPage(String maritalStatus, String gender) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(drpdwn_MaritalStatus).click();
        log.info("Marital Status drop-down is clicked");
        CommonUtils.selectDropdownValue(list_MaritalStatus, maritalStatus);
        driver.findElement(drpdwn_Gender).click();
        log.info("Gender drop-down is clicked");
        CommonUtils.selectDropdownValue(list_Gender, gender);
        driver.findElement(btn_next).click();
        log.info("Next button is clicked");
    }

    public static void enterAddEmployee_ThirdPage(String region, String fte, String tempDept) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(drpdwn_Region).click();
        log.info("Region drop-down is clicked");
        CommonUtils.selectDropdownValue(list_Region, region);
        driver.findElement(drpdwn_FTE).click();
        log.info("FTE drop-down is clicked");
        CommonUtils.selectDropdownValue(list_FTE, fte);
        driver.findElement(drpdwn_TempDept).click();
        log.info("Temp Department drop-down is clicked");
        CommonUtils.selectDropdownValue(list_TempDept, tempDept);
        driver.findElement(btn_save).click();
        log.info("clicked on Save");
    }

    public static void searchEmployee(String firstName, String lastName) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        CommonUtils.staleElementEnterKeys(search_icon, firstName + " " + lastName);
        driver.findElement(txtbx_searchEmployee).click();
        log.info("Searched with Employee first and last name");
    }

    public static String verifyEmployeeId_name(String firstName, String lastName) {
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searched_Employee));
        WebElement searchedEmployeeElement = driver.findElement(searched_Employee);
        String actualFullName = searchedEmployeeElement.getText().trim();
        log.info("Employee Name from Application is: " + actualFullName);
        String expectedFullName = firstName + " " + lastName;
        Assert.assertEquals(expectedFullName, actualFullName, "Employee Name is not matched");
        log.info("Employee Name is Verified and matched: " + actualFullName);
        String employeeId = driver.findElement(empId).getText();
        log.info("Employee Id is :" + employeeId);
        return employeeId;
    }
}
