package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CommonUtils {
    public static WebDriver browserLaunch(String browserName){
        WebDriver driver=null;
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
}
