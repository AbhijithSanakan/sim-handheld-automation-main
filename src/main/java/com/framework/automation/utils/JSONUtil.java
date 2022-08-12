package com.framework.automation.utils;

import com.google.gson.Gson;

/**
 * The JSONUtil class provides all required methods to script for json usages
 *
 * @since 09-19-2019
 * @version 1.1
 *
 */
public class JSONUtil {

    /**
     * get Json from JAXBclass
     * @param -Object sourceObj
     * @return
     */
    public static String getJSONFromJAXBClass(Object sourceObj)
    {
        Gson gson = new Gson();
        return gson.toJson(sourceObj);
    }

    /**
     * get  JAXBclass from Json
     * @param -Class sourceclass, String source Json
     * @return
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    public static Object getJAXBClassFromJSON(Class sourceClass,String sourceJSON)
    {
        Gson gson = new Gson();
        return gson.fromJson(sourceJSON, sourceClass);
    }
}
