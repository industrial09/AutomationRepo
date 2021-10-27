Feature: This test is to validate musicxmatch flows

  Background: I login to musicxmatch app
    When I click on Iniciar sesion on landing page
    Then I enter my user credentials
    And I click on Iniciar sesion button

  Scenario: As I user I want to be able to log in to my account so that I can access my profile
    Given I go to my profile
    Then I verify my account data