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

public class T52OrderOptionOrderStepdef {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=52;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    @Given("User Verify Login and Going To the Scan Item Page Screen")
    public void user_Verify_Login_and_Going_To_the_Scan_Item_Page_Screen() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD

        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        el2.click();
        Thread.sleep(10000);

        System.out.println("1");
//        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[2]");
//        el3.click();
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(10000);



        testCase =52;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);

    }

    @Then("User Check There is Item Details in Order Page")
    public void user_Check_There_is_Item_Details_in_Order_Page() throws InterruptedException {

        actualText = driver.findElementById("com.sof.retail:id/tvDesc").getText();
        expectedText = "Test Bananas (/KG)";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/tvPriceValue").getText();
        expectedText = "2.99 EACH";
        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(5000);
//        MobileElement Basic = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"BASIC\"]/android.widget.TextView");
//        Basic.click();
    }

    @Then("User Verify all in Item Order Details Page")
    public void user_Verify_all_in_Item_Order_Details_Page() throws InterruptedException {
        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
        expectedText = "BOH:";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/currentWeekForecastVal").getText();
        expectedText = "0.00";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/tvsfty").getText();
        expectedText = "Safety:";TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/nextweekForecastVal").getText();
        expectedText = "0.00";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
        expectedText = "Min. Qty:";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/lastWeekSalesVal").getText();
        expectedText = "0.00";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/currentWeekForecastTextView").getText();
        expectedText = "Current Week Forecast";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/currentWeekSalesVal").getText();
        expectedText = "0.00";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/nextweekForecastTextView").getText();
        expectedText = "Next Week Forecast";
        TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/lastWeekSalesTextView").getText();
        expectedText = "Last Week Sales";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/currentWeekSalesTextView").getText();
        expectedText = "Current Week Sales";TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/caoOrderTextView").getText();
        expectedText = "CAO Order";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/locationsTextView").getText();
        expectedText = "Locations";TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }
}
