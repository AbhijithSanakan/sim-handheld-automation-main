package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.utils.TestUtil;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.MarshalledObject;
import java.time.Duration;

public class DROrdersOptionsMenuPage {
    static AndroidDriver<AndroidElement> driver;
    static int testCase;
    static String transNum;
    static String keys = null;
    static String actualText;
    static String expectedText;

    public DROrdersOptionsMenuPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void OptionsMenuClick() throws InterruptedException {
        //Clicking Options Menu
        MobileElement optionsMenuClick = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton"));
        optionsMenuClick.click();
        Thread.sleep(2000);
    }

    public static void ItemLookupClick() throws InterruptedException {
        testCase = 66;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(8000);

        //Verifying entered item details
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "ITEM INFORMATION";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Clicking on BASIC to verify the item details
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"BASIC\"]/android.widget.TextView")).click();
        Thread.sleep(6000);

        try {
            boolean upcCheck = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).isDisplayed();
            if (upcCheck == true) {
                System.out.println("Item Basic Details Loaded");
                //Item Information
                String upcTxt = driver.findElement(By.id("com.sof.retail:id/tvUpc")).getText();
                String upcTxtValue = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).getText();
                System.out.println(upcTxt + "-" + upcTxtValue);
                //Dept
                String deptTxt = driver.findElement(By.id("com.sof.retail:id/deptTextView")).getText();
                String deptTxtValue = driver.findElement(By.id("com.sof.retail:id/deptVal")).getText();
                System.out.println(deptTxt + "-" + deptTxtValue);
                //Dept
                String catTxt = driver.findElement(By.id("com.sof.retail:id/categoryTextView")).getText();
                String catTxtValue = driver.findElement(By.id("com.sof.retail:id/categoryVal")).getText();
                System.out.println(catTxt + "-" + catTxtValue);
                //Dept
                String packTxt = driver.findElement(By.id("com.sof.retail:id/packTextView")).getText();
                String packTxtValue = driver.findElement(By.id("com.sof.retail:id/packVal")).getText();
                System.out.println(packTxt + "-" + packTxtValue);
                //Dept
                String uomTxt = driver.findElement(By.id("com.sof.retail:id/uomTextView")).getText();
                String uomTxtValue = driver.findElement(By.id("com.sof.retail:id/uomVal")).getText();
                System.out.println(uomTxt + "-" + uomTxtValue);
                //Dept
                String variantTxt = driver.findElement(By.id("com.sof.retail:id/variantTextView")).getText();
                String variantTxtValue = driver.findElement(By.id("com.sof.retail:id/variantVal")).getText();
                System.out.println(variantTxt + "-" + variantTxtValue);
                //Dept
                String shipcaseTxt = driver.findElement(By.id("com.sof.retail:id/shipcaseTextView")).getText();
                String shipcaseTxtValue = driver.findElement(By.id("com.sof.retail:id/shipcaseVal")).getText();
                System.out.println(shipcaseTxt + "-" + shipcaseTxtValue);
            }
        } catch (Exception e) {
            System.out.println("Item Details is Empty");
        }
    }

    public static void ItemLookupClickInvalidUpc() throws InterruptedException {
        testCase = 68;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(8000);

        //Checking for error message
        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        expectedText = "ERROR";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Clicking Ok Button
        boolean noUpcChck = driver.findElement(By.id("com.sof.retail:id/dialog_message")).isDisplayed();
        if (noUpcChck == true) {
            String noUpcTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
            System.out.println(noUpcTxt);
        }
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
    }

    public static void ItemLookupOrder() throws InterruptedException {
        testCase = 70;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(8000);

        //Clicking on order
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"ORDER\"]/android.widget.TextView")).click();

        //Verifying item information
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "ITEM INFORMATION";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Checking Details
        //UPC
        String upcTxt = driver.findElement(By.id("com.sof.retail:id/tvUpc")).getText();
        String upcTxtValue = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).getText();
        System.out.println(upcTxt + "-" + upcTxtValue);
        //BOH
        String bohTxt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
        String bohTxtValue = driver.findElement(By.id("com.sof.retail:id/bohValue")).getText();
        System.out.println(bohTxt + "-" + bohTxtValue);
        //BOH
        String safetyTxt = driver.findElement(By.id("com.sof.retail:id/tvsfty")).getText();
        String safetyTxtValue = driver.findElement(By.id("com.sof.retail:id/sftyValue")).getText();
        System.out.println(safetyTxt + "-" + safetyTxtValue);
        //BOH
        String minQtyTxt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
        String minQtyTxtValue = driver.findElement(By.id("com.sof.retail:id/minQtyValue")).getText();
        System.out.println(minQtyTxt + "-" + minQtyTxtValue);
        //Current Week Forecast
        String currentWeekFrcstTxt = driver.findElement(By.id("com.sof.retail:id/currentWeekForecastTextView")).getText();
        String currentWeekFrcstTxtValue = driver.findElement(By.id("com.sof.retail:id/currentWeekForecastVal")).getText();
        System.out.println(currentWeekFrcstTxt + "-" + currentWeekFrcstTxtValue);
        //Next Week Forecast
        String nxtWeekFrcstTxt = driver.findElement(By.id("com.sof.retail:id/nextweekForecastTextView")).getText();
        String nxtWeekFrcstTxtValue = driver.findElement(By.id("com.sof.retail:id/nextweekForecastVal")).getText();
        System.out.println(nxtWeekFrcstTxt + "-" + nxtWeekFrcstTxtValue);
        //Last Week Forecast
        String lastWeekSalesTxt = driver.findElement(By.id("com.sof.retail:id/lastWeekSalesTextView")).getText();
        String lastWeekSalesTxtValue = driver.findElement(By.id("com.sof.retail:id/lastWeekSalesVal")).getText();
        System.out.println(lastWeekSalesTxt + "-" + lastWeekSalesTxtValue);
        //Current Week Sales
        String currentWeekSalesTxt = driver.findElement(By.id("com.sof.retail:id/currentWeekSalesTextView")).getText();
        String currentWeekSalesTxtValue = driver.findElement(By.id("com.sof.retail:id/currentWeekSalesVal")).getText();
        System.out.println(currentWeekSalesTxt + "-" + currentWeekSalesTxtValue);
        //CAO Order
        String caoOrderTxt = driver.findElement(By.id("com.sof.retail:id/caoOrderTextView")).getText();
        String caoOrderValue = driver.findElement(By.id("com.sof.retail:id/caoOrderVal")).getText();
        System.out.println(caoOrderTxt + "-" + caoOrderValue);
        //Locations
        String locationTxt = driver.findElement(By.id("com.sof.retail:id/locationsTextView")).getText();
        String locationTxtValue = driver.findElement(By.id("com.sof.retail:id/locationsVal")).getText();
        System.out.println(locationTxt + "-" + locationTxtValue);
        //First Delivery
        String firstDelTxt = driver.findElement(By.id("com.sof.retail:id/ilp_firstdelvylabel")).getText();
        String firstDelTxtValue = driver.findElement(By.id("com.sof.retail:id/tvfirstdelvyval")).getText();
        System.out.println(firstDelTxt + "-" + firstDelTxtValue);

        //Swiping Down
        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(360, 316))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(360, 269)).release().perform();

        //Second Delivery
        String secondDelTxt = driver.findElement(By.id("com.sof.retail:id/tvUpc")).getText();
        String secondDelTxtValue = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).getText();
        System.out.println(secondDelTxt + "-" + secondDelTxtValue);
    }

    public static void ItemLookupRecent() throws InterruptedException {
        testCase = 72;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(8000);

        //Clicking Recent Option
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"RECENT\"]/android.widget.TextView")).click();
        Thread.sleep(6000);

        //Verifying Recent Option Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "ITEM INFORMATION";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //UPC
        String upcTxt = driver.findElement(By.id("com.sof.retail:id/tvUpc")).getText();
        String upcTxtValue = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).getText();
        System.out.println(upcTxt + "-" + upcTxtValue);
        //Last Sold
        boolean lastSoldChck = driver.findElement(By.id("com.sof.retail:id/upcVal")).isDisplayed();
        String lastSoldTxt = driver.findElement(By.id("com.sof.retail:id/upcTextView")).getText();
        String lastSoldTxtValue = driver.findElement(By.id("com.sof.retail:id/upcVal")).getText();
        System.out.println("Status is " + lastSoldChck + " for " + lastSoldTxt);
        System.out.println(lastSoldTxt + "-" + lastSoldTxtValue);
        //Last Sold
        boolean lastRecvChck = driver.findElement(By.id("com.sof.retail:id/deptVal")).isDisplayed();
        String lastRecvTxt = driver.findElement(By.id("com.sof.retail:id/deptTextView")).getText();
        String lastRecvTxtValue = driver.findElement(By.id("com.sof.retail:id/deptVal")).getText();
        System.out.println("Status is " + lastRecvChck + " for " + lastRecvTxt);
        System.out.println(lastRecvTxt + "-" + lastRecvTxtValue);
        //Last Counted
        boolean lastCountedChck = driver.findElement(By.id("com.sof.retail:id/packVal")).isDisplayed();
        String lastCountedTxt = driver.findElement(By.id("com.sof.retail:id/packTextView")).getText();
        String lastCountedTxtValue = driver.findElement(By.id("com.sof.retail:id/packVal")).getText();
        System.out.println("Status is " + lastCountedChck + " for " + lastCountedTxt);
        System.out.println(lastCountedTxt + "-" + lastCountedTxtValue);
    }

    public static void ItemLookupSales() throws InterruptedException, IOException {
        testCase = 74;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(10000);
        System.out.println("Swiping to Sales");
        Thread.sleep(2000);

        //Swiping to reach Sales
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(345, 677))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(128, 677)).release().perform();

        //Clicking Sales Option
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"SALES\"]/android.widget.TextView")).click();
        Thread.sleep(10000);

        //Verifying Sales Option Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "ITEM INFORMATION";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //UPC
        String upcTxt = driver.findElement(By.id("com.sof.retail:id/tvUpc")).getText();
        String upcTxtValue = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).getText();
        System.out.println(upcTxt + "-" + upcTxtValue);

        //Checking Whether the sales and foreccast for the week is visible
        boolean dayChck = driver.findElement(By.id("com.sof.retail:id/tvItem1")).isDisplayed();
        String dayTxt = driver.findElement(By.id("com.sof.retail:id/tvItem1")).getText();
        boolean salesChck = driver.findElement(By.id("com.sof.retail:id/tvItem2")).isDisplayed();
        String salesTxt = driver.findElement(By.id("com.sof.retail:id/tvItem2")).getText();
        boolean frcstChck = driver.findElement(By.id("com.sof.retail:id/tvItem3")).isDisplayed();
        String frcstTxt = driver.findElement(By.id("com.sof.retail:id/tvItem3")).getText();

        if (dayChck == true && salesChck == true && frcstChck == true) {
            System.out.println(dayTxt + "," + salesTxt + "," + frcstTxt + " is visible");
        }

        //Screenshot the Sales Page
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\74_Sales_Page" + ".jpg";
        FileUtils.copyFile(file, new File(fileName));

        System.out.println("Screenshot of the Sales Page Saved");
    }

    public static void ItemLookupMovement() throws InterruptedException, IOException {
        testCase = 76;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(12000);
        System.out.println("Swiping to Movement");
        Thread.sleep(2000);

        //Swiping to reach Movement
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(345, 677))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(108, 677)).release().perform();


        //Clicking on Movement
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"MOVEMENT\"]/android.widget.TextView")).click();
        Thread.sleep(16000);

        //Verifying Movement Option Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "ITEM INFORMATION";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //UPC
        String upcTxt = driver.findElement(By.id("com.sof.retail:id/tvUpc")).getText();
        String upcTxtValue = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).getText();
        System.out.println(upcTxt + "-" + upcTxtValue);

        //Checking Whether the Activity, Qty & Date is visible
        boolean actChck = driver.findElement(By.id("com.sof.retail:id/tvItem1")).isDisplayed();
        String actTxt = driver.findElement(By.id("com.sof.retail:id/tvItem1")).getText();
        boolean qtyChck = driver.findElement(By.id("com.sof.retail:id/tvItem2")).isDisplayed();
        String qtyTxt = driver.findElement(By.id("com.sof.retail:id/tvItem2")).getText();
        boolean dateChck = driver.findElement(By.id("com.sof.retail:id/tvItem3")).isDisplayed();
        String dateTxt = driver.findElement(By.id("com.sof.retail:id/tvItem3")).getText();

        if (actChck == true && qtyChck == true && dateChck == true) {
            System.out.println(actTxt + "," + qtyTxt + "," + dateTxt + " is visible");
        }

        //Checking Whether data populated
        try {
            boolean dataPop = driver.findElement(By.id("com.sof.retail:id/llItems")).isDisplayed();
            if (dataPop == true) {
                System.out.println("Activity, Qty, Date field is populated with data");
            }
        } catch (Exception e) {
            System.out.println("Activity, Qty, Date Field is empty");
        }

        //Screenshot the Movement Page
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\Output\\76_Movement_Page" + ".jpg";
        FileUtils.copyFile(file, new File(fileName));

        System.out.println("Screenshot of the Movement Page Saved");
    }

    public static void ItemLookupActions() throws InterruptedException {
        testCase = 78;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(12000);
        System.out.println("Swiping to Actions");
        Thread.sleep(2000);

        //Swiping to reach Movement
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(420, 677))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(62, 677)).release().perform();

        //Clicking Actions
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"ACTIONS\"]/android.widget.TextView")).click();
        Thread.sleep(16000);

        //Verifying Actions Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "ITEM INFORMATION";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //UPC
        String upcTxt = driver.findElement(By.id("com.sof.retail:id/tvUpc")).getText();
        String upcTxtValue = driver.findElement(By.id("com.sof.retail:id/tvUpcValue")).getText();
        System.out.println(upcTxt + "-" + upcTxtValue);

        //Checking Whether Shrink, Count, Label visible
        try {
            //Shrink
            actualText = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
            expectedText = "Shrink";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Shrink is not visible");
        }

        try {
            //Count
            actualText = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")).getText();
            expectedText = "Count";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Count is not visible");
        }

        try {
            //Label
            actualText = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")).getText();
            expectedText = "Label";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Label is not visible");
        }

        //Clicking On Shrink
        driver.findElement(By.id("com.sof.retail:id/llShrink")).click();
        Thread.sleep(2000);

        //Checking for Item Shrink popup
        actualText = driver.findElement(By.id("com.sof.retail:id/countDialogTitleTextView")).getText();
        expectedText = "SHRINK";
        TestAsserts.assertCheck(actualText, expectedText);
        String shrinkMsg = driver.findElement(By.id("com.sof.retail:id/countDialogSubTitleTextView")).getText();
        System.out.println(shrinkMsg);

        //Clicking Cancel
        driver.findElement(By.id("com.sof.retail:id/countDialogCancelButton")).click();

        //Clicking Count
        driver.findElement(By.id("com.sof.retail:id/llCount")).click();
        Thread.sleep(2000);

        //Checking for Item Count popup
        actualText = driver.findElement(By.id("com.sof.retail:id/countDialogTitleTextView")).getText();
        expectedText = "FREE COUNT";
        TestAsserts.assertCheck(actualText, expectedText);
        String countMsg = driver.findElement(By.id("com.sof.retail:id/countDialogSubTitleTextView")).getText();
        System.out.println(countMsg);

        //Clicking Cancel
        driver.findElement(By.id("com.sof.retail:id/countDialogCancelButton")).click();

        //Clicking Label
        driver.findElement(By.id("com.sof.retail:id/llLabel")).click();
        Thread.sleep(4000);

        //Checking for Label popup
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "TRANSACTION";
        TestAsserts.assertCheck(actualText, expectedText);
        String labelMsg = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).getText();
        String transDet = driver.findElement(By.id("com.sof.retail:id/descText")).getText();
        String transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        System.out.println(labelMsg);
        System.out.println(transDet + "-" + transNum);

        //Clicking Ok
        driver.findElement(By.id("com.sof.retail:id/button")).click();
    }

    public static void ItemLookupPrices() throws InterruptedException {
        testCase = 102;
        keys = "UPC List 1";
        //Clicking Item Lookup
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_item_look_up"));
        itemLookUpClick.click();
        Thread.sleep(2000);

        //Scan Item
        actualText = driver.findElement(By.id("com.sof.retail:id/scanDialogTitleTextView")).getText();
        expectedText = "SCAN ITEM";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Entering UPC
        MobileElement upc = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/scanDialogOkButton")).click();
        Thread.sleep(12000);

        //Clicking Prices
        MobileElement pricesClick = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"PRICES\"]/android.widget.TextView");
        pricesClick.click();
        Thread.sleep(10000);

        //Verifying Prices Option Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        expectedText = "ITEM INFORMATION";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        try {
            String upcName = driver.findElement(By.id("com.sof.retail:id/tvDesc")).getText();
            boolean offPrice = driver.findElement(By.id("com.sof.retail:id/tvOfferValue")).isDisplayed();
            boolean regPrice = driver.findElement(By.id("com.sof.retail:id/regularVal")).isDisplayed();
            if(offPrice==true && regPrice==true) {
                String offPriceValue = driver.findElement(By.id("com.sof.retail:id/tvOfferValue")).getText();
                String regPriceValue = driver.findElement(By.id("com.sof.retail:id/regularVal")).getText();
                System.out.println(upcName);
                System.out.println("Regular Price - " +regPriceValue);
                System.out.println("Offer Price - " +offPriceValue);
            }
        }
        catch (Exception e) {
            System.out.println("Price is not visible");
        }
        //Clicking close
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();
        Thread.sleep(3000);

        //Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);
    }

    public static void WHDriver() throws InterruptedException {
        testCase = 80;
        //Clicking WH Driver Checkin
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_wh_driver_checkin"));
        itemLookUpClick.click();
        Thread.sleep(4000);

        //Inside WH Driver Checkin
        actualText = driver.findElement(By.id("com.sof.retail:id/textBol")).getText();
        expectedText = "BOL";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Reading values from Excel
        keys = "BOL";
        //Selecting Invoice
        MobileElement bolData = (MobileElement) driver.findElementById("com.sof.retail:id/edtBol");
        bolData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Selecting Driver
        keys = "Driver";
        MobileElement driverData = (MobileElement) driver.findElementById("com.sof.retail:id/edtDriver");
        driverData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Selecting Incoming Security Seal
        keys = "Incoming Security Seal";
        MobileElement incSecSealData = (MobileElement) driver.findElementById("com.sof.retail:id/edtSeal");
        incSecSealData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

        //Clicking Ok
        driver.findElement(By.id("com.sof.retail:id/sendButton")).click();

        //Transaction Page
        try {
            String transText = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).getText();
            System.out.println(transText + " is visible");
            Thread.sleep(4000);
            //Description
            boolean descpChck = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
            String descpValue = driver.findElement(By.id("com.sof.retail:id/descText")).getText();
            System.out.println("Status is " + descpChck + " for Description");
            System.out.println("Description - " + descpValue);
            //Confirmation
            boolean confirmChck = driver.findElement(By.id("com.sof.retail:id/textViewResult")).isDisplayed();
            String confirmValue = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            System.out.println("Status is " + confirmChck + " for Confirmation");
            System.out.println("Confirmation Number - " + confirmValue);

            //Writing Transaction Number to Excel
            transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
            keys = "Transaction Number";
            ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
        } catch (Exception e) {
            System.out.println("Transaction Page not loaded");
        }

        //Clicking Ok Button
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(2000);

        //Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);
    }

    public static void WHDriverInvalidDriver() throws InterruptedException {
        testCase = 82;
        //Clicking WH Driver Checkin
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_wh_driver_checkin"));
        itemLookUpClick.click();
        Thread.sleep(4000);

        //Inside WH Driver Checkin
        actualText = driver.findElement(By.id("com.sof.retail:id/textBol")).getText();
        expectedText = "BOL";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Reading values from Excel
        keys = "BOL";
        //Selecting Invoice
        MobileElement bolData = (MobileElement) driver.findElementById("com.sof.retail:id/edtBol");
        bolData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Selecting Driver
        keys = "Driver";
        MobileElement driverData = (MobileElement) driver.findElementById("com.sof.retail:id/edtDriver");
        driverData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Selecting Incoming Security Seal
        keys = "Incoming Security Seal";
        MobileElement incSecSealData = (MobileElement) driver.findElementById("com.sof.retail:id/edtSeal");
        incSecSealData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

        //Clicking Ok
        driver.findElement(By.id("com.sof.retail:id/sendButton")).click();

        //Checking for error message
        try {
            boolean errorChck = driver.findElement(By.id("com.sof.retail:id/custom_dialog_layout")).isDisplayed();
            if (errorChck == true) {
                String errorTxt = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
                System.out.println(errorTxt + " error popup is displayed");
                Thread.sleep(2000);
            }

            //Clicking Ok Button
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        } catch (Exception e) {
            System.out.println("No error pop up is displayed");
        }

        //Closing App
        driver.closeApp();
    }

    public static void WHDriverCancelButton() throws InterruptedException {
        testCase = 84;
        //Clicking WH Driver Checkin
        MobileElement itemLookUpClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/nav_wh_driver_checkin"));
        itemLookUpClick.click();
        Thread.sleep(4000);

        //Inside WH Driver Checkin
        actualText = driver.findElement(By.id("com.sof.retail:id/textBol")).getText();
        expectedText = "BOL";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Reading values from Excel
        keys = "BOL";
        //Selecting Invoice
        MobileElement bolData = (MobileElement) driver.findElementById("com.sof.retail:id/edtBol");
        bolData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Selecting Driver
        keys = "Driver";
        MobileElement driverData = (MobileElement) driver.findElementById("com.sof.retail:id/edtDriver");
        driverData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Selecting Incoming Security Seal
        keys = "Incoming Security Seal";
        MobileElement incSecSealData = (MobileElement) driver.findElementById("com.sof.retail:id/edtSeal");
        incSecSealData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(2000);

        //Clicking Cancel Button
        driver.findElement(By.id("com.sof.retail:id/cancelButton")).click();
        Thread.sleep(2000);

        //Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Closing App
        driver.closeApp();
    }

}

