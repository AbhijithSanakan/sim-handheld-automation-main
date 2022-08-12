package com.framework.automation.framework;

import com.framework.automation.utils.RunLog;

public class ProgramToClose {

    public static void main(String[] args) throws InterruptedException {
        end_class();
    }

    public static void end_class() throws InterruptedException{
        try{
            String KILL = "taskkill /F /IM BrowserStackLocal.exe";
            Runtime.getRuntime().exec(KILL);
            RunLog.info("Browser Stack local instance closed for Windows");
        }
        catch (Exception e){
            try {
                String KILL = "killall -9 BrowserStackLocal.exe";
                Runtime.getRuntime().exec(KILL);
                RunLog.info("Browser Stack local instance closed for Linux");
            }
            catch (Exception ee ) { RunLog.info("No browser Stack instance to close or already Closed::::" + ee); }
        }
    }
}
