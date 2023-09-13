@All @DemoWebshop
Feature: DemoWebshop Create Address functionality

  @CreateAddress
  Scenario: Create a Address in DemoWebshop Application
    Given User loads DemoWebshop Application
    When User login into DemoWebshop Application with UserName "aarosagarch@gmail.com" and Password "Admin@123"
    Then User Verifies Successful login of DemoWebshop application
    When User Opens Address page
    And User Clicks on AddNew button
    When User Enters address fields data for FirstName as "Automation" LastName as "Catalogue" and Email as "test@test.org"
    And User Selects Country as "Canada" State as "Ontario" Address1 as "21st Avenue" Address2 as "Near Metro State" station and Postal Code as "342342"
    And User Enters PhoneNumber as "8956231470" and FaxNumber as "256325"
    When User Clicks on Save button
    Then User Verifies Address is added



