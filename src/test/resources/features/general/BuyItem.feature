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
    When I click on the item with name "<itemName>" in ItemListPage
    Then I am on SingleItemPage for "<itemName>", within 5 seconds
    And Product price on SingleItemPage equals to "<itemPrice>"

    @Positive
    Examples:
      | email                             | password  | mainCategory | subCategory | itemType | itemName             | itemPrice |
      | michalisvlachos98+test1@gmail.com | test1234! | women        | tops        | jackets  | Stellar Solar Jacket | 75.00     |
#      | roni_cost@example.com             | roni_cost3@example.com! |