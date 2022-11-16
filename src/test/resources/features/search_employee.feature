Feature: As a User I want to search some employees

  Background:
    Given the user is on the main page
    When he enters username and password correctly

  Scenario: As a User I want search Cecil  Bonaparte employee
    Given the user types his employee id "0029"
    When the user search his information in the system
    Then the user will see the basic employee information about "Fiona"

  Scenario: As a User I want search employees by Job Title
    Given the user select job title "Chief Financial Officer"
    When the user search his information in the system
    Then the user will see the basic employee information about "Peter Mac"


  Scenario: As a User I want search employees by name
    Given the user types his name "Fiona"
    When the user search his information in the system
    Then the user will see the basic employee information about "Fiona"