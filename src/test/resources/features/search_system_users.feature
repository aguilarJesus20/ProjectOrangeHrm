Feature: As user I want to search system users

  Background:
    Given the user is on the main page
    When he enters username and password correctly
    Given the user is on the "Admin" menu option
  Scenario Outline: I want to search an user into system users by <userName>
    When he write his information "<userName>"
    Then he should see his personal information "<name>"
    Examples:
      | userName     | name             |
      | Admin        | Richard Collings |


  Scenario Outline: I want to search an user into system users by <userRole> and <userName>
    When he select his userRole "<userRole>" and "<userName>"
    Then he should see his personal information "<nameTable>"
    Examples:
      | userName     | userRole | nameTable        |
      | Admin        | Admin    | Richard Collings |

  Scenario Outline: I want to search an user into system users by status "<status>" and "<userName>"
    When he select his status information "<status>" and "<userName>"
    Then he should see his personal information "<nameTable>"
    Examples:
      | userName  | status   | nameTable        |
      | Admin     | Enabled  | Richard Collings |