package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
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

public class T20ReceivePickSupplierStepdefs {
    static AndroidDriver<AndroidElement> driver;

    static int testCase=20 ;
    static String keys =null;
    static String actualText;
    static String expectedText;

    @Given("User Login and Going To Loading Supplier Screen")
    public void User_Login_and_Going_To_Loading_Supplier_Screen() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);


        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click();
        Thread.sleep(5000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);

        MobileElement ReIn  = (MobileElement) driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton");
        ReIn.click();
        Thread.sleep(10000);

        String LAS = driver.findElement(By.id("com.sof.retail:id/loadSuppliersButton")).getText();
        Assert.assertEquals(LAS, "LOAD ALL SUPPLIERS");
        System.out.println(LAS + " is visible");

        String Invo = driver.findElement(By.id("com.sof.retail:id/invoiceLabelTextView")).getText();
        Assert.assertEquals(Invo, "Invoice #");
        System.out.println(Invo + " is visible");

        boolean Discard= driver.findElementById("com.sof.retail:id/discardIcon").isDisplayed();
        System.out.println(" Discard button visible is" + Discard);

        boolean next= driver.findElementById("com.sof.retail:id/buttonConfirm").isDisplayed();
        System.out.println(" Next button visible is" + next);
        Thread.sleep(10000);

//        MobileElement drdo  = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
//        drdo.click();
//
//        WebElement selectElement = driver.findElement(By.id("com.sof.retail:id/supplierSpinner"));
//        Select selectObject = new Select(selectElement);
//// Return a List<WebElement> of options that the <select> element contains
//        List<WebElement> allAvailableOptions = selectObject.getOptions();
//        System.out.println(allAvailableOptions);

        MobileElement LASup  = (MobileElement) driver.findElementById("com.sof.retail:id/loadSuppliersButton");
        LASup.click();
        Thread.sleep(7000);
        System.out.println(2);
//Verifying Pick Supplier Screen
        actualText = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button")).getText();
        expectedText = "ADD NEW SUPPLIER";
        TestAsserts.assertCheck(actualText,expectedText);


        Thread.sleep(10000);
        MobileElement ANSup  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button");
        ANSup.click();
        System.out.println("Test Done in LOADING SUPPLIER page");
//        MobileElement ANSP  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button");
//        ANSP.click();

        Thread.sleep(5000);


    }

    @Then("Verify Load All Suppliers Able to Add")
    public void Verify_Load_All_Suppliers_Able_to_Add() throws InterruptedException {
        String Provide = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
        Assert.assertEquals(Provide, "PROVIDE SUPPLIER");
        System.out.println(Provide + " is visible");
        Thread.sleep(5000);

//        String Note = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")).getText();
//        Assert.assertEquals(Note, "NOTE: New Supplier entries are audited to ensure they do not already exist. You are expected to choose a supplier from the provided list. If you can’t find it, circle the new supplier’s name and write “new supplier” on the invoice. Attach the invoice to your Summary Report and send to Treasury Services. Max 35 characters.");
//        System.out.println(Note + " is visible");

        String New = driver.findElement(By.id("com.sof.retail:id/newSupplierLabelTextView")).getText();
        Assert.assertEquals(New, "New Supplier Name");
        System.out.println(New + " is visible");

        String cancel = driver.findElement(By.id("com.sof.retail:id/negativeButton")).getText();
        Assert.assertEquals(cancel, "CANCEL");
        System.out.println(cancel + " is visible");

        String Next = driver.findElement(By.id("com.sof.retail:id/positiveButton")).getText();
        Assert.assertEquals(Next, "OK");
        System.out.println(Next + " is visible");

        MobileElement cancl  = (MobileElement) driver.findElementById("com.sof.retail:id/negativeButton");
        cancl.click();
        System.out.println("Test Done in PROVIDE SUPPLIER page");

        Thread.sleep(5000);

        MobileElement ANSup  = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button");
        ANSup.click();

//        MobileElement add  = (MobileElement) driver.findElementById("com.sof.retail:id/newSupplierEditText");
//        add.click();
//        add.sendKeys("asdt");
        testCase =20;
        keys = "Credit/Return#";
        driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));


     //   driver.findElement(By.id("com.sof.retail:id/newSupplierEditText")).sendKeys("asdt");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement Ok  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]");
//        Ok.click();


        System.out.println("Did you mean page");


    }

    @Then("Verify Able Add Pick Supplier")
    public void Verify_Able_Add_Pick_Supplier() throws InterruptedException {
        MobileElement usenew  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        usenew.click();

        MobileElement conf  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        conf.click();

        MobileElement invoiceno  = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceNumberEditText");
        invoiceno.click();

        testCase =20;
        keys = "Invoice";
        driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        System.out.println("Test Done in Pick Supplier");

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }


}
