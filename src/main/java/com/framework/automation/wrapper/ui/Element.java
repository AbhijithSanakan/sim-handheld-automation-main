

package com.framework.automation.wrapper.ui;

import com.framework.automation.framework.support.ApplicationProp;
import com.framework.automation.framework.support.DriverDataHolder;
import com.framework.automation.utils.TestUtil;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.text.MessageFormat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contain all the Element locator related operations
 *
 *
 */
public class Element {

  private String elementName;
  private String elementValue;
  private String elementType;
  public static final String XPATH = "XPATH";
  public static final String CSS = "CSS";
  public static final String ID = "ID";
  public static final String CLASS = "CLASS";
  public static final String NAME = "NAME";
  public static final String LINKTEXT = "LINKTEXT";
  public static final String PARTIALLINKTEXT = "PARTIALLINKTEXT";
  public static final String TAGNAME = "TAGNAME";
  public static final String ACCESSIBILITYID = "accessibilityId";
  public static final String IOSPREDICATE = "iosPredicate";
  public static final String IOSCLASSCHAIN = "iosPredicate";

  public Element(final String elementName, final String elementValue, final String elementType) {
    this.elementName = elementName;
    this.elementValue = elementValue;
    this.elementType = elementType;
  }

  /**
   * Constructor for Element wrapper
   *
   * @implNote To be used when there is no locator difference across different versions of iOS. Both
   *     IOS 13 and lower version will refer to the same locator
   * @param elementName
   * @param iOSValue
   * @param iOSType
   * @param androidValue
   * @param androidType
   */
  public Element(
      String elementName,
      String iOSValue,
      String iOSType,
      String androidValue,
      String androidType) {
      if (DriverDataHolder.getValue("Browser").equalsIgnoreCase("android")) {
        this.elementName = elementName;
        this.elementValue = androidValue;
        this.elementType = androidType;
      } else if (DriverDataHolder.getValue("Browser").equalsIgnoreCase("ios")) {
        this.elementName = elementName;
        this.elementValue = iOSValue;
        this.elementType = iOSType;
      }
  }


  /**
   * @param elementToReturn
   * @return
   */
  public static By getByObject(Element elementToReturn) {
    String elementType = elementToReturn.getElementType();
    String locatorValue = elementToReturn.getElementValue();
    By by = null;
    switch (elementType.toLowerCase()) {
      case "xpath":
        by = By.xpath(locatorValue);
        break;
      case "id":
        by = By.id(locatorValue);
        break;
      case "class":
        by = By.className(locatorValue);
        break;
      case "css":
        by = By.cssSelector(locatorValue);
        break;

      case "name":
        by = By.name(locatorValue);
        break;

      case "linktext":
        by = By.linkText(locatorValue);
        break;

      case "partiallink":
        by = By.partialLinkText(locatorValue);
        break;

      case "tagname":
        by = By.tagName(locatorValue);
        break;

      case "accessibilityid":
        by = MobileBy.AccessibilityId(locatorValue);
        break;

      case "iospredicate":
        by = MobileBy.iOSNsPredicateString(locatorValue);
        break;

      case "iosclasschain":
        by = MobileBy.iOSClassChain(locatorValue);
        break;
    }
    return by;
  }

  public static By returnBrowserElementFromRepo(String componentName, String locatorName) {
    By byElement = null;
    String elementType = null;
    String elementValue = null;
    try {
      Map<String, Object> selected_component;
      Map<String, Object> selected_control;
      if(!System.getProperty("repo").toLowerCase().contains("nativeapp")) {
        selected_component = TestUtil.RepositoryConfig(System.getProperty("repo"), componentName);
      }else{
        selected_component = TestUtil.RepositoryConfig(ApplicationProp.getValue("webRepo"), componentName);
      }
      selected_control = (Map<String, Object>) selected_component.get(locatorName);
      if (!DriverDataHolder.getValue("Platform").equalsIgnoreCase("desktop")) {
        if (DriverDataHolder.getValue("OS").equalsIgnoreCase("android") && DriverDataHolder.getValue("Platform").equalsIgnoreCase("mobile")) {
          elementType = selected_control.get("android_type").toString();
          elementValue = selected_control.get("android_value").toString();
        } else if (DriverDataHolder.getValue("OS").equalsIgnoreCase("android") && DriverDataHolder.getValue("Platform").equalsIgnoreCase("tablet")) {
          elementType = selected_control.get("androidtab_type").toString();
          elementValue = selected_control.get("androidtab_value").toString();
        } else if (DriverDataHolder.getValue("OS").equalsIgnoreCase("iOS") && DriverDataHolder.getValue("Platform").equalsIgnoreCase("mobile")) {
          elementType = selected_control.get("iOS_type").toString();
          elementValue = selected_control.get("iOS_value").toString();
        } else if (DriverDataHolder.getValue("OS").equalsIgnoreCase("iOS") && DriverDataHolder.getValue("Platform").equalsIgnoreCase("tablet")) {
          elementType = selected_control.get("ipad_type").toString();
          elementValue = selected_control.get("ipad_value").toString();
        } else {
          throw new Exception("Invalid Locator type for  - " + locatorName + " in component - " + componentName);
        }
      } else {
        String browser = DriverDataHolder.getValue("Browser").toLowerCase();
        switch (browser) {
          case "chrome":
            elementType = selected_control.get("chrome_type").toString();
            elementValue = selected_control.get("chrome_value").toString();
            break;
          case "firefox":
            elementType = selected_control.get("firefox_type").toString();
            elementValue = selected_control.get("firefox_value").toString();
            break;
          case "safari":
            elementType = selected_control.get("safari_type").toString();
            elementValue = selected_control.get("safari_value").toString();
            break;
          case "ie":
            elementType = selected_control.get("ie_type").toString();
            elementValue = selected_control.get("ie_value").toString();
            break;
          case "edge":
            elementType = selected_control.get("edge_type").toString();
            elementValue = selected_control.get("edge_value").toString();
            break;
          default:
            throw new Exception("Invalid Locator type for  - " + locatorName + " in component - " + componentName);
        }
      }
      switch (elementType.toLowerCase()) {
        case "xpath":
          byElement = By.xpath(elementValue);
          break;
        case "id":
          byElement = By.id(elementValue);
          break;
        case "class":
          byElement = By.className(elementValue);
          break;
        case "css":
          byElement = By.cssSelector(elementValue);
          break;
        case "name":
          byElement = By.name(elementValue);
          break;
        case "linktext":
          byElement = By.linkText(elementValue);
          break;
        case "partiallink":
          byElement = By.partialLinkText(elementValue);
          break;
        case "tagname":
          byElement = By.tagName(elementValue);
          break;
        case "accessibilityid":
          byElement = MobileBy.AccessibilityId(elementValue);
          break;
        case "iospredicate":
          byElement = MobileBy.iOSNsPredicateString(elementValue);
          break;
        case "iosclasschain":
          byElement = MobileBy.iOSClassChain(elementValue);
          break;
      }

    } catch (Exception e) {
      byElement = null;
      TestUtil.updateErrorDetailsToReport("Issue while getting the repo name for  " + componentName + "::" + locatorName,
              e.toString());
    }
    return byElement;
  }


  public static Element returnNativeAppElementFromRepo(String componentName, String locatorName) {
    Element element;
    String elementType;
    String elementValue;

    try {
      Map<String, Object> selected_component;
      Map<String, Object> selected_control;
      selected_component = TestUtil.RepositoryConfig(System.getProperty("repo"), componentName);
      selected_control = (Map<String, Object>) selected_component.get(locatorName);


      if (DriverDataHolder.getValue("Platform").equalsIgnoreCase("android")) {
        elementType = selected_control.get("android_type").toString();
        elementValue = selected_control.get("android_value").toString();
      } else if (DriverDataHolder.getValue("Platform").equalsIgnoreCase("ios")) {
        elementType = selected_control.get("ios_type").toString();
        elementValue = selected_control.get("ios_value").toString();
      } else {
        throw new Exception("Element type/Element Value  not defined");
      }


      switch (elementType.toLowerCase()) {
        case "xpath":
          elementType = Element.XPATH;
          break;
        case "id":
          elementType = Element.ID;
          break;
        case "class":
          elementType = Element.CLASS;
          break;
        case "name":
          elementType = Element.NAME;
          break;
        case "accessibilityid":
          elementType = Element.ACCESSIBILITYID;
          break;
        case "iospredicate":
          elementType = Element.IOSPREDICATE;
          break;
        case "iosclasschain":
          elementType = Element.IOSCLASSCHAIN;
          break;
        default:
          throw new Exception("Invalid Locator type for  - " + locatorName + " in component - " + componentName);
      }
      element = new Element(locatorName, elementValue, elementType);
    } catch (Exception e) {
      element = null;
      TestUtil.updateErrorDetailsToReport("Issue while getting the repo name for " + componentName + "::" + locatorName,
              e.toString());
    }
    return element;
  }



  /** @return the elementName */
  public String getElementName() {
    return elementName;
  }

  /** @param elementName the elementName to set */
  public void setElementName(String elementName) {
    this.elementName = elementName;
  }

  /** @return the elementValue */
  public String getElementValue() {
    return elementValue;
  }

  /** @param elementValue the elementValue to set */
  public void setElementValue(String elementValue) {
    this.elementValue = elementValue;
  }

  /** @return the elementType */
  public String getElementType() {
    return elementType;
  }

  /** @param elementType the elementType to set */
  public void setElementType(String elementType) {
    this.elementType = elementType;
  }
}
