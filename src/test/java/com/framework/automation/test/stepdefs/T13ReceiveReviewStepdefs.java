package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T13ReceiveReviewStepdefs {
    static AndroidDriver<AndroidElement> driver;

    @Given("Admin Reach Dashboard and Select Receive Invoice")
    public void admin_Reach_Dashboard_and_Select_Receive_Invoice() throws IOException, InterruptedException {
    try{    this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click();Thread.sleep(5000);
        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);

        MobileElement Days = (MobileElement) driver.findElementById("android:id/text1");
        Days.click();
        Thread.sleep(5000);

        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(329, 591))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(360, 411)).release().perform();

        MobileElement Day30  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[19]");
        Day30.click();
        Thread.sleep(5000);
        MobileElement rec = (MobileElement) driver.findElementById("com.sof.retail:id/btnReceive");
        rec.click();
        MobileElement invno = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        invno.click();
        invno.sendKeys("1234");
        MobileElement invnuok = (MobileElement) driver.findElementById("com.sof.retail:id/scanDialogOkButton");
        invnuok.click();
        Thread.sleep(5000);
        MobileElement Enclsr = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoEnclosureRadioButton");
        Enclsr.click();
        Thread.sleep(5000);
        MobileElement nxt1 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        nxt1.click();
        Thread.sleep(5000);
        System.out.println("Test Done in Select Invoice page");}
    catch (Exception e){
        System.out.println("No Invoice Available");}

    }

    @Then("User Verify the Temperature Page")
    public void User_Verify_the_Temperature_Page() throws InterruptedException {
        try{

//        boolean commodity = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]").isDisplayed();
//        System.out.println("The commodity status is" + commodity);
//
//        boolean Min = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[2]").isDisplayed();
//        System.out.println("The Min status is" + Min);
//
//        boolean Max = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[3]").isDisplayed();
//        System.out.println("The Max status is" + Max);
//
//        boolean c = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[4]").isDisplayed();
//        System.out.println("The C status is" + c);
//
//        boolean butStatus = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus);
//        //to verify enter in the "'C" text box which we want to mention the Deli/dairy 'C-Record Temperatures
//        MobileElement Cbox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox.clear();
//        Cbox.sendKeys("5");
//        //to verify if a +,- button is enabled with is Eggs()
//        boolean butStatus1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus1);
//
//        //to verify enter in the "'C" text box which we want to mention the Eggs 'C-Record Temperatures
//        MobileElement Cbox1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox1.clear();
//        Cbox1.sendKeys("5");

        MobileElement Nextbtn1 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn1.click();
        System.out.println("Test Done in Temperature page");
        Thread.sleep(10000);}
    catch (Exception e){
        System.out.println("No Invoice Available");}
    }

    @When("User Verify Scan Items in Scan Page")
    public void User_Verify_Scan_Items_in_Scan_Page() throws InterruptedException {
        try{
        String Count = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
        Assert.assertEquals(Count, "No need to count pallets");
        System.out.println(Count + " is visible");

        MobileElement okcount = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okcount.click();
        Thread.sleep(5000);
        System.out.println("Test Done in Popup page");

        boolean miditem= driver.findElementById("com.sof.retail:id/recycler_view_dsd").isDisplayed();
        System.out.println(" items in middle is" + miditem);

        boolean recv= driver.findElementById("com.sof.retail:id/recvText").isDisplayed();
        System.out.println(" Recv name available is" + recv);

        boolean selecteditm = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout").isDisplayed();
        System.out.println("The seletedit status is" + selecteditm);

        MobileElement Hylk = (MobileElement) driver.findElementById("com.sof.retail:id/linkWHRDesc");
        Hylk.click();

        String Iteminfo = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        Assert.assertEquals(Iteminfo, "ITEM INFO");
        System.out.println(Iteminfo + " is visible");

        MobileElement okk = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        okk.click();

        MobileElement nxt = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        nxt.click();
        System.out.println("Test Done in Scan Items page");




        System.out.println("Test Done in Scan Items page");
    }
    catch (Exception e){
        System.out.println("No Invoice Available");}


     }

     @When("User Enter Grand Total With GST in DSD Delivery Page")
     public void User_Enter_Grand_Total_With_GST_in_DSD_Delivery_Page() throws InterruptedException {
        try{
        Thread.sleep(5000);

        MobileElement grandtol = driver.findElementById("com.sof.retail:id/dsdDeliveryGrandTotalEditText");
        grandtol.click();
        grandtol.sendKeys("2202");

        MobileElement Gst = driver.findElementById("com.sof.retail:id/dsdDeliveryGSTEditText");
        Gst.click();
        Gst.sendKeys("220");

        MobileElement Chrgtyp = driver.findElementById("com.sof.retail:id/chargeTypeDropDownImg");
        Chrgtyp.click();
        Thread.sleep(5000);

        MobileElement ch = driver.findElementById("com.sof.retail:id/dsdDeliveryDepartmentSpinner");
        ch.click();


        MobileElement chrgamt = driver.findElementById("com.sof.retail:id/dsdDeliveryChargeAmountEditText");
        chrgamt.click();
        chrgamt.sendKeys("2222");

        MobileElement dep = driver.findElementById("com.sof.retail:id/DepartmentDropDownImg");
        dep.click();

        MobileElement Dp = driver.findElementById("com.sof.retail:id/dsdDeliveryChargeAmountEditText");
        Dp.click();

        MobileElement Nextbtn3 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn3.click();

        System.out.println("Test Done in DSD Delivery page");
     }
    catch (Exception e){
        System.out.println("No Invoice Available");}

     }

     @Then("User Verify Summary page")
     public void User_Verify_Summary_page() throws InterruptedException {
try{
//        MobileElement comm = (MobileElement) driver.findElementById("com.sof.retail:id/etComment");
//        comm.click();
//        comm.sendKeys("dsdsfj");

        driver.findElement(By.id("com.sof.retail:id/etComment")).sendKeys("dsdsfj");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement Nextbtn4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nextbtn4.click();

        System.out.println("Test Done in Comments page");

        String sum = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum, "Supplier");
        System.out.println(sum + "Supplier is visible");

        String sum1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum1, "Invoice / PO #");
        System.out.println(sum1 + "Invoice / PO # is visible");

        String sum2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum2, "Received Into");
        System.out.println(sum2 + "Received Into is visible");

        String sum3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum3, "Grand Total");
        System.out.println(sum3 + "Grand Total is visible");

        String sum4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum4, "GST");
        System.out.println(sum4 + "GST is visible");

        String sum5 = driver.findElement(By.id("com.sof.retail:id/descpTextView")).getText();
        Assert.assertEquals(sum5, "Description");
        System.out.println(sum5 + "Description is visible");

        String sum6 = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).getText();
        Assert.assertEquals(sum6, "Qty");
        System.out.println(sum6 + "Qty is visible");

        System.out.println("Test Done in Summery page");

        MobileElement Send = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Send.click();
}
catch (Exception e){
    System.out.println("No Invoice Available");}
         Thread.sleep(3000);
         driver.closeApp();
         driver.quit();
    }

}
