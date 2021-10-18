package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        //tags = "~@ignore",
        glue = {"stepdefinitions"},
        plugin = {"junit:target/cucumber/result.xml", "json:target/cucumber/report.json"}
)
public class RunCucumberTest {

}
