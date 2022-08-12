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

public class StoreTransferOutPage {
    static int testCase;
    static String keys = null;
    static String actualText;
    static String expectedText;
    static String transNum;
    static int sum = 0;
    static int n;
    static AndroidDriver<AndroidElement> driver;

    public StoreTransferOutPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void TransfersClick() throws InterruptedException {
        //clicking on Transfers
        MobileElement transfersClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout");
        transfersClick.click();
        Thread.sleep(3000);
    }

    public static void StoreTransferOutClick() throws InterruptedException {
        //Clicking on Store Transfer Out
        MobileElement storeTransOut = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        storeTransOut.click();
        Thread.sleep(3000);
    }

    public static void StoreTransferOutScanVerify() throws InterruptedException {
        testCase = 116;

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (restoreChck == true) {
                System.out.println("Restore found");
                String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(restoreTxt);
                boolean restoreBtnChck = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                System.out.println("Status is " + restoreBtnChck + " for Restore Button");
                boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " + deleteBtn + " for Delete Button");
                //Restoring the data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Store Transfer Out Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Store Transfer Out";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Clicking NEXT Button
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

        boolean selStorePopUp = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
        if (selStorePopUp == true) {
            String selectStore = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String selectStoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(selectStore + " Warning is displayed");
            System.out.println(selectStoreTxt);
            //Clicking Ok'
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        }

        MobileElement supplyClck = (MobileElement) driver.findElementById("com.sof.retail:id/sourceSupplyRadioBtn");
        supplyClck.click();

        keys = "Destination";
        MobileElement storeDrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerStore");
        storeDrpdwnClick.click();
        storeDrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(153, 352)).perform();
        Thread.sleep(2000);

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
        Thread.sleep(4000);

        //Scan Items
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Scan Items";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean upcField = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isDisplayed();
        System.out.println("Status is " + upcField + " for UPC Field");
        boolean noCodeBtn = driver.findElement(By.id("com.sof.retail:id/imageButton")).isDisplayed();
        System.out.println("Status is " + noCodeBtn + " for No Code Button");

        try {
            //Checking whether Item Description is enabled
            boolean itemDescLink = driver.findElement(By.id("com.sof.retail:id/linkDesc")).getAttribute("enabled").equals("true");
            if (itemDescLink == true) {
                System.out.println("Item Description is enabled");
            } else {
                System.out.println("Item Description is not enabled");
            }
        } catch (Exception e) {
            System.out.println("Item Description Link is not visible");
        }

        boolean uom = driver.findElement(By.id("com.sof.retail:id/uomText")).isDisplayed();
        System.out.println("Status is " + uom + " for UOM");
        boolean deptDrpdwn = driver.findElement(By.id("com.sof.retail:id/tvCategory")).isDisplayed();
        System.out.println("Status is " + deptDrpdwn + " for Department Dropdown");
        boolean unitCost = driver.findElement(By.id("com.sof.retail:id/unitCost")).isDisplayed();
        System.out.println("Status is " + unitCost + " for Unit Cost");
        boolean extCost = driver.findElement(By.id("com.sof.retail:id/extCost")).isDisplayed();
        System.out.println("Status is " + extCost + " for Ext Cost");
        boolean overExtCost = driver.findElement(By.id("com.sof.retail:id/overrideExtCost")).isDisplayed();
        System.out.println("Status is " + overExtCost + " for Override Ext Cost");
        boolean desc = driver.findElement(By.id("com.sof.retail:id/descriptionText")).isDisplayed();
        System.out.println("Status is " + desc + " for Description");
        boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyText")).isDisplayed();
        System.out.println("Status is " + qty + " for Qty");

        boolean total = driver.findElement(By.id("com.sof.retail:id/totalText")).isDisplayed();
        if (total == true) {
            String totalValue = driver.findElement(By.id("com.sof.retail:id/totalCost")).getText();
            System.out.println("Status is " + total + " for Total");
            System.out.println("Total - " + totalValue);
        }

        try {
            //Checking whether Delete Button is enabled
            boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).getAttribute("enabled").equals("true");
            if (deleteBtn == true) {
                System.out.println("Delete Button is enabled");
            } else {
                System.out.println("Delete Button is not enabled");
            }
        } catch (Exception e) {
            System.out.println("Delete Button is not visible");
        }

        boolean backBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + backBtn + " for Back Button");
        boolean NextBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + backBtn + " for Next Button");

        //Entering Invalid UPC
        keys = "UPC 1";
        MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upcScan.click();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(7000);

        boolean enterItemInfo = driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogTitleTextView")).isDisplayed();
        if (enterItemInfo == true) {
            String enterItemInfoTxt = driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogTitleTextView")).getText();
            System.out.println(enterItemInfoTxt + " is displayed");
            //Clicking CANCEL
            driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogCancelButton")).click();
            Thread.sleep(3000);
        }

        keys = "UPC 2";
        upcScan.click();
        upcScan.clear();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(8000);

        try {
            boolean itemDescLink = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
            if (itemDescLink == true) {
                System.out.println("Item got added");

                String uomValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                String deptValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                String unitCostValue = driver.findElement(By.id("com.sof.retail:id/unitCost")).getText();
                String extCostValue = driver.findElement(By.id("com.sof.retail:id/extCost")).getText();
                String overrideExtCostValue = driver.findElement(By.id("com.sof.retail:id/overrideExtCost")).getText();

                System.out.println("UOM - " + uomValue);
                System.out.println("Department - " + deptValue);
                System.out.println("Unit Cost - " + unitCostValue);
                System.out.println("Ext Cost - " + extCostValue);
                System.out.println("Override Ext Cost - " + overrideExtCostValue);
            }
        } catch (Exception e) {
            System.out.println("Item not added");
        }

        //Swiping through item
        TouchAction action1 = new TouchAction(driver);
        action1.press(PointOption.point(254, 414))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(117, 414)).release().perform();

        boolean delBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + delBtn + " for Delete Button");
        Thread.sleep(2000);

        action1.press(PointOption.point(117, 414))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(254, 414)).release().perform();

        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        boolean itemQty = driver.findElement(By.id("com.sof.retail:id/quantityValue")).isDisplayed();
        if (itemDesc == true && itemQty == true) {
            String itemDescTxt = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
            String itemQtyTxt = driver.findElement(By.id("com.sof.retail:id/quantityValue")).getText();
            System.out.println("Item Description - " + itemDescTxt);
            System.out.println("Item Qty - " + itemQtyTxt);
        }

        //Clicking No Code Button
        driver.findElement(By.id("com.sof.retail:id/imageButton")).click();
        boolean cantScan = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
        if (cantScan == true) {
            String cantScanTxt = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            System.out.println(cantScanTxt + " is displayed");

            boolean okBtn = driver.findElement(By.id("com.sof.retail:id/dialogOkButton")).isDisplayed();
            System.out.println("Status is " + okBtn + " for Ok Button");
            boolean cancelBtn = driver.findElement(By.id("com.sof.retail:id/dialogCancelButton")).isDisplayed();
            System.out.println("Status is " + cancelBtn + " for Cancel Button");

            //Clicking Cancel
            driver.findElement(By.id("com.sof.retail:id/dialogCancelButton")).click();
        }

        //Scan Items
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Scan Items";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Clicking No Code Button again
        driver.findElement(By.id("com.sof.retail:id/imageButton")).click();
        boolean cantScanChck = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
        if (cantScanChck == true) {
            String cantScanTxt = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            System.out.println(cantScanTxt + " is displayed");

            //Entering item description
            MobileElement scanItem = (MobileElement) driver.findElementById("com.sof.retail:id/dialogEditText");
            scanItem.sendKeys("Bake Shop - Strawberry Shortcake, 1 Each");
            driver.findElement(By.id("com.sof.retail:id/dialogOkButton")).click();

            boolean itemAddedDesc = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
            if (itemAddedDesc == true) {
                String itemAdded = driver.findElement(By.id("com.sof.retail:id/linkDesc")).getText();
                System.out.println(itemAdded + " got added to the grid");
            }

        }

        keys = "UPC 3";
        upcScan.click();
        upcScan.clear();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(8000);

        keys = "Cost Per Unit";
        enterItemInfo = driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogTitleTextView")).isDisplayed();
        if (enterItemInfo == true) {
            String enterItemInfoTxt = driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogTitleTextView")).getText();
            System.out.println(enterItemInfoTxt + " is displayed");

            MobileElement cpu = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogEditText");
            cpu.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            action.sendKeys(Keys.ENTER).perform();

            keys = "Department";
            MobileElement deptSel = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogSpinner");
            deptSel.click();
            deptSel.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Thread.sleep(1000);
            //Tapping value
            act.tap(PointOption.point(274, 370)).perform();
            Thread.sleep(2000);
            //Clicking Ok
            driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogOkButton")).click();
            Thread.sleep(2000);

            try {
                boolean itemDescLink = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
                if (itemDescLink == true) {
                    System.out.println("Item got added");

                    String uomValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                    String deptValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                    String unitCostValue = driver.findElement(By.id("com.sof.retail:id/unitCost")).getText();
                    String extCostValue = driver.findElement(By.id("com.sof.retail:id/extCost")).getText();
                    String overrideExtCostValue = driver.findElement(By.id("com.sof.retail:id/overrideExtCost")).getText();

                    System.out.println("UOM - " + uomValue);
                    System.out.println("Department - " + deptValue);
                    System.out.println("Unit Cost - " + unitCostValue);
                    System.out.println("Ext Cost - " + extCostValue);
                    System.out.println("Override Ext Cost - " + overrideExtCostValue);
                }
            } catch (Exception e) {
                System.out.println("Item not added");
            }
        }

        //Closing app
        driver.closeApp();
        driver.quit();
    }

    public static void StoreTransferOutInventory() throws InterruptedException {
        testCase = 118;

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (restoreChck == true) {
                System.out.println("Restore found");
                String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(restoreTxt);
                boolean restoreBtnChck = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                System.out.println("Status is " + restoreBtnChck + " for Restore Button");
                boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " + deleteBtn + " for Delete Button");
                //Restoring the data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Store Transfer Out Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Store Transfer Out";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        MobileElement InvClck = (MobileElement) driver.findElementById("com.sof.retail:id/sourceInventoryRadioBtn");
        InvClck.click();

        keys = "Destination";
        MobileElement storeDrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerStore");
        storeDrpdwnClick.click();
        storeDrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(153, 352)).perform();
        Thread.sleep(2000);

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
        Thread.sleep(4000);

        //Scan Items
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Scan Items";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        keys = "UPC 1";
        MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upcScan.click();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(8000);

        try {
            boolean itemDescLink = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
            if (itemDescLink == true) {
                System.out.println("Item got added");

                String uomValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                String deptValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                String unitCostValue = driver.findElement(By.id("com.sof.retail:id/unitCost")).getText();
                String extCostValue = driver.findElement(By.id("com.sof.retail:id/extCost")).getText();
                String overrideExtCostValue = driver.findElement(By.id("com.sof.retail:id/overrideExtCost")).getText();

                System.out.println("UOM - " + uomValue);
                System.out.println("Department - " + deptValue);
                System.out.println("Unit Cost - " + unitCostValue);
                System.out.println("Ext Cost - " + extCostValue);
                System.out.println("Override Ext Cost - " + overrideExtCostValue);
            }
        } catch (Exception e) {
            System.out.println("Item not added");
        }

        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        boolean itemQty = driver.findElement(By.id("com.sof.retail:id/quantityValue")).isDisplayed();
        if (itemDesc == true && itemQty == true) {
            String itemDescTxt = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
            String itemQtyTxt = driver.findElement(By.id("com.sof.retail:id/quantityValue")).getText();
            System.out.println("Item Description - " + itemDescTxt);
            System.out.println("Item Qty - " + itemQtyTxt);
        }

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Confirm Total Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Confirm Total";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean initTotCost = driver.findElement(By.id("com.sof.retail:id/initialTextView")).isDisplayed();
        if(initTotCost==true) {
            String initTotalCst = driver.findElement(By.id("com.sof.retail:id/initialTextView")).getText();
            String initTotalCstValue = driver.findElement(By.id("com.sof.retail:id/initialTextValue")).getText();
            System.out.println(initTotalCst +" - " +initTotalCstValue);
        }
        boolean totalAdj = driver.findElement(By.id("com.sof.retail:id/totalAdjustTextView")).isDisplayed();
        if(totalAdj==true) {
            String totAdj = driver.findElement(By.id("com.sof.retail:id/totalAdjustTextView")).getText();
            String totAdjValue = driver.findElement(By.id("com.sof.retail:id/totalAdjustTextValue")).getText();
            System.out.println(totAdj +" - " +totAdjValue);
        }
        boolean finTotCost = driver.findElement(By.id("com.sof.retail:id/finalTotalTextView")).isDisplayed();
        if(finTotCost==true) {
            String finTotalCst = driver.findElement(By.id("com.sof.retail:id/finalTotalTextView")).getText();
            String finTotalCstValue = driver.findElement(By.id("com.sof.retail:id/finalTotalTextValue")).getText();
            System.out.println(finTotalCst +" - " +finTotalCstValue);
        }

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();

        //Comments Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Comments";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering Comments
        keys = "Comments";
        MobileElement cmntEnter = (MobileElement) driver.findElementById("com.sof.retail:id/etComment");
        cmntEnter.click();
        cmntEnter.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean srcDept = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
        if(srcDept==true) {
            String srcDeptTxt = driver.findElement(By.id("com.sof.retail:id/sourceDeptText")).getText();
            System.out.println("Source Department - " +srcDeptTxt);
        }
        boolean total = driver.findElement(By.id("com.sof.retail:id/totalTextView")).isDisplayed();
        if(total==true) {
            String totalTxt = driver.findElement(By.id("com.sof.retail:id/sourceDeptCountText")).getText();
            System.out.println("Total - " +totalTxt);
        }
        boolean desc = driver.findElement(By.id("com.sof.retail:id/descpText")).isDisplayed();
        if(desc==true) {
            String descTxt = driver.findElement(By.id("com.sof.retail:id/descpText")).getText();
            System.out.println("Description - " +descTxt);
        }
        boolean qty = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        if(qty==true) {
            String qtyTxt = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            System.out.println("Qty - " +qtyTxt);
        }

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(12000);

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean descChck = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        if(descChck==true) {
            String descTxt = driver.findElement(By.id("com.sof.retail:id/descText")).getText();
            System.out.println("Description - " +descTxt);
        }
        boolean confrmNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        if(confrmNum==true) {
            String confrmNumTxt = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            System.out.println("Confirmation Number - " +confrmNumTxt);
        }

        //Clicking Transaction
        try {
            driver.findElement(By.id("com.sof.retail:id/transactionItmRowDescription")).click();
            Thread.sleep(4000);
            String transId = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            String transDesc = driver.findElement(By.id("com.sof.retail:id/dialogContentView")).getText();
            System.out.println(transId);
            System.out.println(transDesc);
            //Clicking oK
            driver.findElement(By.id("com.sof.retail:id/dialogOkButton")).click();
        }
        catch (Exception e) {
            System.out.println("Transaction details not available");
        }

        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
        Thread.sleep(2000);

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void StoreTransferOutSupply() throws InterruptedException {
        testCase = 120;

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (restoreChck == true) {
                System.out.println("Restore found");
                String restoreTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(restoreTxt);
                boolean restoreBtnChck = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                System.out.println("Status is " + restoreBtnChck + " for Restore Button");
                boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Status is " + deleteBtn + " for Delete Button");
                //Restoring the data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Store Transfer Out Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Store Transfer Out";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        MobileElement supplyClck = (MobileElement) driver.findElementById("com.sof.retail:id/sourceSupplyRadioBtn");
        supplyClck.click();

        keys = "Destination";
        MobileElement storeDrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerStore");
        storeDrpdwnClick.click();
        storeDrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(153, 352)).perform();
        Thread.sleep(2000);

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
        Thread.sleep(4000);

        //Scan Items
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Scan Items";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        keys = "UPC 1";
        MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upcScan.click();
        upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(8000);

        try {
            boolean itemDescLink = driver.findElement(By.id("com.sof.retail:id/linkDesc")).isDisplayed();
            if (itemDescLink == true) {
                System.out.println("Item got added");

                String uomValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                String deptValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
                String unitCostValue = driver.findElement(By.id("com.sof.retail:id/unitCost")).getText();
                String extCostValue = driver.findElement(By.id("com.sof.retail:id/extCost")).getText();
                String overrideExtCostValue = driver.findElement(By.id("com.sof.retail:id/overrideExtCost")).getText();

                System.out.println("UOM - " + uomValue);
                System.out.println("Department - " + deptValue);
                System.out.println("Unit Cost - " + unitCostValue);
                System.out.println("Ext Cost - " + extCostValue);
                System.out.println("Override Ext Cost - " + overrideExtCostValue);
            }
        } catch (Exception e) {
            System.out.println("Item not added");
        }

        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        boolean itemQty = driver.findElement(By.id("com.sof.retail:id/quantityValue")).isDisplayed();
        if (itemDesc == true && itemQty == true) {
            String itemDescTxt = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
            String itemQtyTxt = driver.findElement(By.id("com.sof.retail:id/quantityValue")).getText();
            System.out.println("Item Description - " + itemDescTxt);
            System.out.println("Item Qty - " + itemQtyTxt);
        }

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Confirm Total Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Confirm Total";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean initTotCost = driver.findElement(By.id("com.sof.retail:id/initialTextView")).isDisplayed();
        if(initTotCost==true) {
            String initTotalCst = driver.findElement(By.id("com.sof.retail:id/initialTextView")).getText();
            String initTotalCstValue = driver.findElement(By.id("com.sof.retail:id/initialTextValue")).getText();
            System.out.println(initTotalCst +" - " +initTotalCstValue);
        }
        boolean totalAdj = driver.findElement(By.id("com.sof.retail:id/totalAdjustTextView")).isDisplayed();
        if(totalAdj==true) {
            String totAdj = driver.findElement(By.id("com.sof.retail:id/totalAdjustTextView")).getText();
            String totAdjValue = driver.findElement(By.id("com.sof.retail:id/totalAdjustTextValue")).getText();
            System.out.println(totAdj +" - " +totAdjValue);
        }
        boolean finTotCost = driver.findElement(By.id("com.sof.retail:id/finalTotalTextView")).isDisplayed();
        if(finTotCost==true) {
            String finTotalCst = driver.findElement(By.id("com.sof.retail:id/finalTotalTextView")).getText();
            String finTotalCstValue = driver.findElement(By.id("com.sof.retail:id/finalTotalTextValue")).getText();
            System.out.println(finTotalCst +" - " +finTotalCstValue);
        }

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();

        //Comments Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Comments";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering Comments
        keys = "Comments";
        MobileElement cmntEnter = (MobileElement) driver.findElementById("com.sof.retail:id/etComment");
        cmntEnter.click();
        cmntEnter.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean srcDept = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
        if(srcDept==true) {
            String srcDeptTxt = driver.findElement(By.id("com.sof.retail:id/sourceDeptText")).getText();
            System.out.println("Source Department - " +srcDeptTxt);
        }
        boolean total = driver.findElement(By.id("com.sof.retail:id/totalTextView")).isDisplayed();
        if(total==true) {
            String totalTxt = driver.findElement(By.id("com.sof.retail:id/sourceDeptCountText")).getText();
            System.out.println("Total - " +totalTxt);
        }
        boolean desc = driver.findElement(By.id("com.sof.retail:id/descpText")).isDisplayed();
        if(desc==true) {
            String descTxt = driver.findElement(By.id("com.sof.retail:id/descpText")).getText();
            System.out.println("Description - " +descTxt);
        }
        boolean qty = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        if(qty==true) {
            String qtyTxt = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            System.out.println("Qty - " +qtyTxt);
        }

        //Clicking Send
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(12000);

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean descChck = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        if(descChck==true) {
            String descTxt = driver.findElement(By.id("com.sof.retail:id/descText")).getText();
            System.out.println("Description - " +descTxt);
        }
        boolean confrmNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        if(confrmNum==true) {
            String confrmNumTxt = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            System.out.println("Confirmation Number - " +confrmNumTxt);
        }

        //Clicking Transaction
        try {
            driver.findElement(By.id("com.sof.retail:id/transactionItmRowDescription")).click();
            Thread.sleep(4000);
            String transId = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            String transDesc = driver.findElement(By.id("com.sof.retail:id/dialogContentView")).getText();
            System.out.println(transId);
            System.out.println(transDesc);
            //Clicking oK
            driver.findElement(By.id("com.sof.retail:id/dialogOkButton")).click();
        }
        catch (Exception e) {
            System.out.println("Transaction details not available");
        }

        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
        Thread.sleep(2000);

        //Closing App
        driver.closeApp();
        driver.quit();
    }

}
