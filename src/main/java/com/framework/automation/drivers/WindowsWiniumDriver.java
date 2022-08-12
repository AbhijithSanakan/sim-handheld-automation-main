package com.framework.automation.drivers;

import com.framework.automation.framework.support.ApplicationProp;
import com.framework.automation.utils.PropManager;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import java.io.File;
import java.io.IOException;

public class WindowsWiniumDriver {
    static WiniumDriver driver;
    int winiumport = 9999;
    Process winiumService;
    static WiniumDriverService service;

    /**
     * The getDriver method is used to Get current winium driver instance
     *
     * @param - String location of the application
     * @return WiniumDriver
     * @throws
     * @see -
     * @since 08-07-2019
     * @version 1.7
     *
     */
    public static WiniumDriver getDriver(String appLocation) throws Exception {
        DesktopOptions option = new DesktopOptions();
        //dtOptions.setApplicationPath(PropManager.getAbsolutPath("DesktopExe"));
        System.out.println(appLocation);
        option.setApplicationPath(appLocation);
        File driverPath = new File("Drivers/Winium.Desktop.Driver/Winium.Desktop.Driver.exe");
        System.setProperty("webdriver.winium.desktop.driver","Drivers/Winium.Desktop.Driver/Winium.Desktop.Driver.exe");

        service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
                .withSilent(false).buildDesktopService();
        Thread.sleep(5000);
        try {
            service.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //WiniumDriver driver = new WiniumDriver(new URL("http://localhost:1001"),option);
        driver = new WiniumDriver(service,option);
        return driver;
    }

    /**
     * The getNewDriver method is used to set and initialize a new winium driver instance
     *
     * @param -
     * @return WiniumDriver
     * @throws
     * @see -
     * @since 08-07-2019
     * @version 1.2
     *
     */
    public static WiniumDriver getNewDriver() throws Exception {
        String url = ApplicationProp.getValue("Windows_url");
        DesktopOptions option = new DesktopOptions();
        System.out.println(url);
        option.setApplicationPath(url);
        File driverPath = new File("Drivers/Winium.Desktop.Driver/Winium.Desktop.Driver.exe");
        System.setProperty("webdriver.winium.desktop.driver","Drivers/Winium.Desktop.Driver/Winium.Desktop.Driver.exe");
        service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
                .withSilent(false).buildDesktopService();
        Thread.sleep(5000);
        try {
            service.start();
        }
        catch (Exception e){
            e.printStackTrace();
            service.stop();
        }
        //WiniumDriver driver = new WiniumDriver(new URL("http://localhost:1001"),option);
        driver = new WiniumDriver(service,option);
        return driver;
    }

    /**
     * The getexistingdriverattach method is used to set and initialize a winium driver instance to attach already existing window
     *
     * @param -
     * @return WiniumDriver
     * @throws
     * @see -
     * @since 01-15-2020
     * @version 1.2
     *
     */
    public static WiniumDriver getexistingdriverattach() throws Exception {
        DesktopOptions options = new DesktopOptions();
        options.setDebugConnectToRunningApp(true);
        File driverPath = new File("Drivers/Winium.Desktop.Driver/Winium.Desktop.Driver.exe");
        System.setProperty("webdriver.winium.desktop.driver","Drivers/Winium.Desktop.Driver/Winium.Desktop.Driver.exe");
        service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
                .withSilent(false).buildDesktopService();
        Thread.sleep(5000);
        try {
            service.start();
        }
        catch (Exception e){
            e.printStackTrace();
            service.stop();
        }
        //WiniumDriver driver = new WiniumDriver(new URL("http://localhost:1001"),option);
        driver = new WiniumDriver(service,options);
        return driver;
    }

    /**
     * The closeDriver method is used to close the current driver and kill session
     *
     * @param -
     * @return
     * @throws
     * @see -
     * @since 08-07-2019
     * @version 1.0
     *
     */
    public static void closeDriver() {

        if (null != driver) {
            //Driver.close();
            driver.quit();
            driver = null;
        }
    }

    /**
     * The startService method is used to start winium service
     *
     * @param -
     * @return
     * @throws- IOException, InterruptedException
     * @see -
     * @since 08-07-2019
     * @version 1.2
     *
     */
    public void startService() throws IOException, InterruptedException {

        if (null == winiumService || !winiumService.isAlive() ) {
            try {
                winiumport = Integer.parseInt(PropManager.getProperty("WiniumPort"));
            } catch (Exception e) {
                winiumport = 9999;
            }
            //winiumService = new ProcessBuilder(winiumServerFile.getAbsolutePath(), "--port",
             //       Integer.toString(winiumport)).start();
        }
    }

    /**
     * The stopService method is used to stop winium service
     *
     * @param -
     * @return
     * @throws- IOException
     * @see -
     * @since 08-07-2019
     * @version 1.0
     *
     */
    public void stopService() throws IOException {

        if (null != service) {
            if (service.isRunning()) {
                service.stop();
                service = null;
            }
        }

    }
}