package com.framework.automation.framework.support;

public class getTestCaseName {
    private static ThreadLocal<String> configMap = new ThreadLocal<String>();
    public static void init(String configMap) {
        getTestCaseName.configMap.set ( configMap );// = ;
        System.out.println(getTestCaseName.configMap);
    }
    public static String getValue() {
        return (String) getTestCaseName.configMap.get ();
    }
}
