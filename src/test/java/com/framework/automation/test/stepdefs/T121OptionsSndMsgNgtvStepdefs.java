package com.framework.automation.test.stepdefs;

import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class T121OptionsSndMsgNgtvStepdefs {
    static AndroidDriver<AndroidElement> driver;
    static int testCase=121;
    static String actualText;
    static String expectedText;

    @Given("User is Verify Login and Going Options Menu")
    public void user_is_Verify_Login_and_Going_Options_Menu() throws IOException, InterruptedException {

        this.driver = Login.LoginDriver();
        Thread.sleep(10000);
        //Click Order DD
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        el2.click();
        Thread.sleep(5000);


        MobileElement el3 = (MobileElement) driver.findElementById("com.sof.retail:id/nav_send_msg");
        el3.click();Thread.sleep(9000);
    }

    @Then("User going to Click in Send Button with out enter Mail")
    public void user_going_to_Click_in_Send_Button_with_out_enter_Mail() throws InterruptedException {

        driver.findElementById("com.sof.retail:id/edtScanCode").sendKeys("Screen Shot");

        driver.findElementById("com.sof.retail:id/edtComments").sendKeys("For Reference");

        driver.findElementById("com.sof.retail:id/buttonSend").click();Thread.sleep(9000);

        actualText = driver.findElementById("com.sof.retail:id/dialog_message").getText();
        expectedText = "You must provide at least one email address for this message.";TestAsserts.assertCheck(actualText,expectedText);
        Thread.sleep(3000);

        driver.closeApp();
        driver.quit();
    }

}
