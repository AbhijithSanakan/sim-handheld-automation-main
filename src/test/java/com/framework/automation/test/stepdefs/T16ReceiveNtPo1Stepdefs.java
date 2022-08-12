package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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

public class T16ReceiveNtPo1Stepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=16;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    @Given("User Verify Login and Going To Loading Supplier Screen")
    public void user_Verify_Login_and_Going_To_Loading_Supplier_Screen() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click();
        Thread.sleep(7000);

        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);

        MobileElement ReIn  = (MobileElement) driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton");
        ReIn.click();
        Thread.sleep(10000);

        MobileElement DrDo  = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        DrDo.click();

        MobileElement Selectsup  = (MobileElement) driver.findElementById("com.sof.retail:id/tvCurrentCount");
        Selectsup.click();

        //Need to change Invoice number in every Single Runtime
        testCase =16;
        keys = "Invoice";
        driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).sendKeys("12355");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);

//        MobileElement Nxt1  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
//        Nxt1.click();
//        Thread.sleep(10000);




    }

    @Then("User Check Able to Edit Delivery Info Page")
    public void User_Check_Able_to_Edit_Delivery_Info_Page() throws InterruptedException {

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]").getText();
        expectedText = "Choose Delivery / Truck Type";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]").getText();
        expectedText = "Choose Destination";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicePieceCountTextView").getText();
        expectedText = "Inv. Piece Count";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicedQuantitiesCheckBox").getText();
        expectedText = "Base total on inv. qty.";TestAsserts.assertCheck(actualText,expectedText);



        driver.findElement(By.id("com.sof.retail:id/dsdDeliveryInvoicePieceCountEditText")).sendKeys("5");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        System.out.println("Test Done Delivery Info");

        Thread.sleep(10000);


//        MobileElement Nxtb2  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button");
//        Nxtb2.click();









    }

    @Then("User Verify all in Record Temperatures Page")
    public void User_Verify_all_in_Record_Temperatures_Page() {
//        boolean commodity = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]").isDisplayed();
//        System.out.println("The commodity status is" + commodity);
//
//        boolean Min = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[2]").isDisplayed();
//        System.out.println("The Min status is" + Min);
//
//        boolean Max = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[3]").isDisplayed();
//        System.out.println("The Max status is" + Max);
//
//        boolean c = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[4]").isDisplayed();
//        System.out.println("The C status is" + c);
//
//        boolean butStatus = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus);
//        //to verify enter in the "'C" text box which we want to mention the Deli/dairy 'C-Record Temperatures
//        MobileElement Cbox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox.clear();
//        Cbox.sendKeys("5");
//        //to verify if a +,- button is enabled with is Eggs()
//        boolean butStatus1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[4]").isEnabled();
//        System.out.println("The button status is" + butStatus1);
//        //to verify enter in the "'C" text box which we want to mention the Eggs 'C-Record Temperatures
//        MobileElement Cbox1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText");
//        Cbox1.clear();
//        Cbox1.sendKeys("5");

        MobileElement Nxt3  = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt3.click();

    }

    @When("Check Product able to Add In Scan Items Page")
    public void Check_Product_able_to_Add_In_Scan_Items_Page() throws InterruptedException {
        Actions actio = new Actions(driver);
        String scan = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView")).getText();
        Assert.assertEquals(scan, "Scan Items");
        System.out.println(scan + " is visible");

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView").getText();
        expectedText = "UPC";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        expectedText = "UOM";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]").getText();
        expectedText = "Description";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementById("com.sof.retail:id/recvText").getText();
        expectedText = "Recv.";TestAsserts.assertCheck(actualText,expectedText);



        testCase =16;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);
        upc.clear();

        testCase =16;
        keys = "UPC 2";
        upc.click();
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
        upc.clear();

        ///com.sof.retail:id/recvValue
        driver.findElement(By.id("com.sof.retail:id/invValue")).sendKeys("3");
        actio.sendKeys(Keys.ENTER).perform();

        driver.findElement(By.id("com.sof.retail:id/recvValue")).click();
        actio.sendKeys(Keys.DELETE).perform();

        driver.findElement(By.id("com.sof.retail:id/recvValue")).sendKeys("4");
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);

        MobileElement Nxt4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt4.click();

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "VARIANCES FOUND";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement Nxtok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Nxtok.click();

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Confirm Invoice Quantities";TestAsserts.assertCheck(actualText,expectedText);



        MobileElement Nxt5 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt5.click();Thread.sleep(5000);







    }

    @When("User Verify in DSD Delivery Page")
    public void User_Verify_in_DSD_Delivery_Page() throws InterruptedException {
        testCase =16;
        keys = "Grand Total";
        driver.findElement(By.id("com.sof.retail:id/dsdDeliveryGrandTotalEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));


//        MobileElement grandtol = driver.findElementById("com.sof.retail:id/dsdDeliveryGrandTotalEditText");
//        grandtol.click();
//        grandtol.sendKeys("2202");

        testCase =16;
        keys = "Gst";
        driver.findElement(By.id("com.sof.retail:id/dsdDeliveryGSTEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

//        MobileElement Gst = driver.findElementById("com.sof.retail:id/dsdDeliveryGSTEditText");
//        Gst.click();
//        Gst.sendKeys("220");

        MobileElement Chrgtyp = driver.findElementById("com.sof.retail:id/chargeTypeDropDownImg");
        Chrgtyp.click();
        Thread.sleep(5000);

        MobileElement ch = driver.findElementById("com.sof.retail:id/dsdDeliveryDepartmentSpinner");
        ch.click();

//        testCase =16;
//        keys = "Gst";
//        driver.findElement(By.id("com.sof.retail:id/dsdDeliveryChargeAmountEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        MobileElement chrgamt = driver.findElementById("com.sof.retail:id/dsdDeliveryChargeAmountEditText");
        chrgamt.click();
        chrgamt.sendKeys("2222");

        MobileElement dep = driver.findElementById("com.sof.retail:id/DepartmentDropDownImg");
        dep.click();

        MobileElement Dp = driver.findElementById("com.sof.retail:id/dsdDeliveryChargeAmountEditText");
        Dp.click();

        MobileElement dri = driver.findElementById("com.sof.retail:id/dsdDeliveryDriverNotPresentCheckBox");
        dri.click();

        MobileElement Nextbtn3 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn3.click();Thread.sleep(5000);

        System.out.println("Test Done in DSD Delivery page");
    }

    @Then("Verify Summary Page and Submit")
    public void Verify_Summary_Page_and_Submit() throws InterruptedException, IOException {
        driver.findElement(By.id("com.sof.retail:id/etComment")).sendKeys("Receive");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement Nextbtn4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nextbtn4.click();

        System.out.println("Test Done in Comments page");

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
        expectedText = "Supplier";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
        expectedText = "Invoice / PO #";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
        expectedText = "Received Into";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[1]").getText();
        expectedText = "Grand Total";TestAsserts.assertCheck(actualText,expectedText);

//        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.TextView[1]").getText();
//        expectedText = "GST";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/descpTextView").getText();
        expectedText = "Description";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/qtyTextView").getText();
        expectedText = "Qty";TestAsserts.assertCheck(actualText,expectedText);



        System.out.println("Test Done in Summery page");

        MobileElement Send = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Send.click();

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
        expectedText = "VENDOR INFORMATION";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement okven = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okven.click();

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
        expectedText = "WARNING";TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(5000);


        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();
        Thread.sleep(10000);

        transNum=driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        System.out.println(transNum);
        testCase =16;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\NotPOCase1" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }

}
