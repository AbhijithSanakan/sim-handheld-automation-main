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

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class LabelPrintingPage {
    static AndroidDriver<AndroidElement> driver;
    static int testCase;
    static String transNum;
    static String keys = null;
    static String actualText;
    static String expectedText;

    public LabelPrintingPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void LabPrintingClick() throws InterruptedException {
        Thread.sleep(10000);
        //Swiping Down
        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(257, 392))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(257, 130)).release().perform();

        //Clicking Label Printing
        MobileElement labPrintingClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[5]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView");
        labPrintingClick.click();
    }

    public static void LabPrintVerify() throws InterruptedException {
        testCase = 90;
        keys = "UPC List 3";
        //Clicking Lable Printing
        MobileElement labPrint = (MobileElement) driver.findElementById("com.sof.retail:id/textViewItem");
        labPrint.click();
        Thread.sleep(2000);

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            if (restoreChck == true) {
                System.out.println("Restore found");
                System.out.println("______________");
                System.out.println(restoreTxt);
                System.out.println("______________");
                //Deleting the restore data
                System.out.println("Restoring Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Label Printing Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Label Printing";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean upcFieldChck = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isDisplayed();
        System.out.println("Status is " + upcFieldChck + " for UPC Field");
        boolean upcChck = driver.findElement(By.id("com.sof.retail:id/upcText")).isDisplayed();
        System.out.println("Status is " + upcChck + " for UPC");
        boolean descGrid = driver.findElement(By.id("com.sof.retail:id/labelPrintingtRecyclerView")).isDisplayed();
        System.out.println("Status is " + descGrid + " for Description Grid");

        //Checking for items in grid
        try {
            boolean itemOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemOne == true) {
                System.out.println("Added Items Found");
                String upcOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcOne + " - " + itemNameOne);
            }
            boolean itemTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemTwo == true) {
                System.out.println("Added Items Found");
                String upcTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcTwo + " - " + itemNameTwo);
            }
        } catch (Exception e) {
            System.out.println("No Items Found");
        }

        boolean deleteAllChck = driver.findElement(By.id("com.sof.retail:id/btnDeleteAll")).isDisplayed();
        System.out.println("Status is " + deleteAllChck + " for DeleteAll Button");
        boolean discardChck = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
        System.out.println("Status is " + discardChck + " for Discard Button");
        boolean sendCHck = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
        System.out.println("Status is " + sendCHck + " for Send Button");

        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(14000);

        //Scanning already added item again
        keys = "UPC List 2";
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(8000);

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(8000);

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean staticTxt = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        String staticTxtVale = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).getText();
        if (staticTxt == true) {
            System.out.println(staticTxtVale + " is displayed");
        }

        boolean gridChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout")).isDisplayed();
        System.out.println("Status is " + gridChck + " for Description & Result Grid");
        boolean sentDate = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        boolean sentBy = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        if (sentDate == true && sentBy == true) {
            System.out.println("Status is " + sentDate + " for Sent Date");
            System.out.println("Status is " + sentBy + " for Sent By");
            String sentDateValue = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
            String sentByValue = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).getText();
            System.out.println(sentDateValue);
            System.out.println(sentByValue);
        }

        boolean okBtnChck = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + okBtnChck + " for Ok Button");

        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
        Thread.sleep(2000);

        //Clicking ok
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(5000);

        //Closing App
        driver.closeApp();
    }

    public static void LabPrintRestDel() throws InterruptedException {
        testCase = 92;
        //Clicking Lable Printing
        MobileElement labPrint = (MobileElement) driver.findElementById("com.sof.retail:id/textViewItem");
        labPrint.click();
        Thread.sleep(2000);

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            if (restoreChck == true) {
                System.out.println("Restore found");
                System.out.println("______________");
                System.out.println(restoreTxt);
                System.out.println("______________");
                //Deleting the restore data
                System.out.println("Restoring Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Label Printing Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Label Printing";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Checking for items in grid
        try {
            boolean itemOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemOne == true) {
                System.out.println("Added Items Found");
                String upcOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcOne + " - " + itemNameOne);
            }
            boolean itemTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemTwo == true) {
                System.out.println("Added Items Found");
                String upcTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcTwo + " - " + itemNameTwo);
            }
        } catch (Exception e) {
            System.out.println("No Items Found");
        }

        //Swiping through an item

        TouchAction action1 = new TouchAction(driver);
        action1.press(PointOption.point(363, 308))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(164, 308)).release().perform();

        boolean delBtnChck = driver.findElement(By.id("com.sof.retail:id/lpItemDelete")).isDisplayed();
        System.out.println("Status is " + delBtnChck + " for Delete Button");
        boolean itemLookUpChck = driver.findElement(By.id("com.sof.retail:id/lpItemLookup")).isDisplayed();
        System.out.println("Status is " + itemLookUpChck + " for Item Look Up Button");

        //Deleting the added item
        MobileElement delBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
        delBtn.click();

        //Checking Whether item got deleted
        try {
            boolean itemTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemTwo == true) {
                System.out.println("Item still in the grid");
            }
        } catch (Exception e) {
            System.out.println("Item got deleted");
            Thread.sleep(2000);
        }

        action1.press(PointOption.point(367, 265))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(201, 265)).release().perform();

        delBtnChck = driver.findElement(By.id("com.sof.retail:id/lpItemDelete")).isDisplayed();
        System.out.println("Status is " + delBtnChck + " for Delete Button");
        itemLookUpChck = driver.findElement(By.id("com.sof.retail:id/lpItemLookup")).isDisplayed();
        System.out.println("Status is " + itemLookUpChck + " for Item Look Up Button");
        Thread.sleep(2000);

        //Clicking Item Lookup
        driver.findElement(By.id("com.sof.retail:id/lpItemLookup")).click();
        Thread.sleep(10000);

        //Item Information
        boolean itemInfoChck = driver.findElement(By.id("com.sof.retail:id/tvTitle")).isDisplayed();
        if (itemInfoChck == true) {
            String itemInfoTxt = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
            String itemNameTxt = driver.findElement(By.id("com.sof.retail:id/tvDesc")).getText();
            System.out.println(itemInfoTxt + " is visible for - " + itemNameTxt);
        }
        //Closing Lookup Screen
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(8000);

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean staticTxt = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        String staticTxtVale = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).getText();
        if (staticTxt == true) {
            System.out.println(staticTxtVale + " is displayed");
        }

        boolean gridChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout")).isDisplayed();
        System.out.println("Status is " + gridChck + " for Description & Result Grid");
        boolean sentDate = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        boolean sentBy = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        if (sentDate == true && sentBy == true) {
            System.out.println("Status is " + sentDate + " for Sent Date");
            System.out.println("Status is " + sentBy + " for Sent By");
            String sentDateValue = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
            String sentByValue = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).getText();
            System.out.println(sentDateValue);
            System.out.println(sentByValue);
        }

        boolean okBtnChck = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + okBtnChck + " for Ok Button");

        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
        Thread.sleep(2000);

        //Clicking ok
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(5000);

        //Closing App
        driver.closeApp();

    }

    public static void LabPrintDeleteAll() throws InterruptedException {
        testCase = 94;
        //Clicking Lable Printing
        MobileElement labPrint = (MobileElement) driver.findElementById("com.sof.retail:id/textViewItem");
        labPrint.click();
        Thread.sleep(2000);

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            if (restoreChck == true) {
                System.out.println("Restore found");
                System.out.println("______________");
                System.out.println(restoreTxt);
                System.out.println("______________");
                //Deleting the restore data
                System.out.println("Restoring Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Label Printing Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Label Printing";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Checking for items in grid
        try {
            boolean itemOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemOne == true) {
                System.out.println("Added Items Found");
                String upcOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcOne + " - " + itemNameOne);
            }
            boolean itemTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemTwo == true) {
                System.out.println("Added Items Found");
                String upcTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcTwo + " - " + itemNameTwo);
            }
        } catch (Exception e) {
            System.out.println("No Items Found");
        }

        //Clicking Delete All
        MobileElement deleteAllBtn = (MobileElement) driver.findElement(By.id("com.sof.retail:id/btnDeleteAll"));
        deleteAllBtn.click();

        boolean delAllWarning = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
        if (delAllWarning == true) {
            String removeAll = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String removeAllText = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(removeAll + " popup is displayed with messsage - ");
            System.out.println(removeAllText);
            boolean yesBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
            System.out.println("Status is " + yesBtn + " for Yes Button");
            boolean noBtn = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
            System.out.println("Status is " + noBtn + " for No Button");
            Thread.sleep(2000);

            //Clicking No
            driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
        }
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Label Printing";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Clicking Delete All again
        deleteAllBtn.click();
        delAllWarning = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
        if (delAllWarning == true) {
            String removeAll = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            System.out.println(removeAll + " popup is displayed again");
            boolean yesBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
            boolean noBtn = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
            if (yesBtn == true && noBtn == true) {
                System.out.println("Status is true for YES & NO Button");
            }
            Thread.sleep(2000);
            //Clicking yes
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        }
        //Checking whether Send & DeleteAll button got disabled
        boolean deleteAll = driver.findElement(By.id("com.sof.retail:id/btnDeleteAll")).getAttribute("enabled").equals("true");
        boolean send = driver.findElement(By.id("com.sof.retail:id/btnDeleteAll")).getAttribute("enabled").equals("true");

        if (deleteAll == true && send == true) {
            System.out.println("DELETE ALL & SEND is enabled");
        } else {
            System.out.println("DELETE ALL & SEND is disabled");
        }
        //Clicking Discard
        driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();

        //Back to Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);
    }

    public static void LabPrintDelRestore() throws InterruptedException {
        testCase = 96;
        keys = "UPC List 1";
        //Clicking Lable Printing
        MobileElement labPrint = (MobileElement) driver.findElementById("com.sof.retail:id/textViewItem");
        labPrint.click();
        Thread.sleep(2000);

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            if (restoreChck == true) {
                System.out.println("Restore found");
                System.out.println("______________");
                System.out.println(restoreTxt);
                System.out.println("______________");
                //Deleting the restore data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Label Printing Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Label Printing";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Checking whether Send & DeleteAll button got disabled
        boolean deleteAll = driver.findElement(By.id("com.sof.retail:id/btnDeleteAll")).getAttribute("enabled").equals("true");
        boolean send = driver.findElement(By.id("com.sof.retail:id/btnDeleteAll")).getAttribute("enabled").equals("true");

        if (deleteAll == true && send == true) {
            System.out.println("DELETE ALL & SEND is enabled");
        } else {
            System.out.println("DELETE ALL & SEND is disabled");
        }

        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(14000);

        try {
            boolean itemOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemOne == true) {
                System.out.println("Added Items Found");
                String upcOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameOne = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcOne + " - " + itemNameOne);

                //Checking whether Send & DeleteAll button got enabled
                deleteAll = driver.findElement(By.id("com.sof.retail:id/btnDeleteAll")).getAttribute("enabled").equals("true");
                send = driver.findElement(By.id("com.sof.retail:id/btnDeleteAll")).getAttribute("enabled").equals("true");

                if (deleteAll == true && send == true) {
                    System.out.println("DELETE ALL & SEND is enabled");
                } else {
                    System.out.println("DELETE ALL & SEND is disabled");
                }

            }
        } catch (Exception e) {
            System.out.println("No items got added");
        }

        //Adding another UPC
        keys = "UPC List 2";
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(8000);
        try {
            boolean itemTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (itemTwo == true) {
                System.out.println("Added Items Found");
                String upcTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String itemNameTwo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                System.out.println(upcTwo + " - " + itemNameTwo);
            }
        } catch (Exception e) {
            System.out.println("No Item got Found");
        }

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(8000);

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean staticTxt = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        String staticTxtVale = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).getText();
        if (staticTxt == true) {
            System.out.println(staticTxtVale + " is displayed");
        }

        boolean gridChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout")).isDisplayed();
        System.out.println("Status is " + gridChck + " for Description & Result Grid");
        boolean sentDate = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        boolean sentBy = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        if (sentDate == true && sentBy == true) {
            System.out.println("Status is " + sentDate + " for Sent Date");
            System.out.println("Status is " + sentBy + " for Sent By");
            String sentDateValue = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
            String sentByValue = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).getText();
            System.out.println(sentDateValue);
            System.out.println(sentByValue);
        }

        boolean okBtnChck = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + okBtnChck + " for Ok Button");

        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
        Thread.sleep(2000);

        //Clicking ok
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(5000);

        //Closing App
        driver.closeApp();
    }
    }