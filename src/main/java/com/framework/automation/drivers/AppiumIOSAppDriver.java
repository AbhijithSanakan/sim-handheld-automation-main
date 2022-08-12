package com.framework.automation.drivers;

import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * The AppiumIOSAppDriver class provides all required methods and variables required for Appium ios Driver
 * This also has capabilities, options setup in it
 * @since 04-10-2019
 * @version 1.0
 */
public class AppiumIOSAppDriver {

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

		System.out.println("NEW DRiver iOS APp");
		try {
			Boolean isgrid = Boolean.valueOf(ConfigProp
					.getPropertyValue("runingrid"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
					"iOS");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					DriverDataHolder.getValue("Device"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					"XCUITest");
			capabilities.setCapability("platformVersion", DriverDataHolder.getValue("OS_version"));
			if (ConfigProp.getPropertyValue("app_url").isEmpty() | ConfigProp.getPropertyValue("app_url") == null) {
				if (ConfigProp.getPropertyValue("bundleId") == null) {
					throw new Exception("Bundle ID Required to launch application. Alternate option -  provide app_url(app path)");
				}
				capabilities.setCapability("bundleId", ConfigProp.getPropertyValue("bundleId"));
				capabilities.setCapability("appActivity", ConfigProp.getPropertyValue("appActivity"));

			} else {
				capabilities.setCapability(MobileCapabilityType.APP,
						ConfigProp.getPropertyValue("app_url"));
			}
			capabilities.setCapability(MobileCapabilityType.UDID,
					DriverDataHolder.getValue("Device"));
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
						"http://127.0.0.1:4727/wd/hub"), capabilities);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return remoteDriver;
	}
}
