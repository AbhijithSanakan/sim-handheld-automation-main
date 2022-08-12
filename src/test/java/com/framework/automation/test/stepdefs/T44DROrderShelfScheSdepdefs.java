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

public class T44DROrderShelfScheSdepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=44;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("Verify Login and Going To Shelf Minimums Page Screen")
    public void verify_Login_and_Going_To_Shelf_Minimums_Page_Screen() throws IOException, InterruptedException {

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

    @Then("Check Able to Edit Select Mini Page")
    public void check_Able_to_Edit_Select_Mini_Page() throws InterruptedException {
        actualText = driver.findElementById("com.sof.retail:id/upcText").getText();
        expectedText = "UPC";
        TestAsserts.assertCheck(actualText,expectedText);


        boolean Print = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView").isDisplayed();
        System.out.println("The Printer status is" + Print);

        actualText = driver.findElementById("com.sof.retail:id/shelfDescTextView").getText();
        expectedText = "Shelf:";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/packTextView").getText();
        expectedText = "Pack";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/sizeTextView").getText();
        expectedText = "Size";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/locTextView").getText();
        expectedText = "Loc.";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/checkBoxBase").getText();
        expectedText = "Base";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/checkBoxTemp").getText();
        expectedText = "Temp";
        TestAsserts.assertCheck(actualText,expectedText);

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


    }

    @Then("Verify all in Select Mini Page")
    public void verify_all_in_Select_Mini_Page() throws InterruptedException {
        MobileElement UPC1 = (MobileElement) driver.findElementById("com.sof.retail:id/upcScanText");
        UPC1.click();UPC1.sendKeys("01010");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        String UNABLETOPROCEED = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        Assert.assertEquals(UNABLETOPROCEED, "UNABLE TO PROCEED");
        System.out.println(UNABLETOPROCEED + " is visible");

        MobileElement ok=(MobileElement)driver.findElementById("com.sof.retail:id/positiveButton");
        ok.click();
        Thread.sleep(5000);

        testCase =44;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);
        upc.clear();

        actualText = driver.findElementById("com.sof.retail:id/packTextView").getText();
        expectedText = "Pack";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/packTextValue").getText();
        expectedText = "24";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/sizeTextView").getText();
        expectedText = "Size";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/sizeTextValue").getText();
        expectedText = "500ML";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/locTextView").getText();
        expectedText = "Loc.";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/locTextValue").getText();
        expectedText = "0/7";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/checkBoxBase").getText();
        expectedText = "Base";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/editTextBase").getText();
        expectedText = "9";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/shelfDescTextView").getText();
        expectedText = "Shelf:";
        TestAsserts.assertCheck(actualText,expectedText);actualText = driver.findElementById("com.sof.retail:id/shelfDescValue").getText();
        expectedText = "FE CUSTOMER BEL 2 ";
        TestAsserts.assertCheck(actualText,expectedText);


        boolean Grid = driver.findElementById("com.sof.retail:id/itemDescription").isDisplayed();
        System.out.println("The Product status is" + Grid);

        MobileElement Hyplink=(MobileElement)driver.findElementById("com.sof.retail:id/linkDesc");
        Hyplink.click();

        actualText = driver.findElementById("com.sof.retail:id/textTitle").getText();
        expectedText = "ITEM INFO";
        TestAsserts.assertCheck(actualText,expectedText);


        MobileElement OK=(MobileElement)driver.findElementById("com.sof.retail:id/okButton");
        OK.click();
        Thread.sleep(5000);

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

        boolean Temptxt1= driver.findElementById("com.sof.retail:id/editTextTemp").isEnabled();
        System.out.println("The Temptxt status is" + Temptxt1);

        MobileElement nxt=(MobileElement)driver.findElementById("com.sof.retail:id/buttonConfirm");
        nxt.click();

    }

    @When("Verify Product able to Remove In Select Mini Page")
    public void verify_Product_able_to_Remove_In_Select_Mini_Page() throws InterruptedException, IOException {
        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Summary";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/shelfQtyText").getText();
        expectedText = "Min. Shelf Qty. Adjustments";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement snd = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        snd.click();

        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();
        Thread.sleep(10000);
        transNum= driver.findElementById("com.sof.retail:id/descpCountText").getText();
        testCase =44;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\ShelfSchedul" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }


}
