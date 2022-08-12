package com.framework.automation.test.stepdefs;

import com.framework.automation.drivers.DriverFactory;
import com.framework.automation.test.factory.PageTree;
import com.framework.automation.test.pages.BasePage;
import com.framework.automation.utils.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.Assert;

public class SampleStepDef extends PageTree {


    @Given("Launch Native Application in {string}")
    @Step("Launch Native Application in {string}")
    public void launchNativeApplicationIn(String platform) {
        try {

            //setup platform config for browser and device initialization and driver capabilities
            TestUtil.browserConfig(platform);

            //Initiates driver based on platform , configuration etc..
            DriverFactory.getDriver();

            //Initiates reporting for parallel execution support
            TestUtil.updateTestHistoryId();


        }catch (Exception e) {
            e.printStackTrace();
            Allure.addAttachment("Exception while launching application ", TestUtil.takeScreenShot());
            Assert.fail("Exception while launching application :: "+e.toString());
        }
    }

    @Then("Sample Function call")
    @Step("Sample Function call")
    public void sampleFunctionCall() {
        nativeSamplePage().samplePageMethod();

    }



    @Given("Launch APRO application {string}")
    @Step("Launch APRO application")
    public void launch_apro_application(String browser) {

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
            }
            if (browser.equalsIgnoreCase(("ie"))) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//Drivers/IEDriverServer.exe");
            }
            if (browser.equalsIgnoreCase(("firefox"))) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers/IEDriverServer.exe");
            }
            TestUtil.browserConfig(browser);
            DriverFactory.getDriver();
            String ApplicationName = this.getClass().getSimpleName().split("_")[0];
            System.out.println("Application Name "+ApplicationName);
            BasePage.loadBaseUrl(ApplicationName);
            Thread.sleep(5000);
            TestUtil.updateTestHistoryId();
            if (browser.equalsIgnoreCase(("ie"))) {
                DriverFactory.getDriver().manage().window().maximize();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Allure.addAttachment("Exception in launch_apro_application >> ", TestUtil.takeScreenShot());
            Assert.fail("Exception in launch_apro_application >> "+e.toString());
        }
    }
}
