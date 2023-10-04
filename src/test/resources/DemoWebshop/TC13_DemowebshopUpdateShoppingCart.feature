@All @Webshop
  Feature: DemoWebshop Update Shopping Cart

    Background: PreRequisite for Update Shopping Cart TestCase
    Given User Reads Update Shopping Cart Data from "DemoWebshop_UpdateShoppingCart" using TestID "TC13-01"

      @UpdateShoppingCart
      Scenario: Update Shopping Cart in Demo WebShop Application
        Given User loads DemoWebshop Application
        When User login into DemoWebshop Application with UserName "aarosagarch@gmail.com" and Password "Admin@123"
        Then User Verifies Successful login of DemoWebshop application
        Then User added the Products to Cart
        And User update the shopping cart
        Then User verifies the updated price and total
        And User checkout and Process the payment gateway
        Then User logout from the application




