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
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class CAOOrderPage {
    static int testCase;
    static String keys;
    static String actualText;
    static String orderTotal = "0";
    static String expectedText;
    static AndroidDriver<AndroidElement> driver;

    public CAOOrderPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void orderClick() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.sof.retail:id/toolBarHeader")));

        //Swiping Down
        Thread.sleep(10000);
        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(257, 392))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(257, 197)).release().perform();

        //Clicking on Orders
        MobileElement orderClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.view.ViewGroup");
        orderClick.click();
    }

    public static void CAOOrderClick() throws InterruptedException {
        MobileElement CAOOrderClck = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        CAOOrderClck.click();
        Thread.sleep(6000);
    }

    public static void CAOOrderUiVerify() throws InterruptedException {
        testCase = 98;
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
        Thread.sleep(4000);

        //CAO Order
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "CAO Order";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean orderHeadingChck = driver.findElement(By.id("com.sof.retail:id/purchaseOrderHeading")).isDisplayed();
        if (orderHeadingChck == true) {
            String orderHead = driver.findElement(By.id("com.sof.retail:id/purchaseOrderHeading")).getText();
            System.out.println(orderHead + " is visible");
        }

        try {
            boolean reviewChck = driver.findElement(By.id("com.sof.retail:id/btnReceive")).isDisplayed();
            if (reviewChck == true) {
                System.out.println("Order for review is available");
            }

            //Verifying CAOOrder UI
            boolean aisleChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
            if (aisleChck == true) {
                System.out.println("Status is " + aisleChck + " for Aisle/Store");
            }
            boolean dueDateChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")).isDisplayed();
            if (dueDateChck == true) {
                System.out.println("Status is " + dueDateChck + " for Due Date");
                String dueDate = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")).getText();
                System.out.println("Due Date - " + dueDate);
            }
            boolean itemsNumChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]")).isDisplayed();
            if (itemsNumChck == true) {
                System.out.println("Status is " + itemsNumChck + " for Items Count");
                String itemCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
                System.out.println("Number of items - " + itemCount);
            }
            boolean pieceCountChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]")).isDisplayed();
            if (pieceCountChck == true) {
                System.out.println("Status is " + pieceCountChck + " for Piece Count");
                String pieceCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
                System.out.println("Number of pieces - " + pieceCount);
            }
            boolean timeRemChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]")).isDisplayed();
            if (timeRemChck == true) {
                System.out.println("Status is " + timeRemChck + " for Time Remaining");
                String timeRem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]")).getText();
                System.out.println("Time Remaining - " + timeRem);
            }
            orderTotal = driver.findElement(By.id("com.sof.retail:id/daysTextView")).getText();

        } catch (Exception e) {
            String noOrder = driver.findElement(By.id("com.sof.retail:id/caoOrderNoData")).getText();
            System.out.println(noOrder);
        }

        boolean revUnavailChckbox = driver.findElement(By.id("com.sof.retail:id/cbReceivedPo")).isDisplayed();
        if (revUnavailChckbox == true) {
            System.out.println("Reviewed/Unavailable Checkbox is visible");
        }

        //Clicking Reviewed/Unavailable Checkbox
        driver.findElement(By.id("com.sof.retail:id/cbReceivedPo")).click();
        Thread.sleep(2000);

        try {
            String updatedOrderTotal = driver.findElement(By.id("com.sof.retail:id/daysTextView")).getText();

            try {
                if (orderTotal.equals(updatedOrderTotal)) {
                    System.out.println("No Orders got added");
                } else {
                    System.out.println("Reviewed Orders got added to the list");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        catch (Exception e) {
            System.out.println("Order Count not visible");
        }

        //Pulling down to refresh
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(266, 141))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(266, 365)).release().perform();
        Thread.sleep(3000);

        //Clicking DIscard
        driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
        Thread.sleep(4000);

        //Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        try {
            boolean Storeorders = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.TextView")).isDisplayed();
            boolean dsdOrders = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView")).isDisplayed();
            if (Storeorders == true && dsdOrders == true) {
                System.out.println("Different Orders is visible");
            }
        } catch (Exception e) {
            System.out.println("Different Orders not visible");
        }

        //Closing App
        driver.closeApp();
        driver.quit();

    }

    public static void CAOOrderBadgeVerify() {
        testCase = 126;

        try {
            String caoOrderBadgeCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView")).getText();
            try {
                //Selecting CAO Order
                MobileElement caoOrderClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
                caoOrderClick.click();
                Thread.sleep(4000);

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
                Thread.sleep(4000);

                //Storing count of CAO Order
                String availCAOOrder = driver.findElement(By.id("com.sof.retail:id/daysTextView")).getText();

                //Checking CAO Order with available
                if (availCAOOrder.contains(caoOrderBadgeCount)) {
                    System.out.println("Badge Count is matching");
                    System.out.println("Badge count - " + caoOrderBadgeCount);
                    System.out.println("CAO Order Count - " + availCAOOrder);
                } else {
                    System.out.println("Badge Mismatch");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println("CAO Order is empty");
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void CAOOrderReviewOrderVerify() throws InterruptedException, IOException {
        testCase = 128;
        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if (restoreChck == true) {
                System.out.println("Restore found");
                //Deleting the restore data
                System.out.println("Deleting Previous Session Data");
                Thread.sleep(3000);
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }
        } catch (Exception e) {
            System.out.println("No restore is found");
        }
        Thread.sleep(4000);

        //CAO Order
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "CAO Order";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean orderHeadingChck = driver.findElement(By.id("com.sof.retail:id/purchaseOrderHeading")).isDisplayed();
        if (orderHeadingChck == true) {
            String orderHead = driver.findElement(By.id("com.sof.retail:id/purchaseOrderHeading")).getText();
            System.out.println(orderHead + " is visible");
        }

        try {
            boolean reviewChck = driver.findElement(By.id("com.sof.retail:id/btnReceive")).isDisplayed();
            if (reviewChck == true) {
                System.out.println("Order for review is available");
            }
            //Clicking Review
            MobileElement reviewClick = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
            reviewClick.click();
            Thread.sleep(1000);
            try {
                String genOrder = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                String genOrderTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(genOrder);
                System.out.println(genOrderTxt);
                Thread.sleep(13000);
            } catch (Exception e) {
                System.out.println(e);
            }

            //Scan Items
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Scan Items";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            //Verifying Page Contents
            boolean upc = driver.findElement(By.id("com.sof.retail:id/upcText")).isDisplayed();
            System.out.println("Status is " + upc + " for UPC Icon");
            boolean upcBox = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isDisplayed();
            System.out.println("Status is " + upcBox + " for UPC Box");
            boolean printIcon = driver.findElement(By.id("com.sof.retail:id/imageButton")).isDisplayed();
            System.out.println("Status is " + printIcon + " for Printer Icon");

            boolean forecast = driver.findElement(By.id("com.sof.retail:id/frcstTextView")).isDisplayed();
            String forecastValue = driver.findElement(By.id("com.sof.retail:id/frcstTextValue")).getText();
            System.out.println("Status is " + forecast + " for Forecast, Forecast Value - " + forecastValue);
            boolean last = driver.findElement(By.id("com.sof.retail:id/lastTextView")).isDisplayed();
            String lastValue = driver.findElement(By.id("com.sof.retail:id/lastTextValue")).getText();
            System.out.println("Status is " + last + " for Last, Last Value - " + lastValue);
            boolean loc = driver.findElement(By.id("com.sof.retail:id/locTextView")).isDisplayed();
            String locValue = driver.findElement(By.id("com.sof.retail:id/locTextValue")).getText();
            System.out.println("Status is " + loc + " for Loc, Loc - " + locValue);
            boolean boh = driver.findElement(By.id("com.sof.retail:id/bohTextView")).isDisplayed();
            String bohValue = driver.findElement(By.id("com.sof.retail:id/bohTextValue")).getText();
            System.out.println("Status is " + boh + " for BOH, BOH - " + bohValue);
            boolean min = driver.findElement(By.id("com.sof.retail:id/minTextView")).isDisplayed();
            String minValueText = driver.findElement(By.id("com.sof.retail:id/minTextValue")).getText();
            System.out.println("Status is " + min + " for Min, Min Value - " + minValueText);
            boolean sug = driver.findElement(By.id("com.sof.retail:id/suggTextView")).isDisplayed();
            String sugValue = driver.findElement(By.id("com.sof.retail:id/buttonSugg")).getText();
            System.out.println("Status is " + sug + " for Suggested Quantity, Sug Value - " + sugValue);
            boolean cost = driver.findElement(By.id("com.sof.retail:id/costTextView")).isDisplayed();
            String costValue = driver.findElement(By.id("com.sof.retail:id/costTextValue")).getText();
            System.out.println("Status is " + cost + " for Cost, Cost - " + costValue);
            boolean inTransit = driver.findElement(By.id("com.sof.retail:id/inTranstitTextView")).isDisplayed();
            String inTransitValue = driver.findElement(By.id("com.sof.retail:id/inTranstitTextValue")).getText();
            System.out.println("Status is " + inTransit + " for In Transit, In Transit - " + inTransitValue);

            boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
            String itemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
            String pack = driver.findElement(By.id("com.sof.retail:id/invValue")).getText();
            String qty = driver.findElement(By.id("com.sof.retail:id/recvValue")).getText();
            System.out.println("Description Status is " + itemDesc);
            System.out.println(itemDescName + " is Displayed with Pack - " + pack + " & Qty - " + qty);

            boolean itemDrpdown = driver.findElement(By.id("com.sof.retail:id/showDropDown")).isDisplayed();
            System.out.println("Status is " + itemDrpdown + " for Item Dropdown");

            boolean pieceCount = driver.findElement(By.id("com.sof.retail:id/pieceCountTxt")).isDisplayed();
            String pieceCountValue = driver.findElement(By.id("com.sof.retail:id/pieceCountVal")).getText();
            System.out.println("Status is " + pieceCount + " for Piece Count, Piece Count - " + pieceCountValue);

            boolean total = driver.findElement(By.id("com.sof.retail:id/totalCountTxt")).isDisplayed();
            String totalValue = driver.findElement(By.id("com.sof.retail:id/totalCountValue")).getText();
            System.out.println("Status is " + total + " for Total, Total - " + totalValue);

            boolean item = driver.findElement(By.id("com.sof.retail:id/hcItemsCount")).isDisplayed();
            String itemValue = driver.findElement(By.id("com.sof.retail:id/hcItemsCount")).getText();
            System.out.println("Status is " + item + " for Item, " + itemValue);

            boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
            System.out.println("Status is " + nextBtn + " for Next Button");
            boolean discardBtn = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
            System.out.println("Status is " + discardBtn + " for Discard Button");

            //Adding Invalid UPC
            keys = "UPC List 1";
            MobileElement upcScan = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
            upcScan.clear();
            upcScan.click();
            upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(14000);

            //Checking For Error Message
            try {
                boolean errorMsg = driver.findElement(By.id("com.sof.retail:id/dialog_message")).isDisplayed();
                String errorMsgTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                if (errorMsg == true) {
                    System.out.println(errorMsgTxt + " - Error Message Is Displayed");
                }
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            } catch (Exception e) {
                System.out.println("No Error Displayed");
            }

            //Adding Valid UPC
            keys = "UPC List 2";
            upcScan.click();
            upcScan.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(12000);

            try {
                boolean errorMsg = driver.findElement(By.id("com.sof.retail:id/dialog_message")).isDisplayed();
                String errorMsgTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                if (errorMsg == true) {
                    System.out.println(errorMsgTxt + " - Error Message Is Displayed");
                }
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            } catch (Exception e) {
                System.out.println("No Error Displayed");
                //Checking product details of scanned item
                boolean addedItemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
                String addedItemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
                String packSize = driver.findElement(By.id("com.sof.retail:id/invValue")).getText();
                String qtyCount = driver.findElement(By.id("com.sof.retail:id/recvValue")).getText();
                System.out.println("Description Status is " + addedItemDesc);
                System.out.println(addedItemDescName + " is Displayed with Pack - " + packSize + " & Qty - " + qtyCount);
            }

            //Clicking on item hyperlink
            driver.findElement(By.id("com.sof.retail:id/textItemIdUnderlined")).click();

            //Product details pop up
            String itemInfo = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            System.out.println(itemInfo + " is Displayed");

            //Printing Item Details
            String itemName = driver.findElement(By.id("com.sof.retail:id/dialogItemDescTitleValue")).getText();
            String upcNumber = driver.findElement(By.id("com.sof.retail:id/offerPriceVal")).getText();
            String deptName = driver.findElement(By.id("com.sof.retail:id/regularPriceVal")).getText();
            String packSze = driver.findElement(By.id("com.sof.retail:id/pointsVal")).getText();
            String sizeCount = driver.findElement(By.id("com.sof.retail:id/startVal")).getText();
            String category = driver.findElement(By.id("com.sof.retail:id/endVal")).getText();

            System.out.println("-------------");
            System.out.println("Item Name - " + itemName);
            System.out.println("UPC - " + upcNumber);
            System.out.println("Department - " + deptName);
            System.out.println("Pack - " + packSze);
            System.out.println("Size - " + sizeCount);
            System.out.println("Category - " + category);
            System.out.println("-------------");

            //Clicking on Ok
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();

            //Clicking on Printer Icon
            driver.findElement(By.id("com.sof.retail:id/imageButton")).click();

            //Label Request
            String labelReq = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            System.out.println(labelReq + " Text Box Is Displayed");
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

            //Checking Whether te user is taken back to Store Order Screen
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Scan Items";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            //Clicking on Forecast
            driver.findElement(By.id("com.sof.retail:id/frcstTextValue")).click();
            Thread.sleep(9000);
            String forecastTapData = driver.findElement(By.id("com.sof.retail:id/textTitle")).getText();
            System.out.println(forecastTapData + " is Displayed");
            //Screenshot the Forecast Page
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileName = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\128_Week_Sales_History" + ".jpg";
            FileUtils.copyFile(file, new File(fileName));
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();

            //Clicking on Last
            driver.findElement(By.id("com.sof.retail:id/lastTextValue")).click();
            Thread.sleep(4000);
            String lastTapData = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            String lastTapItemName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")).getText();
            System.out.println(lastTapData + " for - " + lastTapItemName + " is Displayed");
            //Screenshot the Inventory History
            File fileLast = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileNameLast = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\128_Inventory_History" + ".jpg";
            FileUtils.copyFile(fileLast, new File(fileNameLast));
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

            //Clicking on Loc
            driver.findElement(By.id("com.sof.retail:id/locTextValue")).click();
            Thread.sleep(4000);
            try {
                String errorMsg = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
                System.out.println(errorMsg + " Message Box Is Displayed");
                String errorReason = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println("Error Reason - " + errorReason);
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            } catch (Exception e) {
                System.out.println("Loc Data is Visible");
                String itemLoc = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
                String itemLocName = driver.findElement(By.id("com.sof.retail:id/spinnerTextView")).getText();
                System.out.println(itemLoc + " - " + itemLocName);
                //Screenshot the Item Location
                File fileLoc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String fileNameLoc = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\128_Item_Location" + ".jpg";
                FileUtils.copyFile(fileLoc, new File(fileNameLoc));
                driver.findElement(By.id("com.sof.retail:id/okButton")).click();
            }

            //Clicking on Ellipse
            driver.findElement(By.id("com.sof.retail:id/dotText")).click();
            Thread.sleep(6000);
            String popMsg = driver.findElement(By.id("com.sof.retail:id/textTitle")).getText();
            System.out.println(popMsg + " Pop Up is Displayed");
            //Screenshot the Item Location
            File fileLoc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileNameLoc = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\128_MinimumShelfInventory" + ".jpg";
            FileUtils.copyFile(fileLoc, new File(fileNameLoc));
            driver.findElement(By.id("com.sof.retail:id/cancelButton")).click();

            //Clicking on Sug
            driver.findElement(By.id("com.sof.retail:id/buttonSugg")).click();
            Thread.sleep(3000);
            String sugMsg = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            System.out.println(sugMsg + " Formula Is Displayed");
            //Screenshot the Suggested Quantity
            File fileSug = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileNameSug = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\40_Suggested_Quantity" + ".jpg";
            FileUtils.copyFile(fileSug, new File(fileNameSug));
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();

            //Changing Min value
            keys = "Min";
            try {
                MobileElement minValue = (MobileElement) driver.findElementById("com.sof.retail:id/minTextValue");
                minValue.click();
                minValue.clear();
                minValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                action.sendKeys(Keys.ENTER).perform();
                Thread.sleep(5000);
                try {
                    boolean minWarning = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
                    if (minWarning == true) {
                        System.out.println("Min value change warning is displayed");
                    }
                    driver.findElement(By.id("com.sof.retail:id/okButton")).click();
                } catch (Exception e) {
                    System.out.println("Min value change warning is not displayed");
                }
            } catch (Exception e) {
                System.out.println("Min not editable");
            }

            //Changing BOH value
            keys = "BOH";
            try {
                MobileElement bohVal = (MobileElement) driver.findElementById("com.sof.retail:id/bohTextValue");
                bohVal.click();
                bohVal.clear();
                bohVal.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                action.sendKeys(Keys.ENTER).perform();
                Thread.sleep(6000);
                try {
                    boolean bohWarning = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
                    if (bohWarning == true) {
                        System.out.println("BOH value change warning is displayed");
                    }
                    driver.findElement(By.id("com.sof.retail:id/okButton")).click();
                } catch (Exception e) {
                    System.out.println("BOH value change warning is not displayed");
                }
            } catch (Exception e) {
                System.out.println("BOH not editable");
            }

            //Selecting item from dropdown
            MobileElement itemDrpdwn = (MobileElement) driver.findElementById("com.sof.retail:id/showDropDown");
            itemDrpdwn.click();
            MobileElement itemDrpdwnSelect = (MobileElement) driver.findElementById("com.sof.retail:id/tvCategory");
            itemDrpdwnSelect.click();
            String itemDrpdwnName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
            System.out.println(itemDrpdwnName + " populated in the dropdown");

            //Navigating through Arrows
            try {
                MobileElement leftArrow = (MobileElement) driver.findElementById("com.sof.retail:id/imagePrevious");
                leftArrow.click();
                MobileElement rightArrow = (MobileElement) driver.findElementById("com.sof.retail:id/imageNext");
                rightArrow.click();
            }
            catch (Exception e) {
                //Clicking Next Segment
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }

            //Clicking on Next button
            driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

            //Checking whether summary page is visible
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Order Summary";
            TestAsserts.assertCheck(actualText, expectedText);

        } catch (Exception e) {
            String noOrder = driver.findElement(By.id("com.sof.retail:id/caoOrderNoData")).getText();
            System.out.println(noOrder);
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }
}
