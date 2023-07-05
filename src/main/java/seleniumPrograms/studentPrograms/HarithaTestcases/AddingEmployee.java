package seleniumPrograms.studentPrograms.HarithaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingEmployee {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome driver is launched");
        driver.manage().window().maximize();
        System.out.println("Chrome window is maximized");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("website is launched");

        String title=driver.getTitle();
        System.out.println("Title of the page is:"+title);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        Thread.sleep(3000);
        System.out.println("Username is entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        Thread.sleep(3000);
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[4]/button")).click();
        System.out.println("Login is done");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"menu_item_37\"]/span")).click();
        System.out.println("Clicked on Employee Management");

        String titleofPage=driver.getTitle();
        if(titleofPage.equalsIgnoreCase("Employee Management"))
        {
            System.out.println("Employee Management Page is launched");
        }
        else {
            System.out.println("Employee Management Page launching is failed");
        }
        Thread.sleep(10000);
        WebElement add=driver.findElement(By.id("addEmployeeButton"));
        System.out.println("Clicked on employee add button");

        add.click();

        Thread.sleep(10000);

        driver.findElement(By.cssSelector("#first-name-box")).sendKeys("Harry");
        System.out.println("Name is entered into firstname box field");

        driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys("Vuppu");
        System.out.println("Last name is entered into lastname box field");

        driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Canadian Development Center')]")).click();
        System.out.println("Canadian Development Center location is selected");

        driver.findElement(By.id("modal-save-button")).click();
        System.out.println("Clicked on next button");

        Thread.sleep(8000);

        driver.findElement(By.xpath("//*[@id=\"emp_marital_status_inputfileddiv\"]/div/input")).click();
        System.out.println("Marital status drop-down filed is selected");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Single')]")).click();
        System.out.println("Selected Marital status as single");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"emp_gender_inputfileddiv\"]/div/input")).click();
        System.out.println("Gender drop-down field is selected");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"emp_gender_inputfileddiv\"]/div/input")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Female')]")).click();
        System.out.println("Female is selected as gender");

        driver.findElement(By.xpath("//*[@id=\"wizard-nav-button-section\"]/button[2]")).click();
        System.out.println("Clicked on next button");

        Thread.sleep(8000);

        driver.findElement(By.xpath("//*[@id=\"employement_details_tab\"]/custom-fields-panel/div/form/oxd-decorator[1]/div/div[1]/div/div[1]/button/div/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Region-3')]")).click();
        System.out.println("Selected Region as Region-3");

        driver.findElement(By.xpath("//*[@id=\"employement_details_tab\"]/custom-fields-panel/div/form/oxd-decorator[1]/div/div[2]/div/div[1]/button/div/div/div")).click();
        System.out.println("Selected FTE drop-down field");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'0.75')]")).click();
        //driver.findElement(By.cssSelector("div.angular.core-page.oxd:nth-child(7) div.sidebarProfile div.menu-visible section.content div.shuffle-animation:nth-child(3) div.pim-container.wizard:nth-child(1) div.pim-container.oxd-form-container:nth-child(1) div.form-div.custom-fields-standard.custom-fields-oxd form.ng-valid.ng-valid-schema-form.ng-dirty.ng-valid-parse div.form-row div.form-group.col-4:nth-child(3) div.input-group.form-select div.dropdown.bootstrap-select.select-dropdown.ng-not-empty.ng-dirty.ng-valid-parse:nth-child(2) button.btn.dropdown-toggle div.filter-option div.filter-option-inner > div.filter-option-inner-inner")).click();
        System.out.println("Selected FTE as 0.75");

        driver.findElement(By.xpath("//*[@id=\"employement_details_tab\"]/custom-fields-panel/div/form/oxd-decorator[1]/div/div[3]/div/div[1]/button/div/div/div")).click();
        System.out.println("clicked on temporary Department drop-down");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Sub unit-2')]")).click();
        System.out.println("selected Sub Unit-2 as Temporary Department ");

        driver.findElement(By.xpath("//*[@id=\"wizard-nav-button-section\"]/button[3]")).click();
        System.out.println("Saved the Employee data");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"menu_item_37\"]")).click();
        System.out.println("Clicked on Employee Management");

        driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys("Harry Vuppu");
        System.out.println("Entered search name");

        driver.findElement(By.xpath("//*[@id=\"quick_search_icon\"]")).click();
        System.out.println("Clicked on search icon");
        Thread.sleep(5000);
        WebElement SearchResult=driver.findElement(By.xpath("//div[contains(text(),'Harry  Vuppu')]"));
        String Harry=SearchResult.getText();
        if(Harry.contains("Harry Vuppu")){
            System.out.println("New Employee is added");
        }
        else {
            System.out.println("New Employee is not added");
        }
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        System.out.println("Logout is performed");
        Thread.sleep(10000);

        driver.quit();


    }
}
