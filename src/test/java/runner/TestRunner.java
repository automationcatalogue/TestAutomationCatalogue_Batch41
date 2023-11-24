package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@TC04",
        features = "src/test/resources/",
        glue = "stepdefinitions",
        dryRun = true
        //plugin={"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
