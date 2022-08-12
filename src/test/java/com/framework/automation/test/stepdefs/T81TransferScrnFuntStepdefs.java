package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T81TransferScrnFuntStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=81;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;


    @Given("User is reach From Dashboard to Transfer Out page")
    public void user_is_reach_From_Dashboard_to_Transfer_Out_page() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView");
        el1.click();
        Thread.sleep(5000);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]");
        el3.click();
        Thread.sleep(5000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);


    }

    @Then("Check in Transfer Out page Page")
    public void check_in_Transfer_Out_page_Page() throws InterruptedException {

        MobileElement Next  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        Next.click();
        Thread.sleep(5000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "SELECT STORE";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Ok  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Ok.click();Thread.sleep(5000);

        MobileElement Choose  = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerStore");
        Choose.click();

        MobileElement ChooseSelect = (MobileElement) driver.findElementById("com.sof.retail:id/viewDividerFirst");
        ChooseSelect.click();

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(9000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='UOM']").getText();
        expectedText = "UOM";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Override Ext Cost']").getText();
        expectedText = "Override Ext Cost";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Unit Cost']").getText();
        expectedText = "Unit Cost";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Ext Cost']").getText();
        expectedText = "Ext Cost";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Description']").getText();
        expectedText = "Description";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Total']").getText();
        expectedText = "Total";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/button").getText();
        expectedText = "BACK";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/button3").getText();
        expectedText = "NEXT";TestAsserts.assertCheck(actualText,expectedText);

    }

    @Then("Verify in Some Sections are Available in Transfer Out page Page")
    public void verify_in_Some_Sections_are_Available_in_Transfer_Out_page_Page() throws InterruptedException {

        testCase =81;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);

        actualText = driver.findElementById("com.sof.retail:id/enterItemInfoDialogTitleTextView").getText();
        expectedText = "ENTER ITEM INFORMATION";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Cnl  = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogCancelButton");
        Cnl.click();
        Thread.sleep(6000);

        testCase =81;
        keys = "UPC 2";
        MobileElement upc2 = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc2.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);

        actualText = driver.findElementById("com.sof.retail:id/button").getText();
        expectedText = "BACK";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/button3").getText();
        expectedText = "NEXT";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='UOM']").getText();
        expectedText = "UOM";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Override Ext Cost']").getText();
        expectedText = "Override Ext Cost";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Unit Cost']").getText();
        expectedText = "Unit Cost";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Ext Cost']").getText();
        expectedText = "Ext Cost";TestAsserts.assertCheck(actualText,expectedText);

        boolean Hyplink = driver.findElementById("com.sof.retail:id/linkDesc").isDisplayed();
        System.out.println("The Hyper link status is" + Hyplink);

        boolean DepDD = driver.findElementById("com.sof.retail:id/dropDownImgDept").isDisplayed();
        System.out.println("The Department DropDown status is" + DepDD);

        TouchAction actio = new TouchAction(driver);
        actio.press(PointOption.point(332, 420))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(77, 420)).release().perform();
        Thread.sleep(5000);


        boolean Delet = driver.findElementById("com.sof.retail:id/itemDelete").isDisplayed();
        System.out.println("The  DeletBTN status is" + Delet);

        MobileElement Nocode  = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
        Nocode.click();

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='CAN’T SCAN']").getText();
        expectedText = "CAN’T SCAN";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Canl  = (MobileElement) driver.findElementById("com.sof.retail:id/dialogCancelButton");
        Canl.click();

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Scan Items";TestAsserts.assertCheck(actualText,expectedText);
    }

    @Then("User is  Verify Able to Reach Enter Items Page")
    public void user_is_Verify_Able_to_Reach_Enter_Items_Page() throws InterruptedException {

        MobileElement Nocode  = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
        Nocode.click();

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='CAN’T SCAN']").getText();
        expectedText = "CAN’T SCAN";TestAsserts.assertCheck(actualText,expectedText);


        testCase =81;
        keys = "Department";
        MobileElement upc2 = (MobileElement) driver.findElement(By.id("com.sof.retail:id/dialogEditText"));
        upc2.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);

//        MobileElement okkCanl  = (MobileElement) driver.findElementById("com.sof.retail:id/dialogOkButton");
//        okkCanl.click();

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }


}
