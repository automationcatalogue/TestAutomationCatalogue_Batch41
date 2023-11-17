package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class OrangeHRM_EmployeeManagementPage {

    static Logger log = LogManager.getLogger(OrangeHRM_EmployeeManagementPage.class);

    public static By link_PersonalDetails = By.xpath("//a[contains(@ui-sref,'l_details')]");
    public static By list_employee = By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]");
    public static By txt_supervisorName = By.xpath(".//following-sibling::td[6]");
    public static By link_add = By.xpath("//i[text()='add']");

    public static By getEmployeeNameLocator(String empName) {
        By link_Employee = By.xpath("//table[@id='employeeListTable']/tbody/tr/td[contains(text(),'" + empName + "')]");
        return link_Employee;
    }

    public static void clickEmployeePersonalDetails(String empName) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(getEmployeeNameLocator(empName)).click();
        log.info("Click on First Employee Data");
        driver.findElement(link_PersonalDetails).click();
        log.info("Clicked on Personal Details tab");
    }

    public static String getSupervisorName(String employeeName) {
        WebDriver driver = BaseClass.getDriver();
        String supervisorName = "";
        List<WebElement> elements_EmployeeList = driver.findElements(list_employee);
        for (WebElement element_Employee : elements_EmployeeList) {
            String actualEmployee = element_Employee.getText();
            if (actualEmployee.equalsIgnoreCase(employeeName)) {
                supervisorName = element_Employee.findElement(txt_supervisorName).getText();
                log.info("Supervisor name for the employee" + employeeName + " is :" + supervisorName);
                break;
            }
        }
        return supervisorName;
    }

    public static void openAddEmployee() throws Exception {
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(link_add).click();
        log.info("Clicked on Add button ");
    }
}


