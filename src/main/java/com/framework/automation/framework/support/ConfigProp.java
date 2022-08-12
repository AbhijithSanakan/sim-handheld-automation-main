package com.framework.automation.framework.support;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * The ConfigProp class is used to get configuration values and store them in hash map
 *
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class ConfigProp {

	public static Properties prop = new Properties();
	public static String filepath;

	static {
		try {
			System.out.println("Config :" +System.getProperty("user.dir")
					+ File.separator + "config.Properties");
			filepath = System.getProperty("user.dir")
					+ File.separator + "config.Properties";
			prop.load(new FileInputStream(filepath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The getPropertyValue method is used to set the local driver or browser drivers used for this particular Run
	 *
	 * @param -String Key value
	 * @return String
	 * @throws
	 * @see -
	 * @since 08-07-2019
	 * @version 1.0
	 *
	 */
	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

}
