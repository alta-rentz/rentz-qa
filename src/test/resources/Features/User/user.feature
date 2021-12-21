@User
Feature: User Functionality
  As a user
  I want to get user, edit user, and delete who is currently logged in
  So that I am success get user, edit user, and delete who is currently logged in

  @GetUser
  #Get User Login By Token
  Scenario: I want to get user who is currently logged in
    Given I am success get user who is currently logged in
    When I am hit endpoint get user who is currently logged in
    Then I am get success a status code 200
    And validate get user response body code 200 message "Successful Operation"

  @EditUser
  #Put User Login By Token
  Scenario Outline: I want to update user who is currently logged in
    Given I am success get user who is currently logged in
    When I am update data nama "<nama>" email "<email>" password "<password>" phone"<phone>"
    And I am hit endpoint put user who is currently logged in
    Then I am get success a status code 200
    And validate put user response body code 200 message "Successful Operation"
    Examples:
      | nama | email             | password   | phone            |
      | reza | reza!23@gmail.com | P@ssw0rd!@ | 0972712163178121 |

  @DeleteUser
  #Delete User Login By Token
  Scenario: I want delete user who is currently logged in
    Given I am success get user who is currently logged in
    When I am hit endpoint delete user who is currently logged in
    Then I am get success a status code 200
    And validate delete user response body code 200 message "Successful Operation"