Feature: As a User I want to search some employees

  Background:
    Given the user is on the main page
    When he enters username and password correctly
    And click Sign-in

  Scenario: As a User I want search Cecil  Bonaparte employee
    Given the user types his employee id "0029"
    When click on search button
    Then the user will see the basic employee information about "Fiona"

  Scenario: As a User I want search employees by Job Title
    Given the user select job title "Chief Financial Officer"
    When click on search button
    Then the user will see the basic employee information about "Peter Mac"


  Scenario: As a User I want search employees by name
    Given the user types his name "Fiona"
    When click on search button
    Then the user will see the basic employee information about "Fiona"