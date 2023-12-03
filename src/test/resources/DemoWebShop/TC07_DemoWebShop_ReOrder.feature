@All @DemoWebShop
Feature: DemoWebShop ReOrder Functionality

  Background: Loading DemoWebShop ReOrder ExcelTestData
    Given User loads "DemoWebshop_ReOrder" reorder excel sheet

  @TC07 @DemoWebShop_ReOrder
  Scenario Outline: DemoWebShop ReOrder
    Given User launches browser
    Given User opens DemoWebShop application
    When User login into DemoWebShop application with username as "<UserName>" and "<Password>"
    Then User verify title of DemoWebShop home page
    When User open on Orders Page
    And User click on First Order Details and Reorder
    When User click on checkout selected items
    And User place an Order
    Then User get the Order Number
    And User logged out from DemoWebShop application
    And User update order number and status in "DemoWebshop_ReOrder" reorder excel sheet
    Examples:
      | UserName              | Password     |
      | aarosagarch@gmail.com | QWRtaW5AMTIz |