@smoke
Feature: Wishlist management

  Background:
    Given the customer opens Homepage

  Scenario: Add and remove product from wishlist for Guest
    When the customer clicks add to list on first product
    Then LoginPage is displayed
