package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Timer;

public class T15ReceiveViewButtonStepdefs extends ReciveViewButtonSample {

    static AndroidDriver<AndroidElement> driver;

    public T15ReceiveViewButtonStepdefs() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();

    }


    @Given("User reach Dashboard for further operation")
    public void User_reach_Dashboard_for_further_operation() throws MalformedURLException, InterruptedException {


        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click();
        Thread.sleep(5000); try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);

        MobileElement RI2 = (MobileElement) driver.findElementById("com.sof.retail:id/receivedInvoiceCheckBox");
        RI2.click();
        Thread.sleep(5000);
        MobileElement Vw = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
        Vw.click();
        Thread.sleep(5000);


    }

    @Then("Select invoice and non editable delivery info")
    public void select_invoice_and_non_editable_delivery_info() throws InterruptedException {
        //Scroll down to select- Select invoice
        System.out.println("Delivery Info Start");
        boolean EnclosureRadio = driver.findElementById("com.sof.retail:id/deliveryInfoEnclosureRadioButton").isEnabled();
        System.out.println("The EnclosureRadio button status is" + EnclosureRadio);
        boolean CourierRadio = driver.findElementById("com.sof.retail:id/deliveryInfoCourierRadioButton").isEnabled();
        System.out.println("The CourierRadio button status is" + CourierRadio);
        boolean SupplyRadio = driver.findElementById("com.sof.retail:id/deliveryInfoSupplyRadioButton").isEnabled();
        System.out.println("The SupplyRadio button status is" + SupplyRadio);
        boolean BasetolCheckbox = driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicedQuantitiesCheckBox").isEnabled();
        System.out.println("The BasetolCheckbox button status is" + BasetolCheckbox);
        //Select Next btn  -Delivery Info
        MobileElement Nextbtn = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Nextbtn.click();
        Thread.sleep(10000);

    }

    @Then("Verify non editable record temperature")
    public void verify_non_editable_record_temperature() throws InterruptedException {

//        //should be non-editable-Record Temperatures
//        //to verify if a +,- button is enabled with is Deli/dairy ()
//        boolean butStatus = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus);
//        //to verify enter in the "'C" text box which we want to mention the Deli/dairy 'C-Record Temperatures
//        MobileElement Cbox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox.clear();
//        Cbox.sendKeys("5");
//        //to verify if a +,- button is enabled with is Eggs()
//        boolean butStatus1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus1);
//        //to verify enter in the "'C" text box which we want to mention the Eggs 'C-Record Temperatures
//        MobileElement Cbox1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox1.clear();
//        Cbox1.sendKeys("5");
//        //to verify if a +,- button is enabled with is Frozen()
//        boolean butStatus2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus2);
//        //to verify enter in the "'C" text box which we want to mention the Frozen 'C-Record Temperatures
//        MobileElement Cbox2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox2.clear();
//        Cbox2.sendKeys("5");
//        //to verify if a +,- button is enabled with is Grocery()
//        boolean butStatus3 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus3);
//        //to verify enter in the "'C" text box which we want to mention the Grocery 'C-Record Temperatures
//        MobileElement Cbox3 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox3.clear();
//        Cbox3.sendKeys("5");
//        //to verify if a +,- button is enabled with is IceCream()
//        boolean butStatus4 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus4);
//        //to verify enter in the "'C" text box which we want to mention the IceCream 'C-Record Temperatures
//        MobileElement Cbox4 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox4.clear();
//        Cbox4.sendKeys("5");
//        //to verify if a +,- button is enabled with is Meat/seafood()
//        boolean butStatus5 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus5);
//        //to verify enter in the "'C" text box which we want to mention the Meat/seafood 'C-Record Temperatures
//        MobileElement Cbox5 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox5.clear();
//        Cbox5.sendKeys("5");
//        //to verify if a +,- button is enabled with is Poultry()
//        boolean butStatus6 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus6);
//        //to verify enter in the "'C" text box which we want to mention the Poultry 'C-Record Temperatures
//        MobileElement Cbox6 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox6.clear();
//        Cbox6.sendKeys("5");
//        //to verify if a +,- button is enabled with is Produce()
//        boolean butStatus7 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus7);
//        //to verify enter in the "'C" text box which we want to mention the Produce 'C-Record Temperatures
//        MobileElement Cbox7 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox7.clear();
//        Cbox7.sendKeys("5");

        //Select Next btn  -'C-Record Temperatures
        MobileElement Nextbtn1 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn1.click();Thread.sleep(10000);



    }

    @Then("Verify non editable Scan Items")
    public void verify_non_editable_Scan_Items() throws InterruptedException {

        boolean x = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isEnabled();
        System.out.println("UPC Status is "+ x);

        boolean x1 = driver.findElement(By.id("com.sof.retail:id/tv_spinner_txt")).isEnabled();
        System.out.println("UOM Status is "+ x1);
        Thread.sleep(1000);

        boolean x2 = driver.findElement(By.id("com.sof.retail:id/recvValue")).isEnabled();
        System.out.println("rec Status is "+ x2);
        Thread.sleep(1000);

        boolean x3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.EditText")).isEnabled();
        System.out.println("Item Status is "+ x3);
        Thread.sleep(1000);
        //Select Next btn  -Scan Items
        MobileElement Nextbtn2 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn2.click();
        Thread.sleep(10000);
    }

    @Then("Verify non editable DSD Delivery")
    public void verify_non_editable_DSD_Delivery() throws InterruptedException {

        boolean gst = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryGrandTotalEditText")).isEnabled();
        System.out.println("GrandTotal Status is "+ gst);
        Thread.sleep(4000);
        boolean Gnt = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryGSTEditText")).isEnabled();
        System.out.println("GST Status is "+ Gnt);
        boolean CT = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryChargeAmountEditText")).isEnabled();
        System.out.println("Charge Amount Status is "+ CT);
        boolean Depart = driver.findElement(By.id("com.sof.retail:id/dsdDeliveryDepartmentSpinner")).isEnabled();
        System.out.println("Department Status is "+ Depart);


        MobileElement Nextbtn3 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn3.click();
        Thread.sleep(10000);


        boolean Comm = driver.findElement(By.id("com.sof.retail:id/etComment")).isEnabled();
        System.out.println("Department Status is "+ Comm);

        MobileElement Nextbtn4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn4.click();
        System.out.println("Test Done in Comment page");

        String sum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum, "Supplier");
        System.out.println(sum + " is visible");

        String sum1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum1, "Invoice / PO #");
        System.out.println(sum1 + " is visible");

        String sum2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum2, "Received Into");
        System.out.println(sum2 + " is visible");

        String sum3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum3, "Grand Total");
        System.out.println(sum3 + " is visible");

        String sum4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum4, "GST");
        System.out.println(sum4 + " is visible");

        String sum5 = driver.findElement(By.id("com.sof.retail:id/descpTextView")).getText();
        Assert.assertEquals(sum5, "Description");
        System.out.println(sum5 + " is visible");

        String sum6 = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).getText();
        Assert.assertEquals(sum6, "Qty");
        System.out.println(sum6 + " is visible");

        MobileElement Bac = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Bac.click();

        MobileElement Nextbtn5 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn5.click();Thread.sleep(9000);

        MobileElement okk = (MobileElement) driver.findElementById("com.sof.retail:id/btOk");
        okk.click();


        System.out.println("Test Done in Summery page");

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }
}
