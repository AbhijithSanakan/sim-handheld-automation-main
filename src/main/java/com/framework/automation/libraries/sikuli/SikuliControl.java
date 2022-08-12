package com.framework.automation.libraries.sikuli;

import java.io.IOException;

/**
 * The SikuliControl contains methods and basic actions to be carried by sikuli driver
 * it is extends sikulliActions which has more driver actions
 * @since 09-18-2019
 * @version 1.2
 *
 */
public class SikuliControl extends SikuliActions{
    private String imagePath;
    @SuppressWarnings("unused")
    private ControlType type;

    /**
     * The SikuliControl method sets up the initializing process for sikuli driver
     *
     * @param -String Page name, String image name, ControlType type
     * @return
     * @throws
     * @see -
     * @since 09-18-2019
     * @version 1.4
     *
     */
    public SikuliControl(String pageName, String imageName, ControlType type) throws Exception {
        setPageName(pageName);
        setControlName(imageName);
        this.type = type;
        this.imagePath = "src/test/resources/Images/" + pageName + "/" + imageName + ".PNG";
    }

    /**
     * Get the Image path
     * @return
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * set the image path
     * @param -String imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Click on image using dimension
     * @param -Double offsetHeight,Double offsetWidth
     * @throws Exception
     */
    public void click(Double offsetHeight, Double offsetWidth) throws Exception {
        clickOnImage(imagePath, offsetHeight, offsetWidth);

    }

    /**
     * double click on image using dimension
     * @param -Double offsetHeight,Double offsetWidth
     * @throws Exception
     */
    public void doubleClick(Double offsetHeight, Double offsetWidth) throws Exception {
        doubleClickOnImage(imagePath, offsetHeight, offsetWidth);

    }

    public void click(Integer modifier) throws Exception {
        clickOnImage(imagePath, modifier);

    }

    /**
     * Click on a image
     * @throws Exception
     */
    public void click() throws Exception {
        clickOnImage(imagePath);

    }

    /**
     * Double click on image
     * @throws Exception
     */
    public void doubleClick() throws Exception {
        doubleClickOnImage(imagePath);

    }

    /**
     * Type into a image controller
     * @param -String input
     * @throws IOException
     */
    public void type(String input) throws IOException {
        /*
         * double clickWidth=getClickX(imagePath); if(clickWidth>0) {
         * click(0.0,clickWidth); } else { click(); }
         */
        typeOnImage(imagePath, input);

    }

    /**
     * On caps while typing
     * @param -String input
     * @throws Exception
     */
    public void typeCaps(String input) throws Exception {
        /*
         * double clickWidth=getClickX(imagePath); if(clickWidth>0) {
         * click(0.0,clickWidth); } else { click(); }
         */
        typeOnImage(imagePath, input,true);

    }

    /**
     * Get the text inside an image controller
      * @return -String Text on image
     * @throws IOException
     */
    public String getText() throws IOException {
        return getTextOnImage(imagePath);
    }

    /**
     * Get text inside an image controller
     * @param -integer offset
     * @return
     * @throws IOException
     */
    public String getText(int offset) throws IOException {
        return getTextOnImage(imagePath, offset);
    }

    /**
     * Synchronize by waiting for a page
     * @param message
     * @throws IOException
     */
    public void synchronize(String message) throws IOException {
        synchronizeAction(message, imagePath);

    }
}
