@UserRegister
Feature: All user types should be able to register when entering correct\existing information

  Background:
    Given I navigate to RegisterPage
    Then I am on the RegisterPage, within 5 seconds

  Scenario Outline: What ever register the
    When I type "<firstName>" into RegisterPage FIRST_NAME
    And I type "<lastName>" into RegisterPage LAST_NAME
    And I type "<email>" into RegisterPage EMAIL
    And I type "<password>" into RegisterPage PASSWORD
    And I type "<confirm_password>" into RegisterPage CONFIRM_PASSWORD
    And I click RegisterPage CREATE_ACCOUNT_BUTTON
    Then I am on the MyAccountPage, within 5 seconds
    And I see "<message>" in MyAccountPage MESSAGE

    @Positive
    Examples:
      | firstName | lastName | email             | password  | confirm_password | message                                            |
      | First1    | Last1    | userTest1@123.xyz | test1234! | test1234!        | Thank you for registering with Main Website Store. |
      | First2    | Last2    | userTest2@123.xyz | test1234! | test1234!        | Thank you for registering with Main Website Store. |
      | First3    | Last3    | userTest3@123.xyz | test1234! | test1234!        | Thank you for registering with Main Website Store. |
      | First4    | Last4    | userTest4@123.xyz | test1234! | test1234!        | Thank you for registering with Main Website Store. |
      | First5    | Last5    | userTest5@123.xyz | test1234! | test1234!        | Thank you for registering with Main Website Store. |