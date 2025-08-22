@regression @account
Feature: Account Page

  Background: Pre Conditions
    Given I navigate to LoginPage

  @smoke
  Scenario: Account details
    When I log in
    And I click the nav item "Deconectare"
    Then Login button is displayed