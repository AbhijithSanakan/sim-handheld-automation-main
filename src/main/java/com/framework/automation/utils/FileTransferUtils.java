package com.framework.automation.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The FileTransferUtils class have methods which are useful to transfer files
 *
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class FileTransferUtils {

    /**
     * The winscp_transfer_file method is used transfer files through unix winscp commends
     *
     * @param command
     * @since 11-24-2019
     * @version 1.0
     *
     */
    public void winscp_transfer_file(String command){
        try {

            Process cpyFileLocal = Runtime.getRuntime().exec(command);
//          Process cpyFileLocal = Runtime.getRuntime().exec(new String[] {"/bin/sh","-c", "scp  " + rFile+"*.csv"     + " root@" + host + ":" + lFile});
            InputStream stderr = cpyFileLocal.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<ERROR>");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("</ERROR>");
            int exitVal = cpyFileLocal.waitFor();
            System.out.println("Process exitValue: " + exitVal);
            System.out.println("...." + cpyFileLocal.exitValue());
            System.out.println("pscp -pw Coffee20!9 C:\\temp\\automation.txt c723926@CWSAPPQA01:/usr/local/jee/spring/apps/qa1_cwsappqa01_MuleMock/automation.txt");
            System.out.println("Sending  complete...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
