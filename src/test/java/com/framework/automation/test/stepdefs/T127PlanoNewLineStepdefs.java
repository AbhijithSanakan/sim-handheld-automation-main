package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import gherkin.lexer.Th;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T127PlanoNewLineStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=127;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;


    @Given("User Verify Login app and Going To Planograms and Click review")
    public void user_Verify_Login_app_and_Going_To_Planograms_and_Click_review() throws IOException, InterruptedException {

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
        Thread.sleep(2000);
        MobileElement Review = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.Button");
        Review.click();
        Thread.sleep(10000);
    }

    @Then("User Verify New Lines Screen Content")
    public void user_Verify_New_Lines_Screen_Content() throws InterruptedException {
        Actions actions = new Actions(driver);

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "New Lines";TestAsserts.assertCheck(actualText,expectedText);

        testCase =127;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.clear();upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);
        upc.clear();

        testCase =127;
        keys = "UPC 2";
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys)); actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);
        upc.clear();

        driver.findElementById("com.sof.retail:id/textViewItemName").click();Thread.sleep(5000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "ITEM INFO";TestAsserts.assertCheck(actualText,expectedText);

        driver.findElementById("com.sof.retail:id/okButton").click();


        driver.findElementById("com.sof.retail:id/plnogramImagePrint").click();

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "LABEL REQUEST";TestAsserts.assertCheck(actualText,expectedText);


        driver.findElementById("com.sof.retail:id/positiveButton").click();

    }

    @Then("User Verify in all section in New lines")
    public void user_Verify_in_all_section_in_New_lines() throws InterruptedException {

        driver.findElementById("com.sof.retail:id/salesTextHolder").click();

        System.out.println("Sales popup is Visible");

        driver.findElementById("com.sof.retail:id/locTextHolder").click();

        System.out.println("Loc popup is Visible");

        driver.findElementById("com.sof.retail:id/lastTextHolder").click();

        System.out.println("Last popup is Visible");
        driver.findElementById("com.sof.retail:id/textViewShelf").click();

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(350, 460))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(100, 460)).release().perform();
        Thread.sleep(5000);

      boolean BOH=  driver.findElementById("com.sof.retail:id/txtBohText").isEnabled();
        System.out.println("BOH enable is" +BOH);



    }

    @When("Check Able Click Confirm and Back")
    public void check_Able_Click_Confirm_and_Back() throws InterruptedException {

        driver.findElementById("com.sof.retail:id/button3").click();Thread.sleep(6000);

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Questionnaire";TestAsserts.assertCheck(actualText,expectedText);

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.CheckBox")
                .click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.CheckBox")
                .click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.CheckBox")
                .click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.CheckBox")
                .click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.CheckBox")
                .click();


        driver.findElementById("com.sof.retail:id/button3").click();Thread.sleep(5000);

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Summary";TestAsserts.assertCheck(actualText,expectedText);

        driver.findElementById("com.sof.retail:id/button").click();Thread.sleep(5000);

        driver.findElementById("com.sof.retail:id/button").click();Thread.sleep(5000);

        driver.findElementById("com.sof.retail:id/button").click();
        Thread.sleep(5000);

        driver.closeApp();
        driver.quit();

    }

}
