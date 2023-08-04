package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class OrangeHRM_EmployeeManagementPage {
    public static By Link_FirstEmployee = By.xpath("//tr[contains(@ng-repeat,'employee.empNumber')][1]/td[2]");
    public static By Link_PersonalDetails = By.xpath("//a[contains(@ui-sref,'l_details')]");
    public static By link_EmployeeList =By.xpath("//a[text()='Employee List ']");
    public static By list_employee= By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]");
    public static By txt_supervisorName=By.xpath(".//following-sibling::td[6]");

    public static void personalDetails_firstEmployee(){
        WebDriver driver = BaseClass.getDriver();

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_FirstEmployee).click();
        System.out.println("Click on First Employee Data");

        driver.findElement(OrangeHRM_EmployeeManagementPage.Link_PersonalDetails).click();
        System.out.println("Clicked on Personal Details tab");
    }
}
