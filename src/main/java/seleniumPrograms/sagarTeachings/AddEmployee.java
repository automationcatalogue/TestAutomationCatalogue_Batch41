package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.webdriverPrograms.Config.OrangeHRMData;
import selenium.webdriverPrograms.Config.OrangeHRMLocators;

import java.util.List;

public class AddEmployee {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("OrangeHRM website is launched");

        driver.findElement(By.xpath(OrangeHRMLocators.txtbx_UserName)).sendKeys(OrangeHRMData.userName);
        System.out.println("Admin is entered as a UserName");

        driver.findElement(By.xpath(OrangeHRMLocators.txtbx_Password)).sendKeys(OrangeHRMData.password);
        System.out.println("Admin@123 is entered a Password");

        driver.findElement(By.xpath(OrangeHRMLocators.btn_Login)).click();
        System.out.println("Login button is clicked");
        Thread.sleep(10000);

        driver.findElement(By.xpath(OrangeHRMLocators.link_EmployeeList)).click();
        System.out.println("Employee List link is clicked");
        Thread.sleep(12000);

        driver.findElement(By.xpath(OrangeHRMLocators.btn_AddEmployee)).click();
        System.out.println("Add Employee button is clicked");
        Thread.sleep(12000);

        driver.findElement(By.xpath(OrangeHRMLocators.txtbx_firstName)).sendKeys(OrangeHRMData.firstName);
        System.out.println("FirstName is entered");

        driver.findElement(By.xpath(OrangeHRMLocators.txtbx_lastName)).sendKeys(OrangeHRMData.lastName);
        System.out.println("LastName is entered");

        driver.findElement(By.xpath(OrangeHRMLocators.drpdwn_Location)).click();
        System.out.println("Location drop-down is clicked");
        Thread.sleep(2000);

        //driver.findElement(By.xpath(OrangeHRMLocators.list_MexicoOffice)).click();
        //System.out.println("Location value is clicked");

        List<WebElement> elements = driver.findElements(By.xpath(OrangeHRMLocators.list_Locations));
        for(int i=0;i<elements.size();i++){
            WebElement locationElement = elements.get(i);
            String actualLocation = locationElement.getText();
            if(actualLocation.equalsIgnoreCase(OrangeHRMData.location)){
                locationElement.click();
                break;
            }
        }














    }
}
