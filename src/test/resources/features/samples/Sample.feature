@Sample
  @Regression
Feature: This is a Sample execution feature.

  @Sce1
  Scenario: When precondition1 is met and User performs action1 then user sees precondition1-result
    Given I am on precondition1
    When I do action1
    Then I expect precondition1-result

  @Sce2
  Scenario: When precondition2 is met and User performs action1 then user sees precondition2-result
    Given I am on precondition2
    When I do action1
    Then I expect precondition2-result