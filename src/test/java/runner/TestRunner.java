package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@TC05",
        features = "src/test/resources/",
        glue = "stepdefinitions",
        dryRun = false
        //plugin={"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
