package pages.orangeHRM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BaseClass;
import utilities.CommonUtils;

public class OrangeHRM_GoalsPage {
    public static By btn_CreateGoal = By.xpath("//span[text()='Create Goal']");
    public static By txtbx_GoalName = By.cssSelector("#name_value");
    public static By iframe_GoalDescription = By.xpath("//iframe[@allowtransparency='true']");
    public static By txtbx_GoalDescription = By.cssSelector("#tinymce");
    public static By dropdown_goalPriority = By.cssSelector("button[data-id='goalPriority']");
    public static By list_Priorities = By.cssSelector("button[data-id='goalPriority']+div div ul li a span");
    public static By icon_dueDate = By.xpath("//i[text()='date_range']");
    public static By drpdwn_Month = By.xpath("//select[@title='Select a month']//following-sibling::button");
    public static By list_Months = By.xpath("//select[@title='Select a month']//following-sibling::div//li//span");
    public static By drpdwn_Year = By.xpath("//select[@title='Select a year']//following-sibling::button");
    public static By list_years = By.xpath("//select[@title='Select a year']//following-sibling::div//li//span");
    public static By list_Dates = By.xpath("//table[@class='picker__table']/tbody/tr/td/div[contains(@class,'infocus')]");
    public static By btn_Submit = By.xpath("//div[@class='form-row form-buttons-row']/div[3]/button");
    public static By icon_backArrow = By.xpath("//a[@data-tooltip='My Goals']");
    //supervisor goals page
    public static By icon_unApprovedGoals = By.xpath("//i[text()='ohrm_unapproved_target']");

    public static By chkbx_approve = By.xpath("//th[@class='checkbox-th']");
    public static By btn_Approve = By.xpath("//span[text()='Approve']");
    public static By txtbx_approveDescription = By.cssSelector("#note");
    public static By btn_finalApprove = By.xpath("//button[@class='btn btn-label success']");
    public static By btn_Pending = By.xpath("//div[text()='Pending']");
    public static By link_GoalName = By.xpath("(//tr[@class='leaf collapsed'])[1]/td[2]//a");
    public static By icon_MoreDetails = By.xpath("//span[text()='More Details']");
    public static By icon_addprogress = By.xpath("//span[text()='add']");
    public static By btn_Update = By.xpath("//span[text()='Update']");
    public static By dropdown_status = By.xpath("//button[@data-id='status']");
    public static By list_status = By.xpath("//button[@data-id='status']//following-sibling::div//li//span");
    public static By btn_InProgress = By.xpath("//div[text()='In Progress']");
    public static By txt_status = By.xpath("//div[@class='secondary-data-container']/span[3]/div[2]");
    public static By btn_achieved = By.xpath("//div[text()='Achieved']");
    public static By btn_OnHold = By.xpath("//div[text()='On Hold']");
    static Logger log = LogManager.getLogger(OrangeHRM_GoalsPage.class);


    public static void createGoal(String priority,String date, String goalName, String goalDescription)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_CreateGoal).click();
        log.info("Create Goal is Clicked");

        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalName).sendKeys(goalName);
        log.info(goalName + " is entered as GoalName");

        WebElement iframe_goal1 = driver.findElement(iframe_GoalDescription);
        driver.switchTo().frame(iframe_goal1);
        log.info("Switched into iframe");
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalDescription).sendKeys(goalDescription);
        log.info(goalDescription + " is entered as Goal Description");
        driver.switchTo().defaultContent();
        log.info("Exited from the iframe");

        driver.findElement(dropdown_goalPriority).click();
        log.info("Goal Priority is clicked");
        CommonUtils.selectDropdownValue(list_Priorities, priority);

        driver.findElement(OrangeHRM_GoalsPage.icon_dueDate).click();
        CommonUtils.selectCalendarDate(date, drpdwn_Month, list_Months, drpdwn_Year, list_years, list_Dates);

        driver.findElement(OrangeHRM_GoalsPage.btn_Submit).click();
        log.info("Goal is successfully Submitted");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static void supervisor_ApproveGoals(String approveGoalNote){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.icon_unApprovedGoals).click();
        log.info("Clicked on UnApproved Goals");
        driver.findElement(OrangeHRM_GoalsPage.chkbx_approve).click();
        log.info("Checked on Approve check-box for all Goals");
        driver.findElement(OrangeHRM_GoalsPage.btn_Approve).click();
        log.info("Clicked on Approve button");
        driver.findElement(OrangeHRM_GoalsPage.txtbx_approveDescription).sendKeys(approveGoalNote);
        log.info(approveGoalNote + " is entered as Approve Goal Note");
        driver.findElement(OrangeHRM_GoalsPage.btn_finalApprove).click();
        log.info("Approved all the goals created by the employee");
    }

    public static void updateGoalPercentage(String goalPercentageData, String goalNumber){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Pending).click();
        log.info("Clicked on Pending Link");
        driver.findElement(link_GoalName).click();
        log.info("Clicked on "+goalNumber+" Goal Name");
        driver.findElement(icon_MoreDetails).click();
        log.info("Clicked on More Details Button");
        int goalPercentage = Integer.parseInt(goalPercentageData);
        for(int i=1; i<=goalPercentage; i++){
            driver.findElement(icon_addprogress).click();
        }
        log.info("Updated the "+goalNumber+" goal by "+goalPercentage+"%");
        driver.findElement(btn_Update).click();
        log.info("Update button is Clicked");
        driver.findElement(icon_backArrow).click();
        log.info("Clicked on Back Arrow button");
    }

    public static void updateGoalStatus(String status, String goalNumber) throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(btn_Pending).click();
        log.info("Clicked on Pending Link");
        driver.findElement(link_GoalName).click();
        log.info("Clicked on "+goalNumber+" Goal Name");
        driver.findElement(icon_MoreDetails).click();
        log.info("Clicked on More Details Button");
        driver.findElement(dropdown_status).click();
        log.info("Clicked on Status Drop-down");
        CommonUtils.selectDropdownValue(list_status,status);
        driver.findElement(OrangeHRM_GoalsPage.btn_Update).click();
        log.info("Updated the "+goalNumber+" goal by keeping status is "+status);
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
        log.info("Clicked on Back Arrow button");
    }

    public static void clickGoalName_VerifyStatus(String goalNumber, String expectedGoalStatus){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.link_GoalName).click();
        log.info(goalNumber + "Goal Name  is clicked");
        String goalStatus = driver.findElement(OrangeHRM_GoalsPage.txt_status).getText();
        log.info("Status of the " + goalNumber + " goal is :" + goalStatus);
        Assert.assertEquals(goalStatus, expectedGoalStatus, "Goal Status is not updated correctly");
        log.info(goalNumber + " status is updated correctly");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static void verifyInProgressGoalStatus(String goalNumber, String expectedGoalStatus) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_InProgress).click();
        log.info("InProgress button is clicked");
        clickGoalName_VerifyStatus(goalNumber, expectedGoalStatus);
    }

    public static void verifyAchievedGoalStatus(String goalNumber, String expectedGoalStatus) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_achieved).click();
        log.info("Achieved button is clicked");
        clickGoalName_VerifyStatus(goalNumber, expectedGoalStatus);
    }

    public static void verifyOnHoldGoalStatus(String goalNumber, String expectedGoalStatus) {
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_OnHold).click();
        log.info("OnHold button is clicked");
        clickGoalName_VerifyStatus(goalNumber, expectedGoalStatus);
    }

}

