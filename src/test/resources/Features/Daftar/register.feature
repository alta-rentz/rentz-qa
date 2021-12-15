Feature: Register Function
  As a user
  I want to be able to Register
  So That I succeeded Register

  @Register_1
  #TC_1
  Scenario Outline: Check status code and response with valid body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 200
    And valid response success register
    Examples:
      | nama         | email                   | password | phone            |
      | Olla Ramlans | olla_ramlans@alterra.id | P@ssw0rd | 0878909988773812 |

  @Register_2
  #TC_2
  Scenario Outline: Check status code and respond with empty name body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message nama tidak boleh kosong
    Examples:
      | nama | email                    | password | phone           |
      |      | olla_ramlan70@alterra.id | ollam70  | 081221231287901 |

  @Register_3
  #TC_3
  Scenario Outline: Check status code and respond with email exixst body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 500
    And validate error message Email or Phone Number is Exist
    Examples:
      | nama    | email                  | password | phone           |
      | kuciang | olla_ramlan@alterra.id | ollam70  | 081221231287902 |

  @Register_4
  #TC_4
  Scenario Outline: Check status code and respond without "@" at email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message Email must contain email format
    Examples:
      | nama    | email                 | password | phone           |
      | kupiang | olla_ramlanalterra.id | ollam70  | 081221231287903 |

  @Register_5
  #TC_5
  Scenario Outline: Check status code and respond without "." at email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message Email must contain email format
    Examples:
      | nama    | email                 | password | phone           |
      | kupiang | olla_ramlan@alterraid | ollam70  | 081221231287904 |

  @Register_6
  Scenario Outline: Check status code and respond without "@" and "." at email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message Email must contain email format
    Examples:
      | nama    | email                | password | phone           |
      | kupiang | olla_ramlanalterraid | ollam70  | 081221231287905 |

  @Register_7
  Scenario Outline: Check status code and respond with blank email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message Email must contain email format
    Examples:
      | nama    | email | password | phone           |
      | kupiang |       | ollam70  | 081221231287907 |

  @Register_8
  Scenario Outline: Check status code and respond with phone exist body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 500
    And validate error message Email must contain email format
    Examples:
      | nama    | email                | password | phone           |
      | kupiang | kupingtau@alterra.id | ollam70  | 087890998877383 |

  @Register_9
  Scenario Outline: Check status code and respond with blank phone body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message Phone Number cannot be empty
    Examples:
      | nama    | email                | password | phone |
      | kupiang | kupinagsa@alterra.id | ollam70  |       |

  @Register_10
  Scenario Outline: Check status code and respond with using password less than 5 characters body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message password cannot less than 5 character
    Examples:
      | nama    | email                | password | phone        |
      | kupiang | kupinagsa@alterra.id | olla     | 081921213131 |

  @Register_11
  Scenario Outline: Check status code and respond with blank password body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message password cannot be empty
    Examples:
      | nama    | email                | password | phone        |
      | kupiang | kupinagsa@alterra.id |          | 081921213131 |

  @Register_12
  Scenario Outline: Check status code and respond with all blank body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message password cannot less than 5 character
    Examples:
      | nama | email | password | phone |
      |      |       |          |       |
