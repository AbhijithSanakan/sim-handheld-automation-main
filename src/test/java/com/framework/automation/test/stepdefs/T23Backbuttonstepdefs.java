package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Wrapper;
import java.time.Duration;

public class T23Backbuttonstepdefs extends Login{

    static AndroidDriver<AndroidElement> driver;
    public void ReceiveDeliveryDiscardStepdef() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();

    }
    @Given("Next until comment Section")
    public void admin_Login_and_to_Dashboard_for_further_operation() throws InterruptedException, IOException {


        this.driver = Login.LoginDriver();
        Thread.sleep(20000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        Thread.sleep(10000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click();
        Thread.sleep(10000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);

        MobileElement rcvin = (MobileElement) driver.findElementById("com.sof.retail:id/receivedInvoiceCheckBox");
        rcvin.click();


        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();

        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();

        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();
        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();
        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();
        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();
        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();
        action.press(PointOption.point(80, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(37, 214)).release().perform();
        MobileElement Adj = (MobileElement) driver.findElementByXPath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        Adj.click();
        Thread.sleep(10000);
        MobileElement Nxt1 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Nxt1.click();
        Thread.sleep(10000);
        MobileElement Nxt2 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt2.click();
        Thread.sleep(10000);
        MobileElement Nxt3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]");
        Nxt3.click();
        Thread.sleep(10000);
//        MobileElement Nxt4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nxt4.click();

        Thread.sleep(10000);
        System.out.println("Test completed in Forward Button");




    }

    @Then("Back until Delivery Info Section")
    public void next_until_comment_Section() throws InterruptedException {

        MobileElement back1 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        back1.click();
        Thread.sleep(5000);
        MobileElement back2 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        back2.click();
        Thread.sleep(5000);
        MobileElement back3 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        back3.click();
        Thread.sleep(5000);
        MobileElement back4 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        back4.click();

        System.out.println("Test Completed in Back Button");
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();


    }


    }
