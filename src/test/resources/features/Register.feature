@regression @register
Feature: Register Page

  Background: Pre Conditions
    Given I navigate to RegisterPage

  @smoke
  Scenario: Valid Registration Form Submission
    When I fill the registration form
    And I click Register button
    Then Message "Thank you for registering with Main Website Store." is displayed on AccountPage

#  Scenario: Invalid Contact Us Form Submission
#    When I type a last name
#    And I enter an email address
#    And I type a comment
#    And I click on the submit button
#    Then I should be presented with a unsuccessful contact us submission message
#
#  Scenario: Invalid Contact Us Form Submission - Using Specific Data
#    When I type a specific first name "Sarah"
#    And I type a specific last name "Woods"
#    And I enter a specific email address "sarah_woods@example.com"
#    And I type specific text "Hello" and number 123 within the comment input field
#    And I click on the submit button
#    Then I should be presented with a successful contact us submission message
#
#    @wip
#  Scenario: Valid Contact Us Form Submission - Using Random Data
#    When I type a random first name
#    And I type a random last name
#    And I enter a random email address
##    And I type a comment
#    And I type a random comment
#    And I click on the submit button
#    Then I should be presented with a successful contact us submission message
#
#  @smoke
#  Scenario Outline: Validate Contact Us Page
#    When I type a first name <firstName> and a last name <lastName>
#    And I type a email address '<emailAddress>' and a comment '<comment>'
#    And I click on the submit button
#    Then I should be presented with header text '<message>'
#    Examples:
#      | firstName | lastName | emailAddress       | comment           | message                      |
#      | John      | Doe      | john_doe@email.com | hello how are you | Thank You for your Message!  |
#      | Mia       | Carter   | mia12@email.com    | Test 123          | Thank You for your Message!  |
#      | Grace     | Hud      | grace hud112       | Nothing to add    | Error: Invalid email address |