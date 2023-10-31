package testcases.orangeHRM;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import testcases.setup.TestRunner;
import utilities.*;


public class TC06_OrangeHRM_Goals extends TestRunner {
    int row; int row_index;
    static String userName, password, employeeName;
    static String firstGoalPriority, firstGoalDate, secondGoalPriority, secondGoalDate, thirdGoalPriority, thirdGoalDate;
    static String actualUserName, supervisorName, supervisorActualUserName;
    static String firstGoalStatus, secondGoalStatus, thirdGoalStatus, approveGoalNote;
    static String firstGoalName, firstGoalDescription, secondGoalName, secondGoalDescription, thirdGoalName, thirdGoalDescription;
    static int rowNum, rowNum_Index;
    static String sheetName;
    static Logger log = LogManager.getLogger(TC06_OrangeHRM_Goals.class);
    static WebDriver driver;
    private String base64;

    @BeforeMethod
    @Parameters("{testID}")
    public void prerequisite_Setup(@Optional(Config.GoalsRequestTestCase_ID) String testID) throws Exception{
        //To Create the Test in Extent Report
        logger = extent.createTest("OrangeHRMGoals_" + testID);
        Log.startTestCase(TC06_OrangeHRM_Goals.class.getName());

        //Getting Row Number from Index Sheet and TestCase Sheet
        rowNum_Index = ExcelUtils.getRowNumber(testID, "Index");
        log.info(rowNum_Index + "Row Number is picked from Index Sheet");
        sheetName = "OrangeHRM_Goals";
        rowNum = ExcelUtils.getRowNumber(testID, sheetName);
        log.info(rowNum + "Row Number is picked from " + sheetName);

        //Reading the TestData from Excel file
        userName = ExcelUtils.getCellData(sheetName,row,Config.col_UserName);
        log.info("UserName from excel sheet is :" + userName);
        password = ExcelUtils.getCellData(sheetName,row,Config.col_Password);
        log.info("Password from excel sheet is :" + password);
        employeeName = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_empName);
        log.info("EmployeeName from excel sheet is :" + employeeName);

        firstGoalPriority = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_firstGoalPriority);
        log.info("First Goal Priority from excel sheet is :" + firstGoalPriority);
        firstGoalDate = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_firstGoalDate);
        log.info("First Goal Date from excel sheet is :" + firstGoalDate);
        firstGoalName = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_firstGoalName);
        log.info("First Goal Name from excel sheet is :" + firstGoalName);
        firstGoalDescription = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_firstGoalDescription);
        log.info("First Goal Description from excel sheet is :" + firstGoalDescription);

        secondGoalPriority = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_secondGoalPriority);
        log.info("Second Goal Priority from excel sheet is :" + secondGoalPriority);
        secondGoalDate = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_secondGoalDate);
        log.info("Second Goal Date from excel sheet is :" + secondGoalDate);
        secondGoalName = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_secondGoalGoalName);
        log.info("Second Goal Name from excel sheet is :" + secondGoalName);
        secondGoalDescription = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_secondGoalGoalDescription);
        log.info("Second Goal Description from excel sheet is :" + secondGoalDescription);

        thirdGoalPriority = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_thirdGoalPriority);
        log.info("Third Goal Priority from excel sheet is :" + thirdGoalPriority);
        thirdGoalDate = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_thirdGoalDate);
        log.info("Third Goal Date from excel sheet is :" + thirdGoalDate);
        thirdGoalName = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_thirdGoalName);
        log.info("Third Goal Name from excel sheet is :" + thirdGoalName);
        thirdGoalDescription = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_thirdGoalDescription);
        log.info("Third Goal Description from excel sheet is :" + thirdGoalDescription);

        approveGoalNote = ExcelUtils.getCellData(sheetName,row,Config.col_OrangeHRMGoals_approveGoalNote);
        log.info("Approved Goal Note is :" + approveGoalNote);
    }
    @Test
    @Parameters({"browserName"})
    public void OrangeHRM_Goals(@Optional("chrome") String browserName) throws Exception {
        //Browser Launch
        driver = CommonUtils.browserLaunch(browserName);
        BaseClass ob = new BaseClass(driver);

        //Loading OrangeHRM URL
        driver.get(Config.orangeHRM_URL);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_LoginPage");
        log.info("OrangeHRM URL is loaded :" + Config.orangeHRM_URL);
        logger.log(Status.INFO, "OrangeHRM Application is loaded" + Config.orangeHRM_URL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_LoginPage").build());

        OrangeHRM_LoginPage.login(userName, password);
        log.info("OrangeHRM Login is Successful");

        OrangeHRM_HomePage.verifyTitle();
        log.info("OrangeHRM Title is Verified");
        logger.log(Status.INFO, "OrangeHRM Title is Verified");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_HomePage");
        logger.log(Status.INFO, "OrangeHRM Login is Successful", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_HomePage").build());

        //Finding Username of Employee
        OrangeHRM_HomePage.clickHrAdministrationLink();
        log.info("OrangeHRM HR Administration is clicked");

        actualUserName = OrangeHRM_UsersPage.getUserName(employeeName);
        log.info("Actual UserName received for the Employee"+employeeName+" is "+actualUserName);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_GetUserName");
        logger.log(Status.INFO, "Actual UserName received for the Employee"+employeeName+" is "+actualUserName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_GetUserName").build());

        //Finding Supervisor name
        OrangeHRM_HomePage.clickEmployeeManagementLink();
        log.info("OrangeHRM EmployeeManagement is clicked");
        supervisorName = OrangeHRM_EmployeeManagementPage.getSupervisorName(employeeName);
        log.info("SupervisorName received for the Employee"+employeeName+" is "+supervisorName);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_GetSupervisorName");
        logger.log(Status.INFO, "SupervisorName received for the Employee"+employeeName+" is "+actualUserName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_GetSupervisorName").build());

        //Finding Supervisor's username
        OrangeHRM_HomePage.clickHrAdministrationLink();
        log.info("OrangeHRM HR Administration is clicked");

        supervisorActualUserName = OrangeHRM_UsersPage.getUserName(supervisorName);
        log.info("Supervisor Actual UserName received for the Employee"+employeeName+" is "+supervisorActualUserName);
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_GetSupervisorName");
        logger.log(Status.INFO, "Supervisor Actual UserName received for the Employee"+employeeName+" is "+supervisorActualUserName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_GetSupervisorName").build());

        //Logging out from Admin Credentials
        OrangeHRM_HomePage.clickLogout();
        logger.log(Status.INFO, "Logged out from OrangeHRM application");

        //Logging in with the Employee Username
        OrangeHRM_LoginPage.login(actualUserName,password);
        log.info("Logged in with Actual UserName "+actualUserName+" of Employee credentials");

        OrangeHRM_HomePage.selectPerformance();
        log.info("OrangeHRM Performance link is clicked");

        OrangeHRM_PerformancePage.selectMyGoals();
        log.info("MyGoals Link is opened");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_SelectMyGoals");
        logger.log(Status.INFO, "MyGoals Link is opened", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_SelectMyGoals").build());

        //Create 3 goals
        OrangeHRM_GoalsPage.createGoal(firstGoalPriority,firstGoalDate, firstGoalName, firstGoalDescription);
        log.info("First Goal Creation is completed");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_CreateFirstGoal");
        logger.log(Status.INFO, "First Goal Creation is completed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_CreateFirstGoal").build());

        OrangeHRM_GoalsPage.createGoal(secondGoalPriority, secondGoalDate, secondGoalName, secondGoalDescription);
        log.info("Second Goal Creation is completed");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_CreateSecondGoal");
        logger.log(Status.INFO, "Second Goal Creation is completed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_CreateSecondGoal").build());

        OrangeHRM_GoalsPage.createGoal(thirdGoalPriority, thirdGoalDate, thirdGoalName, thirdGoalDescription);
        log.info("Third Goal Creation is completed");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_CreateThirdGoal");
        logger.log(Status.INFO, "Third Goal Creation is completed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_CreateThirdGoal").build());

        OrangeHRM_HomePage.clickLogout();
        log.info("Logged out from OrangeHRM Application");
        logger.log(Status.INFO, "Logged out from OrangeHRM Application");

        // Logging in with the supervisor username
        OrangeHRM_LoginPage.login(supervisorActualUserName,password);
        log.info("Logged in with the supervisor credentials");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_SupervisorLogin");
        logger.log(Status.INFO, "Logged in with the supervisor credentials", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_CreateThirdGoal").build());

        OrangeHRM_HomePage.selectPerformance();
        log.info("OrangeHRM Performance link is clicked");

        OrangeHRM_PerformancePage.selectGoalsList();
        log.info("GoalList Link is opened");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_GoalList");
        logger.log(Status.INFO, "GoalList Link is opened", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_GoalList").build());

        OrangeHRM_GoalsPage.supervisor_ApproveGoals(approveGoalNote);
        log.info("Supervisor Approved All Goals");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_SupervisorGoalsApproval");
        logger.log(Status.INFO, "Supervisor Approved All Goals", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_SupervisorGoalsApproval").build());

        OrangeHRM_HomePage.clickLogout();
        log.info("Logged out from OrangeHRM Application");
        logger.log(Status.INFO, "Logged out from OrangeHRM Application");

        // Logging in with the employee username
        OrangeHRM_LoginPage.login(actualUserName,password);
        log.info("Logged in with the Employee credentials");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_EmployeeLogin");
        logger.log(Status.INFO, "Logged in with the Employee credentials", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_EmployeeLogin").build());

        OrangeHRM_HomePage.selectPerformance();
        log.info("OrangeHRM Performance link is clicked");

        OrangeHRM_PerformancePage.selectMyGoals();
        log.info("MyGoals Link is opened");
        base64 = CommonUtils.takeScreenshot(screenshotsPath, "OrangeHRM_Employee_SelectMyGoals");
        logger.log(Status.INFO, "MyGoals Link is opened", MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "OrangeHRM_Employee_SelectMyGoals").build());

        //Updating Goals Progress
        OrangeHRM_GoalsPage.progress_firstGoal();
        OrangeHRM_GoalsPage.progress_secondGoal();
        OrangeHRM_GoalsPage.progress_thirdGoal();

        //First goal Verification
        firstGoalStatus = OrangeHRM_GoalsPage.verify_firstGoal();
        //Second goal Verification
        secondGoalStatus = OrangeHRM_GoalsPage.verify_secondGoal();
        //Third goal Verification
        thirdGoalStatus = OrangeHRM_GoalsPage.verify_thirdGoal();
        OrangeHRM_HomePage.clickLogout();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            ExcelUtils.setCellData(firstGoalStatus, sheetName,row, Config.col_OrangeHRMGoals_firstGoalStatus);
            log.info(firstGoalStatus+" is written back to the Excel file");
            ExcelUtils.setCellData(secondGoalStatus, sheetName,row, Config.col_OrangeHRMGoals_secondGoalStatus);
            log.info(secondGoalStatus+" is written back to the Excel file");
            ExcelUtils.setCellData(thirdGoalStatus, sheetName,row, Config.col_OrangeHRMGoals_thirdGoalStatus);
            log.info(thirdGoalStatus+" is written back to the Excel file");

            ExcelUtils.setCellData("PASSED", "Index",row_index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        }else if(result.getStatus()==ITestResult.FAILURE){
            if(!BaseClass.failureReason.equalsIgnoreCase("TestId is not found")){
                ExcelUtils.setCellData("FAILED", "Index",row_index, Config.col_Status);
                log.info("TestCase is Failed and status is updated in Excel sheet");

                ExcelUtils.setCellData(BaseClass.failureReason,"Index",row_index,Config.col_reason);
                log.info("Failure Reason is :"+BaseClass.failureReason+" and status is updated in Excel sheet");
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            ExcelUtils.setCellData("SKIPPED", "Index",row_index, Config.col_Status);
            log.info("TestCase is SKIPPED and status is updated in Excel sheet");
        }
        driver.quit();
        ExcelUtils.closeExcelFile();
        Log.endTestCase();
    }

}
