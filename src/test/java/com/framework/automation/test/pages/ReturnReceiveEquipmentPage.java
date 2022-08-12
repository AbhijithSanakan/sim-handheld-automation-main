package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;

public class ReturnReceiveEquipmentPage {
    static String keys;
    static int testCase;
    static String transNum;
    static String actualText;
    static String expectedText;
    static AndroidDriver<AndroidElement> driver;

    public ReturnReceiveEquipmentPage() throws IOException, InterruptedException {
        this.driver= Login.LoginDriver();
    }

    public static void ReturnReceiveClick() {
        driver.findElement(By.id("com.sof.retail:id/textViewTitle")).click();
        System.out.println("Clicked Receive & Return");
    }

    public static void VerifyView() throws InterruptedException {
        testCase = 28;

        MobileElement recvEquip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.FrameLayout/android.widget.ImageView");
        recvEquip.click();
        Thread.sleep(3000);

        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Receive Equipment";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        MobileElement daysDrpdown = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerPrinter");
        daysDrpdown.click();
        MobileElement days = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[10]");
        days.click();

        try {
            MobileElement view = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
            view.click();
            Thread.sleep(3000);

            String enterItems = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            Assert.assertEquals(enterItems, "Enter Items");
            System.out.println(enterItems + " is visible");
            boolean item = driver.findElement(By.id("com.sof.retail:id/textItemID")).isDisplayed();
            String itemNumber = driver.findElement(By.id("com.sof.retail:id/editTextItemID")).getText();
            System.out.println("Status is " + item + " for Bill Of Landing - " + itemNumber);
            boolean desc = driver.findElement(By.id("com.sof.retail:id/itemDescription")).isDisplayed();
            System.out.println("Status is " + desc + " for description");
            boolean recv = driver.findElement(By.id("com.sof.retail:id/descriptionTextHolder")).isDisplayed();
            System.out.println("Status is " + recv + " for recv");
            boolean inv = driver.findElement(By.id("com.sof.retail:id/InvoiceValue")).isDisplayed();
            System.out.println("Status is " + inv + " for inv");
            driver.findElement(By.id("com.sof.retail:id/button")).click();
            Thread.sleep(3000);

            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Comments";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            try {
                driver.findElement(By.id("com.sof.retail:id/etComment")).sendKeys("Sample Comment");
                System.out.println("Comment box is editable");
            } catch (Exception e) {
                System.out.println("Comment box is non editable");

            }
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            Thread.sleep(3000);

            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Summary";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            boolean recvBy = driver.findElement(By.id("com.sof.retail:id/txtBy")).isDisplayed();
            String receivedBy = driver.findElement(By.id("com.sof.retail:id/textReturnBy")).getText();
            System.out.println("Status is " + recvBy + " for Received By - " + receivedBy);
            boolean po = driver.findElement(By.id("com.sof.retail:id/itemCounted")).isDisplayed();
            String poNumber = driver.findElement(By.id("com.sof.retail:id/textPONumber")).getText();
            System.out.println("Status is " + po + " for PO# - " + poNumber);
            boolean supplier = driver.findElement(By.id("com.sof.retail:id/textViewSupplierName")).isDisplayed();
            String supplierName = driver.findElement(By.id("com.sof.retail:id/textSupplierName")).getText();
            System.out.println("Status is " + supplier + " for Supplier - " + supplierName);
            boolean started = driver.findElement(By.id("com.sof.retail:id/statDate")).isDisplayed();
            String startedTime = driver.findElement(By.id("com.sof.retail:id/textStartedTime")).getText();
            System.out.println("Status is " + started + " for Started - " + startedTime);
            boolean descGrid = driver.findElement(By.id("com.sof.retail:id/txtBy")).isDisplayed();
            boolean qtyGrid = driver.findElement(By.id("com.sof.retail:id/txtBy")).isDisplayed();
            if (descGrid == true && qtyGrid == true) {
                System.out.println("Description & Qty grid is displayed");
            }
            boolean descrption = driver.findElement(By.id("com.sof.retail:id/descpText")).isDisplayed();
            boolean qty = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
            if (descrption == true && qty == true) {
                System.out.println("Item Description & Qty count is displayed");
            }
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            Thread.sleep(3000);

            String headerBck = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            Assert.assertEquals(headerBck, "Receive Equipment");
            System.out.println(headerBck + " is visible");
        }
        catch (Exception e) {
            String noPoAvail = driver.findElement(By.id("com.sof.retail:id/purchaseOrderNoData")).getText();
            System.out.println(noPoAvail);
        }

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void EquipStore() throws InterruptedException {
        testCase = 129;

        MobileElement retnEquip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView");
        retnEquip.click();
        Thread.sleep(3000);

        //Return Equipment
        String header = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(header, "Return Equipment");
        System.out.println(header + " is visible");
        MobileElement store = (MobileElement) driver.findElementById("com.sof.retail:id/storeRadioButton");
        store.click();
        Thread.sleep(4000);
        MobileElement depDropdown = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        depDropdown.click();
        MobileElement dropdown = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup");
        dropdown.click();
        String carrier = driver.findElement(By.id("com.sof.retail:id/carrierTextView")).getText();
        Assert.assertEquals(carrier, "Carrier");
        System.out.println(carrier + " section is visible");
        MobileElement storeDropdown = (MobileElement) driver.findElementById("com.sof.retail:id/storeSpinner");
        storeDropdown.click();
        MobileElement storeName = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        storeName.click();
        MobileElement carrierDropdown = (MobileElement) driver.findElementById("com.sof.retail:id/carrierSpinner");
        carrierDropdown.click();
        MobileElement carrierName = (MobileElement) driver.findElementById("com.sof.retail:id/storeSpinner");
        carrierName.click();

        keys = "Truck/Trailer";
        MobileElement truckId = (MobileElement) driver.findElementById("com.sof.retail:id/editTextTruckNumber");
        truckId.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        boolean notAvailChckbox = driver.findElement(By.id("com.sof.retail:id/notAvailableChecbox")).isDisplayed();
        System.out.println("Status is " +notAvailChckbox+ " for Truck Not Available Checkbox" );
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(3000);

        //Enter Items
        MobileElement itemId = (MobileElement) driver.findElementById("com.sof.retail:id/editTextItemID");
        itemId.sendKeys("65176");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement reqSerialNum = (MobileElement) driver.findElementById("com.sof.retail:id/buttonRequiresSerialNumber");
//        reqSerialNum.click();
//        MobileElement confirm = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
//        confirm.click();
        MobileElement returnCount = (MobileElement) driver.findElementById("com.sof.retail:id/editTextReturn");
        returnCount.sendKeys("50");
        Actions action1 = new Actions(driver);
        action1.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Comments
        String comment = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(comment, "Comments");
        System.out.println(comment + " is visible");
        MobileElement enterCom = (MobileElement) driver.findElementById("com.sof.retail:id/etComment");
        enterCom.sendKeys("Return this equipment.");
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Summary
        String summary = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(summary, "Summary");
        System.out.println(summary + " is visible");
        boolean sendBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " +sendBtn+ " for SEND Button" );

        boolean recvBy = driver.findElement(By.id("com.sof.retail:id/txtBy")).isDisplayed();
        String receivedBy = driver.findElement(By.id("com.sof.retail:id/textReturnBy")).getText();
        System.out.println("Status is " + recvBy + " for Received By - " + receivedBy);
        boolean started = driver.findElement(By.id("com.sof.retail:id/statDate")).isDisplayed();
        String startedTime = driver.findElement(By.id("com.sof.retail:id/textStartedTime")).getText();
        System.out.println("Status is " + started + " for Started - " + startedTime);
        boolean descGrid = driver.findElement(By.id("com.sof.retail:id/txtBy")).isDisplayed();
        boolean qtyGrid = driver.findElement(By.id("com.sof.retail:id/txtBy")).isDisplayed();
        if(descGrid==true && qtyGrid==true) {
            System.out.println("Description & Qty grid is displayed");
        }
        boolean descrption = driver.findElement(By.id("com.sof.retail:id/descpText")).isDisplayed();
        boolean qty = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        if(descrption==true && qty==true) {
            System.out.println("Item Description & Qty count is displayed");
        }
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(5000);

        //Transaction
        String transaction = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(transaction, "Transaction");
        System.out.println(transaction + " screen is visible");
        boolean confNumber = driver.findElement(By.id("com.sof.retail:id/descpCountText")).isDisplayed();
        if(confNumber==true) {
            System.out.println("Confirmation Number is loaded for the equipment returned");
        }

        boolean sentDate = driver.findElement(By.id("com.sof.retail:id/textViewDate")).isDisplayed();
        boolean sentBy = driver.findElement(By.id("com.sof.retail:id/textViewSenderName")).isDisplayed();
        if(sentDate==true && sentBy==true) {
            System.out.println("Sent details with Date & Time stamp is loaded");
        }
        //Writing Transaction Number to Excel
        transNum = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(8000);

        //Back to Return Equipment
        String headerBck = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(headerBck, "Return Equipment");
        System.out.println(headerBck + " is visible");

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void VerifyReturnEquip() throws InterruptedException {
        testCase = 131;

        MobileElement retnEquip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.TextView");
        retnEquip.click();
        Thread.sleep(8000);

        //Return Equipment
        String header = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(header, "Return Equipment");
        System.out.println(header + " is visible");
        String departmentDropdown = driver.findElement(By.id("com.sof.retail:id/departmentSpinner")).getText();
        Assert.assertEquals(departmentDropdown, "Enter Department Name");
        System.out.println("Department Dropdown is visible");
        String chooseEquip = driver.findElement(By.id("com.sof.retail:id/chooseDestHintText")).getText();
        Assert.assertEquals(chooseEquip, "Choose Equipment Destination");
        System.out.println("Choose Equipment Destination is visible");
        boolean storeBtn = driver.findElement(By.id("com.sof.retail:id/storeRadioButton")).isDisplayed();
        System.out.println("Status is " +storeBtn+ " for Store Button");
        boolean disposeBtn = driver.findElement(By.id("com.sof.retail:id/disposeRadioButton")).isDisplayed();
        System.out.println("Status is " +disposeBtn+ " for Dispose Button");
        boolean equipWhBtn = driver.findElement(By.id("com.sof.retail:id/equipRadioButton")).isDisplayed();
        System.out.println("Status is " +equipWhBtn+ " for Equip.WH Button");
        boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/equipRadioButton")).isDisplayed();
        System.out.println("Status is " +nextBtn+ " for NEXT Button");
        boolean virtualKey = driver.findElement(By.id("com.sof.retail:id/ccImagePrint")).isDisplayed();
        System.out.println("Status is " +virtualKey+ " for Virtual Keyboard Icon");
        boolean discardBtn = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
        System.out.println("Status is " +discardBtn+ " for NEXT Button");
        Thread.sleep(4000);

        //Choosing Department
        MobileElement drpdown = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        drpdown.click();
        MobileElement drpdownName = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup");
        drpdownName.click();

        //Choosing Store as Equipment Destination
        MobileElement store = (MobileElement) driver.findElementById("com.sof.retail:id/storeRadioButton");
        store.click();
        boolean storeDropdown = driver.findElement(By.id("com.sof.retail:id/departmentSpinner")).isDisplayed();
        System.out.println("Status is " +storeDropdown+ " for Store Dropdown");
        String carrier = driver.findElement(By.id("com.sof.retail:id/carrierTextView")).getText();
        Assert.assertEquals(carrier, "Carrier");
        System.out.println("Carrier Section is visible");
        String carrierDropdown = driver.findElement(By.id("com.sof.retail:id/carrierSpinner")).getText();
        Assert.assertEquals(carrierDropdown, "Enter Carrier");
        System.out.println("Carrier Dropdown is visible");
        String truckTrailer = driver.findElement(By.id("com.sof.retail:id/truckHintTextView")).getText();
        Assert.assertEquals(truckTrailer, "Truck / Trailer #");
        System.out.println("Truck/Trailer# is visible");
        String notAvailChkbox = driver.findElement(By.id("com.sof.retail:id/notAvailableChecbox")).getText();
        Assert.assertEquals(notAvailChkbox, "Not Available");
        System.out.println("Not Available Checkbox is visible");

        //Clicking on Store & Carrier Dropdown
        MobileElement storeDrpdown = (MobileElement) driver.findElementById("com.sof.retail:id/storeSpinner");
        storeDrpdown.click();
        MobileElement storeName = (MobileElement) driver.findElementById("com.sof.retail:id/departmentSpinner");
        storeName.click();
        MobileElement carrierDrpdown = (MobileElement) driver.findElementById("com.sof.retail:id/carrierSpinner");
        carrierDrpdown.click();
        MobileElement carrierName = (MobileElement) driver.findElementById("com.sof.retail:id/storeSpinner");
        carrierName.click();
        MobileElement truckId = (MobileElement) driver.findElementById("com.sof.retail:id/editTextTruckNumber");
        truckId.sendKeys("Eicher100");
        driver.findElement(By.id("com.sof.retail:id/notAvailableChecbox")).click();

        //Choosing Equip.WH as Equipment Destination
        MobileElement equipWh = (MobileElement) driver.findElementById("com.sof.retail:id/equipRadioButton");
        equipWh.click();
        String carrierEquip = driver.findElement(By.id("com.sof.retail:id/carrierTextView")).getText();
        Assert.assertEquals(carrierEquip, "Carrier");
        System.out.println("Carrier Section is visible");
        boolean carrierDropdownEquip = driver.findElement(By.id("com.sof.retail:id/carrierSpinner")).isDisplayed();
        System.out.println("Status is " +carrierDropdownEquip+ " for Carrier Dropdown");
        String truckTrailerEquip = driver.findElement(By.id("com.sof.retail:id/truckHintTextView")).getText();
        Assert.assertEquals(truckTrailerEquip, "Truck / Trailer #");
        System.out.println("Truck / Trailer # is visible");
        String notAvailChkboxEquip = driver.findElement(By.id("com.sof.retail:id/notAvailableChecbox")).getText();
        Assert.assertEquals(notAvailChkboxEquip, "Not Available");
        System.out.println("Not Available Checkbox is visible");

        //Closing App
        driver.closeApp();
        driver.quit();
    }

}

