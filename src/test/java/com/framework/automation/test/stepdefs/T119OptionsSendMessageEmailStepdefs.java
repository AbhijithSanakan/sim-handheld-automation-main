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

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class T119OptionsSendMessageEmailStepdefs {

    static AndroidDriver<AndroidElement> driver;
    static int testCase=119;
    static String actualText;
    static String expectedText;


    @Given("User Verify Login and Going Options Menu")
    public void user_Verify_Login_and_Going_Options_Menu() throws IOException, InterruptedException {
        System.out.println("Admin");
        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();Thread.sleep(5000);


        driver.findElementById("com.sof.retail:id/nav_send_msg").click();Thread.sleep(9000);
    }

    @Then("User Click in Send Button and Check in Send")
    public void user_Click_in_Send_Button_and_Check_in_Send() throws InterruptedException {

        driver.findElementById("com.sof.retail:id/textTO").click();Thread.sleep(5000);

        boolean AddAnotherAdress = driver.findElementById("com.sof.retail:id/addButton").isDisplayed();
        System.out.println("The  AddAnotherAdress Field status is" + AddAnotherAdress);

        actualText = driver.findElementById("com.sof.retail:id/cbMyself").getText();
        expectedText = "Myself";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/cbSm").getText();
        expectedText = "SM";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/cbAsm").getText();
        expectedText = "ASM";TestAsserts.assertCheck(actualText,expectedText);

        boolean Cancelbtn = driver.findElementById("com.sof.retail:id/cancelButton").isDisplayed();
        System.out.println("The  Cancelbtn status is" + Cancelbtn);

        boolean Okbtn = driver.findElementById("com.sof.retail:id/okButton").isDisplayed();
        System.out.println("The  Okbtn status is" + Okbtn);

        driver.findElementById("com.sof.retail:id/cbSm").click();
        driver.findElementById("com.sof.retail:id/okButton").click();Thread.sleep(7000);

        driver.findElementById("com.sof.retail:id/edtScanCode").sendKeys("Screen Shot");

        driver.findElementById("com.sof.retail:id/edtComments").sendKeys("For Reference");

        driver.findElementById("com.sof.retail:id/btnShowMore").click();Thread.sleep(5000);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(151, 227))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(224, 227)).release().perform();
        Thread.sleep(5000);

        driver.findElementById("com.sof.retail:id/ok_button").click();

        driver.findElementById("com.sof.retail:id/buttonSend").click();Thread.sleep(15000);

        driver.findElementById("com.sof.retail:id/positiveButton").click();Thread.sleep(10000);




    }

    @Then("User enter in Options and Send Button and Discard")
    public void user_enter_in_Options_and_Send_Button_and_Discard() throws InterruptedException {


        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton").click();
        Thread.sleep(5000);


        driver.findElementById("com.sof.retail:id/nav_send_msg").click();Thread.sleep(9000);

        driver.findElementById("com.sof.retail:id/textTO").click();Thread.sleep(5000);

        boolean AddAnotherAdress = driver.findElementById("com.sof.retail:id/addButton").isDisplayed();
        System.out.println("The  AddAnotherAdress Field status is" + AddAnotherAdress);

        actualText = driver.findElementById("com.sof.retail:id/cbMyself").getText();
        expectedText = "Myself";
        TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/cbSm").getText();
        expectedText = "SM";TestAsserts.assertCheck(actualText,expectedText);

        actualText = driver.findElementById("com.sof.retail:id/cbAsm").getText();
        expectedText = "ASM";TestAsserts.assertCheck(actualText,expectedText);

        boolean Cancelbtn = driver.findElementById("com.sof.retail:id/cancelButton").isDisplayed();
        System.out.println("The  Cancelbtn status is" + Cancelbtn);

        boolean Okbtn = driver.findElementById("com.sof.retail:id/okButton").isDisplayed();
        System.out.println("The  Okbtn status is" + Okbtn);

        driver.findElementById("com.sof.retail:id/cbSm").click();

        driver.findElementById("com.sof.retail:id/okButton").click();Thread.sleep(7000);

        driver.findElementById("com.sof.retail:id/edtScanCode").sendKeys("Screen Shot");

        driver.findElementById("com.sof.retail:id/edtComments").sendKeys("For Reference");

        driver.findElementById("com.sof.retail:id/buttonCancel").click();Thread.sleep(3000);

        driver.closeApp();
        driver.quit();

    }


}
