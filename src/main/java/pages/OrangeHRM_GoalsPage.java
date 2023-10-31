package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
    public static By list_years = By.xpath("///select[@title='Select a year']//following-sibling::div//li//span");
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
    public static By link_ApprovedGoals = By.xpath("(//tr[@class='leaf collapsed'])[1]/td[2]//a");
    public static By icon_MoreDetails = By.xpath("//span[text()='More Details']");
    public static By icon_addprogress = By.xpath("//span[text()='add']");
    public static By btn_Update = By.xpath("//span[text()='Update']");
    public static By dropdown_status = By.cssSelector("#status");
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
        String[] date_ArrayGoal = date.split("-");
        String day_goal = date_ArrayGoal[0];
        String month_goal = date_ArrayGoal[1];
        String year_goal = date_ArrayGoal[2];

        //month selector
        driver.findElement(drpdwn_Month).click();
        log.info("Clicked on Month Drop-down in Due Date");
        CommonUtils.selectDropdownValue(list_Months, month_goal);

        //year selector
        driver.findElement(drpdwn_Year).click();
        log.info("Clicked on Year Drop-down in Due Date");
        CommonUtils.selectDropdownValue(list_years, year_goal);

        //date selector
        CommonUtils.selectDropdownValue(list_Dates,day_goal);

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

    public static void progress_firstGoal(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_Pending).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.icon_MoreDetails).click();

        for(int i=1; i<=25; i++){
            driver.findElement(OrangeHRM_GoalsPage.icon_addprogress).click();
        }
        driver.findElement(OrangeHRM_GoalsPage.btn_Update).click();
        log.info("Updated the first goal by 25%");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static void progress_secondGoal(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_Pending).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.icon_MoreDetails).click();

        for(int i=1; i<=100; i++){
            driver.findElement(OrangeHRM_GoalsPage.icon_addprogress).click();
        }
        driver.findElement(OrangeHRM_GoalsPage.btn_Update).click();
        log.info("Updated the second goal by 100%");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static void progress_thirdGoal(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_Pending).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.icon_MoreDetails).click();

        Select status = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_status));
        status.selectByVisibleText("On Hold");
        driver.findElement(OrangeHRM_GoalsPage.btn_Update).click();
        log.info("Updated the third goal by keeping it in On Hold");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static String verify_firstGoal(){
        WebDriver driver = BaseClass.getDriver();
        String firstGoal_status = "null";
        driver.findElement(OrangeHRM_GoalsPage.btn_InProgress).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        for(int i=1; i<=3; i++){
            try {
                firstGoal_status = driver.findElement(OrangeHRM_GoalsPage.txt_status).getText();
                log.info("Status of the first goal is :"+firstGoal_status);
                break;
            }catch (StaleElementReferenceException se){
                log.info("Text not found");
            }
        }
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
        return firstGoal_status;
    }

    public static String verify_secondGoal(){
        WebDriver driver = BaseClass.getDriver();
        String secondGoal_status = "null";
        driver.findElement(OrangeHRM_GoalsPage.btn_achieved).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        for(int i=1; i<=3; i++){
            try {
                secondGoal_status= driver.findElement(OrangeHRM_GoalsPage.txt_status).getText();
                log.info("Status of the second goal is :"+secondGoal_status);
                break;
            }catch (StaleElementReferenceException se){
                log.info("Text not found");
            }
        }
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
        return secondGoal_status;
    }

    public static String verify_thirdGoal(){
        WebDriver driver = BaseClass.getDriver();
        String thirdGoal_status = "null";
        driver.findElement(OrangeHRM_GoalsPage.btn_OnHold).click();
        driver.findElement(OrangeHRM_GoalsPage.link_ApprovedGoals).click();
        for (int i=1; i<=3; i++){
            try {
                thirdGoal_status = driver.findElement(OrangeHRM_GoalsPage.txt_status).getText();
                log.info("Status of the third goal is :"+thirdGoal_status);
                break;
            }catch (StaleElementReferenceException se){
                log.info("Text is not found");
            }
        }
        return thirdGoal_status;
    }
}

