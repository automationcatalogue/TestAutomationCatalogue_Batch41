@All @OrangeHRM
Feature: OrangeHRM Application Adding New Employee in Employee Management

  Background: Loading OrangeHRM AddEmployee ExcelTestData
    Given User loads "OrangeHRM_AddEmployee" add employee excel sheet

  @TC02 @OrangeHRM_AddEmployee
  Scenario Outline: OrangeHRM AddEmployee Test
    Given User launches browser
    Given User opens OrangeHRM application
    When User login into OrangeHRM application with username as "<UserName>" and "<Password>"
    Then User verify title of OrangeHRM home page
    When User clicks on OrangeHRM EmployeeManagement link
    And User enters firstName, lastName and location from excel file
    And User enters maritalStatus and gender from from excel file
    And User enters region, fte and temp dept from excel file
    And User clicks on OrangeHRM EmployeeManagement link
    Then User searches for new employee with firstname and lastname
    Then User verify new employee Id and Name
    Then User logged out from OrangeHRM application
    And User Update the EmployeeId in "OrangeHRM_AddEmployee" add employee excel sheet

    Examples:
      | UserName    | Password     |
      | Admin       | QWRtaW5AMTIz |
     # | aaliyah.haq | QWRtaW5AMTIz |
     # | aaron       | QWRtaW5AMTIz |
     # | alice       | QWRtaW5AMTIz |
     # | amanda      | QWRtaW5AMTIz |







