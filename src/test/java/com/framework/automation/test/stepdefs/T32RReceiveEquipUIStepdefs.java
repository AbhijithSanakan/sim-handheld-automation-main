package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T32RReceiveEquipUIStepdefs {
    static AndroidDriver<AndroidElement> driver;

    @Given("User is reach Dashboard to ReceiveEquipment")
    public void user_is_reach_Dashboard_to_ReceiveEquipment() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.TextView");
        el1.click();
        Thread.sleep(10000);









    }


    @Then("Check ReceiveEquipment Page")
    public void Check_ReceiveEquipment_Page() throws InterruptedException {
        String RcvEqup = driver.findElement(By.id("com.sof.retail:id/purchaseOrderHeading")).getText();
        Assert.assertEquals(RcvEqup, "Select a Purchase Order (PO) below.");
        System.out.println(RcvEqup + " is visible");
        Thread.sleep(5000);

        String nopo = driver.findElement(By.id("com.sof.retail:id/purchaseOrderNoData")).getText();
        Assert.assertEquals(nopo, "No POs Available");
        System.out.println(nopo + " is visible");
        Thread.sleep(5000);

        String rcvckbx = driver.findElement(By.id("com.sof.retail:id/cbReceivedPo")).getText();
        Assert.assertEquals(rcvckbx, "Received POs");
        System.out.println(rcvckbx + " is visible");
        Thread.sleep(5000);

        String days = driver.findElement(By.id("com.sof.retail:id/daysTextView")).getText();
        Assert.assertEquals(days, "Days");
        System.out.println(days + " is visible");
        Thread.sleep(5000);

        boolean search = driver.findElementById("com.sof.retail:id/editPO").isEnabled();
        System.out.println("The Search box status is" + search);
        Thread.sleep(4000);

        boolean disbut = driver.findElementById("com.sof.retail:id/discardIcon").isEnabled();
        System.out.println("The disbut status is" + disbut);
        Thread.sleep(4000);
        MobileElement chx = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
        chx.click();

        MobileElement dayss = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerPrinter");
        dayss.click();
        Thread.sleep(5000);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(391, 712))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(381, 113)).release().perform();
        Thread.sleep(10000);

        String day31 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[17]")).getText();
        Assert.assertEquals(day31, "31");
        System.out.println(day31 + " is visible");
        Thread.sleep(5000);

        MobileElement  clk = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[17]");
        clk.click();
    }

    @Then("Verify is Some Sections are Available in ReceiveEquipment Page")
    public void verify_is_Some_Sections_are_Available_in_ReceiveEquipment_Page() throws InterruptedException {
        System.out.println("Screen refreshed");
        Thread.sleep(6000);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText")).sendKeys("0");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
        MobileElement  clk1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText");
        clk1.click();
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(9000);
        System.out.println("1");
        String REQUIRED = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(REQUIRED, "REQUIRED");
        System.out.println(REQUIRED + " is visible");
        Thread.sleep(5000);

        MobileElement ok1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button");
        ok1.click();

        String Failed = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(Failed, "FAILED TO RETRIEVE PO");
        System.out.println(Failed + " is visible");
        Thread.sleep(5000);

        String Cancel = driver.findElement(By.id("com.sof.retail:id/negativeButton")).getText();
        Assert.assertEquals(Cancel, "CANCEL");
        System.out.println(Cancel + " is visible");
        Thread.sleep(5000);

        String Retry = driver.findElement(By.id("com.sof.retail:id/positiveButton")).getText();
        Assert.assertEquals(Retry, "RETRY");
        System.out.println(Retry + " is visible");
        Thread.sleep(5000);



        MobileElement ok2 = (MobileElement) driver.findElementById("com.sof.retail:id/negativeButton");
        ok2.click();
        Thread.sleep(5000);



        System.out.println("2");
    }

    @Then("User is s Verify Able to Reach in Enter Items Page")
    public void user_is_s_Verify_Able_to_Reach_in_Enter_Items_Page() throws InterruptedException {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText"));
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.DELETE).perform();


        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText")).sendKeys("113113");
        Thread.sleep(4000);
        Actions acti = new Actions(driver);
        acti.sendKeys(Keys.ENTER).perform();
        acti.sendKeys(Keys.DELETE).perform();
        Thread.sleep(4000);

        MobileElement ok5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText");
        ok5.click();
        acti.sendKeys(Keys.ENTER).perform();

        String REQUIRE = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(REQUIRE, "REQUIRED");
        System.out.println(REQUIRE + " is visible");
        Thread.sleep(5000);

        MobileElement o = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button");
        o.click();

        String EnterItems = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(EnterItems, "Enter Items");
        System.out.println(EnterItems+ " is visible");

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }

}
