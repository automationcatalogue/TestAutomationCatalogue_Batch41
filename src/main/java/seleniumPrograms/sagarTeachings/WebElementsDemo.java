package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsDemo {
    public static void main(String[] args) {
        System.out.println("WebElements Demo");

        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome browser window is maximized");

        /*WebDriver.Options op = driver.manage();
        WebDriver.Window wi = op.window();
        wi.maximize();*/

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("Orange HRM URL is loaded");

        By locator_userName = By.name("txtUsername");
        WebElement element_userName = driver.findElement(locator_userName);
        element_userName.sendKeys("Admin");
        System.out.println("Admin is entered as a UserName");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@12");
        System.out.println("Admin@123 is entered as a password");

        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[4]/button")).click();
        System.out.println("Login button is clicked");

        String title=driver.getTitle();
        if(title.equalsIgnoreCase("Employee Management")){
            System.out.println("Orange HRM Login is successful");
        }else{
            System.out.println("Orange HRM Login is failed");
        }



    }
}
