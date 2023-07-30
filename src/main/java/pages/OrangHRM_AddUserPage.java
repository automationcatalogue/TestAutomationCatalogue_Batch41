package pages;

import org.openqa.selenium.By;

public class OrangHRM_AddUserPage {
    public static By txtbx_EmployeeName = By.xpath("//input[@id='selectedEmployee_value']");
    public static By icon_AddUser=By.xpath("//i[@class='material-icons'][text()='add']");

    public static By txtbx_RandomUserName=By.xpath("//input[@id='user_name']");
public static By txtbx_Pwd=By.xpath("//input[@placeholder='Enter Password']");
public static By txtbx_ConfirmPwd=By.xpath("//input[@placeholder='Confirm Password']");
public static By btn_Save=By.xpath("//button[@id='modal-save-button']");

public static By empName_Visibility=By.xpath("//div[@id='systemUserDiv']//table//tbody/tr[1]/td[2]//span[text()]");
public static By empName_DropdownVisibility=By.xpath("//div[@id='selectedEmployee_dropdown']//div[@class='title-section']");


}