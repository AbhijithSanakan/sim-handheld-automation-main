package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ReturnReceivebaseclass {


    static AndroidDriver<AndroidElement> driver;
    public void ReturnReceivebaseclass() throws IOException, InterruptedException {
        this.driver=Login.LoginDriver();
    }

    public static AndroidDriver<AndroidElement> ReturnReceiveClick() {
        System.out.println("Check return");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout")).click();
        return driver;
    }

    public static AndroidDriver<AndroidElement> ScreenVerify() {
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

        return driver;
    }

    public static void ReceiveClick() throws InterruptedException {
        System.out.println("Return & Receive Visible");

        MobileElement el1 = (MobileElement) driver.findElementById("com.sof.retail:id/textViewTitle");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el2.click();
        Thread.sleep(10000);
    }

    public static void Verification() {

        try {

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

            try {
                driver.findElement(By.id("com.sof.retail:id/discardIcon"));
                System.out.println("Discard Button Present");
            } catch (NoSuchElementException e) {
                System.out.println("Discard Button not Present");
            }
        }

        catch (Exception e) {
            System.out.println("Invoice is present");
            WebElement checkbox = driver.findElement(By.id("com.sof.retail:id/receivedInvoiceCheckBox"));
            checkbox.click();

            try {

                driver.findElement(By.id("com.sof.retail:id/tvScanItemName"));
                System.out.println("Vendor name is visible" );

                String inv = driver.findElement(By.id("com.sof.retail:id/tvInvoiceOrPoValue")).getText();
                System.out.println("Invoice & PO number is visible" );

                driver.findElement(By.id("com.sof.retail:id/tvInvoiceTime"));
                System.out.println("Invoiced time is visible" );

                driver.findElement(By.id("com.sof.retail:id/tvOrderedValue"));
                System.out.println("Invoiced item count is visible" );

                driver.findElement(By.id("com.sof.retail:id/btnReceive"));
                System.out.println("Received, View Button is visible" );

                MobileElement el2 = (MobileElement) driver.findElementById("android:id/text1");
                el2.click();
                MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
                el3.click();

//                Select dropdown = new Select(el1);
//                dropdown.selectByVisibleText("1");
//                List<WebElement> lists = dropdown.getOptions();
//                int size = lists.size();
//                System.out.println(size+" days");

                TouchAction action=new TouchAction((PerformsTouchActions) driver);
                action.press(PointOption.point(237, 418)).moveTo(PointOption.point(237,526)).release().perform();

            }
            catch (Exception e1) {

                System.out.println("Element not found");
            }

//            MobileElement el1 = (MobileElement) driver.findElementById("android:id/text1");
//            Select dropdown = new Select(el1);
//            List<WebElement> lists = dropdown.getOptions();
//            int size = lists.size();
//            System.out.println(size+" days");

        }
    }

    public static void ReturnClick () throws InterruptedException {
        System.out.println("Return & Receive Visible");

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.ImageView");
        el2.click();
        Thread.sleep(10000);

    }

    public static void ReturnVerification() {
        try {

            String invoice = driver.findElement(By.id("com.sof.retail:id/dsdReturnNoData")).getText();
            Assert.assertEquals(invoice, "No Invoices Available");
            System.out.println(invoice + " is visible");

            String text = driver.findElement(By.id("com.sof.retail:id/selectInvoiceTitleTextView")).getText();
            Assert.assertEquals(text, "Select a credit below.");
            System.out.println(text + " is visible");

            String credit = driver.findElement(By.id("com.sof.retail:id/selectInvoiceorPoNotAvailableButton")).getText();
            Assert.assertEquals(credit, "CREDIT NOT AVAILABLE");
            System.out.println(credit + " is visible");

            WebElement dropdown = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView"));
            Boolean displayed = dropdown.isDisplayed();
            if (displayed == true) {
                System.out.println("Dropdown is visible");
            }

            WebElement checkbox = driver.findElement(By.id("com.sof.retail:id/receivedInvoiceCheckBox"));
            boolean isDisplayed = checkbox.isDisplayed();
            if (isDisplayed == true) {
                System.out.println(("Processed Returns checkbox is visible"));
            }

            try {
                driver.findElement(By.id("com.sof.retail:id/discardIcon")).getText();
                System.out.println("Discard Button Present");
            } catch (NoSuchElementException e) {
                System.out.println("Discard Button not Present");
            }

            try {
                driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
                System.out.println("Pickup Supplier screen is visible");
                Thread.sleep(8000);
            }
            catch (Exception e) {
                System.out.println("Element not found");

            }

            driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
            Thread.sleep(7000);
            driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
            Thread.sleep(7000);

        }
        catch (Exception e) {
            System.out.println("Invoice is present");

        }
    }

    public static void Pickup() {
        try{

//            MobileElement el1 = (MobileElement) driver.findElementById("com.sof.retail:id/textViewTitle");
//            el1.click();
//            MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.ImageView");
//            el2.click();
//            Thread.sleep(10000);


            driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton").click();
            Thread.sleep(7000);

            String supplier = driver.findElement(By.id("com.sof.retail:id/chooseSupplierLabelTextView")).getText();
            Assert.assertEquals(supplier, "Choose Supplier");
            System.out.println(supplier + " is visible");

            driver.findElement(By.id("com.sof.retail:id/supplierSpinner"));
            System.out.println("Choose supplier dropdown Present");

            driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton"));
            System.out.println("Load all suppliers Present");

            String cc = driver.findElement(By.id("com.sof.retail:id/invoiceNumberLabelTextView")).getText();
            Assert.assertEquals(cc, "Enter Credit / Return Number");
            System.out.println(cc + " is visible");

            driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText"));
            System.out.println("Enter Credit/Return textbox is Present");

            try {
//                MobileElement el1 = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
//                el1.click();
                Select drp = new Select(driver.findElement(By.id("com.sof.retail:id/dropDownImg")));
                List<WebElement> li = drp.getOptions();
                System.out.println(li.size()+" Recently used suppliers loaded");

            }

            catch (Exception e) {
                System.out.println("No Supplier found");

            }

//            Add new supplier
            driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).click();
            driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).click();

            try {

                driver.findElement(By.id("com.sof.retail:id/dialog_message"));
                System.out.println("NOTE is visible");

                driver.findElement(By.id("com.sof.retail:id/newSupplierEditText"));
                System.out.println("New supplier textbox is visible");

                try {

                    boolean btnCancel = driver.findElement(By.id("com.sof.retail:id/negativeButton")).isDisplayed();
                    boolean btnOk = driver.findElement(By.id("com.sof.retail:id/positiveButton")).isDisplayed();
                    System.out.println("Button status is " + btnCancel + " for CANCEL ");
                    System.out.println("Button status is " + btnOk + " for OK ");

                }
                catch (Exception e) {
                    System.out.println("No Button is visible");
                }

                driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).sendKeys("Pepsi");
                driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();

                driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).click();
                driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).sendKeys("Pepsi");
                driver.findElement(By.id("com.sof.retail:id/positiveButton")).click();

//                USE ABOVE
                try {

                    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView\n")).click();
                    driver.findElement(By.id("com.sof.retail:id/negativeButton")).click();
                    driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).sendKeys("PEP100");
                    driver.findElement(By.id("com.sof.retail:id/buttonConfirm")).click();

                    try {

                        boolean btnType = driver.findElement(By.id("com.sof.retail:id/deliveryInfoChooseDeliveryTextView")).isDisplayed();
                        boolean btnDelivery = driver.findElement(By.id("com.sof.retail:id/deliveryInfoChooseDestinationTextView")).isDisplayed();
                        boolean btnReturn = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryInvoicePieceCountTextView")).isDisplayed();
                        boolean btnTotal = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryInvoicedQuantitiesCheckBox")).isDisplayed();
                        boolean btnBack = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
                        boolean btnNext = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();

                        System.out.println("Button status is " + btnType + " for Choose Delivery / Truck Type ");
                        System.out.println("Button status is " + btnDelivery + " for Choose Destination ");
                        System.out.println("Button status is " + btnReturn + " for Return piece count ");
                        System.out.println("Button status is " + btnTotal + " for Base total on inv. qty. ");
                        System.out.println("Button status is " + btnBack + " for Back Button ");
                        System.out.println("Button status is " + btnNext + " for Next Button ");

                        MobileElement el3 = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoNormalRadioButton");
                        el3.click();
                        MobileElement el4 = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoInventoryRadioButton");
                        el4.click();
                        MobileElement el5 = (MobileElement) driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicePieceCountEditText");
                        el5.sendKeys("10");
                        MobileElement el6 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
                        el6.click();

//                        MobileElement el1 = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
//                        el1.sendKeys("510"+ Keys.RETURN);
                        MobileElement el1 = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
                        el1.click();
                        MobileElement el2 = (MobileElement) driver.findElementById("com.sof.retail:id/dialogEditText");
                        el2.sendKeys("510");
                        MobileElement el = (MobileElement) driver.findElementById("com.sof.retail:id/dialogOkButton");
                        el.click();
                        MobileElement ele = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
                        ele.click();
                        MobileElement ele2 = (MobileElement) driver.findElementById("com.sof.retail:id/dialogEditText");
                        ele2.sendKeys("555");
                        MobileElement ele3 = (MobileElement) driver.findElementById("com.sof.retail:id/dialogOkButton");
                        ele3.click();

                        try {
                            int startY = 305;
                            int endY =  308;
                            TouchAction action =new TouchAction(driver);
                            int startX=307;
                            int endX=173;
                            action.press(PointOption.point(297, 299))
                                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                                    .moveTo(PointOption.point(173, 310)).release().perform();
                        }
                        catch (Exception e) {

                        }

                        MobileElement next = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
                        next.click();

                        boolean gTotal = driver.findElement(By.id("com.sof.retail:id/grandTotalLabelTextView")).isDisplayed();
                        System.out.println("Button status is " + gTotal + " for Grand Total ");
                        boolean gst = driver.findElement(By.id("com.sof.retail:id/gstLabelTextView")).isDisplayed();
                        System.out.println("Button status is " + gst + " for GST ");

                        boolean dropdown = driver.findElement(By.id("com.sof.retail:id/dropDownImg")).isDisplayed();
                        System.out.println("Dropdown status is " + gst + " for Department ");


                        MobileElement grand = (MobileElement) driver.findElementById("com.sof.retail:id/grandTotalEditText");
                        grand.sendKeys("10.00");
                        MobileElement gs = (MobileElement) driver.findElementById("com.sof.retail:id/gstEditText");
                        gs.sendKeys("03.00");
//                        driver.findElementById("com.sof.retail:id/dropDownImg").click();

                        driver.findElement(By.id("com.sof.retail:id/departmentSpinner"));
                        driver.findElement(By.id("com.sof.retail:id/button3")).click();


                    }
                    catch (Exception e) {
                        System.out.println("Credit Info not available");
                    }

                }

                catch (Exception e) {

                }

            }

            catch (Exception e) {

            }


        }
        catch (Exception error) {
            System.out.println("No element found");

        }
    }
}
