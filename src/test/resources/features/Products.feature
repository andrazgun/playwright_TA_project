@smoke
Feature: Product browsing and cart management
  I want to browse products and manage my cart
  So that I can prepare my shopping

  Background:
    Given the customer opens Homepage

  Scenario: Navigate to a category
    When the customer adds first product to cart
    Then message "Produsul a fost adaugat cu succes in cos." is displayed
    And product count "1" on cart icon is displayed on Header
    When the customer clicks cart on Header
    Then Product with quantity "1" is displayed on Header