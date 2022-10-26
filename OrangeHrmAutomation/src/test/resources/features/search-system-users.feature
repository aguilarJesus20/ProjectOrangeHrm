Feature: As user I want to search system users

  Background:
    Given the user is on the main page
    When he enters username and password correctly
    And click Sign-in

  Scenario Outline: I want to search an user into system users by <userName>
    Given the user is on the "Admin" menu option
    When he write his information "<userName>"
    And he clicks on search button
    Then he should see his personal information "<name>"
    Examples:
      | userName     | name             |
      | Admin        | Richard Collings |


  Scenario Outline: I want to search an user into system users by <userRole> and <userName>
    Given the user is on the "Admin" menu option
    When he select his userRole "<userRole>" and "<userName>"
    And he clicks on search button
    Then he should see his personal information "<nameTable>"
    Examples:
      | userName     | userRole | nameTable        |
      | Admin        | Admin    | Richard Collings |

  Scenario Outline: I want to search an user into system users by status "<status>" and "<userName>"
    Given the user is on the "Admin" menu option
    When he select his status information "<status>" and "<userName>"
    And he clicks on search button
    Then he should see his personal information "<nameTable>"
    Examples:
      | userName  | status   | nameTable        |
      | Admin     | Enabled  | Richard Collings |