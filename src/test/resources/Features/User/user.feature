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

  @GetUserFailed
    #Get User Login Not Token
  Scenario: I want failed to get user who is currently logged in
    Given I am success get user who is currently logged in
    When I am failed hit endpoint get user who is currently logged in
    Then I am get success a status code 400
    And validate failed get user response body message "missing or malformed jwt"

  @EditUser
  #Put User Login By Token
  Scenario Outline: I want to update user who is currently logged in
    Given I am success get user who is currently logged in
    When I am update data nama "<nama>" email "<email>" password "<password>" phone"<phone>"
    And I am hit endpoint put user who is currently logged in
    Then I am get success a status code 200
    And validate put user response body code 200 message "Successful Operation"
    Examples:
      | nama         | email                  | password | phone       |
      | tanpa_nama10 | tanpa_nama10@gmail.com | 121131   | 08867654545 |

  @EditUserFailed
  #Put User Login Not Token
  Scenario Outline: I want to failed update user who is currently logged in
    Given I am success get user who is currently logged in
    When I am update data nama "<nama>" email "<email>" password "<password>" phone"<phone>" not token
    And I am hit endpoint put user who is currently logged in
    Then I am get success a status code 400
    And validate failed put user response body message "missing or malformed jwt"
    Examples:
      | nama      | email                | password  | phone      |
      | injang100 | injang100@alterra.id | injang100 | 0876654555 |

  @DeleteUser
  #Delete User Login By Token
  Scenario: I want delete user who is currently logged in
    Given I am success get user who is currently logged in
    When I am hit endpoint delete user who is currently logged in
    Then I am get success a status code 200
    And validate delete user response body code 200 message "Successful Operation"

  @DeleteUserFailed
  #Delete User Login Not Token
  Scenario: I want failed delete user who is currently logged in
    Given I am success get user who is currently logged in
    When I am failed hit endpoint delete user who is currently logged in
    Then I am get success a status code 400
    And validate failed delete user response body message "missing or malformed jwt"
