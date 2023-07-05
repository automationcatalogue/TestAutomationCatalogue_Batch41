package seleniumPrograms.studentPrograms.HarithaTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddUser {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome driver is launched");
        driver.manage().window().maximize();
        System.out.println("Chrome window is maximized");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("website is launched");

        String title = driver.getTitle();
        System.out.println("Title of the page is:" + title);

        WebElement UserName=driver.findElement(By.id("txtUsername"));
        UserName.sendKeys("Admin");
        Thread.sleep(3000);
        System.out.println("Username is entered");

        WebElement Password=driver.findElement(By.id("txtPassword"));
        Password.sendKeys("Admin@123");
        Thread.sleep(3000);
        System.out.println("Password is entered");

        WebElement Login=driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[4]/button"));
        Login.click();
        System.out.println("Login is done");
        Thread.sleep(5000);

        String TitleofPage = driver.getTitle();
        if (TitleofPage.equalsIgnoreCase("Employee Management")) {
            System.out.println("Employee Management Page is launched");
        } else {
            System.out.println("Employee Management Page launching is failed");
        }
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"menu_item_81\"]")).click();
        System.out.println("HR Administration page is launched");

        String TitleofPageHR = driver.getTitle();
        if (TitleofPageHR.equalsIgnoreCase("HR Administration")) {
            System.out.println("HR Administration Page is launched");
        } else {
            System.out.println("HR Administration Page launching is failed");
        }
        Thread.sleep(8000);

        driver.findElement(By.xpath("//i[contains(text(),'add')]")).click();
        System.out.println("Clicked on add icon in HR Administration Page");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys("Harry Vuppu");
        System.out.println("Entered Employee Name");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//body/div[@id='modal-holder']/div[1]/div[1]/div[1]/div[2]/form[1]/oxd-decorator[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/span[1]")).click();
        System.out.println("Selected Harry Vuppu from drop down");

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Harry2");
        System.out.println("Entered User Name");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@1234");
        System.out.println("Entered Password");

        driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys("Admin@1234");
        System.out.println("Entered Confirm Password");

        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("Clicked on save button");

        Thread.sleep(8000);

        WebElement Logout=driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
        Logout.click();
        System.out.println("Logout is performed");
        Thread.sleep(5000);

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("website is launched");

        UserName.sendKeys("Harry1");
        Thread.sleep(3000);
        System.out.println("Username is entered");

        Password.sendKeys("Admin@1234");
        Thread.sleep(3000);
        System.out.println("Password is entered");

        Login.click();
        System.out.println("Login is done");
        Thread.sleep(5000);

        Logout.click();
        System.out.println("Logout is performed");
        Thread.sleep(2000);

        driver.quit();




    }


    }
