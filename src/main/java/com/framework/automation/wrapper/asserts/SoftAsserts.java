

package com.framework.automation.wrapper.asserts;

import org.assertj.core.api.SoftAssertions;

public class SoftAsserts {

  private static ThreadLocal<SoftAssertions> threadsafe_softassertion =
      ThreadLocal.withInitial(() -> new SoftAssertions());

  /**
   * Get a threadsafe soft assertions object
   *
   * @return
   */
  public static SoftAssertions softAssertion() {
    return threadsafe_softassertion.get();
  }

  /** Remove the thread */
  public static void removeThread() {
    threadsafe_softassertion.remove();
  }

  public static void assertAll() {
    SoftAsserts.softAssertion().assertAll();
  }

  /**
   * Example usage of Soft Assertions
   *
   * @param args
   */
  public static void main(String args[]) {
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(5).isEqualTo(5);
    softAssertions.assertThat(5).isEqualTo(5);
    if (softAssertions.errorsCollected().size() > 0) {
      softAssertions.assertAll();
    }
  }
}
