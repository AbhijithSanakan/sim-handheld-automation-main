package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

public class T29ReturnEquipWHStepdefs {
    static AndroidDriver<AndroidElement> driver;

    static int testCase=29 ;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;

    @Given("User  From Dashboard to ReturnEquipment")
    public void user_From_Dashboard_to_ReturnEquipment() throws InterruptedException, IOException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.FrameLayout/android.widget.ImageView");
        el1.click();
        Thread.sleep(10000);



        MobileElement EquipWH = (MobileElement) driver.findElementById("com.sof.retail:id/equipRadioButton");
        EquipWH.click();

        String carrier = driver.findElement(By.id("com.sof.retail:id/carrierTextView")).getText();
        Assert.assertEquals(carrier, "Carrier");
        System.out.println(carrier+ " is visible ");

        MobileElement carrierdrop = (MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.EditText"));
        carrierdrop.click();

        MobileElement carrierSel = (MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.RadioGroup/android.widget.RadioButton[2]"));
        carrierSel.click();
        Thread.sleep(3000);

        MobileElement Truck = (MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.CheckBox"));
        Truck.click();

        MobileElement drop = (MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]"));
        drop.click();
        Thread.sleep(3000);

        MobileElement botl = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
        botl.click();
        Thread.sleep(10000);


        MobileElement next1 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        next1.click();
        Thread.sleep(10000);

    }

    @Then("Check in the ReturnEquipment Page")
    public void check_in_the_ReturnEquipment_Page() throws InterruptedException {
        String EnterItems = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(EnterItems, "Enter Items");
        System.out.println(EnterItems+ " is visible");
//Need to change data in invoice for every single run
        testCase =20;
        keys = "Invoice";
        driver.findElement(By.id("com.sof.retail:id/editTextItemID")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);

        testCase =20;
        keys = "Credit/Return#";
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        Thread.sleep(4000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        MobileElement Rtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.EditText");
        Rtn.click();
        Rtn.sendKeys("10");
        Actions aci = new Actions(driver);
        aci.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        MobileElement Nxt = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]");
        Nxt.click();
    }

    @Then("Verify in Some Sections are  in ReturnEquipment Page")
    public void verify_in_Some_Sections_are_in_ReturnEquipment_Page() throws InterruptedException {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText")).sendKeys("Return.WH");
        Thread.sleep(4000);
        Actions acti = new Actions(driver);
        acti.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);



    }

    @Then("User is  Verify Able to  in Equip.WH Page")
    public void user_is_Verify_Able_to_in_Equip_WH_Page() throws InterruptedException, IOException {
        String Ret = driver.findElement(By.id("com.sof.retail:id/txtBy")).getText();
        Assert.assertEquals(Ret , "Returned By");
        System.out.println(Ret+ " is visible");
        Thread.sleep(4000);

        String sum3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText();
        Assert.assertEquals(sum3, "Sathish Kuppaiyand");
        System.out.println(sum3 + "Sathish Kuppaiyand is visible");

        String sum4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum4, "Started");
        System.out.println(sum4 + " is visible");

        String sum5 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum5, "Description");
        System.out.println(sum5 + " is visible");

        String sum6 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        Assert.assertEquals(sum6, "Qty.");
        System.out.println(sum6 + " is visible");

//        String sum7 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
//        Assert.assertEquals(sum7, "1003");
//        System.out.println(sum7 + " is visible");



        MobileElement snd = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]");
        snd.click();

        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();
        Thread.sleep(10000);

        transNum=driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        System.out.println(transNum);
        testCase =20;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\Equip.WH" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }
    }

