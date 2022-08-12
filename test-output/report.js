$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/DRCount.feature");
formatter.feature({
  "name": "DRCount Page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DRCount"
    }
  ]
});
formatter.scenario({
  "name": "To verify Hole count flow when holes are counted for few items.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DRCount"
    },
    {
      "name": "@HoleCount"
    }
  ]
});
formatter.step({
  "name": "Admin is logged in the app dashboard page",
  "keyword": "Given "
});
formatter.match({
  "location": "DRCountStepDef.admin_is_logged_in_the_app_dashboard_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Tap on Count icon from dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "DRCountStepDef.tap_on_Count_icon_from_dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Hole Count and verify the flow when holes are counted for few items",
  "keyword": "And "
});
formatter.match({
  "location": "DRCountStepDef.clickOnHoleCountAndVerifyTheFlowWhenHolesAreCountedForFewItems()"
});
formatter.result({
  "error_message": "org.openqa.selenium.StaleElementReferenceException: The element \u0027By.id: com.sof.retail:id/upcScanText\u0027 does not exist in DOM anymore\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027TVMATP532775L\u0027, ip: \u0027192.168.1.6\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002718.0.1.1\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {app: D:\\SOF Automation\\IMAF-main..., appActivity: com.sof.retail.view.activit..., appPackage: com.sof.retail, automationName: uiautomator2, databaseEnabled: false, desired: {app: D:\\SOF Automation\\IMAF-main..., appActivity: com.sof.retail.view.activit..., appPackage: com.sof.retail, automationName: uiautomator2, deviceName: 20003522502670, fullReset: false, noReset: true, platformName: android, platformVersion: 8.1}, deviceApiLevel: 27, deviceManufacturer: Zebra Technologies, deviceModel: MC93, deviceName: 20003522502670, deviceScreenDensity: 240, deviceScreenSize: 480x800, deviceUDID: 20003522502670, fullReset: false, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, noReset: true, pixelRatio: 1.5, platform: LINUX, platformName: Android, platformVersion: 8.1.0, statBarHeight: 36, takesScreenshot: true, viewportRect: {height: 692, left: 0, top: 36, width: 480}, warnings: {}, webStorageEnabled: false}\nSession ID: bbb1dd43-d0ac-411b-b0e7-477ab3212e64\r\n\tat java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:67)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:483)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:250)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat io.appium.java_client.DefaultGenericMobileElement.execute(DefaultGenericMobileElement.java:45)\r\n\tat io.appium.java_client.MobileElement.execute(MobileElement.java:1)\r\n\tat io.appium.java_client.android.AndroidElement.execute(AndroidElement.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.clear(RemoteWebElement.java:124)\r\n\tat com.framework.automation.test.pages.DRCountPage.holeCount(DRCountPage.java:220)\r\n\tat com.framework.automation.test.stepdefs.DRCountStepDef.clickOnHoleCountAndVerifyTheFlowWhenHolesAreCountedForFewItems(DRCountStepDef.java:34)\r\n\tat ✽.Click on Hole Count and verify the flow when holes are counted for few items(file:Features/DRCount.feature:15)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Verified the count flow",
  "keyword": "Then "
});
formatter.match({
  "location": "DRCountStepDef.verifiedTheCountFlow()"
});
formatter.result({
  "status": "skipped"
});
});