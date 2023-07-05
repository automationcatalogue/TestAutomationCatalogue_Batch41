package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddEmployee_OrangeHRM {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is opened");

        driver.manage().window().maximize();
        System.out.println("Window is maximized");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("Orange HRM Website is opened");

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("user id is entered");
        Thread.sleep(3000);

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is entered");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[4]/button")).click();
        System.out.println("Login button is clicked");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"top_level_menu_item_menu_item_37\"]/a")).click();
        System.out.println("Employee button is clicked");
        Thread.sleep(10000);


        WebElement element =driver.findElement(By.id("addEmployeeButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
        //driver.findElement(By.id("addEmployeeButton")).click();
        System.out.println("Add Employee button is clicked");
        Thread.sleep(10000);

        driver.findElement(By.id("first-name-box")).sendKeys("QA");
        driver.findElement(By.id("middle-name-box")).sendKeys("Test");
        driver.findElement(By.id("last-name-box")).sendKeys("Automation");
        System.out.println("First,Middle and Last names of the employee are filled");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]")).click();
        System.out.println("Location DropDown is clicked");

        driver.findElement(By.id("bs-select-4-3")).click();
        System.out.println("Australia HQ Location is Selected");
        Thread.sleep(3000);

        driver.findElement(By.id("modal-save-button")).click();
        System.out.println("Clicking on the next Button");

        driver.findElement(By.xpath("//*[@id=\"emp_marital_status_inputfileddiv\"]/div/input")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Single')]")).click();
        driver.findElement(By.xpath("//*[@id=\"emp_gender_inputfileddiv\"]/div/input")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();

        driver.findElement(By.xpath("//*[@id=\"wizard-nav-button-section\"]/button[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"employement_details_tab\"]/custom-fields-panel/div/form/oxd-decorator[1]/div/div[1]/div/div[1]/button/div/div/div")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Region-3')]")).click();
        driver.findElement(By.xpath("//*[@id=\"employement_details_tab\"]/custom-fields-panel/div/form/oxd-decorator[1]/div/div[2]/div/div[1]/button/div/div/div")).click();
        driver.findElement(By.xpath("//span[contains(text(),'0.75')]")).click();
        driver.findElement(By.xpath("//*[@id=\"employement_details_tab\"]/custom-fields-panel/div/form/oxd-decorator[1]/div/div[3]/div/div[1]/button/div/div/div")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Sub unit-2')]")).click();
        System.out.println("All fields are Entered");

        driver.findElement(By.xpath("//*[@id=\"wizard-nav-button-section\"]/button[3]")).click();

        driver.findElement(By.xpath("//*[@id=\"menu_item_37\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"top_level_menu_item_menu_item_37\"]/a")).click();
        driver.findElement(By.id("employee_name_quick_filter_employee_list_value")).sendKeys("QA Test Automation");
        Thread.sleep(3000);

        driver.quit();
        System.out.println("Browser is closed");
    }
}
