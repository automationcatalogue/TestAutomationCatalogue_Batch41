package testcases.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OrangeHRM_LoginPage;
import utilities.CommonUtils;

import java.time.Duration;

public class TC01_OrangeHRM_LoginTest {

    @Test
    @Parameters({"browserName"})
    public static void login(@Optional("chrome") String browserName) throws Exception{

        WebDriver driver = CommonUtils.browserLaunch(browserName);

        driver.get("https://testcataloguea-trials79.orangehrmlive.com");
        driver.findElement(OrangeHRM_LoginPage.txtbx_userName).sendKeys("Admin");
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys("Admin@123");
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();

        Thread.sleep(6000);

        driver.quit();
    }
}
