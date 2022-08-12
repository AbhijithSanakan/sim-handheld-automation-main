package com.framework.automation.libraries.sikuli;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.framework.automation.drivers.SikuliDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * The SikuliActions class provides all required methods and variables required sikuli driver action
 *
 * @since 09-18-2019
 * @version 1.5
 *
 */
public class SikuliActions{

    Screen screen = SikuliDriver.getSikuliScreen();
    private Region region;
    Pattern pattern;
    double syncTimeout = 30.0;
    String pageName;
    String controlName;

    public SikuliActions() throws Exception {
    }

    /**
     * click on image based image and modifier
     *
     * @param imgName
     *            - Name of the image to be verified
     * @param modifier
     * @return
     */
    public void clickOnImage(String imgName, Integer modifier) throws Exception {
        if (waitForImage(imgName)) {
            region.click(imgName, modifier);
        } else {
            Assert.fail("Click on Image");
        }
    }

    /**
     * click on image without modifiers
     *
     * @param imgName
     *            - Name of the image to be verified
     * @return
     */
    public void clickOnImage(String imgName) throws Exception {
        if (waitForImage(imgName)) {
            region.click();
        } else {
            Assert.fail("Click on Image");
        }
    }

    /**
     * double click on image without modifiers
     *
     * @param imgName
     *            - Name of the image to be verified
     * @return
     */
    public void doubleClickOnImage(String imgName) throws Exception {
        if (waitForImage(imgName)) {
            region.doubleClick();
        } else {
            Assert.fail("Click on Image");
        }
    }

    /**
     * get data from clip board
     *
     * @param
     * @return String data from clipboard
     */
    public String getDataFromClipboard() {
        try {
            String copiedData= (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            return copiedData;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * This method writes a string to the clipboard.
     *
     * @param -String data to clipboard
     * @return
     */
    public static void setStringToClipboard(String stringContent) {
        StringSelection stringSelection = new StringSelection(stringContent);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void clearClipboard() {
        try {
            StringSelection stringSelection = new StringSelection("");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        } catch (Exception e) {
        }
    }

    /**
     * click on image based image and modifier
     *
     * @param imgName
     *            - Name of the image to be verified
     * @param offsetHeight
     *            - Relative height to set offset from the image center -
     *            expected values -1 to 1
     * @param offsetWidth
     *            - Relative width to set offset from the image center -
     *            expected values -1 to 1
     * @return
     */
    public void clickOnImage(String imgName, Double offsetHeight, Double offsetWidth) throws Exception {
        if (waitForImage(imgName)) {
            // region.offset((int) (offsetWidth * (region.w) / 2), (int)
            // (offsetHeight * (region.h) / 2)).click();
            region.offset((int) (offsetWidth / 1), (int) (offsetHeight / 1)).click();

        } else {
            Assert.fail("Click on Image");
        }
    }

    /**
     * DOUBLE click on image based image and modifier
     *
     * @param imgName
     *            - Name of the image to be verified
     * @param offsetHeight
     *            - Relative height to set offset from the image center -
     *            expected values -1 to 1
     * @param offsetWidth
     *            - Relative width to set offset from the image center -
     *            expected values -1 to 1
     * @return
     */
    public void doubleClickOnImage(String imgName, Double offsetHeight, Double offsetWidth) throws Exception {
        if (waitForImage(imgName)) {
            // region.offset((int) (offsetWidth * (region.w) / 2), (int)
            // (offsetHeight * (region.h) / 2)).click();
            region.offset((int) (offsetWidth / 1), (int) (offsetHeight / 1)).doubleClick();

        } else {
            Assert.fail("Click on Image");
        }
    }

    /**
     * Type the string on the screen
     *
     * @param typeString
     *            - String to be entered
     * @return
     */
    public void typeOnScreen(String typeString) throws Exception {
        try {
            screen.type(typeString);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * does enter
     *
     * @param -typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void enter() throws IOException {
        try {
            screen.type(Key.ENTER);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * does tab
     *
     * @param -typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void tab() throws IOException {
        try {
            screen.type(Key.TAB);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * does delete
     *
     * @param -typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void delete() throws IOException {
        try {
            screen.type(Key.DELETE);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * does control + a
     *
     * @param -typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void selectall() throws IOException {

        try {
            screen.type("a", KeyModifier.CTRL);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * does control + c
     *
     * @param -typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void copy() throws IOException {
        try {
            screen.type("c", KeyModifier.CTRL);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * does control + v
     *
     * @param -typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void paste() throws IOException {
        try {
            screen.type("v", KeyModifier.CTRL);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * does control + x
     *
     * @param -typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void cut() throws IOException {
        try {
            screen.type("x", KeyModifier.CTRL);

        } catch (Exception e) {
            Assert.fail("Click on Image");
        }
    }

    /**
     * type on image based on image name
     *
     * @param imgName
     *            - Name of the image to be verified
     * @param typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void typeOnImage(String imgName, String typeString) throws IOException {
        if (waitForImage(imgName)) {
            screen.type(imgName, typeString);

        } else {
            Assert.fail("Click on Image");
        }
    }

    /**
     * type on image based on image name
     *
     * @param imgName
     *            - Name of the image to be verified
     * @param typeString
     *            - String to be entered
     * @return
     * @throws IOException
     */
    public void typeOnImage(String imgName, String typeString,boolean capsOn) throws Exception {
        if (waitForImage(imgName)) {
            screen.type(imgName, typeString,KeyModifier.SHIFT);

        } else {
            Assert.fail("Click on Image");
        }
    }

    /**
     * Get the text on image
     *
     * @param imgName
     *            - Name of the image to be verified
     * @return
     * @throws IOException
     */
    public String getTextOnImage(String imgName) throws IOException {
        if (waitForImage(imgName)) {
            try {

                org.sikuli.basics.Settings.OcrTextSearch = true;
                org.sikuli.basics.Settings.OcrTextRead = true;
                String text = screen.find(imgName).text();

                return text;
            } catch (Exception e) {
                Assert.fail("Click on Image");
            }

        } else {
            Assert.fail("Click on Image");
        }
        return "";
    }

    /**
     * wait for provided seconds
     *
     * @param -integer seconds
     *            - Name of the image to be verified
     * @return
     * @throws IOException
     */
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
        }
    }

    /**
     * Get the text on image with offset
     *
     * @param imgName
     *            - Name of the image to be verified
     * @return
     * @throws IOException
     */
    public String getTextOnImage(String imgName, int offset) throws IOException {
        if (waitForImage(imgName)) {
            try {
                org.sikuli.basics.Settings.OcrTextSearch = true;
                org.sikuli.basics.Settings.OcrTextRead = true;
                String text= screen.find(imgName).right(offset).text();
                return text;
            } catch (Exception e) {
                Assert.fail("Click on Image");
            }
        }

        else {
            Assert.fail("Click on Image");
        }

        return "";
    }

    /**
     * Get the the click area for text box
     *
     * @param imgName
     * @return
     */
    public double getClickX(String imgName) {
        double width = getDimensions(imgName)[1];
        if (width > 0) {
            return width * 0.9;
        }
        return 0;
    }

    /**
     * Get the dimensions of an image
     *
     * @param imgName
     * @return
     */
    public double[] getDimensions(String imgName) {
        try {
            BufferedImage bimg = ImageIO.read(new File(imgName));
            return new double[] { bimg.getHeight(), bimg.getWidth() };
        } catch (Exception e) {
            return new double[] { 0.0, 0.0 };
        }

    }

    /**
     * Verify image is displayed on the page
     *
     * @param imgName
     *            - Name of the image to be verified
     * @return
     * @throws FindFailed
     */
    public boolean IsImagePresent(String imgName) {
        try {
            region = screen.find(imgName);
            ActionLog("Image " + imgName + " is found on screen");
            return true;
        } catch (FindFailed e) {
            e.printStackTrace();
            ActionLog("Image " + imgName + " is not found on screen");
            return false;
        }
    }

    /**
     * wait until the image is loaded in the page
     *
     * @param imgName
     *            - Name of the image to be verified
     * @return boolean
     * @throws IOException
     */
    private boolean waitForImage(String imgName) throws IOException {

        try {
            region = screen.wait(imgName, syncTimeout);
            ActionLog("Image " + imgName + " is found on screen");
            return true;
        } catch (FindFailed e) {
            e.printStackTrace();
            ActionLog("Image " + imgName + " is not found on screen");
            Assert.fail("Click on Image");
            return false;
        }
    }

    /**
     * Verify the navigation into a page with a reference image
     *
     * @param imgName
     *            - Name of the image to be verified
     * @return boolean
     * @throws IOException
     */
    public boolean synchronizeAction(String pageName, String imgName) throws IOException {
        // region = screen.wait(imgName, syncTimeout);
        if (waitForImage(imgName)) {
            this.pageName = pageName;
            ActionLog("Navigation to the page " + pageName + " verified with image " + imgName + " is successful");
            return true;
        } else {
            Assert.fail("Click on Image");
            return false;
        }
        /*
         * catch(FindFailed e){ e.printStackTrace();
         * ActionLog("Navigation to the page " + pageName +
         * " verified with image " + imgName + " is not successful"); //Code to
         * take action based on the failure to come here
         *
         * return false; }
         */
    }

    /**
     * Log message to TestNG report and ALM results
     *
     * @param -String message
     * @return
     * @throws
     */
    public SikuliActions ActionLog(String message) {
        ReportLog(message, false);
        return this;
    }

    /**
     * Add a message to TestNG report
     *
     * @param message
     *            - Message
     * @param header
     *            - Is a separator needed?
     * @return
     */
    public SikuliActions ReportLog(String message, boolean header) {
        // add to TestNG report
        if (header) {
            message = "================" + message + "================";
        }
        Reporter.log(message + "\n");
        return this;
    }


    private String getStepName(String stepName)
    {
        stepName += " [Screen="+pageName+"][Control="+controlName+"]";
        return stepName;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

}
