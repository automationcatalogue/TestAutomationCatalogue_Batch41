@All @DemoWebshop
Feature: DemoWebshop Application Calculating Total Orders

  Background: PreRequisites of Total Order testcase
    Given User reads TotalOrder Data from "DemoWebShop_TotalOrders" using TestID "TC12-01"

@TotalOrders
  Scenario: Total Orders count, DateWise Orders display, Sum of All Orders
    Given User loads DemoWebshop Application
    When User login into DemoWebshop Application with UserName "aarosagarch@gmail.com" and Password "Admin@123"
    Then User Verifies Successful login of DemoWebshop application
    When User clicks on Email Address and click on orders link
    Then User performs Total Orders count
    And User Performs Sum of All Orders Placed
    And User displays Sum of orders DateWise
    Then User Updates the Status in ExcelSheet for Total Orders