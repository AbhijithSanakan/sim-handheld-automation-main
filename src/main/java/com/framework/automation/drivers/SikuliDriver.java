package com.framework.automation.drivers;

import org.sikuli.script.Screen;

/**
 * The SikuliDriver class is used to initialize and make sikulli methods available
 *
 * @since 09-18-2019
 * @version 1.0
 *
 */
public class SikuliDriver extends Screen {

    static SikuliDriver sikuliDriver;

    /**
     * Empty constructor
     */
    public SikuliDriver()
    {

    }

    /**
     * The getSikuliScreen method sets up the initializing process or gathers current silulli driver session
     *
     * @param -no
     * @return Screen
     * @throws Exception
     * @see -
     * @since 09-18-2019
     * @version 1.0
     *
     */
    public static Screen getSikuliScreen() throws Exception {
        if (null == sikuliDriver) {
            sikuliDriver=DriverFactory.getsikuliDriver();
        }
        return sikuliDriver;
    }

}
