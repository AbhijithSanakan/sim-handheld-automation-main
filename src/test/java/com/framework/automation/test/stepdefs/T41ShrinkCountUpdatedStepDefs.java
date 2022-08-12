package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
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
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.UUID;

public class T41ShrinkCountUpdatedStepDefs {

    static AndroidDriver<AndroidElement> driver;
    static int testCase=41 ;
    static String keys =null;
    static String transNum;
   @Given("User Login and Reach To Cunt and Select Shrink")
   public void user_Login_and_Reach_To_Cunt_and_Select_Shrink() throws IOException, InterruptedException {
       this.driver = Login.LoginDriver();
       Thread.sleep(10000);

       MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.view.ViewGroup/android.widget.RelativeLayout");
       el2.click();
       Thread.sleep(5000);
       MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]");
       el1.click();
       Thread.sleep(15000);


}

    @Then("Verify UPC All Shrink Able to Add")
    public void verify_UPC_All_Shrink_Able_to_Add() throws InterruptedException {
        testCase =41;
        keys = "UPC 1";
        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        String  REQUIRED= driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(REQUIRED, "REQUIRED");
        System.out.println(REQUIRED + " is visible");

//       MobileElement Required = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.TextView");
//       Required.click();


        MobileElement ok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButtonSC");
        ok.click();
        MobileElement ok2 = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButtonSC");
        ok2.click();


        testCase =41;
        keys = "UPC 2";
        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Thread.sleep(5000);
        MobileElement clk = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        clk.click();
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        MobileElement ReasonDD = (MobileElement) driver.findElementById("com.sof.retail:id/reasonSpinner");
        ReasonDD.click();

        MobileElement Reason = (MobileElement) driver.findElementById("com.sof.retail:id/descriptionText");
        Reason.click();

        MobileElement Desposal = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.TextView");
        Desposal.click();

        MobileElement Destroy = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        Destroy.click();



        MobileElement GRID = (MobileElement) driver.findElementById("com.sof.retail:id/edtItemCount");
        GRID.click();
        GRID.sendKeys(".5");

//        MobileElement UOM = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Spinner/android.widget.TextView");
//        UOM.click();Thread.sleep(5000);



//        MobileElement SHPC = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='SHPC']");
//        SHPC.click();Thread.sleep(5000);

        Thread.sleep(5000);

        MobileElement sym = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]");
        sym.click();

        String  LEGEND= driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
        Assert.assertEquals(LEGEND, "LEGEND");
        System.out.println(LEGEND + " is visible");

        MobileElement k = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        k.click();

        Thread.sleep(5000);
//       MobileElement Loc = (MobileElement) driver.findElementById("com.sof.retail:id/txtLocText");
//       Loc.click();

//
//       String ITEMLOCATION = driver.findElement(By.id("com.sof.retail:id/dialogTitleTextView")).getText();
//       Assert.assertEquals(ITEMLOCATION, "ITEM LOCATION");
//       System.out.println(ITEMLOCATION + " is visible");
//
//       MobileElement k1 = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
//       k1.click();

        MobileElement line = (MobileElement) driver.findElementById("com.sof.retail:id/textViewItemName");
        line.click();

        String ITEMINFO = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(ITEMINFO, "ITEM INFO");
        System.out.println(ITEMINFO + " is visible");

        MobileElement k2 = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        k2.click();



    }

    @Then("Verify Able To Remove Items to")
    public void verify_Able_To_Remove_Items_to() throws InterruptedException {
        TouchAction acti = new TouchAction(driver);

        acti.press(PointOption.point(256, 495))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(66, 495)).release().perform();
        Thread.sleep(5000);
        MobileElement dlt = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
        dlt.click();

        MobileElement Discrd = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ImageView");
        Discrd.click();
        Thread.sleep(5000);
        String DisCard = driver.findElement(By.id("com.sof.retail:id/dialogTitleWarningTextView")).getText();
        Assert.assertEquals(DisCard, "DISCARD SHRINK COUNT");
        System.out.println(DisCard + " is visible");

        MobileElement canDiscrd = (MobileElement) driver.findElementById("com.sof.retail:id/discardNoButton");
        canDiscrd.click();Thread.sleep(5000);

        MobileElement confirm = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        confirm.click();

        Thread.sleep(9000);

    }

    @Then("Verify Summery Page and get back to Shrink Page")
    public void Verify_Summery_Page_and_get_back_to_Shrink_Page() throws InterruptedException {

        String Summary = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(Summary, "Summary");
        System.out.println(Summary + " is visible");

        String TimeRemaining = driver.findElement(By.id("com.sof.retail:id/textDownTimerHolder")).getText();
        Assert.assertEquals(TimeRemaining, "Time Remaining");
        System.out.println(TimeRemaining + " is visible");

        String ItemsShrunk = driver.findElement(By.id("com.sof.retail:id/textItemCountedHolder")).getText();
        Assert.assertEquals(ItemsShrunk, "Items Shrunk");
        System.out.println(ItemsShrunk + " is visible");

        MobileElement back = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        back.click();
        Thread.sleep(5000);

        String ShrinkCount = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(ShrinkCount, "Shrink Count");
        System.out.println(ShrinkCount + " is visible");


    }

    @When("go to Transaction Page")
    public void go_to_transaction_page() throws InterruptedException, IOException {
        MobileElement confirm = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");

        confirm.click();
        Thread.sleep(5000);



        MobileElement snd = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        snd.click();Thread.sleep(5000);

        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();
        Thread.sleep(18000);

        transNum= driver.findElementById("com.sof.retail:id/descpCountText").getText();

        testCase =41;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\filename" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }



}
