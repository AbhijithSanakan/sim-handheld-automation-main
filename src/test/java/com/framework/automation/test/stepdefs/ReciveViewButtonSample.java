package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class ReciveViewButtonSample extends ReturnReceivebaseclass {


    static AndroidDriver<AndroidElement> driver;

    public void ReturnReceivebaseclass() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();

    }

    public static void Receive() throws InterruptedException {








    }
    public static void DeliveryInfo() {
        //should be non-editable-Delivery Info

        boolean EnclosureRadio = driver.findElementById("com.sof.retail:id/deliveryInfoEnclosureRadioButton").isEnabled();
        System.out.println("The Enclosure status is" + EnclosureRadio);
        boolean CourierRadio = driver.findElementById("com.sof.retail:id/deliveryInfoCourierRadioButton").isEnabled();
        System.out.println("The CourierRadio status is" + CourierRadio);
        boolean SupplyRadio = driver.findElementById("com.sof.retail:id/deliveryInfoSupplyRadioButton").isEnabled();
        System.out.println("The SupplyRadio status is" + SupplyRadio);
        boolean BasetolCheckbox = driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicedQuantitiesCheckBox").isEnabled();
        System.out.println("The BasetolCheckbox status is" + BasetolCheckbox);
        //Select Next btn  -Delivery Info
        MobileElement Nextbtn = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Nextbtn.click();
    }

    public static void Temperatures() {
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
        Nextbtn1.click();
    }

    public static void ScanItems() throws InterruptedException {
        boolean x = driver.findElement(By.id("com.sof.retail:id/upcScanText")).isEnabled();
        System.out.println("Status is "+ x);
        Thread.sleep(4000);
        //Select Next btn  -Scan Items
        MobileElement Nextbtn2 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn2.click();

    }

    public static void Delivery() {
        //shout not be edit and DSD Delivery
        MobileElement Gtotal = driver.findElementById("com.sof.retail:id/dsdDeliveryGrandTotalEditText");
        Gtotal.clear();
        Gtotal.sendKeys("5");

        MobileElement Gst = driver.findElementById("com.sof.retail:id/dsdDeliveryGSTEditText");
        Gst.clear();
        Gst.sendKeys("5");

        boolean Chargetype = driver.findElementById("com.sof.retail:id/dsdDeliveryChargeTypeValueSpinner").isEnabled();
        System.out.println("The Chargetype status is" + Chargetype);

        MobileElement Chargeamt = driver.findElementById("com.sof.retail:id/dsdDeliveryChargeAmountEditText");
        Chargeamt.clear();
        Chargeamt.sendKeys("5");

        boolean Dep = driver.findElementById("com.sof.retail:id/dsdDeliveryDepartmentSpinner").isEnabled();
        System.out.println("The Chargetype status is" + Dep);

        boolean drivname = driver.findElementById("com.sof.retail:id/dsdDeliveryDriverNotPresentCheckBox").isEnabled();
        System.out.println("The Chargetype status is" + drivname);

        //Select Next btn  -DSD Delivery
        MobileElement Nextbtn3 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn3.click();
    }

    //Additional Comments not be edit on Comments
//        MobileElement comt = driver.findElementById("com.sof.retail:id/etComment");
//        comt.clear();
//        comt.sendKeys("5");
    public static void Comment() {
        boolean cmtbox = driver.findElementById("com.sof.retail:id/dsdDeliveryDriverNotPresentCheckBox").isEnabled();
        System.out.println("The Comment status is" + cmtbox);
        //Select Next btn  -on Comments
        MobileElement Nextbtn4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn4.click();
    }
    public static void Summary(){
    //Verify Summary screen visible
    boolean Summtxt = driver.findElementById("com.sof.retail:id/toolBarHeader").isDisplayed();
            System.out.println("The Screen status is"+Summtxt);

    //Select(click) back button
    MobileElement Backbtn = (MobileElement) driver.findElementById("com.sof.retail:id/button");
            Backbtn.click();

    boolean comt = driver.findElementById("com.sof.retail:id/toolBarHeader").isDisplayed();
            System.out.println("The Screen status is"+comt);
        MobileElement Nextbtn6 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn6.click();

    MobileElement okbtn = (MobileElement) driver.findElementById("com.sof.retail:id/btOk");
            okbtn.click();









}
}
