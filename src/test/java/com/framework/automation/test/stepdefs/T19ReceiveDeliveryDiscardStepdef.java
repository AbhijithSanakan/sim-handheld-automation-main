package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.MalformedURLException;

public class T19ReceiveDeliveryDiscardStepdef extends Login {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=19;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    public T19ReceiveDeliveryDiscardStepdef() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }
    @Given("User reach on Select Invoice page")
    public void user_reach_on_Select_Invoice_page() throws MalformedURLException, InterruptedException {
        try{

        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click();Thread.sleep(5000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);
        }
        catch (Exception e){
            System.out.println("Receive invoice not available");
        }Thread.sleep(10000);



    }

    @Then("choose invoice and get back to select invoice")
    public void choose_invoice_and_get_back_to_select_invoice()throws MalformedURLException, InterruptedException {
try{
        MobileElement rcv = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
        rcv.click();

        Thread.sleep(10000);

        MobileElement Nextbtn = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Nextbtn.click();

        Thread.sleep(10000);


        MobileElement bckbt = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        bckbt.click();
        Thread.sleep(10000);

        MobileElement outbtn = (MobileElement) driver.findElementById("com.sof.retail:id/discardIcon");
        outbtn.click();

        boolean DRtxt = driver.findElementById("com.sof.retail:id/dialogDescWarningTextView").isDisplayed();
        System.out.println("The Discard Receving  status is" +DRtxt);
        Thread.sleep(10000);

        MobileElement Disbtn = (MobileElement) driver.findElementById("com.sof.retail:id/discardYesButton");
        Disbtn.click();
        Thread.sleep(10000);

        boolean Selectinv = driver.findElementById("com.sof.retail:id/toolBarHeader").isDisplayed();
        System.out.println("The Select Invoice page status is" +Selectinv);}
catch (Exception e) {
    System.out.println("Receive Invoice Not Available");
}
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();


    }
}
