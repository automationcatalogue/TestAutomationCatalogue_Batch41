package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.OrangeHRM_EditEmployeePage;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class CommonUtils {

    static WebDriver driver;

    public static WebDriver browserLaunch(String browserName){
        driver=null;
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else if(browserName.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }else{
            System.out.println("Invalid browser name is provided");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

    public static void takeScreenshot(String fileName) throws Exception{
        TakesScreenshot ts = (TakesScreenshot)driver;
        String projectPath = System.getProperty("user.dir");
        File dest = new File(projectPath+"\\screenshots\\"+fileName+".jpg");
        File src= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,dest);
    }

    public static void selectDropdownValue(By locator, String data){
        WebDriver driver = BaseClass.getDriver();

        List<WebElement> list_Elements = driver.findElements(locator);
        for (WebElement element:list_Elements)
        {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(data)){
                element.click();
                System.out.println("selected "+elementText+" from a list of values");
                break;
            }
        }
    }
}
