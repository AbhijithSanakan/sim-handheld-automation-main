package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T33ReturnEquipEnterItemsStepdefs {
    static AndroidDriver<AndroidElement> driver;

    @Given("User From Dashboard to ReturnEquipment Page")
    public void user_From_Dashboard_to_ReturnEquipment_Page() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[5]/android.widget.FrameLayout/android.widget.ImageView");
        el1.click();
        Thread.sleep(5000); try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(15000);


        MobileElement Store = (MobileElement) driver.findElementById("com.sof.retail:id/storeRadioButton");
        Store.click();


        MobileElement carrierdrop = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.EditText"));
        carrierdrop.click();

        MobileElement carrierSel = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.RadioGroup/android.widget.RadioButton[2]"));
        carrierSel.click();
        Thread.sleep(3000);

        MobileElement Truck = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.CheckBox"));
        Truck.click();

        MobileElement dropStr = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.EditText"));
        dropStr.click();
        Thread.sleep(3000);

        MobileElement strdpdw = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]"));
        strdpdw.click();

        MobileElement drop = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]"));
        drop.click();
        Thread.sleep(3000);

        MobileElement botl = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.EditText");
        botl.click();
        Thread.sleep(10000);

        MobileElement next1 = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        next1.click();
        Thread.sleep(10000);


    }

    @Then("Setup in the ReturnEquipment Page")
    public void setup_in_the_ReturnEquipment_Page() {
        String EnterItems = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        Assert.assertEquals(EnterItems, "Enter Items");
        System.out.println(EnterItems + " is visible");

        String Make = driver.findElement(By.id("com.sof.retail:id/makeHintText")).getText();
        Assert.assertEquals(Make, "Make");
        System.out.println(Make + " is visible");

        String ItemID = driver.findElement(By.id("com.sof.retail:id/textItemID")).getText();
        Assert.assertEquals(ItemID, "Item ID");
        System.out.println(ItemID + " is visible");

        String SN = driver.findElement(By.id("com.sof.retail:id/serialNumberHintText")).getText();
        Assert.assertEquals(SN, "S/N");
        System.out.println(SN + " is visible");

        String required = driver.findElement(By.id("com.sof.retail:id/textSerialNumberHolder")).getText();
        Assert.assertEquals(required, "S/Ns required if worth > $1,000");
        System.out.println(required + " is visible");

        String SLNO = driver.findElement(By.id("com.sof.retail:id/buttonRequiresSerialNumber")).getText();
        Assert.assertEquals(SLNO, "REQUIRES SERIAL NUMBERS");
        System.out.println(SLNO + " is visible");

        String DLT = driver.findElement(By.id("com.sof.retail:id/buttonDelete")).getText();
        Assert.assertEquals(DLT, "DELETE");
        System.out.println(DLT + " is visible");

        String Descr = driver.findElement(By.id("com.sof.retail:id/descriptionTextHolder")).getText();
        Assert.assertEquals(Descr, "Description");
        System.out.println(Descr + " is visible");

        String Returns = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]")).getText();
        Assert.assertEquals(Returns, "Return");
        System.out.println(Returns + " is visible");

        boolean back = driver.findElementById("com.sof.retail:id/button").isDisplayed();
        System.out.println("The keyboard button is" + back);

        boolean next = driver.findElementById("com.sof.retail:id/button3").isDisplayed();
        System.out.println("The keyboard button is" + next);

        boolean Keybrd = driver.findElementById("com.sof.retail:id/imageKeyboard").isDisplayed();
        System.out.println("The keyboard button is" + Keybrd);

        boolean Discard = driver.findElementById("com.sof.retail:id/discardIcon").isDisplayed();
        System.out.println("The keyboard button is" + Discard);


    }

    @Then("Verify in Some Sections are  in EnterItems Page")
    public void verify_in_Some_Sections_are_in_EnterItems_Page() throws InterruptedException {
        driver.findElement(By.id("com.sof.retail:id/editTextItemID")).sendKeys("6411");
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);

        boolean ReqSLNu = driver.findElementById("com.sof.retail:id/buttonRequiresSerialNumber").isEnabled();
        System.out.println(" Populated Items visible is" + ReqSLNu);

        MobileElement Rtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.EditText");
        Rtn.click();
        Rtn.sendKeys("0");
        Actions aci = new Actions(driver);
        aci.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        MobileElement NxT = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        NxT.click();

        String UTP = driver.findElement(By.id("com.sof.retail:id/dialog_message")).getText();
        Assert.assertEquals(UTP, "You have not counted any items yet!");
        System.out.println(UTP + " is visible");

        MobileElement ok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        ok.click();

        MobileElement Rtn1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.EditText");
        Rtn1.click();
        Rtn.sendKeys("10");
        Actions aci1 = new Actions(driver);
        aci1.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

    }

    @Then("User is Verify Able to in items Page")
    public void user_is_Verify_Able_to_in_items_Page() throws InterruptedException {
        MobileElement RSN = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button[1]");
        RSN.click();

        boolean SNnotRequired = driver.findElementById("com.sof.retail:id/buttonRequiresSerialNumber").isDisplayed();
        System.out.println("The keyboard button is" + SNnotRequired);

        MobileElement SNl = (MobileElement) driver.findElementById("com.sof.retail:id/textSerialNumber");
        SNl.click();
        SNl.sendKeys("1111");

        MobileElement SNArrowR = (MobileElement) driver.findElementById("com.sof.retail:id/imageNext");
        SNArrowR.click();

        MobileElement SN2 = (MobileElement) driver.findElementById("com.sof.retail:id/textSerialNumber");
        SN2.click();
        SNl.sendKeys("2222");

        MobileElement SNArrowL = (MobileElement) driver.findElementById("com.sof.retail:id/imagePrevious");
        SNArrowL.click();

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(318, 467))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(133, 467)).release().perform();
        Thread.sleep(10000);
        MobileElement Dlt = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView");
        Dlt.click();

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }
}
