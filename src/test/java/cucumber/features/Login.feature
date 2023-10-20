Feature: Login Saucedemo Web

  Scenario: Success Login
    Given Login Page Saucedemo Web
    When User input registered username
    And User input registered password
    And User click login button
    Then List product page displayed

  Scenario: Failed Login
    Given Login Page Saucedemo Web
    When User input registered username
    And User input unregistered password
    And User click login button
    Then Error login message displayed