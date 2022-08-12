package com.framework.automation.framework.support;

import java.util.Map;

/**
 * The ParallelRunHolder class is used to get parallel data details and store them in hash map
 *
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class ParallelRunHolder {
    private static ThreadLocal<Map<String, String>> configMap = new ThreadLocal<Map<String, String>>();

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
        ParallelRunHolder.configMap.set(configMap);
    }

    /**
     * The getValue method is used to get value to the input key
     *
     * @param -String Key
     * @return - String value
     * @throws
     * @see -
     * @since 08-07-2019
     * @version 1.0
     *
     */
    public static String getValue(String key) {
        return ParallelRunHolder.configMap.get().get(key);
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
        configMap.remove();
    }
}
