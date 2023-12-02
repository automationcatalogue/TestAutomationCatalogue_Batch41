@All @DemoWebShop
Feature: DemoWebShop Application Applying Discount

  Background: Loading DemoWebShop ApplyDiscount ExcelTestData
    Given User loads "DemoWebShop_ApplyDiscount" excel sheet

  @TC10 @DemoWebShop_ApplyDiscount
  Scenario Outline: Applying Discount
    Given User launches browser
    Given User opens DemoWebShop application
    When User login into DemoWebShop application with username as "<UserName>" and "<Password>"
    Then User verify title of DemoWebShop home page
    Then User adds first book item into the cart
    And User applied discount coupon
    And User verifies cart price after applying discount coupon.
    Then User checkout the selected item
    And User places the order
    Then User logged out from DemoWebShop application
    And User Updates the Status in "DemoWebShop_ApplyDiscount" ExcelSheet for ApplyDiscount

    Examples:
      | UserName    | Password     |
      | Admin       | QWRtaW5AMTIz |
