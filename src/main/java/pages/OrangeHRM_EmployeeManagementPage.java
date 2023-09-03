package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_EmployeeManagementPage {
    public static By Link_FirstEmployee = By.xpath("//tr[contains(@ng-repeat,'employee.empNumber')][1]/td[2]");
    public static By Link_PersonalDetails = By.xpath("//a[contains(@ui-sref,'l_details')]");
    public static By link_EmployeeList =By.xpath("//a[text()='Employee List ']");
    public static By list_employee= By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]");
    public static By txt_supervisorName=By.xpath(".//following-sibling::td[6]");
    static Logger log = LogManager.getLogger(OrangeHRM_EmployeeManagementPage.class);

    public static void personalDetails_firstEmployee(){
        WebDriver driver = BaseClass.getDriver();

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_FirstEmployee).click();
        log.info("Click on First Employee Data");

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_PersonalDetails).click();
        log.info("Clicked on Personal Details tab");
    }

    public static String finding_supervisorName(String employee_name){

        WebDriver driver = BaseClass.getDriver();
        String supervisor_name = null;
        List<WebElement> employee_List = driver.findElements(OrangeHRM_EmployeeManagementPage.list_employee);
        for (WebElement employee_Ref : employee_List) {
            String employee = employee_Ref.getText();
            if (employee.equalsIgnoreCase(employee_name)) {
                supervisor_name = employee_Ref.findElement(OrangeHRM_EmployeeManagementPage.txt_supervisorName).getText();
                log.info("Supervisor name of the given employee is :"+supervisor_name);
                break;
            }
        }
        return supervisor_name;
    }
}


