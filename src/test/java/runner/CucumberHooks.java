package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @Before
    public void beforeEachScenario(){
        Log.startTestCase(CucumberHooks.class.getName());
    }

    @After
    public void afterEachScenario() throws Exception{
        driver = BaseClass.getDriver();
        ExcelUtils.closeExcelFile();
        driver.quit();
        Log.endTestCase();
    }
}
