package com.framework.automation.test.stepdefs;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T60OrderGuideOverStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=60;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    @Given("Verify Login and Going To Order Guide Page Screen")
    public void verify_Login_and_Going_To_Order_Guide_Page_Screen() throws IOException, InterruptedException {

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

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.TextView");
        el3.click();
        Thread.sleep(10000);
        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
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
        }Thread.sleep(10000);

    }

    @Then("Check Contents Present in Over Above Page")
    public void check_Contents_Present_in_Over_Above_Page() throws InterruptedException, IOException {
        MobileElement Overabove  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.TextView");
        Overabove.click();
        Thread.sleep(15000);

        actualText = driver.findElementById("com.sof.retail:id/upcText").getText();
        expectedText = "UPC";
        TestAsserts.assertCheck(actualText,expectedText);

        boolean Categories = driver.findElementById("com.sof.retail:id/soAllItemsSpinnner").isDisplayed();
        System.out.println("The Categories DropDown status is" + Categories);

        actualText = driver.findElementById("com.sof.retail:id/descriptionText").getText();
        expectedText = "Description";
        TestAsserts.assertCheck(actualText,expectedText);

        boolean Next = driver.findElementById("com.sof.retail:id/button3").isDisplayed();
        System.out.println("The Next Button status is" + Next);
        boolean Back = driver.findElementById("com.sof.retail:id/button").isDisplayed();
        System.out.println("The Back Button status is" + Back);
        boolean Keyboard = driver.findElementById("com.sof.retail:id/imageKeyboard").isDisplayed();
        System.out.println("The Keyboard Button status is" + Keyboard);
        boolean Discard = driver.findElementById("com.sof.retail:id/discardIcon").isDisplayed();
        System.out.println("The Discard Button status is" + Discard);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\Deviations\\60-Step-4,5,7,8" +".jpg";
        FileUtils.copyFile(file,new File(fileName));


    }

    @Then("Verify all in Over Above Page")
    public void verify_all_in_Over_Above_Page() throws InterruptedException, IOException {

        MobileElement CatDD  = (MobileElement) driver.findElementById("com.sof.retail:id/soAllItemsSpinnner");
        CatDD.click();

        MobileElement ChangeDD  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView");
        ChangeDD.click();

        actualText = driver.findElementById("com.sof.retail:id/tvCategory").getText();
        expectedText = "CHEESE SNACKS";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement RightArrow  = (MobileElement) driver.findElementById("com.sof.retail:id/rightArrow");
        RightArrow.click();

        actualText = driver.findElementById("com.sof.retail:id/tvCategory").getText();
        expectedText = "CORN CHIPS REGULAR";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement LeftArrow  = (MobileElement) driver.findElementById("com.sof.retail:id/leftArrow");
        LeftArrow.click();

        actualText = driver.findElementById("com.sof.retail:id/tvCategory").getText();
        expectedText = "CHEESE SNACKS";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Nxtybtn  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxtybtn.click();
        Thread.sleep(6000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "UNORDERED CATEGORIES";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement Continue  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Continue.click();
        Thread.sleep(6000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "NOTHING ORDERED";
        TestAsserts.assertCheck(actualText,expectedText);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\Deviations\\60-Step-11" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        MobileElement oK  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        oK.click();

        MobileElement Value  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText");
        Value.sendKeys("8");

//        MobileElement Value2  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText");
//        Value2.sendKeys("8");
//
//
//        MobileElement Value3  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText");
//        Value3.sendKeys("8");
        MobileElement Nxtybtn2  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxtybtn2.click();
        Thread.sleep(5000);


    }

    @When("Verify Back to Order Guide Page With out Send")
    public void verify_Back_to_Order_Guide_Page_With_out_Send() throws InterruptedException {

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Order Summary";
        TestAsserts.assertCheck(actualText,expectedText);

        MobileElement backbtn  = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        backbtn.click();
        Thread.sleep(9000);

        MobileElement backbtn1  = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        backbtn1.click();
        Thread.sleep(9000);

        MobileElement disc  = (MobileElement) driver.findElementById("com.sof.retail:id/discardYesButton");
        disc.click();
        Thread.sleep(10000);

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Order Guides";
        TestAsserts.assertCheck(actualText,expectedText);

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }


}
