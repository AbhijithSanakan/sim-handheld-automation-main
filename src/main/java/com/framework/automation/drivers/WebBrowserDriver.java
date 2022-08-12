package com.framework.automation.drivers;

import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.URL;

/**
 * The WebBrowserDriver class provides all required methods and variables required for Web browsers
 * This also has capabilities, options setup in it.
 * @since 04-10-2019
 * @version 1.0
 *
 */
class WebBrowserDriver {

    enum BrowserName {
        chrome, safari, ie, firefox, edge;
    }

    /**
     * The getNewDriver method is used to set the driver to be used for this particular Run
     *
     * @param -no
     * @return WebDriver
     * @throws
     * @see -
     * @since 08-07-2019
     * @version 1.0
     *
     */
    WebDriver getNewDriver() {
        WebDriver driver = null;
        try {
            Boolean isgrid = Boolean.valueOf(ConfigProp.getPropertyValue("runingrid"));
            //Initialize driver according to the condition//
            if (isgrid) {
                driver = getRemoteDriver();
            } else {
                driver = getLocalDriver();
            }
            //set the resolution of the driver//
            if (
                    !DriverDataHolder.getValue("Res_Width").isEmpty()
                            &&
                            !DriverDataHolder.getValue("Res_Height").isEmpty()
            ) {
                driver.manage().window().setSize(new Dimension(
                        Integer.parseInt(DriverDataHolder.getValue("Res_Width")),
                        Integer.parseInt(DriverDataHolder.getValue("Res_Height"))
                ));
                
            }
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return driver;
    }

    /**
     * The getLocalDriver method is used to set the local driver or browser drivers used for this particular Run
     *
     * @param -no
     * @return WebDriver
     * @throws
     * @see -
     * @since 08-07-2019
     * @version 1.3
     *
     */
    private WebDriver getLocalDriver() {
        BrowserName browser = BrowserName.valueOf(DriverDataHolder.getValue("Browser").toLowerCase());
		DesiredCapabilities cap = new DesiredCapabilities();
        WebDriver driver = null;
        switch (browser) {
            case chrome:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1920,1200","--ignore-certificate-errors","--disable-popup-blocking"
                );
                //options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case ie:

                DesiredCapabilities iecap=DesiredCapabilities.internetExplorer();
                iecap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new InternetExplorerDriver(iecap);
                //driver = new InternetExplorerDriver();
                break;
            case safari:
                DesiredCapabilities safcap=DesiredCapabilities.safari();
                safcap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new SafariDriver(safcap);
                //driver = new SafariDriver();
                break;
            case firefox:
                FirefoxProfile profile=new FirefoxProfile();
                profile.setAcceptUntrustedCertificates(true);
                //driver = new FirefoxDriver((Capabilities) profile);
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    /**
     * The getLocalDriver method is used to set the remote driver or browser drivers used for this particular Run
     *
     * @param -no
     * @return RemoteWebDriver
     * @throws
     * @see -
     * @since 08-07-2019
     * @version 1.0
     *
     */
    private RemoteWebDriver getRemoteDriver() {        
        BrowserName browser = BrowserName.valueOf(DriverDataHolder.getValue("Browser").toLowerCase());
        DesiredCapabilities cap = new DesiredCapabilities();
        RemoteWebDriver remotedriver = null;
        switch (browser) {
            case chrome:
                cap.setBrowserName("chrome");
                cap.setPlatform(Platform.MAC);                
                break;

            case safari:
                cap.setBrowserName("safari");
                break;
            case ie:
                cap.setBrowserName("ie");
                break;
            case firefox:
                cap.setBrowserName("firefox");
                break;
            case edge:
                cap.setBrowserName("MicrosoftEdge");
                cap.setJavascriptEnabled(true);
                cap.setAcceptInsecureCerts(true);
                break;
        }
        try {
            remotedriver = new RemoteWebDriver(
                    new URL(
                            "http://" +
                                    ConfigProp.getPropertyValue("gridhost") +
                                    ":" +
                                    ConfigProp.getPropertyValue("deskport") +
                                    "/wd/hub"),
                    cap
            );
        } catch (Exception e) {    
        }
        return remotedriver;
    }
}
