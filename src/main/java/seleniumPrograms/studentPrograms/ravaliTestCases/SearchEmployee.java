package seleniumPrograms.studentPrograms.ravaliTestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchEmployee {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automation41-trials79.orangehrmlive.com");
        String title = driver.getTitle();
        System.out.println("The title of the Website is"+title);
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("top-level-menu-item")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='employee-navbar-button action-icon' and @ng-click='navbar.filter()']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='emp_search_mdl_employee_id_filter']")).sendKeys("1104");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Search']")).click(); // text is a function so only having () and =''
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Charlie  Carter ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@ng-click='ohrmnavbar.logout()']")).click();
        Thread.sleep(3000);
        driver.quit();
        //driver.findElement(By.xpath("//input[@id='txtUsername']")).Sendkeys("Admin");
                ////tagname[@attribute='value']
//.findElement(By.xpath("//*[text(),'OrangeHRM, Inc']")).click();
    }
}
