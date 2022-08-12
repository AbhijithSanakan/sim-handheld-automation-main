

package com.framework.automation.wrapper.ui;

import com.framework.automation.drivers.DriverFactory;
import com.framework.automation.wrapper.asserts.TestAsserts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import java.time.Duration;

import static org.assertj.core.api.Assertions.fail;

/**
 * NativeAppsAction class will hold all actions lspecific to native apps All actions should return
 * back the action class so that we can call the actions at page level
 *
 *
 */
public class NativeAppsAction extends CommonAction {

  // KEYBOARD BUTTON LOCATORS FOR IOS
  Element IOS_KEYBOARD_DONE_TYPE1 =
      new Element(
          "iOS Keyboard Done button 1",
          "//XCUIElementTypeToolbar//XCUIElementTypeButton[@label='Done' or @label='DONE']",
          Element.XPATH);
  Element IOS_KEYBOARD_DONE_TYPE2 =
      new Element(
          "iOS Keyboard Done button 2",
          "//XCUIElementTypeKeyboard[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[@label='Done']",
          Element.XPATH);
  Element IOS_KEYBOARD_SEARCH = new Element("iOS Keyboard Done button", "Search", Element.NAME);
  Element IOS_KEYBOARD_NEXT =
      new Element(
          "iOS Keyboard Next button",
          "//XCUIElementTypeToolbar//XCUIElementTypeButton[@label=\"Next\"]",
          Element.XPATH);
  Element IOS_RETURN_BUTTON =
      new Element(
          "iOS Keyboard Return button",
          "type == 'XCUIElementTypeButton' AND label == 'return'",
          Element.IOSPREDICATE);
  String KEYBOARDTYPE = "XCUIElementTypeKeyboard";
  String KEYBOARDBUTTON = "XCUIElementTypeButton";
  Element DROPDOWN_TEXT_HOLDER =
      new Element(
          "Element to select text from dropdowns",
          "",
          Element.XPATH,
          "//*[contains(@text,'{0}')]",
          Element.XPATH);

  public enum ScrollDirection {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }


  /**
   * type method without clear option as appium causes exception when using clear explicitly in some
   * cases
   *
   * @param inputElement
   * @param keysToSend
   * @return
   */
  public static void type(Element inputElement, String keysToSend) {
    try {
      WebElement elementToActOn =
              waitForElement(inputElement, Waits.WAIT_CONDITIONS.CLICKABLE);
      elementToActOn.sendKeys(keysToSend);
    } catch (Exception e) {
      fail("Could not type on element - " + inputElement, e);
    }
  }

  public static void click(Element elementToBeClicked) {
    try {
      waitForElement(elementToBeClicked, WAIT_CONDITIONS.CLICKABLE).click();
    } catch (Exception e) {
      fail("Could not click on element - " + elementToBeClicked, e);
    }
  }


  /**
   * method to swipe in required direction specified by the user and find element
   *
   * @param direction (expected values - UP,DOWN,LEFT,RIGHT)
   * @param count expects the number of times the scroll needs to be performed
   * @throws Exception
   * @implNote Please refrain from using large values for count as it will affect the performance of
   *     the script
   *
   */
  public void scrollToElement(Element elementDetails, ScrollDirection direction, int count) {
  try {
    TouchAction touchAction = new TouchAction((AppiumDriver) DriverFactory.getDriver());
    Dimension dimensions = DriverFactory.getDriver().manage().window().getSize();
    boolean elementVisibleFlag = false;

    // VARIABLE DECLARATION
    Double screenHeightStart = 0.0;
    Double screenHeightEnd = 0.0;
    Double screenWidthStart = 0.0;
    Double screenWidthEnd = 0.0;
    int scrollStart = 0;
    int scrollEnd = 0;
    int sideScrollStart = 0;
    int sideScrollEnd = 0;

    // DIMENSIONS IDENTIFIED
    screenHeightStart = dimensions.getHeight() * 0.5;
    screenHeightEnd = dimensions.getHeight() * 0.2;
    screenWidthStart = dimensions.getWidth() * 0.5;
    screenWidthEnd = dimensions.getWidth() * 0.2;

    // CO-ORDINATES ST TO INT VALUE
    scrollStart = screenHeightStart.intValue();
    scrollEnd = screenHeightEnd.intValue();
    sideScrollStart = screenWidthStart.intValue();
    sideScrollEnd = screenWidthEnd.intValue();
    for (int i = 0; i < count; i++) {

      try {
        RemoteWebElement element =
                (RemoteWebElement) DriverFactory.getDriver().findElement(Element.getByObject(elementDetails));

        if (element.isDisplayed()) {
          elementVisibleFlag = true;
          break;
        }
      } catch (NoSuchElementException e) {
        elementVisibleFlag = false;
      }
      if (!elementVisibleFlag) {
        switch (direction) {
          case DOWN:
            scrollwithCoordinates(0, scrollStart, 0, scrollEnd);
            break;
          case UP:
            scrollwithCoordinates(0, scrollEnd, 0, scrollStart);
            break;
          case LEFT:
            scrollwithCoordinates(sideScrollStart, 0, sideScrollEnd, 0);
            break;
          case RIGHT:
            scrollwithCoordinates(sideScrollEnd, 0, sideScrollStart, 0);
            break;
          default:
            TestAsserts.fail("Unable to recognize value for parameter 'Direction'");
        }
      }
    }
  }catch (Exception e){
    fail("Unable to Scroll",e);
  }
  }

  /**
   * Method to scroll through the listview for dropdowns in Android Application
   *
   * @param listView - The listview class identifier is passed to identify scroll location
   */
  public static void scrollListView(Element listView) {
    try {
      WebElement ele = waitForElement(listView, WAIT_CONDITIONS.VISIBLE, 10);
      Dimension listElementDimesion = ele.getSize();
      int elementHeight = listElementDimesion.getHeight();
      int elementXCordinate = ele.getLocation().getX() + ele.getSize().getWidth() / 2;
      int scrollStart = (int) (elementHeight * 0.80);
      int scrollEnd = (int) (elementHeight * 0.20);
      scrollwithCoordinates(elementXCordinate, scrollStart, elementXCordinate, scrollEnd);
    }catch (Exception e){
      fail("Failed to scroll the listview",listView,e);
    }
  }

  /**
   * Generic Scroll method to scroll in required direction with user specified count
   *
   * @param direction (expected values - UP,DOWN,LEFT,RIGHT)
   * @param count expects the number of times the scroll needs to be performed
   * @throws Exception
   * @implNote Please refrain from using large values for count as it will affect the performance of
   *     the script
   *
   */
  public void scroll(ScrollDirection direction, int count) {
  try {
  TouchAction touchAction = new TouchAction((AppiumDriver) DriverFactory.getDriver());
  Dimension dimensions = DriverFactory.getDriver().manage().window().getSize();
  boolean elementVisibleFlag = false;

  // VARIABLE DECLARATION
  Double screenHeightStart = 0.0;
  Double screenHeightEnd = 0.0;
  Double screenWidthStart = 0.0;
  Double screenWidthEnd = 0.0;
  int scrollStart = 0;
  int scrollEnd = 0;
  int sideScrollStart = 0;
  int sideScrollEnd = 0;

  // DIMENSIONS IDENTIFIED
  screenHeightStart = dimensions.getHeight() * 0.5;
  screenHeightEnd = dimensions.getHeight() * 0.2;
  screenWidthStart = dimensions.getWidth() * 0.5;
  screenWidthEnd = dimensions.getWidth() * 0.2;

  // CO-ORDINATES ST TO INT VALUE
  scrollStart = screenHeightStart.intValue();
  scrollEnd = screenHeightEnd.intValue();
  sideScrollStart = screenWidthStart.intValue();
  sideScrollEnd = screenWidthEnd.intValue();

  for (int i = 0; i < count; i++) {

    switch (direction) {
      case DOWN:
        scrollwithCoordinates(0, scrollStart, 0, scrollEnd);
        break;
      case UP:
        scrollwithCoordinates(0, scrollEnd, 0, scrollStart);
        break;
      case LEFT:
        scrollwithCoordinates(sideScrollStart, 0, sideScrollEnd, 0);
        break;
      case RIGHT:
        scrollwithCoordinates(sideScrollEnd, 0, sideScrollStart, 0);
        break;
      default:
        TestAsserts.fail("Unable to recognize value for parameter 'Direction'");
    }
  }
  }catch (AssertionError | Exception e){
    fail("Unable to scroll using co-ordinates",e);
  }
  }

  /**
   * Generic method to perform scroll based on co-ordinates
   *
   * @param startx
   * @param starty
   * @param endx
   * @param endy
   */
  private static void scrollwithCoordinates(int startx, int starty, int endx, int endy) {
    try {
      TouchAction touchAction = new TouchAction((AppiumDriver) DriverFactory.getDriver());
      touchAction
              .press(PointOption.point(startx, starty))
              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
              .moveTo(PointOption.point(endx, endy))
              .release()
              .perform();
    }catch (Exception e){
      fail("Unable to scroll with co-ordinates",e);
    }
  }

}
