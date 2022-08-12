package com.framework.automation.framework.support;

import java.util.Map;

/**
 * The ApplicationProp class is used to get application configuration values and store them in hash map
 *
 * @since 11-04-2019
 * @version 1.2
 *
 */
public class ApplicationProp {
    private static Map<String, Object> configMap;

    /**
     * The init method is used to set the initialize and store value in the hashmap
     *
     * @param -Hash Map
     * @return
     * @throws
     * @see -
     * @since 11-04-2019
     * @version 1.0
     *
     */
    public static void init(Map<String, Object> configMap) {
        ApplicationProp.configMap = configMap;
        System.out.println(ApplicationProp.configMap);
    }

    /**
     * The getValue method is used to get value to the input key
     *
     * @param -String Key
     * @return - String value
     * @throws
     * @see -
     * @since 10-04-2019
     * @version 1.0
     *
     */
    public static String getValue(String key) {
        return (String) ApplicationProp.configMap.get(key);
    }

    /**
     * The endThreadLocal method is used to flush and release the data stored in the hash map
     *
     * @param -
     * @return -
     * @throws
     * @see -
     * @since 10-04-2019
     * @version 1.0
     *
     */
    public static void endThreadLocal() {
        configMap.clear();
    }
}
