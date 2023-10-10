@All @OrangeHRM
Feature: OrangeHRM TravelRequest Feature

  Background: PreRequisites of TravelRequest testcase
    Given User reads TravelRequest Data from "OrangeHRM_TravelExpense" using TestID "TC05-01"

  @TravelRequest
  Scenario: TravelRequest testcase in OrangeHRM Application
    Given User loads OrangeHRM Application in "Chrome" browser
    When User Login into OrangeHRM Application with UserName as "Admin" and Password as "Admin@123"
    Then User Verifies Successful Login
    When User clicks on HR Administration page
    Then User clicks on Users Tab and change password for both Employee and Supervisor and logout
    When User Login into OrangeHRM Application with Employee credentials as employee_UserName and newPassword and clicks on Travel and Expense Link
    And creates a travel request providing currency,destination,travelFrom,travelTo,expenseType,amount,paidBy
    Then User check the status of the TravelRequest and logout from the application
    When User login as Supervisor and provides the Supervisor approval for the TravelRequest and Logout
    Then User login as Employee and check for TravelRequest Status and Logout
    And User Login as Admin and provides admin approval and logout
    And User Login as Employee and checks for final approval Status and logout
    Then User Updates the Status in ExcelSheet for TravelRequest