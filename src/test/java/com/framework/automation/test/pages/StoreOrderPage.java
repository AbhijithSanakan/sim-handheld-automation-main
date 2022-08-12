package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import cucumber.runtime.junit.ScenarioOutlineRunner;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class StoreOrderPage {
    static int testCase;
    static String keys = null;
    static String transNum;
    static String minimumNum;
    static String freeCountNum;
    static String addedItemDescName;
    static String addedItemPack;
    static String addedItemQty;
    static String actualText;
    static String expectedText;
    static AndroidDriver<AndroidElement> driver;

    public StoreOrderPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void orderClick() throws InterruptedException {
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

    public static void placeStoreOrder() throws InterruptedException {
        testCase = 37;
        keys = "UPC 1";

        //Selecting Store Order
        MobileElement storeOrder = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.TextView");
        storeOrder.click();
        Thread.sleep(4000);

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if(restoreChck==true) {
                System.out.println("Restore found");
                //Deleting the restore data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }
        }
        catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Adding UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(14000);
        upc.clear();

        //Checking product details of scanned item
        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        String itemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
        String pack = driver.findElement(By.id("com.sof.retail:id/packValue")).getText();
        String qty = driver.findElement(By.id("com.sof.retail:id/qtyValueField")).getText();
        System.out.println("Description Status is " + itemDesc);
        System.out.println(itemDescName + " is Displayed with Pack - " + pack + " & Qty - " + qty);

        //Changing Min value
        keys = "Min";
        try {
            MobileElement minValue = (MobileElement) driver.findElementById("com.sof.retail:id/minTextValue");
            minValue.click();
            minValue.clear();
            minValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(5000);
            boolean minWarning = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
            if (minWarning == true) {
                System.out.println("Min value change warning is displayed");
            }
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();
        }
        catch (Exception e) {
            System.out.println("Unable to change Min Value");
        }

        //Changing BOH value
        keys = "BOH";
        try {
            MobileElement bohValue = (MobileElement) driver.findElementById("com.sof.retail:id/bohTextValue");
            bohValue.click();
            bohValue.clear();
            bohValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            action.sendKeys(Keys.ENTER).perform();
            boolean bohWarning = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
            if (bohWarning == true) {
                System.out.println("BOH value change warning is displayed");
            }
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();
        }
        catch (Exception e) {
            System.out.println("Unable to change BOH value");
        }

        //Adding UPC2
        keys = "UPC 2";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(12000);
        upc.clear();

        //Checking added item
        addedItemDescName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        addedItemPack = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        addedItemQty = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).getText();
        System.out.println(addedItemDescName + " is added to dropdown with Pack - " + addedItemPack + " & Qty - " + addedItemQty);

        //Clicking green arrows
        driver.findElement(By.id("com.sof.retail:id/rightArrow")).click();

        addedItemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
        addedItemPack = driver.findElement(By.id("com.sof.retail:id/packValue")).getText();
        addedItemQty = driver.findElement(By.id("com.sof.retail:id/qtyValueField")).getText();
        System.out.println(addedItemDescName + " is Visible in the grid. Pack - " + addedItemPack + " & Qty - " + addedItemQty);
        Thread.sleep(2000);

        driver.findElement(By.id("com.sof.retail:id/leftArrow")).click();
        Thread.sleep(2000);

        //Deleting an item
        TouchAction act = new TouchAction(driver);

        act.press(PointOption.point(294, 443))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(159, 443)).release().perform();
        Thread.sleep(2000);

        MobileElement delBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
        delBtn.click();
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

        //Order Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Order Summary";
        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(2000);

        String department = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout/android.widget.TextView")).getText();
        boolean departmentChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout/android.widget.TextView")).isDisplayed();
        System.out.println("Status is " + departmentChck + " for Department name - " + department);

        //Piece Count
        String pieceCount = driver.findElement(By.id("com.sof.retail:id/priceTextView")).getText();
        boolean pieceCountChck = driver.findElement(By.id("com.sof.retail:id/priceTextView")).isDisplayed();
        String pieceCountValue = driver.findElement(By.id("com.sof.retail:id/priceDataTextView")).getText();
        System.out.println("Status is " + pieceCountChck + " for " + pieceCount + ", Total Piece Count " + pieceCountValue);

        //Cuttoff Time
        try {
            boolean cutOff = driver.findElement(By.id("com.sof.retail:id/cutoffTimeTextView")).isDisplayed();
            String cutOffValue = driver.findElement(By.id("com.sof.retail:id/cutoffTimeTextVal")).getText();
            System.out.println("Status is " + cutOff + " for CuttOff Date & Time, CutOff Time - " + cutOffValue);
        }
        catch (Exception e) {
            System.out.println("Cutoff Time not visible");
        }

        //Delivery
        boolean delivery = driver.findElement(By.id("com.sof.retail:id/deliveryTextView")).isDisplayed();
        String deliveryValue = driver.findElement(By.id("com.sof.retail:id/deliveryDataTextView")).getText();
        System.out.println("Status is " + delivery + " for Delivery Date & Time, Delivery - " + deliveryValue);

        //Ordered Item Details
        boolean orderedItem = driver.findElement(By.id("com.sof.retail:id/deliveryTextView")).isDisplayed();
        addedItemDescName = driver.findElement(By.id("com.sof.retail:id/descpText")).getText();
        addedItemQty = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        System.out.println("Status is " + orderedItem + " for Item Description, Item - " + addedItemDescName + " Qty - " + addedItemQty);

        //Clicking on Send
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(20000);

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(3000);

        //Writing Confirmation Numbers to Excel
        try {
            transNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
            keys = "Transaction Number";
            ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println("Transaction Number is not visible");
        }
        try {
            minimumNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
            keys = "Update Minimums";
            ExcelHandle.ExcelWriteFunction(testCase, keys, minimumNum);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println("Minimums Number is not visible");
        }
        try {
            freeCountNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
            keys = "Free Count";
            ExcelHandle.ExcelWriteFunction(testCase, keys, freeCountNum);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println("FreeCount Number is not visible");
        }

        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(3000);

        //Back to Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(3000);
        driver.closeApp();
    }

    public static void storeOrderScreenVerify() throws InterruptedException, IOException {
        testCase = 40;
        keys = "UPC 1";

        //Selecting Store Order
        MobileElement storeOrder = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.TextView");
        storeOrder.click();
        Thread.sleep(4000);

        //Checking for Restore
        try {
            boolean restoreChck = driver.findElement(By.id("com.sof.retail:id/dialog_title")).isDisplayed();
            if(restoreChck==true) {
                System.out.println("Restore found");
                //Deleting the restore data
                System.out.println("Deleting Previous Session Data");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            }
        }
        catch (Exception e) {
            System.out.println("No restore is found");
        }

        //Verifying Store Order Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Store Order";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        boolean upcIcon = driver.findElement(By.id("com.sof.retail:id/upcText")).isDisplayed();
        System.out.println("Status is " + upcIcon + " for UPC icon");
        boolean upcBox = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isDisplayed();
        System.out.println("Status is " + upcBox + " for UPC Box");
        boolean printerIcon = driver.findElement(By.id("com.sof.retail:id/printerButton")).isDisplayed();
        System.out.println("Status is " + printerIcon + " for Printer icon");
        boolean forecast = driver.findElement(By.id("com.sof.retail:id/frcstTextView")).isDisplayed();
        System.out.println("Status is " + forecast + " for Forecast");
        boolean last = driver.findElement(By.id("com.sof.retail:id/lastTextView")).isDisplayed();
        System.out.println("Status is " + last + " for Last Received");
        boolean loc = driver.findElement(By.id("com.sof.retail:id/locTextView")).isDisplayed();
        System.out.println("Status is " + loc + " for Locations");
        boolean boh = driver.findElement(By.id("com.sof.retail:id/bohTextView")).isDisplayed();
        System.out.println("Status is " + boh + " for Balance On Hand");
        boolean min = driver.findElement(By.id("com.sof.retail:id/minTextView")).isDisplayed();
        System.out.println("Status is " + min + " for Minimum Inventory");
        boolean sug = driver.findElement(By.id("com.sof.retail:id/sugTextView")).isDisplayed();
        System.out.println("Status is " + sug + " for Suggested Quantity");
        boolean cost = driver.findElement(By.id("com.sof.retail:id/costText")).isDisplayed();
        System.out.println("Status is " + cost + " for Cost");
        boolean inTransit = driver.findElement(By.id("com.sof.retail:id/transitTextView")).isDisplayed();
        System.out.println("Status is " + inTransit + " for In Transit");
        boolean quesIcon = driver.findElement(By.id("com.sof.retail:id/descriptionImage")).isDisplayed();
        System.out.println("Status is " + quesIcon + " for Question Icon");
        boolean descp = driver.findElement(By.id("com.sof.retail:id/descriptionText")).isDisplayed();
        System.out.println("Status is " + descp + " for Description");
        boolean pack = driver.findElement(By.id("com.sof.retail:id/packText")).isDisplayed();
        System.out.println("Status is " + pack + " for Pack");
        boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyText")).isDisplayed();
        System.out.println("Status is " + qty + " for Quantity");
        boolean itemDrpdown = driver.findElement(By.id("com.sof.retail:id/soAllItemsSpinnner")).isDisplayed();
        System.out.println("Status is " + itemDrpdown + " for Items Dropdown");
        boolean item = driver.findElement(By.id("com.sof.retail:id/storeOrderItemsCount")).isDisplayed();
        System.out.println("Status is " + item + " for Quantity");
        boolean pieceCount = driver.findElement(By.id("com.sof.retail:id/pieceCountTextView")).isDisplayed();
        System.out.println("Status is " + pieceCount + " for Piece Count");
        boolean total = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView[2]")).isDisplayed();
        System.out.println("Status is " + total + " for Total");
        boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
        System.out.println("Status is " + nextBtn + " for Next Button");
        boolean discardBtn = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
        System.out.println("Status is " + discardBtn + " for Discard Button");

        //Adding Invalid UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
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
        keys = "UPC 2";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(12000);

        //Checking product details of scanned item
        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        String itemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
        String packSize = driver.findElement(By.id("com.sof.retail:id/packValue")).getText();
        String qtyCount = driver.findElement(By.id("com.sof.retail:id/qtyValueField")).getText();
        System.out.println("Description Status is " + itemDesc);
        System.out.println(itemDescName + " is Displayed with Pack - " + packSize + " & Qty - " + qtyCount);

        //Clicking on item hyperlink
        driver.findElement(By.id("com.sof.retail:id/linkDesc")).click();

        //Product details pop up
        String itemInfo = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        System.out.println(itemInfo+ " is Displayed");

        //Printing Item Details
        String itemName = driver.findElement(By.id("com.sof.retail:id/dialogItemDescTitleValue")).getText();
        String upcNumber = driver.findElement(By.id("com.sof.retail:id/offerPriceVal")).getText();
        String deptName = driver.findElement(By.id("com.sof.retail:id/regularPriceVal")).getText();
        String packSze = driver.findElement(By.id("com.sof.retail:id/pointsVal")).getText();
        String sizeCount = driver.findElement(By.id("com.sof.retail:id/startVal")).getText();
        String category = driver.findElement(By.id("com.sof.retail:id/endVal")).getText();

        System.out.println("-------------");
        System.out.println("Item Name - " +itemName);
        System.out.println("UPC - " +upcNumber);
        System.out.println("Department - " +deptName);
        System.out.println("Pack - " +packSze);
        System.out.println("Size - " +sizeCount);
        System.out.println("Category - " +category);
        System.out.println("-------------");

        //Clicking on Ok
        driver.findElement(By.id("com.sof.retail:id/okButton")).click();

        //Clicking on Printer Icon
        driver.findElement(By.id("com.sof.retail:id/printerButton")).click();

        //Label Request
        String labelReq = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        System.out.println(labelReq+ " Text Box Is Displayed");
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        //Checking Whether te user is taken back to Store Order Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Store Order";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Clicking on Forecast
        driver.findElement(By.id("com.sof.retail:id/frcstTextValue")).click();
        Thread.sleep(2000);
        String forecastTapData = driver.findElement(By.id("com.sof.retail:id/textTitle")).getText();
        System.out.println(forecastTapData+ " is Displayed");
        //Screenshot the Forecast Page
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\40_Week_Sales_History" + ".jpg";
        FileUtils.copyFile(file, new File(fileName));
        driver.findElement(By.id("com.sof.retail:id/okButton")).click();

        //Clicking on Last
        driver.findElement(By.id("com.sof.retail:id/lastTextValue")).click();
        Thread.sleep(2000);
        String lastTapData = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        String lastTapItemName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        System.out.println(lastTapData+ " for - " +lastTapItemName+ " is Displayed");
        //Screenshot the Inventory History
        File fileLast = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileNameLast = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\40_Inventory_History" + ".jpg";
        FileUtils.copyFile(fileLast, new File(fileNameLast));
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        //Clicking on Loc
        driver.findElement(By.id("com.sof.retail:id/locTextValue")).click();
        Thread.sleep(2000);
        try {
            String errorMsg = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
            System.out.println(errorMsg+ " Message Box Is Displayed");
            String errorReason = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println("Error Reason - " +errorReason);
        }
        catch (Exception e) {
            System.out.println("Loc Data is Visible");
            String itemLoc = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            String itemLocName = driver.findElement(By.id("com.sof.retail:id/spinnerTextView")).getText();
            System.out.println(itemLoc+ " - " +itemLocName);
            //Screenshot the Item Location
            File fileLoc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileNameLoc = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\40_Item_Location" + ".jpg";
            FileUtils.copyFile(fileLoc, new File(fileNameLoc));
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();
        }

        //Clicking on Ellipse
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView")).click();
        Thread.sleep(6000);
        String popMsg = driver.findElement(By.id("com.sof.retail:id/textTitle")).getText();
        System.out.println(popMsg+ " Pop Up is Displayed");
        driver.findElement(By.id("com.sof.retail:id/cancelButton")).click();

        //Clicking on Sug
        driver.findElement(By.id("com.sof.retail:id/sugTextValue")).click();
        Thread.sleep(2000);
        String sugMsg = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        System.out.println(sugMsg+ " Formula Is Displayed");
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
            boolean minWarning = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
            if (minWarning == true) {
                System.out.println("Min value change warning is displayed");
            }
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();
        }
        catch (Exception e) {
            System.out.println("Min not editable");
        }

        //Changing BOH value
        keys = "BOH";
        try {
            MobileElement bohValue = (MobileElement) driver.findElementById("com.sof.retail:id/bohTextValue");
            bohValue.click();
            bohValue.clear();
            bohValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(6000);
            boolean bohWarning = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
            if (bohWarning == true) {
                System.out.println("BOH value change warning is displayed");
            }
            driver.findElement(By.id("com.sof.retail:id/okButton")).click();
        }
        catch (Exception e) {
            System.out.println("BOH not editable");
        }

        //Changing Qty value
        keys = "Order Count";
        String qtyValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")).getText();
        MobileElement qtyClick = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText"));
        qtyClick.click();
        qtyClick.clear();
        qtyClick.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //Checking Whether Value Changed
        String qtyCurrentValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")).getText();

        if(qtyValue==qtyCurrentValue) {
            System.out.println("Value cannot be changed");
        }
        else {
            System.out.println("Value is editabale");
            System.out.println("Previous Value - " +qtyValue+ ", Current Value - " +qtyCurrentValue);
        }

        //Entering Higher Value
        qtyClick.click();
        qtyClick.clear();
        qtyClick.sendKeys("100");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        //Verifying the page after entering higher qty amount
        boolean qtyConfirmChk = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).isDisplayed();
        String qtyConfirm = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        System.out.println("Status is " +qtyConfirmChk+ " for " +qtyConfirm+ " pop up");
        driver.findElement(By.id("com.sof.retail:id/editTextPleaseConfirm")).sendKeys("100");
        driver.findElement(By.id("com.sof.retail:id/adjustButton")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        //Selecting item from dropdown
        MobileElement itemDrpdwn = (MobileElement) driver.findElementById("com.sof.retail:id/scheduleTypeName");
        itemDrpdwn.click();
        MobileElement itemDrpdwnSelect = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView");
        itemDrpdwnSelect.click();
        String itemDrpdwnName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.LinearLayout/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
        System.out.println(itemDrpdwnName + " populated in the dropdown");

        //Navigating through Arrows
        MobileElement leftArrow = (MobileElement) driver.findElementById("com.sof.retail:id/leftArrow");
        leftArrow.click();
        MobileElement rightArrow = (MobileElement) driver.findElementById("com.sof.retail:id/rightArrow");
        rightArrow.click();

        //Clicking on Next button
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

        //Checking whether summary page is visible
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Order Summary";
        TestAsserts.assertCheck(actualText,expectedText);

        //Closing App
        driver.closeApp();
        driver.quit();
    }

}
