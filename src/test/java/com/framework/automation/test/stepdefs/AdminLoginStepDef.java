package com.framework.automation.test.stepdefs;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.cookie.SetCookie;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AdminLoginStepDef extends Login {
   static WebDriver driver;

    @Given("Admin is on welcome page")
    public void Adminisonwelcomepage() throws MalformedURLException, InterruptedException {
//        Login();
        System.out.println("The admin is on welcome page");
    }

    @Then("Swipe up to login")
    public void Swipeuptologin() {

        System.out.println("Swiped up to login");

    }

    @When("Admin enters valid credentials")
    public void Adminentersvalidcredentials() {
        System.out.println("Admin entered valid credentials");

    }

    @And("Hits log in")
    public void Hitslogin() {
        System.out.println("Clicked on login button");

    }

    @Then("Admin should be logged in successfully")
    public void Adminshouldbeloggedinsuccessfully() {
        System.out.println("Successfully logged in");

    }
}
