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
 * The AppiumAndroidAppDriver class provides all required methods and variables required for Appium Android Driver
 * This also has capabilities, options setup in it
 * @version 1.2
 * @since 04-10-2019
 */
public class AppiumAndroidAppDriver {

    /**
     * The getNewDriver method sets up the Appium Android Driver
     * This also has capabilities, options setup in it
     *
     * @param -no
     * @return webdriver
     * @throws
     * @version 1.0
     * @see -https://www.npmjs.com/package/appium-android-driver
     * @since 04-10-2019
     */
    public WebDriver getNewDriver() {
        WebDriver remoteDriver = null;

        try {
            Boolean isgrid = Boolean.valueOf(ConfigProp.getPropertyValue("runingrid"));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability(
                    MobileCapabilityType.DEVICE_NAME, DriverDataHolder.getValue("Device"));
            capabilities.setCapability(
                    MobileCapabilityType.UDID, DriverDataHolder.getValue("Device"));
            capabilities.setCapability(
                    "systemPort", DriverDataHolder.getValue("Port"));
            capabilities.setCapability(
                    "platformVersion", DriverDataHolder.getValue("OS_version"));
            if (DriverDataHolder.getValue("app_url").isEmpty() | DriverDataHolder.getValue("app_url") == null) {
                if (DriverDataHolder.getValue("appPackage") == null | DriverDataHolder.getValue("appActivity") == null) {
                    throw new Exception("App Package and Activity Required to launch application. Alternate option -  provide app_url");
                }
                capabilities.setCapability("appPackage", DriverDataHolder.getValue("appPackage"));
                capabilities.setCapability("appActivity", DriverDataHolder.getValue("appActivity"));

            } else {
                capabilities.setCapability(MobileCapabilityType.APP,
                        DriverDataHolder.getValue("app_url"));
            }
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);


            if (isgrid)
                remoteDriver = new RemoteWebDriver(new URL("http://"
                        + ConfigProp.getPropertyValue("gridhost") + ":"
                        + ConfigProp.getPropertyValue("mobport") + "/wd/hub"),
                        capabilities);
            else
                remoteDriver = new AndroidDriver(new URL("http://localhost:"
                        + DriverDataHolder.getValue("Port") + "/wd/hub"),
                        capabilities);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return remoteDriver;
    }
}
