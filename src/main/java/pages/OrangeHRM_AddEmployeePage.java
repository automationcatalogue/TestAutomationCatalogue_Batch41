package pages;

import javaPrograms.oops.Inheritance_1.B;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;
import utilities.CommonUtils;

import java.time.Duration;

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
        public static By employee_id= By.xpath("//div[text()='Employee Id: ']/span");
        static Logger log = LogManager.getLogger(OrangeHRM_AddEmployeePage.class);

        public static void enterFirstName_LastName_Location(String firstName, String lastName, String location){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(txtbx_EmpFirstName).sendKeys(firstName);
                log.info("First Name is entered");
                driver.findElement(txtbx_EmpLastName).sendKeys(lastName);
                log.info("Last Name is entered");
                selectLocation(location);
                driver.findElement(btn_next).click();
                log.info("Next button is clicked");
        }


        public static void enterFirstNameAndLastName(String firstName, String lastName){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(link_add).click();
                log.info("Clicked on Add button ");

                driver.findElement(txtbx_EmpFirstName).sendKeys(firstName);
                log.info("First Name is entered");

                driver.findElement(txtbx_EmpLastName).sendKeys(lastName);
                log.info("Last Name is entered");
        }

        public static void selectLocation(String location){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(drpdwn_location).click();
                log.info("Location drop-down is clicked ");

                if (location.equals("India Office")) {
                        driver.findElement(location_indiaOption).click();
                        log.info("India Office value is selected from a drop-down");
                } else if (location.equals("Australia office")) {
                        driver.findElement(location_australiaOption).click();
                        log.info("Australia office value is selected from a drop-down");
                } else if (location.equals("Australian Regional HQ")) {
                        driver.findElement(location_australiaHQOption).click();
                        log.info("Australian Regional HQ value is selected from a drop-down");

                } else if (location.equals("Canadian Development Center")) {
                        driver.findElement(location_canadianDevCenteroption).click();
                        log.info("Canadian Development Center value is selected from a drop-down");
                } else if (location.equals("Jamaica training center")) {
                        driver.findElement(location_jamaica_trainingCenterOption).click();
                        log.info("Jamaica training center value is selected from a drop-down");

                } else if (location.equals("Kenya Satalite office")) {
                        driver.findElement(location_kenya_Sat_officeOption).click();
                        log.info("Kenya Satalite office value is selected from a drop-down");
                } else if (location.equals("Mexico Office")) {
                        driver.findElement(location_mexicoOfficeOption).click();
                        log.info("Mexico Office value is selected from a drop-down");
                } else if (location.equals("Philippine call center")) {
                        driver.findElement(location_philippine_calcenterOption).click();
                        log.info("Philippine call center value is selected from a drop-down");
                } else if (location.equals("Singapore Regional HQ")) {
                        driver.findElement(location_singaporeregionalHQOption).click();
                        log.info("Singapore Regional HQ value is selected from a drop-down");
                } else if (location.equals("European Office")) {
                        driver.findElement(location_europeanOfficeOption).click();
                        log.info("European Office value is selected from a drop-down");
                } else if (location.equals("Sheffield Office")) {
                        driver.findElement(location_sheffieldOfficeOption).click();
                        log.info("Sheffield Office value is selected from a drop-down");
                } else if (location.equals("US Office")){
                        driver.findElement(location_UsofficeOption).click();
                        log.info("US Office value is selected from a drop-down");
                } else {
                        log.info("Location not found");
                }

                driver.findElement(btn_next).click();
                log.info("Next button is clicked");
        }


        public static void clickMaritalStatus_Gender(String marital_Status, String gender){
                selectMaritalStatus(marital_Status);
                selectGender(gender);
        }

        public static void selectMaritalStatus(String marital_Status){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(dropdwn_maritalStatus).click();
                log.info("Marital Status drop-down is clicked");

                if (marital_Status.equals("Single")) {
                        driver.findElement(maritalStatus_singleOption).click();
                        log.info("Single is selected");
                } else if (marital_Status.equals("Married")) {
                        driver.findElement(maritalstatus_marriedOption).click();
                        log.info("Married is selected");
                } else if (marital_Status.equals("Other")) {
                        driver.findElement(maritalstatus_otherOption).click();
                        log.info("Marital_status is selected as Other");
                } else {
                        log.info("Marital Status is not found");
                }
        }

        public static void selectGender(String gender){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(dropdwn_gender).click();
                log.info("Gender drop-down is clicked");

                if (gender.equals("Male")) {
                        driver.findElement(gender_maleOption).click();
                        log.info("Male is selected");
                } else if (gender.equals("Female")) {

                        driver.findElement(gender_femaleOption).click();
                        log.info("Male is selected");
                } else if (gender.equals("Non-Binary")) {
                        driver.findElement(gender_nonBinaryOption).click();
                        log.info("Male is selected");
                } else {
                        log.info("gender is not found");
                }

                driver.findElement(next_btn1).click();
                log.info("Clicked on Next");
        }

        public static void selectRegion(String region) {
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(dropdwn_region).click();
                log.info("Region drop-down is clicked");
                if (region.equals("Region-1")) {
                        driver.findElement(region_region1Option).click();
                        log.info("Region-1 is selected ");
                } else if (region.equals("Region-2")) {
                        driver.findElement(region_region2Option).click();
                        log.info("Region-2 is selected ");
                } else if (region.equals("Region-3")) {
                        driver.findElement(region_region3Option).click();
                        log.info("Region-3 is selected ");
                } else {
                        log.info("region is not found");
                }
        }
        public static void selectFTE(String fte){
                WebDriver driver = BaseClass.getDriver();
                driver.findElement(dropdwn_fteOption).click();
                log.info("FTE drop-down is clicked");

                if (fte.equals("0.5")) {
                        driver.findElement(fte_Option1).click();
                        log.info("0.75 is selected");
                } else if (fte.equals("0.75")){
                        driver.findElement(fte_option2).click();
                        log.info("0.75 is selected");
                } else if (fte.equals("1")) {
                        driver.findElement(fte_option3).click();
                        log.info("0.75 is selected");
                } else {
                        log.info("FTE is not found");
                }
        }
         public static void selectTempDept(String temp_dept){

                 WebDriver driver = BaseClass.getDriver();
                 driver.findElement(dropdwn_tempDept).click();
                 log.info("Temp Department drop-down is clicked");

                 if (temp_dept.equals("Sub unit -1")) {
                         driver.findElement(tempDept_subunitOneOption).click();
                         log.info("Sub unit -2 is selected");
                 } else if (temp_dept.equals("Sub unit-2")) {
                         driver.findElement(tempDept_subunitTwoOption).click();
                         log.info("Sub unit -2 is selected");
                 } else if (temp_dept.equals("Sub unit-3")) {
                         driver.findElement(tempDept_subunitThreeOption).click();
                         log.info("Sub unit -2 is selected");
                 } else if (temp_dept.equals("Sub unit-4")) {
                         driver.findElement(tempDept_subunitFourOption).click();
                         log.info("Sub unit -2 is selected");
                 } else {
                         log.info("TempDepartment is not found");
                 }

                 driver.findElement(btn_save).click();
                 log.info("clicked on Save");
         }

         public static void selectFTE_Region_TempDepartment(String region, String fte, String temp_dept){
                selectFTE(fte);
                selectRegion(region);
                selectTempDept(temp_dept);
         }

         public static void searchEmployee(String firstName, String lastName) throws Exception{
                 WebDriver driver = BaseClass.getDriver();
                 CommonUtils.staleElementEnterKeys(search_icon,firstName+" "+ lastName);
                 driver.findElement(txtbx_searchEmployee).click();
                 log.info("Searched with Employee first and last name");
         }

         public static String verifyEmployeeId_name(String firstName, String lastName){
                 WebDriver driver = BaseClass.getDriver();
                 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                 WebElement searchedEmployeeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(OrangeHRM_AddEmployeePage.searched_Employee));
                 String elementText = searchedEmployeeElement.getText().trim();
                 log.info("Element Text is: " + elementText);


                 String expectedFullName = firstName + " " + lastName;
                 if (elementText.equalsIgnoreCase(expectedFullName)) {
                         log.info("Search result is correct");
                 } else {
                         log.info("Search result is incorrect");
                 }
                 String empid=driver.findElement(employee_id).getText();
                 log.info("Employee id is :" + empid);
                 return empid;
         }
}
