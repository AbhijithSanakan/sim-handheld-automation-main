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

public class T42DROrderPlanogramsStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=42;
    static String keys =null;
    static String transNum;

    @Given("User Verify Login and Going To Planograms Page Screen")
    public void user_Verify_Login_and_Going_To_Planograms_Page_Screen() throws IOException, InterruptedException {

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

        //Click Planograms
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[7]");
        el3.click();
        Thread.sleep(5000); try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);

    }



    @Then("User Check Able to Edit Product to Remove Page")
    public void user_Check_Able_to_Edit_Product_to_Remove_Page() throws InterruptedException, IOException {
        Actions actions = new Actions(driver);
        //Swiping Down
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(201, 204))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 473)).release().perform();
        Thread.sleep(5000);
        //Click Review
        MobileElement Review = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.Button");
        Review.click();
        Thread.sleep(10000);

            testCase =42;
            keys = "UPC 1";
            MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
            upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(9000);
            upc.clear();


            testCase =42;
            keys = "UPC 2";
            MobileElement upc2 = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
            upc2.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(9000);
            upc2.clear();

        MobileElement  Hyplink = (MobileElement) driver.findElementById("com.sof.retail:id/textViewItemName");
        Hyplink.click();
        Thread.sleep(5000);

        String ITEMINFO = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
        Assert.assertEquals(ITEMINFO, "ITEM INFO");
        System.out.println(ITEMINFO + " is visible");

        MobileElement  popok = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        popok.click();
        Thread.sleep(5000);



    }




    @Then("User Verify all in Product to Remove Page")
    public void user_Verify_all_in_Product_to_Remove_Page() throws InterruptedException {
        MobileElement  Printicon = (MobileElement) driver.findElementById("com.sof.retail:id/plnogramImagePrint");
        Printicon.click();
        Thread.sleep(5000);
        String LABEL = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
        Assert.assertEquals(LABEL, "LABEL REQUEST");
        System.out.println(LABEL + " is visible");
        Thread.sleep(5000);
        MobileElement  Lableok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Lableok.click();
        Thread.sleep(5000);
        Printicon.click();
        Thread.sleep(9000);

        MobileElement  Lableok2 = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Lableok2.click();

        Thread.sleep(9000);
//        String Producttre = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
//        Assert.assertEquals(Producttre, "Products to Remove");
//        System.out.println(Producttre + " is visible");
//
//
//        MobileElement  Sales = (MobileElement) driver.findElementById("com.sof.retail:id/salesTextHolder");
//        Sales.click();
//
//        MobileElement  Nxt = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
//        Nxt.click();
//        Thread.sleep(5000);



    }

    @When("Check Product able to Remove In New Lines Page")
    public void check_Product_able_to_Remove_In_New_Lines_Page() throws InterruptedException {
        String NewLines = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView")).getText();
        Assert.assertEquals(NewLines, "New Lines");
        System.out.println(NewLines + " is visible");

        MobileElement  bck = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        bck.click();
        Thread.sleep(9000);

//        String Producttre = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
//        Assert.assertEquals(Producttre, "Products to Remove");
//        System.out.println(Producttre + " is visible");

        MobileElement Discard = (MobileElement) driver.findElementById("com.sof.retail:id/discardIcon");
        Discard.click();

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();


    }

}
