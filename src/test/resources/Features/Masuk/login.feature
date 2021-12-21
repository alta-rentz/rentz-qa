@Login
Feature: Login Function
  As a user
  I wan to be able to login
  so that I success login

 #Success #TC_1
  @LoginSukses
  Scenario Outline: Check status code and response with valid body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 200
    And valid response success
    Examples:
      | email           | password   |
      | aldi@alterra.id | P@ssw0rd!@ |

  @LoginFailed #Failed #TC_2
  Scenario Outline: Check status code and response with invalid email and valid password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                      | password |
      | olla_smilikitty@alterra.id | P@ssw0rd |

  @LoginFailed_1 #Failed #TC_3
  Scenario Outline: Check status code and response with valid email and invalid password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                  | password  |
      | olla_ramlan@alterra.id | injang123 |

  @LoginFailed_2 #Failed #TC_4
  Scenario Outline: Check status code and response with invalid email and password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                      | password  |
      | olla_smilikitty@alterra.id | injang123 |

  @LoginFailed_3 #Failed #TC_5
  Scenario Outline: Check status code and response without "@" at email body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                 | password |
      | olla_ramlanalterra.id | P@ssw0rd |

  @LoginFailed_4 #Failed #TC_6
  Scenario Outline: Check status code and response without "." at email body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                 | password |
      | olla_ramlan@alterraid | P@ssw0rd |

  @LoginFailed_5 #Failed #TC_7
  Scenario Outline: Check status code and respond without "@" and "." at email body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                | password |
      | olla_ramlanalterraid | P@ssw0rd |

  @LoginFailed_6 #Failed #TC_8
  Scenario Outline: Check status code and respond with only space on email body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email | password |
      |       | P@ssw0rd |

  @LoginFailed_7 #Failed #TC_9
  Scenario Outline: Check status code and respond with added space email body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                     | password |
      | olla_ r aml an@alterra.id | P@ssw0rd |

  @LoginFailed_8 #Failed #TC_10
  Scenario Outline: Check status code and respond with blank email and password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email | password |
      |       |          |

  @LoginFailed_9 #Failed #TC_11
  Scenario Outline: Check status code and respond with blank email and valid password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email | password |
      |       | P@ssw0rd |

  @LoginFailed_10 #Failed #TC_12
  Scenario Outline: Check status code and respond with valid email and blank password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                 | password |
      | olla_ramlan@alterraid |          |

  @LoginFailed_11 #Failed #TC_13
  Scenario Outline: Check status code and respond with blank email and invalid password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email | password  |
      |       | injang123 |

  @LoginFailed_12 #Failed #TC_14
  Scenario Outline: Check status code and respond with invalid email and blank password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                      | password |
      | olla_smilikitty@alterra.id |          |

  @LoginFailed_13 #Failed #TC_15
  Scenario Outline: Check status code and respond with only space on password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                  | password |
      | olla_ramlan@alterra.id |          |

  @LoginFailed_14 #Failed #TC_16
  Scenario Outline: Check status code and respond with added space on password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                  | password    |
      | olla_ramlan@alterra.id | P @s sw 0rd |

  @LoginFailed_15 #Failed #TC_17
  Scenario Outline: Check status code and respond with added space on password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email                      | password    |
      | olla _ ram lan @alterra.id | P @s sw 0rd |

  @LoginFailed_16 #Failed #TC_18
  Scenario Outline: Check status code and respond with added space on password body request
    Given I am set body request email "<email>" and password "<password>"
    And I am set valid header "Content-Type" with fill "application/json"
    When I am hit endpoint login
    Then I am get a status code 400
    And Validate failed response body 400 and message "Email or Password Invalid"
    Examples:
      | email | password |
      |       |          |