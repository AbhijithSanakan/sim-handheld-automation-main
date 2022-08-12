package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;

public class T91DepartScanItemFunStepdef {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=91;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User reach From Dashboard to Department Transfer")
    public void User_reach_From_Dashboard_to_Department_Transfer() throws IOException, InterruptedException {

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

        MobileElement Choose  = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerDepartment");
        Choose.click();

        MobileElement ChooseSelect = (MobileElement) driver.findElementById("com.sof.retail:id/viewDividerFirst");
        ChooseSelect.click();

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(9000);
    }

    @Then("Check in Department Transfer Out page")
    public void check_in_Department_Transfer_Out_page() {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Scan Items']").getText();
        expectedText = "Scan Items";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='UPC']").getText();
        expectedText = "UPC";TestAsserts.assertCheck(actualText,expectedText);

        boolean NoCodeBar = driver.findElementById("com.sof.retail:id/imageButton").isDisplayed();
        System.out.println("The  NoCodeBar status is" + NoCodeBar);

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

    @Then("Verify in Some Sections are Available in Scan Item when check functional")
    public void verify_in_Some_Sections_are_Available_in_Scan_Item_when_check_functional() throws InterruptedException {

        testCase =91;
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

        upc.clear();

        testCase =91;
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
        upc2.clear();
    }

    @Then("User is  Verify Able to Reach Scan Items Page")
    public void user_is_Verify_Able_to_Reach_Scan_Items_Page() throws InterruptedException {

        MobileElement NoCodeBar = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
        NoCodeBar.click();Thread.sleep(8000);

        MobileElement Cnl  = (MobileElement) driver.findElementById("com.sof.retail:id/dialogCancelButton");
        Cnl.click();Thread.sleep(8000);


        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));upc.click();Thread.sleep(6000);
        upc.sendKeys("09090909090909");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(10000);

        actualText = driver.findElementById("com.sof.retail:id/enterItemInfoDialogTitleTextView").getText();
        expectedText = "ENTER ITEM INFORMATION";TestAsserts.assertCheck(actualText,expectedText);



        MobileElement cost  = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogEditText");
        cost.click();cost.sendKeys("50.50");

        MobileElement DD  = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogSpinner");
        DD.click();

        MobileElement DDcl  = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogEditText");
        DDcl.click();

        MobileElement ok  = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogOkButton");
        ok.click();

        boolean Newitem = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView").isDisplayed();
        System.out.println("The New Item added status is" + Newitem);

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }


}
