Feature: Search and Place the order for products

  Scenario: Search Experience for product search in both home and offers page
    Given User is on GreenKart Landing Page
    When User searched with short name "Tom" and extracted actual name of product
    Then User searched for same shortname "Tom" in offers page
    And Validate product name matches with Landing Page

