Feature: Login validations
  As user, I want to sign-in with correct and wrong credentials to know if the Login is ok


Background:
  Given the user is on the main page

  Scenario: User supplies correct user name and password
    When he enters username and password correctly
    Then He will see the main page

  Scenario Outline: User supplies incorrect user name and password
    When he enters username "<username>" and password "<password>" incorrect
    Then He will see an error message "<message>"
    Examples:
      | username | password | message             |
      | test20   | test29   | Invalid credentials |