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

public class T18ReceiveNoCodeStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=18;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    @Given("User Verify Login and Going To Loading Supplier")
    public void user_Verify_Login_and_Going_To_Loading_Supplier() throws InterruptedException, IOException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[1]");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[1]/android.widget.TextView");
        el3.click();
        try{MobileElement Restore  = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
            Restore.click();}
        catch (Exception e){System.out.println("No Restore popup");}
        Thread.sleep(10000);
//        Thread.sleep(7000);
        MobileElement ReIn = (MobileElement) driver.findElementById("com.sof.retail:id/selectInvoiceorPoNotAvailableButton");
        ReIn.click();
        Thread.sleep(10000);

        MobileElement DrDo = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        DrDo.click();

        MobileElement Selectsup = (MobileElement) driver.findElementById("com.sof.retail:id/invoiceLabelTextView");
        Selectsup.click();

        //Need to change Invoice number in every Single Runtime
        testCase =18;
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

    @Then("Check Able to Edit Delivery Info Page")
    public void check_Able_to_Edit_Delivery_Info_Page() throws InterruptedException {

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]").getText();
        expectedText = "Choose Delivery / Truck Type";TestAsserts.assertCheck(actualText,expectedText);

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

    @Then("User Verify  in Record Temperatures Page")
    public void user_Verify_in_Record_Temperatures_Page() {
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

    @When("Check Product able to Add In different Scan Items Page")
    public void check_Product_able_to_Add_In_different_Scan_Items_Page() throws InterruptedException {

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView").getText();
        expectedText = "Scan Items";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView").getText();
        expectedText = "UPC";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        expectedText = "UOM";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]").getText();
        expectedText = "Description";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/recvText").getText();
        expectedText = "Recv.";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement barcd = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
        barcd.click();

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]").getText();
        expectedText = "CAN’T SCAN";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement Cncl = (MobileElement) driver.findElementById("com.sof.retail:id/dialogCancelButton");
        Cncl.click();

        MobileElement Barcd = (MobileElement) driver.findElementById("com.sof.retail:id/imageButton");
        Barcd.click();

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]").getText();
        expectedText = "CAN’T SCAN";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement Cnle = (MobileElement) driver.findElementById("com.sof.retail:id/dialogCancelButton");
        Cnle.click();

        testCase =18;
        keys = "UPC 1";
        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

        //driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys("1");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        actualText = driver.findElementById("com.sof.retail:id/enterItemInfoDialogTitleTextView").getText();
        expectedText = "ENTER ITEM INFORMATION";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement drp = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        drp.click();

        MobileElement dept = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogEditText");
        dept.click();

        driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogEditText")).sendKeys("1111");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(10000);

//        MobileElement clkok = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogOkButton");
//        clkok.click();

        testCase =18;
        keys = "UPC 2";
        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

//        driver.findElement(By.id("com.sof.retail:id/upcScanText")).click();
//        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys("2");
        Actions actio = new Actions(driver);
        actio.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);
        System.out.println("0");


//        MobileElement drpd = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
//        drpd.click();
//        System.out.println("1");
//        MobileElement deptna = (MobileElement) driver.findElementById("com.sof.retail:id/enterItemInfoDialogTitleTextView");
//        deptna.click();
//        System.out.println("2");
//        driver.findElement(By.id("com.sof.retail:id/enterItemInfoDialogEditText")).sendKeys("1111");
//        Actions acti = new Actions(driver);
//        acti.sendKeys(Keys.ENTER).perform();



        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.EditText[1]")).click();
        Actions act = new Actions(driver);
        act.sendKeys(Keys.DELETE).perform();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.EditText[1]")).sendKeys("4");
        act.sendKeys(Keys.ENTER).perform();

        MobileElement Nxt4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt4.click();
        Thread.sleep(10000);

    }

    @When("User Verify in DSD Delivery Page Screen")
    public void user_Verify_in_DSD_Delivery_Page_Screen() throws InterruptedException {

        testCase =18;
        keys = "Grand Total";
        driver.findElement(By.id("com.sof.retail:id/dsdDeliveryGrandTotalEditText")).sendKeys(ExcelHandle.ExcelFunction(testCase,keys));

//        MobileElement grandtol = driver.findElementById("com.sof.retail:id/dsdDeliveryGrandTotalEditText");
//        grandtol.click();
//        grandtol.sendKeys("2202");

        testCase =18;
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

    @Then("User Verify Summary Page and Submit")
    public void user_Verify_Summary_Page_and_Submit() throws InterruptedException, IOException {
        driver.findElement(By.id("com.sof.retail:id/etComment")).sendKeys("Receive");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

//        MobileElement Nextbtn4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
//        Nextbtn4.click();

        System.out.println("Test Done in Summary page");

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
        expectedText = "Supplier";TestAsserts.assertCheck(actualText,expectedText);
        System.out.println("Test");
        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
        expectedText = "Invoice / PO #";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]").getText();
        expectedText = "Received Into";TestAsserts.assertCheck(actualText,expectedText);


        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[1]").getText();
        expectedText = "Grand Total";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.TextView[1]").getText();
        expectedText = "GST";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/descpTextView").getText();
        expectedText = "Description";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/qtyTextView").getText();
        expectedText = "Qty";TestAsserts.assertCheck(actualText,expectedText);


        System.out.println("Test Done in Summery page");

        MobileElement Send = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Send.click();
        Thread.sleep(4000);

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
        expectedText = "VENDOR INFORMATION";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement okven = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        okven.click();

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
        expectedText = "WARNING";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        warok.click();
        Thread.sleep(10000);

        transNum=driver.findElement(By.id("com.sof.retail:id/descpCountText")).getText();
        System.out.println(transNum);
        testCase =18;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\NotCode" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }


}
