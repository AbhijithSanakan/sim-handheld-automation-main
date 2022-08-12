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

public class T93DepaTransStorInventStepdefs {

    private AndroidDriver<AndroidElement> driver;
    static int testCase=93;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;


    @Given("User is reach From Dashboard to DepartmentTransfer")
    public void User_is_reach_From_Dashboard_to_DepartmentTransfer() throws IOException, InterruptedException {

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

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(9000);
    }

    @Then("Check in DepartmentTransfer Out page")
    public void check_in_DepartmentTransfer_Out_page() throws InterruptedException {

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "SELECT DEPARTMENT";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Ok  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Ok.click();Thread.sleep(5000);


        MobileElement Choose  = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerDepartment");
        Choose.click();

        MobileElement ChooseSelect = (MobileElement) driver.findElementById("com.sof.retail:id/viewDividerFirst");
        ChooseSelect.click();

        actualText = driver.findElementById("com.sof.retail:id/spinnerDepartment").getText();
        expectedText = "BULK (16)";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(9000);

    }

    @Then("Verify in Some Sections are Available in DepartmentTransfer Out when source is Inventory")
    public void verify_in_Some_Sections_are_Available_in_DepartmentTransfer_Out_when_source_is_Inventory() throws InterruptedException {
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



        testCase =93;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(7000);

        //Checking whether Min Field is clickable
        boolean minFieldClick = driver.findElement(By.id("com.sof.retail:id/overrideExtCost")).getAttribute("clickable").equals("true");
        if (minFieldClick == true) {
            System.out.println("Override Ext Cost Field is editable");
        } else {
            System.out.println("Override Ext Cost Field is Read Only");
        }

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        next.click();
        Thread.sleep(9000);


    }

    @Then("User is Verify Able to Reach Enter Items Page and Send")
    public void user_is_Verify_Able_to_Reach_Enter_Items_Page_and_Send() throws InterruptedException, IOException {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Initial Total Cost']").getText();
        expectedText = "Initial Total Cost";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Total Adjustments']").getText();
        expectedText = "Total Adjustments";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Final Total Cost']").getText();
        expectedText = "Final Total Cost";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        next.click();Thread.sleep(9000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Comments']").getText();
        expectedText = "Comments";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Comment  = (MobileElement) driver.findElementById("com.sof.retail:id/etComment");
        Comment.click();Comment.sendKeys("Inventory");

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\Deviations\\T93-Step-10" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        MobileElement nex  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        nex.click();
        Thread.sleep(9000);

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
        Thread.sleep(15000);
        transNum= driver.findElementById("com.sof.retail:id/descpCountText").getText();

        testCase =93;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName1="D:\\SOF-automation\\IMAF-main\\ScreenShots\\T85" +".jpg";
        FileUtils.copyFile(file1,new File(fileName1));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();


    }


}
