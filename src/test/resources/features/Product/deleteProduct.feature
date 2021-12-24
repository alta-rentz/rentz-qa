@DeleteProduct
  Feature:As a user
    I want to delete product by ID
    So that I am success delete product

  Scenario: I want to delete product by ID
    Given I am succes logged in
    When I am hit endpoint delete product ID 145
    Then I am get status code 200 for delete product
    And validate response body code 200 message "Successful Operation"

  Scenario: I want to delete product by invalid ID
    Given I am succes logged in
    When I am hit endpoint delete product ID 117
    Then I am get status code 400 for delete product
    And validate response body code 400 message "Access Forbidden"
