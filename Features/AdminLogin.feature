@AdminLogin
Feature: Admin Login

  Scenario: Admin should be able to login with valid credentials.
    Given Admin is on welcome page
    Then Swipe up to login
    When Admin enters valid credentials
    And Hits log in
    Then Admin should be logged in successfully

