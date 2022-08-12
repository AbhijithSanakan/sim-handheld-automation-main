package com.framework.automation.test.pages;

import com.framework.automation.wrapper.ui.CommonAction;

public class BasePage {

    public static void loadBaseUrl(String ApplicationName) throws Exception {
        BasePage steps = new BasePage();
        CommonAction.launchbaseURL("https://cwsqa01.corp.advancestores.com:2443/webapp/wcs/stores/servlet/LogonForm?catalogId=10051&storeId=10151&langId=-1");
        CommonAction.waitForPageLoad();
    }
}
