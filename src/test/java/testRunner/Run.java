package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//resources/features/Wishlist.feature",
		glue="stepDefinition",
		dryRun=false,
		monochrome=true,
		//tags="@regression",
		plugin= {"pretty","html:target/cucumberReports/WishListReport.html"}
		)

public class Run extends AbstractTestNGCucumberTests{

}
