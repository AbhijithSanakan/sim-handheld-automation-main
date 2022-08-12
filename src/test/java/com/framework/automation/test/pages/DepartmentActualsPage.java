package com.framework.automation.test.pages;

import com.framework.automation.utils.ExcelHandle;
import com.framework.automation.wrapper.asserts.TestAsserts;
import common.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class DepartmentActualsPage {
    static AndroidDriver<AndroidElement> driver;
    static int testCase;
    static String keys = null;
    static String actualText;
    static String expectedText;

    public DepartmentActualsPage() throws IOException, InterruptedException {
        this.driver = Login.LoginDriver();
    }

    public static void DepActualsClick() throws InterruptedException {
        Thread.sleep(10000);
        //Swiping Down
        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(257, 392))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(257, 197)).release().perform();

        //Clicking Deparment Actuals
        MobileElement deptActualClick = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.view.ViewGroup/android.widget.RelativeLayout");
        deptActualClick.click();
    }

    public static void ReviewActualsClick() throws InterruptedException {
        MobileElement revActClick = (MobileElement) driver.findElementById("com.sof.retail:id/textViewItem");
        revActClick.click();
        Thread.sleep(5000);
    }

    public static void DepartmentActualsVerify() throws InterruptedException, IOException {
        testCase = 86;
        keys = "Department";

        //Department & Date
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Department and Date";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Department & Sales Date
        boolean deptDropdown = driver.findElement(By.id("com.sof.retail:id/spinnerDepartment")).isDisplayed();
        String dept = driver.findElement(By.id("com.sof.retail:id/tvDepartment")).getText();
        if (deptDropdown == true) {
            System.out.println(dept + " dropdown is visible");
        }

        boolean salesDateDropdown = driver.findElement(By.id("com.sof.retail:id/textSalesDate")).isDisplayed();
        String salesDateValue = driver.findElement(By.id("com.sof.retail:id/textSalesDate")).getText();
        String salesDate = driver.findElement(By.id("com.sof.retail:id/tvSalesDate")).getText();
        if (salesDateDropdown == true) {
            System.out.println(salesDate + " dropdown is visible");
            System.out.println("Date : " + salesDateValue);
        }

        //Next Button
        boolean nextBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + nextBtn + " for Next Button");

        //Clicking on department dropdown
        driver.findElement(By.id("com.sof.retail:id/spinnerDepartment")).click();
        //Screenshot the dept dropdown
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "D:\\SOF Automation\\IMAF-main\\ScreenShots\\86_Dept_Dropdown" + ".jpg";
        FileUtils.copyFile(file, new File(fileName));

        //Tapping outside dropdown
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(26, 345)).perform();

        //Selecting a dept from dropdown
        MobileElement deptSelect = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerDepartment");
        deptSelect.sendKeys("Dairy");
//        deptSelect.sendKeys(ExcelHandle.ExcelFunction(testCase, keys));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        action.tap(PointOption.point(217, 181)).perform();
        Thread.sleep(2000);
        //Storing value of used department to deptvalue
        String deptValue = driver.findElement(By.id("com.sof.retail:id/spinnerDepartment")).getText();

        //Clicking Sales Date
        MobileElement salesDateClick = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerSalesDate");
        salesDateClick.click();
        boolean calChck = driver.findElement(By.id("android:id/month_view")).isDisplayed();
        if (calChck == true) {
            try {
                System.out.println("Calender is displayed");
                String curDate = driver.findElement(By.id("android:id/date_picker_header_date")).getText();
                System.out.println("Current Month & Date : " + curDate);

                //Checking whether invalid date is selectable
                boolean minFieldClick = driver.findElement(By.xpath("//android.view.View[@content-desc=\"30 July 2022\"]")).getAttribute("clickable").equals("true");
                if (minFieldClick == true) {
                    System.out.println("Disabled Date is clickable");
                } else {
                    System.out.println("Disabled Date is Read Only");
                }

                //Selecting a valid date
                driver.findElement(By.xpath("//android.view.View[@content-desc=\"26 July 2022\"]")).click();
                driver.findElement(By.id("android:id/button1")).click();

            } catch (Exception e) {
                System.out.println("Calender is not displayed");
            }
        }

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(5000);

        //Actuals
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Actuals";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Dept & Date
        boolean deptChck = driver.findElement(By.id("com.sof.retail:id/departmentName")).isDisplayed();
        String deptCurrntValue = driver.findElement(By.id("com.sof.retail:id/departmentName")).getText();
        boolean dateChck = driver.findElement(By.id("com.sof.retail:id/date")).isDisplayed();
        String dateValue = driver.findElement(By.id("com.sof.retail:id/date")).getText();
        if (deptChck == true && dateChck == true) {
            //Checking whether the selected dept is displayed
            if (deptValue.equalsIgnoreCase(deptCurrntValue)) {
                System.out.println("Selected department & date is visible");
                System.out.println("Department - " + deptCurrntValue);
                System.out.println("Sales Date - " + dateValue);

                //Sales Information
                String hours = driver.findElement(By.id("com.sof.retail:id/Hours")).getText();
                String hoursValue = driver.findElement(By.id("com.sof.retail:id/HoursValue")).getText();
                System.out.println("Actual " + hours + " worked - " + hoursValue);

            } else {
                System.out.println("Mismatch in displayed department");
            }
        }

        //Next & Back
        boolean nextBtnChck = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " + nextBtnChck + " for Next Button");
        boolean backBtnChck = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " + backBtnChck + " for Back Button");

        //Clicking Next
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(6000);

        //Daily Totals
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Daily Totals";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        if (deptChck == true && dateChck == true) {
            System.out.println("Department & date is visible");
            System.out.println("Department - " + deptCurrntValue);
            System.out.println("Sales Date - " + dateValue);
        }

        boolean prjSales = driver.findElement(By.id("com.sof.retail:id/projSales")).isDisplayed();
        String prjSalesValue = driver.findElement(By.id("com.sof.retail:id/projSalesValue")).getText();
        System.out.println("Status is " + prjSales + " for Projected Sales");
        boolean actSales = driver.findElement(By.id("com.sof.retail:id/actualSales")).isDisplayed();
        String actSalesValue = driver.findElement(By.id("com.sof.retail:id/actualSalesValue")).getText();
        System.out.println("Status is " + actSales + " for Actual Sales");
        boolean variance = driver.findElement(By.id("com.sof.retail:id/variance")).isDisplayed();
        String varianceValue = driver.findElement(By.id("com.sof.retail:id/varianceValue")).getText();
        System.out.println("Status is " + variance + " for Variance");
        boolean lySales = driver.findElement(By.id("com.sof.retail:id/lySales")).isDisplayed();
        String lySalesValue = driver.findElement(By.id("com.sof.retail:id/lySalesValue")).getText();
        System.out.println("Status is " + lySales + " for LY Sales");
        boolean prjUnits = driver.findElement(By.id("com.sof.retail:id/projUnits")).isDisplayed();
        String prjUnitsValue = driver.findElement(By.id("com.sof.retail:id/projUnitsValue")).getText();
        System.out.println("Status is " + prjUnits + " for Projected Units");
        boolean actUnits = driver.findElement(By.id("com.sof.retail:id/actualsUnits")).isDisplayed();
        String actUnitsValue = driver.findElement(By.id("com.sof.retail:id/actualsUnitsValue")).getText();
        System.out.println("Status is " + actUnits + " for Actual Units");
        boolean prjHours = driver.findElement(By.id("com.sof.retail:id/projHours")).isDisplayed();
        String prjHoursValue = driver.findElement(By.id("com.sof.retail:id/projHoursValue")).getText();
        System.out.println("Status is " + prjHours + " for Projected Hours");

        //Swiping
        action.press(PointOption.point(257, 392))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(257, 197)).release().perform();

        boolean actHours = driver.findElement(By.id("com.sof.retail:id/actualsHours")).isDisplayed();
        String actHoursValue = driver.findElement(By.id("com.sof.retail:id/actualsHoursValue")).getText();
        System.out.println("Status is " + actHours + " for Actual Hours");
        boolean storeSales = driver.findElement(By.id("com.sof.retail:id/storeSales")).isDisplayed();
        String storeSalesValue = driver.findElement(By.id("com.sof.retail:id/storeSalesValue")).getText();
        System.out.println("Status is " + storeSales + " for Store Sales");
        boolean lyStoreSales = driver.findElement(By.id("com.sof.retail:id/lyStoreSales")).isDisplayed();
        String lyStoreValue = driver.findElement(By.id("com.sof.retail:id/lyStoreSalesValue")).getText();
        System.out.println("Status is " + lyStoreSales + " for LY Store Sales");
        boolean ratio = driver.findElement(By.id("com.sof.retail:id/ratio")).isDisplayed();
        String ratioValue = driver.findElement(By.id("com.sof.retail:id/ratioValue")).getText();
        System.out.println("Status is " + ratio + " for Ratio");

        //Printing Sales Information
        System.out.println("Sales Information");
        System.out.println("__________________");
        System.out.println("Projected Sales - " + prjSalesValue);
        System.out.println("Actual Sales - " + actSalesValue);
        System.out.println("+/- Variance - " + varianceValue);
        System.out.println("Ly Sales - " + lySalesValue);
        System.out.println("Projected Units - " + prjUnitsValue);
        System.out.println("Actual Units - " + actUnitsValue);
        System.out.println("Projected Hours - " + prjHoursValue);
        System.out.println("Actual Hours - " + actHoursValue);
        System.out.println("Store Sales - " + storeSalesValue);
        System.out.println("LY Store Sales - " + lyStoreValue);
        System.out.println("Ratio - " + ratioValue);

        //Back & Done Button
        boolean bckBtn = driver.findElement(By.id("com.sof.retail:id/button")).isDisplayed();
        System.out.println("Status is " +bckBtn+ " for Back Button");
        boolean doneBtn = driver.findElement(By.id("com.sof.retail:id/button3")).isDisplayed();
        System.out.println("Status is " +bckBtn+ " for Done Button");

        //Clicking Done
        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(3000);

        //Actuals
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Closing App
        driver.closeApp();
        driver.quit();
    }

    public static void BackAndDiscard() throws InterruptedException {
        testCase = 88;
        String deptName = "Changes";
        //Selecting a dept from dropdown
        MobileElement deptSelect = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerDepartment");
        deptSelect.click();
        deptSelect.sendKeys("Changes");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(223, 179)).perform();
        Thread.sleep(2000);
        //Storing value of used department to deptvalue
        String deptValue = driver.findElement(By.id("com.sof.retail:id/spinnerDepartment")).getText();

        //Clicking Sales Date
        MobileElement salesDateClick = (MobileElement) driver.findElementById("com.sof.retail:id/spinnerSalesDate");
        salesDateClick.click();
        //Selecting a valid date
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"26 July 2022\"]")).click();
        driver.findElement(By.id("android:id/button1")).click();

        if (deptValue.equalsIgnoreCase(deptName)) {
            System.out.println("Selected department & date is visible");
        }

        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(4000);

        //Actuals
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Actuals";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Dept & Date
        boolean deptChck = driver.findElement(By.id("com.sof.retail:id/departmentName")).isDisplayed();
        String deptCurrntValue = driver.findElement(By.id("com.sof.retail:id/departmentName")).getText();
        boolean dateChck = driver.findElement(By.id("com.sof.retail:id/date")).isDisplayed();
        String dateValue = driver.findElement(By.id("com.sof.retail:id/date")).getText();
        if (deptChck == true && dateChck == true) {

                System.out.println("Department - " + deptCurrntValue);
                System.out.println("Sales Date - " + dateValue);

                //Sales Information
                String hours = driver.findElement(By.id("com.sof.retail:id/Hours")).getText();
                String hoursValue = driver.findElement(By.id("com.sof.retail:id/HoursValue")).getText();
                System.out.println("Actual " + hours + " worked - " + hoursValue);

        }

        driver.findElement(By.id("com.sof.retail:id/button3")).click();
        Thread.sleep(6000);

        //Daily Totals
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Daily Totals";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        if (deptChck == true && dateChck == true) {
            System.out.println("Department & date is visible");
            System.out.println("Department - " + deptCurrntValue);
            System.out.println("Sales Date - " + dateValue);
        }

        boolean prjSales = driver.findElement(By.id("com.sof.retail:id/projSales")).isDisplayed();
        String prjSalesValue = driver.findElement(By.id("com.sof.retail:id/projSalesValue")).getText();
        System.out.println("Status is " + prjSales + " for Projected Sales");
        boolean actSales = driver.findElement(By.id("com.sof.retail:id/actualSales")).isDisplayed();
        String actSalesValue = driver.findElement(By.id("com.sof.retail:id/actualSalesValue")).getText();
        System.out.println("Status is " + actSales + " for Actual Sales");
        boolean variance = driver.findElement(By.id("com.sof.retail:id/variance")).isDisplayed();
        String varianceValue = driver.findElement(By.id("com.sof.retail:id/varianceValue")).getText();
        System.out.println("Status is " + variance + " for Variance");
        boolean lySales = driver.findElement(By.id("com.sof.retail:id/lySales")).isDisplayed();
        String lySalesValue = driver.findElement(By.id("com.sof.retail:id/lySalesValue")).getText();
        System.out.println("Status is " + lySales + " for LY Sales");
        boolean prjUnits = driver.findElement(By.id("com.sof.retail:id/projUnits")).isDisplayed();
        String prjUnitsValue = driver.findElement(By.id("com.sof.retail:id/projUnitsValue")).getText();
        System.out.println("Status is " + prjUnits + " for Projected Units");
        boolean actUnits = driver.findElement(By.id("com.sof.retail:id/actualsUnits")).isDisplayed();
        String actUnitsValue = driver.findElement(By.id("com.sof.retail:id/actualsUnitsValue")).getText();
        System.out.println("Status is " + actUnits + " for Actual Units");
        boolean prjHours = driver.findElement(By.id("com.sof.retail:id/projHours")).isDisplayed();
        String prjHoursValue = driver.findElement(By.id("com.sof.retail:id/projHoursValue")).getText();
        System.out.println("Status is " + prjHours + " for Projected Hours");

        //Swiping
        action.press(PointOption.point(257, 392))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(257, 197)).release().perform();

        boolean actHours = driver.findElement(By.id("com.sof.retail:id/actualsHours")).isDisplayed();
        String actHoursValue = driver.findElement(By.id("com.sof.retail:id/actualsHoursValue")).getText();
        System.out.println("Status is " + actHours + " for Actual Hours");
        boolean storeSales = driver.findElement(By.id("com.sof.retail:id/storeSales")).isDisplayed();
        String storeSalesValue = driver.findElement(By.id("com.sof.retail:id/storeSalesValue")).getText();
        System.out.println("Status is " + storeSales + " for Store Sales");
        boolean lyStoreSales = driver.findElement(By.id("com.sof.retail:id/lyStoreSales")).isDisplayed();
        String lyStoreValue = driver.findElement(By.id("com.sof.retail:id/lyStoreSalesValue")).getText();
        System.out.println("Status is " + lyStoreSales + " for LY Store Sales");
        boolean ratio = driver.findElement(By.id("com.sof.retail:id/ratio")).isDisplayed();
        String ratioValue = driver.findElement(By.id("com.sof.retail:id/ratioValue")).getText();
        System.out.println("Status is " + ratio + " for Ratio");

        //Printing Sales Information
        System.out.println("Sales Information");
        System.out.println("__________________");
        System.out.println("Projected Sales - " + prjSalesValue);
        System.out.println("Actual Sales - " + actSalesValue);
        System.out.println("+/- Variance - " + varianceValue);
        System.out.println("Ly Sales - " + lySalesValue);
        System.out.println("Projected Units - " + prjUnitsValue);
        System.out.println("Actual Units - " + actUnitsValue);
        System.out.println("Projected Hours - " + prjHoursValue);
        System.out.println("Actual Hours - " + actHoursValue);
        System.out.println("Store Sales - " + storeSalesValue);
        System.out.println("LY Store Sales - " + lyStoreValue);
        System.out.println("Ratio - " + ratioValue);

        //Clicking Back Button
        driver.findElement(By.id("com.sof.retail:id/button")).click();
        Thread.sleep(3000);

        //Actuals
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Actuals";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Clicking Discard
        driver.findElement(By.id("com.sof.retail:id/discardIcon")).click();
        driver.findElement(By.id("com.sof.retail:id/discardYesButton")).click();
        Thread.sleep(6000);

        //Dashboard
        actualText = driver.findElement(By.id("com.sof.retail:id/toolBarHeader")).getText();
        expectedText = "Dashboard";
        TestAsserts.assertCheck(actualText, expectedText);
        Thread.sleep(2000);

        //Closing App
        driver.closeApp();
        driver.quit();
    }
}
