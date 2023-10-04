package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import pages.OrangeHRM_AddEmployeePage;
import stepdefinitions.OrangeHRM_StepDefinition;
import utilities.BaseClass;
import utilities.Config;
import utilities.ExcelUtils;
import utilities.Log;

public class CucumberHooks {
    static WebDriver driver;
    static Logger log = LogManager.getLogger(CucumberHooks.class);
    public static int rowNum_Index;

    @Before
    public void beforeEachScenario(){
        Log.startTestCase(CucumberHooks.class.getName());
    }

    @After
    public void afterEachScenario(Scenario scenario) throws Exception{
        if (!scenario.isFailed()) {
            ExcelUtils.setCellData("PASSED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Passed and status is updated in Excel sheet");
        } else if (scenario.isFailed()) {
            ExcelUtils.setCellData("FAILED", "Index", rowNum_Index, Config.col_Status);
            log.info("TestCase is Failed and status is updated in Excel sheet");
        }
        driver = BaseClass.getDriver();
        ExcelUtils.closeExcelFile();
        driver.quit();
        Log.endTestCase();
    }
}
