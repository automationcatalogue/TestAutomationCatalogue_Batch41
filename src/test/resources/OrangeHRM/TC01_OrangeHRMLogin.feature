Feature: OrangeHRM Login functionality

  @OrangeHRMLogin_Valid @OrangeHRM_Login
  Scenario Outline: OrangeHRM Login testcase using Valid UserName and Valid Password
    Given User loads OrangeHRM Application in "Chrome" browser
    When User Login into OrangeHRM Application with UserName as "<userName>" and Password as "<password>"
    Then User Verifies Successful Login
    Then User logout from orangeHRM application

    Examples:
    |userName         |password     |
    |Admin            |Admin@123    |
    |aaliyah.haq      |Test@123     |
    |christine.lasalle|Password@1234|
    |helen            |helen@123    |
    |kevin            |Admin@123    |
    |Sarika           |Admin@123    |

  @OrangeHRMLogin_Invalid @OrangeHRM_Login
    Scenario: OrangeHRM Login testcase using Valid User and Invalid Password
      Given OrangeHRM application is loaded
      When User entered username as "Admin"
      And User entered password as "Test@123"
      And User Clicks on Login button
      Then User Verified Invalid Login credentials error message