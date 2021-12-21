@Register
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
    And valid response Successful Operation
    Examples:
      | nama         | email                   | password | phone      |
      | Olla Ramlane | olla_ramlanen@gmail.com | P@ssw0rd | 0878998887 |

  @Register_2
  #TC_2
  Scenario Outline: Check status code and respond with empty name body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "name cannot be empty"
    Examples:
      | nama | email                    | password | phone           |
      |      | olla_ramlan70@alterra.id | ollam70  | 081221231287901 |

  @Register_3
  #TC_3
  Scenario Outline: Check status code and respond with only space on name body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "name cannot be empty"
    Examples:
      | nama | email                     | password | phone           |
      |      | olla_ramlan512@alterra.id | ollam70  | 081221231287902 |

  @Register_4
  #TC_3
  Scenario Outline: Check status code and respond with added Space on name
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "name cannot be empty"
    Examples:
      | nama       | email              | password | phone            |
      | m12 42 34n | ollasip@alterra.id | ollam70  | 0812212123122134 |

  @Register_5
  #TC_3
  Scenario Outline: Check status code and respond with email exixst body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 500
    And validate error message "Email or Phone Number is Exist"
    Examples:
      | nama    | email                  | password | phone           |
      | kuciang | olla_ramlan@alterra.id | ollam70  | 081221231287902 |

  @Register_6
  #TC_4
  Scenario Outline: Check status code and respond without "@" at email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "Email must contain email format"
    Examples:
      | nama    | email                 | password | phone           |
      | kupiang | olla_ramlanalterra.id | ollam70  | 081221231287903 |

  @Register_7
  #TC_5
  Scenario Outline: Check status code and respond without "." at email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "Email must contain email format"
    Examples:
      | nama    | email                 | password | phone           |
      | kupiang | olla_ramlan@alterraid | ollam70  | 081221231287904 |

  @Register_8
  Scenario Outline: Check status code and respond without "@" and "." at email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "Email must contain email format"
    Examples:
      | nama    | email                | password | phone           |
      | kupiang | olla_ramlanalterraid | ollam70  | 081221231287905 |

  @Register_9
  Scenario Outline: Check status code and respond with only space on Email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "email cannot be empty"
    Examples:
      | nama    | email | password | phone           |
      | kupiang |       | ollam70  | 081221231287907 |

  @Register_10
  Scenario Outline: Check status code and respond with added Space on Email
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "Email must contain email format"
    Examples:
      | nama    | email                  | password | phone           |
      | kupiang | olla ram lan@alterraid | ollam70  | 081221231287907 |

  @Register_11
  Scenario Outline: Check status code and respond with blank email body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "email cannot be empty"
    Examples:
      | nama    | email | password | phone           |
      | kupiang |       | ollam70  | 081221231287907 |

  @Register_12
  Scenario Outline: Check status code and respond with phone exist body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 500
    And validate error message "Email or Phone Number is Exist"
    Examples:
      | nama    | email                | password | phone           |
      | kupiang | kupingtau@alterra.id | ollam70  | 087890998877383 |

  @Register_13
  Scenario Outline: Check status code and respond with only space on phone body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "phone number cannot be empty"
    Examples:
      | nama    | email                | password | phone |
      | kupiang | kupingtau@alterra.id | ollam70  |       |

  @Register_14
  Scenario Outline: Check status code and respond with added Spaces on phone body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "phone number cannot be empty"
    Examples:
      | nama    | email                | password | phone              |
      | kupiang | kupinagsa@alterra.id | ollam70  | 08789 0998 87 7383 |

  @Register_15
  Scenario Outline: Check status code and respond with blank on phone body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "phone number cannot be empty"
    Examples:
      | nama    | email                | password | phone |
      | kupiang | kupinagsa@alterra.id | ollam70  |       |

  @Register_16
  Scenario Outline: Check status code and respond with using password less than 5 characters body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "password cannot less than 5 character"
    Examples:
      | nama    | email                | password | phone        |
      | kupiang | kupinagsa@alterra.id | olla     | 081921213131 |

  @Register_17
  Scenario Outline: Check status code and respond with only space on password body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "password cannot be empty"
    Examples:
      | nama    | email                | password | phone        |
      | kupiang | kupinagsa@alterra.id |          | 081921213131 |

  @Register_18
  Scenario Outline: Check status code and respond with added space on password body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "password cannot be empty"
    Examples:
      | nama    | email                | password  | phone        |
      | kupiang | kupinagsa@alterra.id | oll am 70 | 081921213131 |

  @Register_19
  Scenario Outline: Check status code and respond with blank password body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "password cannot be empty"
    Examples:
      | nama    | email                | password | phone        |
      | kupiang | kupinagsa@alterra.id |          | 081921213131 |

  @Register_20
  Scenario Outline: Check status code and respond with space on all data body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "name cannot be empty"
    Examples:
      | nama       | email                  | password  | phone            |
      | k up ia ng | ku pin agsa@alterra.id | oll am 70 | 081 9212 131  31 |

  @Register_21
  Scenario Outline: Check status code and respond with blank on all data body request
    Given I am set body request for register name "<nama>" email "<email>" password "<password>" phone "<phone>"
    And I am set header for register "Content-Type" with fill "application/json"
    When I am hit endpoint register
    Then I am get status code 400
    And validate error message "Bad Request"
    Examples:
      | nama | email | password | phone |
      |      |       |          |       |