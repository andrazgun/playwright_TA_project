@smoke
Feature: Product browsing and cart management
  I want to browse products and manage my cart
  So that I can prepare my shopping

  Background:
    Given the customer opens Homepage

  Scenario: Navigate to a category
    When the customer adds first product to cart
    Then Message "Produsul a fost adaugat cu succes in cos." is displayed

#    When the customer navigates to category "Produse copii"
#    Then the category page should display subcategories and products

#  Scenario: Filter products by price range
#    When the customer applies a price range filter "10 - 50 RON"
#    Then only products within the range should be displayed
#
#  Scenario: Filter products by brand
#    When the customer filters products by brand "Nestle"
#    Then only products from "Nestle" should be displayed
#
#  Scenario: Sort products by price ascending
#    When the customer sorts products by "Price: Low to High"
#    Then the products should be displayed in ascending order of price
#
#  Scenario: Sort products by price descending
#    When the customer sorts products by "Price: High to Low"
#    Then the products should be displayed in descending order of price
#
#  Scenario: View product details
#    When the customer opens a product detail page
#    Then product title, image, price, and description should be displayed
#
#  Scenario: Check stock availability
#    When the customer views a product detail page
#    Then stock status should be displayed as "In stock" or "Out of stock"
#
#  Scenario: Add product to cart from category page
#    When the customer adds a product to the cart from the category listing
#    Then the product should be displayed in the mini-cart
#
#  Scenario: Add product to cart from product page
#    When the customer adds a product to the cart from the product detail page
#    Then the product should be displayed in the mini-cart
#
#  Scenario: Update product quantity in the cart
#    Given the customer has a product in the cart
#    When the customer increases the product quantity
#    Then the cart total should update correctly
#
#  Scenario: Remove product from the cart
#    Given the customer has a product in the cart
#    When the customer removes the product
#    Then the product should no longer be displayed in the cart
