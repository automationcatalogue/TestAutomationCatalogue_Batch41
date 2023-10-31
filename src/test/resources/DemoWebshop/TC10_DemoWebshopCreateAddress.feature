@All @DemoWebshop
Feature: DemoWebshop Create Address Feature

  Background: PreRequisites of CreateAddress
    Given User reads CreateAddress Data from "DemoWebshop_CreateAddress" using TestID "TC10-01"

  @CreateAddress
  Scenario: Create a Address in DemoWebshop Application
    Given User loads DemoWebshop Application
    When User login into DemoWebshop Application with UserName "aarosagarch@gmail.com" and Password "Admin@123"
    When User Opens Address page
    When User Enters address fields data for FirstName, LastName, Email and Company
    And User Provides City, Address1, Address2, ZipPostalCode, PhoneNumber and FaxNumber
    Then User Verifies Address is added
    #Then User logout from the application
    And User logout after verification
    Then User Updates the Status in ExcelSheet for CreateAddress



