@Shop
Feature: All user types should be able to login when entering correct\existing information

  Background:
    Given I navigate to LoginPage
    Then I am on the LoginPage, within 5 seconds


  Scenario Outline: Whatever is on the LoginPage
    When I type "<email>" into LoginPage EMAIL
    And I type "<password>" into LoginPage PASSWORD
    And I click LoginPage SIGN_IN_BUTTON
    Then I hover option "<mainCategory>" in TopNavigationBar CATEGORY;
    And I hover option "<subCategory>" in TopNavigationBar CATEGORY;
    And I click option "<itemType>" in TopNavigationBar CATEGORY;
    Then I should be in ItemsPage for "<mainCategory>","<subCategory>","<itemType>", within in 5 seconds
    Then I click on the item with order <itemOrder> in ItemListPage

    @Positive
    Examples:
      | email                             | password  | mainCategory | subCategory | itemType | itemOrder |
      | michalisvlachos98+test1@gmail.com | test1234! | women        | tops        | jackets  | 12        |
#      | roni_cost@example.com             | roni_cost3@example.com! |