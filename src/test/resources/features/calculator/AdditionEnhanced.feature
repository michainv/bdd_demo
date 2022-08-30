@CalculatorEnhanced
Feature: Calculator should be able add numbers and produce correct results

  Background:
    Given The calculator is reset

  @Addition
  Scenario Outline: When I add <count> numbers then the result should be correct
    When I add numbers to the total
      | <num1> |
      | <num2> |
      | <num3> |
      | <num4> |
      | <num5> |
      | <num6> |
    Then The total should be <total>

    Examples:
      | num1 | num2 | num3 | num4 | num5 | num6 | total | count |
      | 1    | 2    |      |      |      |      | 3     | 2     |
      | 5    | 5    | 6    |      |      |      | 16    | 3     |
      | 5    | 5    | 6    | 6    |      |      | 22    | 4     |
      | 5    | 5    | 5    | 5    | 5    |      | 25    | 5     |
      | 5    | 5    | 5    | 5    | 5    | 5    | 30    | 6     |
