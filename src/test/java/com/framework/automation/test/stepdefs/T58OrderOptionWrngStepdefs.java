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

public class T58OrderOptionWrngStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=58;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    @Given("User Verify Login and Going To Scan Item Page")
    public void user_Verify_Login_and_Going_To_Scan_Item_Page() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(15000);
        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        el2.click();
        Thread.sleep(5000);


        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[2]");
        el3.click();
        Thread.sleep(10000);


        testCase =58;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);
    }

    @Then("User Check There is Error Pop up Page")
    public void user_Check_There_is_Error_Pop_up_Page() throws InterruptedException {

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "ERROR";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/dialog_message").getText();
        expectedText = "UPC/PLU not found";
        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(5000);
        MobileElement okk = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button");
        okk.click();
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }



}
