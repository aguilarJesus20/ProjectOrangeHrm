Feature: As a user I want to create system user for the platform

  Background:
    Given the user is on the main page
    When he enters username and password correctly
    And click Sign-in

  Scenario Outline: I want to create a system user correctly and enable
    Given the user is on the "Admin" menu option
    When he fill in the system user form
    And selecting "<userRole>" role and "<status>"
    Then he should see the success message on the page
    Examples:
      | userRole | status |
      | Admin    | Enable |
