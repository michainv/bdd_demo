@Pricing
Feature: Items should have the same prices on item list and on single Item page

  Background:
    Given I am logged in with user "michalisvlachos98+test1@gmail.com","test1234!"


  Scenario Outline: Check that pricing and name is the same for item list and and single item page
    Then I hover option "<mainCategory>" in TopNavigationBar CATEGORY;
    And I hover option "<subCategory>" in TopNavigationBar CATEGORY;
    And I click option "<itemType>" in TopNavigationBar CATEGORY;
    Then I should be in ItemsPage for "<mainCategory>","<subCategory>","<itemType>", within in 5 seconds
    When I click on the item with name "<itemName>" in ItemListPage
    Then I am on SingleItemPage for "<itemName>", within 5 seconds
    And Product price on SingleItemPage equals to "<itemPrice>"

    @Positive
    Examples:
      | mainCategory | subCategory | itemType | itemName                   | itemPrice |
      | women        | tops        | jackets  | Stellar Solar Jacket       | €75.00     |
      | men          | bottoms     | pants    | Geo Insulated Jogging Pant | €40.80     |
