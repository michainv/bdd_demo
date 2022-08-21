@UserRegister
Feature: All user types should be able to register when entering correct\existing information

  Background:
    Given I navigate to RegisterPage
    Then I am on the RegisterPage, within 5 seconds

  Scenario Outline: What ever register the
    When I type "<firstName>" into RegisterPage FIRST_NAME
    When I type "<lastName>" into RegisterPage LAST_NAME
    When I type "<email>" into RegisterPage EMAIL
    When I type "<password>" into RegisterPage PASSWORD
    When I type "<confirm_password>" into RegisterPage CONFIRM_PASSWORD
    And I click RegisterPage CREATE_ACCOUNT_BUTTON
    Then I am on the MyAccountPage, within 5 seconds
    And I see "<message>" in MyAccountPage MESSAGE

    @Positive
    Examples:
      | firstName | lastName | email              | password  | confirm_password | message                                            |
      | test1     | last1    | what456f12@123.xyz | test1234! | test1234!        | Thank you for registering with Main Website Store. |