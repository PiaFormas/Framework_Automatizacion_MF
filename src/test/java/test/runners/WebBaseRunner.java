package test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import steps.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"steps"},
        features = {"src/test/resources/features"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:results/cucumber.json", "junit:results/cucumber.xml"},
        tags = "",
        monochrome = true
)
public class WebBaseRunner extends Hooks {
    public WebBaseRunner() {
    }
}
