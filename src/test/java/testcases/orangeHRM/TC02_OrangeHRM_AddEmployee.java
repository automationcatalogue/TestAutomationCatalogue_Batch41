package testcases.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OrangeHRM_AddEmployeePage;
import pages.OrangeHRM_HomePage;
import pages.OrangeHRM_LoginPage;
import pages.OrangeHRM_LogoutPage;
import utilities.CommonUtils;

@Test
@Parameters({"browserName"})
public class TC02_OrangeHRM_AddEmployee {
    public static void addEmployee(@Optional("chrome") String browserName) throws Exception {

        WebDriver driver = CommonUtils.browserLaunch("Chrome");

        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        String title = driver.getTitle();
        System.out.println("Title of the page is:" + title);

        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys("Admin");
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Logged in as Admin");

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.link_add).click();
        System.out.println("Clicked on Add button ");

        driver.findElement(OrangeHRM_AddEmployeePage.txtbx_EmpFirstName).sendKeys("Shawn");
        System.out.println("First Name is entered");

        driver.findElement(OrangeHRM_AddEmployeePage.txtbx_EmpLastName).sendKeys("Desman");
        System.out.println("Last Name is entered");

        driver.findElement(OrangeHRM_AddEmployeePage.drpdwn_location).click();
        System.out.println("Location drop-down is clicked ");

        driver.findElement(OrangeHRM_AddEmployeePage.location_indiaOption).click();
        System.out.println("India Office value is selected from a drop-down");

        driver.findElement(OrangeHRM_AddEmployeePage.btn_next).click();
        System.out.println("Next button is clicked");

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_maritalStatus).click();
        System.out.println("Marital Status drop-down is clicked");

        driver.findElement(OrangeHRM_AddEmployeePage.maritalStatus_singleOption).click();
        System.out.println("Single is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_gender).click();
        System.out.println("Gender drop-down is clicked");

        driver.findElement(OrangeHRM_AddEmployeePage.gender_maleOption).click();
        System.out.println("Male is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.next_btn1).click();
        System.out.println("Clicked on Next");

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_region).click();
        System.out.println("Region drop-down is clicked");

        driver.findElement(OrangeHRM_AddEmployeePage.region_region3Option).click();
        System.out.println("Region-3 is selected ");

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_fteOption).click();
        System.out.println("FTE drop-down is clicked");

        driver.findElement(OrangeHRM_AddEmployeePage.fte).click();
        System.out.println("0.75 is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_tempDept).click();
        System.out.println("Temp Department drop-down is clicked");

        driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunittwoOption).click();
        System.out.println("Sub unit -2 is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.btn_save).click();
        System.out.println("clicked on Save");

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management is selected");

        driver.findElement(OrangeHRM_AddEmployeePage.search_icon).sendKeys("Shawn Desman");
        driver.findElement(OrangeHRM_AddEmployeePage.txtbx_searchEmployee).click();
        System.out.println("Searched with Employee first and last name");

        String elementText = driver.findElement(OrangeHRM_AddEmployeePage.searched_Employee).getText();
        System.out.println("Element Text is :" + elementText);

        if (elementText.equalsIgnoreCase("Shawn Desman")) {
            System.out.println("Search result is correct");
        } else {
            System.out.println("Search result is incorrect");
        }

        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("log out is clicked");

        driver.close();

    }
}
