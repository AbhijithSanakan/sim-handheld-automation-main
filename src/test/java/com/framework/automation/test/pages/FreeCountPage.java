package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FreeCountPage {

    static int testCase;
    static String keys = null;
    static String actualText;
    static String expectedText;
    static String transNum;
    static int sum = 0;
    static int n;
    static AndroidDriver<AndroidElement> driver;

    public FreeCountPage() throws IOException, InterruptedException {
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

    public static void FreeCountClick() throws InterruptedException {
        MobileElement freeCountClck = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.TextView");
        freeCountClck.click();
        Thread.sleep(4000);
    }

    public static void FreeCountNoBackup() throws InterruptedException {
        testCase = 106;
        keys = "UPC 1";

        //Free Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Free Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean upcTxt = driver.findElement(By.id("com.sof.retail:id/upcText")).isDisplayed();
        System.out.println("Status is " + upcTxt + " for UPC");
        boolean scanField = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isDisplayed();
        System.out.println("Status is " +scanField+ " for Scan UPC Field");
        boolean packChck = driver.findElement(By.id("com.sof.retail:id/packLabelTextView")).isDisplayed();
        System.out.println("Status is " +packChck+ " for Pack");
        boolean sizeChck = driver.findElement(By.id("com.sof.retail:id/sizeLabelTextView")).isDisplayed();
        System.out.println("Status is " +sizeChck+ " for Size");
        boolean locChck = driver.findElement(By.id("com.sof.retail:id/locLabelTextView")).isDisplayed();
        System.out.println("Status is " +locChck+ " for Location");
        boolean bohChck = driver.findElement(By.id("com.sof.retail:id/bohLabelTextView")).isDisplayed();
        System.out.println("Status is " +bohChck+ " for BOH");
        boolean minChck = driver.findElement(By.id("com.sof.retail:id/minLabelTextView")).isDisplayed();
        System.out.println("Status is " +minChck+ " for Minimum Inventory");
        boolean lastChck = driver.findElement(By.id("com.sof.retail:id/lastLabelTextView")).isDisplayed();
        System.out.println("Status is " +lastChck+ " for Last Received");
        boolean salesChck = driver.findElement(By.id("com.sof.retail:id/salesLabelTextView")).isDisplayed();
        System.out.println("Status is " +salesChck+ " for Sales");
        boolean quesChck = driver.findElement(By.id("com.sof.retail:id/questionTextView")).isDisplayed();
        System.out.println("Status is " +quesChck+ " for ?");
        boolean descChck = driver.findElement(By.id("com.sof.retail:id/descriptionText")).isDisplayed();
        System.out.println("Status is " +descChck+ " for Description");
        boolean totalChck = driver.findElement(By.id("com.sof.retail:id/uomTextView")).isDisplayed();
        System.out.println("Status is " +totalChck+ " for Total");
        boolean countChck = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).isDisplayed();
        System.out.println("Status is " +countChck+ " for Count");
        boolean confirmChck = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
        System.out.println("Status is " +confirmChck+ " for CONFIRM Button");
        boolean vKeyChck = driver.findElement(By.id("com.sof.retail:id/keyboardButtonSC")).isDisplayed();
        System.out.println("Status is " +vKeyChck+ " for Virtual Keyboard");

        //Scanning an Item
        MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upcScan.click();
        upcScan.click();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(12000);
        upcScan.clear();

        //Added Item
        boolean itemAdded = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).isDisplayed();
        if(itemAdded==true) {
            String itemAddedName = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).getText();
            System.out.println(itemAddedName+ " item got added");
            String shelfValue = driver.findElement(By.id("com.sof.retail:id/shelfValueTextView")).getText();
            String timeRemValue = driver.findElement(By.id("com.sof.retail:id/timeRemainingValue")).getText();
            String packValue = driver.findElement(By.id("com.sof.retail:id/packValueTextView")).getText();
            String sizeValue = driver.findElement(By.id("com.sof.retail:id/sizeValueTextView")).getText();
            String locValue = driver.findElement(By.id("com.sof.retail:id/locValueTextView")).getText();
            String bohValue = driver.findElement(By.id("com.sof.retail:id/bohValueTextView")).getText();
            String minValue = driver.findElement(By.id("com.sof.retail:id/minValueTextView")).getText();
            String lastValue = driver.findElement(By.id("com.sof.retail:id/lastValueTextView")).getText();
            String salesValue = driver.findElement(By.id("com.sof.retail:id/salesValueTextView")).getText();

            //Printing Value
            System.out.println("Shelf - " +shelfValue);
            System.out.println("Time Remaining - " +timeRemValue);
            System.out.println("Pack - " +packValue);
            System.out.println("SIze - " +sizeValue);
            System.out.println("Location - " +locValue);
            System.out.println("BOH - " +bohValue);
            System.out.println("Min - " +minValue);
            System.out.println("Last - " +lastValue);
            System.out.println("Sales - " +salesValue);
        }

        //Swiping through item
        TouchAction action1 = new TouchAction(driver);
        action1.press(PointOption.point(254, 414))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(117, 414)).release().perform();

        boolean delBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + delBtn + " for Delete Button");
        driver.findElement(By.id("com.sof.retail:id/itemDelete")).click();

        //Scanning Another Item
        keys = "UPC 2";
        upcScan.click();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);

        //Added Item
        boolean itemAddedNew = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).isDisplayed();
        if(itemAddedNew==true) {
            String itemAddedName = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).getText();
            System.out.println(itemAddedName + " item got added");
        }

        MobileElement countValue = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]");
        keys = "Count";
        String count = (String) ExcelHandle.ExcelFunction(testCase, keys);
        countValue.click();
        countValue.clear();
        countValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();

        try {
            //Quantity confirmation PopUp
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
        }
        catch (Exception e) {
            System.out.println("No quantity confirmation is required");
        }

        //Tapping outside
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(26, 345)).perform();

        //Checking Value of total
        String total = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
        if(total.equals(count)) {
            System.out.println("Count value got added to Total");
        }

        //Clicking Confirm
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

        //Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean timeRemChck = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).isDisplayed();
        boolean itemCountedChck = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).isDisplayed();

        if(timeRemChck==true && itemCountedChck==true) {
            System.out.println("Time Remaining & Item Counted is visible");
            String timeRem = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).getText();
            String itemCounted = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).getText();
            System.out.println("Time Remaining - " +timeRem);
            System.out.println("Item Counted - " +itemCounted);
        }

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        boolean sendTransChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
        if(sendTransChck==true) {
            String sendTransPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String  sendTransPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(sendTransPopUp+ " Pop up is visible");
            System.out.println(sendTransPopUpTxt);

            boolean subBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
            System.out.println("Status is " +subBtn+ " for Submit Button");
            boolean cancelBtn = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
            System.out.println("Status is " +cancelBtn+ " for Cancel Button");

            //Clicking Submit
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(10000);
        }

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Free count & transaction
        boolean freeCount = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        boolean transConfirm = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();

        if (freeCount == true && transConfirm == true) {
            System.out.println("Free count & its count result is shown");
        } else {
            System.out.println("Free count & its count result not available");
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

    }

    public static void FreeCountBackup() throws InterruptedException {
        testCase = 108;
        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if(restoreChck==true) {
                System.out.println("Restore found");
                String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(restoreTxt);
                boolean restoreBtnChck = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                System.out.println("Status is " +restoreBtnChck+ " for Restore Button");
                boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " +deleteBtn+ " for Delete Button");
                //Restoring the data
                System.out.println("Restoring Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
                Thread.sleep(3000);
            }
        }
        catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Free Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Free Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Added Item
        boolean itemAdded = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).isDisplayed();
        if(itemAdded==true) {
            String itemAddedName = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).getText();
            System.out.println(itemAddedName+ " item is visible");
            String shelfValue = driver.findElement(By.id("com.sof.retail:id/shelfValueTextView")).getText();
            String timeRemValue = driver.findElement(By.id("com.sof.retail:id/timeRemainingValue")).getText();
            String packValue = driver.findElement(By.id("com.sof.retail:id/packValueTextView")).getText();
            String sizeValue = driver.findElement(By.id("com.sof.retail:id/sizeValueTextView")).getText();
            String locValue = driver.findElement(By.id("com.sof.retail:id/locValueTextView")).getText();
            String bohValue = driver.findElement(By.id("com.sof.retail:id/bohValueTextView")).getText();
            String minValue = driver.findElement(By.id("com.sof.retail:id/minValueTextView")).getText();
            String lastValue = driver.findElement(By.id("com.sof.retail:id/lastValueTextView")).getText();
            String salesValue = driver.findElement(By.id("com.sof.retail:id/salesValueTextView")).getText();

            //Printing Value
            System.out.println("Shelf - " +shelfValue);
            System.out.println("Time Remaining - " +timeRemValue);
            System.out.println("Pack - " +packValue);
            System.out.println("SIze - " +sizeValue);
            System.out.println("Location - " +locValue);
            System.out.println("BOH - " +bohValue);
            System.out.println("Min - " +minValue);
            System.out.println("Last - " +lastValue);
            System.out.println("Sales - " +salesValue);
        }

        boolean itemDescChck = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        if(itemDescChck==true) {
            String itemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
            System.out.println("Item description is displayed - " +itemDescName);
        }

        //Swiping through item
        TouchAction action1 = new TouchAction(driver);
        action1.press(PointOption.point(254, 414))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(117, 414)).release().perform();

        boolean delBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + delBtn + " for Delete Button");

        //Storing Total value
        String totalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
        MobileElement countValue = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]");
        keys = "Count";

        countValue.click();
        countValue.clear();
        countValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        try {
            //Quantity confirmation PopUp
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
        }
        catch (Exception e) {
            System.out.println("No quantity confirmation is required");
        }

        //Tapping outside
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(26, 345)).perform();

        String curTotalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
        System.out.println("Total before adding count - " + totalValue);
        System.out.println("Total after adding count - " +curTotalValue);

        //Clicking Confirm
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

        //Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean timeRemChck = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).isDisplayed();
        boolean itemCountedChck = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).isDisplayed();

        if(timeRemChck==true && itemCountedChck==true) {
            System.out.println("Time Remaining & Item Counted is visible");
            String timeRem = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).getText();
            String itemCounted = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).getText();
            System.out.println("Time Remaining - " +timeRem);
            System.out.println("Item Counted - " +itemCounted);
        }

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        boolean sendTransChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
        if(sendTransChck==true) {
            String sendTransPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String  sendTransPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(sendTransPopUp+ " Pop up is visible");
            System.out.println(sendTransPopUpTxt);

            boolean subBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
            System.out.println("Status is " +subBtn+ " for Submit Button");
            boolean cancelBtn = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
            System.out.println("Status is " +cancelBtn+ " for Cancel Button");

            //Clicking Submit
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(10000);
        }

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Free count & transaction
        boolean freeCount = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        boolean transConfirm = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();

        if (freeCount == true && transConfirm == true) {
            System.out.println("Free count & its count result is shown");
        } else {
            System.out.println("Free count & its count result not available");
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
    }

    public static void FreeCountCancelled() throws InterruptedException {
        testCase = 110;
        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if(restoreChck==true) {
                System.out.println("Restore found");
                String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(restoreTxt);
                boolean restoreBtnChck = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                System.out.println("Status is " +restoreBtnChck+ " for Restore Button");
                boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " +deleteBtn+ " for Delete Button");
                //Restoring the data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                Thread.sleep(3000);
            }
        }
        catch (Exception e) {
            System.out.println("No restore is found");
        }
        //Free Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Free Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        actualText = driver.findElement(By.id("com.sof.retail:id/totalItems")).getText();
        expectedText = "Item 0 of 0";
        if(actualText.equals(expectedText)) {
            System.out.println("Restore data got deleted");
        }
    }

    public static void FreeCountMinimumShelfInventory() throws InterruptedException {
        testCase = 112;
        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if(restoreChck==true) {
                System.out.println("Restore found");
                String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(restoreTxt);
                boolean restoreBtnChck = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                System.out.println("Status is " +restoreBtnChck+ " for Restore Button");
                boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " +deleteBtn+ " for Delete Button");
                //Restoring the data
                System.out.println("Restoring Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
                Thread.sleep(3000);
            }
        }
        catch (Exception e) {
            System.out.println("No restore is found");
        }
        //Free Count Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Free Count";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Added Item
        boolean itemAdded = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).isDisplayed();
        if(itemAdded==true) {
            String itemAddedName = driver.findElement(By.id("com.sof.retail:id/textViewItemName")).getText();
            System.out.println(itemAddedName+ " item is visible");
            String shelfValue = driver.findElement(By.id("com.sof.retail:id/shelfValueTextView")).getText();
            String timeRemValue = driver.findElement(By.id("com.sof.retail:id/timeRemainingValue")).getText();
            String packValue = driver.findElement(By.id("com.sof.retail:id/packValueTextView")).getText();
            String sizeValue = driver.findElement(By.id("com.sof.retail:id/sizeValueTextView")).getText();
            String locValue = driver.findElement(By.id("com.sof.retail:id/locValueTextView")).getText();
            String bohValue = driver.findElement(By.id("com.sof.retail:id/bohValueTextView")).getText();
            String minValue = driver.findElement(By.id("com.sof.retail:id/minValueTextView")).getText();
            String lastValue = driver.findElement(By.id("com.sof.retail:id/lastValueTextView")).getText();
            String salesValue = driver.findElement(By.id("com.sof.retail:id/salesValueTextView")).getText();

            //Printing Value
            System.out.println("Shelf - " +shelfValue);
            System.out.println("Time Remaining - " +timeRemValue);
            System.out.println("Pack - " +packValue);
            System.out.println("SIze - " +sizeValue);
            System.out.println("Location - " +locValue);
            System.out.println("BOH - " +bohValue);
            System.out.println("Min - " +minValue);
            System.out.println("Last - " +lastValue);
            System.out.println("Sales - " +salesValue);
        }

        boolean itemDescChck = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        if(itemDescChck==true) {
            String itemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
            System.out.println("Item description is displayed - " +itemDescName);
        }

        //Swiping through item
        TouchAction action1 = new TouchAction(driver);
        action1.press(PointOption.point(254, 414))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(117, 414)).release().perform();

        boolean delBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + delBtn + " for Delete Button");
        Thread.sleep(2000);

        action1.press(PointOption.point(78, 402))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(168, 402)).release().perform();

        //Storing Total value
        String totalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
        MobileElement countValue = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]");
        keys = "Count";

        countValue.click();
        countValue.clear();
        countValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        try {
            //Quantity confirmation PopUp
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
        }
        catch (Exception e) {
            System.out.println("No quantity confirmation is required");
        }

        //Tapping outside
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(26, 345)).perform();

        String curTotalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).getText();
        System.out.println("Total before adding count - " + totalValue);
        System.out.println("Total after adding count - " +curTotalValue);

        //Clicking on ellipsis
        driver.findElement(By.id("com.sof.retail:id/minOptions")).click();
        Thread.sleep(4000);

        //Minimum Shelf Inventory Page
        actualText = driver.findElement(By.id("com.sof.retail:id/textTitle")).getText();
        expectedText = "MINIMUM SHELF INVENTORY";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean minQtyChck = driver.findElement(By.id("com.sof.retail:id/textMinimumQtyLabel")).isDisplayed();
        if(minQtyChck==true) {
            System.out.println("Minimum Quantity is displayed");
        }
        boolean recChck = driver.findElement(By.id("com.sof.retail:id/textRecurring")).isDisplayed();
        if(recChck==true) {
            System.out.println("Recurring is displayed");
        }
        boolean schFromChck = driver.findElement(By.id("com.sof.retail:id/constraintLayoutScheduleFrom")).isDisplayed();
        boolean schToChck = driver.findElement(By.id("com.sof.retail:id/constraintLayoutScheduleTo")).isDisplayed();
        if(schFromChck==true && schToChck) {
            System.out.println("Schedule from & Schedule to dropdown is displayed");
        }

        boolean defTxt = driver.findElement(By.id("com.sof.retail:id/textInventoryShelfMinSubTitle")).isDisplayed();
        if(defTxt) {
            String defTxtValue = driver.findElement(By.id("com.sof.retail:id/textInventoryShelfMinSubTitle")).getText();
            System.out.println(defTxtValue);
        }
        boolean okBtn = driver.findElement(By.id("com.sof.retail:id/okButton")).isDisplayed();
        System.out.println("Status is " +okBtn+ " for Ok Button");
        boolean clearBtn = driver.findElement(By.id("com.sof.retail:id/clearButton")).isDisplayed();
        System.out.println("Status is " +clearBtn+ " for Clear Button");
        boolean cancelBtn = driver.findElement(By.id("com.sof.retail:id/cancelButton")).isDisplayed();
        System.out.println("Status is " +cancelBtn+ " for Cancel Button");

        //Clicking Clear
        driver.findElement(By.id("com.sof.retail:id/clearButton")).click();

        //Clicking Confirm
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

        //Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean timeRemChck = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).isDisplayed();
        boolean itemCountedChck = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).isDisplayed();

        if(timeRemChck==true && itemCountedChck==true) {
            System.out.println("Time Remaining & Item Counted is visible");
            String timeRem = driver.findElement(By.id("com.sof.retail:id/timeRemainingValueTextView")).getText();
            String itemCounted = driver.findElement(By.id("com.sof.retail:id/itemShrunkValueTextView")).getText();
            System.out.println("Time Remaining - " +timeRem);
            System.out.println("Item Counted - " +itemCounted);
        }

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        boolean sendTransChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
        if(sendTransChck==true) {
            String sendTransPopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String  sendTransPopUpTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(sendTransPopUp+ " Pop up is visible");
            System.out.println(sendTransPopUpTxt);

            boolean subBtnChck = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
            System.out.println("Status is " +subBtnChck+ " for Submit Button");
            boolean cancelBtnChck = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
            System.out.println("Status is " +cancelBtnChck+ " for Cancel Button");

            //Clicking Submit
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(10000);
        }

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Free count & transaction
        boolean freeCount = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        boolean transConfirm = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();

        if (freeCount == true && transConfirm == true) {
            System.out.println("Free count & its count result is shown");
        } else {
            System.out.println("Free count & its count result not available");
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
    }
}

