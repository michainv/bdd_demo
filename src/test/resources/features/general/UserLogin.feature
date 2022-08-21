@UserLogin
Feature: All user types should be able to login when entering correct\existing information

  Background:
    Given I am on the LoginPage, with 5 seconds


  Scenario Outline: Whatever is on the LoginPage
    When I type "<email>" into LoginPage EMAIL
    And I type "<password>" into LoginPage PASSWORD
    And I click LoginPage SIGN_IN_BUTTON
    Then I am on the MyAccountPage, with 5 seconds

    @Positive
    Examples:
      | email                             | password  |
      | michalisvlachos98+test1@gmail.com | test1234! |