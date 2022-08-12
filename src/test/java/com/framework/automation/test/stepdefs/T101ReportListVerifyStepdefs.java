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
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class T101ReportListVerifyStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=101;
    static String actualText;
    static String expectedText;


    @Given("User Verify Login and Going To Select Hamburger Icon")
    public void user_Verify_Login_and_Going_To_Select_Hamburger_Icon() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        //Click Order DD
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
        el1.click();
        Thread.sleep(5000);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[6]");
        el2.click();
        Thread.sleep(5000);




//        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]");
//        el3.click();
//        Thread.sleep(5000);
//
//        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
//            Restore.click();}
//        catch (Exception e){System.out.println("No Restore popup");}
//        Thread.sleep(10000);
    }

    @Then("User Check Verify in Report Page")
    public void user_Check_Verify_in_Report_Page() {

        boolean Discard = driver.findElementById("com.sof.retail:id/discardIcon").isDisplayed();
        System.out.println("The  Discard status is" + Discard);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Print and email reports']").getText();
        expectedText = "Print and email reports";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='PRINT']").getText();
        expectedText = "PRINT";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='STATUS']").getText();
        expectedText = "STATUS";TestAsserts.assertCheck(actualText,expectedText);

        boolean ReportDD = driver.findElementById("com.sof.retail:id/spinnerTextView").isDisplayed();
        System.out.println("The ReportDropDown status is" + ReportDD);
    }

    @Then("User Verify all in Report DropDown")
    public void user_Verify_all_in_Report_DropDown() throws InterruptedException {

        MobileElement el2 = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerTextView");
        el2.click();Thread.sleep(6000);

        //Locate all drop down list elements
        List dropList = driver.findElements(By.id("com.sof.retail:id/spinnerTextView"));

        //Extract text from each element of drop down list one by one.
        for (int i = 0; i < dropList.size(); i++) {
            MobileElement listItem = (MobileElement) dropList.get(i);
            System.out.println(listItem.getText());
        }
    }
        @When("Click on Discard Button back to Dash bord")
        public void click_on_Discard_Button_back_to_Dash_bord () throws InterruptedException {

            MobileElement Discard = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerTextView");
            Discard.click();

            MobileElement DiscardS = (MobileElement) driver.findElementById("com.sof.retail:id/discardIcon");
            DiscardS.click();Thread.sleep(3000);

            driver.closeApp();
            driver.quit();
        }


    }
