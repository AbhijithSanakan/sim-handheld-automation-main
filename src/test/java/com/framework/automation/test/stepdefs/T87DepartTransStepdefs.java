package com.framework.automation.test.stepdefs;

import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T87DepartTransStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=87;
    static String actualText;
    static String expectedText;

    @Given("User is reach From Dashboard")
    public void user_is_reach_From_Dashboard() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(5000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']").getText();
        expectedText = "Transfers";TestAsserts.assertCheck(actualText,expectedText);



    }

    @Then("Check in DepartmentTransfer")
    public void check_in_DepartmentTransfer() throws InterruptedException {

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView");
        el1.click();
        Thread.sleep(9000);

        boolean StoreTransferIn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView").isDisplayed();
        System.out.println("The  StoreTransferIn status is" + StoreTransferIn);

        boolean StoreTransferOut = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.TextView").isDisplayed();
        System.out.println("The  StoreTransferOut status is" + StoreTransferOut);

        boolean DepartmentTransfer = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView").isDisplayed();
        System.out.println("The  DepartmentTransfer status is" + DepartmentTransfer);


        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView");
        el3.click();
        Thread.sleep(5000);

    }

    @Then("Verify in Some Sections are Available in DepartmentTransfer")
    public void verify_in_Some_Sections_are_Available_in_DepartmentTransfer() throws InterruptedException {
        MobileElement Bar  = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        Bar.click();
        Thread.sleep(9000);

        TouchAction actio = new TouchAction(driver);
        actio.press(PointOption.point(220, 650))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(220, 150)).release().perform();
        Thread.sleep(5000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Log Out']").getText();
        expectedText = "Log Out";

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Exit']").getText();
        expectedText = "Exit";

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }


}
