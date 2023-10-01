@All @OrangeHRM
Feature: OrangeHRM Add Employee Feature

  Background: PreRequisites of Add Employee testcase
    Given User reads AddEmployee Data from "OrangeHRM_AddEmployee" using TestID "TC02-01"

  @AddEmployee
  Scenario: AddEmployee testcase in OrangeHRM Application
    Given User loads OrangeHRM Application in "Chrome" browser
    When User Login into OrangeHRM Application with UserName as "Admin" and Password as "Admin@123"
    Then User Verifies Successful Login
    When User Opens Add Employee Page
    And User Provides FirstName, LastName, Location in Add EmployeePage and Clicks on Next
    And User Selects Marital Status and Gender and Clicks on Next
    And User Selects Region, FTE, Temporary Department and Clicks on Save button
    Then User Search for New Employee
    And User Verifies New Employee information
    Then User logout from orangeHRM application
    Then User Updates the Status in ExcelSheet for Add Employee

