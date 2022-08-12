package com.framework.automation.drivers;

import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;
import com.framework.automation.wrapper.ui.NativeAppsAction;
import com.framework.automation.wrapper.ui.WebAction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.winium.WiniumDriver;

import java.time.Duration;

/**
 * The DriverFactory class is used to select which driver to load, and while moving from one class to other
 * this class is used to identify which driver is being used.
 * @since 04-10-2019
 * @version 2.3
 *
 */
public class DriverFactory {

	private static ThreadLocal<WebDriver> driverinstance = new ThreadLocal<>();
	private static ThreadLocal<WiniumDriver> windriverinstance = new ThreadLocal<>();
	private static ThreadLocal<SikuliDriver> sikulidriverinstance = new ThreadLocal<>();
	private static ThreadLocal<Wait> waitinstance = new ThreadLocal<>();
	private NativeAppsAction nativeAppsAction;
	private WebAction webAction;
	enum DriverName {
		android, ios, web, win,window, sikuli, mac, android_app, ios_app, bw_stack, bwstack_native,saucelabs_native,saucelabs
	}

	/**
	 * The getPlatformName method is used to get the Platform Name from configuration file of a particular Run
	 *
	 * @param -no
	 * @return String
	 * @throws
	 * @see -
	 * @since 04-10-2019
	 * @version 1.3
	 *
	 */
	private static String getPlatformName() {
		return DriverDataHolder.getValue("OS").toLowerCase();
	}

	/**
	 * The getBrowserName method is used to get the browser Name from configuration file of a particular Run
	 *
	 * @param -no
	 * @return String
	 * @throws
	 * @see -
	 * @since 04-10-2019
	 * @version 1.3
	 *
	 */
	private static String getBrowserName() {
		if (DriverDataHolder.getValue("Platform").toLowerCase()
				.equals("mobile"))
			return DriverDataHolder.getValue("OS").toLowerCase() + "_"
					+ DriverDataHolder.getValue("Browser").toLowerCase();
		else
			return DriverDataHolder.getValue("Browser").toLowerCase();
	}

	/**
	 * The getDriver method is used to get the driver used for this particular Run
	 *
	 * @param -no
	 * @return WebDriver
	 * @throws
	 * @see -
	 * @since 08-07-2019
	 * @version 1.3
	 *
	 */
	public static WebDriver getDriver() throws Exception {
		WebDriver driver = driverinstance.get();

		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	public static  Wait getWaits() throws Exception {
		 Wait wait = waitinstance.get();
		if (wait == null) {
			wait =  new FluentWait(getDriver())
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
		}

		return wait;
	}
	public static  Wait getWaits(int timeout) throws Exception {
			Wait wait =  new FluentWait(getDriver())
					.withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
		return wait;
	}

	/**
	 * The WiniumDriver method is used to get the windows driver used for this particular Run
	 *
	 * @param -no
	 * @return WebDriver
	 * @throws
	 * @see -
	 * @since 04-10-2019
	 * @version 1.3
	 *
	 */
	public static WiniumDriver getWinDriver() throws Exception {
		WiniumDriver driver = windriverinstance.get();
		if (driver == null) {
			initDriver();
			driver = windriverinstance.get();
		}
		return driver;
	}

	/**
	 * The SikuliDriver method is used to get the sikuli driver used for this particular Run
	 *
	 * @param -no
	 * @return SikuliDriver
	 * @throws
	 * @see -
	 * @since 04-10-2019
	 * @version 1.3
	 *
	 */
	public static SikuliDriver getsikuliDriver() throws Exception {
		SikuliDriver driver = sikulidriverinstance.get();
		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	/**
	 * The initDriver method is used to initialize all the driver, and switch case according to the apt driver for
	 * this particular Run
	 *
	 * @param -no
	 * @return no
	 * @throws
	 * @see -
	 * @since 04-10-2019
	 * @version 1.0
	 *
	 */
	private static void initDriver() throws Exception {
		String cloud_type=ConfigProp.getPropertyValue("cloud_type");
		String cloud_mode=ConfigProp.getPropertyValue("cloud_mode");
		String platformName;

		if(cloud_type.equalsIgnoreCase("browserstack")){
			if(cloud_mode.equalsIgnoreCase("app")){
				platformName="bwstack_native";
			}else{
				platformName="bw_stack";
			}
		}else if (cloud_type.equalsIgnoreCase("saucelabs")){
			if(cloud_mode.equalsIgnoreCase("app")){
				platformName="saucelabs_native";
			}else{
				platformName="saucelabs";
			}
		}else{
			platformName = getPlatformName().toLowerCase();
		}
		DriverName d = DriverName.valueOf(platformName);

		System.out.println("INITIATING DRIVER::::::::::::::::::::::");

		switch (d) {
		case android:
			System.out.println("INITIATING ANDROID DRIVER");

			if (DriverDataHolder.getValue("Browser").equalsIgnoreCase("app"))
				driverinstance.set(new AppiumAndroidAppDriver().getNewDriver());
			else
				driverinstance.set(new AppiumAndroidDriver().getNewDriver());
			break;
		case ios:
			System.out.println("INITIATING iOS DRIVER");

			if (DriverDataHolder.getValue("Browser").equalsIgnoreCase("app"))
				driverinstance.set(new AppiumIOSAppDriver().getNewDriver());
			else
				driverinstance.set(new AppiumIOSDriver().getNewDriver());
			break;
		case web:
		case mac:
		case win:
			System.out.println("INITIATING WEB DRIVER");
			driverinstance.set(new WebBrowserDriver().getNewDriver());
			break;
		case window:
			System.out.println("INITIATING Winium DRIVER");

			windriverinstance.set(new WindowsWiniumDriver().getexistingdriverattach());
			break;
		case sikuli:
			System.out.println("INITIATING Sikuli DRIVER");

			sikulidriverinstance.set(new SikuliDriver());
			break;
		case bw_stack:
			System.out.println("INITIATING BROWSER STACK DRIVER");
			try {
				driverinstance.set(BrowserStack.getDriver());
				System.out.println("BROWSER STACK DRIVER INITIALIZED");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case bwstack_native:
				System.out.println("INITIATING BROWSER STACK DRIVER - NATIVE APP");
				driverinstance.set(BrowserStackApp.getDriver());
				break;
		case saucelabs_native:
			System.out.println("INITIATING SAUCELABS DRIVER - NATIVE APP");
			driverinstance.set(SauceLabsApp.getDriver());
				break;
		case saucelabs:
				break;


			default:
			System.out.println("Driver Details not defined");
			System.out.println("INITIATING WEB DRIVER");

			driverinstance.set(new WebBrowserDriver().getNewDriver());
			break;
		}
	}

	/**
	 * The closeDriver method is used to close and quit the running driver for a particular Run
	 *
	 * @param -no
	 * @return
	 * @throws
	 * @see -
	 * @since 04-10-2019
	 * @version 1.6
	 *
	 */
	public static void closeDriver() {
		WebDriver driver = driverinstance.get();
		WiniumDriver windriver = windriverinstance.get();
		System.out.println("Closing Driver");
		boolean check = (DriverDataHolder.getValue("Browser").equalsIgnoreCase(
				"safari") && DriverDataHolder.getValue("Platform")
				.equalsIgnoreCase("desktop"))
				|| DriverDataHolder.getValue("Browser").equalsIgnoreCase("app");
		boolean checknull = (DriverDataHolder.getValue("Browser").equalsIgnoreCase(
				"null") && DriverDataHolder.getValue("Platform")
				.equalsIgnoreCase("null"))
				|| DriverDataHolder.getValue("Browser").equalsIgnoreCase("app");
		boolean checkwin = (DriverDataHolder.getValue("Browser").equalsIgnoreCase(
				"desktop") && DriverDataHolder.getValue("Platform")
				.equalsIgnoreCase("desktop"));
		try {
			if(checkwin){
				windriver.close();
				windriver.quit();
				WindowsWiniumDriver.service.stop();
			}
			else {
				if (check)
					driver.quit();
				else if (checknull)
					System.out.println("No driver to Close as Properties are Null");
				else {
					driver.close();
					driver.quit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driverinstance.remove();
	}

}
