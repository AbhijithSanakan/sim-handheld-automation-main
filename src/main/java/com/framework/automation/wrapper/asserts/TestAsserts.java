

package com.framework.automation.wrapper.asserts;

import org.assertj.core.api.Assertions;
import org.testng.Assert;

import java.util.List;

/**
 * TestAsserts class will hold all the methods that can be used for validations
 *
 * @author - AAP COE Automation Team
 */
public class TestAsserts {

  /**
   * AssertJ fail method wrapper.
   *
   */
  public static void assertCheck(String actualText, String expectedText) {
      Assert.assertEquals(actualText, expectedText);
      System.out.println(actualText + " is visible");
  }

  public static void fail(String message) {
    Assertions.fail(message);
  }

  /**
   * AssertJ fail method wrapper.
   *
   * @param message
   */
  public static void fail(String message, Throwable e) {
    Assertions.fail(message, e);
  }

  /**
   * Verify two integer values are equal
   *
   * @param actualValue
   * @param expectedValue
   */
  public static void assertEquals(Integer actualValue, Integer expectedValue) {
    Assert.assertEquals(actualValue, expectedValue);
  }

  /**
   * Validate whether the expected string is part of another string by converting both strings to
   * lowercase
   *
   * @param actualText
   * @param expectedText
   */
  public static void assertTextContainsIgnoreCase(String actualText, String expectedText) {
    Assert.assertTrue(
        actualText.trim().toLowerCase().contains(expectedText.trim().toLowerCase()),
        "expected text " + expectedText + " is not present in the actual text " + actualText);
  }

  /**
   * Validate whether an expected string matches with the another string
   *
   * @param actualText
   * @param expectedText
   */
  public static void assertEquals(String actualText, String expectedText) {
    Assert.assertTrue(
        actualText.trim().equalsIgnoreCase(expectedText.trim()),
        "expected text " + expectedText + " does not match the actual text " + actualText);
  }

  /**
   * Validate a string is not present in the list of strings
   *
   * @param textToBeValidated
   * @param listOfText
   */
  public static void validateTextNotPresentInList(
      String textToBeValidated, List<String> listOfText) {
    for (String text : listOfText) {
      if (text.equalsIgnoreCase(textToBeValidated)) {
        TestAsserts.fail(
            ""
                + textToBeValidated
                + " is present in the list of text :"
                + listOfText
                + " which is not expected.");
      }
    }
  }

  /**
   * Validate whether an expected string is contained in another string. This comparison is case
   * sensitive
   *
   * @param actualText
   * @param expectedText
   * @see #assertTextContainsIgnoreCase
   */
  public static void assertTextContains(String actualText, String expectedText) {
    Assert.assertTrue(
        actualText.contains(expectedText),
        "expected text " + expectedText + " is not present in the actual text " + actualText);
  }

  /**
   * Verify that the given condition is either satisfies either true / false. If not, fail the
   * condition with a custom / specified error message.
   *
   * <p>NOTE: The param conditionIndicator here indicates more of a branching term to pick the
   * respective check - assertTrue / assertFalse. This is not the actual condtionToCheck which will
   * come as part of the conditionToCheck param.
   *
   * <p>Usage:
   *
   * <pre>
   * assertCondition(true,X==Y,"X is not equal Y as expected");
   * assertCondition(false,X==Y,"X is equal Y which is not expected");
   * </pre>
   *
   * @param conditionIndicator
   * @param conditionToCheck
   * @param customErrorMessage
   */
  public static void assertCondition(
      boolean conditionIndicator, boolean conditionToCheck, String customErrorMessage) {
    if (conditionIndicator) {
      Assert.assertTrue(conditionToCheck, customErrorMessage);
    } else {
      Assert.assertFalse(conditionToCheck, customErrorMessage);
    }
  }
}
