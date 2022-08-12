

package com.framework.automation.wrapper.ui;

import com.framework.automation.drivers.DriverFactory;
import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Set;

import static org.assertj.core.api.Assertions.fail;

/**
 * WebAction class will hold all actions specific to web platform All actions should return back the
 * action class so that we can call the actions at page level
 *
 *
 */
public class WebAction extends CommonAction {

  /**
   * Select a value from the dropdown inputElement Additional condition added for Safari to click on
   * the dropdown and then selectByVisibleText()
   *
   * @param inputElement
   * @param textToSelect
   * @return
   */
  public static void selectFromDropDown(WebElement inputElement, String textToSelect) {
    try {
      Select select = new Select(inputElement);
      if (!ConfigProp.getPropertyValue("test_type").contains("app")
          && DriverDataHolder.getValue("Browser").equalsIgnoreCase("safari")) click(inputElement);
      select.selectByVisibleText(textToSelect);
      String selectedText = select.getFirstSelectedOption().getText();
      if (!selectedText.trim().equals(textToSelect.trim())) {
        fail(
            "Selecting the option - "
                + textToSelect
                + " - from "
                + inputElement
                + " failed");
      }
    } catch (Exception e) {
      fail(
          "Error occurred while selecting the option - "
              + textToSelect
              + " - from "
              + inputElement,
          e);
    }
  }

  /**
   * Scroll to an element in the page using javascript. This is a fallback method to scroll since
   * OOB selenium scroll doesn't work in IE.
   *
   * @param inputElement
   * @return
   */
  public static void scrollToAnElement(WebElement inputElement) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
      js.executeScript("arguments[0].scrollIntoView(true);", inputElement);
    }catch (Exception e){
      e.printStackTrace();
      fail("Unable to scroll to element  - ",inputElement,e);
    }
  }

  /**
   * Switch the control from frame back to default content in the window
   *
   * @return
   */
  public static void switchToDefaultWindowContentFromFrame() {
    try {
      DriverFactory.getDriver().switchTo().defaultContent();
    }catch (Exception e){
      fail("Unable to switch to default content window from Frame. ",e);
    }
  }

  /**
   * Double click on the element
   *
   * @param inputElement
   * @return
   * @author - AAP COE Automation Team
   */
  public static void doubleClickOnElement(WebElement inputElement) {
    Actions actions;
    try {
      actions = new Actions(DriverFactory.getDriver());
    actions.moveToElement(inputElement).doubleClick().build().perform();
    } catch (Exception exception) {
      fail("Unable to double click on element  -   ",inputElement,exception);
    }
  }

  /**
   * Get the url
   *
   * @param url
   * @return
   */
  public static void goToURL(String url) {
    try {
      DriverFactory.getDriver().get(url);
    }catch (Exception e){
      fail("Unable to go to URL --",url,e);
    }
  }

  /**
   * Accept the alert
   *
   * @return
   */
  public static void acceptAlert() {
    try {
      DriverFactory.getDriver().switchTo().alert().accept();
    }catch (Exception e){
      fail("Unable too accept alert!",e);
    }
  }

  /**
   * Navigate to the url
   *
   * @param url
   * @return
   */
  public static void navigateToURL(String url) {
    try {
      DriverFactory.getDriver().navigate().to(url);
    }catch (Exception e){
      fail("Unable to go to URL --",url,e);
    }
  }

  /**
   * Switch to window using window handle
   *
   * @param windowhandle
   * @param WINDOW_HANDLE_KEY
   * @return
   *
   */
  public static void switchToWindow(HashMap<String, String> windowhandle, String WINDOW_HANDLE_KEY) {
    try {
      DriverFactory.getDriver().switchTo().window(windowhandle.get(WINDOW_HANDLE_KEY));
    }catch (Exception e){
      fail("Failed to Switch to window - - ",windowhandle.get(WINDOW_HANDLE_KEY),e);
    }
  }

  /**
   * fetch the window handles and return the same
   *
   * @return childWindowhandle
   *
   */
  public static HashMap<String, String> getWindowHandles() {
    HashMap<String, String> childWindowhandle = new HashMap<>();
    try {
      String parentWindowHandle = DriverFactory.getDriver().getWindowHandle();
      Set<String> winHandles = DriverFactory.getDriver().getWindowHandles();

      for (String handle : winHandles) {
        if (!handle.equals(parentWindowHandle)) {
          childWindowhandle.put(WINDOW_HANDLE_KEY.CHILD.toString(), handle);
        } else childWindowhandle.put(WINDOW_HANDLE_KEY.PARENT.toString(), handle);
      }
    }catch (Exception e){
      fail("Get Windows handles failed ",e);
    }
    return childWindowhandle;
  }

  /**
   * click using action class method
   *
   * @param elementToBeClicked
   * @return
   *
   */
  public static void  actionClick(WebElement elementToBeClicked) {
    try {
      Actions actions = new Actions(DriverFactory.getDriver());
      actions.moveToElement(elementToBeClicked).click().build().perform();
    } catch (Exception e) {
      fail("Could not click on element - " + elementToBeClicked, e);
    }
  }

  /**
   * Switch to frame using frame name
   *
   * @param frameName
   * @return
   */
  public static void switchToFrameUsingFrameName(String frameName) {
    try {
      DriverFactory.getDriver().switchTo().frame(frameName);
    }catch(Exception e){
      fail("Failed to switch to frame  - ",frameName,e);
    }
  }

  /**
   * mouse Hover functionality through javascript
   *
   * @param inputElement
   * @return
   */
  public static void mouseHover(WebElement inputElement) {
    try {
      String mouseOverScript =
              "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',"
                      + "true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject)"
                      + "{ arguments[0].fireEvent('onmouseover');}";
      JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
      js.executeScript(mouseOverScript, inputElement);

    }catch (Exception e){
      fail("Failed to move hover over the element  - ",inputElement,e);
    }
  }
  /**
   * Execute java script on the element based on the parameter jsToExecute
   *
   * @param jsToExecute
   * @param inputElement
   */
  public static void executeJavaScriptOnElement(String jsToExecute, WebElement inputElement) {
    try{
      JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
      js.executeScript(jsToExecute, inputElement);
    }catch (Exception e){
      fail("Failed to execute JS on element  - ",inputElement,e);
    }
  }

  /**
   * Refresh the current page
   *
   * @return
   */
  public static void refreshCurrentPage() {
    try{
    DriverFactory.getDriver().navigate().refresh();
    }catch (Exception e){
      fail("failed to refresh " ,e);
    }
  }

  /**
   * Switch to frame using element
   *
   * @author - AAP COE Automation Team
   */
  public static void switchToFrameUsingElement(WebElement frameElement) {
    try{
      DriverFactory.getDriver().switchTo().frame(frameElement);
    }catch (Exception e){
      fail("Failed to execute JS on element  - ",frameElement,e);
    }
  }

  /**
   * Select from dropdown using index
   *
   * @param inputElement
   * @param index
   * @author - AAP COE Automation Team
   * @return
   */
  public static void selectByIndexFromDropDown(WebElement inputElement, int index) {
    Select select = new Select(inputElement);
    select.selectByIndex(index);
  }

  /**
   * Navigate back to the previous page
   *
   * @author - AAP COE Automation Team
   * @return
   */
  public static void navigateBack() {
    try{
      DriverFactory.getDriver().navigate().back();
    }catch (Exception e){
      fail("Failed to navigate back  - ",e);
    }
  }

  /**
   * Java Script click on the supplied Element
   * @param element
   *            WebElement (Web/Mobile)
   *            Description of Element for reporting
   */
  public static void clickElementJS(WebElement element) {
    try {
      WebDriver driver = DriverFactory.getDriver();
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("arguments[0].click();", element);

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unable to click element using JS  - "+element,e);

    }
  }

  /**
   * To check multiple windows/tabs are present
   *
   * @return multipeWindowPresent
   *
   */
  public static Boolean isMultipleWindowsPresent() {
    Boolean multipeWindowPresent = false;
    try {
      Set<String> winHandles = DriverFactory.getDriver().getWindowHandles();
      if (winHandles.size() > 1) {
        multipeWindowPresent = true;
      }
    }catch (Exception e){
      fail("Failed to check if multiple windows are open", e);
    }
    return multipeWindowPresent;
  }
}
