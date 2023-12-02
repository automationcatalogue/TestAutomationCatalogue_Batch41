@All @OrangeHRM
Feature: OrangeHRM Application Creating Goals

  Background: Loading OrangeHRM AddUser ExcelTestData
    Given User loads "OrangeHRM_Goals" goals excel sheet

  @TC05 @OrangeHRM_Goals
  Scenario Outline: OrangeHRM Goals Test
    Given User launches browser
    Given User opens OrangeHRM application
    When User login into OrangeHRM application with username as "<UserName>" and "<Password>"
    Then User verify title of OrangeHRM home page
    When User clicks on OrangeHRM HR Administration link
    And User finds username on Users Page
    When User clicks on OrangeHRM EmployeeManagement link
    And User finds Supervisor name
    When User clicks on OrangeHRM HR Administration link
    And User finds Supervisor userName
    Then User logged out from OrangeHRM application
    Given  User login into OrangeHRM application with employee username
    Then  User clicks on selectPerformance link
    And User clicks on selectMyGoals link
    And User creates three goals
    Then User logged out from OrangeHRM application
    Given User login into OrangeHRM application with  the supervisor username
    Then  User clicks on selectPerformance link
    And User clicks on selectGoalsList link
    And  User clicks on supervisor_ApproveGoals
    Then User logged out from OrangeHRM application
    Given  User login into OrangeHRM application with employee username
    Then  User clicks on selectPerformance link
    And User clicks on selectMyGoals link
    Then User is Updating Goals Progress
    And User does Goals Verification
    Then User logged out from OrangeHRM application
    And User Update status in "OrangeHRM_Goals" goals excel sheet

    Examples:
      | UserName | Password     |
      | Admin    | QWRtaW5AMTIz |
     # | aaliyah.haq | QWRtaW5AMTIz |
     # | aaron       | QWRtaW5AMTIz |
     # | alice       | QWRtaW5AMTIz |
     # | amanda      | QWRtaW5AMTIz |
