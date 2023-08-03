package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import utilities.BaseClass;
import utilities.CommonUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

public class TC20_orangeHRM_Goals {

    String projectPath;
    FileInputStream fis;
    FileOutputStream fos;
    XSSFWorkbook wbk;
    XSSFSheet ws;
    XSSFRow row;
    XSSFCell userName_cell; String userName;
    XSSFCell passWord_cell; String passWord;
    XSSFCell employeeName_cell; String employeeName;
    XSSFCell firstGoalPriority_cell; String firstGoalPriority;
    XSSFCell firstGoalDate_cell; String firstGoalDate;
    XSSFCell secondGoalPriority_cell; String secondGoalPriority;
    XSSFCell secondGoalDate_cell; String secondGoalDate;
    XSSFCell thirdGoalPriority_cell; String thirdGoalPriority;
    XSSFCell thirdGoalDate_cell; String thirdGoalDate;
    XSSFCell firstGoalStatus_cell;
    XSSFCell secondGoalStatus_cell;
    XSSFCell thirdGoalStatus_cell;

    @BeforeClass
    public void prerequisite_Setup() throws Exception{
        projectPath = System.getProperty("user.dir");
        fis = new FileInputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk = new XSSFWorkbook(fis);
        ws = wbk.getSheet("OrangeHRM_Goals");
        row = ws.getRow(1);
        userName_cell = row.getCell(3);
        userName=userName_cell.getStringCellValue();
        passWord_cell = row.getCell(4);
        passWord = passWord_cell.getStringCellValue();
        employeeName_cell = row.getCell(5);
        employeeName = employeeName_cell.getStringCellValue();
        firstGoalPriority_cell = row.getCell(6);
        firstGoalPriority = firstGoalPriority_cell.getStringCellValue();
        firstGoalDate_cell = row.getCell(7);
        firstGoalDate = firstGoalDate_cell.getStringCellValue();
        secondGoalPriority_cell = row.getCell(8);
        secondGoalPriority = secondGoalPriority_cell.getStringCellValue();
        secondGoalDate_cell = row.getCell(9);
        secondGoalDate = secondGoalDate_cell.getStringCellValue();
        thirdGoalPriority_cell = row.getCell(10);
        thirdGoalPriority = thirdGoalPriority_cell.getStringCellValue();
        thirdGoalDate_cell = row.getCell(11);
        thirdGoalDate = thirdGoalDate_cell.getStringCellValue();
    }
    @Test
    @Parameters({"browserName"})
    public void OrangeHRM_Goals(@Optional("chrome") String browserName) throws Exception {
        WebDriver driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://seleniumautom-trials710.orangehrmlive.com");

        OrangeHRM_LoginPage.login(userName,passWord);
        String employee_name = employeeName;
        String Actual_UserName = null;
        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();

        //Finding Username of Employee
        List<WebElement> userName_List = driver.findElements(OrangeHRM_UsersPage.list_users);
        for (WebElement userName : userName_List) {
            String Name = userName.getText();
            if (Name.equalsIgnoreCase(employee_name)) {
                userName.findElement(OrangeHRM_UsersPage.btn_edit).click();
                WebElement Username_Element = driver.findElement(OrangeHRM_UsersPage.txtbx_userName);
                Actual_UserName = (String) js.executeScript("return arguments[0].value", Username_Element);
                System.out.println("Username of the Employee is :"+Actual_UserName);
                driver.findElement(OrangeHRM_UsersPage.icon_crossExit).click();
                break;
            }
        }
        //Finding Supervisor name
        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Clicked on the Employee Management");
        String supervisor_name = null;
        List<WebElement> employee_List = driver.findElements(OrangeHRM_EmployeeManagementPage.list_employee);
        for (WebElement employee_Ref : employee_List) {
            String employee = employee_Ref.getText();
            if (employee.equalsIgnoreCase(employee_name)) {
                supervisor_name = employee_Ref.findElement(OrangeHRM_EmployeeManagementPage.txt_supervisorName).getText();
                System.out.println("Supervisor name of the given employee is :"+supervisor_name);
                break;
            }
        }

        //Finding Supervisor's username
        String supervisor_ActualUserName = null;
        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();

        List<WebElement> supervisorUserName_List = driver.findElements(OrangeHRM_UsersPage.list_users);
        for (WebElement supervisorName : supervisorUserName_List) {
            String name = supervisorName.getText();
            if (name.equalsIgnoreCase(supervisor_name)) {
                supervisorName.findElement(OrangeHRM_UsersPage.btn_edit).click();
                WebElement SupervisorUsername_Element = driver.findElement(OrangeHRM_UsersPage.txtbx_userName);
                supervisor_ActualUserName = (String) js.executeScript("return arguments[0].value", SupervisorUsername_Element);
                System.out.println("username of the Supervisor is :"+supervisor_ActualUserName);
                driver.findElement(OrangeHRM_UsersPage.icon_crossExit).click();
                break;
            }
        }
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Logged out from the Admin credentials");

        //Logging in with the Employee Username
        OrangeHRM_LoginPage.login(Actual_UserName,passWord);
        System.out.println("Logged in with the Employee credentials");

        driver.findElement(OrangeHRM_HomePage.btn_More).click();
        driver.findElement(OrangeHRM_HomePage.link_Performance).click();
        driver.findElement(OrangeHRM_PerformancePage.link_goals).click();
        driver.findElement(OrangeHRM_PerformancePage.link_MyGoals).click();
        System.out.println("Clicked on My Goals");


        //First goal
        driver.findElement(OrangeHRM_GoalsPage.btn_CreateGoal).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalName).sendKeys("Automation for E-Commerce Website");

        WebElement iframe_goal1 = driver.findElement(OrangeHRM_GoalsPage.iframe_GoalDescription);
        driver.switchTo().frame(iframe_goal1);
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalDescription).sendKeys("Automate the Payment Gateways for all bank debit cards and credit cards after applying promo codes");
        driver.switchTo().defaultContent();

        Select select_goal1 = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_goalPriority));
        select_goal1.selectByVisibleText(firstGoalPriority);

        driver.findElement(OrangeHRM_GoalsPage.icon_dueDate).click();

        String date_goal1 = firstGoalDate;
        String date_ArrayGoal1[] = date_goal1.split("-");
        String day_goal1 = date_ArrayGoal1[0];
        String month_goal1 = date_ArrayGoal1[1];
        String year_goal1 = date_ArrayGoal1[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal1 = new Select(driver.findElement(OrangeHRM_GoalsPage.month_dropDown));
        select_MonthGoal1.selectByVisibleText(month_goal1);
        System.out.println("Month is selected as :"+month_goal1);

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal1 = new Select(driver.findElement(OrangeHRM_GoalsPage.year_dropDown));
        select_YearGoal1.selectByVisibleText(year_goal1);
        System.out.println("Year is selected as :"+year_goal1);

        //date selector
        Thread.sleep(2000);
        CommonUtils.selectDropdownValue(OrangeHRM_GoalsPage.date_list,day_goal1);

        driver.findElement(OrangeHRM_GoalsPage.btn_Submit).click();
        System.out.println("First goal is successfully created");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();

        //Second goal
        driver.findElement(OrangeHRM_GoalsPage.btn_CreateGoal).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalName).sendKeys("Automation for Telecom Website");

        WebElement iframe_goal2 = driver.findElement(OrangeHRM_GoalsPage.iframe_GoalDescription);
        driver.switchTo().frame(iframe_goal2);
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalDescription).sendKeys("Automate the new customer entries in the server and check the activation of the user");
        driver.switchTo().defaultContent();

        Select select_goal2 = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_goalPriority));
        select_goal2.selectByVisibleText(secondGoalPriority);

        driver.findElement(OrangeHRM_GoalsPage.icon_dueDate).click();

        String date_goal2 = secondGoalDate;
        String date_ArrayGoal2[] = date_goal2.split("-");
        String day_goal2 = date_ArrayGoal2[0];
        String month_goal2 = date_ArrayGoal2[1];
        String year_goal2 = date_ArrayGoal2[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal2 = new Select(driver.findElement(OrangeHRM_GoalsPage.month_dropDown));
        select_MonthGoal2.selectByVisibleText(month_goal2);
        System.out.println("Month is selected as :"+month_goal2);

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal2 = new Select(driver.findElement(OrangeHRM_GoalsPage.year_dropDown));
        select_YearGoal2.selectByVisibleText(year_goal2);
        System.out.println("Year is selected as :"+year_goal2);

        //date selector
        CommonUtils.selectDropdownValue(OrangeHRM_GoalsPage.date_list,day_goal2);

        driver.findElement(OrangeHRM_GoalsPage.btn_Submit).click();
        System.out.println("Second goal is successfully created");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();

        //Third goal
        driver.findElement(OrangeHRM_GoalsPage.btn_CreateGoal).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalName).sendKeys("Automation for Fiancial Website");

        WebElement iframe_goal3 = driver.findElement(OrangeHRM_GoalsPage.iframe_GoalDescription);
        driver.switchTo().frame(iframe_goal3);
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalDescription).sendKeys("Automate the new customer entries with the valid account numbers and other account details");
        driver.switchTo().defaultContent();

        Select select_goal3 = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_goalPriority));
        select_goal3.selectByVisibleText(thirdGoalPriority);

        driver.findElement(OrangeHRM_GoalsPage.icon_dueDate).click();

        String date_goal3 = thirdGoalDate;
        String date_ArrayGoal3[] = date_goal3.split("-");
        String day_goal3 = date_ArrayGoal3[0];
        String month_goal3 = date_ArrayGoal3[1];
        String year_goal3 = date_ArrayGoal3[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal3 = new Select(driver.findElement(OrangeHRM_GoalsPage.month_dropDown));
        select_MonthGoal3.selectByVisibleText(month_goal3);
        System.out.println("Month is selected as :"+month_goal3);

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal3 = new Select(driver.findElement(OrangeHRM_GoalsPage.year_dropDown));
        select_YearGoal3.selectByVisibleText(year_goal3);
        System.out.println("Year is selected as :"+year_goal3);

        //date selector
        Thread.sleep(2000);
        CommonUtils.selectDropdownValue(OrangeHRM_GoalsPage.date_list,day_goal3);

        Thread.sleep(3000);
        driver.findElement(OrangeHRM_GoalsPage.btn_Submit).click();
        System.out.println("Third goal is successfully created");
        Thread.sleep(3000);
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Logged out from the employee credentials");

        // Logging in with the supervisor username
        OrangeHRM_LoginPage.login(supervisor_ActualUserName,passWord);
        System.out.println("Logged in with the supervisor credentials");

        driver.findElement(OrangeHRM_HomePage.txtbx_Search).sendKeys("Goal List");
        driver.findElement(OrangeHRM_HomePage.link_MyGoals).click();

        driver.findElement(OrangeHRM_GoalsPage.icon_unApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.chkbx_approve).click();
        driver.findElement(OrangeHRM_GoalsPage.btn_Approve).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_approveDescription).sendKeys("Approved all the goals for aaliyah haq on telecom, financial and E commerce domains");
        driver.findElement(OrangeHRM_GoalsPage.btn_finalApprove).click();
        System.out.println("Approved all the goals created by the employee");

        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Logged out from the supervisor credentials");

        // Logging in with the employee username
        OrangeHRM_LoginPage.login(Actual_UserName,passWord);
        System.out.println("Logged in with the employee credentials");

        driver.findElement(OrangeHRM_HomePage.btn_More).click();
        driver.findElement(OrangeHRM_HomePage.link_Performance).click();
        driver.findElement(OrangeHRM_PerformancePage.link_goals).click();
        driver.findElement(OrangeHRM_PerformancePage.link_MyGoals).click();
        System.out.println("Clicked on My Goals");

        //First goal progress
        driver.findElement(OrangeHRM_GoalsPage.btn_Pending).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.icon_MoreDetails).click();

        for(int i=1; i<=25; i++){
            driver.findElement(OrangeHRM_GoalsPage.icon_addprogress).click();
        }
        driver.findElement(OrangeHRM_GoalsPage.btn_Update).click();
        System.out.println("Updated the first goal by 25%");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();

        //Second goal progress
        driver.findElement(OrangeHRM_GoalsPage.btn_Pending).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.icon_MoreDetails).click();

        for(int i=1; i<=100; i++){
            driver.findElement(OrangeHRM_GoalsPage.icon_addprogress).click();
        }
        driver.findElement(OrangeHRM_GoalsPage.btn_Update).click();
        System.out.println("Updated the second goal by 100%");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();

        //Third goal progress
        driver.findElement(OrangeHRM_GoalsPage.btn_Pending).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.icon_MoreDetails).click();

        Select status = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_status));
        status.selectByVisibleText("On Hold");
        driver.findElement(OrangeHRM_GoalsPage.btn_Update).click();
        System.out.println("Updated the third goal by keeping it in On Hold");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();

        //First goal Verification
        String firstGoal_status = "null";
        driver.findElement(OrangeHRM_GoalsPage.btn_InProgress).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        for(int i=1; i<=3; i++){
            try {
                firstGoal_status = driver.findElement(OrangeHRM_GoalsPage.txt_status).getText();
                System.out.println("Status of the first goal is :"+firstGoal_status);
                break;
            }catch (StaleElementReferenceException se){
                System.out.println("Text not found");
            }
        }
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();

        //Second goal Verification
        String secondGoal_status = "null";
        driver.findElement(OrangeHRM_GoalsPage.btn_achieved).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        for(int i=1; i<=3; i++){
            try {
                secondGoal_status= driver.findElement(OrangeHRM_GoalsPage.txt_status).getText();
                System.out.println("Status of the second goal is :"+secondGoal_status);
                break;
            }catch (StaleElementReferenceException se){
                System.out.println("Text not found");
            }
        }
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();

        //Third goal Verification
        String thirdGoal_status = "null";
        driver.findElement(OrangeHRM_GoalsPage.btn_OnHold).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        for (int i=1; i<=3; i++){
            try {
                thirdGoal_status = driver.findElement(OrangeHRM_GoalsPage.txt_status).getText();
                System.out.println("Status of the third goal is :"+thirdGoal_status);
                break;
            }catch (StaleElementReferenceException se){
                System.out.println("Text is not found");
            }
        }
        driver.findElement(OrangeHRM_LogoutPage.btn_logout).click();
        System.out.println("Logged out from the employee credentials");
        driver.quit();
    }
@AfterClass
public void tearDown() throws Exception {

        fis.close();

    }
}
