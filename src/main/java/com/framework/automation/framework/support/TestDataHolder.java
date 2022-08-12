package com.framework.automation.framework.support;

import java.util.Map;

/**
 * The TestDataHolder class is used to get test data details and store them in hash map
 *
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class TestDataHolder {
	private static ThreadLocal<Map<String, String>> testDataMap = new ThreadLocal<Map<String, String>>();

	/**
	 * The init method is used to set the initialize and store value in the hashmap
	 *
	 * @param -Hash Map
	 * @return
	 * @throws
	 * @see -
	 * @since 08-07-2019
	 * @version 1.0
	 *
	 */
	public static void init(Map<String, String> configMap) {
		TestDataHolder.testDataMap.set(configMap);
	}

	/**
	 * The getData method is used to get value to the input key
	 *
	 * @param -String Key
	 * @return - String value
	 * @throws
	 * @see -
	 * @since 08-07-2019
	 * @version 1.0
	 *
	 */
	public static String getData(String key) {
		String Nkey = "";
		Nkey = key;

		if (TestDataHolder.testDataMap.get().containsKey(Nkey)) {
			return TestDataHolder.testDataMap.get().get(Nkey);
		} else {
			return TestDataHolder.testDataMap.get().get(key);
		}
	}

	/**
	 * The endThreadLocal method is used to flush and release the data stored in the hash map
	 *
	 * @param -
	 * @return -
	 * @throws
	 * @see -
	 * @since 08-07-2019
	 * @version 1.0
	 *
	 */
	public static void endThreadLocal() {
		testDataMap.remove();
	}
}
