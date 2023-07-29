package pages;

import javaPrograms.oops.Inheritance_1.B;
import org.openqa.selenium.By;

public class OrangeHRM_AddEmployeePage {

        public static By link_add=By.xpath("//i[text()='add']");
        public static By txtbx_EmpFirstName = By.xpath("//input[@id='first-name-box']");
        public static By txtbx_EmpLastName= By.xpath("//input[@id='last-name-box']");

        public static By drpdwn_location= By.xpath("//div[@class='filter-option-inner-inner']");
        public static By location_indiaOption= By.xpath("//span[text()='India Office']");
        public static By location_australiaOption=By.xpath("//span[text()='Australia office']");
        public static By location_australiaHQOption=By.xpath("//span[text()='Australian Regional HQ']");
        public static By location_canadianDevCenteroption=By.xpath("//span[text()='Canadian Development Center']");
        public static By location_jamaica_trainingCenterOption=By.xpath("//span[text()='Jamaica training center']");
        public static By location_kenya_Sat_officeOption=By.xpath("//span[text()='Kenya Satalite office']");
        public static By location_mexicoOfficeOption=By.xpath("//span[text()='Mexico Office']");
        public static By location_philippine_calcenterOption=By.xpath("//span[text()='Philippine call center']");
        public static By location_singaporeregionalHQOption=By.xpath("//span[text()='Singapore Regional HQ']");
        public static By location_europeanOfficeOption=By.xpath("//span[text()='European Office']");
        public static By location_sheffieldOfficeOption=By.xpath("//span[text()='Sheffield Office']");
        public static By location_UsofficeOption=By.xpath("//span[text()='US Office']");

        public static By btn_next = By.xpath("//button[@class='btn btn-secondary']");

        public static By dropdwn_maritalStatus= By.xpath("(//div[@class='select-wrapper initialized'])[1]/input");
        public static By maritalstatus_marriedOption= By.xpath("//span[text()='Married']");
        public static By maritalstatus_otherOption= By.xpath("(//span[text()='Other'])[2]");
        public static By maritalStatus_singleOption = By.xpath("//span[text()='Single']");

        public static By dropdwn_gender=By.xpath("//div[@id='emp_gender_inputfileddiv']/div/input");
        public static By gender_maleOption=By.xpath("//span[text()='Male']");
        public static By gender_femaleOption=By.xpath("//span[text()='Female']");
        public static By gender_nonBinaryOption=By.xpath("//span[text()='Non-Binary']");

        public static By next_btn1= By.xpath("//button[@class='btn btn-secondary right']");
        public static By dropdwn_region = By.xpath("//label[text()='Region']//following-sibling::div[1]//div[text()='-- Select --']");
        public static By region_region1Option =By.xpath("//span[text()='Region-1']");
        public static By region_region2Option =By.xpath("//span[text()='Region-2']");
        public static By region_region3Option =By.xpath("//span[text()='Region-3']");

        public static By dropdwn_fteOption = By.xpath("//label[text()='FTE']//following-sibling::div[1]//div[text()='-- Select --']");
        public static By fte_Option1=By.xpath("//span[text()='0.5']");
        public static By fte_option2=By.xpath("//span[text()='0.75']");
        public static By fte_option3=By.xpath("//span[text()='1']");

        public static By dropdwn_tempDept=By.xpath("//label[text()='Temporary Department']//following-sibling::div[1]//div[text()='-- Select --']");
        public static By tempDept_subunitOneOption=By.xpath("//span[contains(text(),'Sub unit-1')]");
        public static By tempDept_subunitTwoOption=By.xpath("//span[contains(text(),'Sub unit-2')]");
        public static By tempDept_subunitThreeOption=By.xpath("//span[contains(text(),'Sub unit-3')]");
        public static By tempDept_subunitFourOption=By.xpath("//span[contains(text(),'Sub unit-4')]");

        public static By btn_save=By.xpath("//button[@ng-show='vm.showFinishButton']");
        public static By search_icon=By.xpath("//input[contains(@id,'employee_name_quick_filter')]");
        public static By txtbx_searchEmployee= By.xpath("//input[contains(@id,'employee_name_quick_filter')]");
        public static By searched_Employee =By.xpath("//div[@class='employee-details']/div[1]");



}
