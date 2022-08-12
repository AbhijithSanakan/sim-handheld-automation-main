package com.framework.automation.drivers;

import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;

/**
 * The Saucelabs App class provides all required methods and variables required for Saucelab App automated connectivity and usages
 * This also has capabilities, options setup in it.
 *
 * @version 1.5
 * @since 02-16-2022
 */
public class SauceLabsApp {

    // Setting up the browser stack connection configuration and getting it from configuration.property files//
    private static WebDriver driver;
    public static final String USERNAME = ConfigProp
            .getPropertyValue("cloud_username");
    public static final String AUTOMATE_KEY = ConfigProp
            .getPropertyValue("cloud_automate_key");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY
            + "@ondemand.us-west-1.saucelabs.com/wd/hub";
    public static DesiredCapabilities caps;

    /**
     * The getDriver method sets up the initializing process in browser stack in Mobile App automate
     * This also has capabilities, options setup in it
     *
     * @param -no
     * @return DesiredCapabilities
     * @throws Exception
     * @version 1.3
     * @see -
     * @since 08-29-2019
     */
    public static DesiredCapabilities getCapabilities() throws Exception {
        String OS = DriverDataHolder.getValue("OS");
        caps = new DesiredCapabilities();

        if (OS == null || OS.isEmpty()) {
            throw new Exception("Incorrect properties.PLease refer config.properties");
        }

        caps.setCapability("deviceName", DriverDataHolder.getValue("Device"));
        caps.setCapability("name", "Native App Execution with SauceLabs");
        caps.setCapability("app", DriverDataHolder.getValue("app_url"));
        caps.setCapability("platformName", DriverDataHolder.getValue("OS").toLowerCase());
        caps.setCapability("idleTimeout", "90");
        caps.setCapability("newCommandTimeout", "90");
        return caps;
    }


    /**
     * The getDriver method sets up the initializing process in browser stack in Mobile App automate
     * This also has capabilities, options setup in it
     *
     * @param -no
     * @return webdriver
     * @throws Exception
     * @version 1.4
     * @see -
     * @since 08-29-2019
     */
    public static WebDriver getDriver() throws Exception {
        String OS = DriverDataHolder.getValue("OS");

        if (OS.equalsIgnoreCase("android")) {
            driver = new AndroidDriver(new URL(URL), getCapabilities());
        } else {
            driver = new IOSDriver(new URL(URL), getCapabilities());
        }
        return driver;
    }
}

