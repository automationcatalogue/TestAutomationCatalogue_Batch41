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
    public static By dropdown_goalPriority = By.cssSelector("#goalPriority");
    public static By icon_dueDate = By.xpath("//i[text()='date_range']");
    public static By month_dropDown = By.xpath("//select[@title='Select a month']");
    public static By year_dropDown = By.xpath("//select[@title='Select a year']");
    public static By date_list = By.xpath("//table[@class='picker__table']/tbody/tr/td/div");
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


    public static void create_FirstGoal(String priority,String date)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_CreateGoal).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalName).sendKeys("Automation for E-Commerce Website");

        WebElement iframe_goal1 = driver.findElement(OrangeHRM_GoalsPage.iframe_GoalDescription);
        driver.switchTo().frame(iframe_goal1);
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalDescription).sendKeys("Automate the Payment Gateways for all bank debit cards and credit cards after applying promo codes");
        driver.switchTo().defaultContent();

        Select select_goal1 = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_goalPriority));
        select_goal1.selectByVisibleText(priority);

        driver.findElement(OrangeHRM_GoalsPage.icon_dueDate).click();

        String date_goal1 = date;
        String date_ArrayGoal1[] = date_goal1.split("-");
        String day_goal1 = date_ArrayGoal1[0];
        String month_goal1 = date_ArrayGoal1[1];
        String year_goal1 = date_ArrayGoal1[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal1 = new Select(driver.findElement(OrangeHRM_GoalsPage.month_dropDown));
        select_MonthGoal1.selectByVisibleText(month_goal1);
        log.info("Month is selected as :"+month_goal1);

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal1 = new Select(driver.findElement(OrangeHRM_GoalsPage.year_dropDown));
        select_YearGoal1.selectByVisibleText(year_goal1);
        log.info("Year is selected as :"+year_goal1);

        //date selector
        Thread.sleep(2000);
        CommonUtils.selectDropdownValue(OrangeHRM_GoalsPage.date_list,day_goal1);

        driver.findElement(OrangeHRM_GoalsPage.btn_Submit).click();
        log.info("First goal is successfully created");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static void create_SecondGoal(String priority,String date)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_CreateGoal).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalName).sendKeys("Automation for Telecom Website");

        WebElement iframe_goal2 = driver.findElement(OrangeHRM_GoalsPage.iframe_GoalDescription);
        driver.switchTo().frame(iframe_goal2);
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalDescription).sendKeys("Automate the new customer entries in the server and check the activation of the user");
        driver.switchTo().defaultContent();

        Select select_goal2 = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_goalPriority));
        select_goal2.selectByVisibleText(priority);

        driver.findElement(OrangeHRM_GoalsPage.icon_dueDate).click();

        String date_goal2 = date;
        String date_ArrayGoal2[] = date_goal2.split("-");
        String day_goal2 = date_ArrayGoal2[0];
        String month_goal2 = date_ArrayGoal2[1];
        String year_goal2 = date_ArrayGoal2[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal2 = new Select(driver.findElement(OrangeHRM_GoalsPage.month_dropDown));
        select_MonthGoal2.selectByVisibleText(month_goal2);
        log.info("Month is selected as :"+month_goal2);

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal2 = new Select(driver.findElement(OrangeHRM_GoalsPage.year_dropDown));
        select_YearGoal2.selectByVisibleText(year_goal2);
        log.info("Year is selected as :"+year_goal2);

        //date selector
        CommonUtils.selectDropdownValue(OrangeHRM_GoalsPage.date_list,day_goal2);

        driver.findElement(OrangeHRM_GoalsPage.btn_Submit).click();
        log.info("Second goal is successfully created");
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static void create_ThirdGoal(String priority,String date)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.btn_CreateGoal).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalName).sendKeys("Automation for Fiancial Website");

        WebElement iframe_goal3 = driver.findElement(OrangeHRM_GoalsPage.iframe_GoalDescription);
        driver.switchTo().frame(iframe_goal3);
        driver.findElement(OrangeHRM_GoalsPage.txtbx_GoalDescription).sendKeys("Automate the new customer entries with the valid account numbers and other account details");
        driver.switchTo().defaultContent();

        Select select_goal3 = new Select(driver.findElement(OrangeHRM_GoalsPage.dropdown_goalPriority));
        select_goal3.selectByVisibleText(priority);

        driver.findElement(OrangeHRM_GoalsPage.icon_dueDate).click();

        String date_goal3 = date;
        String date_ArrayGoal3[] = date_goal3.split("-");
        String day_goal3 = date_ArrayGoal3[0];
        String month_goal3 = date_ArrayGoal3[1];
        String year_goal3 = date_ArrayGoal3[2];

        //month selector
        Thread.sleep(3000);
        Select select_MonthGoal3 = new Select(driver.findElement(OrangeHRM_GoalsPage.month_dropDown));
        select_MonthGoal3.selectByVisibleText(month_goal3);
        log.info("Month is selected as :"+month_goal3);

        //year selector
        Thread.sleep(3000);
        Select select_YearGoal3 = new Select(driver.findElement(OrangeHRM_GoalsPage.year_dropDown));
        select_YearGoal3.selectByVisibleText(year_goal3);
        log.info("Year is selected as :"+year_goal3);

        //date selector
        Thread.sleep(2000);
        CommonUtils.selectDropdownValue(OrangeHRM_GoalsPage.date_list,day_goal3);

        Thread.sleep(3000);
        driver.findElement(OrangeHRM_GoalsPage.btn_Submit).click();
        log.info("Third goal is successfully created");
        Thread.sleep(3000);
        driver.findElement(OrangeHRM_GoalsPage.icon_backArrow).click();
    }

    public static void supervisor_ApproveGoals(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_GoalsPage.icon_unApprovedGoals).click();
        driver.findElement(OrangeHRM_GoalsPage.chkbx_approve).click();
        driver.findElement(OrangeHRM_GoalsPage.btn_Approve).click();
        driver.findElement(OrangeHRM_GoalsPage.txtbx_approveDescription).sendKeys("Approved all the goals for aaliyah haq on telecom, financial and E commerce domains");
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

