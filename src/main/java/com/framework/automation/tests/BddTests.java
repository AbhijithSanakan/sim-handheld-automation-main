package com.framework.automation.tests;

import com.framework.automation.framework.support.getTestCaseName;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

//This is a Cucumber Runner class, where all cucumber links are available//
//This class extends BDD TestNG class//
@CucumberOptions(features = "Features/", glue = { "com.framework.automation.test.stepdefs" },strict = true, monochrome = true, plugin = {
		"pretty", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt" })
public class BddTests extends BddTestNG {

	private TestNGCucumberRunner testNGCucumberRunner;
	private Set<String> feature_name = new HashSet<>();
	private Scenario scenario;

	//This method is executed before all classes//
	//Setting up context; initializing TestnG cucumber Runner//
	@BeforeClass(alwaysRun = true)
	public void setUpClass(ITestContext context) {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	//This method is executed at end of all classes//
	//Tear down is used to finish testng runner runner, release its memory//
	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		try {
			testNGCucumberRunner.finish();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	//This is data provide method which is used to get data for our Test method //
		@DataProvider(name = "scenarios", parallel = true)
	public Object[][] GlobalData(Method method, ITestContext context) {
		return testNGCucumberRunner.provideScenarios();
	}

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("Scenario Name"+this.scenario.getName());
		getTestCaseName.init(this.scenario.getName());
	}

	//Actual start point of a execution//
	@Test(dataProvider = "scenarios")
	public void scenarioRunner(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature)
			throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	}
}
