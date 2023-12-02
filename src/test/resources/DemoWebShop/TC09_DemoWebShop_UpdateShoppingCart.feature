@All @DemoWebShop
Feature: DemoWebShop Update Shopping Cart Functionality

  Background: Loading OrangeHRM AddEmployee ExcelTestData
    Given User loads "OrangeHRM_AddEmployee" add employee excel sheet

  @TC06 @DemoWebShop_UpdateShoppingCart
  Scenario Outline: DemoWebShop Update Shopping Cart
    Given User launches browser
    Given User opens DemoWebShop application
    When User login into DemoWebShop application with username as "<UserName>" and "<Password>"
    Then User verify title of DemoWebShop home page
    When User add the first item to the cart
    And User get the item price before increase the quantity and increase the item quantity
    Then User Verify the Items Total price change
    And User verify the grand total
    When User click on checkout selected items
    And User place an Order
    Then User get the Order Number
    And User logged out from DemoWebShop application

    Examples:
      | UserName              | Password     |
      | aarosagarch@gmail.com | QWRtaW5AMTIz |