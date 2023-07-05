package seleniumPrograms.studentPrograms.ramyaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchEmployee1 {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");
        driver.manage().window().maximize();
        System.out.println("Maximized chrome browser window");

        driver.get("https://automation41-trials79.orangehrmlive.com/auth/login");
        System.out.println("Orange HRM Website is Loaded");

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("Email is entered");
        Thread.sleep(2000);

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[4]/button")).click();
        System.out.println("login button is clicked");

        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/header/nav/top-menu/div/div[1]/div[2]/top-level-menu-item[1]/div/a")).click();
        System.out.println("Clicked on Employee List");

        driver.findElement(By.id("employee_name_quick_filter_employee_list_value")).sendKeys("1104");
        System.out.println("searched for the employee number 1104");
        Thread.sleep(3000);
        driver.findElement(By.id("quick_search_icon")).click();
        System.out.println("searched for the employee 1104 ");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//td[contains(text(),'Carter')]")).click();
        System.out.println("Clicked on Charlie Carter link");

        Thread.sleep(7000);

        driver.findElement((By.xpath("//*[@id=\"navbar-logout\"]/a/span"))).click();
        System.out.println("Clicked on logout");

        Thread.sleep(15000);

        driver.close();
        System.out.println("Closing the browser");


    }
}
