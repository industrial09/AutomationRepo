package testrunners;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/cucumberTests/test.feature", glue="testMethods")
public class PruebaRunner extends AbstractTestNGCucumberTests{
	
}
