Feature: As a user I want to create or add a new vacancy in the Orange Hrm System

  Background:
    Given the user is on the main page
    When he enters username and password correctly

  Scenario: As a user I want to create a new vacancy correctly
    Given the user is on the "Recruitment" menu option
    When the user fill out the "Vacancies" form
      | vacancyName   | jobTitle          | description    | hiringManager | numberPositions |
      | Test Engineer | Software Engineer | AutomationTest | Lisa          | 3               |
    Then He will see the message on page "Success"


