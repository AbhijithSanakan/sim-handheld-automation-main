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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T48DROrderShelfSchedStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=47;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User Verify Login and Going To Schedule Minimums Page Screen")
    public void user_Verify_Login_and_Going_To_Schedule_Minimums_Page_Screen() throws IOException, InterruptedException {

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
        Thread.sleep(10000);



        boolean SetupMinimums = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[1]").isDisplayed();
        System.out.println("The SetupMinimums status is" + SetupMinimums);
        boolean ScheduledMinimums = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[2]").isDisplayed();
        System.out.println("The ShuduleMinimums status is" + ScheduledMinimums);
        boolean RecurringMinimums = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[3]").isDisplayed();
        System.out.println("The RecurringMinimums status is" + RecurringMinimums);

        MobileElement Setupmin = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[2]/android.widget.ImageView");
        Setupmin.click();
        Thread.sleep(20000);

        actualText = driver.findElementById("com.sof.retail:id/checkBoxDepartment").getText();
        expectedText = "By Department";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/checkBoxOrder").getText();
        expectedText = "By Order";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/checkBoxAll").getText();
        expectedText = "All";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement all=(MobileElement)driver.findElementById("com.sof.retail:id/checkBoxAll");
        all.click();
        MobileElement nxt=(MobileElement)driver.findElementById("com.sof.retail:id/button3");
        nxt.click();
        Thread.sleep(9000);
    }

    @Then("User Check Able to Edit Schedule Mini Page")
    public void user_Check_Able_to_Edit_Schedule_Mini_Page() throws InterruptedException {
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

        actualText = driver.findElementById("com.sof.retail:id/textViewBase").getText();
        expectedText = "Base";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/textViewTemp").getText();
        expectedText = "Temp";
        TestAsserts.assertCheck(actualText,expectedText);



        boolean ItemGrid = driver.findElementById("com.sof.retail:id/recyclerViewShelfMinimumsScanItems").isDisplayed();
        System.out.println("The ItemGrid status is" + ItemGrid);

        boolean Next = driver.findElementById("com.sof.retail:id/button3").isDisplayed();
        System.out.println("The Next status is" + Next);
        Thread.sleep(2000);

        testCase =48;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);
        upc.clear();
    }

    @Then("User Verify add in Schedule Mini Page")
    public void user_Verify_add_in_Schedule_Mini_Page() {

        MobileElement Temptxt=(MobileElement)driver.findElementById("com.sof.retail:id/editTextTemp");
        Temptxt.click();Temptxt.clear();Temptxt.sendKeys("65");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

    }

    @When("Check Product able to Schedule In Recurring Mini Page")
    public void check_Product_able_to_Schedule_In_Recurring_Mini_Page() throws InterruptedException, IOException {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(300, 445))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(105, 445)).release().perform();
        Thread.sleep(5000);


        MobileElement Dlt=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
        Dlt.click();

        MobileElement nxt=(MobileElement)driver.findElementById("com.sof.retail:id/button3");
        nxt.click();

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
        testCase =48;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\Schedule" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }


}
