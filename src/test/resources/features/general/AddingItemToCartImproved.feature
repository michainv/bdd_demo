@ShopImproved
Feature: Users should be able add products to their carts (improved)

  Background:
    Given I am logged in with user "michalisvlachos98+test1@gmail.com","test1234!"
    And I empty every item in my MainCart

  Scenario Outline: Add 1 product to cart
    Given I add item to my cart
      | Name       | Price       | Size       | Color       | Quantity       |
      | <itemName> | <itemPrice> | <itemSize> | <itemColor> | <itemQuantity> |
    When I navigate on the MainCart page
    Then I can see following products added to MainCart
      | Name       | Price       | Size       | Color       | Quantity       | ItemTotal   |
      | <itemName> | <itemPrice> | <itemSize> | <itemColor> | <itemQuantity> | <itemTotal> |

    Examples:
      | itemName             | itemPrice | itemSize | itemColor | itemQuantity | itemTotal |
      | Stellar Solar Jacket | €75.00    | S        | Blue      | 2            | €150.00   |

  Scenario Outline: Add 2 product to cart
    Given I add items to my cart
      | Name        | Price        | Size        | Color        | Quantity        |
      | <itemName>  | <itemPrice>  | <itemSize>  | <itemColor>  | <itemQuantity>  |
      | <itemName2> | <itemPrice2> | <itemSize2> | <itemColor2> | <itemQuantity2> |
    When I navigate on the MainCart page
    Then I can see following products added to MainCart
      | Name        | Price        | Size        | Color        | Quantity        | ItemTotal    |
      | <itemName>  | <itemPrice>  | <itemSize>  | <itemColor>  | <itemQuantity>  | <itemTotal>  |
      | <itemName2> | <itemPrice2> | <itemSize2> | <itemColor2> | <itemQuantity2> | <itemTotal2> |

    Examples:
      | itemName             | itemPrice | itemSize | itemColor | itemQuantity | itemTotal | itemName2           | itemPrice2 | itemSize2 | itemColor2 | itemQuantity2 | itemTotal2 |
      | Stellar Solar Jacket | €75.00    | S        | Blue      | 2            | €150.00   | Montana Wind Jacket | €49.00     | XL        | Green      | 1             | €49.00     |