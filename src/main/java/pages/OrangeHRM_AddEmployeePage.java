package pages;

import javaPrograms.oops.Inheritance_1.B;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

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

        public static void enterFirstNameAndLastName(String firstName, String lastName){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(OrangeHRM_AddEmployeePage.link_add).click();
                System.out.println("Clicked on Add button ");

                driver.findElement(OrangeHRM_AddEmployeePage.txtbx_EmpFirstName).sendKeys(firstName);
                System.out.println("First Name is entered");

                driver.findElement(OrangeHRM_AddEmployeePage.txtbx_EmpLastName).sendKeys(lastName);
                System.out.println("Last Name is entered");
        }

        public static void selectLocation(String location){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(OrangeHRM_AddEmployeePage.drpdwn_location).click();
                System.out.println("Location drop-down is clicked ");

                if (location.equals("India Office")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_indiaOption).click();
                        System.out.println("India Office value is selected from a drop-down");
                } else if (location.equals("Australia office")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_australiaOption).click();
                        System.out.println("Australia office value is selected from a drop-down");
                } else if (location.equals("Australian Regional HQ")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_australiaHQOption).click();
                        System.out.println("Australian Regional HQ value is selected from a drop-down");

                } else if (location.equals("Canadian Development Center")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_canadianDevCenteroption).click();
                        System.out.println("Canadian Development Center value is selected from a drop-down");
                } else if (location.equals("Jamaica training center")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_jamaica_trainingCenterOption).click();
                        System.out.println("Jamaica training center value is selected from a drop-down");

                } else if (location.equals("Kenya Satalite office")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_kenya_Sat_officeOption).click();
                        System.out.println("Kenya Satalite office value is selected from a drop-down");
                } else if (location.equals("Mexico Office")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_mexicoOfficeOption).click();
                        System.out.println("Mexico Office value is selected from a drop-down");
                } else if (location.equals("Philippine call center")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_philippine_calcenterOption).click();
                        System.out.println("Philippine call center value is selected from a drop-down");
                } else if (location.equals("Singapore Regional HQ")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_singaporeregionalHQOption).click();
                        System.out.println("Singapore Regional HQ value is selected from a drop-down");
                } else if (location.equals("European Office")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_europeanOfficeOption).click();
                        System.out.println("European Office value is selected from a drop-down");
                } else if (location.equals("Sheffield Office")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.location_sheffieldOfficeOption).click();
                        System.out.println("Sheffield Office value is selected from a drop-down");
                } else if (location.equals("US Office")){
                        driver.findElement(OrangeHRM_AddEmployeePage.location_UsofficeOption).click();
                        System.out.println("US Office value is selected from a drop-down");
                } else {
                        System.out.println("Location not found");
                }

                driver.findElement(OrangeHRM_AddEmployeePage.btn_next).click();
                System.out.println("Next button is clicked");
        }

        public static void selectMaritalStatus(String marital_Status){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_maritalStatus).click();
                System.out.println("Marital Status drop-down is clicked");

                if (marital_Status.equals("Single")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.maritalStatus_singleOption).click();
                        System.out.println("Single is selected");
                } else if (marital_Status.equals("Married")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.maritalstatus_marriedOption).click();
                        System.out.println("Married is selected");
                } else if (marital_Status.equals("Other")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.maritalstatus_otherOption).click();
                        System.out.println("Marital_status is selected as Other");
                } else {
                        System.out.println("Marital Status is not found");
                }
        }

        public static void selectGender(String gender){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_gender).click();
                System.out.println("Gender drop-down is clicked");

                if (gender.equals("Male")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.gender_maleOption).click();
                        System.out.println("Male is selected");
                } else if (gender.equals("Female")) {

                        driver.findElement(OrangeHRM_AddEmployeePage.gender_femaleOption).click();
                        System.out.println("Male is selected");
                } else if (gender.equals("Non-Binary")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.gender_nonBinaryOption).click();
                        System.out.println("Male is selected");
                } else {
                        System.out.println("gender is not found");
                }

                driver.findElement(OrangeHRM_AddEmployeePage.next_btn1).click();
                System.out.println("Clicked on Next");
        }

        public static void selectRegion(String region) {
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_region).click();
                System.out.println("Region drop-down is clicked");
                if (region.equals("Region-1")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.region_region1Option).click();
                        System.out.println("Region-1 is selected ");
                } else if (region.equals("Region-2")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.region_region2Option).click();
                        System.out.println("Region-2 is selected ");
                } else if (region.equals("Region-3")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.region_region3Option).click();
                        System.out.println("Region-3 is selected ");
                } else {
                        System.out.println("region is not found");
                }
        }
        public static void selectFTE(String fte){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_fteOption).click();
                System.out.println("FTE drop-down is clicked");

                if (fte.equals("0.5")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.fte_Option1).click();
                        System.out.println("0.75 is selected");
                } else if (fte.equals("0.75")){
                        driver.findElement(OrangeHRM_AddEmployeePage.fte_option2).click();
                        System.out.println("0.75 is selected");
                } else if (fte.equals("1")) {
                        driver.findElement(OrangeHRM_AddEmployeePage.fte_option3).click();
                        System.out.println("0.75 is selected");
                } else {
                        System.out.println("FTE is not found");
                }
        }
         public static void selectTempDept(String temp_dept){

                 WebDriver driver = BaseClass.getDriver();
                 driver.findElement(OrangeHRM_AddEmployeePage.dropdwn_tempDept).click();
                 System.out.println("Temp Department drop-down is clicked");

                 if (temp_dept.equals("Sub unit -1")) {
                         driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitOneOption).click();
                         System.out.println("Sub unit -2 is selected");
                 } else if (temp_dept.equals("Sub unit-2")) {
                         driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitTwoOption).click();
                         System.out.println("Sub unit -2 is selected");
                 } else if (temp_dept.equals("Sub unit-3")) {
                         driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitThreeOption).click();
                         System.out.println("Sub unit -2 is selected");
                 } else if (temp_dept.equals("Sub unit-4")) {
                         driver.findElement(OrangeHRM_AddEmployeePage.tempDept_subunitFourOption).click();
                         System.out.println("Sub unit -2 is selected");
                 } else {
                         System.out.println("TempDepartment is not found");
                 }

                 driver.findElement(OrangeHRM_AddEmployeePage.btn_save).click();
                 System.out.println("clicked on Save");
         }
         public static void searchEmployee(String firstName, String lastName){
                 WebDriver driver = BaseClass.getDriver();
                 driver.findElement(OrangeHRM_AddEmployeePage.search_icon).sendKeys(firstName+" "+ lastName);
                 driver.findElement(OrangeHRM_AddEmployeePage.txtbx_searchEmployee).click();
                 System.out.println("Searched with Employee first and last name");
         }

}
