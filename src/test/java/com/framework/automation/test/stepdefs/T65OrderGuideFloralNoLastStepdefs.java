package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T65OrderGuideFloralNoLastStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=65 ;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    static String minimumNum;
    static String freeCountNum;
    @Given("Verify Login and click Order Guide Page")
    public void verify_Login_and_click_Order_Guide_Page() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD

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
        qa.sendKeys("2242");
        MobileElement ok = (MobileElement) driver.findElementById("com.sof.retail:id/tv_storeName");
        ok.click();Thread.sleep(15000);


        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(9000);

        //Swiping Down
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);
        System.out.println("1");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.TextView");
        el3.click();
        Thread.sleep(5000);
        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}Thread.sleep(9000);
        System.out.println("2");

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView").getText();
        expectedText = "Bakery";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView").getText();
        expectedText = "Produce Items";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView").getText();
        expectedText = "Floral Items";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView").getText();
        expectedText = "Tobacco Items";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView").getText();
        expectedText = "Meat Items";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView").getText();
        expectedText = "Deli Items";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.TextView").getText();
        expectedText = "Over & Above";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
        el1.click();
        Thread.sleep(20000);


    }

    @Then("User Contents Present Check at Floral Items Page")
    public void user_Contents_Present_Check_at_Floral_Items_Page() throws InterruptedException {
        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "LAST ORDER WORKED";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Yes  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Yes.click();
        Thread.sleep(20000);
//        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
//        el1.click();
        try{
            MobileElement Yes2  = (MobileElement) driver.findElementById("com.sof.retail:id/negativeButton");
            Yes2.click();
            Thread.sleep(10000);


        }

        catch (Exception e){
            actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
            expectedText = "Back Stock List";
            TestAsserts.assertCheck(actualText, expectedText);
            Thread.sleep(5000);
        }
        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Back Stock List";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(5000);


        MobileElement Nxt  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
        Nxt.click();
        Thread.sleep(5000);

//        try
//        {MobileElement okk  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
//            okk.click();
//            Thread.sleep(5000);}
//        catch (Exception e){
//            System.out.println("LOW BACK STOCK COUNT");
//        }
//        MobileElement Nxt1  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
//        Nxt1.click();


    }

    @Then("Check all in Floral Items Page")
    public void check_all_in_Floral_Items_Page() throws InterruptedException {
        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "LOW BACK STOCK COUNT";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement can  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        can.click();
        Thread.sleep(9000);


        MobileElement Value1  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText[2]");
        Value1.click();Value1.sendKeys("10");
        Thread.sleep(5000);

        MobileElement Value2  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText[2]");
        Value2.click();Value2.sendKeys("10");
        Thread.sleep(3000);
        MobileElement Value3  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText[2]");
        Value3.click();Value3.sendKeys("10");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        MobileElement Nxt1  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
        Nxt1.click();
        Thread.sleep(8000);

        MobileElement okk  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okk.click();
        Thread.sleep(8000);

    }

    @When("Check Back to Order Guide Page Click Send")
    public void check_Back_to_Order_Guide_Page_Click_Send() throws IOException, InterruptedException {
        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Floral Items";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Value1  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText");
        Value1.click();Value1.sendKeys("1");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        MobileElement next  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        next.click();

        MobileElement con  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        con.click();
        Thread.sleep(8000);

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Order Summary";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/priceTextView").getText();
        expectedText = "Piece";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/deliveryTextView").getText();
        expectedText = "Delivery";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/cutOffTextView").getText();
        expectedText = "Cutoff Time";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/descpTextView").getText();
        expectedText = "Description";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/qtyTextView").getText();
        expectedText = "Qty";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement Snd  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Snd.click();

        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();
        Thread.sleep(20000);

        testCase =65;
        minimumNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
        freeCountNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();


        keys = "Update Minimums";
        ExcelHandle.ExcelWriteFunction(testCase, keys, minimumNum);
        Thread.sleep(2000);
        keys = "Free Count";
        ExcelHandle.ExcelWriteFunction(testCase, keys, freeCountNum);
        Thread.sleep(2000);


        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\65OrderFloralNo" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }


}
