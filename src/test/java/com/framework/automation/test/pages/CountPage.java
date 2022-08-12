package com.framework.automation.test.pages;

import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CountPage {
    static int n;
    static List count = new ArrayList<>();
    static AndroidDriver<AndroidElement> driver;

    public CountPage() throws IOException, InterruptedException {
       this.driver = Login.LoginDriver();
    }

    public static void CountVerify() throws InterruptedException {
        Thread.sleep(10000);
        //Swiping Down
        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(257, 392))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(257, 197)).release().perform();

        //Checking & verifying Count Icon
        boolean count = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout").isDisplayed();
        if(count==true) {
            System.out.println("Count is present on dashboard");
        }
    }

    public static void CountOptionsVerify() throws InterruptedException {
        //Clicking on Count
        MobileElement countClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout");
        countClick.click();
        Thread.sleep(2000);

        //Checking for Listed Counts
        try {
            for (n = 1; n < 10; n++) {
                String countName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.GridView/android.view.ViewGroup[" + n + "]/android.widget.TextView")).getText();
                count.add(countName);
            }
        } catch (Exception e) {
            System.out.println(" ");
        }

        System.out.println("Total " + count.size() + " Count Options is listed");
        for (n = 0; n < count.size(); n++) {
            System.out.println(n+1 + " - " + count.get(n));
        }

        //Collapsing Count
        countClick.click();

        //Closing App
        driver.closeApp();
        driver.quit();
    }

}
