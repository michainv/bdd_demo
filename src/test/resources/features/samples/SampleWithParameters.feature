@SampleParam
Feature: This is a Sample Enhanced execution feature.

  @Sce1
  Scenario Outline: When <precondition> is met and User performs <action> then user sees <result>
    Given I have done precondition : <precondition>
    When I perform action : <action>
    Then I should see result : <result>

    @Positive
    Examples:
      | precondition  | action  | result               |
      | precondition1 | action1 | precondition1-result |
      | precondition2 | action1 | precondition2-result |

