package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.an.E;
import org.apache.commons.io.input.TeeInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReturnReceivePage {

    static AndroidDriver<AndroidElement> driver;
    static String transNum;
    static String keys = null;
    static String actualText;
    static String expectedText;
    static int testCase;

    public ReturnReceivePage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static AndroidDriver<AndroidElement> ReturnReceiveClick() {
        driver.findElement(By.id("com.sof.retail:id/textViewTitle")).click();
        System.out.println("Clicked Return & Receive");
        return driver;
    }

    public static AndroidDriver<AndroidElement> ScreenVerify() throws InterruptedException {
        //RETURN & RECEIVE EXPANSION
        boolean receive = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.ImageView")).isDisplayed();
        System.out.println("Option status is " + receive + " for ReceiveDSD ");
        boolean returndsd = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.ImageView")).isDisplayed();
        System.out.println("Option status is " + returndsd + " for ReturnDSD ");
        boolean warehouse = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.TextView")).isDisplayed();
        System.out.println("Option status is " + warehouse + " for Warehouse Receiving ");
        boolean equip = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.TextView")).isDisplayed();
        System.out.println("Option status is " + equip + " for Receive Equipment ");
        boolean retEquip = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView")).isDisplayed();
        System.out.println("Option status is " + retEquip + " for Return Equipment ");

        driver.findElement(By.id("com.sof.retail:id/textViewTitle")).click();
        MobileElement navigate = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
        navigate.click();
        Thread.sleep(3000);

        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(381, 465))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(381, 140)).release().perform();

        MobileElement exit = (MobileElement) driver.findElementById("com.sof.retail:id/menuExit");
        exit.click();
        Thread.sleep(3000);
        MobileElement exitConfirm = (MobileElement) driver.findElementById("com.sof.retail:id/negativeButton");
        exitConfirm.click();
        Thread.sleep(3000);

        MobileElement navigatePage = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton");
        navigatePage.click();
        Thread.sleep(3000);

        TouchAction action1 = new TouchAction(driver);

        action1.press(PointOption.point(381, 465))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(381, 140)).release().perform();

        MobileElement logout = (MobileElement) driver.findElementById("com.sof.retail:id/menuLogout");
        logout.click();
        Thread.sleep(3000);
        MobileElement logoutConfirm = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        logoutConfirm.click();

        //Closing app
        driver.closeApp();
        driver.quit();

        return driver;
    }

    public static void ReceiveClick() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Return & Receive Visible");
        MobileElement el1 = (MobileElement) driver.findElementById("com.sof.retail:id/textViewTitle");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el2.click();
        Thread.sleep(10000);
    }

    public static void ReturnClick() throws InterruptedException {
        Thread.sleep(4000);
        MobileElement returnClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.ImageView");
        returnClick.click();
        Thread.sleep(3000);

    }

    public static void returnReceiveClick() throws InterruptedException {
        Thread.sleep(4000);
        //Clicking Receive & Return
        MobileElement retnRecvClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout");
        retnRecvClick.click();

    }

    public static void ReturnVerification() {
        testCase = 1;

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

        try {
            //Select Credit Page
            String invoice = driver.findElement(By.id("com.sof.retail:id/dsdReturnNoData")).getText();
            Assert.assertEquals(invoice, "No Invoices Available");
            System.out.println(invoice + " is visible");
            Thread.sleep(1000);

            String text = driver.findElement(By.id("com.sof.retail:id/selectInvoiceTitleTextView")).getText();
            Assert.assertEquals(text, "Select a credit below.");
            System.out.println(text + " is visible");
            Thread.sleep(1000);

            String credit = driver.findElement(By.id("com.sof.retail:id/selectInvoiceorPoNotAvailableButton")).getText();
            Assert.assertEquals(credit, "CREDIT NOT AVAILABLE");
            System.out.println(credit + " is visible");
            Thread.sleep(1000);

            boolean dropdown = driver.findElement(By.id("com.sof.retail:id/daysSpinnerLayout")).isDisplayed();
            if (dropdown == true) {
                System.out.println("Days Dropdown is visible");
            }


            boolean recvCheckBox = driver.findElement(By.id("com.sof.retail:id/receivedInvoiceCheckBox")).isDisplayed();
            if (recvCheckBox == true) {
                System.out.println(("Processed Returns checkbox is visible"));
            }
            Thread.sleep(1000);

            boolean discard = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
            System.out.println("Status is " + discard + " for Discard Button");
            Thread.sleep(1000);

            driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
            Thread.sleep(2000);

            //Pick Supplier Page
            String pickSupplierHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            Assert.assertEquals(pickSupplierHeader, "Pick Supplier");
            System.out.println(pickSupplierHeader + " is visible");
            Thread.sleep(2000);
            driver.closeApp();

        } catch (Exception e) {
            System.out.println("Invoice is present");

        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void Pickup() throws InterruptedException {
        testCase = 2;

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

        try {
            //Clicking CREDIT NOT AVAILABLE
            driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
            Thread.sleep(7000);

            //Verifying Pick Supplier Screen
            String supplier = driver.findElement(By.id("com.sof.retail:id/chooseSupplierLabelTextView")).getText();
            Assert.assertEquals(supplier, "Choose Supplier");
            System.out.println(supplier + " is visible");

            //Verifying Supplier Dropdown
            boolean supDropdown = driver.findElement(By.id("com.sof.retail:id/supplierSpinner")).isDisplayed();
            System.out.println("Status is " + supDropdown + " for Suppiler Dropdown");

            //Verifying Load all suppliers
            boolean loadSuppliers = driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).isDisplayed();
            System.out.println("Status is " + loadSuppliers + " for LOAD ALL SUPPLIERS");

            //Verifying Credit/Return
            String creditReturnTxt = driver.findElement(By.id("com.sof.retail:id/invoiceNumberLabelTextView")).getText();
            Assert.assertEquals(creditReturnTxt, "Enter Credit / Return Number");
            System.out.println(creditReturnTxt + " is visible");
            boolean creditReturnTxtBox = driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).isDisplayed();
            System.out.println("Status is " + creditReturnTxtBox + " for Enter Credit/Return textbox");

            //Clicking Supplier Dropdown
//            MobileElement drpdownClick = (MobileElement) driver.findElement(By.id("com.sof.retail:id/supplierSpinner"));
//            drpdownClick.click();

            System.out.println("-------------------");

//          Add new supplier
            driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).click();
            driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).click();

            try {

                boolean provideDialog = driver.findElement(By.id("com.sof.retail:id/dialog_message")).isDisplayed();
                System.out.println("Status is " + provideDialog + " for PROVIDE SUPPLIER");
                boolean newSupNameTxtBox = driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).isDisplayed();
                System.out.println("Status is " + newSupNameTxtBox + " for New Supplier Name Text Box");

                boolean btnCancel = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                boolean btnOk = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                System.out.println("Button status is " + btnCancel + " for CANCEL ");
                System.out.println("Button status is " + btnOk + " for OK ");


                keys = "Supplier";
                driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();

                driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).click();
                driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

//              USE NEW
                try {
                    driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                    driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                    System.out.println("ADD NEW Supplier was successfull");
                } catch (Exception e) {
                    System.out.println("Element Not Found");

                }

                driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).click();
                driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

//              USE ABOVE
                try {
                    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView\n")).click();
                    driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
                    System.out.println("USE ABOVE Supplier was successfull");
                    keys = "Credit/Return#";
                    driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                    driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
                    System.out.println("-------------------");


                    //Verifying Delivery Info
                    boolean btnType = driver.findElement(By.id("com.sof.retail:id/deliveryInfoChooseDeliveryTextView")).isDisplayed();
                    System.out.println("Button status is " + btnType + " for Choose Delivery / Truck Type ");
                    boolean btnDelivery = driver.findElement(By.id("com.sof.retail:id/deliveryInfoChooseDestinationTextView")).isDisplayed();
                    System.out.println("Button status is " + btnDelivery + " for Choose Destination ");
                    boolean btnReturn = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryInvoicePieceCountTextView")).isDisplayed();
                    System.out.println("Button status is " + btnReturn + " for Return piece count ");
                    boolean btnTotal = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryInvoicedQuantitiesCheckBox")).isDisplayed();
                    System.out.println("Button status is " + btnTotal + " for Base total on inv. qty. ");
                    boolean btnBack = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
                    System.out.println("Button status is " + btnBack + " for Back Button ");
                    boolean btnNext = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
                    System.out.println("Button status is " + btnNext + " for Next Button ");
                    System.out.println("-------------------");

                    //Selecting Delivery/Truck Type
                    MobileElement delTruckType = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoNormalRadioButton");
                    delTruckType.click();
                    //Selecting Destination
                    MobileElement delDest = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoInventoryRadioButton");
                    delDest.click();

                    keys = "Return Piece Count";
                    //Adding the Return Piece Count data From Excel
                    MobileElement rtnPieceCount = (MobileElement) driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicePieceCountEditText");
                    rtnPieceCount.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                    MobileElement nxtBtn = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
                    nxtBtn.click();

                    //Scan Items
                    keys = "UPC List 1";
                    MobileElement item1 = driver.findElement(By.id("com.sof.retail:id/upcScanText"));
                    item1.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                    Actions action = new Actions(driver);
                    action.sendKeys(Keys.ENTER).perform();
                    Thread.sleep(9000);

                    //Entering Return Quantity
                    keys = "Return Quantity";
                    MobileElement returnQty = (MobileElement) driver.findElementById("com.sof.retail:id/quantityValue");
                    returnQty.click();
                    returnQty.clear();
                    returnQty.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
                    action.sendKeys(Keys.ENTER).perform();

                    //Adding second item using Scan
                    keys = "UPC List 2";
                    MobileElement scanUpc = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
                    scanUpc.click();
                    MobileElement upcTxtBox = (MobileElement) driver.findElementById("com.sof.retail:id/dialogEditText");
                    upcTxtBox.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
                    MobileElement okBtn = (MobileElement) driver.findElementById("com.sof.retail:id/dialogOkButton");
                    okBtn.click();
                    Thread.sleep(4000);

                    TouchAction action1 = new TouchAction(driver);
                    action1.press(PointOption.point(285, 341))
                            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                            .moveTo(PointOption.point(142, 341)).release().perform();

                    //Deleting the added item
                    MobileElement delBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
                    delBtn.click();

                    //Clicking on Next
                    MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
                    next.click();

                    //Credit & GST Page
                    boolean gTotal = driver.findElement(By.id("com.sof.retail:id/grandTotalLabelTextView")).isDisplayed();
                    System.out.println("Button status is " + gTotal + " for Grand Total ");
                    boolean gst = driver.findElement(By.id("com.sof.retail:id/gstLabelTextView")).isDisplayed();
                    System.out.println("Button status is " + gst + " for GST ");
                    boolean dropdown = driver.findElement(By.id("com.sof.retail:id/dropDownImg")).isDisplayed();
                    System.out.println("Dropdown status is " + dropdown + " for Department ");
                    System.out.println("-------------------");

                    //Adding data to Grand Total
                    keys = "Grand Total";
                    MobileElement grandTotalData = (MobileElement) driver.findElementById("com.sof.retail:id/grandTotalEditText");
                    grandTotalData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

                    //Adding data to GST
                    keys = "GST";
                    MobileElement gstData = (MobileElement) driver.findElementById("com.sof.retail:id/gstEditText");
                    gstData.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

                    //Selecting value for Dropdown
                    keys = "Department";
                    MobileElement deptDrpdown = (MobileElement) driver.findElement(By.id("com.sof.retail:id/departmentSpinner"));
                    deptDrpdown.click();
                    deptDrpdown.clear();
                    deptDrpdown.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
                    action.sendKeys(Keys.ENTER).perform();
                    Thread.sleep(8000);

                    //Comment Page
                    String commentsHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    Assert.assertEquals(commentsHeader, "Comments");
                    System.out.println(commentsHeader + " is visible");
                    System.out.println("-------------------");
                    Thread.sleep(6000);
                    driver.findElement(By.id("com.sof.retail:id/button3")).click();
                    Thread.sleep(2000);

                    //Summary Page
                    String summaryHeader = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
                    Assert.assertEquals(summaryHeader, "Summary");
                    System.out.println(summaryHeader + " is visible");

                    boolean supplierChk = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
                    String supplierName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                    System.out.println("Visible Status is " +supplierChk+ " for Supplier - " +supplierName);

                    String recvInto = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
                    String recvIntoName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                    System.out.println(recvInto+ " - " +recvIntoName);

                    String grandTotal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
                    String grandTotalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                    System.out.println(grandTotal+ " - " +grandTotalValue);

                    String gstTotal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
                    String gstTotalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                    System.out.println(gstTotal+ " - " +gstTotalValue);

                    String dsdReturn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
                    String dsdReturnTime = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                    System.out.println(dsdReturn+ " - " +dsdReturnTime);

                    boolean description = driver.findElement(By.id("com.sof.retail:id/descpTextView")).isDisplayed();
                    System.out.println("Status is " + description + " for Description ");
                    boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).isDisplayed();
                    System.out.println("Status is " + qty + " for Quantity ");
                    boolean item = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
                    String itemName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
                    String itemQtyCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                    System.out.println("Item Description Status is " + item + " for Item - " +itemName+ " with Qty - " +itemQtyCount);
                    driver.findElement(By.id("com.sof.retail:id/button3")).click();

                    boolean dialog = driver.findElement(By.id("com.sof.retail:id/custom_dialog_layout")).isDisplayed();
                    System.out.println("Status is " + dialog + " for Vendor Information Dialog Box");
                    boolean ok = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                    System.out.println("Status is " + ok + " for OK Button");
                    System.out.println("-------------------");
                    driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
                    Thread.sleep(16000);

                    //Transaction Page
                    boolean title = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
                    System.out.println("Status is " + title + " for Transaction title");
                    boolean desc = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
                    System.out.println("Status is " + desc + " for Description");
                    boolean confirm = driver.findElement(By.id("com.sof.retail:id/textViewResult")).isDisplayed();
                    System.out.println("Status is " + confirm + " for Confirmation");
                    boolean descname = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
                    System.out.println("Status is " + descname + " for Description Name");
                    boolean transid = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
                    transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
                    System.out.println("Status is " + transid + " for Transaction Number");
                    boolean dt = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
                    System.out.println("Status is " + dt + " for Date & Time");
                    boolean name = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
                    System.out.println("Status is " + name + " for Sender Name");
                    Thread.sleep(3000);

                    //Writing Transaction Number to Excel
                    keys = "Transaction Number";
                    ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
                    Thread.sleep(2000);

                    driver.findElement(By.id("com.sof.retail:id/button")).click();


                } catch (Exception e) {

                }

            } catch (Exception e) {

            }
        } catch (Exception error) {
            System.out.println("No element found");
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void DeliveryInfo() throws InterruptedException {
        testCase = 3;

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

        driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
        Thread.sleep(14000);

        //Pickup Supplier Page
        MobileElement dropdown = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        dropdown.click();
        MobileElement supplier = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberLabelTextView");
        supplier.click();
        MobileElement invoice = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberEditText");

        keys = "Credit/Return#";
        invoice.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(2000);

        //Delivery Info Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Credit Return Info";
        TestAsserts.assertCheck(actualText,expectedText);

        //Selecting Supply as destination
        MobileElement el1 = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoSupplyRadioButton");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        el2.click();
        Thread.sleep(3000);

        //Credit & GST Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "DSD Return";
        TestAsserts.assertCheck(actualText,expectedText);

        boolean gTotal = driver.findElement(By.id("com.sof.retail:id/grandTotalLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gTotal + " for Grand Total ");
        boolean gst = driver.findElement(By.id("com.sof.retail:id/gstLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gst + " for GST ");
        boolean drpdown  = driver.findElement(By.id("com.sof.retail:id/dropDownImg")).isDisplayed();
        System.out.println("Dropdown status is " +drpdown+ " for Department ");
        System.out.println("-------------------");

        //Adding value to Grand Total
        keys = "Grand Total";
        MobileElement grand = (MobileElement) driver.findElementById("com.sof.retail:id/grandTotalEditText");
        grand.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //Adding value to GST
        keys = "GST";
        MobileElement gs = (MobileElement) driver.findElementById("com.sof.retail:id/gstEditText");
        gs.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        keys = "Department";
        MobileElement DrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        DrpdwnClick.click();
        DrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(214, 292)).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Comment Page
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Comments";
        TestAsserts.assertCheck(actualText,expectedText);

        //Checking for Comment Box
        boolean comment = driver.findElementById("com.sof.retail:id/etComment").isDisplayed();
        System.out.println("Status is " +comment+ " for Comment Box");

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Summary
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText,expectedText);

        //Verifying Suppiler Details
        boolean sup = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + sup + " for Supplier ");
        String supName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
        System.out.println("Status is " + sup + " for Supplier - " +supName);

        //Verifying Department Details
        boolean dept = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        String deptName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
        System.out.println("Status is " + dept + " for Department, Received Into - " +deptName);

        //Verifying Grand Total & GST
        boolean grandTotal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        String grandTotalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
        System.out.println("Status is " + grandTotal + " for Grand Total, Grand Total is : " +grandTotalValue);
        boolean totalGst = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        String gstTotalValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
        System.out.println("Status is " + totalGst + " for GST. GST Total is : " +gstTotalValue);

        //Verifying DSD Return Time
        boolean dsdReturnTime = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        String dsdReturnTimeValue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
        System.out.println("Status is " + dsdReturnTime + " for DSD Return Time. DSD Return Time is : " +dsdReturnTimeValue);

        //Verifying grid
        boolean description = driver.findElement(By.id("com.sof.retail:id/descpTextView")).isDisplayed();
        System.out.println("Status is " + description + " for Description ");
        boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).isDisplayed();
        System.out.println("Status is " + qty + " for Quantity ");
        boolean sendBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + sendBtn + " for SEND Button ");
        System.out.println("-------------------");


        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(16000);

        //Transaction Page
        boolean title = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        System.out.println("Status is " + title + " for Transaction title");
        boolean desc = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
        System.out.println("Status is " + desc + " for Description");
        boolean confirm = driver.findElement(By.id("com.sof.retail:id/textViewResult")).isDisplayed();
        System.out.println("Status is " + confirm + " for Confirmation");
        boolean descName = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        String descNameValue = driver.findElement(By.id("com.sof.retail:id/descText")).getText();
        System.out.println("Status is " + descName + " for Description Name - " +descNameValue);
        boolean transid = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        System.out.println("Status is " + transid + " for Transaction Number");
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        boolean dt = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        String dtValue = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
        System.out.println("Status is " + dt + " for Date & Time - " +dtValue);
        boolean name = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        String nameValue = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).getText();
        System.out.println("Status is " + name + " for Sender Name, Sender - " +nameValue);
        boolean okBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + okBtn + " for Ok Button");
        System.out.println("-------------------");
        Thread.sleep(3000);

        //Writing Transaction Number to Excel
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
        Thread.sleep(2000);

        //Clicking on Ok Button
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(2000);

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void EnclosureInventory() throws InterruptedException {
        testCase = 4;

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

        driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
        Thread.sleep(12000);

        //Pickup Supplier Page
        MobileElement dropdown = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        dropdown.click();
        MobileElement supplier = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberLabelTextView");
        supplier.click();
        MobileElement invoice = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberEditText");
        invoice.sendKeys("ENCLO200");
        MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(3000);

        //Delivery Info Page
        MobileElement enclosure = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoEnclosureRadioButton");
        enclosure.click();
        MobileElement inventory = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoInventoryRadioButton");
        inventory.click();
        MobileElement count = (MobileElement) driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicePieceCountEditText");
        count.sendKeys("10");
        driver.findElementById("com.sof.retail:id/button3").click();
        Thread.sleep(3000);

        //Scan Items
        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys("555");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
        MobileElement uom = (MobileElement) driver.findElementById("com.sof.retail:id/tv_spinner_txt");
        uom.click();
        MobileElement unit = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        unit.click();
        driver.findElementById("com.sof.retail:id/button3").click();
        Thread.sleep(3000);

        //Credit & GST Page
        boolean gTotal = driver.findElement(By.id("com.sof.retail:id/grandTotalLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gTotal + " for Grand Total ");
        boolean gst = driver.findElement(By.id("com.sof.retail:id/gstLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gst + " for GST ");
        boolean drpdown = driver.findElement(By.id("com.sof.retail:id/dropDownImg")).isDisplayed();
        System.out.println("Dropdown status is " + drpdown + " for Department ");
        System.out.println("-------------------");

        //Adding value to Grand Total
        keys = "Grand Total";
        MobileElement grand = (MobileElement) driver.findElementById("com.sof.retail:id/grandTotalEditText");
        grand.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //Adding value to GST
        keys = "GST";
        MobileElement gs = (MobileElement) driver.findElementById("com.sof.retail:id/gstEditText");
        gs.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        keys = "Department";
        MobileElement DrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        DrpdwnClick.click();
        DrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(214, 292)).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Comment Page
        MobileElement comment = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        comment.click();
        Thread.sleep(3000);

        //Summary
        boolean summary = driver.findElement(By.id("com.sof.retail:id/llSummaryItem")).isDisplayed();
        System.out.println("Status is " + summary + " for Summary ");
        boolean description = driver.findElement(By.id("com.sof.retail:id/descpTextView")).isDisplayed();
        System.out.println("Status is " + description + " for Description ");
        boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).isDisplayed();
        System.out.println("Status is " + qty + " for Quantity ");
        boolean sup = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + sup + " for Supplier ");
        boolean dept = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + dept + " for Received Dept ");
        boolean grandTotal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + grandTotal + " for Grand Total ");
        boolean totalGst = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + totalGst + " for GST ");
        boolean sendBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + sendBtn + " for SEND Button ");
        System.out.println("-------------------");

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(16000);

        //Transaction Page
        boolean title = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        System.out.println("Status is " + title + " for Transaction title");
        boolean desc = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
        System.out.println("Status is " + desc + " for Description");
        boolean confirm = driver.findElement(By.id("com.sof.retail:id/textViewResult")).isDisplayed();
        System.out.println("Status is " + confirm + " for Confirmation");
        boolean descname = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        System.out.println("Status is " + descname + " for Description Name");
        boolean transid = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        System.out.println("Status is " + transid + " for Transaction Number");
        boolean dt = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        System.out.println("Status is " + dt + " for Date & Time");
        boolean name = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        System.out.println("Status is " + name + " for Sender Name");
        driver.findElement(By.id("com.sof.retail:id/button")).click();

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void EnclosureSupply() throws InterruptedException {
        testCase = 5;

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

        driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
        Thread.sleep(10000);

        //Pickup Supplier Page
        MobileElement dropdown = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        dropdown.click();
        MobileElement supplier = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberLabelTextView");
        supplier.click();
        MobileElement invoice = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberEditText");
        invoice.sendKeys("ENCLO100");
        MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(3000);

        //Delivery Info Page
        MobileElement enclosure = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoEnclosureRadioButton");
        enclosure.click();
        MobileElement Supply = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoSupplyRadioButton");
        Supply.click();
        driver.findElementById("com.sof.retail:id/button3").click();
        Thread.sleep(3000);

        //Credit & GST Page
        boolean gTotal = driver.findElement(By.id("com.sof.retail:id/grandTotalLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gTotal + " for Grand Total ");
        boolean gst = driver.findElement(By.id("com.sof.retail:id/gstLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gst + " for GST ");
        boolean drpdown = driver.findElement(By.id("com.sof.retail:id/dropDownImg")).isDisplayed();
        System.out.println("Dropdown status is " + drpdown + " for Department ");
        System.out.println("-------------------");

        //Adding value to Grand Total
        keys = "Grand Total";
        MobileElement grand = (MobileElement) driver.findElementById("com.sof.retail:id/grandTotalEditText");
        grand.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //Adding value to GST
        keys = "GST";
        MobileElement gs = (MobileElement) driver.findElementById("com.sof.retail:id/gstEditText");
        gs.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

//        driver.context("WEBVIEW_1");
//        WebElement selectElement = (WebElement) driver.findElements(By.id("com.sof.retail:id/supplierSpinner"));
//        Select drop = new Select(selectElement);
//        drop.selectByVisibleText("BAKERY (15)");

        keys = "Department";
        MobileElement DrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        DrpdwnClick.click();
        DrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(214, 292)).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Comment Page
        MobileElement comment = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        comment.click();
        Thread.sleep(3000);

        //Summary
        boolean summary = driver.findElement(By.id("com.sof.retail:id/llSummaryItem")).isDisplayed();
        System.out.println("Status is " + summary + " for Summary ");
        boolean description = driver.findElement(By.id("com.sof.retail:id/descpTextView")).isDisplayed();
        System.out.println("Status is " + description + " for Description ");
        boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).isDisplayed();
        System.out.println("Status is " + qty + " for Quantity ");
        boolean sup = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + sup + " for Supplier ");
        boolean dept = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + dept + " for Received Dept ");
        boolean grandTotal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + grandTotal + " for Grand Total ");
        boolean totalGst = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + totalGst + " for GST ");
        boolean sendBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + sendBtn + " for SEND Button ");
        System.out.println("-------------------");

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(16000);

        //Transaction Page
        boolean title = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        System.out.println("Status is " + title + " for Transaction title");
        boolean desc = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
        System.out.println("Status is " + desc + " for Description");
        boolean confirm = driver.findElement(By.id("com.sof.retail:id/textViewResult")).isDisplayed();
        System.out.println("Status is " + confirm + " for Confirmation");
        boolean descname = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        System.out.println("Status is " + descname + " for Description Name");
        boolean transid = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        System.out.println("Status is " + transid + " for Transaction Number");
        boolean dt = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        System.out.println("Status is " + dt + " for Date & Time");
        boolean name = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        System.out.println("Status is " + name + " for Sender Name");
        driver.findElement(By.id("com.sof.retail:id/button")).click();

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void CourierInventory() throws InterruptedException {
        testCase = 6;

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

        driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
        Thread.sleep(10000);

        //Pickup Supplier Page
        MobileElement dropdown = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        dropdown.click();
        MobileElement supplier = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberLabelTextView");
        supplier.click();
        MobileElement invoice = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberEditText");
        invoice.sendKeys("COURIER120");
        MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(3000);

        //Delivery Info Page
        MobileElement courier = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoCourierRadioButton");
        courier.click();
        MobileElement inventory = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoInventoryRadioButton");
        inventory.click();

        keys = "Return Piece Count";
        //Adding the Return Piece Count data From Excel
        MobileElement rtnPieceCount = (MobileElement) driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicePieceCountEditText");
        rtnPieceCount.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        MobileElement nxtBtn = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        nxtBtn.click();
        Thread.sleep(3000);

        //Scan Items
        keys = "UPC List 1";
        MobileElement item1 = driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        item1.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
        MobileElement uom = (MobileElement) driver.findElementById("com.sof.retail:id/tv_spinner_txt");
        uom.click();
        MobileElement unit = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        unit.click();
        driver.findElementById("com.sof.retail:id/button3").click();
        Thread.sleep(3000);

        //Credit & GST Page
        boolean gTotal = driver.findElement(By.id("com.sof.retail:id/grandTotalLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gTotal + " for Grand Total ");
        boolean gst = driver.findElement(By.id("com.sof.retail:id/gstLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gst + " for GST ");
        boolean drpdown = driver.findElement(By.id("com.sof.retail:id/dropDownImg")).isDisplayed();
        System.out.println("Dropdown status is " + drpdown + " for Department ");
        System.out.println("-------------------");

        //Adding value to Grand Total
        keys = "Grand Total";
        MobileElement grand = (MobileElement) driver.findElementById("com.sof.retail:id/grandTotalEditText");
        grand.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //Adding value to GST
        keys = "GST";
        MobileElement gs = (MobileElement) driver.findElementById("com.sof.retail:id/gstEditText");
        gs.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        keys = "Department";
        MobileElement DrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        DrpdwnClick.click();
        DrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(214, 292)).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Comment Page
        MobileElement comment = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        comment.click();
        Thread.sleep(3000);

        //Summary
        boolean summary = driver.findElement(By.id("com.sof.retail:id/llSummaryItem")).isDisplayed();
        System.out.println("Status is " + summary + " for Summary ");
        boolean description = driver.findElement(By.id("com.sof.retail:id/descpTextView")).isDisplayed();
        System.out.println("Status is " + description + " for Description ");
        boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).isDisplayed();
        System.out.println("Status is " + qty + " for Quantity ");
        boolean sup = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + sup + " for Supplier ");
        boolean dept = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + dept + " for Received Dept ");
        boolean grandTotal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + grandTotal + " for Grand Total ");
        boolean totalGst = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + totalGst + " for GST ");
        boolean sendBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + sendBtn + " for SEND Button ");
        System.out.println("-------------------");

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(16000);

        //Transaction Page
        boolean title = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        System.out.println("Status is " + title + " for Transaction title");
        boolean desc = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
        System.out.println("Status is " + desc + " for Description");
        boolean confirm = driver.findElement(By.id("com.sof.retail:id/textViewResult")).isDisplayed();
        System.out.println("Status is " + confirm + " for Confirmation");
        boolean descname = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        System.out.println("Status is " + descname + " for Description Name");
        boolean transid = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        System.out.println("Status is " + transid + " for Transaction Number");
        boolean dt = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        System.out.println("Status is " + dt + " for Date & Time");
        boolean name = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        System.out.println("Status is " + name + " for Sender Name");
        driver.findElement(By.id("com.sof.retail:id/button")).click();

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void CourierSupply() throws InterruptedException {
        testCase = 7;

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

        driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
        Thread.sleep(10000);

        //Pickup Supplier Page
        MobileElement dropdown = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        dropdown.click();
        MobileElement supplier = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberLabelTextView");
        supplier.click();
        MobileElement invoice = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberEditText");
        invoice.sendKeys("COURIER100");
        MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();
        Thread.sleep(3000);

        //Delivery Info Page
        MobileElement courier = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoCourierRadioButton");
        courier.click();
        MobileElement Supply = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoSupplyRadioButton");
        Supply.click();
        driver.findElementById("com.sof.retail:id/button3").click();
        Thread.sleep(3000);

        //Credit & GST Page
        boolean gTotal = driver.findElement(By.id("com.sof.retail:id/grandTotalLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gTotal + " for Grand Total ");
        boolean gst = driver.findElement(By.id("com.sof.retail:id/gstLabelTextView")).isDisplayed();
        System.out.println("Button status is " + gst + " for GST ");
        boolean drpdown = driver.findElement(By.id("com.sof.retail:id/dropDownImg")).isDisplayed();
        System.out.println("Dropdown status is " + drpdown + " for Department ");
        System.out.println("-------------------");

        //Adding value to Grand Total
        keys = "Grand Total";
        MobileElement grand = (MobileElement) driver.findElementById("com.sof.retail:id/grandTotalEditText");
        grand.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //Adding value to GST
        keys = "GST";
        MobileElement gs = (MobileElement) driver.findElementById("com.sof.retail:id/gstEditText");
        gs.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

//        driver.context("WEBVIEW_1");
//        WebElement selectElement = (WebElement) driver.findElements(By.id("com.sof.retail:id/supplierSpinner"));
//        Select drop = new Select(selectElement);
//        drop.selectByVisibleText("BAKERY (15)");

        keys = "Department";
        MobileElement DrpdwnClick = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        DrpdwnClick.click();
        DrpdwnClick.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Thread.sleep(1000);
        //Tapping value
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(214, 292)).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Comment Page
        MobileElement comment = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        comment.click();
        Thread.sleep(3000);

        //Summary
        boolean summary = driver.findElement(By.id("com.sof.retail:id/llSummaryItem")).isDisplayed();
        System.out.println("Status is " + summary + " for Summary ");
        boolean description = driver.findElement(By.id("com.sof.retail:id/descpTextView")).isDisplayed();
        System.out.println("Status is " + description + " for Description ");
        boolean qty = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).isDisplayed();
        System.out.println("Status is " + qty + " for Quantity ");
        boolean sup = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + sup + " for Supplier ");
        boolean dept = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + dept + " for Received Dept ");
        boolean grandTotal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + grandTotal + " for Grand Total ");
        boolean totalGst = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
        System.out.println("Status is " + totalGst + " for GST ");
        boolean sendBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + sendBtn + " for SEND Button ");
        System.out.println("-------------------");

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(16000);

        //Transaction Page
        boolean title = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
        System.out.println("Status is " + title + " for Transaction title");
        boolean desc = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
        System.out.println("Status is " + desc + " for Description");
        boolean confirm = driver.findElement(By.id("com.sof.retail:id/textViewResult")).isDisplayed();
        System.out.println("Status is " + confirm + " for Confirmation");
        boolean descname = driver.findElement(By.id("com.sof.retail:id/descText")).isDisplayed();
        System.out.println("Status is " + descname + " for Description Name");
        boolean transid = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        System.out.println("Status is " + transid + " for Transaction Number");
        boolean dt = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        System.out.println("Status is " + dt + " for Date & Time");
        boolean name = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        System.out.println("Status is " + name + " for Sender Name");
        driver.findElement(By.id("com.sof.retail:id/button")).click();

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void ScanItems() throws InterruptedException {
        testCase = 8;

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
        driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
        Thread.sleep(10000);

        //Pickup Supplier Page
        MobileElement dropdown = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        dropdown.click();
        MobileElement supplier = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberLabelTextView");
        supplier.click();
        MobileElement invoice = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberEditText");
        invoice.sendKeys("120120");
        MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        next.click();

        //Delivery Info Page
        MobileElement enclosure = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoEnclosureRadioButton");
        enclosure.click();
        MobileElement inventory = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoInventoryRadioButton");
        inventory.click();
        MobileElement count = (MobileElement) driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicePieceCountEditText");
        count.sendKeys("10");
        driver.findElementById("com.sof.retail:id/button3").click();

        //Scan Items
        boolean UPC = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isDisplayed();
        System.out.println("Status is " + UPC + " for UPC field");
        boolean UOM = driver.findElement(By.id("com.sof.retail:id/whrUnitSpinner")).isDisplayed();
        System.out.println("Status is " + UOM + " for UOM dropdown");
        boolean description = driver.findElement(By.id("com.sof.retail:id/descriptionText")).isDisplayed();
        System.out.println("Status is " + description + " for description grid");
        boolean returngrid = driver.findElement(By.id("com.sof.retail:id/qtyText")).isDisplayed();
        System.out.println("Status is " + returngrid + " for return grid");
        boolean transbar = driver.findElement(By.id("com.sof.retail:id/bottomProgressBar")).isDisplayed();
        System.out.println("Status is " + transbar + " for transaction bar");
        boolean backBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + backBtn + " for BACK button");
        boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + nextBtn + " for NEXT button");
        System.out.println("-------------------");
        driver.findElementById("com.sof.retail:id/button3").click();

        String dialog = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
        Assert.assertEquals(dialog, "Please add atleast one item.");
        System.out.println(dialog + " is Displayed");
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys("12");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        String error = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
        Assert.assertEquals(error, "UPC/PLU not found");
        System.out.println(error + " is Displayed");
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys("555");
        Actions action1 = new Actions(driver);
        action1.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
        MobileElement uom = (MobileElement) driver.findElementById("com.sof.retail:id/tv_spinner_txt");
        uom.click();
        MobileElement unit = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        unit.click();

        TouchAction action2 = new TouchAction(driver);

        action2.press(PointOption.point(268, 301))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(142, 301)).release().perform();

        boolean deleteBtn = driver.findElement(By.id("com.sof.retail:id/itemDelete")).isDisplayed();
        System.out.println("Status is " + deleteBtn + " for Delete button");
        String rtn = driver.findElement(By.id("com.sof.retail:id/currentItemCount")).getText();
        System.out.println("Number of Returns = " + rtn);

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void Verification() {

        try {
            //RECEIVE PAGE WITH NO INVOICE
            String invoice = driver.findElement(By.id("com.sof.retail:id/dsdReceiveNoData")).getText();
            Assert.assertEquals(invoice, "All Invoices Received");
            System.out.println(invoice + " is visible");

            String text = driver.findElement(By.id("com.sof.retail:id/selectInvoiceTitleTextView")).getText();
            Assert.assertTrue(driver.findElement(By.id("com.sof.retail:id/selectInvoiceTitleTextView")).isDisplayed());
            Assert.assertEquals(text, "Select an invoice below or scan pallet.");
            System.out.println(text + " is visible");

            WebElement dropdown = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView"));
            Boolean displayed = dropdown.isDisplayed();
            if (displayed == true) {
                System.out.println("Dropdown is visible");
            }

            WebElement checkbox = driver.findElement(By.id("com.sof.retail:id/receivedInvoiceCheckBox"));
            boolean isDisplayed = checkbox.isDisplayed();
            if (isDisplayed == true) {
                System.out.println(("Received checkbox is visible"));
            }

            boolean discard = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
            System.out.println("Status is " + discard + " for Discard Button");

        } catch (Exception e) {
            //RECEIVE PAGE WITH INVOICE
            System.out.println("Invoice is present");
            WebElement checkbox = driver.findElement(By.id("com.sof.retail:id/receivedInvoiceCheckBox"));
            checkbox.click();

            try {

                driver.findElement(By.id("com.sof.retail:id/tvScanItemName"));
                System.out.println("Vendor name is visible");

                String inv = driver.findElement(By.id("com.sof.retail:id/tvInvoiceOrPoValue")).getText();
                System.out.println("Invoice & PO number is visible");

                driver.findElement(By.id("com.sof.retail:id/tvInvoiceTime"));
                System.out.println("Invoiced time is visible");

                driver.findElement(By.id("com.sof.retail:id/tvOrderedValue"));
                System.out.println("Invoiced item count is visible");

                driver.findElement(By.id("com.sof.retail:id/btnReceive"));
                System.out.println("Received, View Button is visible");

                MobileElement el2 = (MobileElement) driver.findElementById("android:id/text1");
                el2.click();
                MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
                el3.click();

                int startY = 241;
                int endY = 308;
                TouchAction action = new TouchAction(driver);
                int startX = 307;
                int endX = 173;
                action.press(PointOption.point(241, 330))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                        .moveTo(PointOption.point(243, 498)).release().perform();

            }
            catch (Exception e1) {
                System.out.println("Element not found");
            }
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }
}
