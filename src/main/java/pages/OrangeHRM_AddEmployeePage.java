package pages;

import javaPrograms.oops.Inheritance_1.B;
import org.openqa.selenium.By;

public class OrangeHRM_AddEmployeePage {

        public static By link_add=By.xpath("//i[text()='add']");
        public static By txtbx_EmpFirstName = By.xpath("//input[@id='first-name-box']");
        public static By txtbx_EmpLastName= By.xpath("//input[@id='last-name-box']");
        public static By drpdwn_location= By.xpath("//div[@class='filter-option-inner-inner']");
        public static By location_indiaOption= By.xpath("//span[text()='India Office']");
        public static By btn_next = By.xpath("//button[@class='btn btn-secondary']");
        public static By dropdwn_maritalStatus= By.xpath("(//div[@class='select-wrapper initialized'])[1]/input");
        public static By maritalStatus_singleOption = By.xpath("//span[text()='Single']");
        public static By dropdwn_gender=By.xpath("//div[@id='emp_gender_inputfileddiv']/div/input");
        public static By gender_maleOption=By.xpath("//span[text()='Male']");
        public static By next_btn1= By.xpath("//button[@class='btn btn-secondary right']");
        public static By dropdwn_region = By.xpath("//label[text()='Region']//following-sibling::div[1]//div[text()='-- Select --']");
        public static By region_region3Option =By.xpath("//span[text()='Region-3']");
        public static By dropdwn_fteOption = By.xpath("//label[text()='FTE']//following-sibling::div[1]//div[text()='-- Select --']");
        public static By fte=By.xpath("//span[contains(text(),'0.75')]");
        public static By dropdwn_tempDept=By.xpath("//label[text()='Temporary Department']//following-sibling::div[1]//div[text()='-- Select --']");
        public static By tempDept_subunittwoOption=By.xpath("//span[contains(text(),'Sub unit-2')]");
        public static By btn_save=By.xpath("//button[@ng-show='vm.showFinishButton']");
        public static By search_icon=By.xpath("//input[contains(@id,'employee_name_quick_filter')]");
        public static By txtbx_searchEmployee= By.xpath("//input[contains(@id,'employee_name_quick_filter')]");
        public static By searched_Employee =By.xpath("//div[@class='emp-name'][text()='Shawn  Desman']");



}
