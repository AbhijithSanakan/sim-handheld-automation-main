package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
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

public class T17ReceiveNtPo2Stepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=16;
    static String keys =null;
    static String transNum;


    @Given("User is Verify Login and Going To Loading Supplier Screen")
    public void user_is_Verify_Login_and_Going_To_Loading_Supplier_Screen() throws InterruptedException, IOException {
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


        MobileElement ReIn = (MobileElement) driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton");
        ReIn.click();
        Thread.sleep(10000);

        MobileElement DrDo = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        DrDo.click();

        MobileElement Selectsup = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceLabelTextView");
        Selectsup.click();

        //Need to change Invoice number in every Single Runtime
        testCase =17;
        keys = "Invoice";
        driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));


        //driver.findElement(By.id("com.sof.retail:id/invoiceNumberEditText")).sendKeys("1234");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement Nxt1  = (MobileElement) driver.findElementById("com.sof.retail:id/buttonConfirm");
//        Nxt1.click();
        Thread.sleep(10000);


    }

    @Then("User is Check Able to Edit Delivery Info Page")
    public void user_is_Check_Able_to_Edit_Delivery_Info_Page() throws InterruptedException {
        String ChDTruck = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        Assert.assertEquals(ChDTruck, "Choose Delivery / Truck Type");
        System.out.println(ChDTruck + " is visible");

        String ChosDes = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        Assert.assertEquals(ChosDes, "Choose Destination");
        System.out.println(ChosDes + " is visible");

        MobileElement Supply = (MobileElement) driver.findElementById("com.sof.retail:id/deliveryInfoSupplyRadioButton");
        Supply.click();



        MobileElement Nxtb2  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button");
        Nxtb2.click();


        Thread.sleep(5000);

    }



    @When("Check if Product able to Add In Scan Items Page")
    public void check_if_Product_able_to_Add_In_Scan_Items_Page() throws InterruptedException {
//        String scan = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView")).getText();
//        Assert.assertEquals(scan, "Scan Items");
//        System.out.println(scan + " is visible");
//
//        String UPC = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
//        Assert.assertEquals(UPC, "UPC");
//        System.out.println(UPC + " is visible");
//
//
//        String UOM = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
//        Assert.assertEquals(UOM, "UOM");
//        System.out.println(UOM + " is visible");
//
//        String Des = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")).getText();
//        Assert.assertEquals(Des, "Description");
//        System.out.println(Des + " is visible");
//
//        String Rec = driver.findElement(By.id("com.sof.retail:id/recvText")).getText();
//        Assert.assertEquals(Rec, "Recv.");
//        System.out.println(Rec + " is visible");
//
//        testCase =17;
//        keys = "UPC 1";
//        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.ENTER).perform();
//        driver.findElement(By.id("com.sof.retail:id/upcScanText")).click();
//        action.sendKeys(Keys.DELETE).perform();
////        action.sendKeys(Keys.BACK_SPACE).perform();
////        action.sendKeys(Keys.BACK_SPACE).perform();
////        action.sendKeys(Keys.BACK_SPACE).perform();
//        Thread.sleep(9000);
//
//        testCase =17;
//        keys = "UPC 2";
//        upc.click();
//        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(5000);
//        upc.clear();
//
//        ///com.sof.retail:id/recvValue
//        driver.findElement(By.id("com.sof.retail:id/invValue")).sendKeys("3");
//        action.sendKeys(Keys.ENTER).perform();
//
//        driver.findElement(By.id("com.sof.retail:id/recvValue")).click();
//        action.sendKeys(Keys.DELETE).perform();
//
//        driver.findElement(By.id("com.sof.retail:id/recvValue")).sendKeys("4");
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(9000);
//
//        MobileElement Nxt4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nxt4.click();
//
//        String vf = driver.findElement(By.id("com.sof.retail:id/dialog_title")).getText();
//        Assert.assertEquals(vf, "VARIANCES FOUND");
//        System.out.println(vf + " is visible");
//
//        MobileElement Nxtok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
//        Nxtok.click();
//
//        String ciq = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
//        Assert.assertEquals(ciq, "Confirm Invoice Quantities");
//        System.out.println(ciq + " is visible");
//
//        MobileElement Nxt5 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nxt5.click();

    }

    @When("User is Verify in DSD Delivery Page")
    public void user_is_Verify_in_DSD_Delivery_Page() throws InterruptedException {

        testCase =17;
        keys = "Grand Total";
        driver.findElement(By.id("com.sof.retail:id/dsdDeliveryGrandTotalEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));


//        MobileElement grandtol = driver.findElementById("com.sof.retail:id/dsdDeliveryGrandTotalEditText");
//        grandtol.click();
//        grandtol.sendKeys("2202");

        testCase =17;
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
        Nextbtn3.click();

        System.out.println("Test Done in DSD Delivery page");
    }


    @Then("Verify is Summary Page and Submit")
    public void verify_is_Summary_Page_and_Submit() throws InterruptedException, IOException {
        driver.findElement(By.id("com.sof.retail:id/etComment")).sendKeys("Receive");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement Nextbtn4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nextbtn4.click();

        System.out.println("Test Done in Comments page");

        String sum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum, "Supplier");
        System.out.println(sum + " is visible");

        String sum1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum1, "Invoice / PO #");
        System.out.println(sum1 + " is visible");

        String sum2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum2, "Received Into");
        System.out.println(sum2 + "  is visible");

        String sum3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum3, "Grand Total");
        System.out.println(sum3 + "  is visible");

        String sum4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.TextView[1]")).getText();
        Assert.assertEquals(sum4, "GST");
        System.out.println(sum4 + " is visible");

        String sum5 = driver.findElement(By.id("com.sof.retail:id/descpTextView")).getText();
        Assert.assertEquals(sum5, "Description");
        System.out.println(sum5 + " is visible");

        String sum6 = driver.findElement(By.id("com.sof.retail:id/qtyTextView")).getText();
        Assert.assertEquals(sum6, "Qty");
        System.out.println(sum6 + " is visible");

        System.out.println("Test Done in Summery page");

        MobileElement Send = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Send.click();
        Thread.sleep(4000);

        String VENINF = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
        Assert.assertEquals(VENINF, "VENDOR INFORMATION");
        System.out.println(VENINF + "Qty is visible");

        MobileElement okven = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okven.click();

        String WARNG = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
        Assert.assertEquals(WARNG, "WARNING");
        System.out.println(WARNG + "Qty is visible");

        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();

        Thread.sleep(10000);

        transNum=driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        System.out.println(transNum);
        testCase =17;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\NotPOCase2" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
//    }

    }
}