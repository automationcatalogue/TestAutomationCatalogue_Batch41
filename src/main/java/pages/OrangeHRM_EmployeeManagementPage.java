package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_EmployeeManagementPage {
    public static By Link_FirstEmployee = By.xpath("//tr[contains(@ng-repeat,'employee.empNumber')][1]/td[2]");
    public static By Link_PersonalDetails = By.xpath("//a[contains(@ui-sref,'l_details')]");
    public static By link_EmployeeList = By.xpath("//a[text()='Employee List ']");
    public static By list_employee = By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]");
    public static By txt_supervisorName = By.xpath(".//following-sibling::td[6]");
    public static String supervisor_name = null;
    static Logger log = LogManager.getLogger(OrangeHRM_EmployeeManagementPage.class);

    public static String clickEmployeeList_getSupervisorName(String employeeName)throws Exception {

        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(Link_FirstEmployee));

        List<WebElement> emp_namesList = driver.findElements(list_employee);
        for (WebElement employee_name : emp_namesList) {
            String actual_empname = employee_name.getText();
            if (actual_empname.equalsIgnoreCase(employeeName)) {
                supervisor_name = employee_name.findElement(txt_supervisorName).getText();
                log.info("Supervisor name is :" + supervisor_name);
                break;
            }
        }
        return supervisor_name;
    }

}


