package com.framework.automation.test.stepdefs;

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

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T111ReportPeriendInveStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=111;
    static String actualText;
    static String expectedText;


    @Given("Verify User Going to Login and Reach To Click in Hamburger Icon")
    public void verify_User_Going_to_Login_and_Reach_To_Click_in_Hamburger_Icon() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
        el1.click();
        Thread.sleep(5000);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(201, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(203, 215)).release().perform();
        Thread.sleep(5000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[6]");
        el2.click();
        Thread.sleep(5000);

        MobileElement el3 = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerTextView");
        el3.click();

        MobileElement PeriEndInvent = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
        PeriEndInvent.click();
    }

    @Then("User Check and Verify in Report and Select Period End Inventory")
    public void user_Check_and_Verify_in_Report_and_Select_Period_End_Inventory() {
        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Print and email reports']").getText();
        expectedText = "Print and email reports";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Department']").getText();
        expectedText = "Department";TestAsserts.assertCheck(actualText,expectedText);

        boolean DeptField = driver.findElementById("com.sof.retail:id/spSelection").isDisplayed();
        System.out.println("The  Department Field status is" + DeptField);

        boolean nxt = driver.findElementById("com.sof.retail:id/button").isDisplayed();
        System.out.println("The  Next Field status is" + nxt);

        MobileElement DepartDD = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        DepartDD.click();

        MobileElement DepartDDChs = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]");
        DepartDDChs.click();
        // driver.hideKeyboard();
    }

    @Then("User Verify all in Report page")
    public void user_Verify_all_in_Report_page() throws InterruptedException {
        MobileElement Next = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Next.click();
        Thread.sleep(9000);
        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Print Period End Inventory Summary']").getText();
        expectedText = "Print Period End Inventory Summary";TestAsserts.assertCheck(actualText,expectedText);

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

        driver.findElementById("com.sof.retail:id/button").click();
        Thread.sleep(9000);

        actualText = driver.findElementByXPath("//android.widget.TextView[@text='Reports']").getText();
        expectedText = "Reports";TestAsserts.assertCheck(actualText,expectedText);

        MobileElement el3 = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerTextView");
        el3.click();

        MobileElement PeriEndInvent = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
        PeriEndInvent.click();

        MobileElement DepartDD = (MobileElement) driver.findElementById("com.sof.retail:id/dropDownImg");
        DepartDD.click();

        MobileElement DepartDDChs = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]");
        DepartDDChs.click();

        MobileElement Nex = (MobileElement) driver.findElementById("com.sof.retail:id/button");
        Nex.click();
        Thread.sleep(9000);
    }

    @When("Click Print Period End Inventory  Page for Send Report")
    public void click_Print_Period_End_Inventory_Page_for_Send_Report() throws InterruptedException {
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
