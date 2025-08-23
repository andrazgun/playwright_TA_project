@regression @login
Feature: Login Page

  Background: Pre Conditions
    Given I navigate to LoginPage

  @smoke
  Scenario: Login button
    Then Login button is displayed
    And Register link is displayed

  Scenario Outline: Validate valid & invalid login credentials
    When I type a user name '<username>' and a password '<password>'
    And I click on the login button
    Then Error message with text '<text>' is displayed
    Examples:
      | username             | password        | text                                                                                    |
      |                      |                 | Numele de utilizator este obligatoriu.                                                  |
      | agtest1@yopmail.com  |                 | câmpul parolă este gol.                                                                 |
      | agtest12@yopmail.com | <c/Z2+:Vc4[~    | Adresă de email necunoscută. Verifică din nou sau încearcă cu numele tău de utilizator. |
      | agtest1@yopmail.com  | <c/Z2+:Vc4[~555 | parola pe care ai introdus-o pentru adresa de email agtest1@yopmail.com este incorectă. |