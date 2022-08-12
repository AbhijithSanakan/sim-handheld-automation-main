

package com.framework.automation.wrapper.ui;

import com.framework.automation.drivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.fail;

/**
 * Utility class to wait for elements to load. Internally uses the selenium {@link Wait} class
 *
 *
 */
public class Waits {

  /** Conditions for waiting */
  public enum WAIT_CONDITIONS {
    CLICKABLE,
    VISIBLE
  }



  /**
   * Waits for an element to meet the condition in parameter for the time mentioned in wait_time
   *
   * @param inputElement
   * @param condition
   * @return
   */
  public static WebElement waitForElement(WebElement inputElement, WAIT_CONDITIONS condition) {

    WebElement elementToReturn;
    try {
      switch (condition) {
        case CLICKABLE:
          elementToReturn = (WebElement) DriverFactory.getWaits().until(ExpectedConditions.elementToBeClickable(inputElement));
          break;
        case VISIBLE:
          elementToReturn = (WebElement) DriverFactory.getWaits().until(ExpectedConditions.visibilityOf(inputElement));
          break;
        default:
          elementToReturn = null;
          fail("Condition for wait is not supported");
          break;
      }

    } catch (TimeoutException e) {
      elementToReturn = null;
      fail("Timed out waiting for element - " + inputElement, e);
    }
    catch (Exception e){
      elementToReturn = null;
      e.printStackTrace();
      fail("An Exfeption ocured in the method - " + inputElement, e);
    }
    return elementToReturn;
  }
  /**
   * Waits for an element to meet the condition in parameter for the time mentioned in wait_time
   *
   * @param inputElement
   * @param condition
   * @return
   */
  public static WebElement waitForElement(Element inputElement, WAIT_CONDITIONS condition) {

    WebElement elementToReturn;
    try {
      switch (condition) {
        case CLICKABLE:
          elementToReturn = (WebElement) DriverFactory.getWaits().until(ExpectedConditions.elementToBeClickable(Element.getByObject(inputElement)));
          break;
        case VISIBLE:
          elementToReturn = (WebElement) DriverFactory.getWaits().until(ExpectedConditions.visibilityOfElementLocated(Element.getByObject(inputElement)));
          break;
        default:
          elementToReturn = null;
          fail("Condition for wait is not supported");
          break;
      }

    } catch (TimeoutException e) {
      elementToReturn = null;
      fail("Timed out waiting for element - " + inputElement, e);
    }
    catch (Exception e){
      elementToReturn = null;
      e.printStackTrace();
      fail("An Exfeption ocured in the method - " + inputElement, e);
    }
    return elementToReturn;
  }

  /**
   * Waits for an element to meet the condition in parameter for the time mentioned in wait_time
   *
   * @param inputElement
   * @param condition
   * @param WaitTime
   * @return
   */
  public static WebElement waitForElement(WebElement inputElement, WAIT_CONDITIONS condition, int WaitTime) throws Exception {
    Wait wait_custom = DriverFactory.getWaits(WaitTime);
    WebElement elementToReturn;
    try {
      switch (condition) {
        case CLICKABLE:
          elementToReturn = (WebElement) wait_custom.until(ExpectedConditions.elementToBeClickable(inputElement));
          break;
        case VISIBLE:
          elementToReturn = (WebElement) wait_custom.until(ExpectedConditions.visibilityOf(inputElement));
          break;
        default:
          elementToReturn = null;
          fail("Condition for wait is not supported");
          break;
      }

    } catch (TimeoutException e) {
      elementToReturn = null;
      fail("Timed out waiting for element - " + inputElement, e);
    }
    return elementToReturn;
  }
  /**
   * Waits for an element to meet the condition in parameter for the time mentioned in wait_time
   *
   * @param inputElement
   * @param condition
   * @param WaitTime
   * @return
   */
  public static WebElement waitForElement(Element inputElement, WAIT_CONDITIONS condition, int WaitTime) throws Exception {
    Wait wait_custom = DriverFactory.getWaits(WaitTime);
    WebElement elementToReturn;
    try {
      switch (condition) {
        case CLICKABLE:
          elementToReturn = (WebElement) wait_custom.until(ExpectedConditions.elementToBeClickable(Element.getByObject(inputElement)));
          break;
        case VISIBLE:
          elementToReturn = (WebElement) wait_custom.until(ExpectedConditions.visibilityOfElementLocated(Element.getByObject(inputElement)));
          break;
        default:
          elementToReturn = null;
          fail("Condition for wait is not supported");
          break;
      }

    } catch (TimeoutException e) {
      elementToReturn = null;
      fail("Timed out waiting for element - " + inputElement, e);
    }
    return elementToReturn;
  }

  /**
   * Wait until element is not visible
   *
   * @param inputElement
   * @return
   */
  public static boolean waitForElementToBeInvisible(WebElement inputElement){
    boolean isVisible;
    try {
      isVisible = (boolean) DriverFactory.getWaits().until(ExpectedConditions.invisibilityOf(inputElement));
    } catch (Exception e) {
      isVisible = false;
    }
    return isVisible;
  }



  /**
   * Wait for expected number of windows to be visible
   *
   * @param expectedWindowCount
   */
  public static void waitForWindowToBeVisible(int expectedWindowCount, int WaitTime) throws Exception {
    WebDriverWait wait_custom = new WebDriverWait(DriverFactory.getDriver(), WaitTime);
    wait_custom.until(ExpectedConditions.numberOfWindowsToBe(expectedWindowCount));
  }
  /**
   * Wait for a frame to be available and switch to the frame
   *
   * @param inputElement
   * @param timeToWait
   */
  public static void waitForFrameToBeAvailableAndSwitchToFrame(WebElement inputElement, int timeToWait) throws Exception {
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeToWait);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(inputElement));
  }
}
