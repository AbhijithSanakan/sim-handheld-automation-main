package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.CountPage;
import common.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class CountStepDef extends CountPage {

    public CountStepDef() throws IOException, InterruptedException {
    }

    @Given("logged in the app dashboard page")
    public void logged_in_the_app_dashboard_page() throws InterruptedException, IOException {
        Login.deviceEnvironment();
        System.out.println("Logging into App");
        Thread.sleep(8000);
    }

    @Then("Verify Count icon from dashboard")
    public void verify_Count_icon_from_dashboard() throws InterruptedException {
        CountPage.CountVerify();
    }

    @Then("Click on Count icon and verify Count module and its various sub-modules")
    public void click_on_Count_icon_and_verify_Count_module_and_its_various_sub_modules() throws InterruptedException {
        CountPage.CountOptionsVerify();
    }

    @Then("Verified the count")
    public void verified_the_count() {
        System.out.println("Verified Count");
    }


}
