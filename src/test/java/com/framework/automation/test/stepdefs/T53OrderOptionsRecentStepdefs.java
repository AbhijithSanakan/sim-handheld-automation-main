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

public class T53OrderOptionsRecentStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=53;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User Verify Login and Going in the Scan Item Page Screen")
    public void user_Verify_Login_and_Going_in_the_Scan_Item_Page_Screen() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        el2.click();
        Thread.sleep(5000);


//        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[2]");
//        el3.click();
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);


        testCase =53;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);


    }

    @Then("User Check There is Item Details in Recent Page")
    public void user_Check_There_is_Item_Details_in_Recent_Page() {
        MobileElement Basic = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"RECENT\"]/android.widget.TextView");
        Basic.click();


    }

    @Then("User Verify all in Item Recent Details Page")
    public void user_Verify_all_in_Item_Recent_Details_Page() throws InterruptedException {
        actualText = driver.findElementById("com.sof.retail:id/upcTextView").getText();
        expectedText = "Last Sold";
        TestAsserts.assertCheck(actualText,expectedText);
//        actualText = driver.findElementById("com.sof.retail:id/upcVal").getText();
//        expectedText = "n/a";
//        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/deptTextView").getText();
        expectedText = "Last Received";
        TestAsserts.assertCheck(actualText,expectedText);
//        actualText = driver.findElementById("com.sof.retail:id/deptVal").getText();
//        expectedText = "n/a";
//        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/packTextView").getText();
        expectedText = "Last Counted";
        TestAsserts.assertCheck(actualText,expectedText);
//        actualText = driver.findElementById("com.sof.retail:id/packVal").getText();
//        expectedText = "n/a";
//        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }

}
