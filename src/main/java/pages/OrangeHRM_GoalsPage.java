package pages;

import org.openqa.selenium.By;

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

}
