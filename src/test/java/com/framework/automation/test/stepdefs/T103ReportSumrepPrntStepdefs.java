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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T103ReportSumrepPrntStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=103;
    static String actualText;
    static String expectedText;


    @Given("User Verify Login and Reach To Select Hamburger Icon")
    public void user_Verify_Login_and_Reach_To_Select_Hamburger_Icon() throws IOException, InterruptedException {

        System.out.println("Logging in");
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);

        //Click Order DD
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
        el1.click();Thread.sleep(5000);


        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[6]");
        el2.click();Thread.sleep(5000);


        MobileElement el3 = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerTextView");
        el3.click();

        MobileElement TrnsSumr = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[7]");
        TrnsSumr.click();


    }

    @Then("User Check Verify in Report and select Summary")
    public void user_Check_Verify_in_Report_and_select_Summary() throws InterruptedException {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Print and email reports']").getText();
        expectedText = "Print and email reports";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Department']").getText();
        expectedText = "Department";TestAsserts.assertCheck(actualText,expectedText);

        boolean DeptField = driver.findElementById("com.sof.retail:id/spSelection").isDisplayed();
        System.out.println("The  Department Field status is" + DeptField);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='From']").getText();
        expectedText = "From";TestAsserts.assertCheck(actualText,expectedText);

        boolean Fromfield = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView").isDisplayed();
        System.out.println("The Fromfield status is" + Fromfield);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='To']").getText();
        expectedText = "To";TestAsserts.assertCheck(actualText,expectedText);

        boolean ToField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView").isDisplayed();
        System.out.println("The  ToField Field status is" + ToField);

        boolean nxt = driver.findElementById("com.sof.retail:id/button").isDisplayed();
        System.out.println("The  Next Field status is" + nxt);

        MobileElement DepartDD = (MobileElement) driver.findElementById("com.sof.retail:id/spSelection");
        DepartDD.click();

        MobileElement DepartDDChs = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        DepartDDChs.click();
        // driver.hideKeyboard();

    }


    @Then("User Verify all in Report Date")
    public void user_Verify_all_in_Report_Date() throws IOException, InterruptedException {

        MobileElement DepartDDChs = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
        DepartDDChs.click();

        MobileElement FromDate = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"30 August 2022\"]");
        FromDate.click();

        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName="D:\\SOF-automation\\IMAF-main\\Deviations\\T103-Steps4" +".jpg";
        FileUtils.copyFile(file,new File(fileName));

        driver.findElementById("android:id/button1").click();

        boolean FromField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView").isDisplayed();
        System.out.println("The  FromField Field status is" + FromField);


        MobileElement DepartDDto = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
        DepartDDto.click();

        MobileElement ToDate = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"30 August 2022\"]");
        ToDate.click();

        File file1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName1="D:\\SOF-automation\\IMAF-main\\Deviations\\T103-Steps7" +".jpg";
        FileUtils.copyFile(file1,new File(fileName1));

        driver.findElementById("android:id/button1").click();

        MobileElement Fromdate2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
        Fromdate2.click();

        MobileElement FromDat = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"20 August 2022\"]");
        FromDat.click();

        driver.findElementById("android:id/button1").click();

        boolean ToField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView").isDisplayed();
        System.out.println("The  ToField Field status is" + ToField);

        MobileElement Next = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Next.click();
        Thread.sleep(9000);
    }

    @When("Click on Discard Button back to Dash bord Click")
    public void click_on_Discard_Button_back_to_Dash_bord_Click() throws InterruptedException, IOException {

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Print Transfer Summary']").getText();
        expectedText = "Print Transfer Summary";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Printer']").getText();
        expectedText = "Printer";TestAsserts.assertCheck(actualText,expectedText);

        boolean PrintField = driver.findElementById("com.sof.retail:id/tvCategory").isDisplayed();
        System.out.println("The  Printer Field status is" + PrintField);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='# of Copies']").getText();
        expectedText = "# of Copies";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Email']").getText();
        expectedText = "Email";TestAsserts.assertCheck(actualText,expectedText);


//        boolean Fromfield = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView").isDisplayed();
//        System.out.println("The Fromfield status is" + Fromfield);
//
//        actualText = driver.findElementByXPath("//android.widget.TextView[@text='To']").getText();
//        expectedText = "To";TestAsserts.assertCheck(actualText,expectedText);

        boolean EmailField = driver.findElementById("com.sof.retail:id/email").isDisplayed();
        System.out.println("The  Email Field status is" + EmailField);

        boolean Printredio = driver.findElementById("com.sof.retail:id/printerButton").isDisplayed();
        System.out.println("The  Printredio Field status is" + Printredio);

        boolean EmailRedio = driver.findElementById("com.sof.retail:id/emailButton").isDisplayed();
        System.out.println("The  EmailRedio Field status is" + EmailRedio);

//        driver.findElementById("com.sof.retail:id/button").click();
//        Thread.sleep(9000);
//
//        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Reports']").getText();
//        expectedText = "Reports";TestAsserts.assertCheck(actualText,expectedText);
//
//        driver.findElementById("android:id/button1").click();Thread.sleep(9000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Print Transfer Summary']").getText();
        expectedText = "Print Transfer Summary";TestAsserts.assertCheck(actualText,expectedText);

        driver.findElementById("com.sof.retail:id/printerButton").click();

        driver.findElementById("com.sof.retail:id/tvCategory").click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView").click();

        driver.findElementById("com.sof.retail:id/copiesValue").sendKeys("5");

        driver.findElementById("com.sof.retail:id/button3").click();


        driver.findElementById("com.sof.retail:id/positiveButton").click();
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
       }


}
