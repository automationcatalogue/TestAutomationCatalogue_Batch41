@All @OrangeHRM

Feature: OrangeHRM Add User Feature

  Background: PreRequisites of Add User testcase
    Given User adds new user details in AddUser Data from "OrangeHRM_AddUser" using TestID "TC03-01"

  @AddUser
    Scenario: orangeHRM addUser testcase
    Given  User loads OrangeHRM Application in "Chrome" browser
    When User Login into OrangeHRM Application with UserName as "Admin" and Password as "Admin@123"
    Then User Verifies Successful Login
    And User Verified title of the Homepage
    When User opens HR Administration page
    And  User enters employee,  username, Password, confirm password and clicks on save button
    And User clicks on logout button
    And User enters username as new username
    Then User verifies new user login
    And User logouts after verifying new user login










