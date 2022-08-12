package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import gherkin.lexer.Th;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import schemasMicrosoftComOfficeExcel.STObjectType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class WarehouseReceivingPage {

    static AndroidDriver<AndroidElement> driver;
    static int testCase;
    static String transNum;
    static String keys = null;
    static String actualText;
    static String expectedText;

    public WarehouseReceivingPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void RecvRetClick() throws InterruptedException {
        //Clicking Receive & Return
        driver.findElement(By.id("com.sof.retail:id/textViewTitle")).click();
        System.out.println("Clicked Receive & Return");
        Thread.sleep(4000);
    }

    public static void wareHouseRecvClick() throws InterruptedException {
        //Clicking Warehouse Receiving
        MobileElement warehouseRecv = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[3]/android.widget.FrameLayout/android.widget.ImageView");
        warehouseRecv.click();
        Thread.sleep(6000);
    }

    public static AndroidDriver<AndroidElement> VerifyScreen() throws InterruptedException {
        testCase = 11;
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
        Thread.sleep(7000);

        //Warehouse Receiving Header
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Warehouse Receiving";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Warehouse Receiving Page
        boolean staticTxt = driver.findElement(By.id("com.sof.retail:id/tvSelectBols")).isDisplayed();
        System.out.println("Visible status is " + staticTxt + " for Static Text ");
        boolean bolField = driver.findElement(By.id("com.sof.retail:id/editTextFindBol")).isDisplayed();
        System.out.println("Status is " + bolField + " BOL Manually Entering Field ");
        boolean dropdown = driver.findElement(By.id("android:id/text1")).isDisplayed();
        System.out.println("Dropdown status is " + dropdown + " for Days ");
        boolean receiveChck = driver.findElement(By.id("com.sof.retail:id/cbReceivedBols")).isDisplayed();
        System.out.println("Checkbox status is " + receiveChck + " for Received BOL ");

        boolean receive = driver.findElement(By.id("com.sof.retail:id/btnReceive")).isDisplayed();
        if (receive == true) {
            System.out.println("Received BOL is displayed");
        }

        //Clicking Received BOLs Button
        driver.findElement(By.id("com.sof.retail:id/cbReceivedBols")).click();
        Thread.sleep(4000);

        //Verifying Received Bols
        boolean bol = driver.findElement(By.id("com.sof.retail:id/tvBolNumber")).isDisplayed();
        System.out.println("Status is " + bol + " for BOL Number ");
        boolean recvTime = driver.findElement(By.id("com.sof.retail:id/tvExpectedDelivery")).isDisplayed();
        System.out.println("Status is " + recvTime + " for Received Time ");
        boolean itemCount = driver.findElement(By.id("com.sof.retail:id/tvNumberOfItems")).isDisplayed();
        System.out.println("Status is " + itemCount + " for Item Count ");
        boolean pieceCount = driver.findElement(By.id("com.sof.retail:id/tvNumberOfPieces")).isDisplayed();
        System.out.println("Status is " + pieceCount + " for Piece Count ");
        try {
            boolean recvName = driver.findElement(By.id("com.sof.retail:id/tvReceivedBy")).isDisplayed();
            System.out.println("Status is " + recvName + " for Receiver Name ");
        } catch (Exception e) {
            System.out.println("Receiver Name is Not Visible");
        }
        try {
            boolean button = driver.findElement(By.id("com.sof.retail:id/btnReceive")).isDisplayed();
            System.out.println("Status is " + button + " for Adjust/View Button ");
        } catch (Exception e) {
            System.out.println("Adjust/View Button is not visible");
        }

        MobileElement drpdown = (MobileElement) driver.findElementById("android:id/text1");
        drpdown.click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")).click();
        Thread.sleep(5000);

        TouchAction newAction = new TouchAction(driver);
        newAction.press(PointOption.point(360, 411))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(329, 591)).release().perform();

        Thread.sleep(4000);

        //Closing app
        driver.closeApp();
        driver.quit();

        return driver;
    }

    public static void VerifyNoInvoiceScreen() throws InterruptedException {
        testCase = 22;

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
        Thread.sleep(7000);

        //Warehouse Receiving Header
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Warehouse Receiving";
        TestAsserts.assertCheck(actualText, expectedText);

        //Checking Whether All BOLs received
        try {
            boolean noBolChck = driver.findElement(By.id("com.sof.retail:id/emptyBolView")).isDisplayed();
            if (noBolChck == true) {
                actualText = driver.findElement(By.id("com.sof.retail:id/emptyBolView")).getText();
                expectedText = "All BOLs Received";
                TestAsserts.assertCheck(actualText, expectedText);
                //No Invoice Screen
                boolean staticTxt = driver.findElement(By.id("com.sof.retail:id/tvSelectBols")).isDisplayed();
                System.out.println("Visible status is " + staticTxt + " for Static Text ");
                boolean bolField = driver.findElement(By.id("com.sof.retail:id/editTextFindBol")).isDisplayed();
                System.out.println("Status is " + bolField + " BOL Manually Entering Field ");
                boolean dropdown = driver.findElement(By.id("android:id/text1")).isDisplayed();
                System.out.println("Dropdown status is " + dropdown + " for Days ");
                boolean receiveChck = driver.findElement(By.id("com.sof.retail:id/cbReceivedBols")).isDisplayed();
                System.out.println("Checkbox status is " + receiveChck + " for Received BOL ");
                if (receiveChck == true) {
                    System.out.println("Received BOL is displayed");
                }
            }

        } catch (Exception e) {
            System.out.println("BOLs is waiting to receive");
        }
        //Closing app
        driver.closeApp();
        driver.quit();
    }

    public static void BreakSeal() throws InterruptedException {
        testCase = 9;

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
        Thread.sleep(5000);

        //Clicking Receive
        MobileElement receive = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
        receive.click();
        Thread.sleep(3000);

        //Verifying Break Seal Header
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Break Seal";
        TestAsserts.assertCheck(actualText, expectedText);

        //Discard Button
        boolean discard = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
        System.out.println("Status is " + discard + " for Discard Button ");
        Thread.sleep(3000);

        //Truck
        boolean truck = driver.findElement(By.id("com.sof.retail:id/truckText")).isDisplayed();
        boolean truckBox = driver.findElement(By.id("com.sof.retail:id/truckValueText")).isDisplayed();
        if (truck == truckBox && truckBox == true) {
            System.out.println("Truck/Trailer & Input box is visible");
        }
        Thread.sleep(2000);

        //Incoming Security Seal
        boolean incSecurity = driver.findElement(By.id("com.sof.retail:id/truckText")).isDisplayed();
        boolean incSecurityBox = driver.findElement(By.id("com.sof.retail:id/truckValueText")).isDisplayed();
        if (incSecurity == true && incSecurityBox == true) {
            System.out.println("Incoming Security Seal & Input box is visible");
        }
        //Seal Checkbox
        boolean sealChck = driver.findElement(By.id("com.sof.retail:id/damagedProductCheckbox")).isDisplayed();
        System.out.println("Checkbox status is " + sealChck + " for Seal Matches BOL ");

        //Invalid seal text box
        actualText = driver.findElement(By.id("com.sof.retail:id/damageText")).getText();
        expectedText = "Enter details of invalid seal here:";
        TestAsserts.assertCheck(actualText, expectedText);

        //Storing Invalid Seal Text
        String invSeal = driver.findElement(By.id("com.sof.retail:id/damageText")).getText();

        //Checking Page Number
        actualText = driver.findElement(By.id("com.sof.retail:id/tvCurrentCount")).getText();
        expectedText = "1";
        TestAsserts.assertCheck(actualText, expectedText);
        //Storing Current Page Number
        String page = driver.findElement(By.id("com.sof.retail:id/tvCurrentCount")).getText();

        //Checking Total Page Number
        actualText = driver.findElement(By.id("com.sof.retail:id/tvTotalCount")).getText();
        expectedText = "7";
        //Storing Total Page Number
        String pageTotal = driver.findElement(By.id("com.sof.retail:id/tvTotalCount")).getText();
        //Print current & total page number
        System.out.println("Current page number : " + page + " Out of : " + pageTotal + " is visible");

        //Checking Next Button
        boolean next = driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).isDisplayed();
        System.out.println("Status is " + next + " for NEXT Button ");
        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

        //Checking for Truck,Seal Empty Alert
        boolean dialog = driver.findElement(By.id("com.sof.retail:id/dialog_message")).isDisplayed();
        if (dialog == true) {
            System.out.println("Truck & Security Seal cannot be empty alert is displayed");
        }
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        //Read values from Excel to Truck
        keys = "Truck/Trailer";
        MobileElement truckValue = (MobileElement) driver.findElementById("com.sof.retail:id/truckValueText");
        truckValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Read values from Excel to Incoming Security Seal
        keys = "Incoming Security Seal";
        MobileElement issValue = (MobileElement) driver.findElementById("com.sof.retail:id/incomingSealValueText");
        issValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

        //Clicking BOL unbroken Checkbox
        driver.findElement(By.id("com.sof.retail:id/damagedProductCheckbox")).click();

        //Checking Whether Invalid Seal Text box is visible
        try {
            driver.findElement(By.id("com.sof.retail:id/damageText")).click();
            System.out.println(invSeal + " is visible");
        } catch (Exception e) {
            System.out.println(invSeal + " is not visible");
        }

        //Clicking BOL unbroken Checkbox
        driver.findElement(By.id("com.sof.retail:id/damagedProductCheckbox")).click();

        //Reading values from Excel to Invalid Seal Text Box
        keys = "Invalid Seal Text";
        try {
            MobileElement invalidSeal = (MobileElement) driver.findElementById("com.sof.retail:id/damageDetailsText");
            invalidSeal.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Thread.sleep(3000);
            System.out.println("User is able to enter values");
        } catch (Exception e) {
            System.out.println("User is not able to enter values");
        }

        //Clicking Discard Button
        driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
        //Checking for Discard Warning
        boolean discardClick = driver.findElement(By.id("com.sof.retail:id/dialogDescWarningTextView")).isDisplayed();
        if (discardClick == true) {
            System.out.println("Discard Warning is displayed");
        }
        driver.findElement(By.id("com.sof.retail:id/discardNoButton")).click();

        //Clicking Discard Button
        driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
        //Confirming Discard
        driver.findElement(By.id("com.sof.retail:id/discardYesButton")).click();
        Thread.sleep(4000);

        //Closing app
        driver.closeApp();
        driver.quit();
    }

    public static void NoDamaged() throws InterruptedException {
        testCase = 26;
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
        Thread.sleep(7000);

        try {
            //Clicking Receive
            MobileElement receive = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
            receive.click();
            Thread.sleep(3000);

            //Break Seal
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Break Seal";
            TestAsserts.assertCheck(actualText, expectedText);

            //Read values from Excel to Truck
            keys = "Truck/Trailer";
            MobileElement truckValue = (MobileElement) driver.findElementById("com.sof.retail:id/truckValueText");
            truckValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            //Read values from Excel to Incoming Security Seal
            keys = "Incoming Security Seal";
            MobileElement issValue = (MobileElement) driver.findElementById("com.sof.retail:id/incomingSealValueText");
            issValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

            driver.findElement(By.id("com.sof.retail:id/damagedProductCheckbox")).click();
            driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
            Thread.sleep(3000);

            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Record Temperatures";
            TestAsserts.assertCheck(actualText, expectedText);

            //Record Temperatures
//        MobileElement comm1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
//        comm1.click();
//        comm1.sendKeys("2");
//        MobileElement comm2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText");
//        comm2.click();
//        comm2.sendKeys("5");
//        MobileElement comm3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.EditText");
//        comm3.click();
//        comm3.sendKeys("6");
//        MobileElement comm4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.EditText");
//        comm4.click();
//        comm4.sendKeys("10");
//        MobileElement comm5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.EditText");
//        comm5.click();
//        comm5.sendKeys("8");
//        MobileElement comm6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.EditText");
//        comm6.click();
//        comm6.sendKeys("2");
//        MobileElement comm7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.EditText");
//        comm7.click();
//        comm7.sendKeys("3");
//        MobileElement comm8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.EditText");
//        comm8.click();
//        comm8.sendKeys("1");
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            Thread.sleep(3000);

            //Item Review
            String desc = driver.findElement(By.id("com.sof.retail:id/reviewItemDescription")).getText();
            boolean descStatus = driver.findElement(By.id("com.sof.retail:id/reviewItemDescription")).isDisplayed();
            boolean caseStatus = driver.findElement(By.id("com.sof.retail:id/itemLookup")).isDisplayed();
            if (descStatus == true && caseStatus == true) {
                System.out.println("UPC = " + desc + " & Item Unit is visible");
            }
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(3000);

            //Pallets
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Pallets Unloaded";
            TestAsserts.assertCheck(actualText, expectedText);
            MobileElement palUnloaded = (MobileElement) driver.findElementById("com.sof.retail:id/palletCountText");
            palUnloaded.sendKeys("25");
            Thread.sleep(3000);
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            Thread.sleep(3000);

            //Reseal
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Reseal";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);

            //Reading values from Excel for Outgoing Security Seal
            keys = "Outgoing Security Seal";
            MobileElement outSeal = (MobileElement) driver.findElementById("com.sof.retail:id/editTextSecuritySeal");
            outSeal.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

            //Reading values from Excel for Driver
            keys = "Driver";
            MobileElement driverName = (MobileElement) driver.findElementById("com.sof.retail:id/editTextFullName");
            driverName.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            Thread.sleep(3000);

            //Comments
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Comments";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(2000);
            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            Thread.sleep(3000);

            //Summary
            String incSealNumber = driver.findElement(By.id("com.sof.retail:id/incomingValueText")).getText();
            System.out.println(incSealNumber);
            String outgoingSealNumber = driver.findElement(By.id("com.sof.retail:id/outgoingValueText")).getText();
            System.out.println(outgoingSealNumber);
            if (incSealNumber.equals("Mer2010") && outgoingSealNumber.equals("CONFIRMED")) {

                System.out.println("Details Matched");

                boolean summary = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).isDisplayed();
                System.out.println("Status is " + summary + " for Summary ");
                boolean bol = driver.findElement(By.id("com.sof.retail:id/bolText")).isDisplayed();
                String bolNumber = driver.findElement(By.id("com.sof.retail:id/bolValueText")).getText();
                System.out.println("Status is " + bol + " for Bill Of Landing - " + bolNumber);
                boolean incSeal = driver.findElement(By.id("com.sof.retail:id/incomingText")).isDisplayed();
                System.out.println("Status is " + incSeal + " for Incoming Seal - " + incSealNumber);
                boolean outgoingSeal = driver.findElement(By.id("com.sof.retail:id/outgoingText")).isDisplayed();
                System.out.println("Status is " + outgoingSeal + " for Outgoing Seal - " + outgoingSealNumber);
                boolean recvTime = driver.findElement(By.id("com.sof.retail:id/receivingText")).isDisplayed();
                String receivingTime = driver.findElement(By.id("com.sof.retail:id/receivingValueText")).getText();
                System.out.println("Status is " + recvTime + " for Receiving Time - " + receivingTime);
                boolean recvBy = driver.findElement(By.id("com.sof.retail:id/receivedByText")).isDisplayed();
                String receivedBy = driver.findElement(By.id("com.sof.retail:id/receivedByValueText")).getText();
                System.out.println("Status is " + recvBy + " for Received By - " + receivedBy);

            } else {
                System.out.println("Mismatch In Details");
            }

            driver.findElement(By.id("com.sof.retail:id/button3")).click();
            driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
            Thread.sleep(13000);

            //Transaction
            actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
            expectedText = "Transaction";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(4000);
            boolean staticTxt = driver.findElement(By.id("com.sof.retail:id/textViewTransTitle")).isDisplayed();
            System.out.println("Visible status is " + staticTxt + " for Static Text ");
            boolean descp = driver.findElement(By.id("com.sof.retail:id/sourceDeptTextView")).isDisplayed();
            System.out.println("Status is " + descp + " for Description");
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
            Thread.sleep(5000);

            //Writing Transaction Number to Excel
            transNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
            keys = "Transaction Number";
            ExcelHandle.ExcelWriteFunction(testCase, keys, transNum);
            Thread.sleep(2000);

            //Clicking Ok
            driver.findElement(By.id("com.sof.retail:id/button")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("All BOLs Received");
        }
        //Closing app
        driver.closeApp();
        driver.quit();
    }

    public static void reSeal() throws InterruptedException {
        testCase = 27;
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
        Thread.sleep(7000);

        MobileElement receive = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
        receive.click();
        Thread.sleep(3000);

        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Break Seal";
        TestAsserts.assertCheck(actualText, expectedText);

        //Read values from Excel to Truck
        keys = "Truck/Trailer";
        MobileElement truckValue = (MobileElement) driver.findElementById("com.sof.retail:id/truckValueText");
        truckValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        //Read values from Excel to Incoming Security Seal
        keys = "Incoming Security Seal";
        MobileElement issValue = (MobileElement) driver.findElementById("com.sof.retail:id/incomingSealValueText");
        issValue.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

        //Reading values from Excel to Invalid Seal Text Box
        keys = "Invalid Seal Text";
        try {
            MobileElement invalidSeal = (MobileElement) driver.findElementById("com.sof.retail:id/damageDetailsText");
            invalidSeal.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
            Thread.sleep(3000);
            System.out.println("User is able to enter values");
        } catch (Exception e) {
            System.out.println("User is not able to enter values");
        }

        driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();
        Thread.sleep(3000);

        String temp = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(temp, "Record Temperatures");
        System.out.println("Temperature screen is visible");

        //Record Temperatures
//        MobileElement comm1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
//        comm1.click();
//        comm1.sendKeys("2");
//        MobileElement comm2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText");
//        comm2.click();
//        comm2.sendKeys("5");
//        MobileElement comm3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.EditText");
//        comm3.click();
//        comm3.sendKeys("6");
//        MobileElement comm4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.EditText");
//        comm4.click();
//        comm4.sendKeys("10");
//        MobileElement comm5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.EditText");
//        comm5.click();
//        comm5.sendKeys("8");
//        MobileElement comm6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.EditText");
//        comm6.click();
//        comm6.sendKeys("2");
//        MobileElement comm7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.EditText");
//        comm7.click();
//        comm7.sendKeys("3");
//        MobileElement comm8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.EditText");
//        comm8.click();
//        comm8.sendKeys("1");
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Item Review
        String desc = driver.findElement(By.id("com.sof.retail:id/reviewItemDescription")).getText();
        boolean descStatus = driver.findElement(By.id("com.sof.retail:id/reviewItemDescription")).isDisplayed();
        boolean caseStatus = driver.findElement(By.id("com.sof.retail:id/itemLookup")).isDisplayed();
        if (descStatus == true && caseStatus == true) {
            System.out.println("UPC = " + desc + " & Item Unit is visible");
        }
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();
        Thread.sleep(3000);

        //Pallets
        String pallet = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(pallet, "Pallets Unloaded");
        System.out.println(pallet + " is visible");
        MobileElement palUnloaded = (MobileElement) driver.findElementById("com.sof.retail:id/palletCountText");
        palUnloaded.sendKeys("25");
        Thread.sleep(3000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Reseal
        String reseal = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(reseal, "Reseal");
        System.out.println(reseal + " is visible");
        boolean discard = driver.findElement(By.id("com.sof.retail:id/discardIcon")).isDisplayed();
        System.out.println("Status is " + discard + " for Discard Button");

        boolean outSealLabel = driver.findElement(By.id("com.sof.retail:id/textViewOutGoingSecurityLabel")).isDisplayed();
        boolean outSealChck = driver.findElement(By.id("com.sof.retail:id/editTextSecuritySeal")).isDisplayed();
        if (outSealChck == true && outSealLabel == true) {
            System.out.println("Outgoing Security Seal # & text box is visible");
        }

        boolean sep1 = driver.findElement(By.id("com.sof.retail:id/viewTop")).isDisplayed();
        boolean sep2 = driver.findElement(By.id("com.sof.retail:id/viewBottom")).isDisplayed();
        if (sep1 == true && sep2 == true) {
            System.out.println("Top & Bottom line separators are visible");
        }

        boolean emptyTruck = driver.findElement(By.id("com.sof.retail:id/checkBoxSealNotRequired")).isDisplayed();
        System.out.println("Status is " + emptyTruck + " for 'Truck is Empty'");
        boolean driverSignoff = driver.findElement(By.id("com.sof.retail:id/textViewDriverSignOff")).isDisplayed();
        System.out.println("Status is " + driverSignoff + " for 'Driver Sign-off'");
        boolean driverRefused = driver.findElement(By.id("com.sof.retail:id/checkBoxDriverRefused")).isDisplayed();
        System.out.println("Status is " + driverRefused + " for 'Driver Refused Name'");

        boolean fullNameLabel = driver.findElement(By.id("com.sof.retail:id/textViewOutGoingSecurityLabel")).isDisplayed();
        boolean fullName = driver.findElement(By.id("com.sof.retail:id/editTextSecuritySeal")).isDisplayed();
        if (fullName == true && fullNameLabel == true) {
            System.out.println("Full Name label & text box is visible");
        }

        String staticTxt = driver.findElement(By.id("com.sof.retail:id/textViewConfirmation")).getText();
        Assert.assertEquals(staticTxt, "As the driver of this delivery, I confirm that the delivery is complete and that the above seal # is correct.");
        System.out.println("Static text is visible");
        driver.findElement(By.id("com.sof.retail:id/button3")).click();

        String errorMsg = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
        System.out.println("Error Message " + errorMsg + " is displayed");
        driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

        //Reading values from Excel for Outgoing Security Seal
        keys = "Outgoing Security Seal";
        MobileElement outSeal = (MobileElement) driver.findElementById("com.sof.retail:id/editTextSecuritySeal");
        outSeal.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));

        //Reading values from Excel for Driver
        keys = "Driver";
        MobileElement driverName = (MobileElement) driver.findElementById("com.sof.retail:id/editTextFullName");
        driverName.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Comments
        String comment = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(comment, "Comments");
        System.out.println(comment + " screen is visible");
        Thread.sleep(1000);
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(3000);

        //Back to reseal
        String resealBack = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(resealBack, "Reseal");
        System.out.println("Back to Reseal Page");
        Thread.sleep(1000);
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(3000);

        //Back to Pallets
        String palletBack = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(palletBack, "Pallets Unloaded");
        System.out.println("Back to Pallets Page");
        Thread.sleep(1000);
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Back to reseal
        String resealFrwd = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(resealFrwd, "Reseal");
        System.out.println("Forwaded to Reseal Page");
        driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
        String DiscardErrorMsg = driver.findElement(By.id("com.sof.retail:id/dialogDescWarningTextView")).getText();
        Assert.assertEquals(DiscardErrorMsg, "You have made changes to your Receiving. Going back will discard this work. Are you sure?");
        System.out.println("Discard Warning is displayed");
        driver.findElement(By.id("com.sof.retail:id/discardNoButton")).click();

        driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
        driver.findElement(By.id("com.sof.retail:id/discardYesButton")).click();

        String wareHouse = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(wareHouse, "Warehouse Receiving");
        System.out.println("Warehouse Page is visible");

        //Closing app
        driver.closeApp();
        driver.quit();
    }

    public static void ManualBol() throws InterruptedException {
        testCase = 100;
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
        Thread.sleep(7000);

        MobileElement bolSearch = (MobileElement) driver.findElement(By.id("com.sof.retail:id/editTextFindBol"));

        //Warehouse Receiving Screen
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Warehouse Receiving";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        try {
            //Storing one BOL number from the listing
            String bolNumber = driver.findElement(By.id("com.sof.retail:id/tvBolNumber")).getText();
            //Clicking Search for BOL
            bolSearch.sendKeys(bolNumber);
            boolean searchResChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")).isDisplayed();
            if(searchResChck==true) {
                String searchResBolNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")).getText();
                if(searchResBolNum.equals(bolNumber)) {
                    System.out.println("List updated with entered BOL number");
                }
            }
        } catch (Exception e) {
            System.out.println("No BOL is loaded");
        }

        //Entering Invalid BOL
        try {
            bolSearch.clear();
            bolSearch.sendKeys("0000000");
            boolean searchResChck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")).isDisplayed();
            if(searchResChck==true) {
                System.out.println("Invalid BOL number returned a match");
            }
        }
        catch (Exception e) {
            System.out.println("No BOL is matched");
        }

        //Closing app
        driver.closeApp();
        driver.quit();
    }
}
