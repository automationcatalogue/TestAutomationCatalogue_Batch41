@All @DemoWebShop
Feature: DemoWebShop Create Address Functionality

  Background: Loading DemoWebShop ExcelTestData
    Given User loads "DemoWebshop_CreateAddress" excel data

  @TC06 @DemoWebShop_CreateAddress
  Scenario Outline: DemoWebShop Create Address
    Given User launches browser
    Given User opens DemoWebShop application
    When User login into DemoWebShop application with username as "<UserName>" and "<Password>"
    Then User verify title of DemoWebShop home page
    When User clicks on MyAccount and Addresses link
    And User enters the Create Address details
    Then User verifies the firstname and lastname of address
    And User logged out from DemoWebShop application

    Examples:
      | UserName              | Password     |
      | aarosagarch@gmail.com | QWRtaW5AMTIz |


