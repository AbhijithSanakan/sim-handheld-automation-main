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
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T57OrderOptionsStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=57;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User Verify Login and Going To Scan Item Page Screen")
    public void user_Verify_Login_and_Going_To_Scan_Item_Page_Screen() throws IOException, InterruptedException {

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




        testCase =57;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);



    }

    @Then("User Check There is Item Details Page")
    public void user_Check_There_is_Item_Details_Page() throws InterruptedException {
        actualText = driver.findElementById("com.sof.retail:id/tvDesc").getText();
        expectedText = "Carnation Evaporated Milk (354ML)";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/tvPriceValue").getText();
        expectedText = "2.99 EACH";
        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(5000);
        MobileElement Basic = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"BASIC\"]/android.widget.TextView");
        Basic.click();
    }

    @Then("User Verify all in Item Basic Details Page")
    public void user_Verify_all_in_Item_Basic_Details_Page() {
        actualText = driver.findElementById("com.sof.retail:id/upcTextView").getText();
        expectedText = "UPC";
        TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/upcVal").getText();
        expectedText = "5900000311";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/deptTextView").getText();
        expectedText = "Dept";
        TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/deptVal").getText();
        expectedText = "Grocery";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/categoryTextView").getText();
        expectedText = "Category";
        TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/categoryVal").getText();
        expectedText = "Canned Evaporated Milk";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/packTextView").getText();
        expectedText = "Pack";TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/packVal").getText();
        expectedText = "48";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/uomTextView").getText();
        expectedText = "UOM";TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/uomVal").getText();
        expectedText = "EACH";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/variantTextView").getText();
        expectedText = "Variant ID";TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/variantVal").getText();
        expectedText = "3730015";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/shipcaseTextView").getText();
        expectedText = "Shipcase ID";TestAsserts.assertCheck(actualText,expectedText);
        actualText = driver.findElementById("com.sof.retail:id/shipcaseVal").getText();
        expectedText = "3730016";TestAsserts.assertCheck(actualText,expectedText);





    }

    @When("Check Product able to Remove In Order Guide Page")
    public void check_Product_able_to_Remove_In_Order_Guide_Page() {
        driver.closeApp();
        driver.quit();
    }
}
