package com.framework.automation.utils;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;

public class RunLog {

// Initialize Log4j logs

        private static Logger Log = LogManager.getLogger(RunLog.class);
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File("src/test/resources/log4j2.xml");

        // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

        public static void startTestCase(String sModuleName){
            Log.info("#######################                 "+sModuleName+ "       ##########################");
        }

        //This is to print log for the ending of the test case

        public static void endTestCase(String sModuleName){

            Log.info("#######################         End of " + sModuleName+ "      ##########################");
        }

        // Need to create these methods, so that they can be called

        public static void info(String message) {
            Log.info(message);
        }

        public static void warn(String message) {
            Log.warn(message);
        }

        public static void error(String message) {
            Log.error(message);
        }

        public static void fatal(String message) {
            Log.fatal(message);
        }

        public static void debug(String message) {

            Log.debug(message);

        }
}
