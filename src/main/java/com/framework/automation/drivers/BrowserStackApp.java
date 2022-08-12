package com.framework.automation.drivers;

import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;

/**
 * The BrowserStack class provides all required methods and variables required for Browser Stack App automated connectivity and usages
 * This also has capabilities, options setup in it.
 * @since 08-29-2019
 * @version 1.5
 *
 */
public class BrowserStackApp {

    // Setting up the browser stack connection configuration and getting it from configuration.property files//
    private static WebDriver driver;
    public static final String USERNAME = ConfigProp
            .getPropertyValue("browserStack_username");
    public static final String AUTOMATE_KEY = ConfigProp
            .getPropertyValue("browserStack_automate_key");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY
            + "@hub-cloud.browserstack.com/wd/hub";
    public static DesiredCapabilities caps;

    /**
     * The getDriver method sets up the initializing process in browser stack in Mobile App automate
     * This also has capabilities, options setup in it
     *
     * @param -no
     * @return DesiredCapabilities
     * @throws Exception
     * @see -
     * @since 08-29-2019
     * @version 1.3
     *
     */
    public static DesiredCapabilities getCapabilities()throws Exception{
        String OS = DriverDataHolder.getValue("OS");
        caps = new DesiredCapabilities();

        if (OS==null || OS.isEmpty()) {
            throw new Exception("Incorrect properties.PLease refer config.properties");
        }
        System.out.println(DriverDataHolder.getValue("Device"));
        System.out.println(DriverDataHolder.getValue("OS_version"));
        System.out.println(DriverDataHolder.getValue("app_url"));
        System.out.println();
        caps.setCapability("device",DriverDataHolder.getValue("Device"));
        caps.setCapability("os_version",DriverDataHolder.getValue("OS_version"));
        caps.setCapability("name","AAP Framework Native App with Bstack");
        caps.setCapability("app",DriverDataHolder.getValue("app_url"));

        return caps;
    }


    /**
     * The getDriver method sets up the initializing process in browser stack in Mobile App automate
     * This also has capabilities, options setup in it
     *
     * @param -no
     * @return webdriver
     * @throws Exception
     * @see -
     * @since 08-29-2019
     * @version 1.4
     *
     */
    public static WebDriver getDriver() throws Exception {
        String OS = DriverDataHolder.getValue("OS");

        if(OS.equalsIgnoreCase("android")) {
            driver = new AndroidDriver(new URL(URL),getCapabilities());
        }else{
            driver = new IOSDriver(new URL(URL), getCapabilities());
        }
        return driver;
    }
}