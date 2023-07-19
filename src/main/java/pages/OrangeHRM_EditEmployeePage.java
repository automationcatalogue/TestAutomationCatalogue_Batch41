package pages;

import org.openqa.selenium.By;

public class OrangeHRM_EditEmployeePage {
    public static By txtBox_LastName = By.xpath("//input[@id='lastName']");
    public static By link_DateOfBirthIcon = By.xpath("(//i[contains(@class,'material-icons action')])[1]");
    public static By monthDropDown_DateOfBirth = By.xpath("//div[contains(@class,'--month')]");
    public static By monthsList_DateOfBirth = By.xpath("//div[contains(@class,'--month')]//li/span");
    public static By yearDropDown_DateOfBirth =By.xpath("//div[contains(@class,'select--year')]");
    public static By yearsList_DateOfBirth = By.xpath("//div[contains(@class,'select--year')]//li/span");
    public static By datesList_DateOfBirth = By.xpath("(//table[@class='picker__table'])[1]//td");
    public static By dropDown_Nationality = By.xpath("//div[contains(@id,'nation_code')]/div/input");
    public static By txt_IndiaDropDown = By.xpath("//span[text()='Indian']");
    public static By form = By.xpath("//html/body");

    public static By btn_FirstSave = By.xpath("(//button[@type='submit'])[1]");
    public static By radioBtn_NoAllergies = By.xpath("//ul[@class='radiobutton-container']/li[1]");
    public static By btn_SecondSave = By.xpath("(//button[@type='submit'])[2]");
    public static By checkBox_Kosher = By.xpath("//div[@sf-array='form']/div[4]/label");
    public static By checkBox_Vegetarian = By.xpath("//div[@sf-array='form']/div[5]/label");
    public static By btn_ThirdSave = By.xpath("(//button[@type='submit'])[2]");
    public static By btn_LogOut = By.xpath("//li[@id='navbar-logout']");
}
