package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class OrangeHRM_EmployeeManagementPage {
    public static By Link_FirstEmployee = By.xpath("//tr[contains(@ng-repeat,'employee.empNumber')][1]/td[2]");
    public static By Link_PersonalDetails = By.xpath("//a[contains(@ui-sref,'l_details')]");
    public static By link_EmployeeList = By.xpath("//a[text()='Employee List ']");
    public static By list_employee = By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]");
    public static By txt_supervisorName = By.xpath(".//following-sibling::td[6]");
    static String supervisor_name = null;


    public static String clickEmployeeList_getSupervisorName(String employeeName) {

        WebDriver driver = BaseClass.getDriver();

        driver.findElement(OrangeHRM_EmployeeManagementPage.link_EmployeeList).click();
        supervisor_name = null;
        List<WebElement> emp_namesList = driver.findElements(OrangeHRM_EmployeeManagementPage.list_employee);

        for (WebElement employee_name : emp_namesList) {
            String actual_empname = employee_name.getText();
            if (actual_empname.equalsIgnoreCase(employeeName)) {
                supervisor_name = employee_name.findElement(OrangeHRM_EmployeeManagementPage.txt_supervisorName).getText();
                System.out.println("Supervisor name is :" + supervisor_name);
                break;
            }
        }
        return supervisor_name;
    }
}


