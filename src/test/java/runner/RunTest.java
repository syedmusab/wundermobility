package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;


/**
 * @author smali
 *
 */
@CucumberOptions(features={"src//test//resources//features"}
					,glue={"stepdefinations","utility"}
					,plugin = {"pretty", "html:target/cucumber"}
					, tags ={"@appium, @backend"}
		)
@Test
public class RunTest extends AbstractTestNGCucumberTests{

}
