package com.framework.automation.drivers;

import com.framework.automation.framework.support.ConfigProp;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * The AppiumIOSDriver class provides all required methods and variables required for Appium iOS Driver
 * This also has capabilities, options setup in it
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class AppiumIOSDriver {

	/**
	 * The getNewDriver method sets up the Appium iOS Driver
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
			Boolean isgrid = Boolean.valueOf(ConfigProp
					.getPropertyValue("runingrid"));

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
					"iOS");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					"Sempra iPhone");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					"XCUITest");
			capabilities.setCapability("platformVersion", "12.0.1");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
					"safari");
			capabilities.setCapability(MobileCapabilityType.UDID,
					"73af531d62e55f2d9d3c5b48da3c0a22aee4ed18");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability("usePrebuiltWDA", true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
			capabilities.setCapability("newCommandTimeout", "720");
			capabilities.setCapability("wdaConnectionTimeout", "720000");

			if (isgrid)
				remoteDriver = new IOSDriver(new URL("http://"
						+ ConfigProp.getPropertyValue("gridhost") + ":"
						+ ConfigProp.getPropertyValue("mobport") + "/wd/hub"),
						capabilities);
			else
				remoteDriver = new IOSDriver(new URL(
						"http://127.0.0.1:4725/wd/hub"), capabilities);
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return remoteDriver;
	}
}
