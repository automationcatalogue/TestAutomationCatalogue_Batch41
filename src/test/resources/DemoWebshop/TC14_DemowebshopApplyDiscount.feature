@All @DemoWebshop
Feature: DemoWebshop ApplyDiscount functionality

  Background: PreRequisites of ApplyDiscount
    Given User reads ApplyDiscount Data from "DemoWebshop_ApplyDiscount" using TestID "TC11-01"


  @ReOrder
  Scenario: ApplyDiscount in DemoWebshop Application
    Given User loads DemoWebshop Application
    Then  User clicks on Login link
    When  User login into DemoWebshop Application with UserName "aarosagarch@gmail.com" and Password "Admin@123"
    Then  User clicks on Books link
    And   User clicks on Addtocart button
    And   User clicks on Shopping cart link
    And   User get Cartprice Beforediscount
    When  User clicks on Txtbox coupon
    Then  User enter Txtbox coupon
    And   User clicks on Applydiscount button
    When  User get txtmessage printed
    Then  User get Discount amount
    And   User get Cartprice Afterdiscount
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



