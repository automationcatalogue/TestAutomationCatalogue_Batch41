@All @DemoWebshop
Feature: DemoWebshop ReOrder functionality

  Background: PreRequisites of ReOrder
    Given User reads ReOrder Data from "DemoWebshop_ReOrder" using TestID "TC11-01"


  @ReOrder
  Scenario: ReOrder in DemoWebshop Application
    Given User loads DemoWebshop Application
    Then  User clicks on Login link
    When  User login into DemoWebshop Application with UserName "aarosagarch@gmail.com" and Password "Admin@123"
    Then  User Clicks Email Link
    And   User Clicks on Orders link
    And   User Clicks on OrderDetails button
    Then  User Clicks on ReOrder button
    And   User Clicks on I agree button
    And   User Clicks on Checkout button
    When  User Clicks on BillingContinue button
    Then  User Clicks on ShippingAddress button
    And   User Clicks on ShippingMethod button
    And   User Clicks on PaymentMethod button
    And   User Clicks on PaymentInformation button
    When  User Clicks on ConfirmOrder button
    Then  User Get OrderNumber
    And   User logout after verification



