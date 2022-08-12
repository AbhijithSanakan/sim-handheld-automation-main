package com.framework.automation.drivers;


import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * The AppiumAndroidDriver class provides all required methods and variables required for Appium Android Driver
 * This also has capabilities, options setup in it
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class AppiumAndroidDriver {

	/**
	 * The getNewDriver method sets up the Appium Android Driver
	 * This also has capabilities, options setup in it
	 *
	 * @param -no
	 * @return webdriver
	 * @throws Exception
	 * @see -https://www.npmjs.com/package/appium-android-driver
	 * @since 04-10-2019
	 * @version 1.0
	 *
	 */
	public WebDriver getNewDriver() {
		WebDriver remoteDriver = null;

		try {
			Boolean isgrid = Boolean.valueOf(ConfigProp.getPropertyValue("runingrid"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
			capabilities.setCapability("platformVersion", "7.0");
			capabilities.setCapability(
					MobileCapabilityType.DEVICE_NAME,
					ConfigProp.getPropertyValue(DriverDataHolder
							.getValue("Device_ID") + "_udid"));
			capabilities.setCapability(
					MobileCapabilityType.UDID,
					ConfigProp.getPropertyValue(DriverDataHolder
							.getValue("Device_ID") + "_udid"));
			capabilities.setCapability(
					"systemPort",
					ConfigProp.getPropertyValue(DriverDataHolder
							.getValue("Device_ID") + "_sport"));
			capabilities.setCapability(
					"platformVersion",
					ConfigProp.getPropertyValue(DriverDataHolder
							.getValue("Device_ID") + "_os"));
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

			if (isgrid)
				remoteDriver = new RemoteWebDriver(new URL("http://"
						+ ConfigProp.getPropertyValue("gridhost") + ":"
						+ ConfigProp.getPropertyValue("mobport") + "/wd/hub"),
						capabilities);
			else
				remoteDriver = new AndroidDriver(new URL("http://localhost:"
						+ ConfigProp.getPropertyValue(DriverDataHolder
								.getValue("Device_ID") + "_port") + "/wd/hub"),
						capabilities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return remoteDriver;
	}
}
