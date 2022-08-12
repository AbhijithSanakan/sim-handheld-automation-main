package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.*;

public class DRCountPage {

    static int testCase;
    static String keys = null;
    static String actualText;
    static String expectedText;
    static String transNum;
    static int sum = 0;
    static int n;
    static List count = new ArrayList<>();
    static AndroidDriver<AndroidElement> driver;
    static String recallTxt = null;

    public DRCountPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void countClick() throws InterruptedException {

        Thread.sleep(10000);
        //Swiping Down
        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(257, 392))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(257, 197)).release().perform();

        //Clicking on Count
        MobileElement count = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        count.click();
        Thread.sleep(2000);
    }

    public static void shrinkVerify() throws InterruptedException {
        testCase = 35;
        keys = "UPC 1";
        //Selecting Shrink
        MobileElement shrink = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.FrameLayout/android.widget.ImageView");
        shrink.click();
        Thread.sleep(4000);
        //Adding UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);
        //Selecting Shrink Reason
        MobileElement reasonOption = (MobileElement) driver.findElementById("com.sof.retail:id/reasonSpinner");
        reasonOption.click();
        MobileElement reasonSelect = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
        reasonSelect.click();
        MobileElement okBtn = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButtonSC");
        okBtn.click();
        //Selecting Disposal Method
        MobileElement disposalOption = (MobileElement) driver.findElementById("com.sof.retail:id/text1");
        disposalOption.click();
        MobileElement disposalSelect = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        disposalSelect.click();
        driver.findElement(By.id("com.sof.retail:id/positiveButtonSC")).click();
        Thread.sleep(2000);
        upc.clear();

        //Adding UPC2
        keys = "UPC 2";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);
        upc.clear();

        //Adding UPC3
        keys = "UPC 3";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);

        //Verifying Screen
        boolean upcChk = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).isDisplayed();
        String upcName = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).getText();
        System.out.println("Status is " + upcChk + " for UPC NAME - " + upcName);
        boolean packChk = driver.findElement(By.id("com.sof.retail:id/packTextHolder")).isDisplayed();
        String packSize = driver.findElement(By.id("com.sof.retail:id/txtPackText")).getText();
        System.out.println("Status is " + packChk + " for Pack, Pack Size - " + packSize);
        boolean sizeChk = driver.findElement(By.id("com.sof.retail:id/sizeTextHolder")).isDisplayed();
        String sizeTxt = driver.findElement(By.id("com.sof.retail:id/txtSizeText")).getText();
        System.out.println("Status is " + sizeChk + " for Size, Size - " + sizeTxt);
        boolean locChk = driver.findElement(By.id("com.sof.retail:id/locTextHolder")).isDisplayed();
        String locAvail = driver.findElement(By.id("com.sof.retail:id/txtLocText")).getText();
        System.out.println("Status is " + locChk + " for Loc, Available Loc - " + locAvail);
        boolean shelfChk = driver.findElement(By.id("com.sof.retail:id/packShelfHolder")).isDisplayed();
        String shelfName = driver.findElement(By.id("com.sof.retail:id/txtShelfText")).getText();
        System.out.println("Status is " + shelfChk + " for Shelf, Shelf is - " + shelfName);
        boolean reasonChk = driver.findElement(By.id("com.sof.retail:id/reasonText2")).isDisplayed();
        String reason = driver.findElement(By.id("com.sof.retail:id/reasonSpinner")).getText();
        System.out.println("Status is " + reasonChk + " for Reason, Shrink Reason is - " + reason);
        boolean disposalChk = driver.findElement(By.id("com.sof.retail:id/disposalText")).isDisplayed();
        String disposal = driver.findElement(By.id("com.sof.retail:id/text1")).getText();
        System.out.println("Status is " + disposalChk + " for Reason, Shrink Reason is - " + disposal);

        //Entering count value
        MobileElement count1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText");
        count1.click();
        count1.sendKeys("8");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        MobileElement count2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText");
        count2.clear();
        Thread.sleep(2000);
        count2.click();
        count2.sendKeys("11");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        try {
            boolean qtyConfirmChk = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
            String qtyConfirm = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            System.out.println("Status is " + qtyConfirmChk + " for " + qtyConfirm + " pop up");
            boolean reenterBox = driver.findElement(By.id("com.sof.retail:id/dialogEditText")).isDisplayed();
            System.out.println("Status is " + reenterBox + " for Re-enter quantity box");
            boolean okButton = driver.findElement(By.id("com.sof.retail:id/dialogCancelButton")).isDisplayed();
            boolean cancelButton = driver.findElement(By.id("com.sof.retail:id/dialogOkButton")).isDisplayed();
            if (okButton == true && cancelButton == true) {
                System.out.println("Ok & Cancel Button is visible");
            }
            driver.findElement(By.id("com.sof.retail:id/dialogEditText")).sendKeys("11");
            driver.findElement(By.id("com.sof.retail:id/dialogCancelButton")).click();
            boolean confirmPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            String confirmPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            System.out.println("Status is " + confirmPopUp + " for " + confirmPopUpTxt + " pop up");
        } catch (Exception e) {

        }
        boolean yesBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
        boolean noBtn = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
        if (yesBtn == true && noBtn == true) {
            System.out.println("Yes & No Button is visible");
        }
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        MobileElement count3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText");
        count3.clear();
        Thread.sleep(2000);
        count3.click();
        count3.sendKeys("22110");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        boolean qtyConfirmChk = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
        String qtyConfirm = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        System.out.println("Status is " + qtyConfirmChk + " for " + qtyConfirm + " pop up");
        boolean reenterBox = driver.findElement(By.id("com.sof.retail:id/dialogEditText")).isDisplayed();
        System.out.println("Status is " + reenterBox + " for Re-enter quantity box");
        boolean okButton = driver.findElement(By.id("com.sof.retail:id/dialogCancelButton")).isDisplayed();
        boolean cancelButton = driver.findElement(By.id("com.sof.retail:id/dialogOkButton")).isDisplayed();
        if (okButton == true && cancelButton == true) {
            System.out.println("Ok & Cancel Button is visible");
        }
        driver.findElement(By.id("com.sof.retail:id/dialogEditText")).sendKeys("22110");
        driver.findElement(By.id("com.sof.retail:id/dialogCancelButton")).click();
        boolean confirmPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
        String confirmPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        System.out.println("Status is " + confirmPopUp + " for " + confirmPopUpTxt + " pop up");
        boolean yesButton = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
        boolean noButton = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
        if (yesButton == true && noButton == true) {
            System.out.println("Yes & No Button is visible");
        }
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        driver.closeApp();

    }

    public static void holeCount() throws InterruptedException {
        testCase = 36;
        keys = "UPC 1";

        //Selecting Hole Count
        MobileElement holeClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView");
        holeClick.click();
        Thread.sleep(4000);

        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Holes Counted";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Navigating to next page
        MobileElement nxtBtn = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        nxtBtn.click();

        //Hole Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Hole Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Scanning an Item
        MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);
        upcScan.clear();

        //Verifying Screen after scanning an item
        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
        String itemDescName = driver.findElement(By.id("com.sof.retail:id/linkDesc")).getText();
        System.out.println("Description Status is " + itemDesc + " for UPC NAME - " + itemDescName);
        boolean pack = driver.findElement(By.id("com.sof.retail:id/packTextView")).isDisplayed();
        String packValue = driver.findElement(By.id("com.sof.retail:id/packTextValue")).getText();
        System.out.println("Status is " + pack + " for Pack, Pack Value - " + packValue);
        boolean size = driver.findElement(By.id("com.sof.retail:id/sizeTextView")).isDisplayed();
        String sizeValue = driver.findElement(By.id("com.sof.retail:id/sizeTextValue")).getText();
        System.out.println("Status is " + size + " for Size, Size Type - " + sizeValue);
        boolean loc = driver.findElement(By.id("com.sof.retail:id/locTextView")).isDisplayed();
        String locValue = driver.findElement(By.id("com.sof.retail:id/locTextValue")).getText();
        System.out.println("Status is " + loc + " for Loc, Loc - " + locValue);
        boolean min = driver.findElement(By.id("com.sof.retail:id/minTextView")).isDisplayed();
        String minValue = driver.findElement(By.id("com.sof.retail:id/minTextValue")).getText();
        System.out.println("Status is " + min + " for Min, Min Value - " + minValue);
        boolean last = driver.findElement(By.id("com.sof.retail:id/lastTextView")).isDisplayed();
        String lastValue = driver.findElement(By.id("com.sof.retail:id/lastTextValue")).getText();
        System.out.println("Status is " + last + " for Last, Last Value - " + lastValue);
        boolean sales = driver.findElement(By.id("com.sof.retail:id/salesTextView")).isDisplayed();
        String salesValue = driver.findElement(By.id("com.sof.retail:id/buttonSales")).getText();
        System.out.println("Status is " + sales + " for Sales, Sales Value - " + salesValue);
        boolean holes = driver.findElement(By.id("com.sof.retail:id/holesTextView")).isDisplayed();
        String holesValue = driver.findElement(By.id("com.sof.retail:id/holesTextValue")).getText();
        System.out.println("Status is " + holes + " for Holes, Holes Count - " + holesValue);
        boolean boh = driver.findElement(By.id("com.sof.retail:id/bohTextView")).isDisplayed();
        String bohValue = driver.findElement(By.id("com.sof.retail:id/bohTextValue")).getText();
        System.out.println("Status is " + boh + " for BOH, BOH - " + bohValue);
        boolean shelf = driver.findElement(By.id("com.sof.retail:id/shelfDescTextView")).isDisplayed();
        String shelfValue = driver.findElement(By.id("com.sof.retail:id/shelfDescValue")).getText();
        System.out.println("Status is " + shelf + " for Shelf, Shelf is " + shelfValue);
        boolean item = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        String itemDesp = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
        System.out.println("Status is " + item + " for Item Description");
        System.out.println(itemDesp + " is Visible ");

        //Swiping through item
        TouchAction action1 = new TouchAction(driver);
        action1.press(PointOption.point(322, 456))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(195, 456)).release().perform();

        boolean delBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + delBtn + " for Delete Button");

        //Checking Whether the Hole Count is 1
        try {
            if (holesValue == "1") {
                System.out.println("Hole Count is - " + holesValue);
            }

        } catch (Exception e) {
            System.out.println("Holes count is not One");
        }

        //Scanning the same item again
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);
        upcScan.clear();

        //Checking Whether the Hole Count is increased by 1
        try {
            if (holesValue == "2") {
                System.out.println("Hole Count increased by 1");
                System.out.println("Hole Count is - " + holesValue);
            }

        } catch (Exception e) {
            System.out.println("Holes count is not increased");
        }

        //Scanning More Item
        keys = "UPC 2";
        upcScan.click();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);
        upcScan.clear();

        //Checking Whether the Hole Count is 1 for the newly added item
        try {
            if (holesValue == "1") {
                System.out.println("Hole Count is - " + holesValue);
            }

        } catch (Exception e) {
            System.out.println("Holes count is not 1");
        }

        //Scanning 3rd Item
        keys = "UPC 3";
        upcScan.click();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);
        upcScan.clear();

        //Clicking on Next Button
        driver.findElement(By.id("com.sof.retail:id/button3")).click();

        //Summary
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean staticTxt = driver.findElement(By.id("com.sof.retail:id/hcSummaryReviewTxt")).isDisplayed();
        System.out.println("Screen is " + staticTxt + " for Static Text");
        String time = driver.findElement(By.id("com.sof.retail:id/bolText")).getText();
        String timeRemain = driver.findElement(By.id("com.sof.retail:id/bolValueText")).getText();
        Assert.assertEquals(time, "Time Remaining");
        System.out.println(time + " is visible, Time Remaining - " + timeRemain);
        String holesTxt = driver.findElement(By.id("com.sof.retail:id/outgoingText")).getText();
        String holesCounted = driver.findElement(By.id("com.sof.retail:id/outgoingValueText")).getText();
        Assert.assertEquals(holesTxt, "Holes Counted");
        System.out.println(holesTxt + " is visible, Holes Counted - " + holesCounted);

    }

    public static void HoleCountScreenVerify() throws InterruptedException {
        testCase = 66;
        keys = "UPC 1";

        //Selecting Hole Count
        MobileElement holeClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView");
        holeClick.click();
        Thread.sleep(4000);

        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Holes Counted";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Navigating to next page
        MobileElement nxtBtn = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        nxtBtn.click();

        //Hole Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Hole Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Verifying Hole Count Screen
        //Upc Field
        boolean upcFieldChck = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isDisplayed();
        System.out.println("Status is " + upcFieldChck + " for UPC Field");
        //Label Printing
        boolean labelPrintingChck = driver.findElement(By.id("com.sof.retail:id/imageButton")).isDisplayed();
        System.out.println("Status is " + labelPrintingChck + " for Label Printing Icon");
        //Pack
        boolean pack = driver.findElement(By.id("com.sof.retail:id/packTextView")).isDisplayed();
        System.out.println("Status is " + pack + " for Pack");
        //Size
        boolean size = driver.findElement(By.id("com.sof.retail:id/sizeTextView")).isDisplayed();
        System.out.println("Status is " + size + " for Size");
        //Loc
        boolean loc = driver.findElement(By.id("com.sof.retail:id/locTextView")).isDisplayed();
        System.out.println("Status is " + loc + " for Loc");
        //Min
        boolean min = driver.findElement(By.id("com.sof.retail:id/minTextView")).isDisplayed();
        System.out.println("Status is " + min + " for Min");
        //Last
        boolean last = driver.findElement(By.id("com.sof.retail:id/lastTextView")).isDisplayed();
        System.out.println("Status is " + last + " for Last");
        //Sales
        boolean sales = driver.findElement(By.id("com.sof.retail:id/salesTextView")).isDisplayed();
        System.out.println("Status is " + sales + " for Sales");
        //Holes
        boolean holes = driver.findElement(By.id("com.sof.retail:id/holesTextView")).isDisplayed();
        System.out.println("Status is " + holes + " for Holes");
        //BOH
        boolean boh = driver.findElement(By.id("com.sof.retail:id/bohTextView")).isDisplayed();
        System.out.println("Status is " + boh + " for BOH");
        //? Icon
        boolean qstIcon = driver.findElement(By.id("com.sof.retail:id/descImage")).isDisplayed();
        System.out.println("Status is " + qstIcon + " for ? Icon");
        //Description & Description Grid
        boolean desc = driver.findElement(By.id("com.sof.retail:id/descriptionText")).isDisplayed();
        boolean descGrid = driver.findElement(By.id("com.sof.retail:id/recyclerViewCountScanItems")).isDisplayed();
        if (desc == true && descGrid == true) {
            System.out.println("Description & Description Grid is Visible");
        }
        //Item Count Label
        boolean itemCountLabel = driver.findElement(By.id("com.sof.retail:id/hcItemsCount")).isDisplayed();
        String itemCountLabelValue = driver.findElement(By.id("com.sof.retail:id/hcItemsCount")).getText();
        System.out.println("Status is " + itemCountLabel + " for Item Count Label, " + itemCountLabelValue + " is visible");

        //Next Button
        boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + nextBtn + " for Next Button");
        //Back Button
        boolean backBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + backBtn + " for Back Button");
        //Pagination
        String crntPage = driver.findElement(By.id("com.sof.retail:id/tvCurrentCount")).getText();
        String slashTxt = driver.findElement(By.id("com.sof.retail:id/slashText")).getText();
        String totalPage = driver.findElement(By.id("com.sof.retail:id/tvTotalCount")).getText();
        System.out.println("Page - " + crntPage + slashTxt + totalPage);
        //Discard Button
        boolean discardBtn = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
        System.out.println("Status is " + discardBtn + " for Discard Button");
        //Virtual Keyboard
        boolean virtKeyboard = driver.findElement(By.id("com.sof.retail:id/buttonKeyBoard")).isDisplayed();
        System.out.println("Status is " + virtKeyboard + " for Virtual Keyboard");

        //Scanning an Item
        MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);
        upcScan.clear();

        //Verifying Screen after scanning an item
        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
        String itemDescName = driver.findElement(By.id("com.sof.retail:id/linkDesc")).getText();
        System.out.println("Description Status is " + itemDesc + " for UPC NAME - " + itemDescName);
        //Pack
        boolean packChck = driver.findElement(By.id("com.sof.retail:id/packTextView")).isDisplayed();
        String packValue = driver.findElement(By.id("com.sof.retail:id/packTextValue")).getText();
        System.out.println("Status is " + packChck + " for Pack, Pack Value - " + packValue);
        //Size
        boolean sizeChck = driver.findElement(By.id("com.sof.retail:id/sizeTextView")).isDisplayed();
        String sizeValue = driver.findElement(By.id("com.sof.retail:id/sizeTextValue")).getText();
        System.out.println("Status is " + sizeChck + " for Size, Size Type - " + sizeValue);
        //Loc
        boolean locChck = driver.findElement(By.id("com.sof.retail:id/locTextView")).isDisplayed();
        String locValue = driver.findElement(By.id("com.sof.retail:id/locTextValue")).getText();
        System.out.println("Status is " + locChck + " for Loc, Loc - " + locValue);
        //Min
        boolean minChck = driver.findElement(By.id("com.sof.retail:id/minTextView")).isDisplayed();
        String minValue = driver.findElement(By.id("com.sof.retail:id/minTextValue")).getText();
        System.out.println("Status is " + minChck + " for Min, Min Value - " + minValue);
        //Last
        boolean lastChck = driver.findElement(By.id("com.sof.retail:id/lastTextView")).isDisplayed();
        String lastValue = driver.findElement(By.id("com.sof.retail:id/lastTextValue")).getText();
        System.out.println("Status is " + lastChck + " for Last, Last Value - " + lastValue);
        //Sales
        boolean salesChck = driver.findElement(By.id("com.sof.retail:id/salesTextView")).isDisplayed();
        String salesValue = driver.findElement(By.id("com.sof.retail:id/buttonSales")).getText();
        System.out.println("Status is " + salesChck + " for Sales, Sales Value - " + salesValue);
        //Holes
        boolean holesChck = driver.findElement(By.id("com.sof.retail:id/holesTextView")).isDisplayed();
        String holesValue = driver.findElement(By.id("com.sof.retail:id/holesTextValue")).getText();
        System.out.println("Status is " + holesChck + " for Holes, Holes Count - " + holesValue);
        //BOH
        boolean bohChck = driver.findElement(By.id("com.sof.retail:id/bohTextView")).isDisplayed();
        String bohValue = driver.findElement(By.id("com.sof.retail:id/bohTextValue")).getText();
        System.out.println("Status is " + bohChck + " for BOH,. BOH - " + bohValue);
        //Shelf
        boolean shelf = driver.findElement(By.id("com.sof.retail:id/shelfDescTextView")).isDisplayed();
        String shelfValue = driver.findElement(By.id("com.sof.retail:id/shelfDescValue")).getText();
        System.out.println("Status is " + shelf + " for Shelf, Shelf is " + shelfValue);
        //Item Description
        boolean item = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        String itemDesp = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
        System.out.println("Status is " + item + " for Item Description");
        System.out.println(itemDesp + " is Visible ");

        //Swiping through item
        TouchAction action1 = new TouchAction(driver);
        action1.press(PointOption.point(361, 460))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(223, 460)).release().perform();

        boolean delBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + delBtn + " for Delete Button");

        //Checking Whether Holes Value is 1
        if (holesValue.equalsIgnoreCase("1")) {
            System.out.println("Holes Count is 1");
        } else {
            System.out.println("Holes Count is not 1");
        }

        //Clicking on Hyperlink
        driver.findElement(By.id("com.sof.retail:id/linkDesc")).click();
        try {
            //Item Info
            String itemInfo = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            System.out.println(itemInfo + " is Visible");
            //Upc
            String itemUpc = driver.findElement(By.id("com.sof.retail:id/offerPriceTextView")).getText();
            String itemUpcValue = driver.findElement(By.id("com.sof.retail:id/offerPriceVal")).getText();
            System.out.println(itemUpc + "-" + itemUpcValue);
            //Department
            String itemDept = driver.findElement(By.id("com.sof.retail:id/regularPriceTextView")).getText();
            String itemDeptValue = driver.findElement(By.id("com.sof.retail:id/regularPriceVal")).getText();
            System.out.println(itemDept + "-" + itemDeptValue);
            //Pack
            String itemPack = driver.findElement(By.id("com.sof.retail:id/pointsTextView")).getText();
            String itemPackValue = driver.findElement(By.id("com.sof.retail:id/pointsVal")).getText();
            System.out.println(itemPack + "-" + itemPackValue);
            //Size
            String itemSize = driver.findElement(By.id("com.sof.retail:id/startTextView")).getText();
            String itemSizeValue = driver.findElement(By.id("com.sof.retail:id/startVal")).getText();
            System.out.println(itemSize + "-" + itemSizeValue);
            //Category
            String itemCat = driver.findElement(By.id("com.sof.retail:id/endTextView")).getText();
            String itemCatValue = driver.findElement(By.id("com.sof.retail:id/endVal")).getText();
            System.out.println(itemCat + "-" + itemCatValue);
            //Holes
            String itemHoles = driver.findElement(By.id("com.sof.retail:id/holesTxt")).getText();
            String itemHolesValue = driver.findElement(By.id("com.sof.retail:id/holesTxtVal")).getText();
            System.out.println(itemHoles + "-" + itemHolesValue);
            //Previous Holes
            String itemPreCount = driver.findElement(By.id("com.sof.retail:id/previouslyCountedTxt")).getText();
            String itemPreCountValue = driver.findElement(By.id("com.sof.retail:id/previouslyCountedTxtVal")).getText();
            System.out.println(itemPreCount + "-" + itemPreCountValue);
            //Total Counted
            String itemTotCount = driver.findElement(By.id("com.sof.retail:id/totalCountedAmountTxt")).getText();
            String itemTotCountValue = driver.findElement(By.id("com.sof.retail:id/totalCountedAmountTxtVal")).getText();
            System.out.println(itemTotCount + "-" + itemTotCountValue);

            //Clicking ok
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();
        } catch (Exception e) {
            System.out.println("Item Info is not visible");
        }

        //Clicking Label Printing
        driver.findElement(By.id("com.sof.retail:id/imageButton")).click();
        //Label Request
        String labelReq = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        String labelText = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
        String labelItem = driver.findElement(By.id("com.sof.retail:id/dialog_message_one")).getText();
        System.out.println(labelReq + " Text Box Is Displayed");
        System.out.println(labelText + " " + labelItem);

        boolean warnChkBox = driver.findElement(By.id("com.sof.retail:id/cbDontWarn")).isDisplayed();
        String warnChkBoxTxt = driver.findElement(By.id("com.sof.retail:id/cbDontWarn")).getText();
        if (warnChkBox == true) {
            System.out.println(warnChkBoxTxt + " - Checkbox is visible");
        }
        boolean okBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
        System.out.println("Status is " + okBtn + " for Ok Button");
        Thread.sleep(2000);
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        //Clicking Label Printing Again
        driver.findElement(By.id("com.sof.retail:id/imageButton")).click();
        String labelCancelReq = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        String labelCancelText = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
        String labelCancelItem = driver.findElement(By.id("com.sof.retail:id/dialog_message_one")).getText();
        System.out.println(labelCancelReq + " Text Box Is Displayed");
        System.out.println(labelCancelText + " " + labelCancelItem);

        boolean warnCancelChkBox = driver.findElement(By.id("com.sof.retail:id/cbDontWarn")).isDisplayed();
        String warnCancelChkBoxTxt = driver.findElement(By.id("com.sof.retail:id/cbDontWarn")).getText();
        if (warnCancelChkBox == true) {
            System.out.println(warnCancelChkBoxTxt + " - Checkbox is visible");
        }
        boolean okCancelBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
        System.out.println("Status is " + okCancelBtn + " for Ok Button");
        Thread.sleep(2000);
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        //Checking whether Min Field is clickable
        boolean minFieldClick = driver.findElement(By.id("com.sof.retail:id/minTextValue")).getAttribute("clickable").equals("true");
        if (minFieldClick == true) {
            System.out.println("Min Field is clickable");
        } else {
            System.out.println("Min Field is Read Only");
        }

        //Clicking on Location Value
        driver.findElement(By.id("com.sof.retail:id/locTextValue")).click();
        //Checking for Location PopUp
        try {
            driver.findElement(By.id("com.sof.retail:id/txtLocTextValue")).click();
            String locText = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            String availLoc = driver.findElement(By.id("com.sof.retail:id/spinnerTextView")).getText();
            boolean locCheck = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
            System.out.println("Status is " + locCheck + " for " + locText);
            System.out.println("Available Location - " + availLoc);
            //Clicking Ok Button
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();

        } catch (Exception e) {
            String errorMsg = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String errorMsgTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(errorMsg + " " + errorMsgTxt);
            //Clicking Ok Button
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        }

        //Clicking on Sales Value
        driver.findElement(By.id("com.sof.retail:id/buttonSales")).click();
        Thread.sleep(2000);
        try {
            //Verifying Sales PopUp
            String salesPopUp = driver.findElement(By.id("com.sof.retail:id/textTitle")).getText();
            System.out.println(salesPopUp + " is Displayed");
            //Clicking Ok Button
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();
        } catch (Exception e) {
            System.out.println("No PopUp is Displayed");
        }

        //Clicking on Last
        driver.findElement(By.id("com.sof.retail:id/lastTextValue")).click();
        Thread.sleep(2000);
        try {
            String lastTapData = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String lastTapItemName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")).getText();
            System.out.println(lastTapData + " for - " + lastTapItemName + " is Displayed");
            //Clicking Ok Button
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        } catch (Exception e) {
            String lastTapData = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String lastTapDataValue = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(lastTapData + " is Displayed");
            System.out.println(lastTapDataValue);
            //Clicking Ok Button
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        }

        //Clicking on ? Icon
        driver.findElement(By.id("com.sof.retail:id/descImage")).click();
        //Checking Whether Legend is displayed
        actualText = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        expectedText = "LEGEND";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);
        //Clicking Ok
        driver.findElement(By.id("com.sof.retail:id/okButton")).click();

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();

        //Verifying Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText, expectedText);

        //Clicking Back
        driver.findElement(By.id("com.sof.retail:id/button")).click();

        //Verifying Hole Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Hole Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

//        //Clicking Virtual Keyboard Icon
//        driver.findElement(By.id("com.sof.retail:id/buttonKeyBoard")).click();
//        //Clicking Virtual Keyboard Again
//        driver.findElement(By.id("com.sof.retail:id/buttonKeyBoard")).click();

        //Swiping through item
        action1.press(PointOption.point(361, 460))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(223, 460)).release().perform();

        boolean delIcon = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + delIcon + " for Delete Button");
        //Clicking Delete
        driver.findElement(By.id("com.sof.retail:id/itemDelete")).click();

        //Checking Whether Item Deleted
        try {
            boolean itemDescCheck = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
            if (itemDescCheck == true) {
                System.out.println("Item is visible");
            }
        } catch (Exception e) {
            System.out.println("Item got deleted");
        }

    }

    public static void HoleCountBadge() throws InterruptedException {

        //Set<List> countName = new HashSet<>();
        ArrayList<String> countName = new ArrayList<String>();

        //Selecting Hole Count
        MobileElement holeClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView");
        holeClick.click();
        Thread.sleep(4000);

        try {
            for (n = 1; n < 3; n++) {
                //List<AndroidElement> countNameValue = Collections.singletonList(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.sof.retail:id/tvHoleDeptName']")));
                List<AndroidElement> countNameValue = driver.findElements(MobileBy.id("//android.widget.TextView[@resource-id='com.sof.retail:id/tvHoleDeptName']"));
                countName.add(countNameValue.get(n).getText());
                //countName.add(countNameValue);
                System.out.println(countName.size());
                System.out.println(countName);

                try {
                    //Swiping Down
                    TouchAction action = new TouchAction(driver);

                    action.press(PointOption.point(360, 316))
                            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                            .moveTo(PointOption.point(360, 269)).release().perform();
                } catch (Exception e) {

                }

            }
        } catch (Exception e) {
            System.out.println("Scanned");
        }

        System.out.println("Total " + countName.size() + " is listed");

    }

    public static void InventoryCountPrinter() throws InterruptedException {
        testCase = 46;
        keys = "UPC 1";

        //Selecting Inventory Count
        MobileElement invCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView");
        invCountClick.click();
        Thread.sleep(10000);

        try {
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Inventory Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            try {
                boolean frontBtn = driver.findElement(By.id("com.sof.retail:id/btnFront")).isDisplayed();
                if (frontBtn == true) {
                    System.out.println("Counts are waiting");
                }

                //Checking whether department is displayed
                try {
                    boolean deptDisplayed = driver.findElement(By.id("com.sof.retail:id/tvInventoryItemName")).isDisplayed();
                    System.out.println("Status is " + deptDisplayed + " for departments");
                } catch (Exception e) {
                    System.out.println("Departments not visible");
                }
                //Checking whether Front Button is displayed
                try {
                    boolean frontBtnChck = driver.findElement(By.id("com.sof.retail:id/btnFront")).isDisplayed();
                    System.out.println("Status is " + frontBtnChck + " for Front Stock Button");
                } catch (Exception e) {
                    System.out.println("Front Button not visible");
                }
                //Checking whether Back Button is displayed
                try {
                    boolean backBtn = driver.findElement(By.id("com.sof.retail:id/btnBack")).isDisplayed();
                    System.out.println("Status is " + backBtn + " for Back Stock Button");
                } catch (Exception e) {
                    System.out.println("Back Button not visible");
                }
                //Checking whether Finalize Button is displayed
                try {
                    boolean finBtn = driver.findElement(By.id("com.sof.retail:id/btnFinalize")).isDisplayed();
                    System.out.println("Status is " + finBtn + " for Finalize Button");
                } catch (Exception e) {
                    System.out.println("Finalize Button not visible");
                }
                //Checking whether Approve Button is displayed
                try {
                    boolean approveBtn = driver.findElement(By.id("com.sof.retail:id/btnApprove")).isDisplayed();
                    System.out.println("Status is " + approveBtn + " for Approve Button");
                } catch (Exception e) {
                    System.out.println("Approve Button not visible");
                }
                //Checking whether UnApprove Button is displayed
                try {
                    boolean unApproveBtn = driver.findElement(By.id("com.sof.retail:id/btnUnapprove")).isDisplayed();
                    System.out.println("Status is " + unApproveBtn + " for Unapprove Button");
                } catch (Exception e) {
                    System.out.println("Unapprove Button not visible");
                }
                //Checking whether Reopen Button is displayed
                try {
                    boolean reOpenBtn = driver.findElement(By.id("com.sof.retail:id/btnReopen")).isDisplayed();
                    System.out.println("Status is " + reOpenBtn + " for Reopen Button");
                } catch (Exception e) {
                    System.out.println("Reopen Button not visible");
                }
                //Clicking front of department
                MobileElement frontClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/btnFront"));
                frontClick.click();
                Thread.sleep(8000);

                //Verifying current page
                actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                expectedText = "Scan Items";
                TestAsserts.assertCheck(actualText, expectedText);
                Thread.sleep(2000);

                boolean upcField = driver.findElement(By.id("com.sof.retail:id/upcScanTextInvCount")).isDisplayed();
                System.out.println("Status is " + upcField + " for UPC Field");
                boolean locCheck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed();
                String locValue = driver.findElement(By.id("com.sof.retail:id/tvLocation")).getText();
                System.out.println("Status is " + locCheck + " for Location, Location - " + locValue);
                boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();

                //Adding UPC
                MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
                upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                Actions action = new Actions(driver);
                action.sendKeys(Keys.ENTER).perform();
                Thread.sleep(14000);
                upc.clear();

                //Checking product details of scanned item
                boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
                System.out.println("Status is " + itemDesc + " for Item Description");
                boolean itemCount = driver.findElement(By.id("com.sof.retail:id/invValue")).isDisplayed();
                System.out.println("Status is " + itemCount + " for Total Count Box");
                boolean itemDescBox = driver.findElement(By.id("com.sof.retail:id/rvItems")).isDisplayed();
                System.out.println("Status is " + itemDescBox + " for item description column");
                System.out.println("Status is " + nextBtn + " for Next Button");

                //Clicking on label printing
                driver.findElement(By.id("com.sof.retail:id/imageButtonInv")).click();
                //Label Request
                String labelReq = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                String labelText = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                String labelItem = driver.findElement(By.id("com.sof.retail:id/dialog_message_one")).getText();
                System.out.println(labelReq + " Text Box Is Displayed");
                System.out.println(labelText + " " + labelItem);

                boolean warnChkBox = driver.findElement(By.id("com.sof.retail:id/cbDontWarn")).isDisplayed();
                String warnChkBoxTxt = driver.findElement(By.id("com.sof.retail:id/cbDontWarn")).getText();
                if (warnChkBox == true) {
                    System.out.println(warnChkBoxTxt + " - Checkbox is visible");
                }
                boolean okBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " + okBtn + " for Ok Button");
                Thread.sleep(2000);

                //Clicking Ok Button
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                Thread.sleep(3000);

                //Verifying whether returned back to Scan Items page
                actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                expectedText = "Scan Items";
                TestAsserts.assertCheck(actualText, expectedText);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Inventory Count is empty");
            }

        }
        catch (Exception e) {
            try {
                //Checking for Error Message
                boolean retCountErrorChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
                String retCountErrorTxt = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                if (retCountErrorChck == true) {
                    System.out.println(retCountErrorTxt + " error is displayed");
                }
            }
            catch (Exception ex) {
                System.out.println("Failed to load Inventory Data");
                System.out.println(ex);
            }
        }

        //Closing app
        driver.closeApp();
        driver.quit();
    }

    public static void CycleCountNotStarted() throws InterruptedException {
        testCase = 49;
        keys = "Order Count";

        //Selecting Cycle Count
        MobileElement cycleCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        cycleCountClick.click();

        //Checking Cycle Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Cycle Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        try {
            boolean cycleCountList = driver.findElement(By.id("com.sof.retail:id/textCycleCountName")).isDisplayed();
            if (cycleCountList == true) {
                System.out.println("Cycle Count waiting to start visible");
            }

            //Clicking on STart Button
            MobileElement startClick = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Button"));
            startClick.click();
            Thread.sleep(8000);

            //Checking Scan Item Screen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Cycle Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            //Verifying Printer Icon
            boolean printerChck = driver.findElement(By.id("com.sof.retail:id/ccImagePrint")).isDisplayed();
            System.out.println("Status is " + printerChck + " for Printer Icon");

            //Hyperlink
            boolean hyperlinkChck = driver.findElement(By.id("com.sof.retail:id/textCCItemDescription")).isDisplayed();
            String hyperlinlValue = driver.findElement(By.id("com.sof.retail:id/textCCItemDescription")).getText();
            System.out.println("Status is " + hyperlinkChck + " for Hyperlink description of - " + hyperlinlValue);

            //Shelf
            boolean shelfChck = driver.findElement(By.id("com.sof.retail:id/textCCShelfHolder")).isDisplayed();
            String shelfValue = driver.findElement(By.id("com.sof.retail:id/textCCShelf")).getText();
            System.out.println("Status is " + shelfChck + " for Shelf, Shelf - " + hyperlinlValue);

            //UOM Dropdown
            String uom = driver.findElement(By.id("com.sof.retail:id/uomCCText")).getText();
            boolean uomDropdown = driver.findElement(By.id("com.sof.retail:id/ccUomSpinner")).isDisplayed();
            System.out.println(uom + " dropdown status is " + uomDropdown);

            //Labels & their values
            boolean packChk = driver.findElement(By.id("com.sof.retail:id/packTextHolder")).isDisplayed();
            String packValue = driver.findElement(By.id("com.sof.retail:id/txtPackTextValue")).getText();
            System.out.println("Status is " + packChk + " for Pack, Pack Size - " + packValue);

            //Size
            boolean sizeChk = driver.findElement(By.id("com.sof.retail:id/sizeTextHolder")).isDisplayed();
            String sizeValue = driver.findElement(By.id("com.sof.retail:id/txtSizeTextValue")).getText();
            System.out.println("Status is " + sizeChk + " for Size, Size - " + sizeValue);

            //Loc
            boolean locChk = driver.findElement(By.id("com.sof.retail:id/locationTextHolder")).isDisplayed();
            String locValue = driver.findElement(By.id("com.sof.retail:id/txtLocTextValue")).getText();
            System.out.println("Status is " + locChk + " for Locations, Available Locations - " + locValue);

            //Min
            boolean minChk = driver.findElement(By.id("com.sof.retail:id/minRecTextHolder")).isDisplayed();
            String minValue = driver.findElement(By.id("com.sof.retail:id/txtCGOMinRecTextValue")).getText();
            System.out.println("Status is " + minChk + " for Min, Minimum - " + minValue);

            //Last
            boolean lastChk = driver.findElement(By.id("com.sof.retail:id/lastWeekTextHolder")).isDisplayed();
            String lastValue = driver.findElement(By.id("com.sof.retail:id/txtLastTextValue")).getText();
            System.out.println("Status is " + lastChk + " for last, Last Received - " + lastValue);

            //Sales
            boolean salesChk = driver.findElement(By.id("com.sof.retail:id/salesHistoryTextHolder")).isDisplayed();
            String salesValue = driver.findElement(By.id("com.sof.retail:id/buttonSalesText")).getText();
            System.out.println("Status is " + salesChk + " for Sales, Sales History - " + salesValue);

            //Entering count value
            String totalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
            MobileElement count = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]");
            count.click();
            count.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);

            //Checking Whether value got added to total
            String totalCurrentValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
            if (totalValue == totalCurrentValue) {
                System.out.println("Total Value not updated");
            } else {
                System.out.println("Count got added to total");
                System.out.println("Previous Value - " + totalValue + ", Current Value - " + totalCurrentValue);
            }

            //Clicking on Next
            driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

            //Summary Page
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Summary";
            TestAsserts.assertCheck(actualText, expectedText);

            //Static text & Supplier Name
            try {
                String staticTxt = driver.findElement(By.id("com.sof.retail:id/textCountName")).getText();
                System.out.println(staticTxt + " is visible");
            } catch (Exception e) {
                System.out.println("Static Text Not Visible");
            }

            //Time Remaining
            boolean timeRemChck = driver.findElement(By.id("com.sof.retail:id/textDownTimerHolder")).isDisplayed();
            String timeRem = driver.findElement(By.id("com.sof.retail:id/textDownTimerHolder")).getText();
            String timeRemValue = driver.findElement(By.id("com.sof.retail:id/textDownTimer")).getText();
            System.out.println("Status is " + timeRemChck + " for " + timeRem + ", Time Remaining - " + timeRemValue);

            //Items Counted
            boolean itemsCountChck = driver.findElement(By.id("com.sof.retail:id/textItemCountedHolder")).isDisplayed();
            String itemsCount = driver.findElement(By.id("com.sof.retail:id/textItemCountedHolder")).getText();
            String itemsCountValue = driver.findElement(By.id("com.sof.retail:id/textItemCounted")).getText();
            System.out.println("Status is " + itemsCountChck + " for " + itemsCount + ", Items Counted - " + itemsCountValue);

            //Clicking on Ellipsis
            driver.findElement(By.id("com.sof.retail:id/cycleCountImage")).click();

            //Back to Scan Item Screen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Cycle Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            //Checking whether pre populated data is loaded
            try {
                String itemLoaded = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText();
                String itemTotalCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
                System.out.println(itemLoaded + " is pre loaded with total count - " + itemTotalCount);
            } catch (Exception e) {
                System.out.println("No item is pre loaded");
            }

            //Clicking on next
            driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

            //Clicking on Send
            driver.findElement(By.id("com.sof.retail:id/button3")).click();

            //QA Warning
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

            //Finalize Cycle Count
            String finTxt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
            String sendFinTxt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).getText();
            String sendTxt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]")).getText();
            String cancelTxt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[3]")).getText();
            System.out.println(finTxt + " is visible with, ");
            System.out.println(sendFinTxt + ", " + sendTxt + " & " + cancelTxt + " options");

            //Clicking on send
            driver.findElement(By.id("com.sof.retail:id/sendAndFinalizeButton")).click();
            Thread.sleep(8000);

            //Transaction Page
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Transaction";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(3000);

            //Cycle count & transaction
            boolean cycleCount = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
            boolean transConfirm = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();

            if (cycleCount == true && transConfirm == true) {
                System.out.println("Cycle count & its count result is shown");
            } else {
                System.out.println("Cycle count & its count result not available");
            }

            //Time Stamp & Username
            boolean dateTimeChck = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
            String dateTimeValue = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
            boolean nameChck = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
            String nameValue = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).getText();

            if (dateTimeChck == true && nameChck == true) {
                System.out.println("Sent Date & Time Stamp, Sent by Username is shown");
                System.out.println("Date & Time - " + dateTimeValue + ", Sent " + nameValue);
            }

            //Writing Transaction Number to Excel
            transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            keys = "Transaction Number";
            ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
            driver.findElement(By.id("com.sof.retail:id/button")).click();
            Thread.sleep(2000);

            //Clicking on Ok Button
            driver.findElement(By.id("com.sof.retail:id/button")).click();
            Thread.sleep(2000);

            //Next Count Popup
            String nxtCount = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String nxtCountValue = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(nxtCount + " Pop up is visible with text - " + nxtCountValue);

            //Clicking on No
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
            Thread.sleep(4000);

            //Back to Cycle Count Page
            //Transaction Page
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Cycle Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(3000);


        } catch (Exception e) {
            System.out.println("Cycle Count waiting to start is not visible");
        }
    }

    public static void cycleCountFinalizedCheckbox() throws InterruptedException {
        testCase = 50;

        //Selecting Cycle Count
        MobileElement cycleCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        cycleCountClick.click();

        //Checking Cycle Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Cycle Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        try {
            boolean cycleCountList = driver.findElement(By.id("com.sof.retail:id/textCycleCountName")).isDisplayed();
            if (cycleCountList == true) {
                System.out.println("Cycle Count waiting to start visible");
            }
        } catch (Exception e) {
            System.out.println("Cycle Count waiting to start is not visible");
        }

        //Clicking Finalized Count Checkbox
        driver.findElement(By.id("com.sof.retail:id/checkboxFinalised")).click();
        Thread.sleep(3000);

        //Verifying finalized counts
        try {
            boolean cycleCountList = driver.findElement(By.id("com.sof.retail:id/textCycleCountName")).isDisplayed();
            if (cycleCountList == true) {
                System.out.println("Finalized Counts visible");
            }
        } catch (Exception e) {
            System.out.println("Finalized Count is not visible");
        }

        //Checking whether finalized count is clickable
        boolean finCountClick = driver.findElement(By.id("com.sof.retail:id/textCycleCountName")).getAttribute("clickable").equals("true");
        if (finCountClick == true) {
            System.out.println("Finalized Count is clickable");
        } else {
            System.out.println("Finalized Count is not clickable");
        }
    }

    public static void cycleCountScanItemScreen() throws InterruptedException {
        testCase = 130;
        keys = "UPC 1";

        //Selecting Cycle Count
        MobileElement cycleCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        cycleCountClick.click();

        //Checking Cycle Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Cycle Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        try {
            boolean cycleCountList = driver.findElement(By.id("com.sof.retail:id/textCycleCountName")).isDisplayed();
            if (cycleCountList == true) {
                System.out.println("Cycle Count waiting to start visible");
            }
        } catch (Exception e) {
            System.out.println("Cycle Count waiting to start is not visible");
        }

        //Clicking on Start Button
        try {
            MobileElement startClick = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Button"));
            startClick.click();
            Thread.sleep(8000);

            //Checking Scan Item Screen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Cycle Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            try {
                //Checking whether any preloaded item is visible
                boolean itemLoaded = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).isDisplayed();
                if (itemLoaded == true) {
                    System.out.println("Preloaded Items exist");
                } else {
                    System.out.println("No Preloaded Items");
                }
            } catch (Exception e) {
                System.out.println("No Preloaded Items");
            }

            //Adding UPC to the preloaded list
            MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
            upc.click();
            upc.clear();
            upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(14000);

            //Free count add popup
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(18000);

            //Checking whether Item got populated
            boolean itemCheck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")).isDisplayed();
            String itemName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")).getText();
            System.out.println("Status is " + itemCheck + " for added item - " + itemName);

            //Verifying Printer Icon
            boolean printerChck = driver.findElement(By.id("com.sof.retail:id/ccImagePrint")).isDisplayed();
            System.out.println("Status is " + printerChck + " for Printer Icon");

            //Hyperlink
            boolean hyperlinkChck = driver.findElement(By.id("com.sof.retail:id/textCCItemDescription")).isDisplayed();
            String hyperlinlValue = driver.findElement(By.id("com.sof.retail:id/textCCItemDescription")).getText();
            System.out.println("Status is " + hyperlinkChck + " for Hyperlink description of - " + hyperlinlValue);

            //Shelf
            boolean shelfChck = driver.findElement(By.id("com.sof.retail:id/textCCShelfHolder")).isDisplayed();
            String shelfValue = driver.findElement(By.id("com.sof.retail:id/textCCShelf")).getText();
            System.out.println("Status is " + shelfChck + " for Shelf, Shelf - " + hyperlinlValue);

            //UOM Dropdown
            String uom = driver.findElement(By.id("com.sof.retail:id/uomCCText")).getText();
            boolean uomDropdown = driver.findElement(By.id("com.sof.retail:id/ccUomSpinner")).isDisplayed();
            System.out.println(uom + " dropdown status is " + uomDropdown);

            //Labels & their values
            boolean packChk = driver.findElement(By.id("com.sof.retail:id/packTextHolder")).isDisplayed();
            String packValue = driver.findElement(By.id("com.sof.retail:id/txtPackTextValue")).getText();
            System.out.println("Status is " + packChk + " for Pack, Pack Size - " + packValue);

            //Size
            boolean sizeChk = driver.findElement(By.id("com.sof.retail:id/sizeTextHolder")).isDisplayed();
            String sizeValue = driver.findElement(By.id("com.sof.retail:id/txtSizeTextValue")).getText();
            System.out.println("Status is " + sizeChk + " for Size, Size - " + sizeValue);

            //Loc
            boolean locChk = driver.findElement(By.id("com.sof.retail:id/locationTextHolder")).isDisplayed();
            String locValue = driver.findElement(By.id("com.sof.retail:id/txtLocTextValue")).getText();
            System.out.println("Status is " + locChk + " for Locations, Available Locations - " + locValue);

            //Min
            boolean minChk = driver.findElement(By.id("com.sof.retail:id/minRecTextHolder")).isDisplayed();
            String minValue = driver.findElement(By.id("com.sof.retail:id/txtCGOMinRecTextValue")).getText();
            System.out.println("Status is " + minChk + " for Min, Minimum - " + minValue);

            //Last
            boolean lastChk = driver.findElement(By.id("com.sof.retail:id/lastWeekTextHolder")).isDisplayed();
            String lastValue = driver.findElement(By.id("com.sof.retail:id/txtLastTextValue")).getText();
            System.out.println("Status is " + lastChk + " for last, Last Received - " + lastValue);

            //Sales
            boolean salesChk = driver.findElement(By.id("com.sof.retail:id/salesHistoryTextHolder")).isDisplayed();
            String salesValue = driver.findElement(By.id("com.sof.retail:id/buttonSalesText")).getText();
            System.out.println("Status is " + salesChk + " for Sales, Sales History - " + salesValue);

            //Clicking printer icon
            driver.findElement(By.id("com.sof.retail:id/ccImagePrint")).click();

            //Label Request
            String labelReq = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String labelText = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            String labelItem = driver.findElement(By.id("com.sof.retail:id/dialog_message_one")).getText();
            System.out.println(labelReq + " Text Box Is Displayed");
            System.out.println(labelText + " " + labelItem);

            //Clicking Ok Button //Going back to scan item screen
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(2000);

            //Checking Scan Item Screen again
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Cycle Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            //Cancelling the label request
            driver.findElement(By.id("com.sof.retail:id/ccImagePrint")).click();

            //Label Request
            String cancelLabelReq = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String cancelLabelText = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            String cancelLabelItem = driver.findElement(By.id("com.sof.retail:id/dialog_message_one")).getText();
            System.out.println(cancelLabelReq + " Text Box Is Displayed");
            System.out.println(cancelLabelText + " " + cancelLabelItem);

            //Clicking Ok Button //Going back to scan item screen
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(2000);

            //Clicking on item hyperlink
            driver.findElement(By.id("com.sof.retail:id/textCCItemDescription")).click();

            //Verifying Item Description
            String itemInfoText = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String itemNameText = driver.findElement(By.id("com.sof.retail:id/dialog_msg")).getText();
            String itemUpcText = driver.findElement(By.id("com.sof.retail:id/textOfferPrice")).getText();
            String itemDeptText = driver.findElement(By.id("com.sof.retail:id/textRegularPrice")).getText();
            String itemPackText = driver.findElement(By.id("com.sof.retail:id/textInfoPoints")).getText();
            String itemSizeText = driver.findElement(By.id("com.sof.retail:id/textInfoStart")).getText();
            String itemCategoryText = driver.findElement(By.id("com.sof.retail:id/textInfoEnd")).getText();

            //Printing Item Details
            System.out.println("------------");
            System.out.println(itemInfoText);
            System.out.println("Item Name - " + itemNameText);
            System.out.println("UPC - " + itemUpcText);
            System.out.println("Department - " + itemDeptText);
            System.out.println("Pack - " + itemPackText);
            System.out.println("Size - " + itemSizeText);
            System.out.println("Category - " + itemCategoryText);
            System.out.println("------------");

            //Clicking Ok
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();

            //Checking Scan Item Screen again
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Cycle Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            //Clicking Loc Value
            try {
                driver.findElement(By.id("com.sof.retail:id/txtLocTextValue")).click();
                String locText = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
                String availLoc = driver.findElement(By.id("com.sof.retail:id/spinnerTextView")).getText();
                boolean locCheck = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
                System.out.println("Status is " + locCheck + " for " + locText);
                System.out.println("Available Location - " + availLoc);

                //Clicking Ok Button
                driver.findElement(By.id("com.sof.retail:id/okButton")).click();

            } catch (Exception e) {
                String errorMsg = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                String errorMsgTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(errorMsg + " " + errorMsgTxt);

                //Clicking Ok Button
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }

            //Clicking on Ellipses
            driver.findElement(By.id("com.sof.retail:id/imageThreeDot")).click();

            //Minimum Shelf Inventory
            String minShelf = driver.findElement(By.id("com.sof.retail:id/textTitle")).getText();
            System.out.println(minShelf + " is visible");

            //Clicking Cancel Button
            driver.findElement(By.id("com.sof.retail:id/cancelButton")).click();

            //Checking Scan Item Screen again
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Cycle Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
        } catch (Exception e) {
            String noItemsPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String noItemsPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(noItemsPopUp);
            System.out.println(noItemsPopUpTxt);
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void CycleCountBadgeCount() throws InterruptedException {
        testCase = 124;

        try {
            String cycBadgeCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView")).getText();
            try {
                //Selecting Cycle Count
                MobileElement cycleCountClck = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
                cycleCountClck.click();
                Thread.sleep(4000);

                //Storing count of Cycle count waiting to start
                String availCycleCount = driver.findElement(By.id("com.sof.retail:id/textCount")).getText();

                //Checking cycle count badge count with available
                if (availCycleCount.contains(cycBadgeCount)) {
                    System.out.println("Verified Badge Count");
                    System.out.println("Badge count - " + cycBadgeCount);
                    System.out.println("Cycle count waiting to start - " + availCycleCount);
                } else {
                    System.out.println("Badge Mismatch");
                }
            } catch (Exception e) {
                System.out.println("Cycle Count is empty");
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void InventoryFrontStock() throws InterruptedException {
        testCase = 51;
        keys = "UPC 1";

        //Checking for Listed Counts
        try {
            for (n = 1; n < 10; n++) {
                String countName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[" + n + "]/android.widget.TextView")).getText();
                if(!count.contains(countName)) {
                    count.add(countName);
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
        }

        System.out.println("Total " + count.size() + " is listed");
        for (n = 0; n < count.size(); n++) {
            System.out.println(n+1 + " - " + count.get(n));
        }

        //Selecting Inventory Count
        MobileElement invCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView");
        invCountClick.click();
        Thread.sleep(10000);

        try {

            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Inventory Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            try {
                boolean frontBtn = driver.findElement(By.id("com.sof.retail:id/btnFront")).isDisplayed();
                if (frontBtn == true) {
                    System.out.println("Counts are waiting");
                }

                //Checking whether department is displayed
                try {
                    boolean deptDisplayed = driver.findElement(By.id("com.sof.retail:id/tvInventoryItemName")).isDisplayed();
                    System.out.println("Status is " + deptDisplayed + " for departments");
                } catch (Exception e) {
                    System.out.println("Departments not visible");
                }
                //Checking whether Front Button is displayed
                try {
                    boolean frontBtnChck = driver.findElement(By.id("com.sof.retail:id/btnFront")).isDisplayed();
                    System.out.println("Status is " + frontBtnChck + " for Front Stock Button");
                } catch (Exception e) {
                    System.out.println("Front Button not visible");
                }
                //Checking whether Back Button is displayed
                try {
                    boolean backBtn = driver.findElement(By.id("com.sof.retail:id/btnBack")).isDisplayed();
                    System.out.println("Status is " + backBtn + " for Back Stock Button");
                } catch (Exception e) {
                    System.out.println("Back Button not visible");
                }
                //Checking whether Finalize Button is displayed
                try {
                    boolean finBtn = driver.findElement(By.id("com.sof.retail:id/btnFinalize")).isDisplayed();
                    System.out.println("Status is " + finBtn + " for Finalize Button");
                } catch (Exception e) {
                    System.out.println("Finalize Button not visible");
                }
                //Checking whether Approve Button is displayed
                try {
                    boolean approveBtn = driver.findElement(By.id("com.sof.retail:id/btnApprove")).isDisplayed();
                    System.out.println("Status is " + approveBtn + " for Approve Button");
                } catch (Exception e) {
                    System.out.println("Approve Button not visible");
                }
                //Checking whether UnApprove Button is displayed
                try {
                    boolean unApproveBtn = driver.findElement(By.id("com.sof.retail:id/btnUnapprove")).isDisplayed();
                    System.out.println("Status is " + unApproveBtn + " for Unapprove Button");
                } catch (Exception e) {
                    System.out.println("Unapprove Button not visible");
                }
                //Checking whether Reopen Button is displayed
                try {
                    boolean reOpenBtn = driver.findElement(By.id("com.sof.retail:id/btnReopen")).isDisplayed();
                    System.out.println("Status is " + reOpenBtn + " for Reopen Button");
                } catch (Exception e) {
                    System.out.println("Reopen Button not visible");
                }

                //Clicking front of department
                try {
                    MobileElement frontClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/btnFront"));
                    frontClick.click();
                    Thread.sleep(10000);

                    //Verifying current page
                    actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    expectedText = "Scan Items";
                    TestAsserts.assertCheck(actualText, expectedText);
                    Thread.sleep(2000);

                    //Verifying Upc field
                    boolean upcField = driver.findElement(By.id("com.sof.retail:id/upcScanTextInvCount")).isDisplayed();
                    System.out.println("Status is " + upcField + " for UPC Field");
                    //Verifying Label Printing Icon
                    boolean printerChck = driver.findElement(By.id("com.sof.retail:id/imageButtonInv")).isDisplayed();
                    System.out.println("Status is " + printerChck + " for Label Printing Icon");
                    //Verifying Location
                    boolean locCheck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed();
                    String locValue = driver.findElement(By.id("com.sof.retail:id/tvLocation")).getText();
                    System.out.println("Status is " + locCheck + " for Location, Location - " + locValue);
                    //Verifying Pack
                    boolean packChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView")).isDisplayed();
                    System.out.println("Status is " + packChck + " for Pack");
                    //Verifying Size
                    boolean sizeChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.TextView")).isDisplayed();
                    System.out.println("Status is " + sizeChck + " for Size");
                    //Verifying ?
                    boolean questionChck = driver.findElement(By.id("com.sof.retail:id/legendsIcon")).isDisplayed();
                    System.out.println("Status is " + questionChck + " for ? Icon");
                    //Verifying Description
                    boolean descChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[2]")).isDisplayed();
                    System.out.println("Status is " + descChck + " for Description");
                    //Verifying Total
                    boolean totalChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[3]")).isDisplayed();
                    System.out.println("Status is " + totalChck + " for Total");
                    //Verifying Next button
                    boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
                    System.out.println("Status is " + nextBtn + " for Next Button");
                    //Verifying Virutal keyboard
                    boolean vkBtn = driver.findElement(By.id("com.sof.retail:id/keyboardButtonSC")).isDisplayed();
                    System.out.println("Status is " + vkBtn + " for Virtual Keyboard");

                    //Adding UPC
                    MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanTextInvCount");
                    upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                    Actions action = new Actions(driver);
                    action.sendKeys(Keys.ENTER).perform();
                    Thread.sleep(14000);

                    //Checking whether item got added
                    try {
                        boolean itemChk = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
                        if (itemChk == true) {
                            String itemName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
                            System.out.println(itemName + " got added");
                        }
                        String pack = driver.findElement(By.id("com.sof.retail:id/tvPackValue")).getText();
                        String size = driver.findElement(By.id("com.sof.retail:id/tvSizeValue")).getText();
                        String uom = driver.findElement(By.id("com.sof.retail:id/tvCategory")).getText();
                        String total = driver.findElement(By.id("com.sof.retail:id/invValue")).getText();

                        //Printing Item Details
                        System.out.println("Pack - " + pack);
                        System.out.println("Size - " + size);
                        System.out.println("UOM - " + uom);
                        System.out.println("Total - " + total);
                    } catch (Exception e) {
                        System.out.println("No item got added");
                    }

                    //Checking Item Hyperlink
                    boolean itemHypLink = driver.findElement(By.id("com.sof.retail:id/tvDescPop")).isDisplayed();
                    if (itemHypLink == true) {
                        System.out.println("Item Hyperlink is visible");
                    }

                    //Clicking Hyperlink
                    driver.findElement(By.id("com.sof.retail:id/tvDescPop")).click();

                    //Verifying Hyperlink Contents
                    actualText = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
                    expectedText = "ITEM INFO";
                    TestAsserts.assertCheck(actualText, expectedText);
                    Thread.sleep(2000);

                    //Clicking Ok
                    driver.findElement(By.id("com.sof.retail:id/okButton")).click();

                    //Clicking ? Icon
                    driver.findElement(By.id("com.sof.retail:id/legendsIcon")).click();

                    //Checking Whether Legend is displayed
                    actualText = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
                    expectedText = "LEGEND";
                    TestAsserts.assertCheck(actualText, expectedText);
                    Thread.sleep(2000);

                    //Clicking Ok Button
                    driver.findElement(By.id("com.sof.retail:id/okButton")).click();

                    //Entering value in Total
                    try {
                        driver.findElement(By.id("com.sof.retail:id/invValue")).click();

                    } catch (Exception e) {
                        System.out.println("Unable to enter value");
                    }

                    //Adding item from other department
                    keys = "UPC 2";
                    upc.click();
                    upc.clear();
                    upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                    action.sendKeys(Keys.ENTER).perform();
                    Thread.sleep(6000);

                    try {
                        String noCountMsg = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                        System.out.println(noCountMsg + " is displayed");
                        //Clicking on Ok
                        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println("Element from other department can be added");
                    }

                    //Adding another item from count department
                    keys = "UPC 3";
                    upc.click();
                    upc.clear();
                    upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                    action.sendKeys(Keys.ENTER).perform();
                    Thread.sleep(6000);

                    //Checking whether item got added
                    try {
                        boolean itemChk = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")).isDisplayed();
                        if (itemChk == true) {
                            String itemName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")).getText();
                            System.out.println(itemName + " got added");
                        }
                    } catch (Exception e) {
                        System.out.println("No item got added");
                    }

                    //Checking whether Location is clickable
                    boolean finCountClick = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getAttribute("clickable").equals("true");
                    if (finCountClick == true) {
                        System.out.println("Location is clickable");
                    } else {
                        System.out.println("Location is not clickable");
                    }

                    //Clicking on Next Button
                    driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
                    Thread.sleep(4000);

                    //Summary Page
                    actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    expectedText = "Summary";
                    TestAsserts.assertCheck(actualText, expectedText);

                    //Time Remaining
                    boolean timeRemChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed();
                    String timeRem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
                    String timeRemValue = driver.findElement(By.id("com.sof.retail:id/tvTime")).getText();
                    System.out.println("Status is " + timeRemChck + " for " + timeRem + ", Time Remaining - " + timeRemValue);

                    //Items Counted
                    boolean itemsCountChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed();
                    String itemsCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
                    String itemsCountValue = driver.findElement(By.id("com.sof.retail:id/tvCount")).getText();
                    System.out.println("Status is " + itemsCountChck + " for " + itemsCount + ", Items Counted - " + itemsCountValue);

                    //Checking for Back button
                    boolean backBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
                    System.out.println("Status is " + backBtn + " for Back button");

                    //Checking for Send button
                    boolean sendBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
                    System.out.println("Status is " + backBtn + " for Send button");

                    //Clicking Back Button
                    driver.findElement(By.id("com.sof.retail:id/button")).click();

                    //Verifying current page
                    actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    expectedText = "Scan Items";
                    TestAsserts.assertCheck(actualText, expectedText);
                    Thread.sleep(2000);

                    //Clicking on Next Button
                    driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
                    Thread.sleep(3000);

                    //Clicking on Send Button
                    driver.findElement(By.id("com.sof.retail:id/button3")).click();
                    Thread.sleep(3000);

                    //QA Warning
                    driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                    Thread.sleep(3000);

                    //Submit Inventory Count Options
                    String submitTxt = driver.findElement(By.id("com.sof.retail:id/sendButton")).getText();
                    String submitContinueTxt = driver.findElement(By.id("com.sof.retail:id/sendAndFinalizeButton")).getText();
                    String cancelTxt = driver.findElement(By.id("com.sof.retail:id/cancelButton")).getText();

                    //Printing Options
                    System.out.println("Submit Inventory Count Options are visible");
                    System.out.println(submitTxt);
                    System.out.println(submitContinueTxt);
                    System.out.println(cancelTxt);

                    //Clicking Submit
                    driver.findElement(By.id("com.sof.retail:id/sendButton")).click();
                    Thread.sleep(16000);

                    //Verifying Transaction Page
                    actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    expectedText = "Transaction";
                    TestAsserts.assertCheck(actualText, expectedText);
                    Thread.sleep(2000);

                    //Description
                    boolean descpChck = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
                    String descpValue = driver.findElement(By.id("com.sof.retail:id/descText")).getText();
                    System.out.println("Status is " + descpChck + " for Description");
                    System.out.println("Description - " + descpValue);

                    //Transaction Number

                    boolean cycleCount = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
                    boolean transConfirm = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();

                    if (cycleCount == true && transConfirm == true) {
                        System.out.println("Inventory count & its count result is shown");
                    } else {
                        System.out.println("Inventory count & its count result not available");
                    }

                    //Time Stamp & Username
                    boolean dateTimeChck = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
                    String dateTimeValue = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
                    boolean nameChck = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
                    String nameValue = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).getText();

                    if (dateTimeChck == true && nameChck == true) {
                        System.out.println("Sent Date & Time Stamp, Sent by Username is shown");
                        System.out.println("Date & Time - " + dateTimeValue + ", Sent " + nameValue);
                    }

                    //Writing Transaction Number to Excel
                    transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
                    keys = "Transaction Number";
                    ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
                    driver.findElement(By.id("com.sof.retail:id/button")).click();
                    Thread.sleep(7000);

                    //Verifying Inventory Count Page Again
                    actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    expectedText = "Inventory Count";
                    TestAsserts.assertCheck(actualText, expectedText);
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("_________________________");
                    System.out.println("Front Button not visible");
                    System.out.println("_________________________");
                    System.out.println(e);
                }
            } catch (Exception e) {
                System.out.println("Inventory Count is Empty");
            }
        }
        catch (Exception e) {
            String error = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String errorTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(error);
            System.out.println(errorTxt);
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void InventoryFinalize() throws InterruptedException {
        testCase = 61;

        //Checking for Listed Counts
        try {
            for (n = 1; n < 10; n++) {
                String countName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[" + n + "]/android.widget.TextView")).getText();
                if (!count.contains(countName)) {
                    count.add(countName);
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
        }

        System.out.println("Total " + count.size() + " is listed");
        for (n = 0; n < count.size(); n++) {
            System.out.println(n+1 + " - " + count.get(n));
        }

        //Selecting Inventory Count
        MobileElement invCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView");
        invCountClick.click();
        Thread.sleep(10000);

        try {

            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Inventory Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            try {
                boolean finBtn = driver.findElement(By.id("com.sof.retail:id/btnFinalize")).isDisplayed();
                if (finBtn == true) {
                    System.out.println("Counts are waiting to finalize");
                }

                //Checking whether department is displayed
                try {
                    boolean deptDisplayed = driver.findElement(By.id("com.sof.retail:id/tvInventoryItemName")).isDisplayed();
                    System.out.println("Status is " + deptDisplayed + " for departments");
                } catch (Exception e) {
                    System.out.println("Departments not visible");
                }
                //Checking whether Front Button is displayed
                try {
                    boolean frontBtn = driver.findElement(By.id("com.sof.retail:id/btnFront")).isDisplayed();
                    System.out.println("Status is " + frontBtn + " for Front Stock Button");
                } catch (Exception e) {
                    System.out.println("Front Button not visible");
                }
                //Checking whether Back Button is displayed
                try {
                    boolean backBtn = driver.findElement(By.id("com.sof.retail:id/btnBack")).isDisplayed();
                    System.out.println("Status is " + backBtn + " for Back Stock Button");
                } catch (Exception e) {
                    System.out.println("Back Button not visible");
                }
                //Checking whether Finalize Button is displayed
                try {
                    boolean finBtnChck = driver.findElement(By.id("com.sof.retail:id/btnFinalize")).isDisplayed();
                    System.out.println("Status is " + finBtnChck + " for Finalize Button");
                } catch (Exception e) {
                    System.out.println("Finalize Button not visible");
                }
                //Checking whether Approve Button is displayed
                try {
                    boolean approveBtn = driver.findElement(By.id("com.sof.retail:id/btnApprove")).isDisplayed();
                    System.out.println("Status is " + approveBtn + " for Approve Button");
                } catch (Exception e) {
                    System.out.println("Approve Button not visible");
                }
                //Checking whether UnApprove Button is displayed
                try {
                    boolean unApproveBtn = driver.findElement(By.id("com.sof.retail:id/btnUnapprove")).isDisplayed();
                    System.out.println("Status is " + unApproveBtn + " for Unapprove Button");
                } catch (Exception e) {
                    System.out.println("Unapprove Button not visible");
                }
                //Checking whether Reopen Button is displayed
                try {
                    boolean reOpenBtn = driver.findElement(By.id("com.sof.retail:id/btnReopen")).isDisplayed();
                    System.out.println("Status is " + reOpenBtn + " for Reopen Button");
                } catch (Exception e) {
                    System.out.println("Reopen Button not visible");
                }

                //Clicking on finalize Button
                MobileElement finBtnClck = (MobileElement) driver.findElement(By.id("com.sof.retail:id/btnFinalize"));
                finBtnClck.click();
                Thread.sleep(14000);

                //Transaction Page
                boolean cycleCount = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
                boolean transConfirm = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();

                if (cycleCount == true && transConfirm == true) {
                    System.out.println("Inventory count & its count result is shown");
                } else {
                    System.out.println("Inventory count & its count result not available");
                }

                //Time Stamp & Username
                boolean dateTimeChck = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
                String dateTimeValue = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
                boolean nameChck = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
                String nameValue = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).getText();

                if (dateTimeChck == true && nameChck == true) {
                    System.out.println("Sent Date & Time Stamp, Sent by Username is shown");
                    System.out.println("Date & Time - " + dateTimeValue + ", Sent " + nameValue);
                }

                //Writing Transaction Number to Excel
                transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
                keys = "Transaction Number";
                ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("_________________________");
                System.out.println("Finalize Button is not available");
                System.out.println("_________________________");
                System.out.println(e);
            }
        }
        catch (Exception e) {
            String error = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String errorTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(error);
            System.out.println(errorTxt);
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void InventoryNoData() throws InterruptedException {
        testCase = 53;
        boolean retCountErrorChck;
        String retCountErrorTxt;

        //Checking for Listed Counts
        try {
            for (n = 1; n < 10; n++) {
                String countName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[" + n + "]/android.widget.TextView")).getText();
                if (!count.contains(countName)) {
                    count.add(countName);
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
        }

        System.out.println("Total " + count.size() + " is listed");
        for (n = 0; n < count.size(); n++) {
            System.out.println(n+1 + " - " + count.get(n));
        }

        //Selecting Inventory Count
        MobileElement invCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView");
        invCountClick.click();
        Thread.sleep(9000);

        try {
            //Checking for Error Message
            retCountErrorChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            retCountErrorTxt = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            if (retCountErrorChck == true) {
                System.out.println(retCountErrorTxt + " error is displayed");
            }
            try {
                //Retry Button
                boolean retryBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " + retryBtn + " for RETRY Button");
                //Cancel Button
                boolean cancelBtn = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                System.out.println("Status is " + cancelBtn + " for CANCEL Button");

                //Clicking on Retry
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                Thread.sleep(4000);

                //Checking for Inventory data
                retCountErrorChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
                retCountErrorTxt = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                if (retCountErrorChck == true) {
                    System.out.println(retCountErrorTxt + " error is displayed again");
                } else {
                    System.out.println("Inventory data found");
                }

                //Clicking Cancel
                try {
                    driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();

                    //Verifying SCreen
                    actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    expectedText = "Inventory Count";
                    TestAsserts.assertCheck(actualText, expectedText);
                    Thread.sleep(2000);

                    //Closing App
                    driver.closeApp();
                } catch (Exception e) {
                    System.out.println("Departments are listed");
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        catch (Exception e) {
            try {
                boolean frontBtnChck = driver.findElement(By.id("com.sof.retail:id/btnFront")).isDisplayed();
                if(frontBtnChck==true) {
                    System.out.println("Data found in Inventory Count");
                }
            } catch (Exception ex) {
                System.out.println("Inventory Count is empty");
            }
        }

        //Closing app
        driver.closeApp();
        driver.quit();
    }

    public static void InventoryUnableRetrieve() throws InterruptedException {
        testCase = 54;

        //Checking for Listed Counts
        try {
            for (n = 1; n < 10; n++) {
                String countName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[" + n + "]/android.widget.TextView")).getText();
                if (!count.contains(countName)) {
                    count.add(countName);
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
        }

        System.out.println("Total " + count.size() + " is listed");
        for (n = 0; n < count.size(); n++) {
            System.out.println(n+1 + " - " + count.get(n));
        }

        //Selecting Inventory Count
        MobileElement invCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView");
        invCountClick.click();
        Thread.sleep(4000);

        try {
            //Checking for Error Message
            boolean retCountErrorChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            String retCountErrorTxt = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            if (retCountErrorChck == true) {
                System.out.println(retCountErrorTxt + " error is displayed");
            }
            //Clicking Cancel
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();

            //Verifying SCreen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Inventory Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            try {
                boolean frontBtnChck = driver.findElement(By.id("com.sof.retail:id/btnFront")).isDisplayed();
                if(frontBtnChck==true) {
                    System.out.println("Data found in Inventory Count");
                }
            } catch (Exception ex) {
                System.out.println("Inventory Count is empty");
            }
        }
        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void RecallCountStart() throws InterruptedException {
        testCase = 104;
        keys = "UPC 1";

        //Clicking Recall Count
        MobileElement recallCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[6]/android.widget.TextView");
        recallCountClick.click();

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (restoreChck == true) {
                System.out.println("Restore found");
                //Deleting the restore data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }
        Thread.sleep(20000);

        //Recall SCreen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Recalls & Withdrawals";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean recallChck = driver.findElement(By.id("com.sof.retail:id/recallText")).isDisplayed();
        if (recallChck == true) {
            String prdRecallTxt = driver.findElement(By.id("com.sof.retail:id/recall")).getText();
            recallTxt = driver.findElement(By.id("com.sof.retail:id/recallText")).getText();
            System.out.println("Status is " + recallChck + " for " + prdRecallTxt + recallTxt);
        }
        boolean desc = driver.findElement(By.id("com.sof.retail:id/productRecallValue")).isDisplayed();
        if (desc == true) {
            String descValue = driver.findElement(By.id("com.sof.retail:id/productRecallValue")).getText();
            System.out.println(descValue + " is displayed");
        }
        boolean prodStatus = driver.findElement(By.id("com.sof.retail:id/tvProductStatus")).isDisplayed();
        if (prodStatus == true) {
            String prodStatusValue = driver.findElement(By.id("com.sof.retail:id/tvProductStatus")).getText();
            System.out.println("Product Status - " + prodStatusValue);
        }
        boolean itemStatus = driver.findElement(By.id("com.sof.retail:id/tvProductStatusItems")).isDisplayed();
        if (itemStatus == true) {
            String itemStatusValue = driver.findElement(By.id("com.sof.retail:id/tvProductStatusItems")).getText();
            System.out.println("Item Status - " + itemStatusValue);
        }
        //Start
        try {
            boolean startBtn = driver.findElement(By.id("com.sof.retail:id/btn2")).isDisplayed();
            if (startBtn == true) {
                String startBtnValue = driver.findElement(By.id("com.sof.retail:id/btn2")).getText();
                if (startBtnValue.equals("START")) {
                    System.out.println("Status is " + startBtn + " for Start Button");
                }
            }
        } catch (Exception e) {
            System.out.println("Start Button is not visible");
        }

        //Print
        try {
            boolean printBtn = driver.findElement(By.id("com.sof.retail:id/printerButton")).isDisplayed();
            if (printBtn == true) {
                System.out.println("Status is " + printBtn + " for Print Button");
            }
        } catch (Exception e) {
            System.out.println("Print Button is not visible");
        }

        //Submit
        try {
            boolean submitBtn = driver.findElement(By.id("com.sof.retail:id/btn1")).isDisplayed();
            if (submitBtn == true) {
                String submitBtnValue = driver.findElement(By.id("com.sof.retail:id/btn1")).getText();
                if (submitBtnValue.equals("SUBMIT")) {
                    System.out.println("Status is " + submitBtn + " for Submit Button");
                }
            }
        } catch (Exception e) {
            System.out.println("Submit Button is not visible");
        }

        //Continue
        try {
            boolean contBtn = driver.findElement(By.id("com.sof.retail:id/btn2")).isDisplayed();
            if (contBtn == true) {
                String contBtnValue = driver.findElement(By.id("com.sof.retail:id/btn2")).getText();
                if (contBtnValue.equals("CONTINUE")) {
                    System.out.println("Status is " + contBtn + " for Continue Button");
                }
            }
        } catch (Exception e) {
            System.out.println("Continue Button is not visible");
        }

        boolean subRecallChckbox = driver.findElement(By.id("com.sof.retail:id/submittedRecallsCheckBox")).isDisplayed();
        System.out.println("Status is " + subRecallChckbox + " for Submitted Recall Checkbox");

        //Clicking Start
        String startBtnValue = driver.findElement(By.id("com.sof.retail:id/btn2")).getText();
        if (startBtnValue.equals("START")) {
            driver.findElement(By.id("com.sof.retail:id/btn2")).click();
            Thread.sleep(25000);

            //Recall SCreen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Instructions";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
            try {
                String instrHeading = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.widget.TextView[1]")).getText();
                System.out.println(instrHeading);
            } catch (Exception e) {
                System.out.println("Instruction is empty");
            }

            boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
            System.out.println("Status is " + nextBtn + " for Next Button");

            //Clicking Next Button
            driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
            Thread.sleep(14000);

//            //Recall SCreen
//            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
//            expectedText = "Product Recall # "+recallTxt;
//            TestAsserts.assertCheck(actualText, expectedText);
//            Thread.sleep(2000);

            //Scanning an Invalid Item
            MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
            upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(6000);

            boolean noItemPopUpChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (noItemPopUpChck == true) {
                String noItemPopUpValue = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                String noItemPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(noItemPopUpValue + " is displayed");
                System.out.println(noItemPopUpTxt);
                //Clicking ok
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }

            //Clicking Next
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

            //Summary SCreen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Summary";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            boolean timeRem = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).isDisplayed();
            boolean itemCount = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).isDisplayed();
            if (timeRem == true && itemCount == true) {
                System.out.println("Time Remaining & Item Counted is visible");
                String timeRemValue = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).getText();
                String itemCountValue = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).getText();
                System.out.println("Time Remaining - " + timeRemValue);
                System.out.println("Items Counted - " + itemCountValue);
            }

            //Clicking Send
            driver.findElement(By.id("com.sof.retail:id/button3")).click();

            boolean recallPop = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (recallPop == true) {
                String recallPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                String recallPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(recallPopUp + " Pop up is displayed");
                System.out.println(recallPopUpTxt);
                //Clicking Ok
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

                //Submit Recall
                boolean submitRecallPop = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
                if (submitRecallPop == true) {
                    String submitRecallPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                    String submitRecallPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                    System.out.println(submitRecallPopUp + " Pop up is displayed");
                    System.out.println(submitRecallPopUpTxt);

                    boolean subBtn = driver.findElement(By.id("com.sof.retail:id/sendButton")).isDisplayed();
                    System.out.println("Status is " + subBtn + " for Submit Button");
                    boolean cancelBtn = driver.findElement(By.id("com.sof.retail:id/cancelButton")).isDisplayed();
                    System.out.println("Status is " + cancelBtn + " for Cancel Button");

                    //Clicking No
                    driver.findElement(By.id("com.sof.retail:id/cancelButton")).click();
                }
            }

            //Clicking Send
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            //Clicking Ok
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            //Clicking Submit
            driver.findElement(By.id("com.sof.retail:id/sendButton")).click();

            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(15000);

            //Transaction Page
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Transaction";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(3000);

            boolean prodRecall = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            if (prodRecall == true) {
                System.out.println("Product Recall is visible");
            }
            boolean prodRecallSub = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            if (prodRecallSub == true) {
                System.out.println("Product Recall Submission is visible");
            }

            transNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();

            //Writing Transaction Number to Excel
            transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            keys = "Transaction Number";
            ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
            driver.findElement(By.id("com.sof.retail:id/button")).click();
            Thread.sleep(2000);

        } else {
            System.out.println("START is not visible");
        }
    }

    public static void RecallCountContinue() throws InterruptedException {
        testCase = 114;
        keys = "UPC 1";

        //Clicking Recall Count
        MobileElement recallCountClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[6]/android.widget.TextView");
        recallCountClick.click();

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (restoreChck == true) {
                System.out.println("Restore found");
                //Deleting the restore data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }
        Thread.sleep(20000);

        //Recall SCreen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Recalls & Withdrawals";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean recallChck = driver.findElement(By.id("com.sof.retail:id/recallText")).isDisplayed();
        if (recallChck == true) {
            String prdRecallTxt = driver.findElement(By.id("com.sof.retail:id/recall")).getText();
            recallTxt = driver.findElement(By.id("com.sof.retail:id/recallText")).getText();
            System.out.println("Status is " + recallChck + " for " + prdRecallTxt + recallTxt);
        }
        boolean desc = driver.findElement(By.id("com.sof.retail:id/productRecallValue")).isDisplayed();
        if (desc == true) {
            String descValue = driver.findElement(By.id("com.sof.retail:id/productRecallValue")).getText();
            System.out.println(descValue + " is displayed");
        }
        boolean prodStatus = driver.findElement(By.id("com.sof.retail:id/tvProductStatus")).isDisplayed();
        if (prodStatus == true) {
            String prodStatusValue = driver.findElement(By.id("com.sof.retail:id/tvProductStatus")).getText();
            System.out.println("Product Status - " + prodStatusValue);
        }
        boolean itemStatus = driver.findElement(By.id("com.sof.retail:id/tvProductStatusItems")).isDisplayed();
        if (itemStatus == true) {
            String itemStatusValue = driver.findElement(By.id("com.sof.retail:id/tvProductStatusItems")).getText();
            System.out.println("Item Status - " + itemStatusValue);
        }
        //Start
        try {
            boolean startBtn = driver.findElement(By.id("com.sof.retail:id/btn2")).isDisplayed();
            if (startBtn == true) {
                String startBtnValue = driver.findElement(By.id("com.sof.retail:id/btn2")).getText();
                if (startBtnValue.equals("START")) {
                    System.out.println("Status is " + startBtn + " for Start Button");
                }
            }
        } catch (Exception e) {
            System.out.println("Start Button is not visible");
        }

        //Print
        try {
            boolean printBtn = driver.findElement(By.id("com.sof.retail:id/printerButton")).isDisplayed();
            if (printBtn == true) {
                System.out.println("Status is " + printBtn + " for Print Button");
            }
        } catch (Exception e) {
            System.out.println("Print Button is not visible");
        }

        //Submit
        try {
            boolean submitBtn = driver.findElement(By.id("com.sof.retail:id/btn1")).isDisplayed();
            if (submitBtn == true) {
                String submitBtnValue = driver.findElement(By.id("com.sof.retail:id/btn1")).getText();
                if (submitBtnValue.equals("SUBMIT")) {
                    System.out.println("Status is " + submitBtn + " for Submit Button");
                }
            }
        } catch (Exception e) {
            System.out.println("Submit Button is not visible");
        }

        //Continue
        try {
            boolean contBtn = driver.findElement(By.id("com.sof.retail:id/btn2")).isDisplayed();
            if (contBtn == true) {
                String contBtnValue = driver.findElement(By.id("com.sof.retail:id/btn2")).getText();
                if (contBtnValue.equals("CONTINUE")) {
                    System.out.println("Status is " + contBtn + " for Continue Button");
                }
            }
        } catch (Exception e) {
            System.out.println("Continue Button is not visible");
        }

        boolean subRecallChckbox = driver.findElement(By.id("com.sof.retail:id/submittedRecallsCheckBox")).isDisplayed();
        System.out.println("Status is " + subRecallChckbox + " for Submitted Recall Checkbox");

        //Clicking Continue
        String startBtnValue = driver.findElement(By.id("com.sof.retail:id/btn2")).getText();
        if (startBtnValue.equals("CONTINUE")) {
            driver.findElement(By.id("com.sof.retail:id/btn2")).click();
            Thread.sleep(25000);

            //Recall SCreen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Instructions";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
            try {
                String instrHeading = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.widget.TextView[1]")).getText();
                System.out.println(instrHeading);
            } catch (Exception e) {
                System.out.println("Instruction is empty");
            }

            boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
            System.out.println("Status is " + nextBtn + " for Next Button");

            //Clicking Next Button
            driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
            Thread.sleep(14000);

            //Scanning an Invalid Item
            MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
            upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);

            boolean noItemPopUpChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (noItemPopUpChck == true) {
                String noItemPopUpValue = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                String noItemPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(noItemPopUpValue + " is displayed");
                System.out.println(noItemPopUpTxt);
                //Clicking ok
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }

            //Clicking Next
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            try {
                boolean prodRecall = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
                if (prodRecall == true) {
                    System.out.println("Product Recall Pop up is displayed");
                    String prodRecallTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                    System.out.println(prodRecallTxt);
                    driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                }
            } catch (Exception e) {
                System.out.println("Product Recall Pop up is not displayed");
            }

            //Summary SCreen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Summary";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            boolean timeRem = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).isDisplayed();
            boolean itemCount = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).isDisplayed();
            if (timeRem == true && itemCount == true) {
                System.out.println("Time Remaining & Item Counted is visible");
                String timeRemValue = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).getText();
                String itemCountValue = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).getText();
                System.out.println("Time Remaining - " + timeRemValue);
                System.out.println("Items Counted - " + itemCountValue);
            }

            //Clicking Send
            driver.findElement(By.id("com.sof.retail:id/button3")).click();

            boolean recallPop = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (recallPop == true) {
                String recallPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                String recallPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(recallPopUp + " Pop up is displayed");
                System.out.println(recallPopUpTxt);
                //Clicking Ok
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

                //Submit Recall
                boolean submitRecallPop = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
                if (submitRecallPop == true) {
                    String submitRecallPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                    String submitRecallPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                    System.out.println(submitRecallPopUp + " Pop up is displayed");
                    System.out.println(submitRecallPopUpTxt);

                    boolean subBtn = driver.findElement(By.id("com.sof.retail:id/sendButton")).isDisplayed();
                    System.out.println("Status is " + subBtn + " for Submit Button");
                    boolean cancelBtn = driver.findElement(By.id("com.sof.retail:id/cancelButton")).isDisplayed();
                    System.out.println("Status is " + cancelBtn + " for Cancel Button");

                    //Clicking No
                    driver.findElement(By.id("com.sof.retail:id/cancelButton")).click();
                }
            }

            //Clicking Send
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            //Clicking Ok
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            //Clicking Submit
            driver.findElement(By.id("com.sof.retail:id/sendButton")).click();

            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(18000);

            //Transaction Page
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Transaction";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(3000);

            boolean prodRecall = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            if (prodRecall == true) {
                System.out.println("Product Recall is visible");
            }
            boolean prodRecallSub = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            if (prodRecallSub == true) {
                System.out.println("Product Recall Submission is visible");
            }

            transNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();

            //Writing Transaction Number to Excel
            transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            keys = "Transaction Number";
            ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
            driver.findElement(By.id("com.sof.retail:id/button")).click();
            Thread.sleep(20000);

            //Clicking Submitted Recalls checkbox
            driver.findElement(By.id("com.sof.retail:id/submittedRecallsCheckBox")).click();
            // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+recallTxt+"\").instance(0))").click();

            String uiSelector = "new UiSelector().textMatches(\"" + recallTxt + "\")";
            String command = "new UiScrollable( new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
            driver.findElementByAndroidUIAutomator(command);
        } else {
            System.out.println("CONTINUE is not visible");
        }
    }
}

