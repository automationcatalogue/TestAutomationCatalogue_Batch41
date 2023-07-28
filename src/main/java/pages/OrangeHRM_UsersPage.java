package pages;

import org.openqa.selenium.By;

public class OrangeHRM_UsersPage {
    public static By link_firstUserName =By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]/td[2]//span");
    public static By icon_edit= By.xpath("//tbody[@ng-if='!listData.staticBody']/tr[1]//i");
    public static By chkbx_changePassword=By.xpath("//span[text()='Change Password']");
    public static By txtbx_enterPassword=By.xpath("(//input[@type='password'])[1]");
    public static By txtbx_confirmPassword=By.xpath("(//input[@type='password'])[2]");
    public static By btn_save =By.xpath("//button[text()='Save']");
    public static By list_users =By.xpath("//table[@class='highlight bordered']/tbody/tr/td[4]");
    // corresponding supervisor edit button
    public static By btn_edit =By.xpath(".//following-sibling::td[4]");

}
