package REST.Learning;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/feature",glue = "stepDef",monochrome = true,plugin = {"pretty", "html:target/cucumber"} )

public class TestRunner {

}
