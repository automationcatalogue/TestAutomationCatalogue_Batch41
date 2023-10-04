package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = " @DemoWebshop",
        features = "src/test/resources/",
        glue = "stepdefinitions",
        dryRun = false
        //plugin={"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
