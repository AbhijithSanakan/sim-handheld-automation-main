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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T45DROrderPlanoApprovStapdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=44;
    static String keys =null;
    static String transNum;
    @Given("User is Verify Login and Going To Planograms Page Screen")
    public void user_is_Verify_Login_and_Going_To_Planograms_Page_Screen() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        el2.click();
        Thread.sleep(5000);

        //Swiping Down
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[7]");
        el3.click();
        Thread.sleep(10000);

    }

    @Then("User is Check Able to Edit Product to Remove Page")
    public void user_is_Check_Able_to_Edit_Product_to_Remove_Page() throws InterruptedException {
        Actions actions = new Actions(driver);
        //Swiping Down
//        TouchAction action = new TouchAction(driver);
//        action.press(PointOption.point(201, 606))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//                .moveTo(PointOption.point(203, 208)).release().perform();
//        Thread.sleep(5000);
        //Click Review
        MobileElement Review = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.Button");
        Review.click();
        Thread.sleep(10000);

        MobileElement Nxt = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt.click();
        Thread.sleep(5000);
    }

    @Then("User is Verify all in Product to Remove Page")
    public void user_is_Verify_all_in_Product_to_Remove_Page() throws InterruptedException {
//        MobileElement Nxt = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nxt.click();

        String Producttre = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        Assert.assertEquals(Producttre, "Questionnaire");
        System.out.println(Producttre + " is visible");

        MobileElement Shelf = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.CheckBox");
        Shelf.click();

        MobileElement Q1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.CheckBox");
        Q1.click();

        MobileElement Q2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.CheckBox");
        Q2.click();

        MobileElement Q3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.CheckBox");
        Q3.click();

        MobileElement Q4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.CheckBox");
        Q4.click();

        MobileElement Nxt1 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt1.click();
        Thread.sleep(8000);
    }

    @When("Check Weather Product able to Remove In New Lines Page")
    public void check_Weather_Product_able_to_Remove_In_New_Lines_Page() throws InterruptedException, IOException {
        String Summary = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        Assert.assertEquals(Summary, "Summary");
        System.out.println(Summary + " is visible");


        String ItemsRemoved = driver.findElementById("com.sof.retail:id/textItemsRemoved").getText();
        Assert.assertEquals(ItemsRemoved, "Items Removed");
        System.out.println(ItemsRemoved + " is visible");

        String ItemAdded = driver.findElementById("com.sof.retail:id/textItemAdded").getText();
        Assert.assertEquals(ItemAdded, "Items Added");
        System.out.println(ItemAdded + " is visible");

        String LabeltoPrint = driver.findElementById("com.sof.retail:id/textLabelPrint").getText();
        Assert.assertEquals(LabeltoPrint, "Labels to Print");
        System.out.println(LabeltoPrint + " is visible");

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
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\PlanoApprov" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }

}
