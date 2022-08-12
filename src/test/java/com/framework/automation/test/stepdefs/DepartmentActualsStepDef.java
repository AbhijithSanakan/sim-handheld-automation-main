package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.DepartmentActualsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class DepartmentActualsStepDef extends DepartmentActualsPage {

    public DepartmentActualsStepDef() throws IOException, InterruptedException {
    }

    @Given("Logged in app dashboard")
    public void logged_in_app_dashboard() throws InterruptedException {
        System.out.println("Logging in");
        Thread.sleep(8000);
    }

    @Then("Tap on Department Actuals")
    public void tap_on_Department_Actuals() throws InterruptedException {
        DepartmentActualsPage.DepActualsClick();
    }

    @And("Click on review actuals and verify department actuals app is working")
    public void clickOnReviewActualsAndVerifyDepartmentActualsAppIsWorking() throws InterruptedException, IOException {
        DepartmentActualsPage.ReviewActualsClick();
        DepartmentActualsPage.DepartmentActualsVerify();
    }

    @Then("Verified the deparment actuals functionality")
    public void verified_the_deparment_actuals_functionality() {
        System.out.println("Verified Department Actuals Functionality");
    }

    @And("Click on review actuals and verify Back and Discard button functionality on Daily Totals screen")
    public void clickOnReviewActualsAndVerifyBackAndDiscardButtonFunctionalityOnDailyTotalsScreen() throws InterruptedException {
        DepartmentActualsPage.ReviewActualsClick();
        DepartmentActualsPage.BackAndDiscard();
    }

    @Then("Verified the back and discard button functionality")
    public void verifiedTheBackAndDiscardButtonFunctionality() {
        System.out.println("Verified Back & Discard Button Functionality");
    }

}
