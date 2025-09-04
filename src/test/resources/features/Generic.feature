@regression
Feature: Generic

  Background:
    Given the customer opens Homepage

  @smoke
  Scenario: FAQ How to order
    When the customer clicks Useful Info on Header
    And the customer clicks "Cum Comand" from Useful Info dropdown
    Then HowToOrder page is displayed
