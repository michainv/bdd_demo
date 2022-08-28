@Add
Feature: Calculator can add numbers

  @Positive
  Scenario: I tried to add two numbers
    When I add 5
    And I add 6
    Then The result is 11

  @Positive
  Scenario: I tried to add three numbers
    When I add
      | 5 | 3 | 2 |
    Then The result is 10


    Scenario Outline: I tried to add two numbers
      When I add
        | 5 | 3 | 2 |
      Then The result is 10
      Examples:
