@All @OrangeHRM
Feature: OrangeHRM Application Login functionality

  @TC01 @OrangeHRM_Login
  Scenario Outline: OrangeHRM Login Test
    Given User launches browser
    Given User opens OrangeHRM application
    When User login into OrangeHRM application with username as "<UserName>" and "<Password>"
    Then User verify title of OrangeHRM home page
    And User logged out from OrangeHRM application

    Examples:
      | UserName    | Password     |
      | Admin       | QWRtaW5AMTIz |
     # | aaliyah.haq | QWRtaW5AMTIz |
     # | aaron       | QWRtaW5AMTIz |
     # | alice       | QWRtaW5AMTIz |
     # | amanda      | QWRtaW5AMTIz |







