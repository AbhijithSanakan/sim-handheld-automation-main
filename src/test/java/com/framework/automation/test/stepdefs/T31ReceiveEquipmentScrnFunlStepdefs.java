package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;


public class T31ReceiveEquipmentScrnFunlStepdefs
{
    static AndroidDriver<AndroidElement> driver;
    @Given("User is reach From Dashboard to ReceiveEquipment")
    public void user_is_reach_From_Dashboard_to_ReceiveEquipment() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[4]/android.widget.TextView");
        el1.click();
        Thread.sleep(10000);
    }

    @Then("Check in ReceiveEquipment Page")
    public void check_in_ReceiveEquipment_Page() throws InterruptedException {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText")).sendKeys("113113");
        Thread.sleep(4000);
        Actions acti = new Actions(driver);
        acti.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        MobileElement ok5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText");
        ok5.click();
        acti.sendKeys(Keys.ENTER).perform();
//
//
//        MobileElement rece = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.EditText");
//        rece.click();

        String REQUIRE = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(REQUIRE, "REQUIRED");
        System.out.println(REQUIRE + " is visible");
        Thread.sleep(5000);

        MobileElement o = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button");
        o.click();



    }

    @Then("Verify in Some Sections are Available in ReceiveEquipment Page")
    public void verify_in_Some_Sections_are_Available_in_ReceiveEquipment_Page() throws InterruptedException {

        String EnterItems = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(EnterItems, "Enter Items");
        System.out.println(EnterItems+ " is visible");

        String Make = driver.findElement(By.id("com.sof.retail:id/makeHintText")).getText();
        Assert.assertEquals(Make, "Make");
        System.out.println(Make+ " is visible");

        String serial = driver.findElement(By.id("com.sof.retail:id/serialNumberHintText")).getText();
        Assert.assertEquals(serial, "Serial Numbers");
        System.out.println(serial+ " is visible");

        String seriallable = driver.findElement(By.id("com.sof.retail:id/tvSerialNumber")).getText();
        Assert.assertEquals(seriallable, "Serial Numbers Not Required");
        System.out.println(seriallable+ " is visible");

        String Iteamid = driver.findElement(By.id("com.sof.retail:id/textItemID")).getText();
        Assert.assertEquals(Iteamid, "Item ID");
        System.out.println(Iteamid + " is visible");
        Thread.sleep(5000);



    }

    @Then("User is  Verify Able to Reach in Enter Items Page")
    public void user_is_Verify_Able_to_Reach_in_Enter_Items_Page() throws InterruptedException {
        String Descri = driver.findElement(By.id("com.sof.retail:id/descriptionTextHolder")).getText();
        Assert.assertEquals(Descri, "Description");
        System.out.println(Descri + " is visible");
        Thread.sleep(5000);

        String inv = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]")).getText();
        Assert.assertEquals(inv,"Inv.");
        System.out.println(inv + " is visible");

        String Recv = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[7]")).getText();
        Assert.assertEquals(Recv,"Recv.");
        System.out.println(Recv + " is visible");


        boolean progress = driver.findElementById("com.sof.retail:id/bottomProgressBar").isDisplayed();
        System.out.println("The progress button is" +progress);

        boolean nxtbutton = driver.findElementById("com.sof.retail:id/button").isDisplayed();
        System.out.println("The NEXT button is" +nxtbutton);

        boolean keyboard = driver.findElementById("com.sof.retail:id/ccImagePrint").isDisplayed();
        System.out.println("The keyboard button is" +keyboard);


        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys("6111");
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);
        System.out.println("Three digit Limit");

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys("1");
        Thread.sleep(4000);
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        boolean Populated= driver.findElementById("com.sof.retail:id/scanDetail").isDisplayed();
        System.out.println(" Populated Items visible is" + Populated);

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }

}
