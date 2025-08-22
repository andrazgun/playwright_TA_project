@regression @login
Feature: Login Page

  Background: Pre Conditions
    Given I navigate to LoginPage

  @smoke
  Scenario: Login button
    Then Login button is displayed
    And Register link is displayed

#  @smoke
#  Scenario Outline: Validate valid & invalid login credentials
#    Given I navigate to HomePage
#    When I click on the login portal button
#    And I type a user name '<username>' and a password '<password>'
#    And I click on the login button
#    Then I should be presented with an alert box which contains text '<expectedAlertText>'
#    Examples:
#      | username  | password     | expectedAlertText    |
#      |           |              | validation failed5    |
#      | webdriver |              | validation failed    |
#      |           | webdriver123 | validation failed    |
#      | webdriver | webdriver123 | validation succeeded |