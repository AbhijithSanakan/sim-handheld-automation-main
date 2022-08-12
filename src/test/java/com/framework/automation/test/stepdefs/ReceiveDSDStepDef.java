package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.ReturnReceivePage;
import common.Login;
import cucumber.api.PendingException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import com.framework.automation.test.pages.ReturnReceivePage;
import common.Login;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ReceiveDSDStepDef extends ReturnReceivePage {

    public ReceiveDSDStepDef() throws IOException, InterruptedException {
    }

    @Given("Admin is on dashboard page")
    public void admin_is_on_dashboard_page() throws MalformedURLException, InterruptedException {

        System.out.println("Admin Logged in");
        //Login.LoginDriver();
    }

    @Then("Click on Receive & return")
    public void click_on_Receive_return() throws InterruptedException {
        System.out.println("Inside then");
        ReturnReceivePage.ReceiveClick();
    }

    @And("Click on Receive DSD")
    public void click_on_Receive_DSD() {
        System.out.println("Clicked return");
    }

    @Then("Verify screen contents")
    public void verify_screen_contents() {
        System.out.println("Inside Verify");
        ReturnReceivePage.Verification();
    }

    @When("All invoice received is displayed")
    public void all_invoice_received_is_displayed() {

    }

    @Then("No invoice screen is succesfully verified")
    public void no_invoice_screen_is_succesfully_verified() {

    }


}
