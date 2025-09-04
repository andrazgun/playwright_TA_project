@regression
Feature: Search functionality

  Background:
    Given the customer opens Homepage

  @smoke
  Scenario: Search with a valid keyword
    When the customer searches for "lapte praf"
    Then the first 4 products displayed should related to "lapte praf"

  Scenario: Search with an invalid keyword
    When the customer searches for "xyz123"
    Then no search result list should be displayed
    And info message containing "nici un rezultat" is displayed

  Scenario: Search with autocomplete suggestions
    When the customer types "scutec" in the search bar
    Then the system should display autocomplete suggestions containing "scutec"
