@All @OrangeHRM
Feature: OrangeHRM Application Adding New User in HR Administration

  Background: Loading OrangeHRM AddUser ExcelTestData
    Given User loads "OrangeHRM_AddUser" add user excel data

  @TC03 @OrangeHRM_AddUser
  Scenario Outline: OrangeHRM AddUser Test
    Given User launches browser
    Given User opens OrangeHRM application
    When User login into OrangeHRM application with username as "<UserName>" and "<Password>"
    Then User verify title of OrangeHRM home page
    When User clicks on OrangeHRM HR Administration link
    And User clicks on Add User button
    And User enters EmployeeName, UserName, Password and Confirm Password
    Then User logged out from OrangeHRM application
    Given User login into OrangeHRM application with new username
    Then User verifies new userName
    Then User logged out from OrangeHRM application
    And User Update the new username in "OrangeHRM_AddUser" add user excel sheet

    Examples:
      | UserName    | Password     |
      | Admin       | QWRtaW5AMTIz |
     # | aaliyah.haq | QWRtaW5AMTIz |
     # | aaron       | QWRtaW5AMTIz |
     # | alice       | QWRtaW5AMTIz |
     # | amanda      | QWRtaW5AMTIz |







