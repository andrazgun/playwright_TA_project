Feature: Product browsing and cart management
  I want to browse products and manage my cart
  So that I can prepare my shopping

  Background:
    Given the customer opens Homepage

  @smoke
  Scenario: Add product to cart
    When the customer adds first product to cart
    Then message "Produsul a fost adaugat cu succes in cos." is displayed
    And product count "1" on cart icon is displayed on Header
    When the customer clicks cart on Header
    Then Product with quantity "1" is displayed on Header

    Scenario: Product category
      When the customer select product category "Ingrijire bebe si mama"
      And the customer select product category "Ingrijire bebelusi"
      And the customer select product category "Creme si produse de ingrijire bebe"
      Then Product category page "Creme si produse de ingrijire bebe" is displayed
      When the customer sorts the products by "Pret crescător"
      Then the products are sorted by price ascending