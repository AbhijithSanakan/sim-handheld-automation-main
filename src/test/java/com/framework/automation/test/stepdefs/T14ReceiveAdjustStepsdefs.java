package com.framework.automation.test.stepdefs;

import com.framework.automation.utils.ExcelHandle;
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

public class T14ReceiveAdjustStepsdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=14;
    static String keys =null;
    static String transNum;
    static String actualText;
    static String expectedText;
    @Given("User is Reach Dashboard and Select Receive Invoice Enter in Adjust")
    public void user_is_Reach_Dashboard_and_Select_Receive_Invoice_Enter_in_Adjust() throws IOException, InterruptedException, MalformedURLException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        System.out.println("Reached in Login Page");
try{
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


        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.CheckBox");
        el4.click();
        System.out.println("Reached in Select Invoice Page");

        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView");
        el5.click();
        Thread.sleep(5000);

        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(402, 122))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(402, 663)).release().perform();
        MobileElement day2 =(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        day2.click();



        MobileElement el6 =(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        el6.click();

    actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]").getText();
    expectedText = "Choose Delivery / Truck Type";
    TestAsserts.assertCheck(actualText,expectedText);

    actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]").getText();
    expectedText = "Choose Destination";
    TestAsserts.assertCheck(actualText,expectedText);

    actualText = driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicePieceCountTextView").getText();
    expectedText = "Inv. Piece Count";
    TestAsserts.assertCheck(actualText,expectedText);

    actualText = driver.findElementById("com.sof.retail:id/dsdDeliveryInvoicedQuantitiesCheckBox").getText();
    expectedText = "Base total on inv. qty.";
    TestAsserts.assertCheck(actualText,expectedText);



        MobileElement Nxtb2  = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button");
        Nxtb2.click();
        System.out.println("Test Completed in Delivery Info Page");
        Thread.sleep(9000);}
catch (Exception e){
    System.out.println("Receive invoice not available");
}
    }

    @Then("User is Verify the Temperature Page")
    public void user_is_Verify_the_Temperature_Page() throws InterruptedException {
        try {
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

            MobileElement Nxt3 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
            Nxt3.click();
            System.out.println("Test Completed in Temperatures  Page");
        }
        catch (Exception e){
            System.out.println("Receive invoice not available");
        }Thread.sleep(10000);
    }

    @When("User is Verify Scan Items in Scan Page")
    public void user_is_Verify_Scan_Items_in_Scan_Page() throws InterruptedException {

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

        Thread.sleep(10000);
        testCase =14;
        keys = "UPC 1";
        MobileElement upc = (MobileElement) driver.findElement(By.id("com.sof.retail:id/upcScanText"));
        upc.sendKeys(ExcelHandle.ExcelFunction(testCase,keys));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        upc.clear();
//        driver.findElement(By.id("com.sof.retail:id/upcScanText")).sendKeys("122");
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        driver.findElement(By.id("com.sof.retail:id/recvValue")).click();
        Actions acti = new Actions(driver);
        acti.sendKeys(Keys.DELETE).perform();

        driver.findElement(By.id("com.sof.retail:id/recvValue")).sendKeys("80");
        acti.sendKeys(Keys.ENTER).perform();
        Thread.sleep(9000);

        MobileElement Nxt4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt4.click();

        actualText = driver.findElementById("com.sof.retail:id/dialog_title").getText();
        expectedText = "VARIANCES FOUND";
        TestAsserts.assertCheck(actualText,expectedText);


        MobileElement Nxtok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        Nxtok.click();

        actualText = driver.findElementById("com.sof.retail:id/toolBarHeader").getText();
        expectedText = "Confirm Invoice Quantities";TestAsserts.assertCheck(actualText,expectedText);


        MobileElement Nxt5 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nxt5.click();
        Thread.sleep(5000);
        System.out.println("Test Completed in Items Scan  Page");
    }

    @When("User Enter is Grand Total With GST in DSD Delivery Page")
    public void user_Enter_is_Grand_Total_With_GST_in_DSD_Delivery_Page() {

        MobileElement warok = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        warok.click();

        MobileElement dep = driver.findElementById("com.sof.retail:id/DepartmentDropDownImg");
        dep.click();

        MobileElement Dp = driver.findElementById("com.sof.retail:id/dsdDeliveryGSTTextView");
        Dp.click();


        MobileElement Nextbtn3 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn3.click();

        System.out.println("Test Done in DSD Delivery page");
    }

    @Then("User is Verify Summary page")
    public void user_is_Verify_Summary_page() throws InterruptedException, IOException {

        MobileElement Nextbtn4 = (MobileElement) driver.findElementById("com.sof.retail:id/button3");
        Nextbtn4.click();


        System.out.println("Test Done in Comments page");

        actualText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
        expectedText = "Supplier";TestAsserts.assertCheck(actualText,expectedText);

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

        transNum=driver.findElementById("com.sof.retail:id/descpCountText").getText();


        testCase =14;
        keys = "Transaction Number";
        ExcelHandle.ExcelWriteFunction(testCase,keys,transNum);
        Thread.sleep(2000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\ScreenShots\\T14-Adjust" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();

    }

}
