package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class T85TransSourceSupplyStepdef {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=85;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User reach From Dashboard to Transfer Out")
    public void user_reach_From_Dashboard_to_Transfer_Out() throws IOException, InterruptedException {
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

    @Then("Check in Transfer Out page update UPC")
    public void check_in_Transfer_Out_page_update_UPC() throws InterruptedException {

        MobileElement Supply = (MobileElement) driver.findElementById("com.sof.retail:id/sourceSupplyRadioBtn");
        Supply.click();

        MobileElement Choose  = (MobileElement) driver.findElementById("com.sof.retail:id/llStore");
        Choose.click();Thread.sleep(9000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        Thread.sleep(10000);



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

    @Then("Verify in Some Sections are Available in Transfer Out when source is Supply")
    public void verify_in_Some_Sections_are_Available_in_Transfer_Out_when_source_is_Supply() throws InterruptedException {

        testCase =85;
        keys = "UPC 1";
        MobileElement upc2 = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc2.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);

        testCase =83;
        keys = "UPC 2";
        MobileElement upc1 = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc2.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);

        boolean UnitCostField = driver.findElementById("com.sof.retail:id/unitCost").isDisplayed();
        System.out.println("The  UnitCost Field status is" + UnitCostField);

        boolean overrideExtField = driver.findElementById("com.sof.retail:id/overrideExtCost").isDisplayed();
        System.out.println("The  overrideExt Field status is" + overrideExtField);

        boolean extCostField = driver.findElementById("com.sof.retail:id/extCost").isDisplayed();
        System.out.println("The  extCost Field status is" + extCostField);

        boolean DescriptionField = driver.findElementById("com.sof.retail:id/itemDescription").isDisplayed();
        System.out.println("The  Description Field status is" + DescriptionField);

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        next.click();
        Thread.sleep(9000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Confirm Total']").getText();
        expectedText = "Confirm Total";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Initial Total Cost']").getText();
        expectedText = "Initial Total Cost";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Total Adjustments']").getText();
        expectedText = "Total Adjustments";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Final Total Cost']").getText();
        expectedText = "Final Total Cost";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Next  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Next.click();
        Thread.sleep(9000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Comments']").getText();
        expectedText = "Comments";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement combox = (MobileElement) driver.findElementById("com.sof.retail:id/etComment");
        combox.click();
        combox.sendKeys("Product out");
        Thread.sleep(5000);


        MobileElement nxt = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        nxt.click();Thread.sleep(8000);

    }

    @Then("User is  Verify Able to Reach Enter Items Page and Send to Trans")
    public void user_is_Verify_Able_to_Reach_Enter_Items_Page_and_Send_to_Trans() throws IOException, InterruptedException {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Summary']").getText();
        expectedText = "Summary";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Source Department']").getText();
        expectedText = "Source Department";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Total']").getText();
        expectedText = "Total";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement snd = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        snd.click();

        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();
        Thread.sleep(18000);

        transNum= driver.findElementById("com.sof.retail:id/descpCountText").getText();

        testCase =85;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\T85" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }




}
