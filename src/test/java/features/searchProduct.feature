Feature: Search and Place the order for products

  @OffersPage
  Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenKart Landing Page
    When User searched with short name <Name> and extracted actual name of product
    Then User searched for same shortname <Name> in offers page
    And Validate product name matches with Landing Page

    Examples:
      | Name |
      | Tom  |
      | Beet |
