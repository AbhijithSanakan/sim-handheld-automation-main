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

public class T21ReceiveScanItemsStepdefs {
    static AndroidDriver<AndroidElement> driver;



    @Given("USER  Login and Going To Loading Supplier Screen")
    public void user_Login_and_Going_To_Loading_Supplier_Screen() throws InterruptedException, IOException {
       try{
           this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click(); try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
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


       }
       catch (Exception e){
           System.out.println("Receive invoice not available");
       }Thread.sleep(10000);
    }

    @When("Verify The Temperatures Page")
    public void user_Verify_The_All_emperatures_Page() throws InterruptedException {
        try {

            MobileElement nxt1 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
            nxt1.click();
            Thread.sleep(5000);
            System.out.println("Test Done in Select Invoice page");

        String sum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView")).getText();
        Assert.assertEquals(sum, "Record Temperatures");
        System.out.println(sum + " is visible");

        MobileElement Nextbtn1 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn1.click();
        System.out.println("Test Done in Temperature page");
        Thread.sleep(10000);

        MobileElement okcount = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okcount.click();
        Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println("Receive invoice not available");
        }Thread.sleep(10000);

    }

    @Then("USER Verify Every Thing is Ok in San Item Screen")
    public void user_Verify_Every_Thing_is_Ok_in_Scan_Item_Screen() throws InterruptedException {
       try{
        String scan = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView")).getText();
        Assert.assertEquals(scan, "Scan Items");
        System.out.println(scan + " is visible");

        String UPC = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
        Assert.assertEquals(UPC, "UPC");
        System.out.println(UPC + " is visible");


        String UOM = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
        Assert.assertEquals(UOM, "UOM");
        System.out.println(UOM + " is visible");

        String Des = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(Des, "Description");
        System.out.println(Des + " is visible");

        String Recv = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]")).getText();
        Assert.assertEquals(Recv,"Recv.");
        System.out.println(Recv + " is visible");

        String Allit = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView")).getText();
        Assert.assertEquals(Allit,"All Items");
        System.out.println(Allit + " is visible");

        boolean LeftArrow = driver.findElementById("com.sof.retail:id/imgLeftArrow").isDisplayed();
        System.out.println("The Left Arrow is" +LeftArrow);

        boolean RightArrow = driver.findElementById("com.sof.retail:id/imgRightArrow").isDisplayed();
        System.out.println("The Right Arrow is" +RightArrow);

        boolean progress = driver.findElementById("com.sof.retail:id/pbScannedItem").isDisplayed();
        System.out.println("The progress button is" +progress);

//        boolean progress = driver.findElementById("com.sof.retail:id/eachItemCount").isDisplayed();
//        System.out.println("The progress button is" +progress);

        String Item = driver.findElement(By.id("com.sof.retail:id/eachItemCount")).getText();
        Assert.assertEquals(Item,"Item 1 of 26");
        System.out.println(Item + " is visible");

        boolean Back = driver.findElementById("com.sof.retail:id/button").isDisplayed();
        System.out.println("The progress button is" +Back);

        boolean Nxt = driver.findElementById("com.sof.retail:id/button3").isDisplayed();
        System.out.println("The NEXT button is" +Nxt);

//        MobileElement upcclk = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
//        upcclk.click();

        String itm25 = driver.findElement(By.id("com.sof.retail:id/tvTotalRecvCount")).getText();
        Assert.assertEquals(itm25,"25.0");
        System.out.println(itm25 + " is visible");

        driver.findElement(By.id("com.sof.retail:id/upcScanText")).click();
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        String itm26 = driver.findElement(By.id("com.sof.retail:id/tvTotalRecvCount")).getText();
        Assert.assertEquals(itm26,"26.0");
        System.out.println(itm26 + " is visible");

        MobileElement Hyplnk = (MobileElement) driver.findElementById("com.sof.retail:id/linkWHRDesc");
        Hyplnk.click();
        Thread.sleep(5000);

        String itminfo = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        Assert.assertEquals(itminfo,"ITEM INFO");
        System.out.println(itminfo + " is visible");

        MobileElement itmpopok = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        itmpopok.click();

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(254, 476))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(89, 475)).release().perform();
        Thread.sleep(5000);

        try {
            MobileElement dlt = (MobileElement) driver.findElementById("com.sof.retail:id/itemDelete");
            System.out.println("Delete Button is present");
        }
catch (Exception e) {
            System.out.println("Delete Button not present");
        }

        MobileElement lookup = (MobileElement) driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Item Lookup\"])[5]");
        lookup.click();
        Thread.sleep(10000);

        String ITM = driver.findElement(By.id("com.sof.retail:id/tvTitle")).getText();
        Assert.assertEquals(ITM,"ITEM INFORMATION");
        System.out.println(ITM + " is visible");

        MobileElement X = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView");
        X.click();

        action.press(PointOption.point(254, 476))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(89, 475)).release().perform();
        Thread.sleep(4000);


        MobileElement Delet = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Delete\"]");
        Delet.click();
        Thread.sleep(5000);

        String itms26 = driver.findElement(By.id("com.sof.retail:id/tvTotalRecvCount")).getText();
        Assert.assertEquals(itms26,"25.0");
        System.out.println(itms26 + " is visible");

        action.press(PointOption.point(299, 433))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(117, 434)).release().perform();
        Thread.sleep(5000);
try {
    MobileElement dlt = (MobileElement) driver.findElementById("com.sof.retail:id/itemDelete");
    dlt.click();
    System.out.println("Delete Button is present");
}
catch (Exception e) {
    System.out.println("Delete Button not present");
}


        MobileElement barcd = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
        barcd.click();

        String Cant = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        Assert.assertEquals(Cant,"CAN’T SCAN");
        System.out.println(Cant + " is visible");

//        MobileElement txtbx = (MobileElement) driver.findElementById("com.sof.retail:id/dialogEditText");
//        txtbx.click();
//        txtbx.sendKeys("cock");

        driver.findElement(By.id("com.sof.retail:id/dialogEditText")).sendKeys("cock");
        Actions actios = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement okok = (MobileElement) driver.findElementById("com.sof.retail:id/dialogOkButton");
//        okok.click();
        System.out.println("done");
        MobileElement Ryttarw = (MobileElement) driver.findElementById("com.sof.retail:id/imgRightArrow");
        Ryttarw.click();
        Thread.sleep(3000);

        MobileElement leftarw = (MobileElement) driver.findElementById("com.sof.retail:id/imgLeftArrow");
        leftarw.click();

        MobileElement Didc = (MobileElement) driver.findElementById("com.sof.retail:id/discardIcon");
        Didc.click();

        MobileElement Didcbtn = (MobileElement) driver.findElementById("com.sof.retail:id/discardYesButton");
        Didcbtn.click();
       }
       catch (Exception e){
           System.out.println("Receive invoice not available");
       }Thread.sleep(3000);

        driver.closeApp();
        driver.quit();











    }

}
