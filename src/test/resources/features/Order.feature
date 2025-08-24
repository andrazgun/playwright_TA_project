#@regression @order
#Feature: Orders
#
#  Background: Pre Conditions
#    Given I log in
#    And I navigate to ShopPage
#
#  @smoke
#  Scenario: Add product to cart
#    When I click the first product
#    And I change the product quantity to "5"
#    And I click add to cart button on PdpPage
#    And I click cart on Header
##    And I click go to cart on SidePanel
#    And I navigate to CartPage
#    Then CartPage is displayed