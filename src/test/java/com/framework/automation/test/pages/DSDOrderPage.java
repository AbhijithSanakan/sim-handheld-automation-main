package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import cucumber.runtime.junit.ScenarioOutlineRunner;
import gherkin.lexer.Th;
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

public class DSDOrderPage {
    static int testCase;
    static String keys = null;
    static String addedItemDescName;
    static String addedItemPack;
    static String addedItemQty;
    static String transNum;
    static String actualText;
    static String expectedText;
    static boolean orderedItem;
    static AndroidDriver<AndroidElement> driver;

    public DSDOrderPage() throws IOException, InterruptedException {
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

    public static void placeDsdOrder() throws InterruptedException {
        testCase = 38;
        keys = "UPC 1";

        //Selecting DSD Order
        MobileElement dsdOrderClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView");
        dsdOrderClick.click();
        Thread.sleep(4000);

        //Verifying Pick Supplier Screen
        String pickSupplierHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(pickSupplierHeader, "Pick Supplier");
        System.out.println(pickSupplierHeader + " is visible");
        //Supplier Dropdown
        String supplier = driver.findElement(By.id("com.sof.retail:id/txt_supplier")).getText();
        boolean supplierDrpdown = driver.findElement(By.id("com.sof.retail:id/dsdOrderSupplierSpinner")).isDisplayed();
        String supplierName = driver.findElement(By.id("com.sof.retail:id/tvCategory")).getText();
        System.out.println("Status is "+supplierDrpdown+ " for " +supplier+ " dropdown with " +supplierName+ " Supplier");
        //Minimum Order Value
        String minValue = driver.findElement(By.id("com.sof.retail:id/minOrderTextView")).getText();
        boolean minValueChck = driver.findElement(By.id("com.sof.retail:id/minOrderTextView")).isDisplayed();
        String minValueTxtSign = driver.findElement(By.id("com.sof.retail:id/minOrderSignTextValue")).getText();
        String minValueTxt = driver.findElement(By.id("com.sof.retail:id/minOrderTextValue")).getText();
        System.out.println("Status is " + minValueChck+ " for " +minValue);
        System.out.println(minValue+ " " +minValueTxtSign+minValueTxt);
        //Next Button Check
        boolean nxtBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " +nxtBtn+ " for Next Button");
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(2000);

        //DSD Order Page
        String dsdOrderHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(dsdOrderHeader, "DSD Order");
        System.out.println(dsdOrderHeader + " is visible");

        //Adding UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(18000);
        upc.clear();

        //Checking product details of scanned item
        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        String itemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
        String pack = driver.findElement(By.id("com.sof.retail:id/packValue")).getText();
        String qty = driver.findElement(By.id("com.sof.retail:id/qtyValueField")).getText();
        System.out.println("Description Status is " +itemDesc);
        System.out.println(itemDescName+ " is Displayed with Pack - " +pack+ " & Qty - " +qty);

        boolean forecast = driver.findElement(By.id("com.sof.retail:id/frcstTextView")).isDisplayed();
        String forecastValue = driver.findElement(By.id("com.sof.retail:id/frcstTextValue")).getText();
        System.out.println("Status is " +forecast+ " for Forecast, Forecast Value - " +forecastValue);
        boolean last = driver.findElement(By.id("com.sof.retail:id/lastTextView")).isDisplayed();
        String lastValue = driver.findElement(By.id("com.sof.retail:id/lastTextValue")).getText();
        System.out.println("Status is " +last+ " for Last, Last Value - " +lastValue);
        boolean loc = driver.findElement(By.id("com.sof.retail:id/locTextView")).isDisplayed();
        String locValue = driver.findElement(By.id("com.sof.retail:id/locTextValue")).getText();
        System.out.println("Status is " +loc+ " for Loc, Loc - " +locValue);
        boolean boh = driver.findElement(By.id("com.sof.retail:id/bohTextView")).isDisplayed();
        String bohValue = driver.findElement(By.id("com.sof.retail:id/bohTextValue")).getText();
        System.out.println("Status is " +boh+ " for BOH, BOH - " +bohValue);
        boolean min = driver.findElement(By.id("com.sof.retail:id/minTextView")).isDisplayed();
        String minValueText = driver.findElement(By.id("com.sof.retail:id/minTextValue")).getText();
        System.out.println("Status is " +min+ " for Min, Min Value - " +minValueText);
        boolean sug = driver.findElement(By.id("com.sof.retail:id/sugTextView")).isDisplayed();
        String sugValue = driver.findElement(By.id("com.sof.retail:id/sugTextValue")).getText();
        System.out.println("Status is " +sug+ " for Suggested Quantity, Sug Value - " +sugValue);

        //Adding UPC2
        keys = "UPC 2";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(18000);
        upc.clear();

        //Checking added item
        addedItemDescName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        addedItemPack = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        addedItemQty = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).getText();
        System.out.println(addedItemDescName+ " is added to dropdown with Pack - " +addedItemPack+ " & Qty - " +addedItemQty);

        //Adding 3rd Item
        keys = "UPC 3";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(13000);
        upc.clear();

        //Deleting added item
        TouchAction act = new TouchAction(driver);

        act.press(PointOption.point(294, 443))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(159, 443)).release().perform();
        Thread.sleep(2000);

        MobileElement delBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
        delBtn.click();

//        try {
//            boolean itemCheck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).isDisplayed();
//
//            System.out.println("Checking Whether Item is Deleted");
//            if(itemCheck==true) {
//                System.out.println(addedItemDescName+ " is Visible");
//            }
//            else {
//                System.out.println(addedItemDescName+ " is Deleted");
//            }
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();;
//        }

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        try {
            String orderWarning = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
            System.out.println(orderWarning + " Warning is Displayed, Adjust the order");

            //Adjusting the order
            driver.findElement(By.id("com.sof.retail:id/discardYesButton")).click();
            MobileElement qtyClick = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText"));
            qtyClick.click();
            qtyClick.clear();
            qtyClick.sendKeys("150");
            action.sendKeys(Keys.ENTER).perform();
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(2000);

            qtyClick = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText"));
            qtyClick.click();
            qtyClick.clear();
            qtyClick.sendKeys("100");
            action.sendKeys(Keys.ENTER).perform();
            String qtyConfirmWarning = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
            System.out.println(qtyConfirmWarning + " Warning is Displayed");
            MobileElement qtyConfirm = (MobileElement) driver.findElementById("com.sof.retail:id/editTextPleaseConfirm");
            qtyConfirm.sendKeys("100");
            driver.findElement(By.id("com.sof.retail:id/adjustButton")).click();
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        }

        catch (Exception e) {
            System.out.println("Ordered above minimum");
        }

        driver.findElement(By.id("com.sof.retail:id/button3")).click();

        //Order Summary Page
        String summaryHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(summaryHeader, "Order Summary");
        System.out.println(summaryHeader + " is visible");

        String department = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout/android.widget.TextView")).getText();
        boolean departmentChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout/android.widget.TextView")).isDisplayed();
        System.out.println("Status is " +departmentChck+ " for Department name - " +department);

        //Piece Count
        String pieceCount = driver.findElement(By.id("com.sof.retail:id/priceTextView")).getText();
        boolean pieceCountChck = driver.findElement(By.id("com.sof.retail:id/priceTextView")).isDisplayed();
        String pieceCountValue = driver.findElement(By.id("com.sof.retail:id/priceDataTextView")).getText();
        System.out.println("Status is " +pieceCountChck+ " for " +pieceCount+ ", Total Piece Count" +pieceCountValue);

        //Delivery
        boolean delivery = driver.findElement(By.id("com.sof.retail:id/deliveryTextView")).isDisplayed();
        String deliveryValue = driver.findElement(By.id("com.sof.retail:id/deliveryDataTextView")).getText();
        System.out.println("Status is " +delivery+ " for Delivery Date & Time, Delivery - " +deliveryValue);

        try {
            //Ordered Item Details
            orderedItem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            addedItemDescName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
            addedItemQty = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[3]")).getText();
            System.out.println("Status is " + orderedItem + " for Item Description, Item - " + addedItemDescName + " Qty - " + addedItemQty);

            orderedItem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            addedItemDescName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
            addedItemQty = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[3]")).getText();
            System.out.println("Status is " + orderedItem + " for Item Description, Item - " + addedItemDescName + " Qty - " + addedItemQty);
            Thread.sleep(3000);
        }

        catch (Exception e) {
            System.out.println("Displayed Ordered Item Details");
        }

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(8000);

        //Transaction Page
        String transHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(transHeader, "Transaction");
        System.out.println(transHeader + " is visible");
        Thread.sleep(3000);

        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void placeDsdOrderNegative () throws InterruptedException {
        testCase = 39;
        keys = "UPC 1";

        //Selecting DSD Order
        MobileElement dsdOrderClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView");
        dsdOrderClick.click();
        Thread.sleep(4000);

        //Verifying Pick Supplier Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Pick Supplier";
        TestAsserts.assertCheck(actualText,expectedText);

        //Supplier Dropdown
        String supplier = driver.findElement(By.id("com.sof.retail:id/txt_supplier")).getText();
        boolean supplierDrpdown = driver.findElement(By.id("com.sof.retail:id/dsdOrderSupplierSpinner")).isDisplayed();
        String supplierName = driver.findElement(By.id("com.sof.retail:id/tvCategory")).getText();
        System.out.println("Status is "+supplierDrpdown+ " for " +supplier+ " dropdown with " +supplierName+ " Supplier");

        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(2000);

        //DSD Order Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "DSD Order";
        TestAsserts.assertCheck(actualText,expectedText);

        //Adding UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(18000);
        upc.clear();

        //Checking product details of scanned item
        boolean itemDesc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
        String itemDescName = driver.findElement(By.id("com.sof.retail:id/itemDescription")).getText();
        String pack = driver.findElement(By.id("com.sof.retail:id/packValue")).getText();
        String qty = driver.findElement(By.id("com.sof.retail:id/qtyValueField")).getText();
        System.out.println("Description Status is " +itemDesc);
        System.out.println(itemDescName+ " is Displayed with Pack - " +pack+ " & Qty - " +qty);

        boolean forecast = driver.findElement(By.id("com.sof.retail:id/frcstTextView")).isDisplayed();
        String forecastValue = driver.findElement(By.id("com.sof.retail:id/frcstTextValue")).getText();
        System.out.println("Status is " +forecast+ " for Forecast, Forecast Value - " +forecastValue);
        boolean last = driver.findElement(By.id("com.sof.retail:id/lastTextView")).isDisplayed();
        String lastValue = driver.findElement(By.id("com.sof.retail:id/lastTextValue")).getText();
        System.out.println("Status is " +last+ " for Last, Last Value - " +lastValue);
        boolean loc = driver.findElement(By.id("com.sof.retail:id/locTextView")).isDisplayed();
        String locValue = driver.findElement(By.id("com.sof.retail:id/locTextValue")).getText();
        System.out.println("Status is " +loc+ " for Loc, Loc - " +locValue);
        boolean boh = driver.findElement(By.id("com.sof.retail:id/bohTextView")).isDisplayed();
        String bohValue = driver.findElement(By.id("com.sof.retail:id/bohTextValue")).getText();
        System.out.println("Status is " +boh+ " for BOH, BOH - " +bohValue);
        boolean min = driver.findElement(By.id("com.sof.retail:id/minTextView")).isDisplayed();
        String minValueText = driver.findElement(By.id("com.sof.retail:id/minTextValue")).getText();
        System.out.println("Status is " +min+ " for Min, Min Value - " +minValueText);
        boolean sug = driver.findElement(By.id("com.sof.retail:id/sugTextView")).isDisplayed();
        String sugValue = driver.findElement(By.id("com.sof.retail:id/sugTextValue")).getText();
        System.out.println("Status is " +sug+ " for Suggested Quantity, Sug Value - " +sugValue);

        //Adding UPC2
        keys = "UPC 2";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(18000);
        upc.clear();

        //Checking added item
        addedItemDescName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        addedItemPack = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        addedItemQty = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).getText();
        System.out.println(addedItemDescName+ " is added to dropdown with Pack - " +addedItemPack+ " & Qty - " +addedItemQty);


        //Deleting added item
        TouchAction act = new TouchAction(driver);

        act.press(PointOption.point(294, 443))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(159, 443)).release().perform();
        Thread.sleep(2000);

        MobileElement delBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
        delBtn.click();

        driver.findElement(By.id("com.sof.retail:id/button3")).click();

        try {
            String orderWarning = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
            System.out.println(orderWarning + " Warning is Displayed, Adjust the order");

            //Clicking the Send with below minimum order value
            driver.findElement(By.id("com.sof.retail:id/discardNoButton")).click();

            boolean confirmDialog = driver.findElement(By.id("com.sof.retail:id/dialogTitleWarningTextView")).isDisplayed();
            if(confirmDialog==true) {
                System.out.println("Please Confirm Dialog Box Warning is Displayed");
            }
            driver.findElement(By.id("com.sof.retail:id/discardNoButton")).click();

            //Checking Whether Navigated to Order Summary Page with below Minimum Value
            String summaryHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            Assert.assertEquals(summaryHeader, "Order Summary");
            System.out.println("Order can be placed when minimum condition is not satisfied");
        }

        catch (Exception e) {
            System.out.println("Ordered above minimum");
        }

        //Order Summary Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Order Summary";
        TestAsserts.assertCheck(actualText,expectedText);

        String department = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout/android.widget.TextView")).getText();
        boolean departmentChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout/android.widget.TextView")).isDisplayed();
        System.out.println("Status is " +departmentChck+ " for Department name - " +department);

        //Piece Count
        String pieceCount = driver.findElement(By.id("com.sof.retail:id/priceTextView")).getText();
        boolean pieceCountChck = driver.findElement(By.id("com.sof.retail:id/priceTextView")).isDisplayed();
        String pieceCountValue = driver.findElement(By.id("com.sof.retail:id/priceDataTextView")).getText();
        System.out.println("Status is " +pieceCountChck+ " for " +pieceCount+ ", Total Piece Count" +pieceCountValue);

        //Delivery
        boolean delivery = driver.findElement(By.id("com.sof.retail:id/deliveryTextView")).isDisplayed();
        String deliveryValue = driver.findElement(By.id("com.sof.retail:id/deliveryDataTextView")).getText();
        System.out.println("Status is " +delivery+ " for Delivery Date & Time, Delivery - " +deliveryValue);

        try {
            //Ordered Item Details
            orderedItem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            addedItemDescName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
            addedItemQty = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[3]")).getText();
            System.out.println("Status is " + orderedItem + " for Item Description, Item - " + addedItemDescName + " Qty - " + addedItemQty);

            orderedItem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
            addedItemDescName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
            addedItemQty = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[3]")).getText();
            System.out.println("Status is " + orderedItem + " for Item Description, Item - " + addedItemDescName + " Qty - " + addedItemQty);
            Thread.sleep(3000);
        }

        catch (Exception e) {
            System.out.println("Displayed Ordered Item Details");
        }

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(8000);

        //Transaction Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Transaction";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(3000);

        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(2000);

        //Back to Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(2000);
        driver.closeApp();

    }

}
