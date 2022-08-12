package com.framework.automation.test.stepdefs;

import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class T89DepartScreenFuntStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=89;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User is reach From Dashboard to Transferfunctionality")
    public void User_is_reach_From_Dashboard_to_Transferfunctionality() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView");
        el1.click();
        Thread.sleep(5000);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]");
        el3.click();
        Thread.sleep(5000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);


    }

    @Then("Check in Transfer Out page functionality")
    public void check_in_Transfer_Out_page_functionality() {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Choose Source']").getText();
        expectedText = "Choose Source";TestAsserts.assertCheck(actualText,expectedText);

        boolean Inventory = driver.findElementById("com.sof.retail:id/sourceInventoryRadioBtn").isDisplayed();
        System.out.println("The  Inventory status is" + Inventory);

        boolean Supply = driver.findElementById("com.sof.retail:id/sourceSupplyRadioBtn").isDisplayed();
        System.out.println("The  Supply status is" + Supply);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Choose Destination']").getText();
        expectedText = "Choose Destination";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Department']").getText();
        expectedText = "Department";TestAsserts.assertCheck(actualText,expectedText);

        boolean StoreTransferIn = driver.findElementById("com.sof.retail:id/buttonConfirm").isDisplayed();
        System.out.println("The  StoreTransferIn status is" + StoreTransferIn);

        MobileElement Suppply = (MobileElement) driver.findElementById("com.sof.retail:id/sourceSupplyRadioBtn");
        Suppply.click();

        MobileElement Invent = (MobileElement) driver.findElementById("com.sof.retail:id/sourceInventoryRadioBtn");
        Invent.click();


    }

    @Then("Verify in Some Sections are Available in DepartmentTransfer functionality")
    public void verify_in_Some_Sections_are_Available_in_Transfer_Departmentfunctionality() throws InterruptedException {

        MobileElement Supply = (MobileElement) driver.findElementById("com.sof.retail:id/deptSupplyRadioBtn");
        Supply.click();

        MobileElement Invent = (MobileElement) driver.findElementById("com.sof.retail:id/deptInventoryRadioBtn");
        Invent.click();

        MobileElement Next  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        Next.click();Thread.sleep(5000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='SELECT DEPARTMENT']").getText();
        expectedText = "SELECT DEPARTMENT";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement OK  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        OK.click();Thread.sleep(5000);
    }

    @Then("User is  Verify Able to Reach Enter Items Page and Discard functionality")
    public void user_is_Verify_Able_to_Reach_Enter_Items_Page_and_Discard_functionality() throws InterruptedException {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Department Transfer']").getText();
        expectedText = "Department Transfer";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement disK  = (MobileElement) driver.findElementById("com.sof.retail:id/discardIcon");
        disK.click();Thread.sleep(9000);

        MobileElement disc  = (MobileElement) driver.findElementById("com.sof.retail:id/discardYesButton");
        disc.click();Thread.sleep(9000);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]");
        el3.click();
        Thread.sleep(5000);

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }


}
