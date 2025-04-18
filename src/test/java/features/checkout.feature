Feature: Place the order for products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenKart Landing Page
    When User searched with short name <Name> and extracted actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to Checkout and validate the <Name> items in checkout page
    And Verify user has ability to enter promo code and place the order

    Examples:
      | Name |
      | Tom  |
