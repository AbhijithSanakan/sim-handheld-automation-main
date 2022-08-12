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
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T125PlanogramScrnFunStepdefs {

    static AndroidDriver<AndroidElement> driver;
    static int testCase=125;
    static String actualText;
    static String expectedText;

    @Given("User Verify Login and Going To Planograms")
    public void user_Verify_Login_and_Going_To_Planograms() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(5000);

        //Swiping Down
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);

        //Click Planograms
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[7]");
        el3.click();
        Thread.sleep(5000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}

        Thread.sleep(15000);
    }

    @Then("User Verify Planogram Screen Content and Refresh")
    public void user_Verify_Planogram_Screen_Content_and_Refresh() throws InterruptedException {

        actualText = driver.findElementById("com.sof.retail:id/tvSelectPlanograms").getText();
        expectedText = "Select a Planogram from the list below and perform action.";TestAsserts.assertCheck(actualText,expectedText);

        boolean Planogram = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup").isDisplayed();
        System.out.println("The  Planogram status is" + Planogram);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Removed,']").getText();
        expectedText = "Removed,";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Added']").getText();
        expectedText = "Added";TestAsserts.assertCheck(actualText,expectedText);

        boolean Expected = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup").isDisplayed();
        System.out.println("The  Planogram status is" + Planogram);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='URGENT']").getText();
        expectedText = "URGENT";TestAsserts.assertCheck(actualText,expectedText);

        boolean Review = driver.findElementById("com.sof.retail:id/btnReview").isDisplayed();
        System.out.println("The  Review Button status is" + Review);

        boolean CheckBox = driver.findElementById("com.sof.retail:id/cbApprovedPlanograms").isDisplayed();
        System.out.println("The  CheckBox status is" + CheckBox);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(250, 200))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(250, 450)).release().perform();
        Thread.sleep(5000);
    }

    @Then("User Verify Planogram Approved Checkbox")
    public void user_Verify_Planogram_Approved_Checkbox() throws InterruptedException {

        driver.findElementById("com.sof.retail:id/cbApprovedPlanograms").click();Thread.sleep(9000);

        driver.findElementById("com.sof.retail:id/btnReview").click();Thread.sleep(9000);


    }

    @When("Check Able to click Discard button")
    public void check_Able_to_click_Discard_button() throws InterruptedException {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='New Lines']").getText();
        expectedText = "New Lines";TestAsserts.assertCheck(actualText,expectedText);

        driver.findElementById("com.sof.retail:id/discardIcon").click();Thread.sleep(9000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Planograms']").getText();
        expectedText = "Planograms";TestAsserts.assertCheck(actualText,expectedText);

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }


}
