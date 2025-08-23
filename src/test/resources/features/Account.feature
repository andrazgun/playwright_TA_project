@regression @account
Feature: Account Page

  Background: Pre Conditions
    Given I navigate to LoginPage

  @smoke
  Scenario: Account details
    When I log in
    And I click "Deconectare" from LHN
    Then Login button is displayed

  Scenario: Orders
    When I log in
    And I click "Comenzi" from LHN
    Then OrdersPage is displayed