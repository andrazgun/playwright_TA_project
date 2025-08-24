@smoke
Feature: Search functionality
  As a logged-in customer
  I want to use the search functionality
  So that I can quickly find products

  Background:
    Given the customer is logged in

  Scenario: Search with a valid keyword
    When the customer searches for "lapte praf"
    Then the search results should display products related to "lapte praf"

  Scenario: Search with an invalid keyword
    When the customer searches for "xyz123"
    Then no search result list should be displayed
    And info message containing "nici un rezultat" is displayed

  Scenario: Search with autocomplete suggestions
    When the customer types "scutec" in the search bar
    Then the system should display autocomplete suggestions containing "scutec"
