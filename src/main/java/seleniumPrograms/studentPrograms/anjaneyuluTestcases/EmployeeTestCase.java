package seleniumPrograms.studentPrograms.anjaneyuluTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeTestCase {
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
        System.out.println("employee list button is clicked");
        Thread.sleep(3000);

        driver.findElement(By.id("employee_name_quick_filter_employee_list_value")).sendKeys("1104");
        System.out.println("Employee id is entered");
        Thread.sleep(3000);

        driver.findElement(By.id("employee_name_quick_filter_employee_list_value")).click();
        System.out.println("selected the employee");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"navbar-logout\"]/a/span")).click();
        System.out.println("logged out from the session");
        Thread.sleep(3000);

        driver.quit();
        System.out.println("Browser is closed");

    }
}
