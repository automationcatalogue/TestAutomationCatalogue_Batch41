@All @OrangeHRM
Feature: OrangeHRM Application Edit Employee in Employee Management

  Background: Loading OrangeHRM EditEmployee ExcelTestData
    Given User loads "OrangeHRM_EditEmployee" edit employee excel data

  @TC04 @OrangeHRM_EditEmployee
  Scenario Outline: OrangeHRM EditEmployee Test
    Given User launches browser
    Given User opens OrangeHRM application
    When User login into OrangeHRM application with username as "<UserName>" and "<Password>"
    Then User verify title of OrangeHRM home page
    When User clicks on OrangeHRM EmployeeManagement link
    And User clicks on employee personal details tab
    And User edits employee dob and nationality
    And User edits employee health information
    And User edits employee mobile number
    Then User validates edit employee data
    Then User logged out from OrangeHRM application
    And User Update status in "OrangeHRM_EditEmployee" edit employee excel sheet

    Examples:
      | UserName    | Password     |
      | Admin       | QWRtaW5AMTIz |
     # | aaliyah.haq | QWRtaW5AMTIz |
     # | aaron       | QWRtaW5AMTIz |
     # | alice       | QWRtaW5AMTIz |
     # | amanda      | QWRtaW5AMTIz |







