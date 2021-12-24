@GetProduct
Feature: Get All Product and by ID
  As a user
  I want to see all products and details products
  So that I am success get products

  @GetAllProduct #SUKSES
  Scenario: I want to see list all product
    Given I am set header "Content-Type" with fill "application/json"
    When I am hit endpoint get all products
    Then I am get status code 200 for get all products
    And validate success response body code 200 message "Successful Operation"

  @GetProductSID #SUKSES
  Scenario: I want to see list product by subcategory ID
    Given I am set header "Content-Type" with fill "application/json"
    When I am hit endpoint get subcategory by SubcategoryID 311
    Then I am get status code 200 for get product by SubcategoryID
    And validate success response body code 200 message "Successful Operation" for get product by SubcategoryID 311

  @GetProductID #SUKSES
  Scenario: I want to see list product ID
    Given I am set header "Content-Type" with fill "application/json"
    When I am hit endpoint get product by ID 4
    Then I am get status code 200 for get product by ID
    And validate success response body code 200 message "Successful Operation" for get product by ID 4



