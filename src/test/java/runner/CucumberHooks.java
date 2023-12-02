package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import utilities.*;

public class CucumberHooks {
    static WebDriver driver;
    public static Logger log;
    public static int rowNum_Index;
    public static XSSFWorkbook wbk;
    public static ExtentReports extent;
    public static ExtentTest logger;
    private static String projectPath;
    public static String screenshotsPath;
    public static Scenario scenario;

    @Before
    public void beforeEachScenario(Scenario scenario) throws Exception{
        log = LogManager.getLogger(scenario.getName());
        CucumberHooks.scenario = scenario;
        System.out.println("Before Suite Execution");
        projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        screenshotsPath = CommonUtils.generateScreenshotsFolder(projectPath);
        Log.startTestCase(scenario.getName());
    }

    @After
    public void afterEachScenario(Scenario scenario) throws Exception{

        if (!scenario.isFailed()) {
            log.info(scenario.getName() + "TestCase is Passed");
        } else if (scenario.isFailed()) {
            log.info(scenario.getName() + "TestCase is Failed");
        }
        driver = BaseClass.getDriver();
        driver.quit();
        Log.endTestCase();
    }
}
