package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.ReturnReceivePage;
import common.Login;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class ReturnReceiveVerifyStepDef extends ReturnReceivePage {
    public ReturnReceiveVerifyStepDef() throws IOException, InterruptedException {
    }

    @Given("Admin is in dashboard page")
    public void adminIsInDashboardPage() {
    }

    @Then("Tap on Receive & Return")
    public void tap_on_Receive_Return()  {
        ReturnReceivePage.ReturnReceiveClick();

    }

    @Then("Verify the options")
    public void verify_the_options() throws InterruptedException {
        ReturnReceivePage.ScreenVerify();
    }

    @Then("Verified the segment")
    public void verifiedTheSegment() {
        System.out.println("Verified Return & Receive Segment");
    }
}
