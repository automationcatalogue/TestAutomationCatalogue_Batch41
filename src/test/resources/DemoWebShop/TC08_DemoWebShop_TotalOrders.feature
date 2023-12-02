@All @DemoWebShop
Feature: DemoWebShop Application Calculating Total Orders

  Background: Loading DemoWebShop TotalOrders ExcelTestData
    Given User loads "DemoWebShop_TotalOrders" total orders excel sheet

  @TC08 @DemoWebShop_TotalOrders
  Scenario Outline: Total Orders count, DateWise Orders display, Sum of All Orders
    Given User launches browser
    Given User opens DemoWebShop application
    When User login into DemoWebShop application with username as "<UserName>" and "<Password>"
    Then User verify title of DemoWebShop home page
    When User opens OrdersPage by clicking on Email link and then on Orders
    Then User performs Total Orders count
    And User Performs Sum of All Orders Placed
    And User displays Sum of orders DateWise
    Then User logged out from DemoWebShop application
    And User Updates the Status in "DemoWebShop_TotalOrders" ExcelSheet for Total Orders

    Examples:
      | UserName    | Password     |
      | aarosagarch@gmail.com       | QWRtaW5AMTIz |