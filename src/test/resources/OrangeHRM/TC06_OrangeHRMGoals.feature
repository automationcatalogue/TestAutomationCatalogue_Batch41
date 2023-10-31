@All @OrangeHRM
Feature: Orange HRM Goals Feature

  Background: PreRequisites of OrangeHRM Goals testcase
    Given User reads Goals Data from "OrangeHRM_Goals" using TestID "TC06-01"

  @Goals
  Scenario: Goals TestCase in OrangeHRM Application
    Given User loads OrangeHRM Application in "Chrome" browser
    When User Login into OrangeHRM Application with UserName as "Admin" and Password as "Admin@123"
    And User Clicks on Login button
    When Finding Username of Employee in HrAdministration
    And Finding Supervisor name in EmployeeManagement
    And Finding Supervisor's username in HrAdministration
    And User logout from orangeHRM application
    When Log in with the Employee Username
    And Create all goals and logout
    When Logging in with the supervisor username
    And  Logging in with the employee username
    When All goals progress
    Then All goals Verification
    And User logout from orangeHRM application
    Then User Updates the Status in ExcelSheet for Goals





