@regression @account
Feature: Account Page

  Background: Pre Conditions
    Given I log in
  @smoke
  Scenario: Account details
    When I click "Deconectare" from LHN
    Then Login button is displayed

  Scenario: Orders
    When I click "Comenzi" from LHN
    Then OrdersPage is displayed