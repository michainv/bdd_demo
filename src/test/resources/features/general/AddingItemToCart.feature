@Shop
Feature: Users should be able add products to their carts

  Background:
    Given I am logged in with user "michalisvlachos98+test1@gmail.com","test1234!"
    And I empty every item in my MainCart

  Scenario Outline: Add 1 product to cart
    When I Navigate to the product page for item:"<itemName>"
    Then I am on SingleItemPage for "<itemName>", within 5 seconds
    And Product price on SingleItemPage equals to "<itemPrice>"
    Then I select "size" : "<itemSize>" in SingleItemPage
    And I select "color" : "<itemColor>" in SingleItemPage
    And I type "<itemQuantity>" in SingleItemPage ITEM_QUANTITY
    And I click ADD_TO_CART in SingleItemPage
    And I navigate on the MainCart page
    Then I should see item with PRODUCT_NAME : "<itemName>" in MainCart
    And I should see "<itemName>" with PRODUCT_PRICE : "<itemPrice>" in MainCart
    And I should see "<itemName>" with PRODUCT_SUBTOTAL : "<itemTotal>" in MainCart
    And I should see "<itemName>" with PRODUCT_QUANTITY : "<itemQuantity>" in MainCart
    And I should see "<itemName>" with PRODUCT_COLOR : "<itemColor>" in MainCart
    And I should see "<itemName>" with PRODUCT_SIZE : "<itemSize>" in MainCart

    @Positive
    Examples:
      | itemName             | itemPrice | itemSize | itemColor | itemQuantity | itemTotal |
      | Stellar Solar Jacket | €75.00    | S        | Blue      | 2            | €150.00   |
      | Montana Wind Jacket  | €49.00    | XL       | Green     | 1            | €49.00    |


  Scenario Outline: Add 2 products to cart
    When I Navigate to the product page for item:"<itemName>"
    Then I am on SingleItemPage for "<itemName>", within 5 seconds
    And Product price on SingleItemPage equals to "<itemPrice>"
    Then I select "size" : "<itemSize>" in SingleItemPage
    And I select "color" : "<itemColor>" in SingleItemPage
    And I type "<itemQuantity>" in SingleItemPage ITEM_QUANTITY
    And I click ADD_TO_CART in SingleItemPage
    When I Navigate to the product page for item:"<itemName2>"
    And Product price on SingleItemPage equals to "<itemPrice2>"
    Then I am on SingleItemPage for "<itemName2>", within 5 seconds
    Then I select "size" : "<itemSize2>" in SingleItemPage
    And I select "color" : "<itemColor2>" in SingleItemPage
    And I type "<itemQuantity2>" in SingleItemPage ITEM_QUANTITY
    And I click ADD_TO_CART in SingleItemPage
    And I navigate on the MainCart page
    Then I should see item with PRODUCT_NAME : "<itemName>" in MainCart
    And I should see "<itemName>" with PRODUCT_PRICE : "<itemPrice>" in MainCart
    And I should see "<itemName>" with PRODUCT_SUBTOTAL : "<itemTotal>" in MainCart
    And I should see "<itemName>" with PRODUCT_QUANTITY : "<itemQuantity>" in MainCart
    And I should see "<itemName>" with PRODUCT_COLOR : "<itemColor>" in MainCart
    And I should see "<itemName>" with PRODUCT_SIZE : "<itemSize>" in MainCart
    Then I should see item with PRODUCT_NAME : "<itemName2>" in MainCart
    And I should see "<itemName2>" with PRODUCT_PRICE : "<itemPrice2>" in MainCart
    And I should see "<itemName2>" with PRODUCT_SUBTOTAL : "<itemTotal2>" in MainCart
    And I should see "<itemName2>" with PRODUCT_QUANTITY : "<itemQuantity2>" in MainCart
    And I should see "<itemName2>" with PRODUCT_COLOR : "<itemColor2>" in MainCart
    And I should see "<itemName2>" with PRODUCT_SIZE : "<itemSize2>" in MainCart

    @Positive
    Examples:
      | itemName             | itemPrice | itemSize | itemColor | itemQuantity | itemTotal | itemName2           | itemPrice2 | itemSize2 | itemColor2 | itemQuantity2 | itemTotal2 |
      | Stellar Solar Jacket | €75.00    | S        | Blue      | 2            | €150.00   | Montana Wind Jacket | €49.00     | XL        | Green      | 1             | €49.00     |