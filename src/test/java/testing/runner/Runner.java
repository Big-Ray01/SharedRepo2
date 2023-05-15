package testing.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testing/feature/test.feature",
        glue = "testing.stepDef",
        plugin = {"pretty", "html: Execution/cucumber.html"}
)
public class Runner {
}
