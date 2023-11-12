package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class CommonUtils {

    static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    private static String dateTime;
    static Logger log = LogManager.getLogger(CommonUtils.class);

    public static WebDriver browserLaunch(String browserName) {
        driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid browser name is provided");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

    public static void takeScreenshot(File dest) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, dest);
    }

    public static String takeScreenshot(String screenshotsPath, String fileName) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotsPath + "//" + fileName + ".jpg");
        FileUtils.copyFile(src, dest);
        String base64Image = ts.getScreenshotAs(OutputType.BASE64);
        return base64Image;
    }

    public static void selectDropdownValue(By locator, String data) throws Exception {
        WebDriver driver = BaseClass.getDriver();
        List<WebElement> list_Elements = driver.findElements(locator);
        Thread.sleep(2000);
        for (WebElement element : list_Elements) {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(data)) {
                element.click();
                log.info("selected " + elementText + " from a list of values");
                break;
            }
        }
    }

    public static void switchToiFrame(By locator) {
        WebDriver driver = BaseClass.getDriver();
        WebElement element_frame = driver.findElement(locator);
        driver.switchTo().frame(element_frame);
        System.out.println("Switched into iFrame");
    }

    public static String generateFolderNameWithTmeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy_HHmmss");
        dateTime = now.format(formatter);
        return dateTime;
    }

    public static void staleElementEnterKeys(By locator, String data) throws Exception {
        for (int count = 1; count <= 4; ++count) {
            try {
                driver.findElement(locator).sendKeys(data);
                break;
            } catch (StaleElementReferenceException se) {
                System.out.println("Stale Element is occurred and retrying");
                Thread.sleep(1000);
            }
        }
    }

    public static ExtentReports generateExtentReport(String projectPath) {
        sparkReporter = new ExtentSparkReporter(projectPath + "//reports//TestAutomation_" + dateTime + ".html");
        sparkReporter.config().setDocumentTitle("TestAutomationCatalogue_batch41");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("OrangeHRM TestCases Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", "Windows11");
        extent.setSystemInfo("Author", "Batch41");
        extent.setSystemInfo("Browser", "Chrome");
        return extent;
    }

    public static String generateScreenshotsFolder(String projectPath) {
        String dateTime = CommonUtils.generateFolderNameWithTmeStamp();
        String screenshotsPath = projectPath + "\\screenshots\\" + dateTime;
        File file = new File(screenshotsPath);
        file.mkdir();
        log.info("New Folder for Screenshots is created with timestamp " + dateTime);
        return screenshotsPath;
    }

    public static void selectCalendarDate(String date, By drpdwn_Month, By list_Months, By drpdwn_Year, By list_years, By list_Dates) throws Exception {
        String[] date_ArrayGoal = date.split("-");
        String day = date_ArrayGoal[0];
        String month = date_ArrayGoal[1];
        String year = date_ArrayGoal[2];

        //month selector
        driver.findElement(drpdwn_Month).click();
        log.info("Clicked on Month Drop-down in Date Picker");
        CommonUtils.selectDropdownValue(list_Months, month);

        //year selector
        driver.findElement(drpdwn_Year).click();
        log.info("Clicked on Year Drop-down in Date Picker");
        CommonUtils.selectDropdownValue(list_years, year);

        //date selector
        CommonUtils.selectDropdownValue(list_Dates, day);
    }
}
