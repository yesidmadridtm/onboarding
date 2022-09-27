package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features", glue="stepsDefinitions", plugin= {"html:target/cucumber.html"}, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
