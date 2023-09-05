package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CommonUtils{

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

    public static void takeScreenshot(File dest) throws Exception{
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,dest);
    }

    public static void takeScreenshot(String screenshotsPath, String fileName) throws Exception{
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src= ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotsPath+"//"+fileName+".jpg");
        FileUtils.copyFile(src,dest);
    }

    public static void selectDropdownValue(By locator, String data) throws Exception{
        WebDriver driver = BaseClass.getDriver();

        List<WebElement> list_Elements = driver.findElements(locator);
        Thread.sleep(2000);
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

    public static void switchToiFrame(By locator){
        WebDriver driver = BaseClass.getDriver();
        WebElement element_frame = driver.findElement(locator);
        driver.switchTo().frame(element_frame);
        System.out.println("Switched into iFrame");
    }

    public static String generateFolderNameWithTmeStamp(){
        LocalDateTime now =LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy_HHmmss");
        String dateTime = now.format(formatter);
        return dateTime;
    }

    public static void staleElementEnterKeys(By locator, String data) throws Exception{
        for(int count=1;count<=4;++count){
            try{
                driver.findElement(locator).sendKeys(data);
                break;
            }catch (StaleElementReferenceException se){
                System.out.println("Stale Element is occurred and retrying");
                Thread.sleep(1000);
            }

        }
    }


}
