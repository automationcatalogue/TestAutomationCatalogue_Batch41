package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import runner.CucumberHooks;
import utilities.BaseClass;
import utilities.CommonUtils;
import utilities.Config;

public class OrangeHRM_Steps {
    static WebDriver driver;
    private static String base64;
    static Logger log;

    @Given("User launches browser")
    public void user_launches_browser() {
        log = LogManager.getLogger(CucumberHooks.scenario.getName());
        driver = CommonUtils.browserLaunch(Config.browserName);
        BaseClass ob = new BaseClass(driver);
    }
    @Given("User opens OrangeHRM application")
    public void user_opens_orange_hrm_application() throws Exception{
        driver.get(Config.orangeHRM_URL);
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_LoginPage");
        log.info("OrangeHRM URL is loaded :" + Config.orangeHRM_URL);
    }
    @When("User login into OrangeHRM application with username as {string} and {string}")
    public void user_login_into_orange_hrm_application_with_username_as_and(String userName, String password) {
        OrangeHRM_LoginPage.login(userName, password);
        log.info("OrangeHRM Login is Successful");
    }
    @Then("User verify title of OrangeHRM home page")
    public void user_verify_title_of_orange_hrm_home_page() throws Exception{
        OrangeHRM_HomePage.verifyTitle();
        base64 = CommonUtils.takeScreenshot(CucumberHooks.screenshotsPath, "OrangeHRM_HomePage");
    }
    @Then("User logged out from OrangeHRM application")
    public void user_logged_out_from_orange_hrm_application() {
        OrangeHRM_HomePage.logout();
    }
}
