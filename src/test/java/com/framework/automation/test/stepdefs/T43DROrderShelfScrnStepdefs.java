package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
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

public class T43DROrderShelfScrnStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=43;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User Verify Login and Going To Shelf Minimums Page Screen")
    public void user_Verify_Login_and_Going_To_Shelf_Minimums_Page_Screen() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(9000);

        //Swiping Down
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[6]/android.widget.TextView");
        el3.click();
        Thread.sleep(5000);
        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);

        boolean SetupMinimums = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[1]").isDisplayed();
        System.out.println("The SetupMinimums status is" + SetupMinimums);
        boolean ScheduledMinimums = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[2]").isDisplayed();
        System.out.println("The ShuduleMinimums status is" + ScheduledMinimums);
        boolean RecurringMinimums = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[3]").isDisplayed();
        System.out.println("The RecurringMinimums status is" + RecurringMinimums);

        MobileElement Setupmin = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[1]");
        Setupmin.click();
        Thread.sleep(20000);
    }

    @Then("User Check Able to Edit Select Mini Page")
    public void user_Check_Able_to_Edit_Select_Mini_Page() throws InterruptedException {

        String UPC = driver.findElementById("com.sof.retail:id/upcText").getText();
        Assert.assertEquals(UPC, "UPC");
        System.out.println(UPC + " is visible");

        boolean Print = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView").isDisplayed();
        System.out.println("The Printer status is" + Print);

        String Shelf = driver.findElementById("com.sof.retail:id/shelfDescTextView").getText();
        Assert.assertEquals(Shelf, "Shelf:");
        System.out.println(Shelf + "field is visible");

        String Pack= driver.findElementById("com.sof.retail:id/packTextView").getText();
        Assert.assertEquals(Pack, "Pack");
        System.out.println(Pack + " is visible");

        String Size = driver.findElementById("com.sof.retail:id/sizeTextView").getText();
        Assert.assertEquals(Size, "Size");
        System.out.println(Size + " is visible");

        String Loc = driver.findElementById("com.sof.retail:id/locTextView").getText();
        Assert.assertEquals(Loc, "Loc.");
        System.out.println(Loc + " is visible");

        String Base = driver.findElementById("com.sof.retail:id/checkBoxBase").getText();
        Assert.assertEquals(Base, "Base");
        System.out.println(Base + " is visible");

        String Temp = driver.findElementById("com.sof.retail:id/checkBoxTemp").getText();
        Assert.assertEquals(Temp, "Temp");
        System.out.println(Temp + " is visible");

        boolean tempdrpdwn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.Spinner").isDisplayed();
        System.out.println("The Temp Drop Down status is" + tempdrpdwn);

        boolean Schedule = driver.findElementById("com.sof.retail:id/rbSchedule").isDisplayed();
        System.out.println("The Schedule status is" + Schedule);

        boolean ScheduleDD = driver.findElementById("com.sof.retail:id/constraintLayoutScheduleFrom").isDisplayed();
        System.out.println("The ScheduleDD status is" + ScheduleDD);

        boolean Recurring = driver.findElementById("com.sof.retail:id/rbRecurring").isDisplayed();
        System.out.println("The Recurring status is" + Recurring);


        boolean RecurringDD = driver.findElementById("com.sof.retail:id/spinnerRecurring").isDisplayed();
        System.out.println("The RecurringDD status is" + RecurringDD);

        boolean ScheduletoDD = driver.findElementById("com.sof.retail:id/constraintLayoutScheduleTo").isDisplayed();
        System.out.println("The ScheduletoDD status is" + ScheduletoDD);

        boolean ItemGrid = driver.findElementById("com.sof.retail:id/recyclerViewShelfMinimumsScanItems").isDisplayed();
        System.out.println("The ItemGrid status is" + ItemGrid);

        boolean Next = driver.findElementById("com.sof.retail:id/buttonConfirm").isDisplayed();
        System.out.println("The Next status is" + Next);
        Thread.sleep(2000);

        MobileElement UPC1 = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        UPC1.click();UPC1.sendKeys("01010");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(6000);

        String UNABLETOPROCEED = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        Assert.assertEquals(UNABLETOPROCEED, "UNABLE TO PROCEED");
        System.out.println(UNABLETOPROCEED + " is visible");

        MobileElement ok=(MobileElement)driver.findElementById("com.sof.retail:id/positiveButton");
        ok.click();
        Thread.sleep(5000);

        testCase =43;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);
        upc.clear();

        String Pack1= driver.findElementById("com.sof.retail:id/packTextView").getText();
        Assert.assertEquals(Pack1, "Pack");
        String Packvalue= driver.findElementById("com.sof.retail:id/packTextValue").getText();
        Assert.assertEquals(Packvalue, "24");
        System.out.println(Pack1+ Packvalue + " is visible");

        String Sizeq = driver.findElementById("com.sof.retail:id/sizeTextView").getText();
        Assert.assertEquals(Sizeq, "Size");
        String Sizevalue= driver.findElementById("com.sof.retail:id/sizeTextValue").getText();
        Assert.assertEquals(Sizevalue, "500ML");
        System.out.println(Sizeq+ Sizevalue + " is visible");

        String Loc1 = driver.findElementById("com.sof.retail:id/locTextView").getText();
        Assert.assertEquals(Loc1, "Loc.");
        String Locvalue= driver.findElementById("com.sof.retail:id/locTextValue").getText();
        Assert.assertEquals(Locvalue, "0/7");
        System.out.println(Loc1+ Locvalue + " is visible");

        String Base1 = driver.findElementById("com.sof.retail:id/checkBoxBase").getText();
        Assert.assertEquals(Base1, "Base");
        String Basevalue= driver.findElementById("com.sof.retail:id/editTextBase").getText();
        Assert.assertEquals(Basevalue, "9");
        System.out.println(Base1+ Basevalue + " is visible");

        String Shelf1 = driver.findElementById("com.sof.retail:id/shelfDescTextView").getText();
        Assert.assertEquals(Shelf1, "Shelf:");
        String Shelfvalue= driver.findElementById("com.sof.retail:id/shelfDescValue").getText();
        Assert.assertEquals(Shelfvalue, "FE CUSTOMER BEL 2 ");
        System.out.println(Shelf1+ Shelfvalue + " is visible");

        boolean Grid = driver.findElementById("com.sof.retail:id/itemDescription").isDisplayed();
        System.out.println("The Product status is" + Grid);

        MobileElement Hyplink=(MobileElement)driver.findElementById("com.sof.retail:id/linkDesc");
        Hyplink.click();

        String ItemInfo = driver.findElementById("com.sof.retail:id/textTitle").getText();
        Assert.assertEquals(ItemInfo, "ITEM INFO");
        System.out.println(ItemInfo + " is visible");

        MobileElement OK=(MobileElement)driver.findElementById("com.sof.retail:id/okButton");
        OK.click();
        Thread.sleep(5000);











//        String Sched]\led = driver.findElementById("").getText();
//        Assert.assertEquals(Scheduled, "Minimums");
//        System.out.println(Scheduled + " is visible");


//
//        String Recurring= driver.findElementById("").getText();
//        Assert.assertEquals(Recurring, "Minimums");
//        System.out.println(Recurring + " is visible");
//
//        String Summary = driver.findElementById("").getText();
//        Assert.assertEquals(Summary, "Summary");
//        System.out.println(Summary + " is visible");
//
//        String ItemsRemoved = driver.findElementById("").getText();
//        Assert.assertEquals(ItemsRemoved, "Removed");
//        System.out.println(ItemsRemoved + " is visible");
    }

    @Then("User Verify all in Select Mini Page")
    public void user_Verify_all_in_Select_Mini_Page() throws InterruptedException {

        String SetupMinimum = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        Assert.assertEquals(SetupMinimum, "Setup Minimums");
        System.out.println(SetupMinimum + " page is visible");

        MobileElement Clickbase=(MobileElement)driver.findElementById("com.sof.retail:id/checkBoxBase");
        Clickbase.click();

        boolean checkbox= driver.findElementById("com.sof.retail:id/editTextBase").isEnabled();
        System.out.println("The Checkbox status is" + checkbox);

        MobileElement basetxt=(MobileElement)driver.findElementById("com.sof.retail:id/editTextBase");
        basetxt.click();basetxt.sendKeys("8");

        MobileElement ClickTemp=(MobileElement)driver.findElementById("com.sof.retail:id/checkBoxTemp");
        ClickTemp.click();

        boolean Tempbox= driver.findElementById("com.sof.retail:id/checkBoxTemp").isEnabled();
        System.out.println("The Checkbox status is" + Tempbox);

        boolean Temptxt= driver.findElementById("com.sof.retail:id/editTextTemp").isEnabled();
        System.out.println("The Temptxt status is" + Temptxt);

        boolean TempDD= driver.findElementById("com.sof.retail:id/spinnerTemp").isEnabled();
        System.out.println("The TempDropDown status is" + TempDD);

        MobileElement TempDrop=(MobileElement)driver.findElementById("com.sof.retail:id/tvCategory");
        TempDrop.click();

        MobileElement free=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView");
        free.click();

        MobileElement Tempvalue=(MobileElement)driver.findElementById("com.sof.retail:id/editTextTemp");
        Tempvalue.click();Tempvalue.sendKeys("3");

        MobileElement TempDrop2=(MobileElement)driver.findElementById("com.sof.retail:id/tvCategory");
        TempDrop2.click();

        MobileElement X2=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView");
        X2.click();

//        String txt = driver.findElementById("com.sof.retail:id/editTextTemp").getText();
//        Assert.assertEquals(txt, "147");
//        System.out.println(txt + " is visible");

        MobileElement RadioRecurr=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.RadioButton[2]");
        RadioRecurr.click();

        boolean RecurrDD= driver.findElementById("com.sof.retail:id/spinnerRecurring").isEnabled();
        System.out.println("The RecurrDD status is" + RecurrDD);

        boolean Schedulefrm= driver.findElementById("com.sof.retail:id/constraintLayoutScheduleFrom").isEnabled();
        System.out.println("The Schedulefrm status is" + Schedulefrm);

        boolean ScheduleTo= driver.findElementById("com.sof.retail:id/constraintLayoutScheduleTo").isEnabled();
        System.out.println("The ScheduleTo status is" + ScheduleTo);

        MobileElement Recurrdrop=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.LinearLayout[2]/android.widget.Spinner/android.widget.LinearLayout/android.widget.TextView");
        Recurrdrop.click();
        Thread.sleep(5000);
        MobileElement RecDrop2=(MobileElement)driver.findElementById("com.sof.retail:id/tvCategory");
        RecDrop2.click();

        MobileElement RedioSchedule=(MobileElement)driver.findElementById("com.sof.retail:id/rbSchedule");
        RedioSchedule.click();

        boolean Schedulefrm1= driver.findElementById("com.sof.retail:id/constraintLayoutScheduleFrom").isEnabled();
        System.out.println("The Schedulefrm status is" + Schedulefrm1);

        boolean ScheduleTo1= driver.findElementById("com.sof.retail:id/constraintLayoutScheduleTo").isEnabled();
        System.out.println("The ScheduleTo status is" + ScheduleTo1);

        boolean RecurrDD1= driver.findElementById("com.sof.retail:id/spinnerRecurring").isEnabled();
        System.out.println("The RecurrDD status is" + RecurrDD1);

        MobileElement Datefrom=(MobileElement)driver.findElementById("com.sof.retail:id/imageScheduleFrom");
        Datefrom.click();

        MobileElement Date12=(MobileElement)driver.findElementByXPath("//android.view.View[@content-desc=\"30 August 2022\"]");
        Date12.click();

        MobileElement Dateok=(MobileElement)driver.findElementById("android:id/button1");
        Dateok.click();

        MobileElement DateTo=(MobileElement)driver.findElementById("com.sof.retail:id/imageScheduleTo");
        DateTo.click();

        MobileElement Dates12=(MobileElement)driver.findElementByXPath("//android.view.View[@content-desc=\"30 September 2022\"]");
        Dates12.click();

        MobileElement Datesok=(MobileElement)driver.findElementById("android:id/button1");
        Datesok.click();



//        boolean Grid2 = driver.findElementById("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView").isDisplayed();
//        System.out.println("The Product2 status is" + Grid2);

        //Swiping Left
        TouchAction act = new TouchAction(driver);
        act.press(PointOption.point(350, 475))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(95, 475)).release().perform();
        Thread.sleep(5000);
        System.out.println("1");
        MobileElement Da=(MobileElement)driver.findElementById("com.sof.retail:id/itemDelete");
        Da.click();

        testCase =43;
        keys = "UPC 2";
        MobileElement upc1 = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc1.click();
        upc1.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions acti = new Actions(driver);
        acti.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);
        upc1.clear();

        MobileElement nxt=(MobileElement)driver.findElementById("com.sof.retail:id/buttonConfirm");
        nxt.click();
        Thread.sleep(10000);
    }

    @When("Check Product able to Remove In Select Mini Page")
    public void check_Product_able_to_Remove_In_Select_Mini_Page() throws InterruptedException {
        String Summary = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        Assert.assertEquals(Summary, "Summary");
        System.out.println(Summary + " is visible");

        String S = driver.findElementById("com.sof.retail:id/shelfQtyText").getText();
        Assert.assertEquals(S, "Min. Shelf Qty. Adjustments");
        System.out.println(S + " is visible");

        MobileElement bk=(MobileElement)driver.findElementById("com.sof.retail:id/button");
        bk.click();

        String SetupMinimums = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        Assert.assertEquals(SetupMinimums, "Setup Minimums");
        System.out.println(SetupMinimums + " is visible");

        MobileElement disbtn=(MobileElement)driver.findElementById("com.sof.retail:id/discardIcon");
        disbtn.click();

        MobileElement disbtnyes=(MobileElement)driver.findElementById("com.sof.retail:id/discardYesButton");
        disbtnyes.click();

        String SelfMinimums = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        Assert.assertEquals(SelfMinimums, "Shelf Minimums");
        System.out.println(SelfMinimums + " is visible");

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }

}
