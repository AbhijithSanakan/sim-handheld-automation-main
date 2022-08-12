package common;

import com.framework.automation.utils.ExcelHandle;
import freemarker.core.Environment;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Login {
    static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> LoginDriver() throws IOException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"20003522502670");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        File f = new File("src/Apps");
        File f1 = new File(f,"SOF-prodDebug-2.6.0-2022-05-09_13-54.apk");

        capabilities.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());

        capabilities.setCapability("appPackage", "com.sof.retail");
        capabilities.setCapability("appActivity", "com.sof.retail.view.activity.LoginActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver (url, capabilities);
        Thread.sleep(18000);

        return driver;
    }

    public static void deviceEnvironment() throws IOException, InterruptedException {

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(91, 719))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(248, 353)).release().perform();


        //SETTING ENVIRONMENT TO QA
        System.out.println("Setting Environment to QA");
        MobileElement advanced = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]");
        advanced.click();
        Thread.sleep(2000);
        MobileElement password = (MobileElement) driver.findElementById("com.sof.retail:id/edtScanCode");
        password.click();
        Thread.sleep(2000);
        password.sendKeys(ReadData.getDecodepassword());
        MobileElement okBtn = (MobileElement) driver.findElementById("com.sof.retail:id/okButton");
        okBtn.click();
        MobileElement Chng = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        Chng.click();
        Thread.sleep(2000);
        MobileElement qa = (MobileElement) driver.findElementById("com.sof.retail:id/rbQa");
        qa.click();
        Thread.sleep(2000);
        MobileElement ok = (MobileElement) driver.findElementById("com.sof.retail:id/positiveButton");
        ok.click();
        System.out.println("Environment set to QA");
        Thread.sleep(6000);
    }


}
