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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T30ReceiveEquipmentFlowStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=30;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User reach Dashboard to ReceiveEquipment")
    public void User_reach_Dashboard_to_ReceiveEquipment() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.TextView");
        el1.click();
        Thread.sleep(10000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
    catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);


    }

    @Then("Select Receive invoice to Reach Comment Page")
    public void select_receive_invoice_to_reach_comment_page () throws InterruptedException {
        try{   MobileElement ReIn = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerPrinter");
        ReIn.click();
        Thread.sleep(5000);
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(350, 579))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(347, 223)).release().perform();
        Thread.sleep(10000);

        MobileElement Day = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[13]");
        Day.click();

        MobileElement DaRcvy = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.Button");
        DaRcvy.click();

        String REQUIRED = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(REQUIRED, "REQUIRED");
        System.out.println(REQUIRED + " is visible");
        Thread.sleep(5000);

        MobileElement ok1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button");
        ok1.click();

        String Iteamid = driver.findElement(By.id("com.sof.retail:id/textItemID")).getText();
        Assert.assertEquals(Iteamid, "Item ID");
        System.out.println(Iteamid + " is visible");
        Thread.sleep(5000);

        String Descri = driver.findElement(By.id("com.sof.retail:id/descriptionTextHolder")).getText();
        Assert.assertEquals(Descri, "Description");
        System.out.println(Descri + " is visible");
        Thread.sleep(5000);



        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")).sendKeys("COCK");
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys("1");
        Thread.sleep(4000);
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        boolean Populated= driver.findElementById("com.sof.retail:id/scanDetail").isDisplayed();
        System.out.println(" Populated Items visible is" + Populated);


//        boolean x = driver.findElement(By.id("com.sof.retail:id/quantityValue")).isEnabled();
//        System.out.println("Status is "+ x);
//        Thread.sleep(4000);
//
//        boolean xq = driver.findElement(By.id("com.sof.retail:id/InvoiceValue")).isEnabled();
//        System.out.println("Status is "+ xq);
//        Thread.sleep(4000);



        MobileElement xt = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
        xt.click();

        boolean cmtbox = driver.findElementById("com.sof.retail:id/etComment").isEnabled();
        System.out.println("The Comment status is" + cmtbox);
        Thread.sleep(4000);

        MobileElement cmt = (MobileElement) driver.findElementById("com.sof.retail:id/etComment");
        cmt.sendKeys("Receive 1");
        Thread.sleep(5000);
        System.out.println("1");
        MobileElement nxt = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]");
        nxt.click();
        System.out.println("2");
        Thread.sleep(5000);}
        catch (Exception e){
            System.out.println("Invoice Not Available");
        }









    }

    @Then("Verify Some Sections are Available in Summary Page")
    public void verify_some_are_are_avilable_in_summary_page() {
        try{
        String sum = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(sum, "Summary");
        System.out.println(sum + "Supplier is visible");

        String sum4 = driver.findElement(By.id("com.sof.retail:id/txtBy")).getText();
        Assert.assertEquals(sum4, "Received By");
        System.out.println(sum4 + " is visible");

        String sum45 = driver.findElement(By.id("com.sof.retail:id/itemCounted")).getText();
        Assert.assertEquals(sum45, "PO #");
        System.out.println(sum45 + " is visible");

        String sum455 = driver.findElement(By.id("com.sof.retail:id/textViewSupplierName")).getText();
        Assert.assertEquals(sum455, "For");
        System.out.println(sum455 + " is visible");

        String srt = driver.findElement(By.id("com.sof.retail:id/statDate")).getText();
        Assert.assertEquals(srt, "Started");
        System.out.println(srt + " is visible");

        String sum5 = driver.findElement(By.id("com.sof.retail:id/descpTextView")).getText();
        Assert.assertEquals(sum5, "Description");
        System.out.println(sum5 + " is visible");

        String sum6 = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).getText();
        Assert.assertEquals(sum6, "Qty");
        System.out.println(sum6 + " is visible");

//        String Des = driver.findElement(By.id("com.sof.retail:id/descpText")).getText();
//        Assert.assertEquals(Des, "SIGN PICK, FOR DELI #334312 100/PK");
//        System.out.println(Des + " is visible");

        String Qty = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        Assert.assertEquals(Qty, "1");
        System.out.println(Qty + " is visible");

        System.out.println("Test Done in Summery page");}
        catch (Exception e){
        System.out.println("Invoice Not Available");}






    }

    @Then("User is Verify all Final Transaction Done")
    public void verify_all_final_Transaction_done() throws InterruptedException {
try{
//        MobileElement send = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]");
//        send.click();

        String Wty = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(Wty, "WARNING");
        System.out.println(Wty + " is visible");

        System.out.println("WARNING popup for QA configured");

        MobileElement ok2 = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        ok2.click();

        String Trans = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(Trans, "Transaction");
        System.out.println(Trans + " is visible");

        String Time = driver.findElement(By.id("com.sof.retail:id/textViewDate")).getText();
        Assert.assertEquals(Time, "Sent June 24, 2022 at 15:20");
        System.out.println(Time + " is visible");

//        String num = driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
//        Assert.assertEquals(num, "121768827");
//        System.out.println(num + " is visible");

        MobileElement ok3 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        ok3.click();
    }
        catch (Exception e){
        System.out.println("Invoice Not Available");}
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }



}
