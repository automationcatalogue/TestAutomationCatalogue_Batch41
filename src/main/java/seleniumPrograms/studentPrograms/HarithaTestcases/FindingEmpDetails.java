package seleniumPrograms.studentPrograms.HarithaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingEmpDetails {
    public static void main(String[] args) throws Exception {

        WebDriver driver= new ChromeDriver();

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
        Thread.sleep(2000);

        driver.findElement(By.className("top-level-menu-item")).click();
        System.out.println("Employee List is selected");
        Thread.sleep(10000);

        driver.findElement(By.id("employee_name_quick_filter_employee_list_value")).sendKeys("1104");
        System.out.println("Entered 1104 in search box field");
        Thread.sleep(3000);

        driver.findElement(By.id("quick_search_icon")).click();
        System.out.println("Clicked on Search icon");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//td[contains(text(),'Carter')]")).click();
        System.out.println("From the search result clicked on Charlie Carter link");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        System.out.println("Logout is performed");
        Thread.sleep(3000);

        driver.quit();

    }
}
