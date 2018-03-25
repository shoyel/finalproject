Feature: Saksfifthavenue login functionality
  Background:
    Given Not a validated user
    When user borwse to the site
    Then saksfifthavenue home page display
    And user close pop up
    When User click Sign In link
    Then Browser display Sign In page


  Scenario: 1. Valid user with valid password

    When User enter user email as "shoyel1516@gmail.com"
    And User enter user password as "Aasim0619!"
    And user click SIGN IN button
    Then Home page should display
    And Welcome message display


  Scenario: 2. Valid user with valid password -Admin

    When User enter user email as "doverave@yahoo.com"
    And User enter user password as "Lo0ve101!"
    And user click SIGN IN button
    Then Home page should display
    And Welcome message display

    Scenario Outline: 3. Valid user with valid password -Data Driven

      When User enter user email as "<EmailAddress>"
      And User enter user password as "<Password>"
      And user click SIGN IN button
      Then Home page should display
      And Welcome message display
      Examples:
        |EmailAddress         |Password|
        |doverave@yahoo.com   |Lo0ve101!|
        |shoyel1516@gmail.com |Aasim0619!|
