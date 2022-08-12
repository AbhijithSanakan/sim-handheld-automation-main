package com.framework.automation.framework.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.framework.automation.utils.TestUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class DataHandler {

    private static Map<String, Object> datamap;

    /**
     * Loads the DataRepository YAML file
     * @param filename - name excluding .yaml extension for file placed under DataRepository folder
     * @return
     */
    public static void loadTestDataFromDataRepository(String filename) {
        try{
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        InputStream resource = new FileInputStream(System.getProperty("user.dir")+"/DataRepository/"+filename+".yaml");
        DataHandler.datamap = mapper.readValue(resource, Map.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * The getValue method is used to get value to the input keys
     */
    public static String getValue(String testCaseName , String key) {
        Map<String,String>dataLine = (Map<String, String>) DataHandler.datamap.get(testCaseName);
        return dataLine.get(key);
    }



    public static void main(String[] args) {
        loadTestDataFromDataRepository("Data");
        DataHandler.getValue("TestName 1","Key1");
    }


}
