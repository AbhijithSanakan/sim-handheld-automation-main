package com.framework.automation.tests;

import com.framework.automation.drivers.DriverFactory;
import com.framework.automation.framework.support.ApplicationProp;
import com.framework.automation.framework.support.DataHandler;
import com.framework.automation.framework.support.DriverDataHolder;
import com.framework.automation.framework.support.TestDataHolder;
import com.framework.automation.utils.TestUtil;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * The BddTestNG class uses TestnG annotations , this is a base class for the testnG TEST class
 * It has all before and after metods which is almost common for all tests
 *
 * @since 04-10-2019
 * @version 1.1
 *
 */
public class BddTestNG {

	public static String test_name_screenshot;
	int count = 0;

	//Execute Before every Regression or Test Suites is started.//
	//Sets the context and retreives the suite name which is being executed.//
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		String suiteName = context.getCurrentXmlTest().getSuite().getName();
		System.out.println(">>>> Environment Selected >>>> " + System.getProperty("env"));
		TestUtil.ApplicationConfig(System.getProperty("env"));
		DataHandler.loadTestDataFromDataRepository(System.getProperty("testrepo"));
	}

	//Execute Before every methods in Test Class of TestnG//
	@BeforeMethod
	public void setUp(Object[] testArgs, ITestContext context, Method method) {
	}
	//Execute this after a method is completed//
	//close the drivers and release all hash  maps stored value//
	@AfterMethod(alwaysRun = true)
	public void closeDriver(ITestContext context) {
		try{ DriverFactory.closeDriver();}
		catch (Exception e) {
			System.out.println("[INFO] If running API, no driver to close");
			System.out.println("[ERROR] If running web application , this is issue in " +
					"closeDriver @AfterMethod::closeDriver()");
		}

		try{ DriverDataHolder.endThreadLocal();}
		catch (Exception e){System.out.println("[INFO] If running API, no driver data to flush");
			System.out.println("[ERROR] If running web application , this is issue in closeDriver " +
					"@AfterMethod::driverdata endthreadlocal()");
		}
			TestDataHolder.endThreadLocal();
	}

	//Executes after the suite is completed//
	@AfterSuite(alwaysRun = true)
	public void afterSuite(ITestContext context) {
		//Uncomment below line if report generation should happen after suite, and not using commands to execute outside framework//
		// Reporter.closeTest(context.getCurrentXmlTest().getSuite().getName());
			ApplicationProp.endThreadLocal();
		//Uncomment the below line in case if a e-mail has to be triggered using this framework//
		//sendResultEmail();
	}
}
