

package com.framework.automation.wrapper.ui;

import com.framework.automation.drivers.DriverFactory;
import com.framework.automation.framework.support.DriverDataHolder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.fail;

/**
 * CommonAction class will hold all actions like click, type, select etc. All actions should return
 * back the action class so that we can call the actions at page level
 *
 *
 */
public class CommonAction extends Waits{


  public enum WINDOW_HANDLE_KEY {
    CHILD,
    PARENT
  };




  /**
   * Find the element inputElement from the DOM structure
   *
   * @param inputElement
   * @return
   */
  protected static WebElement findElement(By inputElement) {
    try {
      ArrayList<WebElement> webElements =
          (ArrayList<WebElement>) DriverFactory.getDriver().findElements(inputElement);
      if (webElements.size() < 1) {
        fail("No elements were found in DOM for " + inputElement);
      } else if (webElements.size() > 1) {
        fail("More than one element was found for " + inputElement + " in DOM.");
      } else {
        return webElements.get(0);
      }
    } catch (Exception exception) {
      fail("Finding element " + inputElement + " failed.", exception);
    }
    return null;
  }

  /**
   * Click on an element specified by elementToClick
   *
   * @param elementToBeClicked
   * @return
   */
  public static void click(WebElement elementToBeClicked) {
    try {
      waitForElement(elementToBeClicked, WAIT_CONDITIONS.CLICKABLE).click();
    } catch (Exception e) {
      fail("Could not click on element - " + elementToBeClicked, e);
    }
  }

  /**
   * Type the text keysToSend on the element inputElement
   *
   * @param inputElement
   * @param keysToSend
   * @return
   */
  public static void type(WebElement inputElement, String keysToSend) {
    try {
      WebElement elementToActOn =
          waitForElement(inputElement, WAIT_CONDITIONS.CLICKABLE);
      elementToActOn.clear();
      elementToActOn.sendKeys(keysToSend);
    } catch (Exception e) {
      fail("Could not type on element - " + inputElement, e);
    }
  }

  /**
   * Check for the visibility of an element in DOM structure
   *
   * @param inputElement
   * @return
   */
  public static boolean isElementDisplayed(WebElement inputElement) {
    try {
      return waitForElement(inputElement,WAIT_CONDITIONS.VISIBLE).isDisplayed();
    } catch (AssertionError e) {
      return false;
    }
  }

  /**
   * Check for the visibility of an element with an additional waitTime
   *
   * @param inputElement
   * @return
   */
  public static boolean isElementDisplayed(WebElement inputElement, int waitTime) {
    try {
      return waitForElement(inputElement, WAIT_CONDITIONS.VISIBLE, waitTime)
          .isDisplayed();
    } catch (AssertionError | Exception e) {
      return false;
    }
  }

  /**
   * Method to clear content of text input fields
   *
   * @param inputElement
   * @return
   */
  public static void clear(WebElement inputElement) {
    try {
      waitForElement(inputElement,WAIT_CONDITIONS.CLICKABLE,5).clear();
    } catch (Exception exception) {
      exception.printStackTrace();
      fail("Could not clear the text field - " + inputElement, exception);
    }
  }

  /**
   * Retrieve the text value of the element
   *
   * @param inputElement
   * @return
   */
  public static String getText(WebElement inputElement) {
    String elementText = "";
    try {
      elementText = waitForElement(inputElement, WAIT_CONDITIONS.VISIBLE).getText();

    } catch (Exception e) {
      fail(
          "Error occured while retrieving the text of the element - "
              + inputElement,
          e);
    }
    return elementText;
  }

  /**
   * Get the text as String array list from all elements that match the inputElement
   *
   * @param inputElement
   * @return
   */
  public static List<String> getTextFromList(By inputElement) {
    List<String> listOfWebElementText = new ArrayList<String>();
    List<WebElement> webElements;
    try {
      webElements = DriverFactory.getDriver().findElements(inputElement);
    if (webElements.size() > 1) {
      for (WebElement element : webElements) {
        listOfWebElementText.add(element.getText());
      }
      return listOfWebElementText;
    }
    } catch (Exception exception) {
      fail(
              "Error occured while retrieving text from list- "
                      + inputElement,
              exception);
    }
    return listOfWebElementText;
  }

  /**
   * Get the attribute from inputElement from the DOM structure
   *
   * @param inputElement
   * @param attribute
   * @return
   */
  public static String getAttribute(WebElement inputElement, String attribute) {
    String attributeValue = "";
    try {
      attributeValue =
          waitForElement(inputElement, WAIT_CONDITIONS.VISIBLE).getAttribute(attribute);

    } catch (Exception e) {
      fail(
          "Error occured while retrieving the attribute value of the element - "
              + inputElement,
          e);
    }
    return attributeValue;
  }

  /**
   * Get the count of elements identified with the given locator
   *
   * @author - AAP COE Automation Team
   * @param inputElement
   * @return
   */
  public static int getElementCount(By inputElement) throws Exception {
    List<WebElement> webElements =
        (List<WebElement>) DriverFactory.getDriver().findElements(inputElement);
    int i = webElements.size();
    return i;
  }

  public static void mouseOver(WebElement inputElement) {
    try {
      if (DriverDataHolder.getValue("Browser").equalsIgnoreCase("safari")) {
        Actions action = new Actions(DriverFactory.getDriver());
        action.moveToElement(inputElement).build().perform();
      } else {
        String mouseOverScript =
                "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',"
                        + "true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject)"
                        + "{ arguments[0].fireEvent('onmouseover');}";
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript(mouseOverScript, inputElement);
      }
    }catch (Exception e){
      fail(
              "Error occured during mouse hover - "
                      + inputElement,
              e);
    }
  }

  /**
   * Get all options / values from a select / drop down element
   *
   * @param inputElement
   * @return returns the Drop down options / values as a list of web elements
   */
  public List<WebElement> getAllOptionsFromDropDown(WebElement inputElement) {

    Select select = new Select(inputElement);
    List<WebElement> options = select.getOptions();
    return options;
  }

  public static void scrolltoPageEnd() throws Exception  {
    WebDriver driver = DriverFactory.getDriver();
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("scroll(0, document.body.scrollHeight);");
  }

  /**
   * Waits for the page load with 2 mins as timeout
   */
  public static void waitForPageLoad() throws Exception  {
    WebDriver driver = DriverFactory.getDriver();
    if (!DriverDataHolder.getValue("Browser").equalsIgnoreCase("app"))
      try {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(driver1 -> String.valueOf(
                ((JavascriptExecutor) driver1)
                        .executeScript("return document.readyState;"))
                .equals("complete"));
        System.out.println("PAGE LOAD COMPLETED");
      } catch (Exception e) {
        e.printStackTrace();
        fail("Failed to wait for page load",e);

      }
  }

  /**
   * Invokes thread to sleep for 5 seconds
   */
  public static void intentionalSleep() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

    /**
     * Launches the url from the config file
     *
     * @param url
     */
    public static void launchbaseURL(String url) {
      try {
        System.out.println("Launching URL...");
        WebDriver driver = DriverFactory.getDriver();
        driver.get(url);
        System.out.println("BASE URL Launched...");
        if(!(CommonAction.isMobileWebTest() | CommonAction.isNativeAppTest())) {
          driver.manage().window().maximize();
        }
        System.out.println("Maximized the Application...");

      } catch (Exception e) {
        e.printStackTrace();
        fail("Unable to luanch the base URL - " +url,e);
      }
    }

    public static boolean isNativeAppTest(){
      if(DriverDataHolder.getValue("Platform").toLowerCase().contains("ios") | DriverDataHolder.getValue("Platform").toLowerCase().contains("android")){
        return true;
      }else{
        return false;
      }
    } public static boolean isMobileWebTest(){
    System.out.println(DriverDataHolder.getValue("Platform"));
      if(DriverDataHolder.getValue("Platform").toLowerCase().contains("mobile") | DriverDataHolder.getValue("Platform").toLowerCase().contains("tablet")){
        return true;
      }else{
        return false;
      }
    }
  }

