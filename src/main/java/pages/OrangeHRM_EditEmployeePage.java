package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;
import utilities.CommonUtils;

import java.time.Duration;

public class OrangeHRM_EditEmployeePage {
    public static By txtBox_LastName = By.xpath("//input[@id='lastName']");
    public static By link_DateOfBirthIcon = By.xpath("(//i[contains(@class,'material-icons action')])[1]");
    public static By monthDropDown_DateOfBirth = By.xpath("//div[contains(@class,'--month')]");
    public static By monthsList_DateOfBirth = By.xpath("//div[contains(@class,'--month')]//li/span");
    public static By yearDropDown_DateOfBirth =By.xpath("//div[contains(@class,'select--year')]");
    public static By yearsList_DateOfBirth = By.xpath("//div[contains(@class,'select--year')]//li/span");
    public static By datesList_DateOfBirth = By.xpath("(//table[@class='picker__table'])[1]//td");
    public static By dropDown_Nationality = By.cssSelector("#nation_code");
    public static By txt_IndiaDropDown = By.xpath("//span[text()='Indian']");
    public static By form = By.xpath("//html/body");

    public static By btn_FirstSave = By.xpath("(//button[@type='submit'])[1]");
    public static By radioBtn_NoAllergies = By.xpath("//ul[@class='radiobutton-container']/li[1]");
    public static By btn_SecondSave = By.xpath("(//button[@type='submit'])[2]");
    public static By checkBox_Kosher = By.xpath("//div[@sf-array='form']/div[4]/label");
    public static By checkBox_Vegetarian = By.xpath("//div[@sf-array='form']/div[5]/label");
    public static By btn_ThirdSave = By.xpath("(//button[@type='submit'])[2]");

    public static void enterLastName(String lastName){
        WebDriver driver = BaseClass.getDriver();

        driver.findElement(OrangeHRM_EditEmployeePage.txtBox_LastName).clear();
        System.out.println("Cleared the last name");

        driver.findElement(OrangeHRM_EditEmployeePage.txtBox_LastName).sendKeys(lastName);
        System.out.println("Updated the last name");
    }

    public static void Selection_DateOfBirth(String DateOfBirth)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_EditEmployeePage.link_DateOfBirthIcon).click();
        System.out.println("Date picker icon is clicked");

        String date = DateOfBirth;
        String date_Array[]=date.split("-");
        String day=date_Array[0];
        String month=date_Array[1];
        String year=date_Array[2];

        //month selector
        driver.findElement(OrangeHRM_EditEmployeePage.monthDropDown_DateOfBirth).click();
        CommonUtils.selectDropdownValue(OrangeHRM_EditEmployeePage.monthsList_DateOfBirth, month);

        //year selector
        driver.findElement(OrangeHRM_EditEmployeePage.yearDropDown_DateOfBirth).click();
        CommonUtils.selectDropdownValue(OrangeHRM_EditEmployeePage.yearsList_DateOfBirth, year);

        //date selector
        CommonUtils.selectDropdownValue(OrangeHRM_EditEmployeePage.datesList_DateOfBirth, day);
    }

    public static void select_Nationality(String nation_Name)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        Thread.sleep(3000);
        Select nation = new Select(driver.findElement(OrangeHRM_EditEmployeePage.dropDown_Nationality));
        nation.selectByVisibleText(nation_Name);
        System.out.println("Nationality selected as "+ nation_Name);
    }

    public static void firstSave(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_EditEmployeePage.btn_FirstSave).click();
        System.out.println("Clicked on first save button");
    }

    public static void verify_SuccessfullyUpdated(String Data){
        WebDriver driver = BaseClass.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        Boolean isSuccessful = wait.until(ExpectedConditions.textToBePresentInElementLocated(OrangeHRM_EditEmployeePage.form,"Successfully Updated"));
        if(isSuccessful){
            System.out.println(Data+" is successfully Updated");
        }else {
            System.out.println(Data+" is not Successful updated");
        }
    }

    public static void select_Allergies(String allergy)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        Thread.sleep(2000);
        if(allergy=="No") {
            driver.findElement(OrangeHRM_EditEmployeePage.radioBtn_NoAllergies).click();
            System.out.println("Radio Button for NO is selected");
        }else {
            System.out.println("Allergies radio Button is not clicked");
        }
    }

    public static void secondSave(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_EditEmployeePage.btn_SecondSave).click();
        System.out.println("Clicked on Hygiene save button");
    }

    public static void select_diet(String diet)throws Exception{
        WebDriver driver = BaseClass.getDriver();
        if(diet=="Koshler") {
            for (int i = 1; i <= 3; ++i) {
                try {
                    Thread.sleep(2000);
                    driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Kosher).click();
                    System.out.println("Dietary Requirements check-box Koshler is clicked");
                    break;
                } catch (StaleElementReferenceException se) {
                    System.out.println("Stale Element Reference Exception is occurred for " + i + " time");
                }
            }
        } else if (diet=="Vegetarian") {
            for (int i = 1; i <= 3; ++i) {
                try {
                    Thread.sleep(2000);
                    driver.findElement(OrangeHRM_EditEmployeePage.checkBox_Vegetarian).click();
                    System.out.println("Dietary Requirements check-box Vegeterian is clicked");
                    break;
                } catch (StaleElementReferenceException se) {
                    System.out.println("Stale Element Reference Exception is occurred for " + i + " time");
                }
            }
        }else {
            System.out.println("Dietary Requirement "+diet+" is not available ");
        }
    }

    public static void thirdSave(){
        WebDriver driver = BaseClass.getDriver();
        driver.findElement(OrangeHRM_EditEmployeePage.btn_ThirdSave).click();
        System.out.println("Clicked on Dietary Requirements save button");
    }


}
