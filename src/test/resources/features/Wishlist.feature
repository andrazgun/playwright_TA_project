@smoke
Feature: Wishlist management
  As a logged-in customer
  I want to manage my wishlist
  So that I can save products for later

  Background:
    Given the customer is logged in
    When the customer clicks main icon

  Scenario: Add and remove product from wishlist
    When the customer adds a product to wishlist named favorite
    And the customer clicks the wishlist icon on Header
    Then WishlistPage is displayed
    When the customer selects wishlist "Favorite"
    Then the wishlist should contain at least 1 products
    When the customer removes all the products from the wishlist
    Then the wishlist should be empty
