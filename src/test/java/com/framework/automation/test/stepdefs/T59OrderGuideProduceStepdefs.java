package com.framework.automation.test.stepdefs;

import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import common.ReadData;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T59OrderGuideProduceStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=59;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("Verify Login and Going To Order Guide Page")
    public void verify_Login_and_Going_To_Order_Guide_Page() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(91, 719))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(248, 353)).release().perform();

        MobileElement advanced = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]");
        advanced.click();
        MobileElement password = (MobileElement) driver.findElementById("com.sof.retail:id/edtScanCode");
        password.sendKeys(ReadData.getDecodepassword());
        MobileElement okBtn = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        okBtn.click();
        MobileElement Chng = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]");
        Chng.click();Thread.sleep(6000);
        MobileElement qa = (MobileElement) driver.findElementById("com.sof.retail:id/edit_serachStore");
        qa.sendKeys("2241");
        MobileElement ok = (MobileElement) driver.findElementById("com.sof.retail:id/tv_storeName");
        ok.click();Thread.sleep(15000);


        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(9000);

        //Swiping Down
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.TextView");
        el3.click();
        Thread.sleep(10000);


        try{
            actualText = driver.findElementByXPath("//android.widget.TextView[@text='Bakery']").getText();
            expectedText = "Bakery";
            TestAsserts.assertCheck(actualText,expectedText);}
        catch (Exception e){
            System.out.println("Bakery Not Visible");
        }
        try{
            actualText = driver.findElementByXPath("//android.widget.TextView[@text='Produce Items']").getText();
            expectedText = "Produce Items";
            TestAsserts.assertCheck(actualText,expectedText);}
        catch (Exception e){
            System.out.println("Produce Items Not Visible");
        }
        try{
            actualText = driver.findElementByXPath("//android.widget.TextView[@text='Floral Items']").getText();
            expectedText = "Floral Items";
            TestAsserts.assertCheck(actualText,expectedText);}
        catch (Exception e){
            System.out.println("Floral Items Not Visible");
        }
        try{
            actualText = driver.findElementByXPath("//android.widget.TextView[@text='Tobacco Items']").getText();
            expectedText = "Tobacco Items";
            TestAsserts.assertCheck(actualText,expectedText);}
        catch (Exception e){
            System.out.println("Tobacco Items Not Visible");
        }
        try{
            actualText = driver.findElementByXPath("//android.widget.TextView[@text='Meat Items']").getText();
            expectedText = "Meat Items";
            TestAsserts.assertCheck(actualText,expectedText);}
        catch (Exception e){
            System.out.println("Meat Items Not Visible");
        }
        try{
            actualText = driver.findElementByXPath("//android.widget.TextView[@text='Deli Items']").getText();
            expectedText = "Deli Items";
            TestAsserts.assertCheck(actualText,expectedText);}
        catch (Exception e){
            System.out.println("Deli Items Not Visible");
        }
        try{
            actualText = driver.findElementByXPath("//android.widget.TextView[@text='Over & Above']").getText();
            expectedText = "Over & Above";
            TestAsserts.assertCheck(actualText,expectedText);}
        catch (Exception e){
            System.out.println("Over & Above Not Visible");
        }
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        el1.click();
        Thread.sleep(20000);

    }

    @Then("Check Contents Present in Produce Items Page")
    public void check_Contents_Present_in_Produce_Items_Page() throws InterruptedException {

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "LAST ORDER WORKED";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Yes  = (MobileElement) driver.findElementById("com.sof.retail:id/negativeButton");
        Yes.click();
        Thread.sleep(10000);

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Back Stock List";
        TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(5000);

        MobileElement Value1  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText");
        Value1.click();Value1.sendKeys("10");
        Thread.sleep(5000);

        MobileElement Value2  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText");
        Value2.click();Value2.sendKeys("10");
        Thread.sleep(3000);
        MobileElement Value3  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText");
        Value3.click();Value3.sendKeys("10");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        MobileElement Nxt  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        Nxt.click();
        Thread.sleep(5000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "STARTING ORDER";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement ok  = (MobileElement) driver.findElementById("com.sof.retail:id/negativeButton");
        ok.click();
        Thread.sleep(9000);
    }

    @Then("Verify all in Produce Items Page")
    public void verify_all_in_Produce_Items_Page() throws IOException, InterruptedException {
        actualText = driver.findElementById("com.sof.retail:id/upcText").getText();
        expectedText = "UPC";TestAsserts.assertCheck(actualText,expectedText);

        boolean Print = driver.findElementById("com.sof.retail:id/printerButton").isDisplayed();
        System.out.println("The Print Button status is" + Print);

        actualText = driver.findElementById("com.sof.retail:id/frcstTextView").getText();
        expectedText = "Frcst";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/lastTextView").getText();
        expectedText = "Last";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/locTextView").getText();
        expectedText = "Loc.";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/bohTextView").getText();
        expectedText = "BOH";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/minTextView").getText();
        expectedText = "Min.";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/sugTextView").getText();
        expectedText = "Sug.";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/costText").getText();
        expectedText = "Cost:";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/transitTextView").getText();
        expectedText = "BOH + In Transit:";TestAsserts.assertCheck(actualText,expectedText);

        boolean qust = driver.findElementById("com.sof.retail:id/descriptionImage").isDisplayed();
        System.out.println("The ? Button status is" + qust);

        actualText = driver.findElementById("com.sof.retail:id/descriptionText").getText();
        expectedText = "Description";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/packText").getText();
        expectedText = "Pack";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/qtyText").getText();
        expectedText = "Qty";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView[3]").getText();
        expectedText = "Total";TestAsserts.assertCheck(actualText,expectedText);

        boolean Categories = driver.findElementById("com.sof.retail:id/soAllItemsSpinnner").isDisplayed();
        System.out.println("The Categories DropDown status is" + Categories);

        boolean Item = driver.findElementById("com.sof.retail:id/storeOrderItemsCount").isDisplayed();
        System.out.println("The Item  status is" + Item);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView[3]").getText();
        expectedText = "Piece Count";TestAsserts.assertCheck(actualText,expectedText);

        boolean Next = driver.findElementById("com.sof.retail:id/button3").isDisplayed();
        System.out.println("The Next Button status is" + Next);
        boolean Back = driver.findElementById("com.sof.retail:id/button").isDisplayed();
        System.out.println("The Back Button status is" + Back);
        boolean Keyboard = driver.findElementById("com.sof.retail:id/imageKeyboard").isDisplayed();
        System.out.println("The Keyboard Button status is" + Keyboard);
        boolean Discard = driver.findElementById("com.sof.retail:id/discardIcon").isDisplayed();
        System.out.println("The Discard Button status is" + Discard);

        MobileElement qtyy  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText");
        qtyy.click();qtyy.sendKeys("20");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\Deviations\\59-Step-8" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        MobileElement qty1  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText");
        qty1.click();qty1.sendKeys("20");
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ESCAPE).perform();

        MobileElement Hyplink  = (MobileElement) driver.findElementById("com.sof.retail:id/linkDesc");
        Hyplink.click();
        Thread.sleep(5000);

        actualText = driver.findElementById("com.sof.retail:id/dialogTitleTextView").getText();
        expectedText = "ITEM INFO";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement okk  = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        okk.click();
        Thread.sleep(5000);

        MobileElement pnt  = (MobileElement) driver.findElementById("com.sof.retail:id/printerButton");
        pnt.click();
        Thread.sleep(6000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "LABEL REQUEST";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement okkk  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okkk.click();
        Thread.sleep(5000);

        MobileElement Bk  = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Bk.click();

        MobileElement can  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        can.click();

        MobileElement Minecli  = (MobileElement) driver.findElementById("com.sof.retail:id/dotText");
        Minecli.click();
        Thread.sleep(6000);

        MobileElement canl  = (MobileElement) driver.findElementById("com.sof.retail:id/cancelButton");
        canl.click();
        Thread.sleep(5000);


        MobileElement qustion  = (MobileElement) driver.findElementById("com.sof.retail:id/descriptionImage");
        qustion.click();
        Thread.sleep(5000);
        actualText = driver.findElementById("com.sof.retail:id/dialogTitleTextView").getText();
        expectedText = "LEGEND";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement okay  = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        okay.click();
        Thread.sleep(5000);

        MobileElement CatDD  = (MobileElement) driver.findElementById("com.sof.retail:id/soAllItemsSpinnner");
        CatDD.click();
        Thread.sleep(5000);

        MobileElement ChangeDD  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView");
        ChangeDD.click();

        MobileElement RightArrow  = (MobileElement) driver.findElementById("com.sof.retail:id/rightArrow");
        RightArrow.click();

        actualText = driver.findElementById("com.sof.retail:id/tvCategory").getText();
        expectedText = "ASIAN PRODUCE ROOT CROPS";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement LeftArrow  = (MobileElement) driver.findElementById("com.sof.retail:id/leftArrow");
        LeftArrow.click();

        actualText = driver.findElementById("com.sof.retail:id/tvCategory").getText();
        expectedText = "APPLES ";TestAsserts.assertCheck(actualText,expectedText);







    }

    @When("Verify in Back to Order Guide Page With out Send")
    public void verify_in_Back_to_Order_Guide_Page_With_out_Send() throws InterruptedException, IOException {

        MobileElement qtyy  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText");
        qtyy.click();qtyy.sendKeys("20");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\Deviations\\59-Step-8" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        MobileElement qty1  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText");
        qty1.click();qty1.sendKeys("20");
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ESCAPE).perform();

        MobileElement Hyplink  = (MobileElement) driver.findElementById("com.sof.retail:id/linkDesc");
        Hyplink.click();
        Thread.sleep(5000);

        actualText = driver.findElementById("com.sof.retail:id/dialogTitleTextView").getText();
        expectedText = "ITEM INFO";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement okk  = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        okk.click();
        Thread.sleep(5000);

        MobileElement pnt  = (MobileElement) driver.findElementById("com.sof.retail:id/printerButton");
        pnt.click();
        Thread.sleep(6000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "LABEL REQUEST";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement okkk  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okkk.click();
        Thread.sleep(5000);

        MobileElement Bk  = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Bk.click();

        MobileElement can  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        can.click();

        MobileElement Minecli  = (MobileElement) driver.findElementById("com.sof.retail:id/dotText");
        Minecli.click();
        Thread.sleep(6000);

        MobileElement canl  = (MobileElement) driver.findElementById("com.sof.retail:id/cancelButton");
        canl.click();
        Thread.sleep(5000);


        MobileElement qustion  = (MobileElement) driver.findElementById("com.sof.retail:id/descriptionImage");
        qustion.click();
        Thread.sleep(5000);
        actualText = driver.findElementById("com.sof.retail:id/dialogTitleTextView").getText();
        expectedText = "LEGEND";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement okay  = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        okay.click();
        Thread.sleep(5000);

        MobileElement CatDD  = (MobileElement) driver.findElementById("com.sof.retail:id/soAllItemsSpinnner");
        CatDD.click();
        Thread.sleep(5000);

        MobileElement ChangeDD  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView");
        ChangeDD.click();

        MobileElement RightArrow  = (MobileElement) driver.findElementById("com.sof.retail:id/rightArrow");
        RightArrow.click();

        actualText = driver.findElementById("com.sof.retail:id/tvCategory").getText();
        expectedText = "ASIAN PRODUCE ROOT CROPS";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement LeftArrow  = (MobileElement) driver.findElementById("com.sof.retail:id/leftArrow");
        LeftArrow.click();

        actualText = driver.findElementById("com.sof.retail:id/tvCategory").getText();
        expectedText = "APPLES ";TestAsserts.assertCheck(actualText,expectedText);

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }

}
