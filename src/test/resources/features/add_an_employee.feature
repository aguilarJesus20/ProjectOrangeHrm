Feature: Create a new employee
  As user, I want to create a new employee


  Background:
    Given the user is on the main page
    When he enters username and password correctly
    Given the user is on the "PIM" menu option
    And the user adds a new Employee

  Scenario:Creating an employee correctly without login details

    When he enters his personal information
    And the system saves his information
    Then He will see the message on page "Success"


  Scenario: Creating an employee with login details
    When he enters his personal information
    And he enters login details information with status "disable"
    And the system saves his information
    Then He will see the message on page "Success"


  Scenario Outline: Validating the message error Exceed is showing up on the new employee form page
    When he enters his "<firstName>" "<middleName>" "<lastName>" personal information
    Then he should see the message error "<message>"
    Examples:
      | firstName                           | middleName                          | lastName                            | message                         |
      | OctubreOctubreOctubreOctubreOctubre | Pablo                               | Perez                               | Should not exceed 30 characters |
      | Juan                                | OctubreOctubreOctubreOctubreOctubre | Perez                               | Should not exceed 30 characters |
      | Carlos                              | Pablo                               | OctubreOctubreOctubreOctubreOctubre | Should not exceed 30 characters |

  Scenario Outline: Validating the message error on Create Login Details Form Password Field
    When he enters password "<password>" login details form
    Then he should see the message error "<message>"
    Examples:
      | password | message                                                                                                                         |
      | test     | Should have at least 8 characters                                                                                               |
      | test2020 | Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password |


