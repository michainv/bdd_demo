@Calculator
Feature: Calculator should be able add numbers and produce correct results


  @Addition
    @TwoNumbers
  Scenario Outline: When I add two numbers then the result should be correct
    Given The calculator is reset
    When I add <num1> to the total
    And I add <num2> to the total
    Then The total should be <total>

    Examples:
      | num1 | num2 | total |
      | 5    | 6    | 11    |
      | 0    | 0    | 0     |
      | 5.5  | 4.5  | 10    |
      | 3.3  | 1.2  | 4.5   |
      | -3   | 1    | -2    |

  @Addition
    @ThreeNumbers
  Scenario Outline: When I add three numbers then the result should be correct
    Given The calculator is reset
    When I add <num1> to the total
    And I add <num2> to the total
    And I add <num3> to the total
    Then The total should be <total>

    Examples:
      | num1 | num2 | num3 | total |
      | 5    | 6    | 11   | 22    |
      | 9    | 91   | 100  | 200   |
      | 5.5  | 4.5  | 10   | 20    |
      | 3.3  | 1.2  | 4.5  | 9     |
      | -3   | 1    | -2   | -4    |