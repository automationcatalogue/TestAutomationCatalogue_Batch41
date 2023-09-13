Feature: OrangeHRM Login functionality

  @OrangeHRMLogin_Valid @OrangeHRM_Login
  Scenario: OrangeHRM Login testcase using Valid UserName and Valid Password
    Given OrangeHRM application is loaded
    When User entered username as "Admin"
    And User entered password as "Admin@123"
    And User Clicks on Login button
    Then User verified Login is successful
    And User Verified title of the Homepage

  @OrangeHRMLogin_Invalid @OrangeHRM_Login
    Scenario: OrangeHRM Login testcase using Valid User and Invalid Password
      Given OrangeHRM application is loaded
      When User entered username as "Admin"
      And User entered password as "Test@123"
      And User Clicks on Login button
      Then User Verified Invalid Login credentials error message