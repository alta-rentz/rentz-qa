@CreateProduct
  Feature: POST Create Product for user
    As a user
    I want to create product
    So that I am success create product

  @TC_1 #Success
  Scenario Outline: User create product
    Given I am success logged in as a user
    And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
    When I am hit endpoint create product
    Then I am get a status code 200 create product
    And validate response body code 200 and message "product created and file uploaded successfully"
    Examples:
      | name                    | subcategory_id | city_id | price | description    | stock | guarantee |
      | Habis Terang kata siapa | 311            | 3273    | 50000 | kepo banget lu | 10    | 2         |

    @TC_2
    Scenario Outline: User create product with blank product name
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Must add product name"
      Examples:
        | name | subcategory_id | city_id | price | description    | stock | guarantee |
        |      | 311            | 3273    | 50000 | kepo banget lu | 10    | 2         |

    @TC_3
    Scenario Outline: User create product and enters Spaces in Product Name
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Must add product name"
      Examples:
        | name | subcategory_id | city_id | price | description    | stock | guarantee |
        |      | 311            | 3273    | 50000 | kepo banget lu | 10    | 2         |

    @TC_4
    Scenario Outline: User craate product without selecting a Product Category
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Bad Request"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item |                | 3273    | 50000 | kepo banget lu | 10    | 2         |

    @TC_5
    Scenario Outline: User create product without selecting a Owner's City
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Bad Request"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            |         | 50000 | kepo banget lu | 10    | 2         |

    @TC_6
    Scenario Outline: User create product with inserting characters in price
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Price must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50k0f | kepo banget lu | 10    | 2         |

    @TC_7
    Scenario Outline: User create product enter space price
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Price must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    |       | kepo banget lu | 10    | 2         |

    @TC_8
    Scenario Outline: User create product without price
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Price must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    |       | kepo banget lu | 10    | 2         |

    @TC_9
    Scenario Outline: User create product inserting characters "+" in Price
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Price must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price  | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000+ | kepo banget lu | 10    | 2         |

    @TC_10
    Scenario Outline: User create product inserting characters "-" in Price
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Price must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price  | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000- | kepo banget lu | 10    | 2         |

    @TC_11
    Scenario Outline: User create product inserting characters "." in Price
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Price must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price  | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000. | kepo banget lu | 10    | 2         |

    @TC_12
    Scenario Outline: User create product inserting characters "," in Price
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Price must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price  | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000, | kepo banget lu | 10    | 2         |

    @TC_13
    Scenario Outline: User create product enter space in description
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Must add description"
      Examples:
        | name             | subcategory_id | city_id | price | description | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 |             | 10    | 2         |

    @TC_14
    Scenario Outline: User create product inserting characters in stock
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Stock must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10f   | 2         |

    @TC_15
    Scenario Outline: User create product without stock
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Stock must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu |       | 2         |

    @TC_16
    Scenario Outline: User create product inserting characters "+" stock
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Stock must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10+   | 2         |

    @TC_17
    Scenario Outline: User create product inserting characters "-" stock
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Stock must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10-   | 2         |

    @TC_18
    Scenario Outline: User create product inserting characters "." stock
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Stock must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10.   | 2         |

    @TC_19
    Scenario Outline: User create product inserting characters "," stock
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Stock must be more than 0"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10,   | 2         |

    @TC_20
    Scenario Outline: User create product without guarantee
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 400 create product
      And validate response body code 400 and message "Bad Request"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10    |           |

    @TC_21
    Scenario Outline: User create product choose one guarantee
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 200 create product
      And validate response body code 200 and message "product created and file uploaded successfully"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10    | 2         |

    @TC_22
    Scenario Outline: User create product and upload Photo size >1MB
      Given I am success logged in as a user
      And I am set body request name "<name>" subcategory_id "<subcategory_id>" city_id "<city_id>" price "<price>" description "<description>" stock "<stock>" guarantee "<guarantee>"
      When I am hit endpoint create product
      Then I am get a status code 502 create product
      And validate response body code 502 and message "Must add description"
      Examples:
        | name             | subcategory_id | city_id | price | description    | stock | guarantee |
        | Habis Gelap Item | 311            | 3273    | 50000 | kepo banget lu | 10    | 2         |
      
