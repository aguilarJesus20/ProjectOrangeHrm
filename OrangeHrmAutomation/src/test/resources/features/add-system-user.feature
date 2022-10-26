Feature: As a user I want to create system user for the platform

  Background:
    Given the user is on the main page
    When he enters username and password correctly
    And click Sign-in

  Scenario Outline: I want to create a system user correctly and "<status>"
    Given the user is on the "Admin" menu option
    And he click on Add System user button
    When he fill in the system user form with "<userRole>" and status "<status>"
    Then He will see the message on page "Success"
    Examples:
      | userRole | status  |
      | Admin    | Enable  |
      | ESS      | Disable |
      | Admin    | Disable |
      | ESS      | Enable |
