package com.framework.automation.drivers;

import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;
import com.framework.automation.framework.support.getTestCaseName;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import e2e.tests.desktop.stepdef;
/**
 * The BrowserStack class provides all required methods and variables required for Browser Stack automated connectivity and usages
 * This also has capabilities, options setup in it.
 * @since 08-05-2019
 * @version 1.5
 *
 */
public class BrowserStack {
	// Setting up the browser stack connection configuration and getting it from configuration.property files
	public static final String USERNAME = ConfigProp
			.getPropertyValue("browserStack_username");
	public static final String AUTOMATE_KEY = ConfigProp
			.getPropertyValue("browserStack_automate_key");
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	public static String resolution = DriverDataHolder.getValue("Res_Width") + "x"
			+ DriverDataHolder.getValue("Res_Height");
	/**
	 * The getDriver method sets up the initializing process in browser stack
	 * This also has capabilities, options setup in it
	 *
	 * @param -no
	 * @return webdriver
	 * @throws Exception
	 * @see -
	 * @since 08-05-2019
	 * @version 2.4
	 *
	 */

	public static WebDriver getDriver() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String strDate = formatter.format(date).replaceAll ( "/","_" );
		String runNameInBS = ConfigProp.getPropertyValue("browserstackProjectName")+ "_"+strDate;


		//MOBILE WEB BROWSERSTACK CONFIGURATION
		if(ConfigProp.getPropertyValue("browserstack_mobileweb").equalsIgnoreCase("yes"))
		{
			//--------------------------------------------------------------------
			String browser = DriverDataHolder.getValue("Browser");
			String osVersion = DriverDataHolder.getValue("OS_version");
			String modelName = DriverDataHolder.getValue("device");
			String realDevice = DriverDataHolder.getValue("real_mobile");
			String browserStackLocal = ConfigProp.getPropertyValue("browserstack_local");
			String availabilityWidget = ConfigProp.getPropertyValue("availabilityWidget");
			String Platform = DriverDataHolder.getValue("Platform");
			//--------------------------------------------------------------------


			//-----SETTING DESIRED CAPABILITIES OBJECT WITH PARAMETERS-----
			caps.setCapability("os_version", osVersion);
			caps.setCapability("device", modelName);
			caps.setCapability("real_mobile", realDevice);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
			caps.setCapability("autoGrantPermissions", true);


			//SETTING SEPARATE BROWSER CAPABILITIES AS MOBILE BROWSER PARAMETER MAY VARY
			if (browser != null || browser != "") {
				//SETTING DEFAULT BROWSER AND KEYBOARD CAPABILITIES BASED ON PLATFORM FOR MOBILE WEB
				if(DriverDataHolder.getValue("OS").toLowerCase().contains("android")) {
					caps.setCapability("browser", DriverDataHolder.getValue("chrome"));
					caps.setCapability("unicodeKeyboard",true);
					caps.setCapability("resetKeyboard",true);
				}else{
					caps.setCapability("browser", DriverDataHolder.getValue("safari"));
				}
			}


			if(availabilityWidget.equalsIgnoreCase("yes"))
			{
				caps.setCapability("nativeWebTap",true);
			}

			if(Platform.equalsIgnoreCase("tablet")) {
				caps.setCapability("deviceOrientation", "landscape");
			}

			if (browserStackLocal.equalsIgnoreCase("yes"))
			{
				caps.setCapability("browserstack.local", "true");
				caps.setCapability("browserstack.localIdentifier", "AAPBrowserStackTunnel");
			}
			else{
				caps.setCapability("browserstack.geoLocation", "US");
				caps.setCapability("ignoreProtectedModeSettings", "true");
				caps.setCapability("disable-popup-blocking", "true");
			}

			if (browser.equalsIgnoreCase("chrome")) {
				// INIT CHROME OPTION
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				Map<String, Object> profile = new HashMap<String, Object>();
				Map<String, Object> contentSettings = new HashMap<String, Object>();

				// SET CHROME OPTIONS
				contentSettings.put("geolocation", 1); // 2 to disable
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				options.setExperimentalOption("prefs", prefs);
				options.setPageLoadStrategy(PageLoadStrategy.NONE);

				// SET CAPABILITY
				caps.setCapability(ChromeOptions.CAPABILITY, options);

			}

		}
		//CONFIGURATION TO RUN DESKTOP BROWSER IN BROWSERSTACK CLOUD
		else {
			//---------------------------------------------------------------
			String browser = DriverDataHolder.getValue("Browser");
			String browserVersion = DriverDataHolder.getValue("Version");
			String OS = DriverDataHolder.getValue("OS");
			// Setting default,add accordingly in config.properties
			String OSVersion = DriverDataHolder.getValue("OS_version");
			String browserStackLocal = ConfigProp.getPropertyValue("browserstack_local");
			//---------------------------------------------------------------


			System.out.println("BROWSER DETAILS:::::" + browser + browserVersion
					+ OS + OSVersion + resolution + getTestCaseName.getValue());
			if (browserStackLocal.equalsIgnoreCase("yes")) {

				if (browser.toLowerCase().equalsIgnoreCase("chrome")) {
					// INIT CHROME OPTION
					ChromeOptions options = new ChromeOptions();
					Map<String, Object> prefs = new HashMap<String, Object>();
					Map<String, Object> profile = new HashMap<String, Object>();
					Map<String, Object> contentSettings = new HashMap<String, Object>();

					// SET CHROME OPTIONS
					contentSettings.put("geolocation", 1); // 2 to disable
					profile.put("managed_default_content_settings", contentSettings);
					prefs.put("profile", profile);
					options.setExperimentalOption("prefs", prefs);
					options.setPageLoadStrategy(PageLoadStrategy.NONE);

					// SET CAPABILITY
					caps.setCapability(ChromeOptions.CAPABILITY, options);
				} else if (browser.toLowerCase().equalsIgnoreCase("firefox")) {
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("geo.enabled", true);
					profile.setPreference("geo.provider.use_corelocation", true);
					profile.setPreference("geo.prompt.testing", true);
					profile.setPreference("geo.prompt.testing.allow", true);//false to disable
					caps.setCapability(FirefoxDriver.PROFILE, profile);
				} else if (browser.toLowerCase().equalsIgnoreCase("ie")) {
					caps.setCapability("browserstack.ie.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS",
							"true");
				}
			}
			if (browser != null || browser != "") {
				caps.setCapability("browser", browser);
				caps.setCapability("browser_version", DriverDataHolder.getValue("Version"));
				if (DriverDataHolder.getValue("OS").equalsIgnoreCase("Win")) {
					caps.setCapability("os", "Windows");
				} else {
					caps.setCapability("os", DriverDataHolder.getValue("OS"));
				}
				caps.setCapability("os_version", DriverDataHolder.getValue("OS_version"));
				caps.setCapability("resolution", resolution);
				caps.setCapability("browserstack.networkLogs", "true");
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
				if (ConfigProp.getPropertyValue("browserstack_local").equalsIgnoreCase("yes")) {
					caps.setCapability("browserstack.local", "true");
					caps.setCapability("browserstack.localIdentifier", "AAPBrowserStackTunnel");
					System.out.println("Browser Stack runing in local mode");
				} else {
					caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
					caps.setCapability("browserstack.geoLocation", "US");
					caps.setCapability("ignoreProtectedModeSettings", "true");
					caps.setCapability("disable-popup-blocking", "true");
					caps.setCapability("browserstack.ie.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS",
							"true");
					System.out.println("Capabilities set for browserStack");
				}
			} else {
				// Default Settings //
				System.out
						.println("::BROWSER STACK RUNNING IN DEFAULT BROWSER:: CHROME");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "64.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("browserstack.geoLocation", "US");
				caps.setCapability("disable-popup-blocking", "true");
				if (ConfigProp.getPropertyValue("browserstack_local").equalsIgnoreCase("yes")) {
					caps.setCapability("browserstack.local", "true");
				} else {
					caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
					caps.setCapability("browserstack.geoLocation", "US");
					caps.setCapability("ignoreProtectedModeSettings", "true");
					caps.setCapability("disable-popup-blocking", "true");
					caps.setCapability("browserstack.ie.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS",
							"true");
				}
			}
		}

		//COMMON PROPS FOR MOBILE AND DESKTOP WEB
//		caps.setCapability("name", getTestCaseName.getValue ().toString ());
		caps.setCapability("project", ConfigProp.getPropertyValue("browserstackProjectName"));
		caps.setCapability("build", runNameInBS);


		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		return driver;
	}
}