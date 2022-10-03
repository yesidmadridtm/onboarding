package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        features="src/test/resources/features/PimPage.feature",
        glue= "stepsdefinitions",
        snippets = CAMELCASE,
        tags = "@run")

public class RunnerPIM extends AbstractTestNGCucumberTests {
}
