package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//resources/features/Shop.feature",
		glue="stepDefinition",
		dryRun=false,
		monochrome=true,
		//tags="@sanity",
		plugin= {"pretty","html:target/cucumberReports/ShopReport.html"}
		)

public class Run extends AbstractTestNGCucumberTests{

}
