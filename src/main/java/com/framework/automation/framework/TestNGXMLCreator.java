package com.framework.automation.framework;


import com.browserstack.local.Local;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.framework.automation.framework.support.ConfigProp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The TestNGXMLCreator class is used create required testnG files using Excel Scanner class
 *
 *
 * @version 1.0
 * @since 04-10-2019
 */
public class TestNGXMLCreator {

    private static Map<String, Map<String, Map<String, ArrayList<Map<String, String>>>>> testsComb = new HashMap<String, Map<String, Map<String, ArrayList<Map<String, String>>>>>();
    private static XmlSuite suiteD, suiteM, suiteApp;

    private static XmlTest testD;
    private static XmlTest testM;
    private static XmlTest testMApp;

    private static ArrayList<String> classesList = new ArrayList<>();

    private static XmlClass xmlClass;
    private static List<XmlInclude> methodIncludes = new ArrayList<XmlInclude>();
    private static List<XmlClass> xmlClassesList = new ArrayList<XmlClass>();

    private static String basepkg = "com.aap.automation.tests.BddTests";

    //main method to call all related methods in a flow//
    public static void main(String[] args) throws InterruptedException {
        main_class();
    }

    public static void main_class() {
        xmlInit();
        suiteGen();
        String xmlD = getXMLD();
        writeToXMLD(xmlD);
    }

    /**
     * The xmlinit method is used to set the testnG suites ad various testNG xmls required
     *
     * @param -
     * @return
     * @throws
     * @version 1.0

     * @see -
     * @since 04-10-2019
     */
    private static void xmlInit() {
        suiteD = new XmlSuite();
        if (ConfigProp.getPropertyValue("parallelExecution").equalsIgnoreCase("yes")) {
            if (System.getProperty("jenkinsRun").toLowerCase().contains("yes")) {
                suiteD.setParallel(XmlSuite.ParallelMode.METHODS);
                suiteD.setThreadCount(Integer.parseInt(System.getProperty("noOfThread")));
                suiteD.setDataProviderThreadCount(Integer.parseInt(System.getProperty("noOfThread")));
            } else {
                suiteD.setParallel(XmlSuite.ParallelMode.METHODS);
                suiteD.setThreadCount(Integer.parseInt(ConfigProp.getPropertyValue("noOfThread")));
                suiteD.setDataProviderThreadCount(Integer.parseInt(ConfigProp.getPropertyValue("noOfDataProvider")));
            }
        } else {
            suiteD.setParallel(XmlSuite.DEFAULT_PARALLEL);
            suiteD.setThreadCount(1);
            suiteD.setDataProviderThreadCount(1);
        }
        assignSuiteName();
    }

    /**
     * The suiteGen method is used to set the valuesfor various testNG xmls required
     *
     * @param -
     * @return
     * @throws
     * @version 1.0

     * @see -
     * @since 04-10-2019
     */
    private static void suiteGen() {
        testD = new XmlTest(suiteD);
        testD.setName("Test");
        testD.setThreadCount(1);
        testD.setParallel(XmlSuite.DEFAULT_PARALLEL);
        xmlClass = new XmlClass(basepkg);
        methodIncludes = xmlClass.getIncludedMethods();
        methodIncludes.add(new XmlInclude("scenarioRunner"));
        xmlClassesList.add(xmlClass);
        testD.setXmlClasses(xmlClassesList);
    }


    private static String getXMLD() {
        return suiteD.toXml();
    }


    /**
     * The writeToXMLD method is used to write the created TesnTG as a file XMLD to the parent location
     *
     * @param -
     * @return
     * @throws
     * @version 1.0

     * @see -
     * @since 04-10-2019
     */
    private static void writeToXMLD(String xml) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("TestNgD.xml"), "utf-8"))) {
            writer.write(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void assignSuiteName() {
        suiteD.setName(ConfigProp.getPropertyValue("ProjectName"));
    }


}
