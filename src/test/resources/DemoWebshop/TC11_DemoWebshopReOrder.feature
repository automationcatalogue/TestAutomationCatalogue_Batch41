@All @DemoWebshop
Feature: DemoWebshop ReOrder functionality

  @ReOrder
  Scenario: ReOrder in DemoWebshop Application
    Given User loads DemoWebshop Application
    When User login into DemoWebshop Application with UserName "aarosagarch@gmail.com" and Password "Admin@123"
    Then User Clicks Email Link
    And User Clicks on Orders link
    And User Clicks on OrderDetails button
    Then User Clicks on ReOrder button
    And User Clicks on Iagree button
    And User Clicks on Checkout button
    When User Clicks on BillingContinue button
    Then User Clicks on ShippingAddress button
    And User Clicks on ShippingMethod button
    And User Clicks on PaymentMethod button
    And User Clicks on PaymentInformation button
    When User Clicks on ConfirmOrder button
    Then User Get OrderNumber



