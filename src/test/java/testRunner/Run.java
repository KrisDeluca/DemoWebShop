package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//resources/features/Login.feature",
		glue="stepDefinition",
		dryRun=false,
		monochrome=true,
		//tags="@smoke",
		//plugin= {"pretty","html:target/cucumberReports/WishListReport.html"}
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extentReports/report.html"}
		)

public class Run extends AbstractTestNGCucumberTests{
	
}


