@UserLogin
@Smoke
Feature: Users should be able to login when entering correct\existing information

  Background:
    Then I am on the LoginPage, within 5 seconds


  Scenario Outline: Login using correct credentials
    When I type "<email>" into LoginPage EMAIL
    And I type "<password>" into LoginPage PASSWORD
    And I click LoginPage SIGN_IN_BUTTON
    Then I am logged in, within 5 seconds


    @Positive
    Examples:
      | email             | password  |
      | userTest1@123.xyz | test1234! |

  @Negative
  Scenario Outline: Login using incorrect credentials
    When I type "<email>" into LoginPage EMAIL
    And I type "<password>" into LoginPage PASSWORD
    And I click LoginPage SIGN_IN_BUTTON
    Then I am not logged in, within 5 seconds
    Then I see error alert:"<errorMessage>" in the LoginPage


    Examples:
      | email                 | password   | errorMessage                                                                                                |
      | userTest1@123.xyz     | wrongpass! | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |

  @Negative
  Scenario Outline: Login with missing or invalid fields
    When I type "<email>" into LoginPage EMAIL
    And I type "<password>" into LoginPage PASSWORD
    And I click LoginPage SIGN_IN_BUTTON
    Then I am not logged in, within 2 seconds
    Then I see error:"<errorMessage>" for "<field>" in the LoginPage


    Examples:
      | email              | password   | errorMessage                                                 | field    |
      | notvalidformat     | wrongpass! | Please enter a valid email address (Ex: johndoe@domain.com). | EMAIL    |
      |                    | wrongpass! | This is a required field.                                    | EMAIL    |
      | wrongEmail@123.xyz |            | This is a required field.                                    | PASSWORD |