@UserRegister
@Smoke
Feature: All user types should be able to register when entering correct\existing information

  Background:
    Given I navigate to RegisterPage
    Then I am on the RegisterPage, within 5 seconds

#  @Positive
#  Scenario Outline: Unregistered user tries to Register with valid credentials
#    When I type "<firstName>" into RegisterPage FIRST_NAME
#    And I type "<lastName>" into RegisterPage LAST_NAME
#    And I type "<email>" into RegisterPage EMAIL
#    And I type "<password>" into RegisterPage PASSWORD
#    And I type "<confirm_password>" into RegisterPage CONFIRM_PASSWORD
#    And I click RegisterPage CREATE_ACCOUNT_BUTTON
#    Then I am on the MyAccountPage, within 5 seconds
#    And I see "<message>" in MyAccountPage MESSAGE
#
#
#    Examples:
#      | firstName | lastName | email              | password  | confirm_password | message                                            |
#      | First1    | Last1    | userTest9@123.xyz  | test1234! | test1234!        | Thank you for registering with Main Website Store. |
#      | First2    | Last2    | userTest10@123.xyz | Test1234! | test1234!        | Thank you for registering with Main Website Store. |
#

#  @Negative
#  Scenario Outline: Already register email cannot be used to Register again
#    When I type "<firstName>" into RegisterPage FIRST_NAME
#    And I type "<lastName>" into RegisterPage LAST_NAME
#    And I type "<existingEmail>" into RegisterPage EMAIL
#    And I type "<password>" into RegisterPage PASSWORD
#    And I type "<confirm_password>" into RegisterPage CONFIRM_PASSWORD
#    And I click RegisterPage CREATE_ACCOUNT_BUTTON
#    Then I see "<errorMessage>" in RegisterPage ALERT
#
#
#    Examples:
#      | firstName | lastName | existingEmail     | password  | confirm_password | errorMessage                                                                                                                                                 |
#      | First1    | Last1    | userTest1@123.xyz | test1234! | test1234!        | There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account. |

  @Negative
  Scenario Outline: Users should not be allowed to register with missing/incorrect fields e.g. error in <field>
    When I type "<firstName>" into RegisterPage FIRST_NAME
    And I type "<lastName>" into RegisterPage LAST_NAME
    And I type "<existingEmail>" into RegisterPage EMAIL
    And I type "<password>" into RegisterPage PASSWORD
    And I type "<confirm_password>" into RegisterPage CONFIRM_PASSWORD
    And I click RegisterPage CREATE_ACCOUNT_BUTTON
    Then I see error:"<errorMessage>" for "<field>" in the RegisterPage

    @Positive
    Examples:
      | firstName | lastName | existingEmail        | password  | confirm_password | field            | errorMessage                                                                                                                            |
      | First1    | Last1    |                      | test1234! | test1234!        | EMAIL            | This is a required field.                                                                                                               |
      | First1    | Last1    | userTest999@123.xyz1 | test1234  | test1234         | EMAIL            | Please enter a valid email address (Ex: johndoe@domain.com).                                                                            |
      | First1    |          | userTest999@123.xyz  | test1234! | test1234!        | LAST_NAME        | This is a required field.                                                                                                               |
      |           | Last1    | userTest999@123.xyz  | test1234! | test1234!        | FIRST_NAME       | This is a required field.                                                                                                               |
      | First1    | Last1    | userTest999@123.xyz  |           | test1234!        | PASSWORD         | This is a required field.                                                                                                               |
      | First1    | Last1    | userTest999@123.xyz  | test1234  | test1234         | PASSWORD         | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |
      | First1    | Last1    | userTest999@123.xyz  | test1234! |                  | CONFIRM_PASSWORD | This is a required field.                                                                                                               |
      | First1    | Last1    | userTest999@123.xyz  | test1234  | test12345        | CONFIRM_PASSWORD | Please enter the same value again.                                                                                                      |

