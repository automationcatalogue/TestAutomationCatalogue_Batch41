package testcases.orangeHRM;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;
import utilities.ExcelUtils;

import java.time.Duration;

public class TC06_orangeHRM_Goals {
    XSSFWorkbook wbk;
    int row; int row_index;
    String userName;
    String passWord;
    String employeeName;
    String firstGoalPriority;
    String firstGoalDate;
    String secondGoalPriority;
    String secondGoalDate;
    String thirdGoalPriority;
    String thirdGoalDate;
    static String Actual_UserName; static String supervisor_name;
    static String supervisor_ActualUserName;
    static String firstGoal_status; static String secondGoal_status; static String thirdGoal_status;
    static String sheetName;
    @BeforeClass
    public void prerequisite_Setup() throws Exception{
        wbk= ExcelUtils.setExcelFilePath();
        sheetName = "OrangeHRM_Goals";
        row = ExcelUtils.getRowNumber(Config.TestCase_ID,sheetName);
        row_index = ExcelUtils.getRowNumber(Config.TestCase_ID,"Index");
        userName = ExcelUtils.getCellData(sheetName,row,Config.col_UserName);
        passWord = ExcelUtils.getCellData(sheetName,row,Config.col_Password);
        employeeName = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_empName);
        firstGoalPriority = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_firstGoalPriority);
        firstGoalDate = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_firstGoalDate);
        secondGoalPriority = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_secondGoalPriority);
        secondGoalDate = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_secondGoalDate);
        thirdGoalPriority = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_thirdGoalPriority);
        thirdGoalDate = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_thirdGoalDate);
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

        //Finding Username of Employee
        OrangeHRM_HomePage.clickHrAdministrationLink();
        Actual_UserName = OrangeHRM_HRAdministrationPage.username_Employee(employeeName);

        //Finding Supervisor name
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        supervisor_name = OrangeHRM_EmployeeManagementPage.finding_supervisorName(employeeName);

        //Finding Supervisor's username
        OrangeHRM_HomePage.clickHrAdministrationLink();
        supervisor_ActualUserName = OrangeHRM_HRAdministrationPage.username_Supervisor(supervisor_name);

        //Logging out from Admin Credentials
        OrangeHRM_HomePage.clickLogout();

        //Logging in with the Employee Username
        OrangeHRM_LoginPage.login(Actual_UserName,passWord);
        System.out.println("Logged in with the Employee credentials");
        OrangeHRM_HomePage.select_Performance();
        OrangeHRM_PerformancePage.select_MyGoals();

        //First goal
        OrangeHRM_GoalsPage.create_FirstGoal(firstGoalPriority,firstGoalDate);
        //Second goal
        OrangeHRM_GoalsPage.create_SecondGoal(secondGoalPriority,secondGoalDate);
        //Third goal
        OrangeHRM_GoalsPage.create_ThirdGoal(thirdGoalPriority,thirdGoalDate);

        //Logging out from Employee Credentials
        OrangeHRM_HomePage.clickLogout();

        // Logging in with the supervisor username
        OrangeHRM_LoginPage.login(supervisor_ActualUserName,passWord);
        System.out.println("Logged in with the supervisor credentials");

        OrangeHRM_HomePage.select_MyGoals();
        OrangeHRM_GoalsPage.supervisor_ApproveGoals();

        //Logging out from Supervisor Credentials
        OrangeHRM_HomePage.clickLogout();

        // Logging in with the employee username
        OrangeHRM_LoginPage.login(Actual_UserName,passWord);
        System.out.println("Logged in with the employee credentials");
        OrangeHRM_HomePage.select_Performance();
        OrangeHRM_PerformancePage.select_MyGoals();

        //First goal progress
        OrangeHRM_GoalsPage.progress_firstGoal();

        //Second goal progress
        OrangeHRM_GoalsPage.progress_secondGoal();

        //Third goal progress
        OrangeHRM_GoalsPage.progress_thirdGoal();

        //First goal Verification
        firstGoal_status = OrangeHRM_GoalsPage.verify_firstGoal();

        //Second goal Verification
        secondGoal_status = OrangeHRM_GoalsPage.verify_secondGoal();

        //Third goal Verification
        thirdGoal_status = OrangeHRM_GoalsPage.verify_thirdGoal();

        //Logging out from Employee Credentials
        OrangeHRM_HomePage.clickLogout();

        driver.quit();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(firstGoal_status, sheetName,row, Config.col_OrangeHRMGoals_firstGoalStatus);
            System.out.println(firstGoal_status+" is written back to the Excel file");
            ExcelUtils.setCellData(secondGoal_status, sheetName,row, Config.col_OrangeHRMGoals_secondGoalStatus);
            System.out.println(secondGoal_status+" is written back to the Excel file");
            ExcelUtils.setCellData(thirdGoal_status, sheetName,row, Config.col_OrangeHRMGoals_thirdGoalStatus);
            System.out.println(thirdGoal_status+" is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index",row_index, Config.col_Status);
            System.out.println("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index",row_index, Config.col_Status);
                System.out.println("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",row_index,Config.col_reason);
                System.out.println("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index",row_index, Config.col_Status);
            System.out.println("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        ExcelUtils.closeExcelFile();
    }

}
