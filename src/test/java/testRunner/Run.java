package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//resources/features/Login.feature",
		glue="stepDefinition",
		dryRun=false,
		monochrome=true,
		//tags="@regression",
		//plugin= {"pretty","html:target/cucumberReports/WishListReport.html"}
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",}
		)

public class Run extends AbstractTestNGCucumberTests{

}
